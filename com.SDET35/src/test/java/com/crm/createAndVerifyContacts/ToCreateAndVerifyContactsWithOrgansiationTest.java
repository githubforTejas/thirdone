package com.crm.createAndVerifyContacts;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.genericutility.BaseClass;
import com.crm.objectRepository.ContactsInfoPage;
import com.crm.objectRepository.ContactsPage;
import com.crm.objectRepository.CreateNewContactsPage;
import com.crm.objectRepository.CreateNewOrganizationPage;
import com.crm.objectRepository.HomePage;
import com.crm.objectRepository.OrganizationInfoPage;
import com.crm.objectRepository.OrganizationsPage;

public class ToCreateAndVerifyContactsWithOrgansiationTest extends BaseClass {
	@Test(groups="SmokeTest",retryAnalyzer = com.crm.genericutility.RetryAnalyserImp.class)
	public void toCreateAndVerifyContactsWithOrgansiationTest() throws IOException {

		//To get the random number
		int randomNum = java.getRandomNumber();

		//
		String mr = excel.getValueFromExcel("Contacts",2,10);
		String organizationName = excel.getValueFromExcel("Organizations",1,2)+randomNum;
		String bill_State = excel.getValueFromExcel("Organizations",1, 5)+randomNum;
		String bill_City = excel.getValueFromExcel("Organizations", 1,4)+randomNum;
		String bill_Country = excel.getValueFromExcel("Organizations", 1,6)+randomNum;
		String firstName = excel.getValueFromExcel("Contacts",1,2)+randomNum;
		String lastName = excel.getValueFromExcel("Contacts",1,3)+randomNum;
		String title = excel.getValueFromExcel("Contacts",1,8)+randomNum;
		String department = excel.getValueFromExcel("Contacts",1,7)+randomNum;
		String email = excel.getValueFromExcel("Contacts",1,4)+randomNum;
		String industry = excel.getValueFromExcel("Organizations", 3, 3);
		String type = excel.getValueFromExcel("Organizations", 3, 7);

		//creating organization
		HomePage home=new HomePage(driver);
		home.organizationsLink();

		OrganizationsPage orgPage=new OrganizationsPage(driver);
		orgPage.createOrganizationLookUpImg();

		CreateNewOrganizationPage createNewOrg=new CreateNewOrganizationPage(driver);
		createNewOrg.OrganizationName(organizationName);
		createNewOrg.IndustryDropdown(industry);
		createNewOrg.typeDropdown(type);
		createNewOrg.saveBtn();
		OrganizationInfoPage orgInfo=new OrganizationInfoPage(driver);
		String orgTitle = orgInfo.getOrganization().getText();		
		
		//To check whether the Organization is created or not
		SoftAssert soft=new SoftAssert();
		soft.assertTrue(orgTitle.contains(organizationName));
		System.out.println("Organization is created");
		
		
		home.contactsLink();
		ContactsPage contacts=new ContactsPage(driver);
		contacts.createContactsLookUpImg();


		CreateNewContactsPage createNewContact=new CreateNewContactsPage(driver);
		createNewContact.FirstNameDropDown(mr);
		createNewContact.firstNameTextEdit(firstName);
		createNewContact.lastNameTextEdit(lastName);
		String parentid = driver.getWindowHandle();
		createNewContact.orgNameLookUpImg();
		webUtil.switchToWindow(driver," Accounts&action");

		/*Set<String> allid= driver.getWindowHandles();
	for(String id:allid)
	{
		if(!id.equals(parentid))
		{
			driver.switchTo().window(id);
		}
	}*/

		createNewContact.searchTextField(organizationName); 
		createNewContact.searchBtn();
		createNewContact.selectOrg();
		driver.switchTo().window(parentid);

		createNewContact.title(title);
		createNewContact.department(department);
		createNewContact.email(email);
		createNewContact.saveBtn();
		ContactsInfoPage contactInfo=new ContactsInfoPage(driver);
		String contactTitle = contactInfo.getContactTitle().getText();
		
		//to verify whether the contact is created is created or not
		soft.assertTrue(contactTitle.contains(firstName));
		System.out.println("Contact is created");
		soft.assertAll();
		
		

	}
}

