package test.Projects;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

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

public class CreateProject_PilotWalletP2PIncorrectNumb extends BaseTest {
	
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
	public void Verify_projectTitle() throws InterruptedException, EncryptedDocumentException, IOException {
		CreateProject cp = new CreateProject(driver);
		String Enteronlyalphabets = RandomStringUtils.randomAlphabetic(10);
		System.out.println("Enteronlyalphabets: " + Enteronlyalphabets);
		cp.Enter_ProjectTitle(Enteronlyalphabets);
		cp.Clear_ProjectTitle(Enteronlyalphabets);
		Thread.sleep(1000);
		String EnteronlyNumber = RandomStringUtils.randomNumeric(8);
		System.out.println("EnteronlyNumber: " + EnteronlyNumber);
		cp.Enter_ProjectTitle(EnteronlyNumber);
		cp.Clear_ProjectTitle(EnteronlyNumber);
		Thread.sleep(1000);
		String EnteronlySpecialChar = ExcelData.getData("projects", 2, 2);
		cp.Enter_ProjectTitle(EnteronlySpecialChar);
		System.out.println("EnteronlySpecialChar: " + EnteronlySpecialChar);
		cp.Clear_ProjectTitle(EnteronlySpecialChar);
		cp.Clear_ProjectTitle(EnteronlySpecialChar);
		Thread.sleep(1000);
		String Enteralphanumeric = ExcelData.getData("projects", 28, 2);
		System.out.println("Enteralphanumeric: " + Enteralphanumeric);
		cp.Enter_ProjectTitle(Enteralphanumeric);
		cp.Clear_ProjectTitle(Enteralphanumeric);
		String ActualclearTitleErrorMsg = cp.ProjectTitleFieldReq();
		System.out.println("ActualclearTitleErrorMsg: " + ActualclearTitleErrorMsg);
		String ExpecetdclearTitleErrorMsg = ExcelData.getData("projects", 3, 2);
		System.out.println("ExpecetdclearTitleErrorMsg: " + ExpecetdclearTitleErrorMsg);
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(ActualclearTitleErrorMsg, ExpecetdclearTitleErrorMsg);
		sa.assertAll();
	}

	@Test(priority = 2)
	public void Verify_projectDescription() throws InterruptedException, EncryptedDocumentException, IOException {
		CreateProject cp = new CreateProject(driver);
		String Enteronlyalphabets = RandomStringUtils.randomAlphabetic(10);
		System.out.println("Enteronlyalphabets: " + Enteronlyalphabets);
		cp.Enter_ProjectDescription(Enteronlyalphabets);
		cp.Clear_ProjectDescription(Enteronlyalphabets);
		Thread.sleep(1000);
		String EnteronlyNumber = RandomStringUtils.randomNumeric(8);
		System.out.println("EnteronlyNumber: " + EnteronlyNumber);
		cp.Enter_ProjectDescription(EnteronlyNumber);
		cp.Clear_ProjectDescription(EnteronlyNumber);
		Thread.sleep(1000);
		String EnteronlySpecialChar = ExcelData.getData("projects", 2, 2);
		cp.Enter_ProjectDescription(EnteronlySpecialChar);
		System.out.println("EnteronlySpecialChar: " + EnteronlySpecialChar);
		cp.Clear_ProjectDescription(EnteronlySpecialChar);
		Thread.sleep(1000);
		/*
		String ActualclearTitleErrorMsg = cp.ProjectTitleFieldReq();
		System.out.println("ActualclearTitleErrorMsg: " + ActualclearTitleErrorMsg);
		String ExpecetdclearTitleErrorMsg = ExcelData.getData("projects", 3, 2);
		System.out.println("ExpecetdclearTitleErrorMsg: " + ExpecetdclearTitleErrorMsg);
	    */
	}

	@Test(priority = 3)
	public void Verify_Testsetup() throws InterruptedException, EncryptedDocumentException, IOException {
		CreateProject cp = new CreateProject(driver);
		cp.ClickOnCreateNewTest();
		Thread.sleep(1000);
		String ActualWallet = driver.findElement(By.xpath("//input[@id='instrument_WALLET']")).getAttribute("Value");
		System.out.println("ActualWallet: " + ActualWallet);
		String Expectedwallet = ExcelData.getData("projects", 4, 2);
		System.out.println("Expectedwallet: " + Expectedwallet);
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(ActualWallet, Expectedwallet);
		Thread.sleep(1000);
		String ActualBank = driver.findElement(By.xpath("//input[@id='instrument_BANK']")).getAttribute("Value");
		System.out.println("ActualBank: " + ActualBank);
		String ExpectedBank = ExcelData.getData("projects", 5, 2);
		System.out.println("ExpectedBank: " + ExpectedBank);
		Thread.sleep(1000);
		cp.ClickOnUseExisiting();
		Thread.sleep(1000);
		String ActualTestDetails = driver.findElement(By.xpath("//h2[normalize-space()='Test Details']")).getText();
		System.out.println("ActualTestDetails: " + ActualTestDetails);
		String ExpectedTestDetails = ExcelData.getData("projects", 6, 2);
		System.out.println("ExpectedTestDetails: " + ExpectedTestDetails);
		sa.assertEquals(ActualTestDetails, ExpectedTestDetails);
		sa.assertAll();

	}

