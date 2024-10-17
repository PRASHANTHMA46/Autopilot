package test.SmokeTesting;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
import com.Autopilot.Generic.WaitUtils;
import com.Autopilot.PageObjects.CreateProject;
import com.Autopilot.PageObjects.HomePage;
import com.Autopilot.PageObjects.LoginPage;
import com.Autopilot.Utilities.ExcelData;

public class CreateProjectPilotBankP2BTransaction extends BaseTest {

	@BeforeMethod
	public void LoginAdmin() throws InterruptedException, EncryptedDocumentException, IOException {


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
		driver.findElement(By.xpath("//html")).click();
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
	
	@Test
	public void PilotBankP2BTransaction() throws InterruptedException, EncryptedDocumentException, IOException {
		// basic details enter to continue
		// basic details enter to continue
		CreateProject cp = new CreateProject(driver);
		String title = ExcelData.getData("projects", 78, 2);
		cp.Enter_ProjectTitle(title);
		System.out.println("Title: " + title);
		String description =  ExcelData.getData("projects", 79, 2);
		cp.Enter_ProjectDescription(description);
		System.out.println("Description: " + description);
		cp.ClickOnCreateNewTest();
		Actions actions = new Actions(driver);
		actions.scrollByAmount(0, 900).perform();
		cp.ClickOnInstrumentBank();
		cp.ClickOnTestTypePilotTesting();
		actions.scrollByAmount(0, 700).perform();
		cp.ClickOnclearindicator();
		cp.click_TansactionTypearrowdropdown();
		cp.click_transactionp2p();
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
		/*
		 * // FinancialPartner String ExpecetdfinancialInstitutions =
		 * ExcelData.getData("projects", 17, 2);
		 * cp.enterfinancialInstitutions(ExpecetdfinancialInstitutions);
		 * GenericUtils.selectDropdownOption(driver, ExpecetdfinancialInstitutions);
		 * Thread.sleep(1000);
		 */
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
		Thread.sleep(1000);
		actions.scrollByAmount(0, 700).perform();
		cp.ClickLaunchDate();
		Thread.sleep(2000);
		ZonedDateTime utcNow = ZonedDateTime.now().withZoneSameInstant(java.time.ZoneOffset.UTC);
		// now(ChronoUnit.SECONDS).withZoneSameInstant(java.time.ZoneOffset.UTC);
		ZonedDateTime utcPlusOneMinutes = utcNow.plusMinutes(1);
		// Format the time into a string (adjust format as needed)
		DateTimeFormatter formatter  = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String formattedTime = utcPlusOneMinutes.format(formatter);
		// Find the input element and enter the time
		WebElement inputElement = driver.findElement(By.xpath("//input[@name='launchDetails.launchDate']"));
		inputElement.sendKeys(formattedTime);
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
		// verifyAllTransaction
		Thread.sleep(2000);
		String expected_projectname = title;
		System.out.println("expected_projectname: " + expected_projectname);
		String actual_projectname = driver.findElement(By.xpath("//td[@data-cy='0_projectTitle']")).getText();
		System.out.println("actual_projectname: " + actual_projectname);
		String expected_scenario = "P2P";
		System.out.println("expected_scenario: " + expected_scenario);
		String actual_scenario = driver.findElement(By.xpath("//td[@data-cy='0_testScenarios']")).getText();
		System.out.println("actual_scenario: " + actual_scenario);
		String projectID = driver.findElement(By.xpath("//td[@data-cy='0_id']")).getText();
		String actual_projectID = projectID.split("#")[1].replace(".", "").trim();
		System.out.println("actual_projectID: " + actual_projectID);
		sa.assertEquals(actual_projectname, expected_projectname);
		sa.assertEquals(actual_scenario, expected_scenario);
		sa.assertEquals(actual_projectID, expectedprojectID);
		//Verify the Transaction
		actions.scrollByAmount(0, -800).perform();
		cp.clickonTestprojecttableoption();
		Thread.sleep(20000);
		cp.clickonprojecttableoptionView();
		Thread.sleep(20000);
		driver.findElement(By.xpath("(//a[normalize-space()='Golden Money Transfer'])[1]")).click();
		Thread.sleep(50000);
		driver.navigate().refresh();
		WebElement projectstatus = cp.getText_projectstatus();
		WaitUtils.fluentWait_VisibilityOfElement(projectstatus);
		String status = projectstatus.getText();
		 // Perform actions based on status
        if (status.equals("Ongoing")) {
            // Click on the "Option" button
            WebElement OptionButton = driver.findElement(By.xpath("//td[@class='text-center']"));
            OptionButton.click();
            Thread.sleep(2000);
            cp.clickonbatchViewDetails();
            Thread.sleep(2000);
            String Actualresponcemessage = cp.getresponse();
            System.out.println("Actualresponcemessage: " + Actualresponcemessage);
            Thread.sleep(2000);
            String Expectedresponcemessage = ExcelData.getData("projects", 32, 2);
            System.out.println("Expectedresponcemessage: " + Expectedresponcemessage);
            sa.assertEquals(Actualresponcemessage, Expectedresponcemessage);
            cp.clickonCloseicon();
        } else if (status.equals("Success") || status.equals("Failed")) {
            // Check for pass or fail condition
            WebElement resultElement = cp.getText_PassorFailStatus();
            String result = resultElement.getText();
            if (result.equals("Pass")) {
                System.out.println("Project Success!");
            } else {
                System.out.println("Project failed!");
            }
        } else {
            System.out.println("Unknown status: " + status);
        }
		
		sa.assertAll();
	}

}
