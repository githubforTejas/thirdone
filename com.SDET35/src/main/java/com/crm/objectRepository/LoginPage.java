package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	@FindBy(name="user_name")
	private WebElement usernameTextEdit;

	@FindBy(name="user_password")
	private WebElement passwordtextEdit;

	@FindBy(id="submitButton")
	private WebElement loginBtn;


	//Initialization
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	//Utilization

	public WebElement getUsernameTextEdit()
	{
		return usernameTextEdit;
	}

	public WebElement getPasswordTextEdit()
	{
		return passwordtextEdit;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	//Business Libraries
	public void usernameTextEdit(String USERNAME)
	{
		usernameTextEdit.sendKeys(USERNAME);
	}

	public void passwordtextEdit(String PASSWORD)
	{
		passwordtextEdit.sendKeys(PASSWORD);
	}

	public void loginBtn()
	{
		loginBtn.click();
	}
}
