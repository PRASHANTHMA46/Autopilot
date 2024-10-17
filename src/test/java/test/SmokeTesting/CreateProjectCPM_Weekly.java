package test.SmokeTesting;

import java.io.IOException;
import java.time.LocalDate;
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
import com.Autopilot.Generic.WaitUtils;
import com.Autopilot.PageObjects.CreateProject;
import com.Autopilot.PageObjects.HomePage;
import com.Autopilot.PageObjects.LoginPage;
import com.Autopilot.Utilities.ExcelData;

public class CreateProjectCPM_Weekly extends BaseTest {
	
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

	@Test(priority=1)
	public void CPMAllTransaction()throws InterruptedException, EncryptedDocumentException, IOException
	{
			CreateProject cp = new CreateProject(driver);
			cp.clickOnProject();
			String TestProjectsHeader = driver.findElement(By.xpath("//a[text()='Testing Projects']")).getText();
			System.out.println("TestProjectsHeader:" + TestProjectsHeader);
			cp.ClickOnCreateProject();
			String title = ExcelData.getData("CreateProject", 51, 2);
			cp.Enter_ProjectTitle(title);
			String description = ExcelData.getData("CreateProject", 52, 2);
			cp.Enter_ProjectDescription(description);
			Thread.sleep(1000);
			cp.ClickOnCreateNewTest();
			Actions actions = new Actions(driver);
			actions.scrollByAmount(0, 900).perform();
			cp.ClickOnInstrumentBank();
			cp.ClickOnCPM();
			Thread.sleep(1000);
			String sourcecountry = ExcelData.getData("CreateProject", 2, 2);
			cp.entersourcecounrty(sourcecountry);
			GenericUtils.selectDropdownOption(driver, sourcecountry);
			String destinationcountry = ExcelData.getData("CreateProject", 1, 2);
			cp.enterdestinationCountry(destinationcountry);
			GenericUtils.selectDropdownOption(driver, destinationcountry);
			String receivepartner = ExcelData.getData("CreateProject", 53, 2);
			cp.enterreceivepartner(receivepartner);
			Thread.sleep(1000);
			GenericUtils.selectDropdownOption(driver, receivepartner);
			/*
			String financialInstitutions = ExcelData.getData("CreateProject", 19, 2);
			cp.enterfinancialInstitutions(financialInstitutions);
			GenericUtils.selectDropdownOption(driver, financialInstitutions);
			String transactionMode = ExcelData.getData("CreateProject", 20, 2);
			cp.entertransactionMode(transactionMode);
			GenericUtils.selectDropdownOption(driver, transactionMode);
			*/
			String numberOfBotAccounts = ExcelData.getData("CreateProject", 6, 2);
			cp.enternumberOfBotAccounts(numberOfBotAccounts);
			String enternumberOfTestAccounts = ExcelData.getData("CreateProject", 7, 2);
			cp.enternumberOfTestAccounts(enternumberOfTestAccounts);
			String NumberOfOccurance =  ExcelData.getData("CreateProject", 14, 2);
			cp.EnterNumberOfOccurancy(NumberOfOccurance);
			actions.scrollByAmount(0, 700).perform();
			cp.ClickLaunchDate();
			Thread.sleep(2000);
			LocalDate currentDate = LocalDate.now();
			System.out.println(currentDate);
			int dayOfMonth = currentDate.getDayOfMonth();
	        String formattedDay;
	     // Use `dd` format if the day is a single digit, otherwise use `d`
	        if (dayOfMonth < 10) {
	            // Single-digit day: format with leading zero
	            DateTimeFormatter twoDigitFormatter = DateTimeFormatter.ofPattern("d");
	            formattedDay = currentDate.format(twoDigitFormatter);
	        } else {
	            // Two-digit day: format normally
	            DateTimeFormatter singleDigitFormatter = DateTimeFormatter.ofPattern("dd");
	            formattedDay = currentDate.format(singleDigitFormatter);
	        }
			//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd");
	        //String dayofMonth = currentDate.format(formattedDay);
	        System.out.println("Day of Month: " + formattedDay);
			String lanuchday = "(//span[text()='"+formattedDay+"'])[1]";
			driver.findElement(By.xpath(lanuchday)).click();
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
			SoftAssert sa = new SoftAssert();
			sa.assertEquals(actual_projectname, expected_projectname);
			sa.assertEquals(actual_scenario, expected_scenario);
			sa.assertEquals(actual_projectID, expectedprojectID);
			actions.scrollByAmount(0, -800).perform();
			cp.clickonTestprojecttableoption();
			Thread.sleep(20000);
			cp.clickonprojecttableoptionView();
			Thread.sleep(20000);
			driver.findElement(By.xpath("(//a[normalize-space()='Central Payments L.L.C'])[1]")).click();
			Thread.sleep(50000);
			driver.navigate().refresh();
			WebElement projectstatus = cp.getText_projectstatus();
			WaitUtils.fluentWait_VisibilityOfElement(projectstatus);
			String status = projectstatus.getText();
			 // Perform actions based on status
	        if (status.equals("Ongoing")) {
	            // Click on the "Option" button
	            cp.clickon_projecttableFirtOption();
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
	            String expectedTitle = "Success";
	            String result = resultElement.getText();
	            if (result.equals("Pass")) {
	                System.out.println("Project Success!");
	                cp.clickonbatchViewDetails();
		            Thread.sleep(2000);
		            String Successresponcemessage = cp.getresponse();
		            System.out.println("Successresponcemessage: " + Successresponcemessage);
		            cp.clickonCloseicon();
	            } else {
	                System.out.println("Project failed!");
	                cp.clickonbatchViewDetails();
		            Thread.sleep(2000);
		            String Failedresponcemessage = cp.getresponse();
		            System.out.println("Failedresponcemessage: " + Failedresponcemessage);
		            cp.clickonCloseicon();
	            }
	            sa.assertEquals(result, expectedTitle);
	        } else {
	            System.out.println("Unknown status: " + status);
	        }
			
			sa.assertAll();
	}
	
