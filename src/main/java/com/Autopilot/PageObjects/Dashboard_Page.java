package com.Autopilot.PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Autopilot.Generic.BaseTest;

public class Dashboard_Page extends BaseTest {
	
	//Initialization
		public Dashboard_Page(WebDriver driver)
		{
			
			PageFactory.initElements(driver, this);
			
		}
	
		
		//WebElement
		@FindBy(xpath = "//span[normalize-space()='Dashboard']")
		WebElement dashboard;
		@FindBy(xpath = "//button[@data-cy='toggleFiltersPilotStatisticsButton']")
		WebElement pilotprojectcalendericon;
		@FindBy(xpath = "//input[@name='pilotStatisticsStartDateFrom']")
		WebElement pilotStatisticsStartDateFrom;
		@FindBy(xpath = "//input[@name='pilotStatisticsStartDateTo']")
		WebElement pilotStatisticsStartDateTo;
		@FindBy(xpath = "//button[@data-cy='downloadPilotStatisticsButton']//*[name()='svg']")
		WebElement downloadPilotStatisticsButton;
		@FindBy(xpath = "(//a[@class='fs-xs p-3'][normalize-space()='View Projects'])[1]")
		WebElement viewproject;
		@FindBy(xpath = "//button[@data-cy='toggleFiltersBatchStatisticsButton']//*[name()='svg']")
		WebElement viewtransaction;
		@FindBy(xpath = "//button[@data-cy='toggleFiltersBatchStatisticsButton']")
		WebElement CPMCalender;
		@FindBy(xpath = "//input[@name='batchStatisticsStartDateFrom']")
		WebElement CPMStartDateFrom;
		@FindBy(xpath = "//input[@name='batchStatisticsStartDateTo']")
		WebElement CPMStartDateTo;
		@FindBy(xpath = "//button[@data-cy='downloadBatchStatisticsButton']//*[name()='svg']")
		WebElement CPMStaticdownload;
		@FindBy(xpath = "(//input[@id='react-select-2-input'])[1]")
		WebElement  receivepatner;
		@FindBy(xpath = "//*[@id=\"react-select-2-listbox\"]")
		WebElement  receivepatnerfirstdropodwn;
		@FindBy(xpath = "(//input[@id='react-select-3-input'])[1]")
		WebElement  country;
		@FindBy(xpath = "//*[@id=\"react-select-3-option-98\"]")
		WebElement  countryfirstdropdown;
		@FindBy(xpath = "(//a[@class='fs-xs p-3'][normalize-space()='View Projects'])[2]")
		WebElement  CPMviewproject;
		@FindBy(xpath = "(//button[@title='Toggle filters'])[3]")
		WebElement  ScheduledoperationFilter;
		@FindBy(xpath = "(//input[@id='react-select-4-input'])[1]")
		WebElement  instrument;
		@FindBy(xpath = "(//input[@id='react-select-5-input'])[1]")
		WebElement  testtypeinput;
		@FindBy(xpath = "(//input[@id='react-select-6-input'])[1]")
		WebElement  recievepartner;
		@FindBy(xpath = "//button[@title='Add']")
		WebElement  Add;
		@FindBy(xpath = "//a[normalize-space()='Add Sender Bot']")
		WebElement  AddSenderBot;
		@FindBy(xpath = "//button[normalize-space()='Back']")
		WebElement  SenderBack;
		@FindBy(xpath = "//a[normalize-space()='Add Wallet Account']")
		WebElement  AddWalletAccount;
		@FindBy(xpath = "//a[normalize-space()='Add Bank Account']")
		WebElement  AddBankAccount;
		@FindBy(xpath = "//a[normalize-space()='Add Test Suite']")
		WebElement  AddTestSuite;
		@FindBy(xpath = "//a[normalize-space()='Create Project']")
		WebElement  CreateProject;
		@FindBy(css = "div[class='col'] button[title='Toggle filters']")
		WebElement  OperationstaticFilter;
		@FindBy(xpath = "(//input[@id='react-select-18-input'])[1]")
		WebElement  Operationstaticinstrument;
		@FindBy(xpath = "(//input[@id='react-select-19-input'])[1]")
		WebElement  OperationstaticTesttype;
		@FindBy(xpath = "//input[@placeholder='Enter Transaction ID']")
		WebElement  enterTransactionID;
		@FindBy(xpath = "(//button[@type='submit'][normalize-space()='View'])[1]")
		WebElement  clickView;
		@FindBy(xpath = "//input[@placeholder='Enter Project ID']")
		WebElement  enterproject;
		@FindBy(xpath = "(//button[@type='submit'][normalize-space()='View'])[2]")
		WebElement  enterprojectview;
		
		
		public void enterprojectviewclick()
		{
			enterprojectview.click();
		}
		public void EnterprojectID(String text)
		{
			
			enterproject.sendKeys(text);
			
		}
		public void viewTransactionclick()
		{
			clickView.click();
		}
		public void EnterViewTransaction(String text)
		{
			
			enterTransactionID.sendKeys(text);
			
		}
		public void EnterOperationstaticTesttype(String text)
		{
			
			OperationstaticTesttype.sendKeys(text);
			
		}
		public void EnterOperationstaticinstrument(String text)
		{
			Operationstaticinstrument.sendKeys(text);
			
			
		}
		public void OperationstaticFilter(String text)
		{
			OperationstaticFilter.sendKeys(text);
		}
		public void clickCreateProject()
		{
			CreateProject.click();
		}
		public void clickAddTestSuite()
		{
			AddTestSuite.click();
		}
		public void clickAddBankAccount()
		{
			AddBankAccount.click();
		}
		public void clickAddWalletAccount()
		{
			AddWalletAccount.click();
		}
		public void clickSenderBack()
		{
			SenderBack.click();
		}
		public void clickADDSenderBot()
		{
			AddSenderBot.click();
		}
		public void clickADD()
		{
			Add.click();
		}
		public void enterrecievepartnert(String text)
		{
			recievepartner.sendKeys(text);
		}
		public void entertesttypeinput(String text)
		{
			testtypeinput.sendKeys(text);
		}
		public void enterinstrument(String text)
		{
			instrument.sendKeys(text);
		}
		public void clickScheduledoperationFilter()
		{
			ScheduledoperationFilter.click();
		}
		public void clickCPMviewproject()
		{
			CPMviewproject.click();
		}
		
