package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignsPage {


	//Declaration
	@FindBy(xpath="//img[@title='Create Campaign...']")
	private WebElement createCampaignLookUpImage;


	//Initialization
	public CampaignsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);	
	}

	//Utilization
	public WebElement getCreateCampaignLookUpImage() 
	{
		return createCampaignLookUpImage;
	}

	//Business Libraries
	public void createCampaignLookUpImage()
	{
		createCampaignLookUpImage.click();
	}





}
