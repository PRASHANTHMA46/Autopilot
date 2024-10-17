package com.Autopilot.PageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Autopilot.Generic.BaseTest;

public class LoginPage2 extends BaseTest {
	

	//Initialization
	public LoginPage2(WebDriver driver) {
		
		PageFactory.initElements(driver, this);  
		
	}
	
	//WebElements
		@FindBy(xpath="//input[@id='input-email']")
		private WebElement EnterEmailIdField;
		
		@FindBy(xpath="//input[@id='input-password']")
		private WebElement EnterPasswordField;
		@FindBy(xpath="//input[@value='Login']")
		private WebElement LoginButton;
		
		
		
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
		
	

}
