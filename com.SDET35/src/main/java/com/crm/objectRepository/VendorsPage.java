package com.crm.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorsPage {

	@FindBy(xpath="//img[@title='Create Vendor...']")
	private WebElement createVendorLookUpImg;


	public VendorsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	public WebElement getCreateVendorLookUpImg() 
	{
		return createVendorLookUpImg;
	}

	public void createVendorLookUpImg()
	{
		createVendorLookUpImg.click();
	}

}
