package com.Autopilot.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Autopilot.Generic.BaseTest;

public class Projects_Page extends BaseTest {

	public Projects_Page(WebDriver driver) {

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//span[normalize-space()='Projects']")
	private WebElement Projects;
	
	@FindBy(xpath="//h1[@class='page-title']")
	private WebElement pagetitle;

	@FindBy(xpath = "//button[normalize-space()='Create Project']")
	private WebElement Createproject;

	@FindBy(xpath = "//input[@id='projectTitle']")
	private WebElement Projecttitle;

	@FindBy(xpath = "//input[@id='projectDescription']")
	private WebElement Projectdescription;

	@FindBy(xpath = "//input[@id='testSetUp_NEW']")
	private WebElement Createnewtest;

	@FindBy(xpath = "//input[@id='instrument_BANK']")
	private WebElement Bank;

	@FindBy(xpath = "//label[normalize-space()='Pilot Testing']")
	private WebElement Pilottesting;

	@FindBy(xpath = "//label[normalize-space()='Continuous Performance Monitoring']")
	private WebElement CPM;

	@FindBy(xpath = "//input[@id='sourceCountry']")
	private WebElement Sourcecountry;

	@FindBy(xpath = "//input[@id='destinationCountry']")
	private WebElement Destinationcountry;

	@FindBy(xpath = "//input[@id='receivePartners.0.partner']")
	private WebElement Receivepartner;

	@FindBy(xpath = "//input[@id='receivePartners.0.numberOfBotAccounts']")
	private WebElement senderbots;

	@FindBy(xpath = "//input[@id='receivePartners.0.numberOfTestAccounts']")
	private WebElement receipientaccounts;

	@FindBy(xpath = "//input[@name='launchDetails.launchDate']")
	private WebElement dateoflaunch;
	
	@FindBy(xpath="//input[@id='launchDetails.occurrencesCount']")
	private WebElement occurances;
	

	@FindBy(xpath = "//button[normalize-space()='Launch']")
	private WebElement Launch;

	@FindBy(xpath = "//button[normalize-space()='Confirm & Launch']")
	private WebElement Confirmandlaunch;

	@FindBy(xpath = "//button[@data-cy='btn-launch']")
	private WebElement launchbtn;

	@FindBy(xpath = "//h1[normalize-space()='Projects']")
	private WebElement Empty_click;

	@FindBy(xpath = "//h1[@class='page-title fw-bold']")
	private WebElement subpagetitle;

	@FindBy(xpath = "//p[contains(text(),'Your project ID is')]")
	private WebElement projectId;

	@FindBy(xpath = "(//div[@class='project-status'])[1]")
	private WebElement projectstatus;

	// Testing projects Filter Functionality

	@FindBy(xpath = "//a[@id='react-aria7818265358-:rh:-tab-testing']")
	private WebElement Testingprojects;

	@FindBy(xpath = "(//input[@class='react-select__input'])[1]")
	private WebElement Destination_CountryFilter;

	@FindBy(xpath = "(//input[@class='react-select__input'])[2]")
	private WebElement Receive_partnerFilter;

	@FindBy(xpath = "(//input[@class='react-select__input'])[3]")
	private WebElement status_Filter;

	@FindBy(xpath = "//input[@name='startDateRangeFilter']")
	private WebElement Date_filter;

	@FindBy(xpath = "//a[@data-rr-ui-event-key='scheduled']")
	private WebElement scheduled;

	@FindBy(xpath = "//a[@data-rr-ui-event-key='saved']")
	private WebElement Saved;

	@FindBy(xpath = "//input[@data-cy='startDateRangeFilter']")
	private WebElement LaunchDate;

	// Utilization

	public void Clickprojects() {
		Projects.click();
	}

	public void Clickcreateprojects() {
		Createproject.click();
	}

	public void EnterProjecttitle(String Projecttitles) {
		Projecttitle.sendKeys(Projecttitles);
	}

	public void EnterProjectdescription(String description) {
		Projectdescription.sendKeys(description);
	}

	public void ClickBank() {
		Bank.click();
	}

	public void Clickcreatenewtest() {
		Createnewtest.click();
	}

	public void Clickpilottesting() {
		Pilottesting.click();
	}

	public void ClickCPM() {
		CPM.click();
	}

	public void EnterSourcecountry(String text) {
		Sourcecountry.sendKeys(text);
	}

	public void Enterdestinationcountry(String text) {
		Destinationcountry.sendKeys(text);

	}

	public void ClickReceivepartner(String text) {
		Receivepartner.sendKeys(text);

	}

	public void Entersenderbots(String text) {
		senderbots.sendKeys(text);
	}

	public void Enterreceipientsaccount(String text) {
		receipientaccounts.sendKeys(text);
	}
	public void Enter_Occurances(String text) {
		occurances.sendKeys(text);
	}

	public void Enterdate_of_launch(String date) {
		dateoflaunch.sendKeys(date);
	}

	public void ClickLaunchbtn() {
		Launch.click();
	}

	public void ClickConfirm_and_Launch() {
		if (isConfirmandLaunchbuttonenabled()) {
			Confirmandlaunch.click();
		
			
		} else {
			System.out.println("Confirm and Launch button is disabled");
			
		

		}

	}

	public boolean isConfirmandLaunchbuttonenabled() {
		
		return Confirmandlaunch.isEnabled();
	}

	public void Click_Launchbtn() {
		Launch.click();
	}

	public String Fetch_Pagetitle() {
		return pagetitle.getText();
	}
	public String Fetch_SubPagetitle() {
		return subpagetitle.getText();
	}

	public String Fetch_ProjectId() {
		return projectId.getText();
	}

	public String Fetch_Projectstatus() {
		return projectstatus.getText();
	}

	public void Side_Click() {
		Empty_click.click();

	}

	public void Enter_DestinationCountry_Filter(String text) {
		Destination_CountryFilter.sendKeys(text);

	}

	public void Enter_ReceivePartner_Filter(String text) {
		Receive_partnerFilter.sendKeys(text);
	}

	public void Enter_Status_Filter(String text) {
		status_Filter.sendKeys(text);
	}

	public void Click_ScheduledProjects() {
		scheduled.click();
	}

	public void Click_SavedProjects() {
		Saved.click();
	}

	public void Enter_LaunchDateFilter(String text) {
		LaunchDate.sendKeys(text);
	}

}
