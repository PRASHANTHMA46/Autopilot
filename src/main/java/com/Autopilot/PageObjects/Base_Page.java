package com.Autopilot.PageObjects;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base_Page {
	
	public static WebDriver driver;
	
	public void BasePage(WebDriver driver)
	{
		this.driver= driver;
	}
	
	
	//Explicit wait method
//	public static void ExplicitWait(WebElement element) 
//	{
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.elementToBeClickable(element));
//	}	

	
		//To verify the title
		/*public void verifyTitle(String eTitle)
		{
			WebDriverWait wait =new WebDriverWait(driver,10);
			try {
			wait.until(ExpectedConditions.titleIs(eTitle));
			Reporter.log("Title is matching : "+ eTitle);
			}
			catch(Exception e)
			{
				Reporter.log("Title is not matching :Expected condition is :"+ eTitle,true);
				Reporter.log("Actual Title is:" +driver.getTitle(),true);
				Assert.fail();
			}
		}
		
		
		//To verify Element
		public void verifyElement(WebElement element)
		{
			WebDriverWait wait= new WebDriverWait(driver,10);
			try
			{
				wait.until(ExpectedConditions.visibilityOf(element));
			    Reporter.log("Matching element is present", true);
			}
			catch(Exception e)
			{
			    Reporter.log("Element is not present", true);
			    Assert.fail();
			}
					
		}
		*/
		

}
