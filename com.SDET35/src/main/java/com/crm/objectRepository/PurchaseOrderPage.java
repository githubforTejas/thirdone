package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchaseOrderPage {

	@FindBy(xpath="//img[@title='Create Purchase Order...']")
	private WebElement createPurchaseOrderLookUpImg;

	//Initialization
	public PurchaseOrderPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreatePurchaseOrderLookUpImg()
	{
		return createPurchaseOrderLookUpImg;
	}

	//Business Libraries
	public void createPurchaseOrderLookUpImg()
	{
		createPurchaseOrderLookUpImg.click();
	}	
}