	@Test(priority = 4)
	public void Verify_TransactionTypes() throws EncryptedDocumentException, IOException, InterruptedException {
		CreateProject cp = new CreateProject(driver);
		String Enteronlyalphabets = RandomStringUtils.randomAlphabetic(10);
		cp.Enter_ProjectTitle(Enteronlyalphabets);
		cp.Enter_ProjectDescription(Enteronlyalphabets);
		cp.ClickOnCreateNewTest();
		cp.ClickOnInstrumentBank();
		Actions actions = new Actions(driver);
		actions.scrollByAmount(0, 700).perform();
		cp.ClickOnclearindicator();
		cp.click_TansactionTypearrowdropdown();
		cp.click_transactionB2B();
		cp.Clearmultitransaction();
		cp.click_TansactionTypearrowdropdown();
		Thread.sleep(1000);
		List<WebElement> dropdownElement = driver.findElements(
				By.xpath("//div[@class='react-select__menu-list react-select__menu-list--is-multi css-qr46ko']"));

		for (WebElement alltransaction : dropdownElement) {
			String Actualtransaction = alltransaction.getText();
			System.out.println("Actualtransactiondropdown: " + Actualtransaction );
			String ExpectedTransactiondropdown = ExcelData.getData("projects", 8, 2);
			System.out.println("ExpectedTransactiondropdown: " + ExpectedTransactiondropdown);
			SoftAssert sa = new SoftAssert();
			sa.assertEquals(Actualtransaction, ExpectedTransactiondropdown);
			sa.assertAll();
		}
		Thread.sleep(1000);
		cp.enterTansactionType(Enteronlyalphabets);
		String Transactionnooption = "No options";
		System.out.println("Transactionnooption: " + Transactionnooption);
		String Nooption = driver
				.findElement(By.xpath(
						"//div[@class='react-select__menu-notice react-select__menu-notice--no-options css-1t1x6cd']"))
				.getText();
		System.out.println("expectednooption: " + Nooption);
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(Transactionnooption, Nooption);
		cp.clearTansactionType(Enteronlyalphabets);
		Thread.sleep(1000);
		cp.click_transactionp2p();
		cp.click_TansactionTypearrowdropdown();
		cp.click_transactionP2B();
		cp.click_TansactionTypearrowdropdown();
		cp.click_transactionB2P();
		cp.click_TansactionTypearrowdropdown();
		cp.click_transactionB2B();
		Thread.sleep(1000);
		sa.assertAll();

	}

	@Test(priority = 5)
	public void Verify_TestDetails_Instrument() throws EncryptedDocumentException, IOException, InterruptedException {
		// basic details enter to continue
		CreateProject cp = new CreateProject(driver);
		String Enteronlyalphabets = RandomStringUtils.randomAlphabetic(10);
		cp.Enter_ProjectTitle(Enteronlyalphabets);
		cp.Enter_ProjectDescription(Enteronlyalphabets);
		cp.ClickOnCreateNewTest();
		// verify wallet instrument
		cp.ClickOnInstrumentWallet();
		System.out.println("Selected Instrument Wallet");
		String walletincorrectnumber = driver
				.findElement(By.xpath("//label[normalize-space()='Incorrect mobile number']")).getText();
		System.out.println(" walletincorrectnumber: " + walletincorrectnumber);
		String Expectedtincorrectnumber = ExcelData.getData("projects", 7, 2);
		System.out.println(" Expectedtincorrectnumber: " + Expectedtincorrectnumber);
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(walletincorrectnumber, Expectedtincorrectnumber);
		// verify Bank instrument
		cp.ClickOnInstrumentBank();
		System.out.println("Selected Instrument Bank");
		Thread.sleep(1000);
		List<WebElement> listofnegativescenario = driver.findElements(By.xpath(
				"//legend[normalize-space()='Negative Scenarios']/following-sibling::div[@class='  form-check']"));
		for (WebElement listofscenario : listofnegativescenario)
			System.out.println("listofnegativescenario: " + listofscenario.getText());
		Thread.sleep(1000);
		sa.assertAll();
	}

	@Test(priority = 6)
	public void Verify_NegativeScenario() throws InterruptedException, EncryptedDocumentException, IOException {
		// basic details enter to continue
		CreateProject cp = new CreateProject(driver);
		String Enteronlyalphabets = RandomStringUtils.randomAlphabetic(10);
		cp.Enter_ProjectTitle(Enteronlyalphabets);
		cp.Enter_ProjectDescription(Enteronlyalphabets);
		cp.ClickOnCreateNewTest();
		// verify Bank instrument
		cp.ClickOnInstrumentBank();
		Thread.sleep(1000);
		Actions actions = new Actions(driver);
		actions.scrollByAmount(0, 700).perform();
		List<WebElement> listofnegativescenario = driver
				.findElements(By.xpath("//legend[normalize-space()='Negative Scenarios']/ancestor::div[@class='col']"));
		for (WebElement listofscenario : listofnegativescenario) {
			String ActuallistofnegativeScenario = listofscenario.getText();
			System.out.println("ActuallistofnegativeScenario: " + ActuallistofnegativeScenario);
			String ExpectedlistofnegativeScenario = ExcelData.getData("projects", 9, 2);
			System.out.println("ExpectedlistofnegativeScenario: " + ExpectedlistofnegativeScenario);
			SoftAssert sa = new SoftAssert();
			sa.assertEquals(ActuallistofnegativeScenario, ExpectedlistofnegativeScenario);
			sa.assertAll();
		}
		Thread.sleep(1000);
		cp.click_INCORRECT_MOBILE();
		cp.click_Incorrectname();
		cp.click_Incorrectaccount();
		Thread.sleep(1000);
		cp.deselect_INCORRECT_MOBILE();
		cp.deselect_Incorrectaccount();
		cp.deselect_Incorrectname();
		Thread.sleep(1000);

	}

