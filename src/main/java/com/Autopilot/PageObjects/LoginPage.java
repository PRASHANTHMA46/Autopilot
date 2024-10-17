package com.Autopilot.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Autopilot.Generic.BaseTest;

public class LoginPage extends BaseTest{

	//Initialization
	public LoginPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);  
		
	}
	//WebElements
	@FindBy(xpath="//input[@id='username']")
	private WebElement EnterEmailIdField;
	
	@FindBy(xpath="//input[@id='password']")
	private WebElement EnterPasswordField;
	
	
	@FindBy(xpath="//input[@id='kc-login']")
	private WebElement LoginButton;
	
	@FindBy(xpath="//input[@id=':r1:']")
	private WebElement EnterOTPField;
	
	@FindBy(xpath="//button[normalize-space()='Submit OTP']")
	private WebElement SubmitOTPButton;
	
	@FindBy(xpath="//p[normalize-space()='Invalid user!']")
	private WebElement InvalidUserErrorMsg;

	@FindBy(xpath = "//aside[@class='sidebar']")
	WebElement navbar;
	
	//Utilzation_Methods
	
	public void Navbarslideropen() {
		navbar.click();
	}
	
	public void enterEmailId(String EmailId)
	{
		EnterEmailIdField.sendKeys(EmailId);
	}
	
	public void enterPassword(String Password)
	{
		EnterPasswordField.sendKeys(Password);
	}
	
	public void clickLoginButton() 
	{
		LoginButton.click();
	}
	
	public void enterOTP(String OTP)
	{
		EnterOTPField.sendKeys(OTP);
	}
	
	public void clickSubmitButton()
	{
		SubmitOTPButton.click();
	}
	public WebElement returnInvalidUserErrorMsg()
	{
		return InvalidUserErrorMsg;
	}
}
	