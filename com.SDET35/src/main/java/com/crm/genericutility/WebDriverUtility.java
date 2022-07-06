package com.crm.genericutility;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * it will wait for 10 seconds till the page gets loaded 
 * @author Admin
 *
 */
public class WebDriverUtility {
	public void WaitForPageToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	/**
	 * it will check for the element in the GUI for polling time of 500ms
	 */
	public void WaitForElementTOBeClickable(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(element));			
	}
	/**
	 * it will check for the title in the GUI for polling time of 500ms 
	 */
	public void waitForTitleContains(WebDriver driver,String title)
	{
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.titleContains(title));
	}
	/**
	 * Here we can change the polling time from default 500ms to any polling time
	 */
	public void waitForElementToCustom(WebDriver driver,int pollingTime,WebElement element)
	{
		FluentWait wait=new FluentWait(driver);
		wait.pollingEvery(pollingTime, TimeUnit.SECONDS);
		wait.ignoring(Exception.class);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**here we are giving custom timeout
	 * @throws InterruptedException 
	 * 
	 */
	public void waitAndClick(WebElement element) throws InterruptedException
	{
		int count=0;
		while(count<10)
		{
			try {
				element.click();
			}
			catch(Exception e)
			{
				Thread.sleep(1000);
				count++;
			}
		}
	}
	/**
	 * Used to switch from one window to another window
	 */
	public void switchToWindow(WebDriver driver,String partialWindow)
	{
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while(it.hasNext())
		{
			String ele = it.next();
			driver.switchTo().window(ele);
			String currentWindow = driver.getTitle();
			if(currentWindow.contains(partialWindow))
			{
				break;
			}
		}
	}
	/**
	 * switch from one frame to another frame using index
	 */
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	/**
	 * switch from one frame to another frame using id_attribute
	 */
	public void switchToFrame(WebDriver driver,String id_attribute)
	{
		driver.switchTo().frame(id_attribute);
	}
	/**
	 * switch from one frame to another frame using x path
	 */
	public void switchToFrame(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
	}
	/**
	 * it is used to switch back from any child frame to main parent frame
	 * @param driver
	 */
	public void switchBackToMainWindow(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	/**
	 * 
	 * @param driver
	 */
	public void switchToAlertPopupAndAccept(WebDriver driver )
	{
		driver.switchTo().alert().accept();
	}
	/**
	 * 
	 */
	public void switchToAlertPopupAndDismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	/**
	 * it is used to select an option from the dropdown by using index
	 */
	public void selectDropDown(WebElement element,int index)
	{
		Select select=new Select(element);
		select.selectByIndex(index);
	}
	/**
	 * it is used to select an option from the dropdown using value
	 */
	public void selectDropDown(WebElement element,String value)
	{
		Select select=new Select(element);
		select.selectByValue(value);
	}
	/**
	 * it is used to select an option from the dropdown by using visible text
	 * @param element
	 * @param visible_Text
	 */
	public void selectDropDownByVisibleText(WebElement element,String visible_Text)
	{
		Select select=new Select(element);
		select.selectByVisibleText(visible_Text);
	}
	/**
	 * it is used to mouse hover on the element
	 */
	public void mouseHoverOnElement(WebDriver driver,WebElement element)
	{
		Actions actions=new Actions(driver);
		actions.moveToElement(element).perform();
	}
	/**
	 * it is used to right click on the element
	 * @param driver
	 */
	public void rightClickOnTheElement(WebDriver driver,WebElement element)
	{
		Actions action=new Actions(driver);
		action.contextClick(element).perform();

	}
	/**
	 * it is used to click on enter button using keyboard
	 */
	public void clickOnEnterButton(WebDriver driver)
	{
		Actions actions=new Actions(driver);
		actions.sendKeys(Keys.ENTER).perform();
	}
	/**
	 * @throws IOException 
	 * 
	 */
	public static String takeScreenshot(WebDriver driver,String screenShotName) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File("./src/test/resources/Photos/"+screenShotName+".png");
		Files.copy(src, dst);
		return screenShotName;
	}
	/**
	 * 
	 * @param driver
	 */
	public void scrollBarAction(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
	}
}