	@Test(priority = 7)
	public void Verify_Sourcecountry() throws InterruptedException, EncryptedDocumentException, IOException {
		// basic details enter to continue
		CreateProject cp = new CreateProject(driver);
		String Enteronlyalphabets = RandomStringUtils.randomAlphabetic(10);
		cp.Enter_ProjectTitle(Enteronlyalphabets);
		cp.Enter_ProjectDescription(Enteronlyalphabets);
		cp.ClickOnCreateNewTest();
		// verify Bank instrument
		cp.ClickOnInstrumentBank();
		Thread.sleep(1000);
		String Actualsourcecountry = ExcelData.getData("projects", 10, 2);
		cp.entersourcecounrty(Actualsourcecountry);
		GenericUtils.selectDropdownOption(driver, Actualsourcecountry);
		cp.clearsourcecounrty();
		Thread.sleep(1000);
		String sourcecountrytwo = ExcelData.getData("projects", 11, 2);
		cp.entersourcecounrty(sourcecountrytwo);
		GenericUtils.selectDropdownOption(driver, sourcecountrytwo);
		cp.clearsourcecounrty();
		String sourcecountrythree = ExcelData.getData("projects", 12, 2);
		cp.entersourcecounrty(sourcecountrythree);
		GenericUtils.selectDropdownOption(driver, sourcecountrythree);
		cp.clearsourcecounrty();
		cp.entersourcecounrty(sourcecountrythree);
		GenericUtils.selectDropdownOption(driver, sourcecountrythree);
		Thread.sleep(2000);
		cp.clearsourcecounrty();
		cp.entersourcecounrty(Actualsourcecountry);
		String sourcecountry = cp.getsourcecounrty();
		System.out.println("Actualsourcecountry: " + sourcecountry);
		String expectedsoucountry = Actualsourcecountry;
		System.out.println("expectedsourcecountry: " + expectedsoucountry);
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(sourcecountry, expectedsoucountry);
		cp.clearsourcecounrty();
		String invalidinput = ExcelData.getData("projects", 1, 2);
		cp.entersourcecounrty(invalidinput);
		String actualnooption = "No options";
		System.out.println("Actualsourcecountry: " + actualnooption);
		String Nooption = driver
				.findElement(By.xpath(
						"//div[@class='react-select__menu-notice react-select__menu-notice--no-options css-1t1x6cd']"))
				.getText();
		System.out.println("expectedsourcecountry: " + Nooption);
		sa.assertEquals(actualnooption, Nooption);
		sa.assertAll();
	}

	@Test(priority = 8)
	public void Verify_Destinationcountry() throws InterruptedException, EncryptedDocumentException, IOException {
		// basic details enter to continue
		CreateProject cp = new CreateProject(driver);
		String Enteronlyalphabets = RandomStringUtils.randomAlphabetic(10);
		cp.Enter_ProjectTitle(Enteronlyalphabets);
		cp.Enter_ProjectDescription(Enteronlyalphabets);
		cp.ClickOnCreateNewTest();
		// verify Bank instrument
		cp.ClickOnInstrumentBank();
		Thread.sleep(1000);
		String ActualDestinationcountry = ExcelData.getData("projects", 10, 2);
		cp.enterdestinationCountry(ActualDestinationcountry);
		GenericUtils.selectDropdownOption(driver, ActualDestinationcountry);
		cp.cleardestinationcounrty();
		Thread.sleep(1000);
		String Destinationcountry = ExcelData.getData("projects", 11, 2);
		cp.enterdestinationCountry(Destinationcountry);
		GenericUtils.selectDropdownOption(driver, Destinationcountry);
		cp.cleardestinationcounrty();
		String sourcecountrythree = ExcelData.getData("projects", 12, 2);
		cp.enterdestinationCountry(sourcecountrythree);
		GenericUtils.selectDropdownOption(driver, sourcecountrythree);
		cp.cleardestinationcounrty();
		cp.enterdestinationCountry(sourcecountrythree);
		GenericUtils.selectDropdownOption(driver, sourcecountrythree);
		Thread.sleep(2000);
		cp.cleardestinationcounrty();
		cp.enterdestinationCountry(ActualDestinationcountry);
		String destinationCountry = cp.getdestination();
		System.out.println("Actualsourcecountry: " + destinationCountry);
		String expectedsoucountry = ActualDestinationcountry;
		System.out.println("expectedsourcecountry: " + expectedsoucountry);
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(destinationCountry, expectedsoucountry);
		cp.cleardestinationcounrty();
		String invalidinput = ExcelData.getData("projects", 1, 2);
		cp.enterdestinationCountry(invalidinput);
		String actualnooption = "No options";
		System.out.println("Actualsourcecountry: " + actualnooption);
		String Nooption = driver
				.findElement(By.xpath(
						"//div[@class='react-select__menu-notice react-select__menu-notice--no-options css-1t1x6cd']"))
				.getText();
		System.out.println("expectedsourcecountry: " + Nooption);
		sa.assertEquals(actualnooption, Nooption);
		sa.assertAll();
	}

	@Test(priority = 9)
	public void verify_SwapCountry() throws EncryptedDocumentException, IOException, InterruptedException {

		// basic details enter to continue
				CreateProject cp = new CreateProject(driver);
				String Enteronlyalphabets = RandomStringUtils.randomAlphabetic(10);
				cp.Enter_ProjectTitle(Enteronlyalphabets);
				cp.Enter_ProjectDescription(Enteronlyalphabets);
				cp.ClickOnCreateNewTest();
				// verify Bank instrument
				cp.ClickOnInstrumentBank();
				String expectedsourcecountry = ExcelData.getData("projects", 10, 2);
				System.out.println("beforeswapsourcecountry: " + expectedsourcecountry);
				cp.entersourcecounrty(expectedsourcecountry);
				GenericUtils.selectDropdownOption(driver, expectedsourcecountry);
				SoftAssert sa = new SoftAssert();
				String expectedDestinationcountry = ExcelData.getData("projects", 11, 2);
				System.out.println("beforeswapDestinationcountry: " + expectedDestinationcountry);
				cp.enterdestinationCountry(expectedDestinationcountry);
				GenericUtils.selectDropdownOption(driver, expectedDestinationcountry);
				Thread.sleep(1000);
				// swap country
				cp.SwapCountry();
				System.out.println("Clicking on Swap Button");
				Thread.sleep(2000);
				String actualsourceswap = cp.getswapsourcecounrty();
				System.out.println("actualsourceswap: " + actualsourceswap);
				String excpectedsourceswap = ExcelData.getData("projects", 11, 2);
				System.out.println("excpectedsourceswap: " + excpectedsourceswap);
				sa.assertEquals(actualsourceswap, excpectedsourceswap);
				String actualdestinationswap = cp. getswapdestination();
				System.out.println("actualdestinationswap: " + actualdestinationswap);
				String excpectedestinationswap = ExcelData.getData("projects", 10, 2);
				System.out.println("excpectedestinationswap: " + excpectedestinationswap);
				sa.assertEquals(actualdestinationswap, excpectedestinationswap);
		        sa.assertAll();
	}

