package com.Autopilot.Utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {

	static ExtentReports extent;


	public static ExtentReports  extentReportGenrator()
	{		
		String path = System.getProperty("user.dir")+"//reports//EngagePlus.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("_yyyy_MM_dd_HH_mm_ss");
		DateFormat dateFormatreport = new SimpleDateFormat("_dd_MM_yyyy");
		reporter = new ExtentSparkReporter("reports/reports" + dateFormatreport.format(date)
		+ "/Autopilot-" + dateFormat.format(date) + ".html");
		reporter.config().setTheme(Theme.DARK);
		reporter.config().setReportName("Autopilot");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("PROJECT_NAME", "Autopilot");
		extent.setSystemInfo("EXECUTED_BY", "PrashanthM");
		return extent;
	}
	
	
}
