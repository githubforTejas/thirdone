package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewVendorPage {
	@FindBy(xpath="//input[@name='vendorname']")
	private WebElement vendorName;

	@FindBy(xpath="(//input[@value='  Save  '])[2]")
	private WebElement saveBtn;


	public CreateNewVendorPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	public WebElement getvendorName() 
	{
		return vendorName;
	}

	public WebElement getsaveBtn() 
	{
		return saveBtn;
	}

	public void vendorName(String vendorN)
	{
		vendorName.sendKeys(vendorN);;
	}

	public void saveBtn() 
	{
		saveBtn.click();
	}
}
