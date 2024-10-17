package test.Projects;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Autopilot.Config.PropertiesFile;
import com.Autopilot.Generic.BaseTest;
import com.Autopilot.Generic.GenericUtils;
import com.Autopilot.PageObjects.LoginPage;
import com.Autopilot.PageObjects.Projects_Page;
import com.Autopilot.Utilities.ExcelData;

public class SavedProjects_DropdownFunctionality extends BaseTest {

	@BeforeMethod
	public void LoginAdmin() throws InterruptedException, EncryptedDocumentException, IOException {

		LoginPage lp = new LoginPage(driver);
		Thread.sleep(3000);
		String EmailId = PropertiesFile.readProperty("Admin");
		String Password = PropertiesFile.readProperty("Password");
		lp.enterEmailId(EmailId);
		lp.enterPassword(Password);
		lp.clickLoginButton();
		Thread.sleep(2000);
		Projects_Page pp = new Projects_Page(driver);
		pp.Clickprojects();
		String actualpage = driver.findElement(By.xpath("//h1[normalize-space()='Projects']")).getText();
		System.out.println("Actual page:" + actualpage);
		String expectedpage = "Projects";
		System.out.println("Expected page:" + expectedpage);
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actualpage, expectedpage);
		sa.assertAll();
		Thread.sleep(1000);

		pp.Click_SavedProjects();
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
				// System.out.println("After Filtering Country:" + Actual_Country);
				// System.out.println(Actual_Country.equalsIgnoreCase(Country));
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
				System.out.println(cells.get(columnIndex1).getText().equalsIgnoreCase(partner));

			}

		}
	}

	
	@Test
	public void Launchdate_DropdownFunctionality() {
		Projects_Page pp = new Projects_Page(driver);
		SoftAssert sa = new SoftAssert();
		pp.Side_Click();
		
		pp.Enter_LaunchDateFilter(null);
		
	}
}
