package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	
	//Declaration
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement orgTitle;

	//Initialization
	public OrganizationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	//Utilization
	public WebElement getOrganization()
	{
		return orgTitle;
	}
}
