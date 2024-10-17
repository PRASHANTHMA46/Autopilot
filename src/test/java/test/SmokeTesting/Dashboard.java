package test.SmokeTesting;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Autopilot.Config.PropertiesFile;
import com.Autopilot.Generic.BaseTest;
import com.Autopilot.Generic.GenericUtils;
import com.Autopilot.PageObjects.Dashboard_Page;
import com.Autopilot.PageObjects.HomePage;
import com.Autopilot.PageObjects.LoginPage;
import com.Autopilot.Utilities.ExcelData;

public class Dashboard extends BaseTest {

	
	@BeforeMethod
	public void LoginAdmin() throws InterruptedException {

		LoginPage lp = new LoginPage(driver);
		String EmailId = PropertiesFile.readProperty("Admin");
		String Password = PropertiesFile.readProperty("pswd");
		lp.enterEmailId(EmailId);
		lp.enterPassword(Password);
		Thread.sleep(1000);
		lp.clickLoginButton();
		Thread.sleep(1000);
		lp.Navbarslideropen();
		Thread.sleep(1000);
		Dashboard_Page DP = new Dashboard_Page(driver);
		DP.clickOndashboard();
		Thread.sleep(2000);
		WebElement ele = driver.findElement(By.xpath("//html"));
		GenericUtils.mouseOver(driver, ele);

	}
	
	@Test(priority=1)
	public void VerifyProjectWidget() throws IllegalStateException, IOException, InterruptedException
	{
		//verify the data of project widget.
		Dashboard_Page dp = new Dashboard_Page(driver);
		String Actualpagetitle = driver.findElement(By.xpath("//h1[normalize-space()='Dashboard']")).getText();
		System.out.println("Actualpagetitile: " + Actualpagetitle);
		String Expectedpagetitle =  ExcelData.getData("SmokeTesting", 1, 2);
		System.out.println("Expectedpagetitle: " + Expectedpagetitle);
		Thread.sleep(2000);
		dp.clickOpilotprojectcalendericon();
		Thread.sleep(3000);
		LocalDate currentDate = LocalDate.now();
		System.out.println(currentDate);
		LocalDate CurrentDay = currentDate;
		System.out.println("CurrentDay : " + CurrentDay);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String formattedDate = CurrentDay.format(formatter);
		System.out.println("CurrentDayformate " + formattedDate);
		WebElement dateForm = driver.findElement(By.xpath("//input[@name='pilotStatisticsStartDateFrom']"));
		String s = Keys.chord(Keys.CONTROL, "a");
		Thread.sleep(3000);
		// Replace with actual locator
		dateForm.sendKeys(s);
		dateForm.sendKeys(formattedDate);
		dateForm.click();
		LocalDate nextDay = currentDate.plusDays(1);
		String Formatenextday = nextDay.format(formatter);
		WebElement dateTo = driver.findElement(By.xpath("//input[@name='pilotStatisticsStartDateTo']"));
		dateTo.sendKeys(s);
		dateTo.sendKeys(Formatenextday);
		dateTo.click();
		Thread.sleep(3000);
		dp.downloadPilotStatisticsButton();
		dp.clickviewproject();
		Thread.sleep(3000);
		String Actualpagetitleproject = driver.findElement(By.xpath("//h1[normalize-space()='Projects']")).getText();
		System.out.println("Actualpagetitleproject: " + Actualpagetitleproject);
		String Expectedpagetitleproject =  ExcelData.getData("SmokeTesting", 2, 2);
		System.out.println("Expectedpagetitleproject: " + Expectedpagetitleproject);
	}
	
