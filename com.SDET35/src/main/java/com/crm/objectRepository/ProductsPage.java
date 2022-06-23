package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {

	//Declaration
	@FindBy(xpath="//img[@title='Create Product...']")
	private WebElement createNewProductsLookUpImg;

	//Initialization
	public ProductsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//UtiliZation
	public WebElement getCreateNewProductsLookUpImg() {
		return createNewProductsLookUpImg;
	}

	//Business Libraries
	public void createNewProductsLookUpImg()
	{
		createNewProductsLookUpImg.click();
	}






}
