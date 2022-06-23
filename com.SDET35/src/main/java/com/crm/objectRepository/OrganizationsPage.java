package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {

	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement createOrganizationLookUpImg;

	//Initialization
	public OrganizationsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	//Utilization
	public WebElement  getCreateOrganizationLookUpImg() 
	{
		return createOrganizationLookUpImg;
	}

	//Business Libraries
	public void createOrganizationLookUpImg()
	{
		createOrganizationLookUpImg.click();
	}

}
