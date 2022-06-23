package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.genericutility.WebDriverUtility;

public class HomePage extends WebDriverUtility{

	@FindBy(xpath="//a[.='Organizations']")
	private WebElement organizationsLink;

	@FindBy(xpath="//a[.='Contacts']")
	private WebElement contactsLink;

	@FindBy(xpath="//a[.='Products']")
	private WebElement productsLink;

	@FindBy(xpath="//a[.='More']")
	private WebElement moreLink;

	@FindBy(xpath="//a[.='Campaigns']")
	private WebElement campaigns;
	
	@FindBy(xpath="//a[@id='more' and .='Vendors']")
	private WebElement vendorLink;
	
	@FindBy(xpath="//a[.='Purchase Order']")
	private WebElement purchaseOrderLink;

	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement Administration;

	@FindBy(xpath="//a[.='Sign Out']")
	private WebElement signOutLink;

	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	//Utilization

	public WebElement getOrganizationsLink() {
		return organizationsLink;
	}

	public WebElement getContactsLink() {
		return contactsLink;
	}

	public WebElement getProductsLink() {
		return productsLink;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getAdministration() {
		return Administration;
	}

	public WebElement getSignOutLink() {
		return signOutLink;
	}

	//Utilization
	public void organizationsLink()
	{
		organizationsLink.click();
	}

	public void contactsLink()
	{
		contactsLink.click();
	}

	public void productsLink()
	{
		productsLink.click();
	}

	public void moreLink(WebDriver driver)
	{
		mouseHoverOnElement(driver,moreLink );
	}

	public void campaigns()
	{
		campaigns.click();
	}
	
	public void vendorLink()
	{
		vendorLink.click();
	}
	
	public void purchaseOrderLink()
	{
		purchaseOrderLink.click();
	}

	public void administration(WebDriver driver)
	{
		mouseHoverOnElement(driver,Administration);
	}

	public void signOutLink()
	{
		signOutLink.click();
	}		
}
