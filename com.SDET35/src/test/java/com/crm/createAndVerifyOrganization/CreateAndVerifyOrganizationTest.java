package com.crm.createAndVerifyOrganization;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.genericutility.BaseClass;
import com.crm.genericutility.ExcelUtility;
import com.crm.genericutility.FileUtility;
import com.crm.genericutility.JavaUtility;
import com.crm.genericutility.WebDriverUtility;
import com.crm.objectRepository.CreateNewOrganizationPage;
import com.crm.objectRepository.HomePage;
import com.crm.objectRepository.LoginPage;
import com.crm.objectRepository.OrganizationInfoPage;
import com.crm.objectRepository.OrganizationsPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateAndVerifyOrganizationTest extends BaseClass{
	@Test(groups="SmokeTest",retryAnalyzer = com.crm.genericutility.RetryAnalyserImp.class)
	public void createAndVerifyOrganizationTest() throws IOException, InterruptedException {


		//to get the random number
		int randomNum = java.getRandomNumber();

		//TO get the data from excel

		String orgName = excel.getValueFromExcel("Organizations", 1, 2)+randomNum;
		String industry = excel.getValueFromExcel("Organizations", 3, 3);
		String type = excel.getValueFromExcel("Organizations", 3, 7);

		HomePage home=new HomePage(driver);
		home.organizationsLink();
		OrganizationsPage org=new OrganizationsPage(driver);
		org.createOrganizationLookUpImg();
		CreateNewOrganizationPage newOrg=new CreateNewOrganizationPage(driver);
		newOrg.OrganizationName(orgName);
		newOrg.IndustryDropdown(industry);
		newOrg.typeDropdown(type);
		newOrg.saveBtn();	
		OrganizationInfoPage orgInfo=new OrganizationInfoPage(driver);
		String actualTitle = orgInfo.getOrganization().getText();

		//to verify whether the organization is created or not
		
		SoftAssert soft=new SoftAssert();
		soft.assertTrue(actualTitle.contains(orgName));
		System.out.println("Orgnization is created");
		soft.assertAll();

	}
}
