package mandatoryHomeWork.selenium;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JIRA_CreateTask_CreateBUG {
		//Data
		public static String[] issue_Type = {"Story", "Task", "Bug", "Epic"};
		public static String[] assignee = {"Sathish", "Devi", "Hema", "Karupa", "Krishna"};
		public static Date date;
		
		// Login Locators
		public static By userName_txt = By.id("username");
		public static By cntinue_btn = By.cssSelector("#login-submit>span>span");
		public static By password_txt = By.id("password");
		public static By login_btn = By.xpath("//span[text() = 'Log in']");
		public static By prjctMenuDrpDwn = By.xpath("//span[text() = 'Projects']");
		public static By viewAllPrjctOpt = By.xpath("//span[text() = 'View all projects']");
		public static By srchPrjctTxt = By.id("keyword");
		public static By srchClearBtn = By.xpath("//span[@aria-label = 'Clear']");
		public static By srchErrorMessage = By.tagName("h4");
		public static By OpenProject = By.xpath("//span[text() = 'compare_Check']");
		public static By todoBoard = By.xpath("(//div[text() = 'To Do']//following::div[contains(@data-testid, 'software-board')])[1]");
		public static By listOfTickets = By.cssSelector(".fKpSAB");
		public static By isue_create_btn = By.xpath("//span[text() = 'Create']");
		public static By issue_typ_drpdwn = By.xpath("//div[contains(@id, 'issue-type-select')]");
		public static By sumry_txt = By.cssSelector("#summary-field");
		public static By desc_txt = By.cssSelector(".ak-editor-content-area p");
		public static By assignee_txt_drpdwn = By.cssSelector("#assignee-field-label+div div.fabric-user-picker__single-value");
		public static By sprintDrpDwn = By.xpath("//div[text() = 'Select sprint']");
		public static By ftr_Create_btn = By.xpath("//div[contains(@data-testid , 'modal--footer')]//span[text() = 'Create']");
		public static By sucs_Flg_Notifction = By.xpath("//div[@data-testid = 'jira-issue-create.modal.create-form.success-flag']");
		public static By sucs_Flg_Notifction_text = By.xpath("//span[contains(text(), 've created')]");
		public static By slctTckID = By.xpath("//div[text() = 'Select Issue']");
		public static By srchTicket = By.xpath("//input[@name='search']");
		public static String opnTicktFrmBrd = "//span[text() = '-']";
		
		public static String rndmInptData(String[] arr) {
			Random random = new Random();
			int i = random.nextInt(arr.length);
			return arr[i];
		}

		public static void main(String[] args) throws InterruptedException {
			// Login to JIRA in incognito
			ChromeOptions opt = new ChromeOptions();
			opt.addArguments("incognito");
			opt.addArguments("start-maximized");
			
			
			//System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver_113.exe");
			ChromeDriver dr = new ChromeDriver(opt);
			Actions act = new Actions(dr);
			
			dr.get("https://comparecheck.atlassian.net/");
			WebDriverWait wait = new WebDriverWait(dr, Duration.ofSeconds(30));
			
			//Enter User Name
			WebElement usrNm = wait.until(ExpectedConditions.elementToBeClickable(userName_txt));
			usrNm.click();
			usrNm.clear();
			usrNm.sendKeys("b.sathish21@gmail.com");
			
			//Click on Continue button
			wait.until(ExpectedConditions.elementToBeClickable(cntinue_btn)).click();
			
			//Enter Password
			WebElement pswd = wait.until(ExpectedConditions.elementToBeClickable(password_txt));
			pswd.click();
			pswd.clear();
			pswd.sendKeys("Jithisha@01");
			
			//Click on the Log-In button
			wait.until(ExpectedConditions.elementToBeClickable(login_btn)).click();
			
			//Navigate to projects page
			wait.until(ExpectedConditions.elementToBeClickable(prjctMenuDrpDwn)).click();
			wait.until(ExpectedConditions.elementToBeClickable(viewAllPrjctOpt)).click();
			WebElement srchPrjct = wait.until(ExpectedConditions.elementToBeClickable(srchPrjctTxt));
			srchPrjct.click();
			srchPrjct.clear();
			srchPrjct.sendKeys("test");
			WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(srchErrorMessage));
			assertTrue(notification.isDisplayed(), "Project Available");
			
			//open the project
			wait.until(ExpectedConditions.elementToBeClickable(srchClearBtn)).click();
			srchPrjct.click();
			srchPrjct.clear();
			srchPrjct.sendKeys("compare_Check");
			wait.until(ExpectedConditions.elementToBeClickable(OpenProject)).click();
			
			//get the list of tickets in the boards
			wait.until(ExpectedConditions.visibilityOfElementLocated(listOfTickets));
			List<WebElement> lstOfTickets = dr.findElements(listOfTickets);
		    System.out.println("Number of Tickets:" + lstOfTickets.size());
		    for(WebElement k : lstOfTickets) {
		    	System.out.println(k.getText());
		    }
			
		    //open an new tab
			act.sendKeys(Keys.LEFT_CONTROL + "t").perform();
			dr.findElement(By.cssSelector("body")).sendKeys(Keys.LEFT_CONTROL + "t");
			ArrayList<String> tabs = new ArrayList<String> (dr.getWindowHandles());
			dr.switchTo().window(tabs.get(0));
		    dr.navigate().to("https://comparecheck.atlassian.net/");
	
			//Click on Create button
			wait.until(ExpectedConditions.elementToBeClickable(isue_create_btn)).click();
			
			//choose Issue Type
			WebElement issueTypeDrpDwn = wait.until(ExpectedConditions.elementToBeClickable(issue_typ_drpdwn));
			issueTypeDrpDwn.click();
			act.sendKeys("Task").sendKeys(Keys.ENTER).perform();
			
			//Enter Summary
			WebElement summaryText = wait.until(ExpectedConditions.elementToBeClickable(sumry_txt));
			summaryText.click();
			summaryText.clear();
			date = new Date();
			summaryText.sendKeys("New Summary created - " + date.getTime());
	
			//Enter Description
			WebElement descText = wait.until(ExpectedConditions.elementToBeClickable(desc_txt));
			descText.click();
			descText.clear();
			date = new Date();
			descText.sendKeys("New Description created - " + date.getTime());
			
			//choose Assignee
			WebElement assigneeDrpDwnTxt = wait.until(ExpectedConditions.elementToBeClickable(assignee_txt_drpdwn));
			assigneeDrpDwnTxt.click();
			act.sendKeys(rndmInptData(assignee)).perform();
			Thread.sleep(1000);//Time needed to populate the result
			act.sendKeys(Keys.ENTER).perform();
			
			//Assign Sprint
			wait.until(ExpectedConditions.elementToBeClickable(sprintDrpDwn)).click();
			act.sendKeys("CC Sprint 1").perform();
			Thread.sleep(1000);//Time needed to populate the result
			act.sendKeys(Keys.ENTER).perform();
	
			//Click on Create button
			wait.until(ExpectedConditions.elementToBeClickable(ftr_Create_btn)).click();
			
			//assert Notification of successful ticket creation
			WebElement notfication = wait.until(ExpectedConditions.visibilityOfElementLocated(sucs_Flg_Notifction));
			assertTrue(notfication.isDisplayed(), "Ticket is not created/ notification not arrived");
			String ticket = wait.until(ExpectedConditions.visibilityOfElementLocated(sucs_Flg_Notifction_text)).getText();
			String[] tckt = ticket.split("\"");
			String ticketID = tckt[1];
			System.out.println("Task Ticket ID is " + ticketID);
			
			//refresh the browser
			//dr.switchTo().defaultContent();
			dr.navigate().refresh();
			
			//Navigate to projects page
			wait.until(ExpectedConditions.elementToBeClickable(prjctMenuDrpDwn)).click();
			wait.until(ExpectedConditions.elementToBeClickable(viewAllPrjctOpt)).click();
			srchPrjct = wait.until(ExpectedConditions.elementToBeClickable(srchPrjctTxt));
			srchPrjct.click();
			srchPrjct.clear();
			srchPrjct.sendKeys("test");
			notification = wait.until(ExpectedConditions.visibilityOfElementLocated(srchErrorMessage));
			assertTrue(notification.isDisplayed(), "Project Available");
			
			//open the project
			wait.until(ExpectedConditions.elementToBeClickable(srchClearBtn)).click();
			srchPrjct.click();
			srchPrjct.clear();
			srchPrjct.sendKeys("compare_Check");
			wait.until(ExpectedConditions.elementToBeClickable(OpenProject)).click();
			Thread.sleep(5000);
			dr.navigate().refresh();
			
			//get the list of tickets in the boards and verify the created ticket availability
			wait.until(ExpectedConditions.visibilityOfElementLocated(listOfTickets));
			lstOfTickets = dr.findElements(listOfTickets);
		    System.out.println("Number of Tickets:" + lstOfTickets.size());
		    boolean f = false;
		    for(WebElement k : lstOfTickets) {
		    	String check = k.getText();
		    	System.out.println(check);
		    	if(check == ticketID) f = true;
		    }
		    
		    //Create a bug with blocked by newly created issue
		    //Click on Create button
			wait.until(ExpectedConditions.elementToBeClickable(isue_create_btn)).click();
			
			//choose Issue Type
			issueTypeDrpDwn = wait.until(ExpectedConditions.elementToBeClickable(issue_typ_drpdwn));
			issueTypeDrpDwn.click();
			act.sendKeys("Bug").sendKeys(Keys.ENTER).perform();
			
			//Enter Summary
			summaryText = wait.until(ExpectedConditions.elementToBeClickable(sumry_txt));
			summaryText.click();
			summaryText.clear();
			date = new Date();
			summaryText.sendKeys("New Summary created - " + date.getTime());
	
			//Enter Description
			descText = wait.until(ExpectedConditions.elementToBeClickable(desc_txt));
			descText.click();
			descText.clear();
			date = new Date();
			descText.sendKeys("New Description created - " + date.getTime());
			
			//choose Assignee
			assigneeDrpDwnTxt = wait.until(ExpectedConditions.elementToBeClickable(assignee_txt_drpdwn));
			assigneeDrpDwnTxt.click();
			act.sendKeys(rndmInptData(assignee)).perform();
			Thread.sleep(1000);//Time needed to populate the result
			act.sendKeys(Keys.ENTER).perform();
			
			//Assign Sprint
			wait.until(ExpectedConditions.elementToBeClickable(sprintDrpDwn)).click();
			act.sendKeys("CC Sprint 1").perform();
			Thread.sleep(1000);//Time needed to populate the result
			act.sendKeys(Keys.ENTER).perform();
			
			//Linked Issues
			wait.until(ExpectedConditions.elementToBeClickable(slctTckID)).click();
			act.sendKeys(ticketID).perform();
			Thread.sleep(1000);//Time needed to populate the result
			act.sendKeys(Keys.ENTER).perform();
	
			//Click on Create button
			wait.until(ExpectedConditions.elementToBeClickable(ftr_Create_btn)).click();
			
			//assert Notification of successful ticket creation
			notfication = wait.until(ExpectedConditions.visibilityOfElementLocated(sucs_Flg_Notifction));
			assertTrue(notfication.isDisplayed(), "Ticket is not created/ notification not arrived");
			String bugTicket = wait.until(ExpectedConditions.visibilityOfElementLocated(sucs_Flg_Notifction_text)).getText();
			String[] bugTckt = bugTicket.split("\"");
			String bugID = bugTckt[1];
			System.out.println("Bug ID is " + bugID);
			
			//refresh the browser
			//dr.switchTo().defaultContent();
			dr.navigate().refresh();
			
			//Navigate to projects page
			wait.until(ExpectedConditions.elementToBeClickable(prjctMenuDrpDwn)).click();
			wait.until(ExpectedConditions.elementToBeClickable(viewAllPrjctOpt)).click();
			srchPrjct = wait.until(ExpectedConditions.elementToBeClickable(srchPrjctTxt));
			srchPrjct.click();
			srchPrjct.clear();
			srchPrjct.sendKeys("test");
			notification = wait.until(ExpectedConditions.visibilityOfElementLocated(srchErrorMessage));
			assertTrue(notification.isDisplayed(), "Project Available");
			
			//open the project
			wait.until(ExpectedConditions.elementToBeClickable(srchClearBtn)).click();
			srchPrjct.click();
			srchPrjct.clear();
			srchPrjct.sendKeys("compare_Check");
			wait.until(ExpectedConditions.elementToBeClickable(OpenProject)).click();
			Thread.sleep(5000);
			dr.navigate().refresh();
			
			//get the list of tickets in the boards and verify the created ticket availability
			wait.until(ExpectedConditions.visibilityOfElementLocated(listOfTickets));
			lstOfTickets = dr.findElements(listOfTickets);
		    System.out.println("Number of Tickets:" + lstOfTickets.size());
		    f = false;
		    for(WebElement k : lstOfTickets) {
		    	String check = k.getText();
		    	System.out.println(check);
		    	if(check == bugID) f = true;
		    }
		    
		    //Change the status as Done for the newly created bug and validate the status in the board
		    wait.until(ExpectedConditions.elementToBeClickable(srchTicket)).click();
		    act.sendKeys(bugID).perform();	
			Thread.sleep(5000);	    
		    String[] ot = opnTicktFrmBrd.split("-");
		    opnTicktFrmBrd = ot[0] + bugID + ot[1];
		    wait.until(ExpectedConditions.elementToBeClickable(listOfTickets)).click();
		    
		    try{
		    	wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".icon-close"))).click();
		    }
		    catch (Exception e) {
				// TODO: handle exception
			} 
			Thread.sleep(5000);	   
		    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@aria-label='To Do - Change status'])[2]"))).click();
		    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text() = 'Done']"))).click();
			Thread.sleep(5000);	   
			dr.navigate().refresh(); 
			Thread.sleep(5000);	   
			dr.navigate().refresh(); 
		    wait.until(ExpectedConditions.elementToBeClickable(srchTicket)).click();
		    act.sendKeys(bugID).perform();	
			Thread.sleep(5000);	    
		    wait.until(ExpectedConditions.elementToBeClickable(listOfTickets)).click();
		    
		    try {
		    	wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".icon-close"))).click();
		    }
		    catch (Exception e) {
				// TODO: handle exception
			}
			Thread.sleep(5000);	   
		    String res = dr.findElement(By.xpath("(//div[contains(@data-test-id , 'resolution')]//span)[2]")).getText();
		    System.out.println(res);
		    
			//Quit the browser
			Thread.sleep(5000);
			//dr.quit();
		}

}
