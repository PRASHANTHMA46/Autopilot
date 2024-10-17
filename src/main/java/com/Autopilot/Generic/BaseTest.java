package com.Autopilot.Generic;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.Autopilot.Config.PropertiesFile;
import com.Autopilot.PageObjects.HomePage;
import com.Autopilot.Utilities.ExtentReport;
import com.aventstack.extentreports.ExtentReports;

import io.github.bonigarcia.wdm.WebDriverManager;



public class BaseTest {

	public static WebDriver driver;
	public static Properties prop;
	public static FileInputStream fis;
	public static File file;
	public static ExtentReports report;
	

	@BeforeClass
	public void setUpMethod() throws InterruptedException, IOException, AWTException {
		
		if ("chromeheadless".equalsIgnoreCase(PropertiesFile.readProperty("browser"))) {
			//System.setProperty(PropertiesFile.readProperty("driver"), PropertiesFile.readProperty("driverPath"));
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--window-size=1080,800");
			options.addArguments("--start-maximized");
			options.addArguments("--headless");
			options.addArguments("--remote-allow-origins=*");
			options.addArguments("--disable notifications");
			DesiredCapabilities cp = new DesiredCapabilities();
			cp.setCapability(ChromeOptions.CAPABILITY, options);
			options.merge(cp);
			driver = new ChromeDriver(options);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.get(PropertiesFile.readProperty("url"));
			Thread.sleep(1000);
		} else if ("chrome".equalsIgnoreCase(PropertiesFile.readProperty("browser"))) {
			//System.setProperty(PropertiesFile.readProperty("driver"), PropertiesFile.readProperty("driverPath"));
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			//options.setExperimentalOption("excludeSwitches",Arrays.asList("disable-popup-blocking","enable-automation"));
			options.addArguments("disable-infobars");
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			options.addArguments("--window-size=800, 600");
			driver.get(PropertiesFile.readProperty("url"));
		} else if ("firefox".equalsIgnoreCase(PropertiesFile.readProperty("browser"))) {
			//System.setProperty(PropertiesFile.readProperty("driver"), PropertiesFile.readProperty("driverPath"));
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get(PropertiesFile.readProperty("url"));
		} else if ("edge".equalsIgnoreCase(PropertiesFile.readProperty("browser"))) {
			//System.setProperty(PropertiesFile.readProperty("driver"), PropertiesFile.readProperty("driverPath"));
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.get(PropertiesFile.readProperty("url"));
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@AfterMethod
	public static void postCondition(ITestResult res) throws IOException, InterruptedException {
		HomePage hp = new HomePage(driver);
		
		hp.clickOnProfile();
		Thread.sleep(2000);
		hp.clickonLogoutButton();
		Thread.sleep(1000);
		try {
			Alert alert = driver.switchTo().alert();
	        // Get the text of alert
			//System.out.println("Alert text: " + alert.getText());
	        alert.accept();
		} catch (Exception e) {
            System.out.println("No alert present or could not handle the alert.");
            e.printStackTrace();
        }
		
		
	
	}
	
	@AfterClass
	public void flush()
	{	
		driver.close();
		driver.quit();
	}
	
	//@BeforeTest
	public void report()
	{
		report = ExtentReport.extentReportGenrator();
	}
	
	//@AfterTest
	public void reportflush()
	{
		
		if (report != null) {
			report.flush();
        }
		
	}
	
	public String getScreenshot(String name, WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		File path = new File(System.getProperty("user.dir") + "//reports//" + name + ".png");
		FileUtils.copyFile(source, path);
		return System.getProperty("user.dir") + "//reports/reports" + name + ".png"; 
		
	}

	public static void ExplicitWait(WebElement element) 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public static void Explicitwait(String string) 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(string)));
	}
	public static void Explicitwait1(WebElement ele) 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	

}
