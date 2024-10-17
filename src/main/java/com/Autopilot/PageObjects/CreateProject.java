package com.Autopilot.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Autopilot.Generic.BaseTest;

public class CreateProject extends BaseTest {
	
      private static final String text = null;


	public CreateProject(WebDriver driver)
      {
    	  PageFactory.initElements(driver, this);
    	  
      }
	
    //WebElement
  	@FindBy(xpath="//span[normalize-space()='Projects']")
  	private WebElement Projects;
  	@FindBy(xpath="//button[normalize-space()='Create Project']")
  	private WebElement CreateProject;
  	@FindBy(xpath="//input[@id='projectTitle']")
  	private WebElement ProjectTitle;
  	@FindBy(xpath="//input[@id='projectTitle']/following-sibling::div[text()='Field is required']")
  	private WebElement ProjectTitleFieldRequ;
  	@FindBy(xpath="//input[@id='projectDescription']")
  	private WebElement ProjectDescription;
  	@FindBy(xpath="//label[normalize-space()='Create New Test']")
  	private WebElement CreateNewTest;
  	@FindBy(xpath="//input[@id='testSetUp_EXISTING']")
  	private WebElement UseExisitngSuite;
  	@FindBy(xpath="//input[@id='testSuiteId']")
  	private WebElement EntertestSuitename;
  	@FindBy(xpath="//input[@id='instrument_BANK']")
  	private WebElement InstrumentBank;
  	@FindBy(xpath="//input[@id='instrument_WALLET']")
  	private WebElement InstrumentWallet;
  	@FindBy(xpath="//label[normalize-space()='Pilot Testing']")
  	private WebElement TestTypePilotTesting;
  	@FindBy(xpath="//label[normalize-space()='Continuous Performance Monitoring']")
  	private WebElement CPM;
  	@FindBy(xpath="//label[normalize-space()='Weekly']")
  	private WebElement CPMWeekly;
  	@FindBy(xpath="//label[normalize-space()='Monthly']")
  	private WebElement Monthly;
  	@FindBy(xpath="//label[normalize-space()='Quarterly']")
  	private WebElement Quarterly;
  	@FindBy(xpath="//div[@class='react-select__multi-value__remove css-v7duua']")
  	private WebElement multiclearindicator;
  	@FindBy(xpath="//div[@class='react-select__indicator react-select__clear-indicator css-ccwosw-indicatorContainer']")
  	private WebElement clearindicator;
  	@FindBy(xpath="//input[@id='transactionTypes']")
  	private WebElement TansactionType;
  	@FindBy(xpath="//label[normalize-space()='Incorrect name']")
  	private WebElement IncorrectName;
  	@FindBy(xpath="//label[normalize-space()='Incorrect account']")
  	private WebElement Incorrectaccount;
  	@FindBy(xpath="//input[@id='INCORRECT_MOBILE']")
  	private WebElement INCORRECT_MOBILE;
  	
