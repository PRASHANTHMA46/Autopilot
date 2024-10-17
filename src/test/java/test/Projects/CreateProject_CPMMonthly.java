package test.Projects;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Autopilot.Config.PropertiesFile;
import com.Autopilot.Generic.BaseTest;
import com.Autopilot.Generic.GenericUtils;
import com.Autopilot.PageObjects.CreateProject;
import com.Autopilot.PageObjects.HomePage;
import com.Autopilot.PageObjects.LoginPage;
import com.Autopilot.Utilities.ExcelData;

public class CreateProject_CPMMonthly extends BaseTest{
	@BeforeMethod
	public void LoginAdmin() throws InterruptedException, EncryptedDocumentException, IOException {

		LoginPage lp = new LoginPage(driver);
		HomePage hp = new HomePage(driver);
		String EmailId = PropertiesFile.readProperty("Admin");
		String Password = PropertiesFile.readProperty("pswd");
		lp.enterEmailId(EmailId);
		lp.enterPassword(Password);
		Thread.sleep(1000);
		lp.clickLoginButton();
		Thread.sleep(1000);
		lp.Navbarslideropen();
		Thread.sleep(1000);
		CreateProject cp = new CreateProject(driver);
		cp.clickOnProject();
		String ActualProjectHeader = driver.findElement(By.xpath("//h1[normalize-space()='Projects']")).getText();
		System.out.println("ActualProjectHeader: " + ActualProjectHeader);
		String expected_ProjectHeader = ExcelData.getData("projects", 1, 2);
		System.out.println("Expected_ProjectHeader: " + expected_ProjectHeader);
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(ActualProjectHeader, expected_ProjectHeader);
		cp.ClickOnCreateProject();
		Thread.sleep(2000);

	}