	@Test(priority = 10)
	public void verify_Defaultcurrency() throws EncryptedDocumentException, IOException, InterruptedException {
		CreateProject cp = new CreateProject(driver);
		String Enteronlyalphabets = RandomStringUtils.randomAlphabetic(10);
		cp.Enter_ProjectTitle(Enteronlyalphabets);
		cp.Enter_ProjectDescription(Enteronlyalphabets);
		cp.ClickOnCreateNewTest();
		// verify Bank instrument
		cp.ClickOnInstrumentBank();
		String expectedsourcecountry = ExcelData.getData("projects", 10, 2);
		System.out.println("expectedsourcecountry: " + expectedsourcecountry);
		cp.entersourcecounrty(expectedsourcecountry);
		GenericUtils.selectDropdownOption(driver, expectedsourcecountry);
		SoftAssert sa = new SoftAssert();
		String expectedDestinationcountry = ExcelData.getData("projects", 11, 2);
		System.out.println("expectedDestinationcountry: " + expectedDestinationcountry);
		cp.enterdestinationCountry(expectedDestinationcountry);
		GenericUtils.selectDropdownOption(driver, expectedDestinationcountry);
		Thread.sleep(2000);
		String actualdefaultcurrency = cp.getcurrencycode();
		System.out.println("actualdefaultcurrency: " + actualdefaultcurrency);
		String expecteddefaultcurrency = ExcelData.getData("projects", 29, 2);
		System.out.println("expecteddefaultcurrency: " + expecteddefaultcurrency);
		sa.assertAll();
	}

	@Test(priority = 11)
	public void verify_AccountAssignmentandReciverPartner()
			throws EncryptedDocumentException, IOException, InterruptedException {
		// basic details enter to continue
		CreateProject cp = new CreateProject(driver);
		String Enteronlyalphabets = RandomStringUtils.randomAlphabetic(10);
		cp.Enter_ProjectTitle(Enteronlyalphabets);
		cp.Enter_ProjectDescription(Enteronlyalphabets);
		cp.ClickOnCreateNewTest();
		// verify Bank instrument
		cp.ClickOnInstrumentBank();
		String expectedsourcecountry = ExcelData.getData("projects", 11, 2);
		System.out.println("expectedsourcecountry: " + expectedsourcecountry);
		cp.entersourcecounrty(expectedsourcecountry);
		GenericUtils.selectDropdownOption(driver, expectedsourcecountry);
		SoftAssert sa = new SoftAssert();
		String expectedDestinationcountry = ExcelData.getData("projects", 10, 2);
		System.out.println("expectedDestinationcountry: " + expectedDestinationcountry);
		cp.enterdestinationCountry(expectedDestinationcountry);
		GenericUtils.selectDropdownOption(driver, expectedDestinationcountry);
		Thread.sleep(1000);
		cp.click_RandomAccount();
		Thread.sleep(1000);
		cp.click_existing();
		Thread.sleep(1000);
		cp.click_RandomAccount();
		Thread.sleep(1000);
		// Receiverpartner
		String Expectedreceivepartner = ExcelData.getData("projects", 13, 2);
		cp.enterreceivepartner(Expectedreceivepartner);
		System.out.println("Expectedreceivepartner: " + Expectedreceivepartner);
		Thread.sleep(1000);
		GenericUtils.selectDropdownOption(driver, Expectedreceivepartner);
		Thread.sleep(2000);
		String Actualreceivepartner = cp.receivepartnerHeader();
		System.out.println(" Actualreceivepartner: " + Actualreceivepartner);
		sa.assertEquals(Actualreceivepartner, Expectedreceivepartner);
		String expectedreceivepartnertwo = ExcelData.getData("projects", 14, 2);
		cp.enterreceivepartner(expectedreceivepartnertwo);
		System.out.println("expectedreceivepartnertwo : " + expectedreceivepartnertwo);
		Thread.sleep(1000);
		GenericUtils.selectDropdownOption(driver, expectedreceivepartnertwo);
		Thread.sleep(2000);
		String actualpartnerheadertwo = cp.receivepartnerHeader();
		System.out.println(" actualpartnerheadertwo: " + actualpartnerheadertwo);
		sa.assertEquals(actualpartnerheadertwo, expectedreceivepartnertwo);
		String invalidpartner = ExcelData.getData("projects", 2, 2);
		cp.enterreceivepartner(invalidpartner);
		String expecetdNooption = driver.findElement(By.xpath(
				"(//div[@class='react-select__menu-notice react-select__menu-notice--no-options css-1t1x6cd'])[1]"))
				.getText();
		System.out.println("expecetdNooption: " + expecetdNooption);
		String ActualNooption = ExcelData.getData("projects", 16, 2);
		System.out.println("ActualNooption: " + ActualNooption);
		sa.assertEquals(ActualNooption, expecetdNooption);
		Thread.sleep(1000);
		sa.assertAll();
	}

