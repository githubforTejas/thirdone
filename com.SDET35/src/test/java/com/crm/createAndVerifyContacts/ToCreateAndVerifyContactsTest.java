package com.crm.createAndVerifyContacts;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.genericutility.BaseClass;
import com.crm.genericutility.ExcelUtility;
import com.crm.genericutility.FileUtility;
import com.crm.genericutility.JavaUtility;
import com.crm.genericutility.WebDriverUtility;
import com.crm.objectRepository.ContactsInfoPage;
import com.crm.objectRepository.ContactsPage;
import com.crm.objectRepository.CreateNewContactsPage;
import com.crm.objectRepository.HomePage;
import com.crm.objectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(com.crm.genericutility.ListImplimentation.class)
public class ToCreateAndVerifyContactsTest extends BaseClass{

	@Test(groups="SmokeTest",retryAnalyzer = com.crm.genericutility.RetryAnalyserImp.class)
	public  void toCreateAndVerifyContactsTest() throws IOException, InterruptedException 
		
	{
		//(Hey hi Boss, is everything fine ?,how is the life )
		int randomNum = java.getRandomNumber();

		//to get the data from excel
		String mr = excel.getValueFromExcel("Contacts",2,10);
		String firstName = excel.getValueFromExcel("Contacts",1,2)+randomNum; 
		String lastName = excel.getValueFromExcel("Contacts",1,3)+randomNum;
		String title = excel.getValueFromExcel("Contacts",1,8)+randomNum;
		String department = excel.getValueFromExcel("Contacts",1,7)+randomNum;
		String email = excel.getValueFromExcel("Contacts",1,4)+randomNum;
		String mobileNo = excel.getNumericValueFromExcel("Contacts", 1, 5);

		//Click on Contacts link....
		HomePage home=new HomePage(driver);
		home.contactsLink();

		//Click on create contacts look up image
		ContactsPage contacts=new ContactsPage(driver);    
		contacts.createContactsLookUpImg();

		CreateNewContactsPage createContacts=new CreateNewContactsPage(driver);
		createContacts.FirstNameDropDown(mr);
		createContacts.firstNameTextEdit(firstName);
		createContacts.lastNameTextEdit(lastName);
		createContacts.title(title);
		createContacts.department(department);
		createContacts.email(email);
		createContacts.mobileNumber(mobileNo);
		createContacts.saveBtn();

		//Verify whether the contacts is created or not
		ContactsInfoPage contactInfo=new ContactsInfoPage(driver);
		String contactsTitle = contactInfo.getContactTitle().getText();
		SoftAssert soft=new SoftAssert();
		soft.assertTrue(contactsTitle.contains(firstName));
		System.out.println("Contact is created and verified thoroughly");
		soft.assertAll();
	}
}
