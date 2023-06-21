package mandatoryHomeWork.selenium;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JIRA_DrgDrp_CrtSubTsk_DeletePrnt_Validate {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//fireFox
//		FirefoxOptions opt = new FirefoxOptions();
//		opt.addArguments("-private");		
//		
//		FirefoxDriver dr = new FirefoxDriver(opt);
		
		//edge
		EdgeOptions opt = new EdgeOptions();
		opt.addArguments("-inprivate");
		
		EdgeDriver dr = new EdgeDriver(opt);
		dr.manage().window().maximize();
		Actions act = new Actions(dr);
		
		dr.get("https://comparecheck.atlassian.net/");
		WebDriverWait wait = new WebDriverWait(dr, Duration.ofSeconds(30));
		
		//Enter User Name
		WebElement usrNm = wait.until(ExpectedConditions.elementToBeClickable(By.id("username")));
		usrNm.click();
		usrNm.clear();
		usrNm.sendKeys("b.sathish21@gmail.com");
		
		//Click on Continue button
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#login-submit>span>span"))).click();
		
		//Enter Password
		WebElement pswd = wait.until(ExpectedConditions.elementToBeClickable(By.id("password")));
		pswd.click();
		pswd.clear();
		pswd.sendKeys("Jithisha@01");
		
		//Click on the Log-In button
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text() = 'Log in']"))).click();
		
		//Click on Create button
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text() = 'Create']"))).click();
		
		//choose Issue Type
		WebElement issueTypeDrpDwn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@id, 'issue-type-select')]")));
		issueTypeDrpDwn.click();
		act.sendKeys("Task").sendKeys(Keys.ENTER).perform();
		
		//Enter Summary
		WebElement summaryText = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#summary-field")));
		summaryText.click();
		Date date = new Date();
		String sumry = "New Summary created - " + date.getTime();
		summaryText.sendKeys(sumry);

		//Enter Description
		WebElement descText = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".ak-editor-content-area p")));
		descText.click();
		date = new Date();
		act.sendKeys("New Description created - " + date.getTime()).perform();
		
		//choose Assignee
		WebElement assigneeDrpDwnTxt = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#assignee-field-label+div div.fabric-user-picker__single-value")));
		assigneeDrpDwnTxt.click();
		act.sendKeys("Sathish").perform();
		Thread.sleep(1000);//Time needed to populate the result
		act.sendKeys(Keys.ENTER).perform();
		
		//Assign Sprint
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text() = 'Select sprint']"))).click();
		act.sendKeys("CC Sprint 1").perform();
		Thread.sleep(1000);//Time needed to populate the result
		act.sendKeys(Keys.ENTER).perform();

		//Click on Create button
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@data-testid , 'modal--footer')]//span[text() = 'Create']"))).click();
		
		//Navigate to projects page
		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text() = 'Projects']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text() = 'compare_Check (CC)']"))).click();
		
		//search created task
		wait.until(ExpectedConditions.elementToBeClickable(By.name("search"))).click();
		act.sendKeys(sumry).perform();
		
		//drag and drop
		Thread.sleep(5000);
		act.clickAndHold(dr.findElement(By.xpath("(//div[contains(@class, 'ixgNBr')])[1]"))).build().perform();
		Thread.sleep(2500);
		act.moveToElement(dr.findElement(By.xpath("(//div[contains(@class, 'jwPAny')])[2]"))).build().perform();
		Thread.sleep(2500);
		act.release().build().perform();
		Thread.sleep(5000);
		act.clickAndHold(dr.findElement(By.xpath("(//div[contains(@class, 'ixgNBr')])[1]"))).build().perform();
		Thread.sleep(2500);
		act.moveToElement(dr.findElement(By.xpath("(//div[contains(@class, 'jwPAny')])[1]"))).build().perform();
		Thread.sleep(2500);
		act.release().build().perform();
		
		//Click on any task
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[contains(@class, 'ixgNBr')])[1]"))).click();
		
		//Click on "add a Child issue"
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text() = 'Add a child issue']"))).click();
		String childIssueName ="Test data - Child: " + date; 
		act.sendKeys(childIssueName).perform();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id = 'jira-issue-header']//following::span[text() = 'Create']"))).click();
		
		//Open the created child issue
		Thread.sleep(2500);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-testid='issue-line-card.card-container']"))).click();
		
		//Add description to child issue
		Thread.sleep(2500);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h2[text() = 'Description']//following::span[1]"))).click();
		act.sendKeys("Description of child issue: " + date).perform();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text() = 'Save']"))).click();
		
		//assign to an member
		String[] assignee = {"Sathish", "Devi", "Hema", "Karupa", "Krishna"};
		Random random = new Random();
		int i = random.nextInt(assignee.length);
		String user = assignee[i];
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h2[text() = 'Assignee']/following::span[text() = 'Unassigned']"))).click();
		Thread.sleep(2000);
		act.sendKeys(Keys.END).perform();
		act.sendKeys(Keys.LEFT_SHIFT, Keys.HOME, Keys.BACK_SPACE).perform();
		act.sendKeys(user).build().perform();
		Thread.sleep(2000);
		act.sendKeys(Keys.ENTER).perform();
		
		//add label
		Thread.sleep(2500);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h2[text() = 'Labels']/following::span[1]"))).click();
		act.sendKeys("test").perform();
		Thread.sleep(2000);
		act.sendKeys(Keys.ENTER).perform();
		
		//add comment
		Thread.sleep(2500);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder = 'Add a comment…']"))).click();
		String comnt = "comment for the child " + date ;
		act.sendKeys(comnt).perform();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text() = 'Save']"))).click();
		Thread.sleep(3000);
		
		//verify added comment
		String check = wait.until(
				ExpectedConditions.elementToBeClickable(
						By.xpath("//div[@data-test-id='issue.activity.comments-list']//following::p"))).getText();
		assertTrue(check.equals(comnt), "Comment is differed" + comnt + " || " + check);
		
		//close form
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Close']//span//span"))).click();
		Thread.sleep(3000);
		dr.navigate().refresh();
		Thread.sleep(3000);
		
		//filter group by
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span.hnPqMq"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text() = 'Subtask']"))).click();
		
		//search created child ticket with name
		wait.until(ExpectedConditions.elementToBeClickable(By.name("search"))).click();
		act.sendKeys(childIssueName).perform();
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".dMbKdr"))).click();
		
		//open attach
		String path = "\\src\\test\\java\\weekDayAssignment\\childIssueAttachment.txt";
		String dirPath = System.getProperty("user.dir");
		System.out.println(dirPath + " --***--- " + path);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text() = 'Attach']"))).click();
		act.sendKeys(dirPath+path).build().perform();
		Thread.sleep(2000);
		act.sendKeys(Keys.ENTER).perform();
		Thread.sleep(8000);
		WebElement atchmnt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#newFileExperienceWrapper")));
		assertTrue(atchmnt.isDisplayed(), "Attachment not available");

		//close form
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Close']//span//span"))).click();
		Thread.sleep(3000);
		dr.navigate().refresh();
		Thread.sleep(3000);
		
		//search parent ticket
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span.hnPqMq"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role = 'menu']//span[text() = 'None']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.name("search"))).click();
		act.sendKeys(Keys.END).perform();
		act.sendKeys(Keys.LEFT_SHIFT, Keys.HOME, Keys.BACK_SPACE).perform();
		act.sendKeys(sumry).build().perform();
		Thread.sleep(2000);
		act.sendKeys(Keys.ENTER).perform();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[contains(@class, 'ixgNBr')])[1]"))).click();
		
		//click on more button and delete
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable
				(By.xpath("//button[@data-testid='issue-meatball-menu.ui.dropdown-trigger.button']//span//span"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text() = 'Delete']"))).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text() = 'Delete']"))).click();
		
		//search parent ticket
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span.hnPqMq"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role = 'menu']//span[text() = 'None']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.name("search"))).click();
		act.sendKeys(Keys.END).perform();
		act.sendKeys(Keys.LEFT_SHIFT, Keys.HOME, Keys.BACK_SPACE).perform();
		act.sendKeys(sumry).build().perform();
		Thread.sleep(2000);
		act.sendKeys(Keys.ENTER).perform();
		WebElement ntprntissue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(@class, 'ixgNBr')])[1]")));
		assertTrue(!ntprntissue.isDisplayed(), "is available");
		
		//close browser
		dr.quit();
	}

}
