package com.crm.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.genericutility.WebDriverUtility;

public class CreateNewCampaignsPage extends WebDriverUtility{
	//Declaration
	@FindBy(xpath="//input[@name='campaignname']")
	private WebElement campaignname;

	@FindBy(xpath="//Select[@name='campaigntype']")
	private WebElement campaigntype;

	@FindBy(xpath="//Select[@name='expectedresponse']")
	private WebElement expectedresponse;

	@FindBy(xpath="//Select[@name='campaignstatus']")
	private WebElement campaignstatus;

	@FindBy(xpath="//img[@title='Select']")
	private WebElement productLookUpImg;

	@FindBy(id="search_txt")
	private WebElement searchField;

	@FindBy(xpath="//input[@name='search']")
	private WebElement searchBtn;

	@FindBy(id="1")
	private WebElement selectProduct;

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;



	//Initialization
	public CreateNewCampaignsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	//Utilization
	public WebElement getCampaignname() {
		return campaignname;
	}


	public WebElement getCampaigntype() {
		return campaigntype;
	}


	public WebElement getExpectedresponse() {
		return expectedresponse;
	}


	public WebElement getCampaignstatus() {
		return campaignstatus;
	}

	public WebElement getProductLookUpImg() {
		return productLookUpImg;
	}

	public WebElement getSearchField() {
		return searchField;
	}


	public WebElement getSearchBtn() {
		return searchBtn;
	}


	public WebElement getSelectProduct() {
		return selectProduct;
	}

	public WebElement getSaveBtn()
	{
		return saveBtn;
	}


	//Business Libraries
	public void campaignname(String campaignN)
	{
		campaignname.sendKeys(campaignN);
	}

	public void campaigntype(String value)
	{
		selectDropDown(campaigntype,value);
	}

	public void expectedresponse(String value)
	{
		selectDropDown(expectedresponse,value);
	}


	public void campaignstatus(String value)
	{
		selectDropDown(campaignstatus,value);
	}

	public void productLookUpImg()
	{
		productLookUpImg.click();
	}

	public void searchField(String productName)
	{
		searchField.sendKeys(productName);
	}

	public void searchBtn()
	{
		searchBtn.click();
	}

	public void selectProduct()
	{
		selectProduct.click();
	}

	public void saveBtn()
	{
		saveBtn.click();
	}




}
