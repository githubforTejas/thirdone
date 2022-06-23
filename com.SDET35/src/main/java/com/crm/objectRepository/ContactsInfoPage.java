package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsInfoPage {
	//Declaration
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement contactsTitle;

	//Initialization
	public ContactsInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	//Utilization
	public WebElement getContactTitle() {
		return contactsTitle;
	}
}
