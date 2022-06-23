package com.crm.genericutility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListImplimentation implements ITestListener {

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		
		JavaUtility java=new JavaUtility();
		String date = java.getSystemDateAndTimeInISTFormat();
		
		String testName = result.getMethod().getMethodName();
		EventFiringWebDriver eDriver=new EventFiringWebDriver(BaseClass.sdriver);
		File src = eDriver.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File("./src/test/resources/Photos/"+testName+".png"));
	}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}	
}	

