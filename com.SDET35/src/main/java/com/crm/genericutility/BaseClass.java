package com.crm.genericutility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.crm.objectRepository.HomePage;
import com.crm.objectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass
{
	public static WebDriver sdriver; ;
	public WebDriver driver;
	public DataBaseUtility dBUtil=new DataBaseUtility();
	public ExcelUtility excel=new ExcelUtility();
	public FileUtility file=new FileUtility();
	public JavaUtility java=new JavaUtility();
	public WebDriverUtility webUtil=new WebDriverUtility();

	@BeforeSuite(groups={"SmokeTest","regressionTest"})
	public void connectToDataBase()
	{
		dBUtil.connectToDb();
	}
	//@Parameters("BROWSER")
	@BeforeClass(groups={"SmokeTest","regressionTest"})
	public void launchTheBrowser() throws IOException
	{
		String BROWSER = System.getProperty("browser");
		String URL = System.getProperty("url");
		
		//String BROWSER = file.getPropertyKeyValue("BROWSER");
		//String URL = file.getPropertyKeyValue("URL");


		if(BROWSER.equalsIgnoreCase("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();	
			driver=new FirefoxDriver();	
		}
		else if(BROWSER.equalsIgnoreCase("Chrome"))	
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();	
		}

		else
		{
			WebDriverManager.firefoxdriver().setup();	
			driver=new FirefoxDriver();	
		}
		//sdriver=driver;
		webUtil.WaitForPageToLoad(driver);	
		driver.manage().window().maximize();
		driver.get(URL);	
	}

	@BeforeMethod(groups={"SmokeTest","regressionTest"})
	public void loginToAppln() throws IOException
	{
		String USERNAME = file.getPropertyKeyValue("USERNAME");
		String PASSWORD = file.getPropertyKeyValue("PASSWORD");


		LoginPage login=new LoginPage(driver);
		login.usernameTextEdit(USERNAME);
		login.passwordtextEdit(PASSWORD);	
		login.loginBtn();
	}

	@AfterMethod(groups={"SmokeTest","regressionTest"})
	public void logOutFromAppln()
	{
		HomePage home=new HomePage(driver);
		home.administration(driver);
		home.signOutLink();
	}

	@AfterClass(groups={"smokeTest","regressionTest"})
	public void closeTheBrowser()
	{
		driver.quit();
	}

	@AfterSuite(groups={"smokeTest","regressionTest"})
	public void closeTheDataBase()
	{
		dBUtil.closeTheDataBase();
	}
}
