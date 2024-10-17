package com.Autopilot.Generic;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class GenericUtils {

	public static WebDriver driver;


		public static void getScreenShot(WebDriver driver, String name) throws IOException
		{
			TakesScreenshot t =(TakesScreenshot)driver;
			File src=t.getScreenshotAs(OutputType.FILE);
			File dest= new File("\\screenshots\\"+name+".png");
			FileUtils.copyFile(src, dest);
			
		}



    public static void clickmoveByoffset()
    {
    	Actions actions = new Actions(driver);
    	actions.moveByOffset(0, 0).click().build().perform();
    }
	public  static void selectByIndex(WebElement element, int Index)
	{
		Select sel=new Select(element);
		sel.selectByIndex(Index);
	}

	public static void selectByValue(WebElement element, String value)
	{
		Select sel=new Select(element);
		sel.selectByValue(value);
	}

	public static void selectByVisibleText(WebElement element, String text )
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}

	public  static void getFirstSelectedOption(WebElement element, String text)
	{	Select sel=new Select(element);
	sel.getFirstSelectedOption();
	}

	public static void mouseOver(WebDriver driver, WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}

	public static void scrollIntoView(WebDriver driver, WebElement element)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true);",element);
		Actions Act = new Actions(driver);
		Act.sendKeys(Keys.PAGE_UP).click().perform();

	}
	public static void scrolltoelement(WebDriver driver, WebElement element)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true);",element);
	}
	public static void verticallyScroll(WebDriver driver)
	{
		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		Actions Act = new Actions(driver);
		Act.sendKeys(Keys.DOWN).click().perform();
	}

	public static void verticalScrollBy(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1280)"); 	 
	}
	public static void verticalDoubleScrollBy(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,2000)"); 
	}
	public static void horizantalDoubleScrollBy(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(1000,0)"); 
	}
	public static void waitForElementToClickable(WebDriver driver, WebElement element)
    {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	wait.until(ExpectedConditions.elementToBeClickable(element));
    }
	
	public static void waitForPresenceOfElement(WebDriver driver, By element)
    {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }
	
	  public static void selectDropdownOption(WebDriver driver, String text)
	    {
	    	WebElement option = driver.findElement(By.xpath("//div[text()='"+text+"']"));
	    	JavascriptExecutor js =(JavascriptExecutor) driver;
	    	js.executeScript("arguments[0].click();", option);
	    }



	public static WebElement waitForPresenceOfElement(WebDriver driver2, String string) {
		return null;
		// TODO Auto-generated method stub
		
	}
}
