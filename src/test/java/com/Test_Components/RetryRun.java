package com.Test_Components;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryRun implements IRetryAnalyzer {

	@Override
	public boolean retry(ITestResult result) {
		
		int count  = 0;
		int maxTry = 3;
		
		if(count < maxTry)
		{
			count++;
			return true;
		}
		
		return false;
	}

}
