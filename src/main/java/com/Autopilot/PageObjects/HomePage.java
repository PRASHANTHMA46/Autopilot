package com.Autopilot.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Autopilot.Generic.BaseTest;

public class HomePage extends BaseTest{

	//Initialization
	public HomePage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	//WebElement
	@FindBy(xpath = "//aside[@class='sidebar']")
	WebElement navbar;
	@FindBy(xpath="//div[@class='nav-item dropdown']//a[@role='button']")
	private WebElement Profile;
	
	@FindBy(xpath="//a[normalize-space()='Logout']")
	private WebElement LogoutButton;
	
	@FindBy(xpath="//button[normalize-space()='Yes, Log Out']")
	private WebElement LogoutConfirmationButton;
	
	//Utilization Methods
	public void clickOnProfile()
	{
		Profile.click();
	}
	
	public void clickonLogoutButton()
	{
		 LogoutButton.click();
		//return LogoutButton;
	}
	
	public void clickLogoutConfirmationButton()
	{
		LogoutConfirmationButton.click();
	}
	
	public void Navbarslideropen() {
		navbar.click();
	}

}
