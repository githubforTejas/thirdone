package com.crm.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.genericutility.WebDriverUtility;

public class CreateNewProductsPage extends WebDriverUtility {

	//Declaration
	@FindBy(xpath="//input[@name='productname']")
	private WebElement productName;

	@FindBy(xpath="//select[@name='productcategory']")
	private WebElement productCategory;

	@FindBy(xpath="//Select[@name='manufacturer']")
	private WebElement manufacturer;

	@FindBy(xpath="//input[@name='assigntype' and @value='T']")
	private WebElement groupRadioBtn;

	@FindBy(xpath="(//input[@value='  Save  '])[2]")
	private WebElement saveBtn;

	//Initialization
	public CreateNewProductsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getProductName() {
		return productName;
	}

	public WebElement getProductCategory() {
		return productCategory;
	}

	public WebElement getManufacturer() {
		return manufacturer;
	}

	public WebElement getGroupRadioBtn() {
		return groupRadioBtn;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	//Business Libraries

	public void productName(String productN)
	{
		productName.sendKeys(productN);
	}

	public void productCategory(String value)
	{
		selectDropDown(productCategory, value);
	}


	public void manufacturer(String value)
	{
		selectDropDown(manufacturer, value);
	}

	public void groupRadioBtn()
	{
		groupRadioBtn.click();
	}


	public void saveBtn()
	{
		saveBtn.click();
	}









}