	@Test(priority = 12)
	public void verify_FinancialInstitution() throws EncryptedDocumentException, IOException, InterruptedException {
		// basic details enter to continue
		CreateProject cp = new CreateProject(driver);
		String Enteronlyalphabets = RandomStringUtils.randomAlphabetic(10);
		cp.Enter_ProjectTitle(Enteronlyalphabets);
		cp.Enter_ProjectDescription(Enteronlyalphabets);
		cp.ClickOnCreateNewTest();
		// verify Bank instrument
		cp.ClickOnInstrumentBank();
		String expectedsourcecountry = ExcelData.getData("projects", 11, 2);
		System.out.println("expectedsourcecountry: " + expectedsourcecountry);
		cp.entersourcecounrty(expectedsourcecountry);
		GenericUtils.selectDropdownOption(driver, expectedsourcecountry);
		SoftAssert sa = new SoftAssert();
		String expectedDestinationcountry = ExcelData.getData("projects", 10, 2);
		System.out.println("expectedDestinationcountry: " + expectedDestinationcountry);
		cp.enterdestinationCountry(expectedDestinationcountry);
		GenericUtils.selectDropdownOption(driver, expectedDestinationcountry);
		Thread.sleep(1000);
		cp.click_RandomAccount();
		Thread.sleep(1000);
		cp.click_existing();
		Thread.sleep(1000);
		cp.click_RandomAccount();
		Thread.sleep(1000);
		Actions actions = new Actions(driver);
		actions.scrollByAmount(0, 700).perform();
		// Receiverpartner
		String Expectedreceivepartner = ExcelData.getData("projects", 13, 2);
		cp.enterreceivepartner(Expectedreceivepartner);
		GenericUtils.selectDropdownOption(driver, Expectedreceivepartner);
		Thread.sleep(1000);
		// FinancialPartner
		String ExpecetdfinancialInstitutions = ExcelData.getData("projects", 17, 2);
		cp.enterfinancialInstitutions(ExpecetdfinancialInstitutions);
		GenericUtils.selectDropdownOption(driver, ExpecetdfinancialInstitutions);
		Thread.sleep(1000);
		System.out.println("ExpecetdfinancialInstitutions:" + ExpecetdfinancialInstitutions);
		String ActualfinancialInstitutions = driver.findElement(By.xpath(
				"//div[contains(@class,'react-select__multi-value__label css-9jq23d')][normalize-space()='ICICI BANK']"))
				.getText();
		System.out.println("ActualfinancialInstitutions: " + ActualfinancialInstitutions);
		sa.assertEquals(ActualfinancialInstitutions, ExpecetdfinancialInstitutions);
		Thread.sleep(1000);
		String ExpecetdfinancialInstitutionstwo = ExcelData.getData("projects", 18, 2);
		cp.enterfinancialInstitutions(ExpecetdfinancialInstitutionstwo);
		GenericUtils.selectDropdownOption(driver, ExpecetdfinancialInstitutionstwo);
		System.out.println("ExpecetdfinancialInstitutionstwo:" + ExpecetdfinancialInstitutionstwo);
		Thread.sleep(1000);
		String ActualfinancialInstitutionstwo = driver.findElement(By.xpath(
				"//div[contains(@class,'react-select__multi-value__label css-9jq23d')][normalize-space()='Kotak Mahindra Bank']"))
				.getText();
		System.out.println("ActualfinancialInstitutionstwo: " + ActualfinancialInstitutionstwo);
		sa.assertEquals(ActualfinancialInstitutionstwo, ExpecetdfinancialInstitutionstwo);
		Thread.sleep(2000);
		cp.ClearfinancialInstitutions();
		Thread.sleep(1000);
		// Selecting Again FinancialInstitution
		cp.enterfinancialInstitutions(ExpecetdfinancialInstitutions);
		GenericUtils.selectDropdownOption(driver, ExpecetdfinancialInstitutions);
		sa.assertAll();
	}

	@Test(priority = 13)
	public void verify_transactionmode() throws InterruptedException, EncryptedDocumentException, IOException {
		// basic details enter to continue
		CreateProject cp = new CreateProject(driver);
		String Enteronlyalphabets = RandomStringUtils.randomAlphabetic(10);
		cp.Enter_ProjectTitle(Enteronlyalphabets);
		cp.Enter_ProjectDescription(Enteronlyalphabets);
		cp.ClickOnCreateNewTest();
		// verify Bank instrument
		cp.ClickOnInstrumentBank();
		String expectedsourcecountry = ExcelData.getData("projects", 11, 2);
		System.out.println("expectedsourcecountry: " + expectedsourcecountry);
		cp.entersourcecounrty(expectedsourcecountry);
		GenericUtils.selectDropdownOption(driver, expectedsourcecountry);
		SoftAssert sa = new SoftAssert();
		String expectedDestinationcountry = ExcelData.getData("projects", 10, 2);
		System.out.println("expectedDestinationcountry: " + expectedDestinationcountry);
		cp.enterdestinationCountry(expectedDestinationcountry);
		GenericUtils.selectDropdownOption(driver, expectedDestinationcountry);
		Thread.sleep(1000);
		cp.click_RandomAccount();
		Thread.sleep(1000);
		cp.click_existing();
		Thread.sleep(1000);
		cp.click_RandomAccount();
		Thread.sleep(1000);
		Actions actions = new Actions(driver);
		actions.scrollByAmount(0, 700).perform();
		// Receiverpartner
		String Expectedreceivepartner = ExcelData.getData("projects", 13, 2);
		cp.enterreceivepartner(Expectedreceivepartner);
		GenericUtils.selectDropdownOption(driver, Expectedreceivepartner);
		Thread.sleep(1000);
		// FinancialPartner
		String ExpecetdfinancialInstitutions = ExcelData.getData("projects", 17, 2);
		cp.enterfinancialInstitutions(ExpecetdfinancialInstitutions);
		GenericUtils.selectDropdownOption(driver, ExpecetdfinancialInstitutions);
		Thread.sleep(1000);
		// TransactionMode
		String transactionMode = ExcelData.getData("projects", 19, 2);
		System.out.println("transactionMode: " + transactionMode);
		cp.entertransactionMode(transactionMode);
		GenericUtils.selectDropdownOption(driver, transactionMode);
		String expectedtransactiomode = cp.gettransactionMode();
		Thread.sleep(1000);
		System.out.println("expectedtransactiomode: " + expectedtransactiomode);
		sa.assertEquals(transactionMode, expectedtransactiomode);
		cp.cleartransactionMode();
		cp.entertransactionMode(transactionMode);
		GenericUtils.selectDropdownOption(driver, transactionMode);
		sa.assertAll();
	}

