package com.crm.genericutility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListImplimentation implements ITestListener {
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		test= report.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		
		test.log(Status.PASS, result.getMethod().getMethodName());
		test.log(Status.PASS, result.getThrowable());
	}

	public void onTestFailure(ITestResult result) {
		
		test.log(Status.FAIL,result.getMethod().getMethodName());
		test.log(Status.FAIL, result.getThrowable());

		try {
			String screenShotName=WebDriverUtility.takeScreenshot(BaseClass.sdriver, result.getMethod().getMethodName());
			test.addScreenCaptureFromPath(screenShotName);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		//		
		//		JavaUtility java=new JavaUtility();
		//		String date = java.getSystemDateAndTimeInISTFormat();
		//		
		//		String testName = result.getMethod().getMethodName();
		//		EventFiringWebDriver eDriver=new EventFiringWebDriver(BaseClass.sdriver);
		//		File src = eDriver.getScreenshotAs(OutputType.FILE);
		//		try {
		//			FileUtils.copyFile(src, new File("./src/test/resources/Photos/"+testName+".png"));
		//	}
		//		catch(IOException e)
		//		{
		//			e.printStackTrace();
		//		}
	}
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

		test.log(Status.SKIP, result.getMethod().getMethodName());
		test.log(Status.SKIP, result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		ExtentSparkReporter spark=new ExtentSparkReporter("./ExtentReports/report.html");
		spark.config().setTheme(Theme.DARK);
		spark.config().setReportName("Framework Extent Report");
		spark.config().setDocumentTitle("Tejas's document");

		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("caretedBy", "Tejas");
		report.setSystemInfo("ReviewedBy", "Deepak");
		report.setSystemInfo("platform", "windows11");
		report.setSystemInfo("ServerName","ApacheTomcat");

	}
	public void onFinish(ITestContext context) {

		report.flush();

	}	
}	

