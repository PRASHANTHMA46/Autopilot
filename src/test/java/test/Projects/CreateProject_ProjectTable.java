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
import com.Autopilot.PageObjects.CreateProject;
import com.Autopilot.PageObjects.HomePage;
import com.Autopilot.PageObjects.LoginPage;
import com.Autopilot.Utilities.ExcelData;

public class CreateProject_ProjectTable extends BaseTest {

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
		driver.findElement(By.xpath("//html")).click();
		Thread.sleep(2000);

	}

	@Test(priority = 1)
	public void DestinationCountrydropdown() throws EncryptedDocumentException, IOException, InterruptedException {
		CreateProject cp = new CreateProject(driver);
		String india = ExcelData.getData("project_table", 1, 2);
		cp.EnterDestinationcountry(india);
		GenericUtils.selectDropdownOption(driver, india);
		System.out.println("expectedDestinationcountry: " + india);
		String ActualDestinationcountry = driver
				.findElement(By.xpath("(//td[contains(text(),'United States of America')])")).getText();
		System.out.println("ActualDestinationcountry: " + ActualDestinationcountry);
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(ActualDestinationcountry, india);
		String Actual_USA = ExcelData.getData("project_table", 2, 2);
		System.out.println("Actualseconddestinatoincountry: " + Actual_USA);
		cp.EnterDestinationcountry(Actual_USA);
		GenericUtils.selectDropdownOption(driver, Actual_USA);
		String Actual_Bang = ExcelData.getData("project_table", 3, 2);
		System.out.println("ActualBang: " + Actual_Bang);
		cp.EnterDestinationcountry(Actual_Bang);
		GenericUtils.selectDropdownOption(driver, Actual_Bang);
		Thread.sleep(1000);
		cp.clickon_removebangladesh();
		Thread.sleep(1000);
		String Actualafterclosebangl = driver
				.findElement(By.xpath("//div[contains(text(),'United States of America')]")).getText();
		System.out.println("Actualafterclosebangl: " + Actualafterclosebangl);
		String Expectedafterclosebangl = ExcelData.getData("project_table", 1, 2);
		System.out.println("Expectedafterclosebangl: " + Expectedafterclosebangl);
		sa.assertEquals(Actualafterclosebangl, Expectedafterclosebangl);
		cp.clickon_removeUnitedStatesofAmerica();
		Thread.sleep(1000);
		String Actualaftercloseusa = driver.findElement(By.xpath("//div[contains(text(),'India')]")).getText();
		System.out.println("Actualaftercloseusa: " + Actualaftercloseusa);
		String Expectedaftercloseusa = ExcelData.getData("project_table", 2, 2);
		System.out.println("Expectedaftercloseusa: " + Expectedaftercloseusa);
		sa.assertEquals(Actualaftercloseusa, Expectedaftercloseusa);
		Thread.sleep(1000);
		cp.clickon_removeRemoveIndia();
		cp.EnterDestinationcountry(india);
		GenericUtils.selectDropdownOption(driver, india);
		cp.EnterDestinationcountry(Actual_Bang);
		GenericUtils.selectDropdownOption(driver, Actual_Bang);
		cp.EnterDestinationcountry(Actual_USA);
		GenericUtils.selectDropdownOption(driver, Actual_USA);
		Thread.sleep(1000);
		cp.clickon_closealldestiation();
		sa.assertAll();
	}

	@Test(priority = 2)
	public void ReceivePartnerdropdown() throws EncryptedDocumentException, IOException, InterruptedException {
		CreateProject cp = new CreateProject(driver);
		String partner = ExcelData.getData("project_table", 4, 2);
		cp.EnterReceivePartner(partner);
		GenericUtils.selectDropdownOption(driver, partner);
		System.out.println("expected_partnerbank: " + partner);
		String actual_partnerbank = driver.findElement(By.xpath("(//td[contains(text(),'Federal Bank')])[1]"))
				.getText();
		System.out.println("actual_partnerbank: " + actual_partnerbank);
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actual_partnerbank, partner);
		// selecting again another partner
		String secondpartner = ExcelData.getData("project_table", 5, 2);
		cp.EnterReceivePartner(secondpartner);
		GenericUtils.selectDropdownOption(driver, secondpartner);
		// closing onebyone partner
		cp.clickon_RemoveIndiaGoldenMoneyTransfer();
		String aftercloseonepartner = driver.findElement(By.xpath("//div[contains(text(),'Federal Bank')]")).getText();
		System.out.println("aftercloseonepartner: " + aftercloseonepartner);
		sa.assertEquals(aftercloseonepartner, partner);
		cp.clickon_RemoveFederalBank();
		// again reenter the partner
		cp.EnterReceivePartner(partner);
		GenericUtils.selectDropdownOption(driver, partner);
		Thread.sleep(1000);
		cp.EnterReceivePartner(secondpartner);
		GenericUtils.selectDropdownOption(driver, secondpartner);
		Thread.sleep(1000);
		cp.clickon_closealldestiation();
		sa.assertAll();
	}

	
	@Test(priority=3)
	public void ProjectTable_StatusDropdown() throws EncryptedDocumentException, IOException, InterruptedException{
		  // Click on the status dropdown to open it
				WebElement dropdown = driver.findElement(By.xpath("(//div[@class='react-select__input-container css-19bb58m'])[3]"));
				dropdown.click();
				CreateProject cp = new CreateProject(driver);
			    // Get all dropdown options
			    List<WebElement> dropdownOptions = driver.findElements(By.xpath("//div[@class='react-select__option css-1dqae0a-option']"));
			    
			    for (int i = 0; i < dropdownOptions.size(); i++) {
			        // Get the updated list of options (as DOM might have refreshed)
			        dropdownOptions = driver.findElements(By.xpath("//div[@class='react-select__option css-1dqae0a-option']"));
			        
			        // Select the dropdown option by index
			        WebElement option = dropdownOptions.get(i);
			        String optionText = option.getText();
			        option.click();
			        SoftAssert sa = new SoftAssert();
			        // Wait for the table to update (you may need to adjust this wait or use an explicit wait)
			        Thread.sleep(2000); // Adjust this as per the page load time
			        // Check if "No data available" is displayed in the table or verify the status
			        List<WebElement> noDataElements = driver.findElements(By.xpath("//td[normalize-space()='No data available']"));
			        if (!noDataElements.isEmpty()) {
			            System.out.println("No data available for the status: " + optionText);
			        } else {
			            // Locate the status in the table (Assumed that status is in the first cell)
			            WebElement statusCell = driver.findElement(By.xpath("(//div[@class='project-status'])"));
			            String cellText = statusCell.getText();
			            
			         // Use soft assertion to verify the status in the table matches the selected dropdown option
			            sa.assertEquals(cellText, optionText, "Mismatch found! Expected: " + optionText + ", but found: " + cellText);
			            // Verify the status in the table matches the selected dropdown option
			            if (!cellText.equals(optionText)) {
			                System.out.println("Mismatch found! Expected: " + optionText + ", but found: " + cellText);
			            } else {
			                System.out.println("Status verified for " + optionText);
			            }
			        }
			        // Close the selected value to reset the dropdown for the next iteration
			        cp.Clearmultitransaction();
			        dropdown.click();
			        // Wait before selecting the next option
			        Thread.sleep(1000); // Adjust this as per the page behavior
			       //sa.assertAll(); 
			    }
			    
	}
	
	@Test(priority=4)
	public void verify_statusAlldropdown() throws EncryptedDocumentException, IOException, InterruptedException
	{
		WebElement dropdown = driver.findElement(By.xpath("(//div[@class='react-select__input-container css-19bb58m'])[3]"));
		dropdown.click();
		CreateProject cp = new CreateProject(driver);
	    // Get all dropdown options
	    List<WebElement> dropdownOptions = driver.findElements(By.xpath("//div[@class='react-select__menu css-1nmdiq5-menu']"));
	    for (WebElement status:dropdownOptions)
	    {
	    	String ActualstatusList = status.getText();
	    	Thread.sleep(2000);
			System.out.println("ActualstatusList: " + ActualstatusList);
			String ExpectedstatusList = ExcelData.getData("project_table", 6, 2);
			System.out.println("ExpectedstatusList: " + ExpectedstatusList);
			SoftAssert sa = new SoftAssert();
			sa.assertEquals(ActualstatusList, ExpectedstatusList);
	    	sa.assertAll();
	    }
	}
	
	
}
