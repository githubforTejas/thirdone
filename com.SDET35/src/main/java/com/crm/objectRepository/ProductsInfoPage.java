package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsInfoPage {

	//Declaration
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement productTitle;

	//Initialization
	public ProductsInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	//Utilization
	public WebElement getProduct()
	{
		return productTitle;
	}
}
