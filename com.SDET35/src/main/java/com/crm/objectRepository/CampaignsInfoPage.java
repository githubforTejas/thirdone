package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignsInfoPage {
	//Declaration
@FindBy(xpath="//span[@class='dvHeaderText']")
private WebElement campaignTitle;  

//Initialization
public CampaignsInfoPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

//Utilization
public WebElement getCampaignTitle() {
	return campaignTitle;
}
}