	@Test(priority=2)
	public void CPMWeekly_B2BTransaction() throws InterruptedException, EncryptedDocumentException, IOException
	{
		CreateProject cp = new CreateProject(driver);
		cp.clickOnProject();
		String TestProjectsHeader = driver.findElement(By.xpath("//a[text()='Testing Projects']")).getText();
		System.out.println("TestProjectsHeader:" + TestProjectsHeader);
		cp.ClickOnCreateProject();
		String title = ExcelData.getData("CreateProject", 54, 2);
		cp.Enter_ProjectTitle(title);
		System.out.println("Title: " + title);
		String description =  ExcelData.getData("CreateProject", 55, 2);
		cp.Enter_ProjectDescription(description);
		System.out.println("Description: " + description);
		Thread.sleep(1000);
		cp.ClickOnCreateNewTest();
		Actions actions = new Actions(driver);
		actions.scrollByAmount(0, 900).perform();
		cp.ClickOnInstrumentBank();
		cp.ClickOnCPM();
		actions.scrollByAmount(0, 700).perform();
		cp.ClickOnclearindicator();
		cp.click_TansactionTypearrowdropdown();
		cp.click_transactionB2B();
		Thread.sleep(1000);
		String sourcecountry = ExcelData.getData("CreateProject", 2, 2);
		cp.entersourcecounrty(sourcecountry);
		GenericUtils.selectDropdownOption(driver, sourcecountry);
		System.out.println("sourcecountry: " + sourcecountry);
		String destinationcountry = ExcelData.getData("CreateProject", 1, 2);
		cp.enterdestinationCountry(destinationcountry);
		GenericUtils.selectDropdownOption(driver, destinationcountry);
		System.out.println("destinationcountry: " + destinationcountry);
		String receivepartner = ExcelData.getData("CreateProject", 53, 2);
		cp.enterreceivepartner(receivepartner);
		System.out.println("receivepartner: " + receivepartner);
		Thread.sleep(1000);
		GenericUtils.selectDropdownOption(driver, receivepartner);
		/*
		String financialInstitutions = ExcelData.getData("CreateProject", 19, 2);
		cp.enterfinancialInstitutions(financialInstitutions);
		GenericUtils.selectDropdownOption(driver, financialInstitutions);
		String transactionMode = ExcelData.getData("CreateProject", 20, 2);
		cp.entertransactionMode(transactionMode);
		GenericUtils.selectDropdownOption(driver, transactionMode);
		*/
		String numberOfBotAccounts = ExcelData.getData("CreateProject", 6, 2);
		cp.enternumberOfBotAccounts(numberOfBotAccounts);
		String enternumberOfTestAccounts = ExcelData.getData("CreateProject", 7, 2);
		cp.enternumberOfTestAccounts(enternumberOfTestAccounts);
		String NumberOfOccurance =  ExcelData.getData("CreateProject", 14, 2);
		cp.EnterNumberOfOccurancy(NumberOfOccurance);
		actions.scrollByAmount(0, 700).perform();
		cp.ClickLaunchDate();
		Thread.sleep(2000);
		LocalDate currentDate = LocalDate.now();
		System.out.println(currentDate);
		int dayOfMonth = currentDate.getDayOfMonth();
        String formattedDay;
     // Use `dd` format if the day is a single digit, otherwise use `d`
        if (dayOfMonth < 10) {
            // Single-digit day: format with leading zero
            DateTimeFormatter twoDigitFormatter = DateTimeFormatter.ofPattern("d");
            formattedDay = currentDate.format(twoDigitFormatter);
        } else {
            // Two-digit day: format normally
            DateTimeFormatter singleDigitFormatter = DateTimeFormatter.ofPattern("dd");
            formattedDay = currentDate.format(singleDigitFormatter);
        }
		//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd");
        //String dayofMonth = currentDate.format(formattedDay);
        System.out.println("Day of Month: " + formattedDay);
		String lanuchday = "(//span[text()='"+formattedDay+"'])[1]";
		driver.findElement(By.xpath(lanuchday)).click();
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
		String expected_projectname = title;
		System.out.println("expected_projectname: " + expected_projectname);
		String actual_projectname = driver.findElement(By.xpath("//td[@data-cy='0_projectTitle']")).getText();
		System.out.println("actual_projectname: " + actual_projectname);
		String expected_scenario = "B2B";
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
		actions.scrollByAmount(0, -800).perform();
		cp.clickonTestprojecttableoption();
		Thread.sleep(20000);
		cp.clickonprojecttableoptionView();
		Thread.sleep(20000);
		driver.findElement(By.xpath("(//a[normalize-space()='Central Payments L.L.C'])[1]")).click();
		Thread.sleep(50000);
		driver.navigate().refresh();
		WebElement projectstatus = cp.getText_projectstatus();
		WaitUtils.fluentWait_VisibilityOfElement(projectstatus);
		String status = projectstatus.getText();
		 // Perform actions based on status
        if (status.equals("Ongoing")) {
            // Click on the "Option" button
            cp.clickon_projecttableFirtOption();
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
            String expectedTitle = "Success";
            String result = resultElement.getText();
            if (result.equals("Pass")) {
                System.out.println("Project Success!");
                cp.clickon_projecttableFirtOption();
                Thread.sleep(2000);
                cp.clickonbatchViewDetails();
	            Thread.sleep(2000);
	            String Successresponcemessage = cp.getresponse();
	            System.out.println("Successresponcemessage: " + Successresponcemessage);
	            cp.clickonCloseicon();
            } else {
                System.out.println("Project failed!");
                cp.clickon_projecttableFirtOption();
                Thread.sleep(2000);
                cp.clickonbatchViewDetails();
	            Thread.sleep(2000);
	            String Failedresponcemessage = cp.getresponse();
	            System.out.println("Failedresponcemessage: " + Failedresponcemessage);
	            cp.clickonCloseicon();
            }
            sa.assertEquals(result, expectedTitle);
        } else {
            System.out.println("Unknown status: " + status);
        }
		
		sa.assertAll();
		
	}
	
