package com.customeListners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.setUp.BaseSetup;

public class TestNGListeners implements ITestListener {

	public void onTestStart(ITestResult result) {
		BaseSetup.logger.info("--- Method Execution Started --- : "+result.getMethod().getMethodName());
		
	}

	public void onTestSuccess(ITestResult result) {
		BaseSetup.logger.info("--- Method Execution Finished --- : "+result.getMethod().getMethodName());
		
	}

	public void onTestFailure(ITestResult result) {
		BaseSetup.logger.info("--- Method Execution Failure --- : "+result.getMethod().getMethodName());
		
	}

	public void onTestSkipped(ITestResult result) 
	{
		 
		BaseSetup.logger.info("-- Test is skipped: ---" + result.getMethod().getMethodName());
	}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	
	public void onStart(ITestContext context) 
	{
		BaseSetup.logger.info("--- Test Started --- : "+context.getName());
		
	}

	
	public void onFinish(ITestContext context) 
	{
		BaseSetup.logger.info("--- Test Finished --- : "+context.getName());
		
	}

}