	@Test(priority = 1)
	public void verify_CPMA_Monthly() throws EncryptedDocumentException, IOException, InterruptedException {

		// basic details enter to continue
		CreateProject cp = new CreateProject(driver);
		String title = ExcelData.getData("projects", 96, 2);
		cp.Enter_ProjectTitle(title);
		System.out.println("Title: " + title);
		String description = ExcelData.getData("projects", 97, 2);
		cp.Enter_ProjectDescription(description);
		cp.ClickOnCreateNewTest();
		// verify Bank instrument
		cp.ClickOnInstrumentBank();
		Actions actions = new Actions(driver);
		actions.scrollByAmount(0, 700).perform();
		cp.ClickOnCPM();
		Thread.sleep(1000);
		cp.ClickOnCPMMonthly();
		Thread.sleep(1000);
		String expectedsourcecountry = ExcelData.getData("projects", 10, 2);
		System.out.println("expectedsourcecountry: " + expectedsourcecountry);
		cp.entersourcecounrty(expectedsourcecountry);
		GenericUtils.selectDropdownOption(driver, expectedsourcecountry);
		SoftAssert sa = new SoftAssert();
		String expectedDestinationcountry = ExcelData.getData("projects", 11, 2);
		System.out.println("expectedDestinationcountry: " + expectedDestinationcountry);
		cp.enterdestinationCountry(expectedDestinationcountry);
		GenericUtils.selectDropdownOption(driver, expectedDestinationcountry);
		Thread.sleep(1000);
		cp.click_RandomAccount();
		Thread.sleep(1000);
		actions.scrollByAmount(0, 700).perform();
		// Receiverpartner
		String Expectedreceivepartner = ExcelData.getData("projects", 24, 2);
		cp.enterreceivepartner(Expectedreceivepartner);
		GenericUtils.selectDropdownOption(driver, Expectedreceivepartner);
		Thread.sleep(1000);
		// TransactionMode
		String transactionMode = ExcelData.getData("projects", 25, 2);
		System.out.println("transactionMode: " + transactionMode);
		cp.entertransactionMode(transactionMode);
		GenericUtils.selectDropdownOption(driver, transactionMode);
		// No of Sender Bots
		String Expecetdsenderbots = ExcelData.getData("projects", 26, 2);
		System.out.println("Expecetdsenderbots: " + Expecetdsenderbots);
		cp.enternumberOfBotAccounts(Expecetdsenderbots);
		Thread.sleep(1000);
		// No of Recipient Bots
		String ExpectedREcipientBots = ExcelData.getData("projects", 27, 2);
		cp.enternumberOfTestAccounts(ExpectedREcipientBots);
		String NumberOfOccurance =  ExcelData.getData("projects", 91, 2);
		cp.EnterNumberOfOccurancy(NumberOfOccurance);
		actions.scrollByAmount(0, 700).perform();
		Thread.sleep(1000);
		ZonedDateTime utcNow = ZonedDateTime.now().plusDays(2).withZoneSameInstant(java.time.ZoneOffset.UTC);
		// now(ChronoUnit.SECONDS).withZoneSameInstant(java.time.ZoneOffset.UTC);
		ZonedDateTime utcPlusOneMinutes = utcNow.plusMinutes(1);
		// Format the time into a string (adjust format as needed)
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String formattedTime = utcPlusOneMinutes.format(formatter);
		// Find the input element and enter the time
		WebElement inputElement = driver.findElement(By.xpath("//input[@name='launchDetails.launchDate']"));
		inputElement.sendKeys(formattedTime);
		Thread.sleep(1000);
		//View Batch details
		cp.clickonbatchViewBatchDetails();
		String actual_batchdetails = driver.findElement(By.xpath("//div[text()='Batch Details']")).getText();
		System.out.println("actual_batchdetails: " + actual_batchdetails);
		String expected_batchdetails = ExcelData.getData("projects", 92, 2);
		System.out.println("expected_batchdetails: " + expected_batchdetails);
		String ActualBatchOne = driver.findElement(By.xpath("//span[normalize-space()='Batch 1']")).getText();
		System.out.println("ActualBatchOne: " + ActualBatchOne);
		String ExpectedBatchOne = ExcelData.getData("projects", 93, 2);
		System.out.println("ExpectedBatchOne: " + ExpectedBatchOne);
		String ActualBatchSecond = driver.findElement(By.xpath("//span[normalize-space()='Batch 2']")).getText();
		System.out.println("ActualBatchSecond: " + ActualBatchSecond);
		String ExpectedBatchSecond = ExcelData.getData("projects", 94, 2);
		System.out.println("ExpectedBatchSecond: " + ExpectedBatchSecond);
		sa.assertEquals(actual_batchdetails, expected_batchdetails);
		sa.assertEquals(ActualBatchOne, ExpectedBatchOne);
		sa.assertEquals(ActualBatchSecond, ExpectedBatchSecond);
        cp.clickonCloseicon();
		WebElement element = driver.findElement(By.xpath("//button[normalize-space()='Confirm & Launch']"));
		actions.moveToElement(element).perform();
		cp.click_ConfirmLaunch();
		Thread.sleep(1000);
		cp.click_Launch();
		Thread.sleep(3000);
		WebElement modalBody = driver.findElement(By.xpath("//div[@class='modal-body']"));
		// Retrieve inner text of the modal body using JavaScript
		String modalBodyText = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText;",
				modalBody);
		// Print modal body text to console
		System.out.println(modalBodyText);
		String actual_projectlanuch = driver.findElement(By.xpath("//p[@class='modal__message']")).getText();
		System.out.println(actual_projectlanuch);
		WebElement projectIDElement = driver.findElement(By.xpath("//p[contains(text(), 'Your project ID is')]"));
		// Extract the text from the element
		String projectIDText = projectIDElement.getText();
		// Extract the project ID from the text
		String expectedprojectID = projectIDText.split("#")[1].replace(".", "").trim();
		// Print the project ID
		System.out.println("expectedprojectID: " + expectedprojectID);
		actions.moveByOffset(0, 0).click().build().perform();
		Thread.sleep(2000);
		String expected_projectname = title;
		System.out.println("expected_projectname: " + expected_projectname);
		String actual_projectname = driver.findElement(By.xpath("//td[@data-cy='0_projectTitle']")).getText();
		System.out.println("actual_projectname: " + actual_projectname);
		String expected_scenario = "B2B, B2P, P2B, P2P";
		System.out.println("expected_scenario: " + expected_scenario);
		String actual_scenario = driver.findElement(By.xpath("//td[@data-cy='0_testScenarios']")).getText();
		System.out.println("actual_scenario: " + actual_scenario);
		String projectID = driver.findElement(By.xpath("//td[@data-cy='0_id']")).getText();
		String actual_projectID = projectID.split("#")[1].replace(".", "").trim();
		System.out.println("actual_projectID: " + actual_projectID);
		sa.assertEquals(actual_projectname, expected_projectname);
		sa.assertEquals(actual_scenario, expected_scenario);
		sa.assertEquals(actual_projectID, expectedprojectID);
		// // verify CPM Weekly in scheduled Tab.
		actions.scrollByAmount(0, -800).perform();
		cp.clickon_scheduledprojectTab();
		Thread.sleep(2000);
		String expected_ScheduledTabprojectname = title;
		System.out.println("expected_ScheduledTabprojectname: " + expected_ScheduledTabprojectname);
		String actual_ScheduledTabprojectname = driver.findElement(By.xpath("//td[@data-cy='0_projectTitle']")).getText();
		System.out.println("actual_ScheduledTabprojectname: " + actual_ScheduledTabprojectname);
		String expected_ScheduledTabscenario = "B2B, B2P, P2B, P2P";
		System.out.println("expected_ScheduledTabscenario: " + expected_ScheduledTabscenario);
		String actual_ScheduledTabscenario = driver.findElement(By.xpath("//td[@data-cy='0_testScenarios']")).getText();
		System.out.println("actual_ScheduledTabscenario: " + actual_ScheduledTabscenario);
		String ScheduledTabprojectID = driver.findElement(By.xpath("//td[@data-cy='0_id']")).getText();
		String actual_ScheduledID = ScheduledTabprojectID.split("#")[1].replace(".", "").trim();
		String actual_ScheduledTabprojectID = actual_ScheduledID;
		System.out.println("actual_ScheduledTabprojectID: " + actual_ScheduledTabprojectID);
		sa.assertEquals(actual_projectname, expected_projectname);
		sa.assertEquals(actual_scenario, expected_scenario);
		sa.assertEquals(actual_ScheduledTabprojectID, expectedprojectID);
		String Expected_projectscheduled = ExcelData.getData("projects", 90, 2);
		System.out.println("Expected_projectscheduled: " + Expected_projectscheduled);
		String Actual_projectscheduled = driver.findElement(By.xpath("(//div[@class='project-status'][contains(text(),'Scheduled')])[1]")).getText();
		System.out.println("Actual_projectscheduled: " + Actual_projectscheduled);
		cp.clickon_TestingProjects();
		Thread.sleep(2000);
		cp.clickonTestprojecttableoption();
		Thread.sleep(2000);
		cp.clickonprojecttableoptionView();
		Thread.sleep(2000);
		//verifying Test Details
		String Actual_CPM = cp.get_TestType();
		System.out.println("Actual_CPM: " + Actual_CPM);
		String Expected_CPM = ExcelData.getData("projects", 100, 2);
		System.out.println("Expected_CPM: " + Expected_CPM);
		String Actual_MONTHLY = cp.get_Frequency();
		System.out.println("Actual_MONTHLY: " + Actual_MONTHLY);
		String Expected_MONTHLY = ExcelData.getData("projects", 102, 2);
		System.out.println("Expected_MONTHLY: " + Expected_MONTHLY);
		sa.assertEquals(Actual_CPM, Expected_CPM);
		sa.assertEquals(Actual_MONTHLY, Expected_MONTHLY);
		driver.findElement(By.xpath("(//a[normalize-space()='Golden Money Transfer'])[1]")).click();
		cp.clickon_pause();
		String actualScheduledprojectpaused = driver.findElement(By.xpath("//div[@role='status']")).getText();
		System.out.println("actualScheduledprojectpaused: " + actualScheduledprojectpaused);
		String expectedScheduledprojectpaused = ExcelData.getData("projects", 95, 2);
		System.out.println("expectedScheduledprojectpaused: " + expectedScheduledprojectpaused);
		sa.assertEquals(actualScheduledprojectpaused, expectedScheduledprojectpaused);
		cp.clickonTestprojecttableoption();
		Thread.sleep(2000);
		cp.clickonprojecttableoptionView();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[normalize-space()='Golden Money Transfer'])[1]")).click();
		Thread.sleep(1000);
		cp.click_Launch();
		String actualrelaunch = driver.findElement(By.xpath("//div[@role='status']")).getText();
		System.out.println("actualrelaunch: " + actualrelaunch);
		String expectedrelaunch = ExcelData.getData("projects", 31, 2);
		System.out.println("expectedrelaunch: " + expectedrelaunch);
		sa.assertEquals(actualrelaunch, expectedrelaunch);
		sa.assertAll();	
	}


}