	@Test(priority=3)
	public void CPMWeekly_B2PTransaction() throws InterruptedException, EncryptedDocumentException, IOException
	{
		CreateProject cp = new CreateProject(driver);
		cp.clickOnProject();
		String TestProjectsHeader = driver.findElement(By.xpath("//a[text()='Testing Projects']")).getText();
		System.out.println("TestProjectsHeader:" + TestProjectsHeader);
		cp.ClickOnCreateProject();
		String title = ExcelData.getData("CreateProject", 51, 2);
		cp.Enter_ProjectTitle(title);
		System.out.println("Title: " + title);
		String description =  ExcelData.getData("CreateProject", 52, 2);
		cp.Enter_ProjectDescription(description);
		System.out.println("Description: " + description);
		Thread.sleep(1000);
		cp.ClickOnCreateNewTest();
		Actions actions = new Actions(driver);
		actions.scrollByAmount(0, 900).perform();
		cp.ClickOnInstrumentBank();
		cp.ClickOnCPM();
		actions.scrollByAmount(0, 700).perform();
		cp.ClickOnclearindicator();
		cp.click_TansactionTypearrowdropdown();
		cp.click_transactionB2P();
		Thread.sleep(1000);
		String sourcecountry = ExcelData.getData("CreateProject", 2, 2);
		cp.entersourcecounrty(sourcecountry);
		GenericUtils.selectDropdownOption(driver, sourcecountry);
		System.out.println("sourcecountry: " + sourcecountry);
		String destinationcountry = ExcelData.getData("CreateProject", 1, 2);
		cp.enterdestinationCountry(destinationcountry);
		GenericUtils.selectDropdownOption(driver, destinationcountry);
		System.out.println("destinationcountry: " + destinationcountry);
		String receivepartner = ExcelData.getData("CreateProject", 53, 2);
		cp.enterreceivepartner(receivepartner);
		System.out.println("receivepartner: " + receivepartner);
		Thread.sleep(1000);
		GenericUtils.selectDropdownOption(driver, receivepartner);
		/*
		String financialInstitutions = ExcelData.getData("CreateProject", 19, 2);
		cp.enterfinancialInstitutions(financialInstitutions);
		GenericUtils.selectDropdownOption(driver, financialInstitutions);
		String transactionMode = ExcelData.getData("CreateProject", 20, 2);
		cp.entertransactionMode(transactionMode);
		GenericUtils.selectDropdownOption(driver, transactionMode);
		*/
		String numberOfBotAccounts = ExcelData.getData("CreateProject", 6, 2);
		cp.enternumberOfBotAccounts(numberOfBotAccounts);
		String enternumberOfTestAccounts = ExcelData.getData("CreateProject", 7, 2);
		cp.enternumberOfTestAccounts(enternumberOfTestAccounts);
		String NumberOfOccurance =  ExcelData.getData("CreateProject", 14, 2);
		cp.EnterNumberOfOccurancy(NumberOfOccurance);
		actions.scrollByAmount(0, 700).perform();
		cp.ClickLaunchDate();
		Thread.sleep(2000);
		LocalDate currentDate = LocalDate.now();
		System.out.println(currentDate);
		int dayOfMonth = currentDate.getDayOfMonth();
        String formattedDay;
     // Use `dd` format if the day is a single digit, otherwise use `d`
        if (dayOfMonth < 10) {
            // Single-digit day: format with leading zero
            DateTimeFormatter twoDigitFormatter = DateTimeFormatter.ofPattern("d");
            formattedDay = currentDate.format(twoDigitFormatter);
        } else {
            // Two-digit day: format normally
            DateTimeFormatter singleDigitFormatter = DateTimeFormatter.ofPattern("dd");
            formattedDay = currentDate.format(singleDigitFormatter);
        }
		//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd");
        //String dayofMonth = currentDate.format(formattedDay);
        System.out.println("Day of Month: " + formattedDay);
		String lanuchday = "(//span[text()='"+formattedDay+"'])[1]";
		driver.findElement(By.xpath(lanuchday)).click();
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
		String expected_projectname = title;
		System.out.println("expected_projectname: " + expected_projectname);
		String actual_projectname = driver.findElement(By.xpath("//td[@data-cy='0_projectTitle']")).getText();
		System.out.println("actual_projectname: " + actual_projectname);
		String expected_scenario = "B2P";
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
		actions.scrollByAmount(0, -800).perform();
		cp.clickonTestprojecttableoption();
		Thread.sleep(20000);
		cp.clickonprojecttableoptionView();
		Thread.sleep(20000);
		driver.findElement(By.xpath("(//a[normalize-space()='Central Payments L.L.C'])[1]")).click();
		Thread.sleep(50000);
		driver.navigate().refresh();
		WebElement projectstatus = cp.getText_projectstatus();
		WaitUtils.fluentWait_VisibilityOfElement(projectstatus);
		String status = projectstatus.getText();
		 // Perform actions based on status
        if (status.equals("Ongoing")) {
            // Click on the "Option" button
            cp.clickon_projecttableFirtOption();
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
            String expectedTitle = "Success";
            String result = resultElement.getText();
            if (result.equals("Pass")) {
                System.out.println("Project Success!");
                cp.clickon_projecttableFirtOption();
                Thread.sleep(2000);
                cp.clickonbatchViewDetails();
	            Thread.sleep(2000);
	            String Successresponcemessage = cp.getresponse();
	            System.out.println("Successresponcemessage: " + Successresponcemessage);
	            cp.clickonCloseicon();
            } else {
                System.out.println("Project failed!");
                cp.clickon_projecttableFirtOption();
                Thread.sleep(2000);
                cp.clickonbatchViewDetails();
	            Thread.sleep(2000);
	            String Failedresponcemessage = cp.getresponse();
	            System.out.println("Failedresponcemessage: " + Failedresponcemessage);
	            cp.clickonCloseicon();
            }
            sa.assertEquals(result, expectedTitle);
        } else {
            System.out.println("Unknown status: " + status);
        }
		
		sa.assertAll();
		
		
	}

