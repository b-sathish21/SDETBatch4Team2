package mandatoryHomeWork.selenium;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MakeMyTrip_ValidatePriceForReturnTrip {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("start-maximized");

		ChromeDriver dr = new ChromeDriver(opt);
		Actions act = new Actions(dr);
		
		dr.get("https://www.makemytrip.com/flights/");
		WebDriverWait wait = new WebDriverWait(dr, Duration.ofSeconds(30));
		/*---------------------------------------------------------------*/
		
		//close login/ sign-up form pop-up
		act.sendKeys(Keys.ESCAPE).build().perform();
		dr.navigate().refresh();
		
		//click on round trip
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@data-cy='roundTrip']//span"))).click();
		
		//click on from city and choose chennai
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("fromCity"))).click();
		Thread.sleep(1500);
		act.sendKeys("chennai").build().perform();
		Thread.sleep(1500);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".react-autosuggest__suggestion.react-autosuggest__suggestion--first"))).click();
		
		//click on To city
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("toCity"))).click();
		Thread.sleep(1500);
		act.sendKeys("coim").build().perform();
		Thread.sleep(1500);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".react-autosuggest__suggestion.react-autosuggest__suggestion--first"))).click();
		
		//click on depature date
		try {
			String depDate = "(//div[@class='DayPicker-Body']//div[@class='DayPicker-Week'][2]//div[@class='DayPicker-Day'])[2]";
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(depDate))).click();
		}
		catch (Exception e) {
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.dates #departure"))).click();
			String depDate = "(//div[@class='DayPicker-Body']//div[@class='DayPicker-Week'][2]//div[@class='DayPicker-Day'])[2]";
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(depDate))).click();
		}
		
		//click on Return date
		String retDate = "(//div[@class='DayPicker-Body']//div[@class='DayPicker-Week'][2]//div[@class='DayPicker-Day'])[4]";
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(retDate))).click();
		
		//click on the search button
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.widgetSearchBtn"))).click();
		
		//close the pop-up
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".commonOverlay button.button"))).click();
		
		//click on view all if present		
		Thread.sleep(500);
		((JavascriptExecutor) dr).executeScript("arguments[0].scrollIntoView(true);", 
				dr.findElement((By.xpath("(//button[@class='button actionBtn '])[1]"))));
		Thread.sleep(500);
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class = 'button actionBtn '])[1]"))).click();
			
		
		//get the prices for departure
		int max=0, price=0;
		WebElement finalPrice = null;
		List<WebElement> depFlightRates = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".paneView:nth-child(1)  .priceInfo p.blackText")));
		for(WebElement rate : depFlightRates) {
			String rat = rate.getText();
			String[] rt = rat.split(" ");
			String[] finlRate = rt[1].split("per");
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<finlRate[0].length(); i++) if(finlRate[0].charAt(i)>47 && finlRate[0].charAt(i)<58) sb.append(finlRate[0].charAt(i));
			price = Integer.parseInt(sb.toString());
			System.out.println("--"+price+"--" + "==> " + finlRate[0]);
			if(price >= max) {
				max = price; 
				finalPrice = rate;
			}
		}
		System.out.println("Max Price for the depature flight is " + price);Thread.sleep(500);
		((JavascriptExecutor) dr).executeScript("arguments[0].scrollIntoView(true);", finalPrice);
		Thread.sleep(500);
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
		act.moveToElement(finalPrice, 0, 10).click().build().perform();
		

		//click on view all if present
		act.sendKeys(Keys.HOME).build().perform();
		Thread.sleep(500);
		act.moveToElement(dr.findElement(By.xpath("(//button[@class = 'button actionBtn '])[1]")), 0, 10).click().build().perform();
			
		
		//get the prices for return
		int maxrn=0, pricern=0;
		WebElement finalPricern = null;
		List<WebElement> depFlightRatesrn = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".paneView:nth-child(2)  .priceInfo p.blackText")));
		for(WebElement rate : depFlightRatesrn) {
			String rat = rate.getText();
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<rat.length(); i++) if(rat.charAt(i)>47 && rat.charAt(i)<58) sb.append(rat.charAt(i));
			pricern = Integer.parseInt(sb.toString());
			System.out.println("--"+pricern+"--" + "==> " + rat);
			if(pricern >= maxrn) {
				maxrn = pricern; 
				finalPricern = rate;
			}
		}
		System.out.println("Max Price for the Return flight is " + maxrn);
		Thread.sleep(500);
		act.scrollToElement(finalPricern).scrollByAmount(0, 250).build().perform();
		Thread.sleep(500);
		act.moveToElement(finalPricern, 0, 0).click().build().perform();
		
		int totalPrice = max + maxrn;
		
		//click on book now button
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".splitFooterButton"))).click();

		//click on continue button
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".lato-black"))).click();

		//handle window
		ArrayList<String> tabs = new ArrayList<String> (dr.getWindowHandles());
	    dr.switchTo().window(tabs.get(1));
	    Thread.sleep(1000);
	    
	    //remove charity amount
	    try {
	    	wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".charityAddTxt"))).click();
	    }
	    catch (Exception e) {
			// TODO: handle exception
		}
		
		
		//get fare
	    String faree = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".fareFooter span:nth-child(2)"))).getText();
		String[] fre = faree.split(" ");
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<fre[1].length(); i++) if(fre[1].charAt(i)>47 && fre[1].charAt(i)<58) sb.append(fre[1].charAt(i));
		price = Integer.parseInt(sb.toString());
		
		//validate the fares
		System.out.println(totalPrice + " == " + price);
		if(totalPrice==price) System.out.println("Bill Price is matched");
		
		//close the browser
		System.out.println("completed");
		Thread.sleep(2500);
		dr.close();
		Thread.sleep(2500);
		dr.quit();
	}

}
