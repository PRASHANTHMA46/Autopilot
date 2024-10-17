package com.Autopilot.Generic;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils extends BaseTest {
	
	static FluentWait<WebDriver> fluentWait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(120))
			.pollingEvery(Duration.ofMillis(500)).ignoring(NoSuchElementException.class);
	
	public WebElement FluentWait_VisibilityOfElement(String xpathValue)
	{
		WebElement ele = fluentWait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(xpathValue)));
		return ele;
	}	
	public void fluentWait_elementToBeClickable(WebElement ele)
	{
		fluentWait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	public static void fluentWait_VisibilityOfElement(WebElement ele)
	{
		fluentWait.until(ExpectedConditions.visibilityOf(ele));
	}
	public void ExplicitWait_ElementToBeClickable(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public static WebElement ExplicitWait_VisibilityOfElement(WebElement ele)
	{
		return new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(ele));
	}
	public static void click(WebElement wb) {
		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(wb))
				.click();
	}
	public static void sendKeys(WebElement wb, String value) {
		WaitUtils.ExplicitWait_VisibilityOfElement(wb).sendKeys(value);
	}
	public static String getText(WebElement wb) {
		return WaitUtils.ExplicitWait_VisibilityOfElement(wb).getText();
	}
	public static String getAttribute(WebElement wb, String value) {
		return WaitUtils.ExplicitWait_VisibilityOfElement(wb).getAttribute(value);
	}
	public static void clear(WebElement wb) {
		WaitUtils.ExplicitWait_VisibilityOfElement(wb).clear();
	}
	public static boolean isDisplayed(WebElement wb) {
		return WaitUtils.ExplicitWait_VisibilityOfElement(wb).isDisplayed();
	}
	public static boolean isEnabled(WebElement wb) {
		return WaitUtils.ExplicitWait_VisibilityOfElement(wb).isEnabled();
	}
	public static boolean isSelected(WebElement wb) {
		return WaitUtils.ExplicitWait_VisibilityOfElement(wb).isSelected();
	}
	public static void waitForElementToAppear(WebDriver driver, WebElement element)
    {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	wait.until(ExpectedConditions.elementToBeClickable(element));
    }

}
