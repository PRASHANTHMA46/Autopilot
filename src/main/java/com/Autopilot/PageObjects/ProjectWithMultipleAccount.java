package com.Autopilot.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;

import com.Autopilot.Config.PropertiesFile;

public class ProjectWithMultipleAccount {
	

    public ProjectWithMultipleAccount(WebDriver driver)
    {
  	  PageFactory.initElements(driver, this);
  	  
    }
	
    //WebElement
  	@FindBy(xpath="//input[@id='testSetUp_EXISTING']")
  	private WebElement UseExisitingTestSuite;
  	@FindBy(xpath="//input[@id='testSuiteId']")
  	private WebElement testSuiteId;
  	
  	
  	
  	public void enterOntestSuiteId(String text)
  	{
  		testSuiteId.sendKeys(text);
  	}
  	public void clickOnUseExisitingTestSuite()
  	{
  		UseExisitingTestSuite.click();
  	}

}