	@Test(priority=2)
	public void VerifyCPM() throws InterruptedException, EncryptedDocumentException, IOException
	{
		Dashboard_Page dp = new Dashboard_Page(driver);
		String Actualpagetitle = driver.findElement(By.xpath("//h1[normalize-space()='Dashboard']")).getText();
		System.out.println("Actualpagetitile: " + Actualpagetitle);
		String Expectedpagetitle =  ExcelData.getData("SmokeTesting", 1, 2);
		System.out.println("Expectedpagetitle: " + Expectedpagetitle);
		Thread.sleep(2000);
		dp.clickCPMCalender();
		Thread.sleep(3000);
		LocalDate currentDate = LocalDate.now();
		System.out.println(currentDate);
		LocalDate CurrentDay = currentDate;
		System.out.println("CurrentDay : " + CurrentDay);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String formattedDate = CurrentDay.format(formatter);
		System.out.println("CurrentDayformate " + formattedDate);
		WebElement dateForm = driver.findElement(By.xpath("//input[@name='batchStatisticsStartDateFrom']"));
		String s = Keys.chord(Keys.CONTROL, "a");
		Thread.sleep(3000);
		// Replace with actual locator
		dateForm.sendKeys(s);
		dateForm.sendKeys(formattedDate);
		dateForm.click();
		LocalDate nextDay = currentDate.plusDays(1);
		String Formatenextday = nextDay.format(formatter);
		WebElement dateTo = driver.findElement(By.xpath("//input[@name='batchStatisticsStartDateTo']"));
		dateTo.sendKeys(s);
		dateTo.sendKeys(Formatenextday);
		dateTo.click();
		Thread.sleep(2000);
		dp.clickCPMStaticdownload();
		Thread.sleep(2000);
		String recivepartner = ExcelData.getData("SmokeTesting", 3, 2);
		dp.enterreceivepartner(recivepartner);
		dp.enterreceivepartnerbacksapce();
		Thread.sleep(2000);
		dp.clickreceivepatnerfirstdropodwn();
		String country = ExcelData.getData("SmokeTesting", 4, 2);
		dp.entercountry(country);
		dp.countrybackspace();
		dp.clickcountryfirstdropdown();
		dp.clickCPMviewproject();
		String Actualproject = driver.findElement(By.xpath("//h1[normalize-space()='Projects']")).getText();
		System.out.println("ActualprojectTitle: " + Actualproject);
		String Expectedprojecttitle =  ExcelData.getData("SmokeTesting", 5, 2);
		System.out.println("Expectedprojecttitle: " + Expectedprojecttitle);
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(Actualproject, Expectedprojecttitle);
		sa.assertAll();
		
	}
	
	@Test(priority=3)
	public void VerifyScheduleOperation() throws EncryptedDocumentException, IOException, InterruptedException
	{
		
		Dashboard_Page dp = new Dashboard_Page(driver);
		dp.clickScheduledoperationFilter();
		Actions actions = new Actions(driver);
		actions.scrollByAmount(0, 400).perform();
		Thread.sleep(2000);
		String instrument = ExcelData.getData("SmokeTesting", 6, 2);
		dp.enterinstrument(instrument);
		GenericUtils.selectDropdownOption(driver, instrument);
		String testtype = ExcelData.getData("SmokeTesting", 7, 2);
		dp.entertesttypeinput(testtype);
		GenericUtils.selectDropdownOption(driver, testtype);
		String recievepartner = ExcelData.getData("SmokeTesting", 8, 2);
		dp.enterrecievepartnert(recievepartner);
		GenericUtils.selectDropdownOption(driver, recievepartner);
		String ActualScheduledOperationstitle = driver.findElement(By.xpath("(//div[@class='panel-header p-3'])[2]")).getText();
		System.out.println("ActualScheduled: " + ActualScheduledOperationstitle);
		String ExpectedScheduledOperationstitle =  ExcelData.getData("SmokeTesting", 9, 2);
		System.out.println("ExpectedScheduled: " + ExpectedScheduledOperationstitle);
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(ActualScheduledOperationstitle, ExpectedScheduledOperationstitle);
		sa.assertAll();
		
	}
	
	@Test(priority=3)
	public void VerifyExecuationTime() throws EncryptedDocumentException, IOException, InterruptedException
	{
		Thread.sleep(2000);
		Dashboard_Page dp = new Dashboard_Page(driver);
		Actions actions = new Actions(driver);
		actions.scrollByAmount(0, 800).perform();
		Thread.sleep(2000);
		String ActualExecuationTime = driver.findElement(By.xpath("//div[contains(text(),'Execution Time')]")).getText();
		System.out.println("ActualExecuationTime: " + ActualExecuationTime);
		String ExpectedScheduledOperationstitle =  ExcelData.getData("SmokeTesting", 10, 2);
		System.out.println("ExpectedScheduled: " + ExpectedScheduledOperationstitle);
		driver.findElement(By.xpath(ExpectedScheduledOperationstitle));
		Thread.sleep(2000);
		  
		
	}
	
