package com.bhumi.SampleMaven.base;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
// getTitle, switchToAlert acceptAlert DismissAlert getTextFromAlert
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	protected WebDriver driver = null;
	protected Wait<WebDriver> wait = null;
	protected Logger baseTestlog=LogManager.getLogger();

	public void launchBrowser(String browserName) {

		switch (browserName.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			baseTestlog.info("browser instance chrome created.");
			driver.manage().window().maximize();
			baseTestlog.info("window is maximized");
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			break;

		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			break;

		

		case "safari":
			// Safari does not require a separate driver setup, as it is included with macOS
			driver = new SafariDriver();
			break;

		default:
			baseTestlog.info("Unsupported browser: " + browserName);
			Reporter.log("Unsupported browser: " + browserName);
		}

		// return driver;
	}
	
	public void goToUrl(String url) {
		driver.get(url);
		baseTestlog.info(url + "is entered");
		Reporter.log(url + "is entered");
		
	}

	public void enterText(WebElement ele, String data, String objectName) {
		if (ele.isDisplayed()) {
			ele.clear();
			ele.sendKeys(data);
			baseTestlog.info("data is entered in " + objectName + " textbox");
			Reporter.log("data is entered in " + objectName + " textbox");
		} else {
			baseTestlog.info(objectName + " element is not displayed");
			Reporter.log(objectName + " element is not displayed");
		}
	}
	
	public void clickElement(WebElement ele, String objectName) {
		if (ele.isEnabled()) {
			ele.click();
			baseTestlog.info(objectName + " button is clicked");
			Reporter.log(objectName + " button is clicked");
			
		} else {
			baseTestlog.info(objectName+" element is not enabled");
			Reporter.log(objectName+" element is not enabled");
			
		}
	}
	
	public String getTextFromElement(WebElement ele, String objectName) {
		String data = ele.getText();
		baseTestlog.info(" text is extracted from "+objectName);
		Reporter.log(" text is extracted from "+objectName);
		return data;
	}
	
	public void closeBrowser() {
		driver.quit();
		baseTestlog.info("browser instance closed");
		Reporter.log("browser instance closed");
		driver=null;
	}
	
	
	public void maximiseBrowser() {
		driver.manage().window().maximize();
		//baseTestlog.info("browser window has maximized");
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public void refreshPage() {
		driver.navigate().refresh();
		baseTestlog.info("page is refreshed");
		Reporter.log("page is refreshed");
	}



	public void quitBrowser() {
		driver.quit();
		baseTestlog.info("all browser closed");
		Reporter.log("all browser closed");
		driver=null;
		
	}

	

	public void clearElement(WebElement ele, String ObjectName) {
		if (ele.isDisplayed()) {
			ele.clear();
			baseTestlog.info(ObjectName + " is cleared");
			Reporter.log(ObjectName + " is cleared");
		} else {
			baseTestlog.info(ObjectName + " element is not cleared");
			Reporter.log(ObjectName + " is not cleared");
		}
	}

	

	// ****************handling alerts reusable methods*************************

//	public Alert switchToAlert() {
//
//		Alert alert = new Alert();
//	}
//
//	public void AcceptAlert(Alert alert) {
//
//		
//
//	}
//
//	public String getAlertText(Alert alert, String objectname) {
//		
//
//	}

	public void dismisAlert() {

		

	}
	// ******************************alert ends**************************************

	// ******************************Action class reusable methods**************************************
	

	public void mouseOverOnElement(WebElement ele, String objName) {
		Actions action = new Actions(driver);
		action.moveToElement(ele).perform();
		
	}

	public void ContextClickOnElement(WebElement ele, String objName) {
		
	}

	// ******************************Action class reusable method ends**************************************

	// ******************************Select class reusable method starts*************************************

	public void selectByTextData(WebElement element, String text, String objName) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
		baseTestlog.info(text + " selected in " + objName + " dropdown");
		Reporter.log(text + " selected in " + objName + " dropdown");
		

	}

	public void selectByIndexData(WebElement element, int index, String objName) {
		Select select = new Select(element);
		select.selectByIndex(index);
		//select.selectByVisibleText(text);
		baseTestlog.info(objName + " dropdown value selected");
		Reporter.log(objName + " dropdown value selected");

	}

	public void selectByValueData(WebElement element, String value, String objName) {
		Select select = new Select(element);
		select.selectByValue(value);
		baseTestlog.info(value + " selected in " + objName + " dropdown");
		Reporter.log(value + " selected in " + objName + " dropdown");
	}
	
//	public WebElement selectFromListUsingText(List<WebElement> list, String text) {
//		
//
//	}

	// ******************************select class reusable method ends**************************************

	// ******************************wait reusable method starts**************************************

	public void waitUntilPageLoads() {
		WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		webDriverWait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
	}
	public void waitForVisibility(WebElement ele, int time, int pollingtime, String objectName) {
		WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(time));
		webDriverWait.until(ExpectedConditions.visibilityOf(ele));
		System.out.println("Waiting");
	}

	public void WaitUntilPresenceOfElementLocatedBy(By locator, String objName) {
		
		//WebElement ele  = driver.findElement(locator);
		WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		webDriverWait.until(ExpectedConditions.presenceOfElementLocated(locator));
		System.out.println("Waiting");

	}

	public void waitUntilElementToBeClickable(By locator, String objName) {
		WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		webDriverWait.until(ExpectedConditions.elementToBeClickable(locator));
		System.out.println("Waiting");
	}

	public void waitForVisibility(WebElement ele, int time, String objectName) {
		
	}

	public void waitForAlertPresent(int time) {
		
	}

	
	public  String getCurrentDate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
	}
	
		
	
}
