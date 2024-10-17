package test.Practice;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Autopilot.Config.PropertiesFile;
import com.Autopilot.Generic.BaseTest;
import com.Autopilot.PageObjects.Ecommerce_Page;
import com.Autopilot.PageObjects.HomePage;
import com.Autopilot.PageObjects.LoginPage2;

public class Testnaveen extends BaseTest {
	
	@BeforeMethod
	public void LoginAdmin() throws InterruptedException {

		LoginPage2 lp = new LoginPage2(driver);
		HomePage hp = new HomePage(driver);
		String EmailId = PropertiesFile.readProperty("Admin");
		String Password = PropertiesFile.readProperty("pswd");
		lp.enterEmailId(EmailId);
		lp.enterPassword(Password);
		Thread.sleep(1000);
		lp.clickLoginButton();
		Thread.sleep(1000);
		

	}

	@Test
	public void EditAccount() throws InterruptedException
	{
		Ecommerce_Page ep = new Ecommerce_Page(driver);
		ep.clickOnProfile();
		Thread.sleep(1000);
		ep.LastName("yadav");
		ep.Click_Continue();
		 // Capture the success message
        String success = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText();
        System.out.println("editaccount: " + success);

        // Assert that the success message matches the expected value
        String expectedMessage = "Success: Your account has been successfully updated."; // Replace with your expected message
        Assert.assertTrue(success.contains(expectedMessage), "The success message is not as expected!");
        
        Thread.sleep(3000);
		//logout
        ep.clickOnMyaccount();
        ep.clickOnLogout();
        driver.quit();
        
		
		
	}

}
