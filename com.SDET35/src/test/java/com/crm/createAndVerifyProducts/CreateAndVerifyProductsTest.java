package com.crm.createAndVerifyProducts;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.genericutility.BaseClass;
import com.crm.genericutility.ExcelUtility;
import com.crm.genericutility.FileUtility;
import com.crm.genericutility.JavaUtility;
import com.crm.genericutility.WebDriverUtility;
import com.crm.objectRepository.CreateNewProductsPage;
import com.crm.objectRepository.HomePage;
import com.crm.objectRepository.LoginPage;
import com.crm.objectRepository.ProductsInfoPage;
import com.crm.objectRepository.ProductsPage;

import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(com.crm.genericutility.ListImplimentation.class)
public class CreateAndVerifyProductsTest extends BaseClass
{
	@Test(groups="SmokeTest",retryAnalyzer = com.crm.genericutility.RetryAnalyserImp.class)
	public void createAndVerifyProductsTest() throws IOException {

		//to get random number(RAJAKUMARA)
		int randomNum = java.getRandomNumber();

		//to get data from excel
		String productN = excel.getValueFromExcel("Products",1, 2)+randomNum;
		String productCategory = excel.getValueFromExcel("Products",3,4);
		String manufacturer = excel.getValueFromExcel("Products",3,5);

		//Click on Products link
		HomePage home=new HomePage(driver);
		home.productsLink();

		ProductsPage product=new ProductsPage(driver);
		product.createNewProductsLookUpImg();

		CreateNewProductsPage newProduct=new CreateNewProductsPage(driver);
		newProduct.productName(productN);
		newProduct.productCategory(productCategory);
		newProduct.manufacturer(manufacturer);
		newProduct.saveBtn();

		
		ProductsInfoPage info=new ProductsInfoPage(driver);
		String productTitle = info.getProduct().getText();

		//to check whether the product is created or not
		SoftAssert sAssert=new SoftAssert();
		sAssert.assertTrue(productTitle.contains(productN));  
		System.out.println("Product is created");
		sAssert.assertAll();

	}
}
