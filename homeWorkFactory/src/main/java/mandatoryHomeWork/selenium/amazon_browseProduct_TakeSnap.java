package mandatoryHomeWork.selenium;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class amazon_browseProduct_TakeSnap {
	
	//Locators
	public static By search_txt_bx = By.id("twotabsearchtextbox");
	public static By listFrstOption_SrchList = By.cssSelector(".left-pane-results-container >div:nth-child(1)");
	public static By srchRslt_cntainr = By.cssSelector(".rush-component.s-latency-cf-section");
	public static By srchRsltFstCrd_price_txt = By.xpath("(//span[@class = 'a-price-whole'])[1]");
	public static By srchRsltFstCrd_cstmrRting_txt = By.xpath("(//span[@class = 'a-size-base s-underline-text'])[1]");
	public static By srchRsltFstCrd_img = By.xpath("(//div[contains(@class, 's-product-image-container')]//img)[1]");
	public static By prdctImgmainPage = By.cssSelector("#main-video-container");
	public static By prdctImgPOPUP = By.cssSelector("#ivLargeImage img");
	public static By prdctImgPOPUP_close_btn = By.cssSelector(".a-icon-close");
	public static By addToCart_btn = By.id("add-to-cart-button");
	public static By sbTotl_inCrt_txt = By.id("attach-accessory-cart-subtotal");
	
	//Common actions
	public static void clckEle(WebDriverWait wait, Actions act, WebDriver driver, By locator) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
		}
		catch (Exception e) {
			act.click(driver.findElement(locator)).build().perform();
		}
	}
	
	public static void clrEle(WebDriverWait wait, Actions act, WebDriver driver, By locator) throws InterruptedException {
		Thread.sleep(500);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(locator)).clear();
		}
		catch (Exception e) {
			act.sendKeys(Keys.END).perform();
			act.sendKeys(Keys.LEFT_SHIFT, Keys.HOME, Keys.BACK_SPACE).perform();
		}		
	}
	
	public static void sndTxt2Ele(WebDriverWait wait, Actions act, WebDriver driver, By locator, String input) throws InterruptedException {
		try{
			wait.until(ExpectedConditions.elementToBeClickable(locator)).sendKeys(input);;
		}
		catch (Exception e) {
			// TODO: handle exception
			act.sendKeys(input).build().perform();
		}
	}

	//script
	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("start-maximized");

		ChromeDriver dr = new ChromeDriver(opt);
		Actions act = new Actions(dr);
		
		//Launch URL https://www.amazon.in/
		dr.get("https://www.amazon.in/");
		WebDriverWait wait = new WebDriverWait(dr, Duration.ofSeconds(30));
		/*---------------------------------------------------------------*/
		
		//search as oneplus 9 pro
		clckEle(wait, act, dr, search_txt_bx);
		clrEle(wait, act, dr, search_txt_bx);
		sndTxt2Ele(wait, act, dr, search_txt_bx, "OnePlus 9 Pro");
		Thread.sleep(500);
		
		clckEle(wait, act, dr, listFrstOption_SrchList);
		
		//Get the price of the first product
		String Price = wait.until(ExpectedConditions.elementToBeClickable(srchRsltFstCrd_price_txt)).getText();
		Price = "₹"+Price+".00";
		
		//Print the number of customer ratings for the first displayed product
		System.out.println("the customer rating for the product is " 
		+ wait.until(ExpectedConditions.elementToBeClickable(srchRsltFstCrd_cstmrRting_txt)).getText());
		
		//Click the first text link of the first image
		clckEle(wait, act, dr, srchRsltFstCrd_img);
		//handle window
		ArrayList<String> tabs = new ArrayList<String> (dr.getWindowHandles());
	    dr.switchTo().window(tabs.get(1));
	    Thread.sleep(500);
		
		//Take a screen shot of the product displayed
		clckEle(wait, act, dr, prdctImgmainPage);
		Thread.sleep(500);
		WebElement prdctImage = wait.until(ExpectedConditions.elementToBeClickable(prdctImgPOPUP));
		Thread.sleep(500);
		File img = prdctImage.getScreenshotAs(OutputType.FILE);
		Thread.sleep(500);
		FileUtils.copyFile(img, new File("./productImage.jpeg"));
		Thread.sleep(500);
		clckEle(wait, act, dr, prdctImgPOPUP_close_btn);
		
		//Click 'Add to Cart' button
		clckEle(wait, act, dr, addToCart_btn);
		
		//Get the cart subtotal and verify if it is correct.
		String subTotal = wait.until(ExpectedConditions.visibilityOfElementLocated(sbTotl_inCrt_txt)).getText();
		assertTrue(subTotal.equals(Price), "price (" + Price + ") is not equals to Sub Total (" + subTotal + ").");
		System.out.println("price (" + Price + ") is equals to Sub Total (" + subTotal + ").");
		
		//Quit the browser.
		dr.close();
		try {
			dr.quit();			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Browser is fully closed already,..!!!");
		}		
	}

}
