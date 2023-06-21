package mandatoryHomeWork.selenium;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Nykaa_ProductChooseOnFilterAndValidatePrice {
	
	//Locators
	public static By brand_top_ribon_droperMenu = By.xpath("//div[@id = 'brand_arrowUp']//parent::li/a");
	public static By brand_SrchBox = By.cssSelector(".brandSearchMain #brandSearchBox");
	public static By l_oreal_paris_product_at_menu = By.xpath("//div[@id = 'list_L']//following::a[contains(text(), 'Oreal Paris')][1]");
	public static By srtBy_drpdwn = By.className("sort-name");
	public static By cstmrTopRtd_option = By.xpath("//span[text() = 'customer top rated']//parent::div/following-sibling::div");
	public static By ctgry_fltr_drpdwn = By.xpath("//span[text() = 'Category']");
	public static By hair_sbCtgry_fltr_drpdwn = By.xpath("//span[text() = 'Hair']");
	public static By harcare_sb_sbctgry_fltr_drpdwn = By.xpath("//ul[@id = 'custom-scroll']//span[text() = 'Hair Care']");
	public static By shampoo_option = By.xpath("//span[text() = 'Shampoo']");
	public static By cncrn_fltr_drpdwn = By.xpath("//span[text() = 'Concern']");
	public static By clrPtrctn_option = By.xpath("//span[text() = 'Color Protection']");
	public static By fltr_sction_chck = By.xpath("//span[@class = 'name']//parent::div/following-sibling::div//span[text() = 'Color Protection']");
	public static By choose_prdct = By.cssSelector("#product-list-wrap .css-xrzmfa");
	public static By page_Title = By.tagName("title");
	public static By ml180_sz_option = By.xpath("//span[text() = '180ml']");
	public static By get_MRP_txt = By.xpath("(//span[text() = 'MRP:']/following-sibling::span)[1]");
	public static By add_to_bag_btn = By.xpath("(//span[text() = 'Add to Bag'])[1]");
	public static By go_to_Cart_btn = By.xpath("//button[@class='css-aesrxy']");
	public static By grndTotl_txt = By.xpath("(//div[contains(@class, 'footer-layout')]//span)[1]");
	public static By prcd_btn = By.xpath("//span[text() = 'Proceed']");
	public static By cntnAsGust_btn = By.xpath("//button[text() = 'Continue as guest']");
	public static By nwAdrsCls_btn = By.xpath("//p[text() = 'New Address']//parent::div/preceding-sibling::div/span");
	public static By pricDetails_btn = By.xpath("//p[text() = 'Price Details']//parent::div/following-sibling::p");
	
	
	
	public static void clckEle(WebDriverWait wait, Actions act, WebDriver driver, By locator) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
		}
		catch (Exception e) {
			try {
				act.click(driver.findElement(locator)).build().perform();
			}
			catch (Exception ex) {
				act.moveToElement(driver.findElement(locator), 10, 20).click(driver.findElement(locator)).build().perform();
			}		
		}
	}
	
	public static void mseHvrEle(WebDriverWait wait, Actions act, WebDriver driver, By locator) {
		act.moveToElement(driver.findElement(locator)).build().perform();
	}
	
	public static void sndTxt2Ele(WebDriverWait wait, Actions act, WebDriver driver, By locator, String input) throws InterruptedException {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
			Thread.sleep(2000);
			act.sendKeys(Keys.END).perform();
			act.sendKeys(Keys.LEFT_SHIFT, Keys.HOME, Keys.BACK_SPACE).perform();
			act.sendKeys(input).build().perform();
		}
		catch (Exception e) {
			act.click(driver.findElement(locator)).build().perform();
			Thread.sleep(2000);
			act.sendKeys(Keys.END).perform();
			act.sendKeys(Keys.LEFT_SHIFT, Keys.HOME, Keys.BACK_SPACE).perform();
			act.sendKeys(input).build().perform();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("start-maximized");

		ChromeDriver dr = new ChromeDriver(opt);
		Actions act = new Actions(dr);
		
		//Launch URL http://leaftaps.com/opentaps/control/login
		dr.get("https://www.nykaa.com/");
		WebDriverWait wait = new WebDriverWait(dr, Duration.ofSeconds(30));
		/*---------------------------------------------------------------*/
//		2. Mouseover on Brands and Search L'Oreal Paris
		mseHvrEle(wait, act, dr, brand_top_ribon_droperMenu);
		clckEle(wait, act, dr, brand_SrchBox);
		sndTxt2Ele(wait, act, dr, brand_SrchBox, "L'Oreal Paris");
		
//		3. Click L'Oreal Paris
		clckEle(wait, act, dr, l_oreal_paris_product_at_menu);
		
//		4. Check the title contains L'Oreal Paris
		String title = dr.getTitle();
		assertTrue(title.contains("L'Oreal Paris"), "page title is not matching");
		
//		5. Click sort By and select customer top rated
		clckEle(wait, act, dr, srtBy_drpdwn);
		clckEle(wait, act, dr, cstmrTopRtd_option);
		
//		6. Click Category and click Hair->Click haircare->Shampoo
		clckEle(wait, act, dr, ctgry_fltr_drpdwn);
		clckEle(wait, act, dr, hair_sbCtgry_fltr_drpdwn);
		clckEle(wait, act, dr, harcare_sb_sbctgry_fltr_drpdwn);
		clckEle(wait, act, dr, shampoo_option);
		
//		7. Click->Concern->Color Protection
		clckEle(wait, act, dr, cncrn_fltr_drpdwn);
		clckEle(wait, act, dr, clrPtrctn_option);
		
//		8.check whether the Filter is applied with Shampoo
		String check = wait.until(ExpectedConditions.presenceOfElementLocated(fltr_sction_chck)).getText();
		assertTrue(check.contains("Color Protection"), "Filter is not applied");
		
//		9. Click on L'Oreal Paris Colour Protect Shampoo
		clckEle(wait, act, dr, choose_prdct);
		
//		10. GO to the new window and select size as 175ml
		//handle window
		ArrayList<String> tabs = new ArrayList<String> (dr.getWindowHandles());
	    dr.switchTo().window(tabs.get(1));
	    Thread.sleep(500);
	    
	    clckEle(wait, act, dr, ml180_sz_option);
	    String mrp = wait.until(ExpectedConditions.visibilityOfElementLocated(get_MRP_txt)).getText();
		
//		11. Print the MRP of the product
	    System.out.println("The price for 180 ml shampoo is " + mrp);
	    
//		12. Click on ADD to BAG
	    clckEle(wait, act, dr, add_to_bag_btn);
	    
//		13. Go to Shopping Bag
	    clckEle(wait, act, dr, go_to_Cart_btn);
	    
//		14. Print the Grand Total amount
	    Thread.sleep(500);
	    dr.switchTo().frame(0);
	    String gTotal = wait.until(ExpectedConditions.presenceOfElementLocated(grndTotl_txt)).getText();
	    System.out.println("The grand total of the bill is " + gTotal);
	    
//		15. Click Proceed
	    clckEle(wait, act, dr, prcd_btn);
	    dr.switchTo().defaultContent();
	    
//		16. Click on Continue as Guest
	    clckEle(wait, act, dr, cntnAsGust_btn);
	    clckEle(wait, act, dr, nwAdrsCls_btn);
	    
//		17. Check if this grand total is the same in step 14
	    String priceDetails = wait.until(ExpectedConditions.presenceOfElementLocated(pricDetails_btn)).getText();
	    System.out.println("The final price details of the bill is " + priceDetails);
	    assertTrue(priceDetails.equals(gTotal), "Price dosn't match");
		
		//Quit the browser.
		dr.quit();		
	}

}
