package com.crm.objectRepository;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.genericutility.WebDriverUtility;

public class CreateNewPurchaseOrderPage extends WebDriverUtility

{

	@FindBy(xpath="//input[@name='subject']")
	private WebElement subject;

	@FindBy(xpath="(//img[@src='themes/softed/images/select.gif'])[1]")
	private WebElement vendorNameLookUpImg;

	@FindBy(id="search_txt")
	private WebElement searchFieldForVendor;

	@FindBy(xpath="//input[@class='crmbutton small create']")
	private WebElement searchBtn;

	@FindBy(id="1")
	private WebElement selectVendor;

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	@FindBy(xpath="//select[@name='postatus']")	
	private WebElement statusDropDown;
	
	@FindBy(xpath="//input[@value='U']")
	private WebElement userRadioBtn;

	@FindBy(xpath="//input[@value='T']")
	private WebElement AssignedToRadioBtn;

	@FindBy(xpath="//select[@name='assigned_group_id']")
	private WebElement AssignedToDropDown;

	@FindBy(xpath="//textarea[@name='bill_street']")
	private WebElement billingAddres;

	@FindBy(xpath="//textarea[@name='ship_street']")
	private WebElement shippingAddress ;

	@FindBy(id="searchIcon1")
	private WebElement itemName;

	@FindBy(id="search_txt")
	private WebElement searchFieldForProduct;

	@FindBy(xpath="//input[@class='crmbutton small create']")	
	private WebElement searchBtnForProduct;

	@FindBy(id="popup_product_126")	
	private WebElement selectProduct;

	@FindBy(id="qty1")	
	private WebElement qty;

	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement purchaseordertitle;

	//Initialization

	public CreateNewPurchaseOrderPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getSubject() {
		return subject;
	}

	public WebElement getVendorNameLookUpImg() {
		return vendorNameLookUpImg;
	}

	public WebElement getSearchFieldForVendor() {
		return searchFieldForVendor;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getSelectVendor() {
		return selectVendor;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getCancelledStatusDropDown() {
		return statusDropDown;
	}

	public WebElement getAssignedToRadioBtn() {
		return AssignedToRadioBtn;
	}

	public WebElement getAssignedToDropDown() {
		return AssignedToDropDown;
	}

	public WebElement getBillingAddres() {
		return billingAddres;
	}

	public WebElement getShippingAddress() {
		return shippingAddress;
	}

	public WebElement getItemName() {
		return itemName;
	}

	public WebElement getSearchFieldForProduct() {
		return searchFieldForProduct;
	}

	public WebElement getSearchBtnForProduct() {
		return searchBtnForProduct;
	}

	public WebElement getSelectProduct() {
		return selectProduct;
	}

	public WebElement getQty() {
		return qty;
	}

	public WebElement getPurchaseordertitle() {
		return purchaseordertitle;
	}

	//Business Libraries

	public void subject(String purchaseOrderSubject)
	{
		subject.sendKeys(purchaseOrderSubject);
	}

	public void vendorNameLookUpImg()
	{
		vendorNameLookUpImg.click();
	}

	public void searchFieldForVendor(String vendorN)
	{
		searchFieldForVendor.sendKeys(vendorN);
	}

	public void searchBtn() 
	{
		searchBtn.click();
	}

	public void selectVendor()
	{
		selectVendor.click();
	}

	public void saveBtn()
	{
		saveBtn.click();
	}

	public void status(String statusValue) 
	{
		selectDropDown(statusDropDown, statusValue);
	}
	
	public void radioBtnForUser()
	{
		userRadioBtn.click();
	}

	public void AssignedToRadioBtn()
	{
		AssignedToRadioBtn.click();
	}

	public void AssignedToDropDown(String value)
	{
		selectDropDownByVisibleText(AssignedToDropDown, value);
	}

	public void billingAddres(String PoBillingAddress)
	{
		billingAddres.sendKeys(PoBillingAddress);
	}

	public void shippingAddress(String PoBillingAddress)
	{
		shippingAddress.sendKeys(PoBillingAddress);
	}

	public void itemName()
	{
		itemName.click();
	}

	public void searchFieldForProduct(String productN)
	{
		searchFieldForProduct.sendKeys(productN);
	}

	public void searchBtnForProduct()
	{
		searchBtnForProduct.click();
	}

	public void selectProduct()
	{
		selectProduct.click();
	}

	public void qty(String qtty)
	{
		qty.sendKeys(qtty);
	}

}