	@Test(priority=4 )
	public void VerifyAdd() throws InterruptedException, EncryptedDocumentException, IOException
	{
		//Thread.sleep(3000);
		Dashboard_Page dp = new Dashboard_Page(driver);
		dp.clickADD();
		Thread.sleep(2000);
		dp.clickADDSenderBot();
		Thread.sleep(1000);
		String ActualAddsenderBotTitle = driver.findElement(By.xpath("//h1[normalize-space()='Add Sender Bot']")).getText();
		System.out.println("ActualAddsenderBotTitle: " + ActualAddsenderBotTitle);
		String ExpectedAddsenderBotTitle =  "Add Sender Bot";
		System.out.println("ExpectedAddsenderBotTitle: " + ExpectedAddsenderBotTitle);
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(ActualAddsenderBotTitle, ExpectedAddsenderBotTitle);
		dp.clickSenderBack();
		dp.clickADD();
		dp.clickAddWalletAccount();
		Thread.sleep(2000);
		String ActualAddRecipientAccountTitle = driver.findElement(By.xpath("//h1[normalize-space()='Add Recipient Account']")).getText();
		System.out.println("ActualAddRecipientAccountTitle: " + ActualAddRecipientAccountTitle);
		String ExpectedAddRecipientAccountTitle =  "AddRecipientAccount";
		System.out.println("ExpectedAddRecipientAccountTitle: " + ExpectedAddRecipientAccountTitle);
		sa.assertEquals(ActualAddRecipientAccountTitle, ExpectedAddRecipientAccountTitle);
		Thread.sleep(2000);
		dp.clickSenderBack();
		dp.clickADD();
		dp.clickAddBankAccount();
		Thread.sleep(2000);
		String ActualAddBankAccountTitle = driver.findElement(By.xpath("//h1[normalize-space()='Add Recipient Account']")).getText();
		System.out.println("ActualAddBankAccountTitle: " + ActualAddBankAccountTitle);
		String ExpectedAddBankAccountTitle =  "AddRecipientAccount";
		System.out.println("ExpectedAddBankAccountTitle: " + ExpectedAddBankAccountTitle);
		sa.assertEquals(ActualAddBankAccountTitle, ExpectedAddBankAccountTitle);
		dp.clickSenderBack();
		dp.clickADD();
		dp.clickAddTestSuite();
		Thread.sleep(2000);
		String ActualAddTestSuite = driver.findElement(By.xpath("//h1[normalize-space()='Add New Test Suite']")).getText();
		System.out.println("ActualAddBankAccountTitle: " + ActualAddBankAccountTitle);
		String ExpectedAddTestSuite =  "Add New Test Suite";
		System.out.println("ExpectedAddTestSuite: " + ExpectedAddTestSuite);
		sa.assertEquals(ActualAddTestSuite, ExpectedAddTestSuite);
		dp.clickSenderBack();
		dp.clickADD();
		dp.clickCreateProject();
		Thread.sleep(2000);
		String Actualcreateproject = driver.findElement(By.xpath("//h1[normalize-space()='Create Project']")).getText();
		System.out.println("Actualcreateproject: " + Actualcreateproject);
		String Expectedcreateproject =  "Create Project";
		System.out.println("Expectedcreateproject: " + Expectedcreateproject);
		sa.assertEquals(Actualcreateproject, Expectedcreateproject);
	}
	
	@Test(priority=5 )
	public void OperationStatics() throws InterruptedException, EncryptedDocumentException, IOException
	{
		
		String ActualOperationstaticsHeader = driver.findElement(By.xpath("//div[contains(text(),'Operation Statistics')]")).getText();
		System.out.println("ActualOperationstaticsHeader: " + ActualOperationstaticsHeader);
		String ExpectedOperationstaticsHeader =  "Operation Statistics";
		System.out.println("ExpectedOperationstaticsHeader: " + ExpectedOperationstaticsHeader);
		Dashboard_Page dp = new Dashboard_Page(driver);
		WebElement element = driver.findElement(By.xpath("//div[@class='col']//button[@title='Toggle filters']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(2000);
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(ActualOperationstaticsHeader, ExpectedOperationstaticsHeader);
	    sa.assertAll();
		
	}
	@Test(priority=6 )
	public void ViewtransactionAndviewproject() throws InterruptedException
	{
		Dashboard_Page dp = new Dashboard_Page(driver);
		String transactionId = "TPTQ000001306447";
		dp.EnterViewTransaction(transactionId);
		dp.viewTransactionclick();
		String transactionsucess = driver.findElement(By.xpath("//div[@class='info-text']//div[@class='project-status'][normalize-space()='Success']")).getText();
		System.out.println("View transactionsucess " + transactionsucess);
		dp.clickSenderBack();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[normalize-space()='View Project'])[1]")).click();
		String projectID = "2362";
		dp.EnterprojectID(projectID);
		dp.enterprojectviewclick();
		String projectname = driver.findElement(By.xpath("//h1[normalize-space()='UTA_AUtopilots-Test-Devserver-223']")).getText();
		System.out.println("project ID:"   + projectname );
		dp.clickSenderBack();
		
	}
}
