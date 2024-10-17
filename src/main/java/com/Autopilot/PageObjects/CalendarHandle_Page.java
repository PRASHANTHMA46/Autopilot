package com.Autopilot.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalendarHandle_Page extends Base_Page {
	
	//Initialization
	public CalendarHandle_Page(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
	}
	
	//WebElements
	@FindBy(xpath="//input[@placeholder='dd/mm/yyyy - dd/mm/yyyy']")
	private WebElement TransactionLookup_CalendarIcon;
	
	@FindBy(xpath="//span[@class='rdrMonthPicker']//select")
	private WebElement Month_Dropdown;
	
	@FindBy(xpath="//span[@class='rdrYearPicker']//select")
	private WebElement Year_Dropdown;
	
	@FindBy(xpath="//button[normalize-space()='OK']")
	private WebElement Ok_Button;
	
	@FindBy(xpath ="//*[@id=\"root\"]/div[1]/div[2]/div[2]/div/div[2]/div/div[2]/div[2]/div[1]/div/div[2]/input")
    private WebElement DateRangeSelectorForTxnLookUp;

    @FindBy(xpath ="(//input[@class ='MuiInputBase-input css-mnn31'])[2]")
    private WebElement DateRangeSelectorAllQuery;
	
	@FindBy(xpath ="//input[@class ='MuiInputBase-input css-mnn31']")
	private WebElement dateRangeSelectorforReportsLink;
	
	@FindBy(xpath ="(//input[@class ='MuiInputBase-input Mui-readOnly MuiInputBase-readOnly css-mnn31'])")
	private WebElement dateRangeSelector;
	
	@FindBy(xpath ="//input[@placeholder ='Early']")
	private WebElement fromDate;
	
	@FindBy(xpath ="//input[@placeholder ='Continuous']")
	private WebElement toDate;

	@FindBy(xpath ="//span[@class ='rdrMonthPicker']")
	private WebElement month;
	
	@FindBy(xpath ="//span[@class ='rdrYearPicker']")
	private WebElement year;
	
	@FindBy(xpath ="//button[@class='rdrNextPrevButton rdrNextButton']")
	private WebElement nextMonth;
	
	@FindBy(xpath = "//button[@class ='closeBtn']")
	private WebElement closeButton;
	
	@FindBy(xpath = "//button[@class='saveBtn']")
	private WebElement saveButton;

	@FindBy(xpath = "//button[@class='rdrNextPrevButton rdrPprevButton']")
	private WebElement previousMonth;
	
	@FindBy(xpath ="//select/option[@value='2']")
	private WebElement selectMarch;
	
	@FindBy(xpath ="//select/option[@value='4']")
	private WebElement selectMay;
	
	@FindBy(xpath ="//span[text()='1']")
	private WebElement selectDateOne;
	
	@FindBy(xpath ="(//span[text()='15'])")
	private WebElement selectDateFifteen;
	
	@FindBy(xpath ="//span[text()='25']")
	private WebElement selectDate25;
	
	@FindBy(xpath ="//span[text()='9']")
	private WebElement selectDate9;
	
	@FindBy(xpath ="//select/option[@value='2022']")
	private WebElement select2022;
	
	@FindBy (xpath ="//div[@class='MuiFormControl-root css-17ltz4u']")
    private WebElement CalenderIcon;
    
	@FindBy (xpath ="//input[@class='MuiInputBase-input Mui-readOnly MuiInputBase-readOnly css-mnn31']")
    private WebElement report_CalenderIcon;
	
    @FindBy(xpath="//span[@class='rdrMonthPicker']")
    private WebElement CalenderMonthPicker;
    
    @FindBy(xpath="//span[@class='rdrYearPicker']")
    private WebElement CalenderYearPicker;
    
    @FindBy(xpath="//option[text()='2021']")
    private WebElement Select2021Year;
    
    @FindBy(xpath="//span[@class='rdrDayNumber']")
     private WebElement select1stdate;
    
    @FindBy(xpath="//button[normalize-space()='Close']")
    private WebElement CloseButton;
	
    
	//Utilzation_Methods
    
    public void  selectDateRange() {
    	dateRangeSelector.click();
       }
   
    public void clickOnFromDate() {
    	fromDate.click();
    }
    public void clickOnToDate() {
    	toDate.click();
       }
    public void clickOnMonth() {
    	month.click();
    }
    public void clickOnYear() {
    	year.click();
        }
   
   public void clickOnNextmonth() {
	   nextMonth.click();
   }
   public void clickOnPreviousMonth() {
	   previousMonth.click();
   }
   public void clickOnDateRangeSelectorforReports() {
	   dateRangeSelectorforReportsLink.click();
   }
   public void clickOnCloseButton() {
		  closeButton.click();
	  }
   public void clickOnOkButton() {
	   saveButton.click();
   }
   public String getMonth() {
	   return month.getText();
   }
   public String getYear() {
	   return year.getText();
   }
   public String getFromDate() {
	   return fromDate.getText();
   }
   public String getToDate() {
	   return toDate.getText();
   }
   public void selectDateRangeForTxnLookUp()
   {
       DateRangeSelectorForTxnLookUp.click();
   }
   public void selectDateRangeSelectorAllQuery()
   {
       DateRangeSelectorAllQuery.click();
   }
   public void clickOnMarch() {
		selectMarch.click();
	}
   public void clickOnOne() {
	   selectDateOne.click();
	}
   public void clickOnFifteen() {
	   selectDateFifteen.click();
	}
   public void selectYear2022() {
	   select2022.click();
   }
   public void clickOnMay() {
		selectMay.click();
	}
   public void clickOn25() {
	   selectDate25.click();
	}
   public void clickOn9() {
	   selectDate9.click();
	}
   
   public void click_CalenderIcon()
   {
       CalenderIcon.click();
   }
   public void click_ReportCalenderIcon()
   {
	   report_CalenderIcon.click();
   }
  
   public void click_CalenderMonthPicker()
   {
       CalenderMonthPicker.click();
   }
   
   public void click_CalenderYearPicker()
   {
       CalenderYearPicker.click();
   }
   public void select_Select2021Year()
   {
       Select2021Year.click();
   }
 
   public void click_select1stdate(String testdata)
   {
       select1stdate.sendKeys(testdata);
   }
   public void click_CloseButton()
   {
       CloseButton.click();
   }
   
   public void clickTransactionLookup_CalendarIcon()
	{
		TransactionLookup_CalendarIcon.click();
	}
	
	public void clickMonth_Dropdown()
	{
		Month_Dropdown.click();
	}
	
	public void clickYear_Dropdown()
	{
		Year_Dropdown.click();
	}
	
	public void clickOk_Button()
	{
		Ok_Button.click();
	}

public WebElement getDateRangeSelectorForTxnLookUp() {
	return DateRangeSelectorForTxnLookUp;
}

public void setDateRangeSelectorForTxnLookUp(WebElement dateRangeSelectorForTxnLookUp) {
	DateRangeSelectorForTxnLookUp = dateRangeSelectorForTxnLookUp;
}

public WebElement getDateRangeSelectorAllQuery() {
	return DateRangeSelectorAllQuery;
}

public void setDateRangeSelectorAllQuery(WebElement dateRangeSelectorAllQuery) {
	DateRangeSelectorAllQuery = dateRangeSelectorAllQuery;
}

public WebElement getDateRangeSelectorforReportsLink() {
	return dateRangeSelectorforReportsLink;
}

public void setDateRangeSelectorforReportsLink(WebElement dateRangeSelectorforReportsLink) {
	this.dateRangeSelectorforReportsLink = dateRangeSelectorforReportsLink;
}

public WebElement getDateRangeSelector() {
	return dateRangeSelector;
}

public void setDateRangeSelector(WebElement dateRangeSelector) {
	this.dateRangeSelector = dateRangeSelector;
}

public WebElement getNextMonth() {
	return nextMonth;
}

public void setNextMonth(WebElement nextMonth) {
	this.nextMonth = nextMonth;
}

public WebElement getCloseButton() {
	return closeButton;
}

public void setCloseButton(WebElement closeButton) {
	this.closeButton = closeButton;
}

public WebElement getSaveButton() {
	return saveButton;
}

public void setSaveButton(WebElement saveButton) {
	this.saveButton = saveButton;
}

public WebElement getPreviousMonth() {
	return previousMonth;
}

public void setPreviousMonth(WebElement previousMonth) {
	this.previousMonth = previousMonth;
}

public WebElement getSelectMarch() {
	return selectMarch;
}

public void setSelectMarch(WebElement selectMarch) {
	this.selectMarch = selectMarch;
}

public WebElement getSelectMay() {
	return selectMay;
}

public void setSelectMay(WebElement selectMay) {
	this.selectMay = selectMay;
}

public WebElement getSelectDateOne() {
	return selectDateOne;
}

public void setSelectDateOne(WebElement selectDateOne) {
	this.selectDateOne = selectDateOne;
}

public WebElement getSelectDateFifteen() {
	return selectDateFifteen;
}

public void setSelectDateFifteen(WebElement selectDateFifteen) {
	this.selectDateFifteen = selectDateFifteen;
}

public WebElement getSelectDate25() {
	return selectDate25;
}

public void setSelectDate25(WebElement selectDate25) {
	this.selectDate25 = selectDate25;
}

public WebElement getSelectDate9() {
	return selectDate9;
}

public void setSelectDate9(WebElement selectDate9) {
	this.selectDate9 = selectDate9;
}

public WebElement getSelect2022() {
	return select2022;
}

public void setSelect2022(WebElement select2022) {
	this.select2022 = select2022;
}

public WebElement getCalenderIcon() {
	return CalenderIcon;
}

public void setCalenderIcon(WebElement calenderIcon) {
	CalenderIcon = calenderIcon;
}

public WebElement getReport_CalenderIcon() {
	return report_CalenderIcon;
}

public void setReport_CalenderIcon(WebElement report_CalenderIcon) {
	this.report_CalenderIcon = report_CalenderIcon;
}

public WebElement getCalenderMonthPicker() {
	return CalenderMonthPicker;
}

public void setCalenderMonthPicker(WebElement calenderMonthPicker) {
	CalenderMonthPicker = calenderMonthPicker;
}

public WebElement getCalenderYearPicker() {
	return CalenderYearPicker;
}

public void setCalenderYearPicker(WebElement calenderYearPicker) {
	CalenderYearPicker = calenderYearPicker;
}

public WebElement getSelect2021Year() {
	return Select2021Year;
}

public void setSelect2021Year(WebElement select2021Year) {
	Select2021Year = select2021Year;
}

public WebElement getSelect1stdate() {
	return select1stdate;
}

public void setSelect1stdate(WebElement select1stdate) {
	this.select1stdate = select1stdate;
}

public WebElement getCloseButton1() {
	return CloseButton;
}

public void setCloseButton1(WebElement closeButton) {
	CloseButton = closeButton;
}

//public WebDriverWait getWait() {
//	return wait;
//}
//
//public void setWait(WebDriverWait wait) {
//	this.wait = wait;
//}

public void setFromDate(WebElement fromDate) {
	this.fromDate = fromDate;
}

public void setToDate(WebElement toDate) {
	this.toDate = toDate;
}

public void setMonth(WebElement month) {
	this.month = month;
}

public void setYear(WebElement year) {
	this.year = year;
}
  
}