  	@FindBy(xpath="//div[@class='react-select__indicator react-select__dropdown-indicator css-15lsz6c-indicatorContainer']")
  	private WebElement TansactionTypearrowdropdown;
  	@FindBy(xpath="//div[text()='P2P']")
  	private WebElement p2p;
  	@FindBy(xpath="//div[text()='B2B']")
  	private WebElement B2B;
  	@FindBy(xpath="//div[text()='B2P']")
  	private WebElement B2P;
  	@FindBy(xpath="//div[text()='P2B']")
  	private WebElement P2B;
  	@FindBy (xpath ="//*[text()='United States of America']")
  	private WebElement swapsourcecountry;
  	@FindBy(xpath="//input[@id='sourceCountry']")
  	private WebElement sourcecountry;
  	@FindBy(xpath="//*[text()='USD']")
  	private WebElement currencyCode;
  	@FindBy(xpath="//button[@class='btn btn-outline-primary']")
  	private WebElement swapCountry;
  	@FindBy (xpath ="//*[text()='India']")
  	private WebElement swapdestinationcountry;
  	@FindBy(xpath="//input[@id='destinationCountry']")
  	private WebElement destinationCountry;
  	@FindBy(xpath="//input[@id='accountsAssignmentStrategy_EXISTING_ACCOUNTS']")
  	private WebElement exisitingAccount;
  	@FindBy(xpath="//input[@id='accountsAssignmentStrategy_RANDOM_ACCOUNTS']")
  	private WebElement RANDOM_ACCOUNTS;
  	@FindBy(xpath="//input[@id='receivePartners.0.partner']")
  	private WebElement receivepartner;
  	@FindBy(xpath="//div[@class='item-header']")
  	private WebElement receivepartnerHeader;
  	@FindBy(xpath="(//input[@id='receivePartners.0.financialInstitutions'])[1]")
  	private WebElement financialInstitutions;
  	@FindBy(xpath="//div[contains(@aria-label,'Remove Kotak Mahindra Bank')]//*[name()='svg']")
  	private WebElement financialInstitutions_clear;
  	@FindBy(xpath="(//input[@id='receivePartners.0.transactionMode'])[1]")
  	private WebElement transactionMode;
  	@FindBy(xpath="(//div[@class='react-select__value-container react-select__value-container--has-value css-hlgwow'])[5]")
  	private WebElement gettransactionMode;
  	@FindBy(xpath="(//input[@id='receivePartners.0.numberOfBotAccounts'])[1]")
  	private WebElement numberOfBotAccounts;
  	@FindBy(xpath="//input[@data-cy='receivePartners.0.numberOfBotAccounts']")
  	private WebElement getnumberOfBotAccounts;
  	@FindBy(xpath="(//input[@id='receivePartners.0.numberOfTestAccounts'])[1]")
  	private WebElement numberOfTestAccounts;
  	@FindBy(xpath="//input[@id='launchDetails.occurrencesCount']")
  	private WebElement numberOfOccurancy;
  	@FindBy(xpath="//button[normalize-space()='Confirm & Launch']")
  	private WebElement ConfirmLaunch;
  	@FindBy(xpath="//button[normalize-space()='Save']")
  	private WebElement ConfirmSave;
  	@FindBy(xpath="//button[normalize-space()='Launch']")
  	private WebElement Launch;
  	@FindBy(xpath="//button[normalize-space()='Save']")
  	private WebElement Save;
  	@FindBy(xpath="//input[@data-testid='launchDetails.launchDate']")
  	private WebElement LaunchDate;
  	@FindBy(xpath="//tbody/tr[1]/td[13]")
  	private WebElement Testprojecttableoption;
  	@FindBy(xpath="//button[normalize-space()='View']")
  	private WebElement projecttableoptionView;
  	@FindBy(xpath="//div[@class='info-text']//div[@class='project-status']")
  	private WebElement projectstatus;
  	@FindBy(xpath="//button[normalize-space()='Edit']")
  	private WebElement projectEdit;
  	@FindBy(xpath="(//*[name()='svg'][@class='kebab-icon'])[5]")
  	private WebElement kebabiconincorrect;
  	@FindBy(xpath="(//*[name()='svg'][@class='kebab-icon'])[2]")
  	private WebElement batchViewincorrectacunt;
  	@FindBy(xpath="//button[normalize-space()='View Batch Details']")
  	private WebElement batchViewBatchDetails;
  	@FindBy(xpath="//button[normalize-space()='View Details']")
  	private WebElement batchViewDetails;
  	@FindBy(xpath="//div[@class='info-text']//div[@class='project-status'][normalize-space()='Failed'] | //div[@class='info-text']//div[@class='project-status'][normalize-space()='Success']")
  	private WebElement multibatchViewDetails;
  	@FindBy(xpath="//button[@aria-label='Close']")
  	private WebElement Closeicon;
  	@FindBy(xpath="//div[@class='item-header']//div[@class='info'][strong[contains(text(), 'Response Message')]]")
  	private WebElement Response;
  	@FindBy(xpath="//td[@class='text-center']")
  	private WebElement projectTableoption;
  	@FindBy(xpath="(//a[normalize-space()='Scheduled Projects'])[1]")
  	private WebElement scheduledprojectTab;
  	@FindBy(xpath="//button[normalize-space()='Pause']")
  	private WebElement pause;
  	@FindBy(xpath="(//a[normalize-space()='Testing Projects'])[1]")
  	private WebElement TestingProjects;
  	@FindBy(xpath="//div[text()='Frequency']/following-sibling::div[@class='preview__value']")
  	private WebElement Frequency;
  	@FindBy(xpath="//div[text()='Test Type']/following-sibling::div[@class='preview__value']")
  	private WebElement TestType;
  	@FindBy(xpath="//button[@class='accordion-button']//div[@class='project-status'][contains(text(),'Scheduled')]")
  	private WebElement getScheduledstatus;
  	@FindBy(xpath="//button[@class='accordion-button collapsed']//div[@class='project-status'][contains(text(),'Scheduled')]")
  	private WebElement getScheduledquaterly;
  	//Project Tables 
  	@FindBy(xpath="(//input[@class='react-select__input'])[1]")
  	private WebElement Destinationcountry;
  	@FindBy(xpath="(//input[@class='react-select__input'])[2]")
  	private WebElement ReceivePartner;
  	@FindBy(xpath="(//input[@class='react-select__input'])[3]")
  	private WebElement status;
  	//Remove Destination Country
  	@FindBy(xpath="//div[@aria-label='Remove Bangladesh']//*[name()='svg']")
  	private WebElement removebangladesh;
  	@FindBy(xpath="//div[@aria-label='Remove United States of America']//*[name()='svg']")
  	private WebElement UnitedStatesofAmerica;
  	@FindBy(xpath="//div[@aria-label='Remove India']//*[name()='svg']")
  	private WebElement RemoveIndia;
	@FindBy(xpath="//div[@aria-label='Remove Golden Money Transfer']//*[name()='svg']")
  	private WebElement RemoveIndiaGoldenMoneyTransfer;
	@FindBy(xpath="//div[@aria-label='Remove Federal Bank']//*[name()='svg']")
  	private WebElement RemoveFederalBank;
  	@FindBy(xpath="//div[@class='react-select__indicator react-select__clear-indicator css-ccwosw-indicatorContainer']//*[name()='svg']")
  	private WebElement closealldestiation;
  	
