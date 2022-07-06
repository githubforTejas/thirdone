package com.crm.purchaseOrder;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
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
import com.crm.objectRepository.CreateNewPurchaseOrderPage;
import com.crm.objectRepository.CreateNewVendorPage;
import com.crm.objectRepository.HomePage;
import com.crm.objectRepository.LoginPage;
import com.crm.objectRepository.ProductsInfoPage;
import com.crm.objectRepository.ProductsPage;
import com.crm.objectRepository.PurchaseOrderPage;
import com.crm.objectRepository.VendorsInfoPage;
import com.crm.objectRepository.VendorsPage;

import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(com.crm.genericutility.ListImplimentation.class)
public class ToCreateAndVerifyPurchaseOrderAndSelectUserRadioButtonTest extends BaseClass{
	@Test(groups="regressionTest",retryAnalyzer = com.crm.genericutility.RetryAnalyserImp.class)
	public void toCreateAndVerifyPurchaseOrderAndSelectUserRadioButtonTest() throws EncryptedDocumentException, IOException {


		//to get the random number(.......................)
		Random random=new Random();
		int randomNum = random.nextInt(1000);


		//to get the data from excel

		String productN = excel.getValueFromExcel("Products",1, 2)+randomNum;
		String productCategory = excel.getValueFromExcel("Products",3,4);
		String manufacturer = excel.getValueFromExcel("Products",3,5);
		String vendorN = excel.getValueFromExcel("Vendors", 1, 2)+randomNum;
		String purchaseOrderSubject = excel.getValueFromExcel("Purchase order", 1, 2)+randomNum;
		String BillingAddress = excel.getValueFromExcel("Purchase order", 1, 4);
		String shippingAddress = excel.getValueFromExcel("Purchase order", 1, 5);
		String qty = excel.getValueFromExcel("Purchase order", 1, 6);
		String createdStatus = excel.getValueFromExcel("Purchase order", 1, 3);
		//String assignedToSupportGroup=excel.getValueFromExcel("Purchase order", 2, 7);


		//Click on Products link
		HomePage home=new HomePage(driver);
		home.productsLink();
		
                 //create an object
		ProductsPage product=new ProductsPage(driver);
		product.createNewProductsLookUpImg();

		CreateNewProductsPage newProduct=new CreateNewProductsPage(driver);
		newProduct.productName(productN);
		newProduct.productCategory(productCategory);
		newProduct.manufacturer(manufacturer);
		newProduct.saveBtn();

//hi all
		ProductsInfoPage info=new ProductsInfoPage(driver);
		String productTitle = info.getProduct().getText();

		//to verify whether the product is created or not

		SoftAssert soft=new SoftAssert();
		soft.assertTrue(productTitle.contains(productN));
		System.out.println("Product is created and verified");
		soft.assertAll();


		home.moreLink(driver);	
		home.vendorLink();

		VendorsPage vendors=new VendorsPage(driver);
		vendors.createVendorLookUpImg();

		CreateNewVendorPage createNewVendorPage=new CreateNewVendorPage(driver);

		createNewVendorPage.vendorName(vendorN);
		createNewVendorPage.saveBtn();

		VendorsInfoPage vendorsInfoPage=new VendorsInfoPage(driver);
		String vendorTitle = vendorsInfoPage.getVendortitle().getText();

		//to Check whether the vendor is created or not
		soft.assertTrue(vendorTitle.contains(vendorN));
		System.out.println("Vendor is created");
		soft.assertAll();

		home.moreLink(driver);
		//click on purchase order
		home.purchaseOrderLink();
		//click on create purchase order icon 
		PurchaseOrderPage purchaseOrderPage=new PurchaseOrderPage(driver);
		purchaseOrderPage.createPurchaseOrderLookUpImg();
		//Enter subject
		CreateNewPurchaseOrderPage createNewPurchaseOrder=new CreateNewPurchaseOrderPage(driver);
		createNewPurchaseOrder.subject(purchaseOrderSubject);
		//get the parent window id
		String parentid = driver.getWindowHandle();
		createNewPurchaseOrder.vendorNameLookUpImg();
		//get all the id's
		webUtil.switchToWindow(driver, "Vendors&action");
		driver.manage().window().maximize();
		//enter the vendor name
		createNewPurchaseOrder.searchFieldForVendor(vendorN);
		//click on search button
		createNewPurchaseOrder.searchBtn();
		//select the vendor 
		createNewPurchaseOrder.selectVendor();
		//switch to parent window
		driver.switchTo().window(parentid);
		//select an option from the dropdown
		createNewPurchaseOrder.status(createdStatus);
		createNewPurchaseOrder.radioBtnForUser();
		//enter billing address
		createNewPurchaseOrder.billingAddres(BillingAddress);
		//enter ship address
		createNewPurchaseOrder.shippingAddress(shippingAddress);
		//get the parent window id
		String parentid2 = driver.getWindowHandle();
		createNewPurchaseOrder.itemName();
		webUtil.switchToWindow(driver, "Products&action");
		//enter product name
		createNewPurchaseOrder.searchFieldForProduct(productN);
		//click on search now
		createNewPurchaseOrder.searchBtnForProduct();
		//select a product
		createNewPurchaseOrder.selectProduct();
		//switch the parent id
		driver.switchTo().window(parentid2);
		createNewPurchaseOrder.qty(qty);

		createNewPurchaseOrder.saveBtn();
		String poTitle = createNewPurchaseOrder.getPurchaseordertitle().getText();


		//verifying whether purchase order is created or not

		soft.assertTrue(poTitle.contains(purchaseOrderSubject));
		System.out.println("Purchase order is created");
		Assert.fail();
		soft.assertAll();
	}

}
