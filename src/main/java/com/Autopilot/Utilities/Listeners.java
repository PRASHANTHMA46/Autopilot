package com.Autopilot.Utilities;


import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.Autopilot.Generic.BaseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;



public class Listeners extends BaseTest implements ITestListener {

	ExtentTest test;
	ExtentReports extent = ExtentReport.extentReportGenrator();
	//ExtentReports extent = ExtentReporterNG.getReportObject();

	@Override
	public void onTestStart(ITestResult result) {
		test= extent.createTest(result.getMethod().getMethodName());
	}
	@Override
	public void onTestSuccess(ITestResult result)
	{
		test.log(Status.PASS,"Test Passed");
	}
	@Override
	public void onTestFailure(ITestResult result)
	{
		test.fail(result.getThrowable());

		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver")
					.get(result.getInstance());
		} catch (Exception e1) {

			e1.printStackTrace();
		}

		String filePath="null";
		
		try {
			
			filePath = getScreenshot(result.getMethod().getMethodName(),driver);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		test.addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
		/*
		try {
			Allure.addAttachment(UUID.randomUUID().toString(),
					new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		*/
		
		//filePath = getScreenshot(result.getMethod().getMethodName(),driver);
		//test.addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
		
	}	

	public String getScreenshot(String methodName, WebDriver driver) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void onTestSkipped(ITestResult result)
	{
		{	
			test.skip(result.getThrowable());

			try {
				driver = (WebDriver) result.getTestClass().getRealClass().getField("driver")
						.get(result.getInstance());
			} catch (Exception e1) {

				e1.printStackTrace();
			}

			String filePath="null";

			filePath = getScreenshot(result.getMethod().getMethodName(),driver);
			test.addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
		}	
	}
	
	@Override
	public void onStart(ITestContext context)
	{
	}
	
	@Override
	public void onFinish(ITestContext context)
	{
		extent.flush();
	}
}