	public void Enterstatus(String text)
  	{
		status.sendKeys(text);
  		
  	}
  	public void clickon_status()
  	{
  		status.click();
  		
  	}
  	public void clickon_RemoveFederalBank()
  	{
  		RemoveFederalBank.click();
  		
  	}
  	
  	public void clickon_RemoveIndiaGoldenMoneyTransfer()
  	{
  		RemoveIndiaGoldenMoneyTransfer.click();
  		
  	}
  	public void EnterReceivePartner(String text)
  	{
  		ReceivePartner.sendKeys(text);
  		
  	}
  	public void clickon_closealldestiation()
  	{
  		closealldestiation.click();
  		
  	}
  	public void clickon_removeRemoveIndia()
  	{
  		RemoveIndia.click();
  		
  	}
	public void clickon_removeUnitedStatesofAmerica()
  	{
		UnitedStatesofAmerica.click();
  		
  	}
  	public void clickon_removebangladesh()
  	{
  		removebangladesh.click();
  		
  	}
	public void EnterDestinationcountry(String text)
  	{
		Destinationcountry.sendKeys(text);
  		
  	}
  	public String get_Scheduledquaterly()
  	{
  		return getScheduledquaterly.getText();
  		
  	}
	public String get_Scheduledstatus()
  	{
  		return getScheduledstatus.getText();
  		
  	}
	
  	public String get_TestType()
  	{
  		return TestType.getText();
  		
  	}
  	public String get_Frequency()
  	{
  		return Frequency.getText();
  		
  	}
	public void clickon_TestingProjects()
  	{
		TestingProjects.click();
  		
  	}
  	public void clickon_pause()
  	{
  		pause.click();
  		
  	}
  	public void clickon_scheduledprojectTab()
  	{
  		scheduledprojectTab.click();
  		
  	}
  	public void clickon_batchViewincorrectacunt()
  	{
  		batchViewincorrectacunt.click();
  		
  	}
  	public void clickon_kebabiconincorrectOption()
  	{
  		kebabiconincorrect.click();
  		
  	}
	public void clickon_projecttableFirtOption()
  	{
		projectTableoption.click();
  		
  	}
  	public String getresponse()
  	{
  		return Response.getText();
  	}
  	public WebElement getText_PassorFailStatus()
  	{
  		return multibatchViewDetails;
  	}
  	public void clickonCloseicon()
  	{
  		Closeicon.click();
  		
  	}
  	
