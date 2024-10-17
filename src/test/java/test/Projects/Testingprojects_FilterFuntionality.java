package test.Projects;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Autopilot.Config.PropertiesFile;
import com.Autopilot.Generic.BaseTest;
import com.Autopilot.Generic.GenericUtils;
import com.Autopilot.PageObjects.CreateProject;
import com.Autopilot.PageObjects.HomePage;
import com.Autopilot.PageObjects.LoginPage;
import com.Autopilot.PageObjects.Projects_Page;

import com.Autopilot.Utilities.ExcelData;

public class Testingprojects_FilterFuntionality extends BaseTest {

	@BeforeMethod
	public void LoginAdmin() throws InterruptedException, EncryptedDocumentException, IOException {

		LoginPage lp = new LoginPage(driver);
		HomePage hp = new HomePage(driver);
		String EmailId = PropertiesFile.readProperty("Admin");
		String Password = PropertiesFile.readProperty("pswd");
		lp.enterEmailId(EmailId);
		lp.enterPassword(Password);
		Thread.sleep(1000);
		lp.clickLoginButton();
		Thread.sleep(1000);
		lp.Navbarslideropen();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//html")).click();
		CreateProject cp = new CreateProject(driver);
		cp.clickOnProject();
		String ActualProjectHeader = driver.findElement(By.xpath("//h1[normalize-space()='Projects']")).getText();
		System.out.println("ActualProjectHeader: " + ActualProjectHeader);
		String expected_ProjectHeader = ExcelData.getData("projects", 1, 2);
		System.out.println("Expected_ProjectHeader: " + expected_ProjectHeader);
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(ActualProjectHeader, expected_ProjectHeader);
		Thread.sleep(2000);
	}

	@Test
	public void DestinationCountry_DropdownFunctionality()
			throws EncryptedDocumentException, IOException, InterruptedException {
		Projects_Page pp = new Projects_Page(driver);
		SoftAssert sa = new SoftAssert();
		pp.Side_Click();

		// Validating the Destination_Country Filter
		String Country = ExcelData.getData("projects", 1, 2);
		pp.Enter_DestinationCountry_Filter(Country);
		GenericUtils.selectDropdownOption(driver, Country);

		// Locate the table
		WebElement table = driver.findElement(By.cssSelector("tbody"));

		// Locate all the rows within the table

		List<WebElement> rows = table.findElements(By.tagName("tr"));
		// Iterate through the rows and print the specific column
		int columnIndex = 6;
		for (WebElement row : rows) {
			List<WebElement> cells = row.findElements(By.tagName("td"));
			if (cells.size() > columnIndex) {
				String Actual_Country = cells.get(columnIndex).getText();
				System.out.println("Actual Country:"+ Actual_Country);
				sa.assertEquals(Country, Actual_Country);
				sa.assertAll();
			}

		}
	}

	@Test
	public void Receivepartner_DropDownFunctionality() throws EncryptedDocumentException, IOException {
		Projects_Page pp = new Projects_Page(driver);
		SoftAssert sa = new SoftAssert();
		pp.Side_Click();

		// Locate the table
		WebElement table = driver.findElement(By.cssSelector("tbody"));

		// Locate all the rows within the table

		List<WebElement> rows = table.findElements(By.tagName("tr"));

		// Validating the Receive_partner Filter
		String partner = ExcelData.getData("projects", 2, 2);
		pp.Enter_ReceivePartner_Filter(partner);
		GenericUtils.selectDropdownOption(driver, partner);
		// Iterate through the rows and print the specific column
		int columnIndex1 = 8;
		for (WebElement row : rows) {
			List<WebElement> cells = row.findElements(By.tagName("td"));
			if (cells.size() > columnIndex1) {
				//System.out.println(cells.get(columnIndex1).getText().equalsIgnoreCase(partner));
				String Actual_Partner = cells.get(columnIndex1).getText();
				System.out.println("Actual Partner:"+ Actual_Partner);
				sa.assertEquals(Actual_Partner,partner);
				sa.assertAll();
			}

		}
	}

	@Test
	public void Status_DropdownFunctionality() throws EncryptedDocumentException, IOException {
		Projects_Page pp = new Projects_Page(driver);
		SoftAssert sa = new SoftAssert();
		pp.Side_Click();
		// Locate the table
		WebElement table = driver.findElement(By.cssSelector("tbody"));

		// Locate all the rows within the table
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		// Validating the Receive_partner Filter
		String status = ExcelData.getData("projects", 3, 2);
		pp.Enter_Status_Filter(status);
		GenericUtils.selectDropdownOption(driver, status);
		// Iterate through the rows and print the specific column
		int columnIndex2 = 11;
		for (WebElement row : rows) {
			List<WebElement> cells = row.findElements(By.tagName("td"));
			if (cells.size() > columnIndex2) {
				String Actual_Status = cells.get(columnIndex2).getText();
				System.out.println("Actual Status:"+ Actual_Status);
				System.out.println("Expected Status:"+ status);
				sa.assertEquals(Actual_Status,status);
				sa.assertAll();

			}

		}
	}
}
