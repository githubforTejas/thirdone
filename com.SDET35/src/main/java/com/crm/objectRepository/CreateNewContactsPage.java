package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.genericutility.WebDriverUtility;

public class CreateNewContactsPage extends WebDriverUtility {

	//Declaration
	@FindBy(xpath="//select[@name='salutationtype']")
	private WebElement FirstNameDropDown;

	@FindBy(xpath="//input[@name='firstname']")
	private WebElement firstNameTextEdit;

	@FindBy(xpath="//input[@name='lastname']")
	private WebElement LastNameTextEdit;

	@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
	private WebElement orgNameLookUpImg;

	@FindBy(id="search_txt")
	private WebElement searchTextField;

	@FindBy(xpath="//input[@name='search']")
	private WebElement searchBtn;

	@FindBy(id="1")
	private WebElement selectOrg;

	@FindBy(xpath="//Select[@name='leadsource']")
	private WebElement leadSourceDropDown;

	@FindBy(id="title")
	private WebElement title;

	@FindBy(id="department")
	private WebElement department;

	@FindBy(id="email")
	private WebElement email;

	@FindBy(id="mobile")
	private WebElement mobileNumber;

	@FindBy(id="jscal_trigger_birthday")
	private WebElement calender;

	@FindBy(xpath="//input[@class='crmbutton small save']")
	private WebElement saveBtn;

	//Initialization

	public CreateNewContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}


	//Utilization
	public WebElement getFirstNameDropDown() {
		return FirstNameDropDown;
	}

	public WebElement getFirstNameTextEdit() {
		return firstNameTextEdit;
	}

	public WebElement getLastNameTextEdit() {
		return LastNameTextEdit;
	}

	public WebElement getLeadSourceDropDown() {
		return leadSourceDropDown;
	}

	public WebElement getTitle() {
		return title;
	}

	public WebElement getDepartment() {
		return department;
	}

	public WebElement getEmail() {
		return email;
	}

	public void calender()
	{
		calender.click();
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	//Business Libraries

	public void FirstNameDropDown(String value)
	{
		selectDropDown(FirstNameDropDown, value);
	}

	public void firstNameTextEdit(String firstName)
	{
		firstNameTextEdit.sendKeys(firstName);
	}
	public void lastNameTextEdit(String lastName)
	{
		LastNameTextEdit.sendKeys(lastName);
	}

	public void orgNameLookUpImg()
	{
		orgNameLookUpImg.click();
	}

	public void searchTextField(String organizationName)
	{
		searchTextField.sendKeys(organizationName);
	}

	public void searchBtn()
	{
		searchBtn.click();
	}
	public void selectOrg()
	{
		selectOrg.click();
	}

	public void leadSourceDropDown(String value)
	{
		selectDropDown(leadSourceDropDown, value);
	}

	public void title(String titleName)
	{
		title.sendKeys(titleName);
	}

	public void department(String departmentName)
	{
		department.sendKeys(departmentName);
	}
	public void email(String mailid)
	{
		email.sendKeys(mailid);
	}

	public void mobileNumber(String mobileNo)
	{
		mobileNumber.sendKeys(mobileNo);
	}
	public void saveBtn()
	{
		saveBtn.click();
	}

}
