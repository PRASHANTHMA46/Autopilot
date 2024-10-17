package com.Autopilot.Utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class IretryAnalyzer implements IRetryAnalyzer{

	private int retrycount = 0;
	private static final int maxcount =1;
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(retrycount < maxcount) {
			retrycount++;
			return true;
		}
		return false;
	}	
}