	@Test(priority = 14)
	public void verify_No_senderBots() throws InterruptedException, EncryptedDocumentException, IOException {
		// basic details enter to continue
		CreateProject cp = new CreateProject(driver);
		String Enteronlyalphabets = RandomStringUtils.randomAlphabetic(10);
		cp.Enter_ProjectTitle(Enteronlyalphabets);
		cp.Enter_ProjectDescription(Enteronlyalphabets);
		cp.ClickOnCreateNewTest();
		// verify Bank instrument
		cp.ClickOnInstrumentBank();
		String expectedsourcecountry = ExcelData.getData("projects", 11, 2);
		System.out.println("expectedsourcecountry: " + expectedsourcecountry);
		cp.entersourcecounrty(expectedsourcecountry);
		GenericUtils.selectDropdownOption(driver, expectedsourcecountry);
		SoftAssert sa = new SoftAssert();
		String expectedDestinationcountry = ExcelData.getData("projects", 10, 2);
		System.out.println("expectedDestinationcountry: " + expectedDestinationcountry);
		cp.enterdestinationCountry(expectedDestinationcountry);
		GenericUtils.selectDropdownOption(driver, expectedDestinationcountry);
		Thread.sleep(1000);
		cp.click_RandomAccount();
		Thread.sleep(1000);
		Actions actions = new Actions(driver);
		actions.scrollByAmount(0, 700).perform();
		// Receiverpartner
		String Expectedreceivepartner = ExcelData.getData("projects", 13, 2);
		cp.enterreceivepartner(Expectedreceivepartner);
		GenericUtils.selectDropdownOption(driver, Expectedreceivepartner);
		Thread.sleep(1000);
		// FinancialPartner
		String ExpecetdfinancialInstitutions = ExcelData.getData("projects", 17, 2);
		cp.enterfinancialInstitutions(ExpecetdfinancialInstitutions);
		GenericUtils.selectDropdownOption(driver, ExpecetdfinancialInstitutions);
		Thread.sleep(1000);
		// TransactionMode
		String transactionMode = ExcelData.getData("projects", 19, 2);
		System.out.println("transactionMode: " + transactionMode);
		cp.entertransactionMode(transactionMode);
		GenericUtils.selectDropdownOption(driver, transactionMode);
		// No of Sender Bots
		String Expecetdsenderbots = ExcelData.getData("projects", 20, 2);
		System.out.println("Expecetdsenderbots: " + Expecetdsenderbots);
		cp.enternumberOfBotAccounts(Expecetdsenderbots);
		cp.ClearnumberOfBotAccounts();
		Thread.sleep(1000);
		String EnterZero = ExcelData.getData("projects", 23, 2);
		System.out.println("Expecetdsenderbots: " + EnterZero);
		cp.enternumberOfBotAccounts(EnterZero);
		String actualerror = driver.findElement(By.xpath("//div[@class='invalid-feedback']")).getText();
		System.out.println("actualerror: " + actualerror);
		String expecetderror = "Number must be greater than or equal to 1";
		System.out.println("expecetderror: " + expecetderror);
		sa.assertAll();

	}

	@Test(priority = 15)
	public void verify_Norecipientaccount() throws EncryptedDocumentException, IOException, InterruptedException {
		// basic details enter to continue
		CreateProject cp = new CreateProject(driver);
		String Enteronlyalphabets = RandomStringUtils.randomAlphabetic(10);
		cp.Enter_ProjectTitle(Enteronlyalphabets);
		cp.Enter_ProjectDescription(Enteronlyalphabets);
		cp.ClickOnCreateNewTest();
		// verify Bank instrument
		cp.ClickOnInstrumentBank();
		String expectedsourcecountry = ExcelData.getData("projects", 11, 2);
		System.out.println("expectedsourcecountry: " + expectedsourcecountry);
		cp.entersourcecounrty(expectedsourcecountry);
		GenericUtils.selectDropdownOption(driver, expectedsourcecountry);
		SoftAssert sa = new SoftAssert();
		String expectedDestinationcountry = ExcelData.getData("projects", 10, 2);
		System.out.println("expectedDestinationcountry: " + expectedDestinationcountry);
		cp.enterdestinationCountry(expectedDestinationcountry);
		GenericUtils.selectDropdownOption(driver, expectedDestinationcountry);
		Thread.sleep(1000);
		cp.click_RandomAccount();
		Thread.sleep(1000);
		Actions actions = new Actions(driver);
		actions.scrollByAmount(0, 700).perform();
		// Receiverpartner
		String Expectedreceivepartner = ExcelData.getData("projects", 13, 2);
		cp.enterreceivepartner(Expectedreceivepartner);
		GenericUtils.selectDropdownOption(driver, Expectedreceivepartner);
		Thread.sleep(1000);
		// FinancialPartner
		String ExpecetdfinancialInstitutions = ExcelData.getData("projects", 17, 2);
		cp.enterfinancialInstitutions(ExpecetdfinancialInstitutions);
		GenericUtils.selectDropdownOption(driver, ExpecetdfinancialInstitutions);
		Thread.sleep(1000);
		// TransactionMode
		String transactionMode = ExcelData.getData("projects", 19, 2);
		System.out.println("transactionMode: " + transactionMode);
		cp.entertransactionMode(transactionMode);
		GenericUtils.selectDropdownOption(driver, transactionMode);
		// No of Sender Bots
		String Expecetdsenderbots = ExcelData.getData("projects", 20, 2);
		System.out.println("Expecetdsenderbots: " + Expecetdsenderbots);
		cp.enternumberOfBotAccounts(Expecetdsenderbots);
		Thread.sleep(1000);
		// No of Recipient Bots
		String ExpectedREcipientBots = ExcelData.getData("projects", 20, 2);
		cp.enternumberOfTestAccounts(ExpectedREcipientBots);
		System.out.println("ExpectedREcipientBots: " + ExpectedREcipientBots);
		cp.ClearnumberOfTestAccounts();
		cp.enternumberOfTestAccounts(ExpectedREcipientBots);
		Thread.sleep(1000);
		cp.ClearnumberOfTestAccounts();
		String EnterZero = ExcelData.getData("projects", 23, 2);
		System.out.println("Expecetdsenderbots: " + EnterZero);
		cp.enternumberOfTestAccounts(EnterZero);
		String actualerror = driver.findElement(By.xpath("//div[@class='invalid-feedback']")).getText();
		System.out.println("actualerror: " + actualerror);
		String expecetderror = "Number must be greater than or equal to 1";
		System.out.println("expecetderror: " + expecetderror);
		sa.assertAll();
	}

