package test.CreateTest;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
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
import com.Autopilot.PageObjects.CreateProject;
import com.Autopilot.PageObjects.HomePage;
import com.Autopilot.PageObjects.LoginPage;
import com.Autopilot.Utilities.ExcelData;

public class CreateProjectPilotBankAllTransaction extends BaseTest {

	@BeforeMethod
	public void LoginAdmin() throws InterruptedException {

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

	}

	@Test
	public void PilotBankAllTransaction() throws InterruptedException, EncryptedDocumentException, IOException {
		CreateProject cp = new CreateProject(driver);
		cp.clickOnProject();
		String TestProjectsHeader = driver.findElement(By.xpath("//a[text()='Testing Projects']")).getText();
		System.out.println("TestProjectsHeader:" + TestProjectsHeader);
		cp.ClickOnCreateProject();
		String generateString = RandomStringUtils.randomAlphabetic(10);
		cp.Enter_ProjectTitle(generateString);
		cp.Enter_ProjectDescription(generateString);
		Thread.sleep(1000);
		cp.ClickOnCreateNewTest();
		Actions actions = new Actions(driver);
		actions.scrollByAmount(0, 900).perform();
		cp.ClickOnInstrumentBank();
		cp.ClickOnTestTypePilotTesting();
		actions.scrollByAmount(0, 700).perform();
		cp.ClickOnclearindicator();
		cp.click_TansactionTypearrowdropdown();
		cp.click_transactionp2p();
		cp.click_TansactionTypearrowdropdown();
		cp.click_transactionP2B();
		cp.click_TansactionTypearrowdropdown();
		cp.click_transactionB2P();
		cp.click_TansactionTypearrowdropdown();
		cp.click_transactionB2B();
		Thread.sleep(1000);
		String sourcecountry = ExcelData.getData("CreateProject", 1, 2);
		cp.entersourcecounrty(sourcecountry);
		GenericUtils.selectDropdownOption(driver, sourcecountry);
		String destinationcountry = ExcelData.getData("CreateProject", 2, 2);
		cp.enterdestinationCountry(destinationcountry);
		GenericUtils.selectDropdownOption(driver, destinationcountry);
		String receivepartner = ExcelData.getData("CreateProject", 3, 2);
		cp.enterreceivepartner(receivepartner);
		Thread.sleep(1000);
		GenericUtils.selectDropdownOption(driver, receivepartner);
		String financialInstitutions = ExcelData.getData("CreateProject", 4, 2);
		cp.enterfinancialInstitutions(financialInstitutions);
		GenericUtils.selectDropdownOption(driver, financialInstitutions);
		String transactionMode = ExcelData.getData("CreateProject", 5, 2);
		cp.entertransactionMode(transactionMode);
		GenericUtils.selectDropdownOption(driver, transactionMode);
		String numberOfBotAccounts = ExcelData.getData("CreateProject", 6, 2);
		cp.enternumberOfBotAccounts(numberOfBotAccounts);
		String enternumberOfTestAccounts = ExcelData.getData("CreateProject", 7, 2);
		cp.enternumberOfTestAccounts(enternumberOfTestAccounts);
		LocalDate currentDate = LocalDate.now();
		System.out.println(currentDate);
		LocalDate nextDay = currentDate.plusDays(1);
		System.out.println("Lanuch Date : " + nextDay);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		 String formattedDate = nextDay.format(formatter);
		System.out.println("Converted Lanuch Date " + formattedDate );
		WebElement dateInput = driver.findElement(By.xpath("//input[@data-testid='launchDetails.launchDate']"));
		// Replace with actual locator
		dateInput.sendKeys(formattedDate);
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath("//button[normalize-space()='Confirm & Launch']"));
		actions.moveToElement(element).perform();
		cp.click_ConfirmLaunch();
		Thread.sleep(1000);
		cp.click_Launch();
		Thread.sleep(3000);
		WebElement modalBody = driver.findElement(By.xpath("//div[@class='modal-body']"));
		// Retrieve inner text of the modal body using JavaScript
        String modalBodyText = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText;", modalBody);
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
		//verifyAllTransaction 
		Thread.sleep(2000);
		String expected_projectname = generateString;
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
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actual_projectname, expected_projectname);
		sa.assertEquals(actual_scenario, expected_scenario);
		sa.assertEquals(actual_projectID, expectedprojectID);
		sa.assertAll();
	}
}
