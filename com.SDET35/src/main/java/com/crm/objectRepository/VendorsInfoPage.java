package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorsInfoPage {

	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement vendortitle;


	public VendorsInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	public WebElement getVendortitle() {
		return vendortitle;
	}

}