	@Test(priority = 16)
	public void verify_SaveEditLanuch_WalletP2PIncorrectNumb() throws EncryptedDocumentException, IOException, InterruptedException {
		// basic details enter to continue
		CreateProject cp = new CreateProject(driver);
		String Enteronlyalphabets = ExcelData.getData("projects", 46, 2);
		cp.Enter_ProjectTitle(Enteronlyalphabets);
		String Enterdescription = ExcelData.getData("projects", 47, 2);
		cp.Enter_ProjectDescription(Enterdescription);
		cp.ClickOnCreateNewTest();
		// verify Wallet instrument
		cp.ClickOnInstrumentWallet();
		Thread.sleep(1000);
		Actions actions = new Actions(driver);
		actions.scrollByAmount(0, 700).perform();
		cp.deselect_INCORRECT_MOBILE();
		Thread.sleep(1000);
		String expectedsourcecountry = ExcelData.getData("projects", 48, 2);
		System.out.println("expectedsourcecountry: " + expectedsourcecountry);
		cp.entersourcecounrty(expectedsourcecountry);
		GenericUtils.selectDropdownOption(driver, expectedsourcecountry);
		SoftAssert sa = new SoftAssert();
		String expectedDestinationcountry = ExcelData.getData("projects", 49, 2);
		System.out.println("expectedDestinationcountry: " + expectedDestinationcountry);
		cp.enterdestinationCountry(expectedDestinationcountry);
		GenericUtils.selectDropdownOption(driver, expectedDestinationcountry);
		Thread.sleep(1000);
		cp.click_RandomAccount();
		Thread.sleep(1000);
		// Receiverpartner
		String Expectedreceivepartner = ExcelData.getData("projects", 50, 2);
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
		String transactionMode = ExcelData.getData("projects", 52, 2);
		System.out.println("transactionMode: " + transactionMode);
		cp.entertransactionMode(transactionMode);
		GenericUtils.selectDropdownOption(driver, transactionMode);
		// No of Sender Bots
		String Expecetdsenderbots = ExcelData.getData("projects", 53, 2);
		System.out.println("Expecetdsenderbots: " + Expecetdsenderbots);
		cp.enternumberOfBotAccounts(Expecetdsenderbots);
		Thread.sleep(1000);
		// No of Recipient Bots
		String ExpectedREcipientBots = ExcelData.getData("projects", 54, 2);
		cp.enternumberOfTestAccounts(ExpectedREcipientBots);
		Thread.sleep(1000);
		actions.scrollByAmount(0, 700).perform();
		cp.ClickLaunchDate();
		Thread.sleep(2000);
		LocalDate currentDate = LocalDate.now();
		System.out.println(currentDate);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd");
		String dayofMonth = currentDate.format(formatter);
		System.out.println("Day of Month: " + dayofMonth);
		String lanuchday = "(//span[text()='" + dayofMonth + "'])[1]";
		driver.findElement(By.xpath(lanuchday)).click();
		WebElement element = driver.findElement(By.xpath("//button[normalize-space()='Save']"));
		actions.moveToElement(element).perform();
		cp.click_ConfirmSave();
		Thread.sleep(2000);
		String actualsavedstatus = driver.findElement(By.xpath("//td[@data-cy='0_status']")).getText();
		System.out.println("actualsavedstatus: " + actualsavedstatus);
		String expectedsavedstatus = ExcelData.getData("projects", 30, 2);
		System.out.println("expectedsavedstatus: " + expectedsavedstatus);
		cp.clickonTestprojecttableoption();
		Thread.sleep(2000);
		cp.clickonprojecttableoptionView();
		Thread.sleep(2000);
		cp.clickonprojectEdit();
		Thread.sleep(1000);
		//Edit the title
		String Enterdescription2 = ExcelData.getData("projects", 51, 2);
		cp.Clear_ProjectDescription(Enterdescription);
		cp.Enter_ProjectDescription(Enterdescription2);
		Thread.sleep(3000);
		cp.clearLaunchDate();
		Thread.sleep(2000);
		cp.ClickLaunchDate();
		actions.scrollByAmount(0, 1000).perform();
		//Edit the Date
		LocalDate nextDay = currentDate.plusDays(1);
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd");
		String Nextday = nextDay.format(formatter2);
		System.out.println("Next Day of Month: " + Nextday);
		String Nextlanuchday = "(//span[text()='" + Nextday + "'])[1]";
		driver.findElement(By.xpath(Nextlanuchday)).click();
		Thread.sleep(2000);
		actions.scrollByAmount(0, 900).perform();
		Thread.sleep(2000);
		WebElement element2 = driver.findElement(By.xpath("//button[normalize-space()='Save']"));
		actions.moveToElement(element2).perform();
		cp.click_ConfirmSave();
		Thread.sleep(2000);
		actions.scrollByAmount(0, -800).perform();
		cp.clickonTestprojecttableoption();
		Thread.sleep(2000);
		cp.clickonprojecttableoptionView();
		Thread.sleep(2000);
		cp.click_Launch();
		Thread.sleep(1000);
		WebElement lanuchsucess = driver.findElement(By.xpath("//div[text()='Project launched successfully']"));
        String actuallanuch = lanuchsucess.getText();
        System.out.println("project lanuched: " + actuallanuch );
        String expectedlanuch = ExcelData.getData("projects", 31, 2);
        System.out.println("expectedlanuch message: " + expectedlanuch  );
        sa.assertEquals(actuallanuch, expectedlanuch);
        sa.assertAll();
	}
	
