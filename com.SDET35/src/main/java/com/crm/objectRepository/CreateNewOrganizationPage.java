package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.genericutility.WebDriverUtility;

public class CreateNewOrganizationPage extends WebDriverUtility {
	@FindBy(xpath="//input[@name='accountname']")
	private WebElement OrganizationName;

	@FindBy(xpath="//Select[@name='industry']")
	private WebElement IndustryDropdown;

	@FindBy(xpath="//Select[@name='accounttype']")
	private WebElement typeDropdown;

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;


	//Initialization
	public CreateNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}


	//Utilization
	public WebElement getOrganizationName() {
		return OrganizationName;
	}

	public WebElement getIndustryDropdown() {
		return IndustryDropdown;
	}

	public WebElement getTypeDropdown() {
		return typeDropdown;
	}

	public WebElement getsaveBtn()
	{
		return saveBtn;
	}

	//Business Libraries
	public void OrganizationName(String organizationName)
	{
		OrganizationName.sendKeys(organizationName);
	}

	public void IndustryDropdown(String visible_Text)
	{
		selectDropDownByVisibleText(IndustryDropdown,visible_Text);
	}
	public void typeDropdown(String visible_Text)
	{
		selectDropDownByVisibleText(typeDropdown,visible_Text);
	}
	public void saveBtn()
	{
		saveBtn.click();
	}
}