  	public void clickonbatchViewBatchDetails()
  	{
  		batchViewBatchDetails.click();
  		
  	}
  	public void clickonbatchViewDetails()
  	{
  		batchViewDetails.click();
  		
  	}
  	public void clickonprojectEdit()
  	{
  		projectEdit.click();
  		
  	}
  	public WebElement getText_projectstatus()
  	{
  		return projectstatus;
  	}
	
  	public void clickonprojecttableoptionView()
  	{
  		projecttableoptionView.click();
  		
  	}
  	public void clickonTestprojecttableoption()
  	{
  		Testprojecttableoption.click();
  		
  	}
  	public void click_existing()
  	{
  		exisitingAccount.click();
  		
  	}
  	public void click_RandomAccount()
  	{
  		RANDOM_ACCOUNTS.click();
  		
  	}
  	public void clearLaunchDate()
  	{
  		LaunchDate.sendKeys(Keys.BACK_SPACE);
  	}
	public void ClickLaunchDate()
  	{
  		LaunchDate.click();
  		
  	}
  	public void EnterLaunchDate(String text)
  	{
  		LaunchDate.sendKeys(text);
  		
  	}
	public String getText_OfOccurancy()
  	{
		return numberOfOccurancy.getAttribute("Value");
  		
  	}
  	public void ClearNumberOfOccurancy()
  	{
		numberOfOccurancy.clear();
  		
  	}
	public void EnterNumberOfOccurancy(String text)
  	{
		numberOfOccurancy.sendKeys(text);
  		
  	}
  	public void click_save()
  	{
  		Save.click();
  		
  	}
  	public void click_Launch()
  	{
  		Launch.click();
  	}
  	public void click_ConfirmSave()
  	{
  		ConfirmSave.click();
  	}
  	
  	public void click_ConfirmLaunch()
  	{
  		ConfirmLaunch.click();
  	}
  	public void ClearnumberOfTestAccounts()
  	{
  		numberOfTestAccounts.clear();
  	}
  	public String getenternumberOfTestAccounts()
  	{
  		return numberOfTestAccounts.getAttribute("Value");
  	}
  	public void enternumberOfTestAccounts(String text)
  	{
  		numberOfTestAccounts.sendKeys(text);
  	}
  	
  	public void ClearnumberOfBotAccounts()
  	{
  		numberOfBotAccounts.clear();
  	}
  	public String getenternumberOfBotAccounts()
  	{
  		return getnumberOfBotAccounts.getAttribute("Value");
  	}
  	public void enternumberOfBotAccounts(String text)
  	{
  		numberOfBotAccounts.sendKeys(text);
  	}
  	public String gettransactionMode()
  	{
  		return gettransactionMode.getText();
  	}
	public void cleartransactionMode()
  	{
  		transactionMode.clear();
  	}
  	public void entertransactionMode(String text)
  	{
  		transactionMode.sendKeys(text);
  	}
  	
  	public void ClearfinancialInstitutions()
  	{
  		financialInstitutions_clear.click();
  	}
  	public void enterfinancialInstitutions(String text)
  	{
  		financialInstitutions.sendKeys(text);
  	}
  
  	public String receivepartnerHeader()
  	{
  		return receivepartnerHeader.getText();
  	}
  	public void enterreceivepartner(String text)
  	{
  		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", receivepartner);
  		receivepartner.sendKeys(text);
  	}
  	
  	public String getreceivepartner()
  	{
  		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", receivepartner);
  		return receivepartner.getText();
  	}
  	public void cleardestinationcounrty()
  	{
  		destinationCountry.sendKeys(Keys.BACK_SPACE);
  	}
  	public String getswapdestination()
  	{
  		return swapdestinationcountry.getText();
  	}
	public String getdestination()
  	{
  		return destinationCountry.getAttribute("Value");
  	}
	public String getcurrencycode()
  	{
  		return currencyCode.getText();
  	}
	