	@Test(priority = 17)
	public void verify_PilotWalletP2PIncorrectNumb()
			throws EncryptedDocumentException, IOException, InterruptedException {
		// basic details enter to continue
		CreateProject cp = new CreateProject(driver);
		String Enteronlyalphabets = ExcelData.getData("projects", 46, 2);
		cp.Enter_ProjectTitle(Enteronlyalphabets);
		String Enterdescription = ExcelData.getData("projects", 47, 2);
		cp.Enter_ProjectDescription(Enterdescription);
		cp.ClickOnCreateNewTest();
		// verify Wallet instrument
	    cp.ClickOnInstrumentWallet();
	    Actions actions = new Actions(driver);
		actions.scrollByAmount(0, 700).perform();
		cp.deselect_INCORRECT_MOBILE();
		Thread.sleep(1000);
		String expectedsourcecountry = ExcelData.getData("projects", 48, 2);
		System.out.println("expectedsourcecountry: " + expectedsourcecountry);
		cp.entersourcecounrty(expectedsourcecountry);
		GenericUtils.selectDropdownOption(driver, expectedsourcecountry);
		SoftAssert sa = new SoftAssert();
		String expectedDestinationcountry = ExcelData.getData("projects", 49, 2);
		System.out.println("expectedDestinationcountry: " + expectedDestinationcountry);
		cp.enterdestinationCountry(expectedDestinationcountry);
		GenericUtils.selectDropdownOption(driver, expectedDestinationcountry);
		Thread.sleep(1000);
		cp.click_RandomAccount();
		Thread.sleep(1000);
		actions.scrollByAmount(0, 700).perform();
		// Receiverpartner
		String Expectedreceivepartner = ExcelData.getData("projects", 50, 2);
		cp.enterreceivepartner(Expectedreceivepartner);
		GenericUtils.selectDropdownOption(driver, Expectedreceivepartner);
		Thread.sleep(1000);
		/*
		 * // FinancialPartner String ExpecetdfinancialInstitutions =
		 * ExcelData.getData("projects", 17, 2);
		 * cp.enterfinancialInstitutions(ExpecetdfinancialInstitutions);
		 * GenericUtils.selectDropdownOption(driver, ExpecetdfinancialInstitutions);
		 * Thread.sleep(1000);
		 
		// TransactionMode
		String transactionMode = ExcelData.getData("projects", 52, 2);
		System.out.println("transactionMode: " + transactionMode);
		cp.entertransactionMode(transactionMode);
		GenericUtils.selectDropdownOption(driver, transactionMode);
		*/
		// No of Sender Bots
		String Expecetdsenderbots = ExcelData.getData("projects", 53, 2);
		System.out.println("Expecetdsenderbots: " + Expecetdsenderbots);
		cp.enternumberOfBotAccounts(Expecetdsenderbots);
		Thread.sleep(1000);
		// No of Recipient Bots
		String ExpectedREcipientBots = ExcelData.getData("projects", 54, 2);
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
		Thread.sleep(2000);
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
		String expected_projectname = Enteronlyalphabets;
		System.out.println("expected_projectname: " + expected_projectname);
		String actual_projectname = driver.findElement(By.xpath("//td[@data-cy='0_projectTitle']")).getText();
		System.out.println("actual_projectname: " + actual_projectname);
		String expected_Transactiontype = ExcelData.getData("projects", 55, 2);
		System.out.println("expected_Transactiontype: " + expected_Transactiontype);
		String actual_Transactiontype = driver.findElement(By.xpath("//td[@data-cy='0_testScenarios']")).getText();
		System.out.println("actual_Transactiontype: " + actual_Transactiontype);
		String projectID = driver.findElement(By.xpath("//td[@data-cy='0_id']")).getText();
		String actual_projectID = projectID.split("#")[1].replace(".", "").trim();
		System.out.println("actual_projectID: " + actual_projectID);
		sa.assertEquals(actual_projectname, expected_projectname);
		sa.assertEquals(actual_Transactiontype, expected_Transactiontype);
		sa.assertEquals(actual_projectID, expectedprojectID);
		//Verify the Transaction
		actions.scrollByAmount(0, -800).perform();
		cp.clickonTestprojecttableoption();
		Thread.sleep(20000);
		cp.clickonprojecttableoptionView();
		Thread.sleep(20000);
		driver.findElement(By.xpath("(//a[normalize-space()='bKash MTB'])[1]")).click();
		Thread.sleep(50000);
		driver.navigate().refresh();
		WebElement projectstatus = cp.getText_projectstatus();
		WaitUtils.fluentWait_VisibilityOfElement(projectstatus);
		String status = projectstatus.getText();
		 // Perform actions based on status
        if (status.equals("Ongoing")) {
            Thread.sleep(2000);
            /*
            cp.clickon_batchViewincorrectacunt();
            Thread.sleep(2000);
            String Actualresponcemessage = cp.getresponse();
            System.out.println("Actualresponcemessage: " + Actualresponcemessage);
            Thread.sleep(2000);
            String Expectedresponcemessage = ExcelData.getData("projects", 57, 2);
            System.out.println("Expectedresponcemessage: " + Expectedresponcemessage);
            sa.assertEquals(Actualresponcemessage, Expectedresponcemessage);
            cp.clickonCloseicon();
            */
            try {
                // Click on the batch view
                cp.clickon_batchViewincorrectacunt();
                // Wait for the response message to be present
                Thread.sleep(2000);
                cp.clickonbatchViewDetails();
                // Attempt to retrieve the actual response message
                String Actualresponcemessage = cp.getresponse();
                System.out.println("Actualresponcemessage: " + Actualresponcemessage);
                // Wait for a while before getting the expected response message
                Thread.sleep(2000);
                // Retrieve the expected response message from Excel
                String Expectedresponcemessage = ExcelData.getData("projects", 57, 2);
                System.out.println("Expectedresponcemessage: " + Expectedresponcemessage);
                // Assert that the actual response matches the expected response
                sa.assertEquals(Actualresponcemessage, Expectedresponcemessage);
                cp.clickonCloseicon();
            } catch (Exception e) {
                // Print the exception to understand the error
                System.out.println("Error occurred: " + e.getMessage());
                
                // Click on the close icon if there is an error
                cp.clickonCloseicon();
            }
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
