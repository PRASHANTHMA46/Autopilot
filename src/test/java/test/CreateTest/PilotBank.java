package test.CreateTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.checkerframework.checker.calledmethods.qual.EnsuresCalledMethods.List;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;

import com.Autopilot.Generic.BaseTest;
import com.Autopilot.Config.PropertiesFile;
import com.Autopilot.PageObjects.HomePage;
import com.Autopilot.PageObjects.LoginPage;


public class PilotBank extends BaseTest {
	
	@BeforeMethod
	public void LoginAdmin() throws InterruptedException, EncryptedDocumentException, IOException {
		
		LoginPage lp = new LoginPage(driver);
		HomePage hp = new HomePage(driver);
		Thread.sleep(1000);
		String EmailId = PropertiesFile.readProperty("Admin");
		String Password = PropertiesFile.readProperty("pswd");
		lp.enterEmailId(EmailId);
		Thread.sleep(1000);
		lp.enterPassword(Password);
		Thread.sleep(1000);
		lp.clickLoginButton();
		Thread.sleep(1000);
		/*
		lp.clickSubmitButton();
		hp.clickOnProfile();
		Thread.sleep(1000);
		mp.click_Support();
		Thread.sleep(2000);
	     */
	}
	

	@org.testng.annotations.Test(priority=1)
	public void Test()
	{
		
		
	}
	

}