	public void SwapCountry()
  	{
		swapCountry.click();
  	}
  	public void enterdestinationCountry(String text)
  	{
  		destinationCountry.sendKeys(text);
  	}
  	
  	public void clearsourcecounrty()
  	{
  		sourcecountry.sendKeys(Keys.BACK_SPACE);
  	}
	public String getswapsourcecounrty()
  	{
  		return swapsourcecountry.getText();
  	}
  	public String getsourcecounrty()
  	{
  		return sourcecountry.getAttribute("Value");
  	}
  
  	public void entersourcecounrty(String text)
  	{
  		sourcecountry.sendKeys(text);
  	}
  	public void click_transactionP2B()
  	{
  		P2B.click();
  	}
  	public void click_transactionB2P()
  	{
  		B2P.click();
  	}
  	public void click_transactionB2B()
  	{
  		B2B.click();
  	}
	public void click_transactionp2p()
  	{
		p2p.click();
  	}
	public void deselect_INCORRECT_MOBILE()
  	{
		INCORRECT_MOBILE.click();
  	}
	public void deselect_Incorrectaccount()
  	{
		Incorrectaccount.click();
  	}
	public void deselect_Incorrectname()
  	{
		IncorrectName.click();
  	}
	public void click_Incorrectname()
  	{
		IncorrectName.click();
  	}
	public void click_Incorrectaccount()
  	{
		Incorrectaccount.click();
  	}
	public void click_INCORRECT_MOBILE()
  	{
		INCORRECT_MOBILE.click();
  	}
	
	public void click_TansactionTypearrowdropdown()
  	{
		TansactionTypearrowdropdown.click();
  	}
	public void clearTansactionType(String text)
  	{
  		TansactionType.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
  	}
  	public void enterTansactionType(String text)
  	{
  		TansactionType.sendKeys(text);
  	}
  	public void ClickOnTansactionType()
  	{
  		TansactionType.click();
  	}
  	
  	public void Clearmultitransaction()
  	{
  		multiclearindicator.click();
  	}
	public void ClickOnclearindicator()
  	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", clearindicator);
		clearindicator.click();
  	}
	
	public void ClickOnCPMQuarterly()
  	{
		Quarterly.click();
  	}
	public void ClickOnCPMMonthly()
  	{
		Monthly.click();
  	}
	public void ClickOnCPMWeekly()
  	{
		CPMWeekly.click();
  	}
	public void ClickOnCPM()
  	{
		CPM.click();
  	}
  	public void ClickOnTestTypePilotTesting()
  	{
  		TestTypePilotTesting.click();
  	}
  	public void ClickOnInstrumentBank()
  	{
  		InstrumentBank.click();
  	}
  	public void ClickOnInstrumentWallet()
  	{
  		InstrumentWallet.click();
  	}
  	public void EnterTestSuiteName(String text)
  	{
  		EntertestSuitename.sendKeys(text);;
  	}
  	public void ClickOnUseExisiting()
  	{
  		UseExisitngSuite.click();
  	}
  	public void ClickOnCreateNewTest()
  	{
  		CreateNewTest.click();
  	}
  	public void Clear_ProjectDescription(String text)
  	{
  		ProjectDescription.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));

  	}
  	
  	public void Enter_ProjectDescription(String description)
  	{
  		ProjectDescription.sendKeys(description);
  	}
  	
  	public String ProjectTitleFieldReq()
  	{
  		return ProjectTitleFieldRequ.getText();

  	}
	
  	public void Clear_ProjectTitle(String text)
  	{
  		ProjectTitle.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));

  	}
  	
  	public void Enter_ProjectTitle(String title)
  	{
  		ProjectTitle.sendKeys(title);
  	}
  	public String get_ProjectTitle()
  	{
  		return ProjectTitle.getAttribute("value");
  	}
  	public void ClickOnCreateProject()
  	{
  		CreateProject.click();
  	}
  	public void clickOnProject()
  	{
  		Projects.click();
  	}
}