		public void clickcountryfirstdropdown()
		{
			countryfirstdropdown.click();
		}
		
		public void clickreceivepatnerfirstdropodwn()
		{
			receivepatnerfirstdropodwn.click();
		}
		public void countrybackspace()
		{
			country.sendKeys(Keys.BACK_SPACE);
		}
		public void entercountry(String text)
		{
			country.sendKeys(text);
		}
		
		public void enterreceivepartner(String text)
		{
			receivepatner.sendKeys(text);
		}
		public void enterreceivepartnerbacksapce()
		{
			receivepatner.sendKeys(Keys.BACK_SPACE);
		}
		public void clickCPMStaticdownload()
		{
			CPMStaticdownload.click();
		}
		public void clickCPMStartDateTO()
		{
			CPMStartDateTo.click();
		}
		public void clickCPMStartDateFrom()
		{
			CPMStartDateFrom.click();
		}
		public void clickCPMCalender()
		{
			CPMCalender.click();
		}
		public void clickviewtransaction()
		{
			viewtransaction.click();
		}
		public void clickviewproject()
		{
			viewproject.click();
		}
		public void downloadPilotStatisticsButton()
		{
			downloadPilotStatisticsButton.click();
		}
		public void enterStartDateFrom(String text)
		{
			pilotStatisticsStartDateFrom.sendKeys(text);
		}
		public void clickOndashboard()
		{
			dashboard.click();
		}
		
		public void clickOpilotprojectcalendericon()
		{
			pilotprojectcalendericon.click();
		}
		
		
		

}