	@Test(priority=4)
	public void CPMWeekly_P2BTransaction() throws InterruptedException, EncryptedDocumentException, IOException
	{
		CreateProject cp = new CreateProject(driver);
		cp.clickOnProject();
		String TestProjectsHeader = driver.findElement(By.xpath("//a[text()='Testing Projects']")).getText();
		System.out.println("TestProjectsHeader:" + TestProjectsHeader);
		cp.ClickOnCreateProject();
		String title = ExcelData.getData("CreateProject", 58, 2);
		cp.Enter_ProjectTitle(title);
		System.out.println("Title: " + title);
		String description =  ExcelData.getData("CreateProject", 59, 2);
		cp.Enter_ProjectDescription(description);
		System.out.println("Description: " + description);
		Thread.sleep(1000);
		cp.ClickOnCreateNewTest();
		Actions actions = new Actions(driver);
		actions.scrollByAmount(0, 900).perform();
		cp.ClickOnInstrumentBank();
		cp.ClickOnCPM();
		actions.scrollByAmount(0, 700).perform();
		cp.ClickOnclearindicator();
		cp.click_TansactionTypearrowdropdown();
		cp.click_transactionP2B();
		Thread.sleep(1000);
		String sourcecountry = ExcelData.getData("CreateProject", 2, 2);
		cp.entersourcecounrty(sourcecountry);
		GenericUtils.selectDropdownOption(driver, sourcecountry);
		System.out.println("sourcecountry: " + sourcecountry);
		String destinationcountry = ExcelData.getData("CreateProject", 1, 2);
		cp.enterdestinationCountry(destinationcountry);
		GenericUtils.selectDropdownOption(driver, destinationcountry);
		System.out.println("destinationcountry: " + destinationcountry);
		String receivepartner = ExcelData.getData("CreateProject", 53, 2);
		cp.enterreceivepartner(receivepartner);
		System.out.println("receivepartner: " + receivepartner);
		Thread.sleep(1000);
		GenericUtils.selectDropdownOption(driver, receivepartner);
		/*
		String financialInstitutions = ExcelData.getData("CreateProject", 19, 2);
		cp.enterfinancialInstitutions(financialInstitutions);
		GenericUtils.selectDropdownOption(driver, financialInstitutions);
		String transactionMode = ExcelData.getData("CreateProject", 20, 2);
		cp.entertransactionMode(transactionMode);
		GenericUtils.selectDropdownOption(driver, transactionMode);
		*/
		String numberOfBotAccounts = ExcelData.getData("CreateProject", 6, 2);
		cp.enternumberOfBotAccounts(numberOfBotAccounts);
		String enternumberOfTestAccounts = ExcelData.getData("CreateProject", 7, 2);
		cp.enternumberOfTestAccounts(enternumberOfTestAccounts);
		String NumberOfOccurance =  ExcelData.getData("CreateProject", 14, 2);
		cp.EnterNumberOfOccurancy(NumberOfOccurance);
		actions.scrollByAmount(0, 700).perform();
		cp.ClickLaunchDate();
		Thread.sleep(2000);
		LocalDate currentDate = LocalDate.now();
		System.out.println(currentDate);
		int dayOfMonth = currentDate.getDayOfMonth();
        String formattedDay;
     // Use `dd` format if the day is a single digit, otherwise use `d`
        if (dayOfMonth < 10) {
            // Single-digit day: format with leading zero
            DateTimeFormatter twoDigitFormatter = DateTimeFormatter.ofPattern("d");
            formattedDay = currentDate.format(twoDigitFormatter);
        } else {
            // Two-digit day: format normally
            DateTimeFormatter singleDigitFormatter = DateTimeFormatter.ofPattern("dd");
            formattedDay = currentDate.format(singleDigitFormatter);
        }
		//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd");
        //String dayofMonth = currentDate.format(formattedDay);
        System.out.println("Day of Month: " + formattedDay);
		String lanuchday = "(//span[text()='"+formattedDay+"'])[1]";
		driver.findElement(By.xpath(lanuchday)).click();
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
		String expected_projectname = title;
		System.out.println("expected_projectname: " + expected_projectname);
		String actual_projectname = driver.findElement(By.xpath("//td[@data-cy='0_projectTitle']")).getText();
		System.out.println("actual_projectname: " + actual_projectname);
		String expected_scenario = "P2B";
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
		actions.scrollByAmount(0, -800).perform();
		cp.clickonTestprojecttableoption();
		Thread.sleep(20000);
		cp.clickonprojecttableoptionView();
		Thread.sleep(20000);
		driver.findElement(By.xpath("(//a[normalize-space()='Central Payments L.L.C'])[1]")).click();
		Thread.sleep(50000);
		driver.navigate().refresh();
		WebElement projectstatus = cp.getText_projectstatus();
		WaitUtils.fluentWait_VisibilityOfElement(projectstatus);
		String status = projectstatus.getText();
		 // Perform actions based on status
        if (status.equals("Ongoing")) {
            // Click on the "Option" button
            cp.clickon_projecttableFirtOption();
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
            String expectedTitle = "Success";
            String result = resultElement.getText();
            if (result.equals("Pass")) {
                System.out.println("Project Success!");
                cp.clickon_projecttableFirtOption();
                Thread.sleep(2000);
                cp.clickonbatchViewDetails();
	            Thread.sleep(2000);
	            String Successresponcemessage = cp.getresponse();
	            System.out.println("Successresponcemessage: " + Successresponcemessage);
	            cp.clickonCloseicon();
            } else {
                System.out.println("Project failed!");
                cp.clickon_projecttableFirtOption();
                Thread.sleep(2000);
                cp.clickonbatchViewDetails();
	            Thread.sleep(2000);
	            String Failedresponcemessage = cp.getresponse();
	            System.out.println("Failedresponcemessage: " + Failedresponcemessage);
	            cp.clickonCloseicon();
            }
            sa.assertEquals(result, expectedTitle);
        } else {
            System.out.println("Unknown status: " + status);
        }
		
		sa.assertAll();
		
		
	}
	
