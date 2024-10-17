package com.Autopilot.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Ecommerce_Page {

	// Initialization
	public Ecommerce_Page(WebDriver driver) {

		PageFactory.initElements(driver, this);

	}

	// WebElement
	@FindBy(xpath = "//a[normalize-space()='Edit Account']")
	WebElement EditAccount;

	// WebElement
	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement LastName;

	// WebElement
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement Click_Continue;
	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement Myaccount;
	@FindBy(xpath = "(//a[normalize-space()='Logout'])[1]")
	WebElement Logout;

	// Utilization Methods
	public void clickOnProfile() {
		EditAccount.click();
	}

	public void LastName(String name) {
		LastName.clear();
		LastName.sendKeys(name);
	}

	public void clickOnMyaccount() {
		Myaccount.click();
	}

	public void Click_Continue() {
		Click_Continue.click();
	}
	
	public void clickOnLogout() {
		Logout.click();
	}
}