	@Test(priority=5)
	public void CPMWeekly_P2PTransaction() throws InterruptedException, EncryptedDocumentException, IOException
	{
		CreateProject cp = new CreateProject(driver);
		cp.clickOnProject();
		String TestProjectsHeader = driver.findElement(By.xpath("//a[text()='Testing Projects']")).getText();
		System.out.println("TestProjectsHeader:" + TestProjectsHeader);
		cp.ClickOnCreateProject();
		String title = ExcelData.getData("CreateProject", 60, 2);
		cp.Enter_ProjectTitle(title);
		System.out.println("Title: " + title);
		String description =  ExcelData.getData("CreateProject", 61, 2);
		cp.Enter_ProjectDescription(description);
		System.out.println("Description: " + description);
		Thread.sleep(1000);
		cp.ClickOnCreateNewTest();
		Actions actions = new Actions(driver);
		actions.scrollByAmount(0, 900).perform();
		cp.ClickOnInstrumentBank();
		cp.ClickOnCPM();
		actions.scrollByAmount(0, 700).perform();
		cp.ClickOnclearindicator();
		cp.click_TansactionTypearrowdropdown();
		cp.click_transactionp2p();
		Thread.sleep(1000);
		String sourcecountry = ExcelData.getData("CreateProject", 2, 2);
		cp.entersourcecounrty(sourcecountry);
		GenericUtils.selectDropdownOption(driver, sourcecountry);
		System.out.println("sourcecountry: " + sourcecountry);
		String destinationcountry = ExcelData.getData("CreateProject", 1, 2);
		cp.enterdestinationCountry(destinationcountry);
		GenericUtils.selectDropdownOption(driver, destinationcountry);
		System.out.println("destinationcountry: " + destinationcountry);
		String receivepartner = ExcelData.getData("CreateProject", 53, 2);
		cp.enterreceivepartner(receivepartner);
		System.out.println("receivepartner: " + receivepartner);
		Thread.sleep(1000);
		GenericUtils.selectDropdownOption(driver, receivepartner);
		/*
		String financialInstitutions = ExcelData.getData("CreateProject", 19, 2);
		cp.enterfinancialInstitutions(financialInstitutions);
		GenericUtils.selectDropdownOption(driver, financialInstitutions);
		String transactionMode = ExcelData.getData("CreateProject", 20, 2);
		cp.entertransactionMode(transactionMode);
		GenericUtils.selectDropdownOption(driver, transactionMode);
		*/
		String numberOfBotAccounts = ExcelData.getData("CreateProject", 6, 2);
		cp.enternumberOfBotAccounts(numberOfBotAccounts);
		String enternumberOfTestAccounts = ExcelData.getData("CreateProject", 7, 2);
		cp.enternumberOfTestAccounts(enternumberOfTestAccounts);
		String NumberOfOccurance =  ExcelData.getData("CreateProject", 14, 2);
		cp.EnterNumberOfOccurancy(NumberOfOccurance);
		actions.scrollByAmount(0, 700).perform();
		cp.ClickLaunchDate();
		Thread.sleep(2000);
		LocalDate currentDate = LocalDate.now();
		System.out.println(currentDate);
		int dayOfMonth = currentDate.getDayOfMonth();
        String formattedDay;
     // Use `dd` format if the day is a single digit, otherwise use `d`
        if (dayOfMonth < 10) {
            // Single-digit day: format with leading zero
            DateTimeFormatter twoDigitFormatter = DateTimeFormatter.ofPattern("d");
            formattedDay = currentDate.format(twoDigitFormatter);
        } else {
            // Two-digit day: format normally
            DateTimeFormatter singleDigitFormatter = DateTimeFormatter.ofPattern("dd");
            formattedDay = currentDate.format(singleDigitFormatter);
        }
		//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd");
        //String dayofMonth = currentDate.format(formattedDay);
        System.out.println("Day of Month: " + formattedDay);
		String lanuchday = "(//span[text()='"+formattedDay+"'])[1]";
		driver.findElement(By.xpath(lanuchday)).click();
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
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actual_projectname, expected_projectname);
		sa.assertEquals(actual_scenario, expected_scenario);
		sa.assertEquals(actual_projectID, expectedprojectID);
		actions.scrollByAmount(0, -800).perform();
		cp.clickonTestprojecttableoption();
		Thread.sleep(20000);
		cp.clickonprojecttableoptionView();
		Thread.sleep(20000);
		driver.findElement(By.xpath("(//a[normalize-space()='Central Payments L.L.C'])[1]")).click();
		Thread.sleep(50000);
		driver.navigate().refresh();
		WebElement projectstatus = cp.getText_projectstatus();
		WaitUtils.fluentWait_VisibilityOfElement(projectstatus);
		String status = projectstatus.getText();
		 // Perform actions based on status
        if (status.equals("Ongoing")) {
            // Click on the "Option" button
            cp.clickon_projecttableFirtOption();
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
            String expectedTitle = "Success";
            String result = resultElement.getText();
            if (result.equals("Pass")) {
                System.out.println("Project Success!");
                cp.clickon_projecttableFirtOption();
                Thread.sleep(2000);
                cp.clickonbatchViewDetails();
	            Thread.sleep(2000);
	            String Successresponcemessage = cp.getresponse();
	            System.out.println("Successresponcemessage: " + Successresponcemessage);
	            cp.clickonCloseicon();
            } else {
                System.out.println("Project failed!");
                cp.clickon_projecttableFirtOption();
                Thread.sleep(2000);
                cp.clickonbatchViewDetails();
	            Thread.sleep(2000);
	            String Failedresponcemessage = cp.getresponse();
	            System.out.println("Failedresponcemessage: " + Failedresponcemessage);
	            cp.clickonCloseicon();
            }
            sa.assertEquals(result, expectedTitle);
        } else {
            System.out.println("Unknown status: " + status);
        }
		
		sa.assertAll();
		
		
	}
	
}
