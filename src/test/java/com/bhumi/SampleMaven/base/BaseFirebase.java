package com.bhumi.SampleMaven.base;

import java.io.File;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
// warning fatal bebug, info
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.bhumi.SampleMaven.utilities.Constants;
import com.bhumi.SampleMaven.utilities.PropertiesUtility;

public class BaseFirebase extends BaseTest{
	protected Logger BaseFirebasetlog=LogManager.getLogger();
	
	@BeforeMethod
	@Parameters("browserName")
	public void setUpBeforeMethod(@Optional("chrome") String name) {
		BaseFirebasetlog.info(".........BeforeMethod setUpBeforeMethod executed---------------");
		BaseFirebasetlog.info("Launching Salesforce");
		launchBrowser(name);
		String url=PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES,"url");
		goToUrl(url);
		driver.manage().window().maximize();
	}
	
	@AfterMethod
	public void tearDownAfterTestMethod() {
		closeBrowser();
		BaseFirebasetlog.info("******tearDownAfterTestMethod executed***********");
	}
	
	public void login_firebase() throws InterruptedException {
		
		String userName=PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES,"username");
		String passWord=PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES,"password");		
		Thread.sleep(5000);
		WebElement username= driver.findElement(By.id("email_field"));	
		enterText(username,userName,"username");
		WebElement password=driver.findElement(By.id("password_field"));
		enterText(password,passWord, "password");		
		WebElement loginButton= driver.findElement(By.tagName("button"));
		clickElement(loginButton, "login");
	}
	
	public void login_SalesForce() throws InterruptedException {
		String userName=PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES,"username");
		String passWord=PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES,"password");		
		//Thread.sleep(5000);
		BaseFirebasetlog.info("Entering UserName & Password and login to salesforce");
		Reporter.log("Entering UserName & Password and login to salesforce");
		this.WaitUntilPresenceOfElementLocatedBy(By.id("username"), "username");
		WebElement username= driver.findElement(By.id("username"));	
		enterText(username,userName,"username");
		//Reporter.log("UserName entered on login page");
		WebElement password=driver.findElement(By.id("password"));
		enterText(password,passWord, "password");		
		//Reporter.log("Password entered on login page");
		WebElement loginButton= driver.findElement(By.id("Login"));
		clickElement(loginButton, "login");
		//Reporter.log("Login Button Clicked");
		waitUntilPageLoads() ;
		BaseFirebasetlog.info("Login Successfull");
		Reporter.log("Login Successfull");
	}
	
	
	public void logout_SalesForce() throws InterruptedException {
		WebElement SalesForceUserMenu = driver.findElement(By.id("userNavButton"));
		
		clickElement(SalesForceUserMenu, "User Menu on Salesforce HomePage");
		
		Assert.assertEquals(SalesForceUserMenu.isDisplayed(), true,"SalesForce UserMenu not displayed");
		BaseFirebasetlog.info("Salesforce User Menu Displayed");
		Reporter.log("Salesforce User Menu Displayed");
		
		
		this.waitUntilElementToBeClickable(By.xpath("//a[@title='Logout']"), "Logout");
		WebElement logOut = driver.findElement(By.xpath("//*[@id='userNavMenu']//a[@title='Logout']"));
		clickElement(logOut, "Logout on Salesforce HomePage");
		BaseFirebasetlog.info("Logout Successfull");
		Reporter.log("Logout Successfull");
		//Thread.sleep(10000);
		waitUntilPageLoads() ;
	}
	
	
	public  boolean verifyFileDownloaded(String fileName) {
		File dir = new File("C:\\Users\\vinay\\Downloads");
		File[] dirList = dir.listFiles();
		boolean fileDownloaded = false;
		for(int i=0;i<dirList.length;i++) {
			if(dirList[i].getName().contains(fileName)){
				return true;
				
			}
		}
		return false;
	}
	
	public boolean  verifyDropDownContainsOptions(Select dropdown, String option) {
		// TODO Auto-generated method stub
		List<WebElement> dropdownOptions = dropdown.getOptions();
		for(WebElement w:dropdownOptions) {System.out.println(w.getText());}
		//System.out.println(dropdown.toString());
		boolean optionFound = false;
		for(int i=0;i<dropdownOptions.size();i++) {
			if(dropdownOptions.get(i).getText().equalsIgnoreCase(option)) {
				//System.out.println("Passed: " + option + " available in drop down as expected");
				optionFound = true;
				return optionFound;
			}
		}
		return optionFound;
	}
	
	public  boolean verifyDropDownOptions(Select dropdown, String option) {
		// TODO Auto-generated method stub
		List<WebElement> dropdownOptions = dropdown.getOptions();
		//System.out.println(dropdown.toString());
		
		for(int i=0;i<dropdownOptions.size();i++) {
			if(dropdownOptions.get(i).getText().equalsIgnoreCase(option)) {
				System.out.println("Passed: " + option + " available in drop down as expected");
				return true;
			}
		}
		return false;
		
	}
	
	public  void addSalesForceHomeCustomTab(String tabvalue,String tabName) throws InterruptedException {
		Thread.sleep(5000);
		
		Select tabSelect = new Select(driver.findElement(By.id("duel_select_0")));
		Select tabSelected = new Select(driver.findElement(By.id("duel_select_1")));
		
		
		boolean valueInTabselect = verifyDropDownContainsOptions(tabSelect, tabvalue);
		System.out.println(valueInTabselect);
		
		//boolean valueInTabselected = CommonMethods.verifyDropDownOptions(tabSelected, "Accounts");
		Thread.sleep(5000);
		WebElement addBtn = driver.findElement(By.id("duel_select_0_right"));
		WebElement removeBtn = driver.findElement(By.id("duel_select_0_left"));
		
		if(valueInTabselect) {
			System.out.println("Select Account");
			tabSelect.selectByVisibleText(tabvalue);
			BaseFirebasetlog.info(tabvalue + " selected to be added to Salesforce menu");
			Reporter.log(tabvalue + " selected to be added to Salesforce menu");
			clickElement(addBtn,"Add Cutomize Menu");
			//addBtn.click();
		}else {
			System.out.println("Select Account1");
			tabSelected.selectByVisibleText(tabvalue);
			BaseFirebasetlog.info(tabvalue + " selected to be removed from Salesforce menu");
			Reporter.log(tabvalue + " selected to be removed from  Salesforce menu");
			clickElement(removeBtn,"Remove Cutomize Menu");
			tabSelect.selectByVisibleText(tabvalue);
			BaseFirebasetlog.info(tabvalue + " selected to be added to Salesforce menu");
			Reporter.log(tabvalue + " selected to be added to Salesforce menu");
			clickElement(addBtn,"Add Cutomize Menu");
		}
		Thread.sleep(3000);
		WebElement saveBtn = driver.findElement(By.xpath("//*[@name='save']"));
		clickElement(saveBtn,"Save Customize Menu");
		
		Thread.sleep(5000);
		WebElement allTabHeader = driver.findElement(By.xpath("//*[@class='content']//h1"));
		//System.out.println(loginHistoryHeader.getText());
		Assert.assertEquals(allTabHeader.getText().contains("All Tabs"), true,"All Tabs page not displayed");
		Thread.sleep(5000);
		logout_SalesForce();
		Thread.sleep(5000);
		login_SalesForce();
		Thread.sleep(5000);
		WebElement sfHomeMenu = driver.findElement(By.id(tabName));
		Assert.assertEquals(sfHomeMenu.isDisplayed(), true,"New Menu not added on home page");
		BaseFirebasetlog.info(tabName + " added to Salesforce menu");
		Reporter.log(tabName + " added to Salesforce menu");
		
		
	}
	public  void createNewAccount(String AccountName) {
		WebElement newbtn = driver.findElement(By.name("new"));
		newbtn.click();
		WebElement accountName = driver.findElement(By.id("acc2"));
		accountName.sendKeys(AccountName);
		Select typeSelect = new Select(driver.findElement(By.id("acc6")));
		typeSelect.selectByVisibleText("Technology Partner");
		//00Nan0000015xHu
		Select priority = new Select(driver.findElement(By.id("00Nan0000015xHu")));
		priority.selectByVisibleText("High");
		WebElement save = driver.findElement(By.name("save"));
		save.click();
		//WebElement newAccount = driver.findElement(By.xpath("//*[@id='contactHeaderRow']//h2"));
		//CommonMethods.verifyElementText(newAccount, AccountName);
	}
	
	public  void clickAccountsTab() {
		WebElement accountTab = driver.findElement(By.xpath("//*[@id='Account_Tab']/a"));
		accountTab.click();
		//CommonMethods.verifyTitleContains(driver,"Accounts");
	}
	
	
	public  void clickOpportunityTab() {
		WebElement opportunity = driver.findElement(By.xpath("//*[@id='Opportunity_Tab']/a"));
		opportunity.click();
		//CommonMethods.verifyTitleContains(driver,"Opportunities");
	}
	
	public  void clickLeads() {
		WebElement lead = driver.findElement(By.xpath("//*[@id='Lead_Tab']/a"));
		lead.click();
		//CommonMethods.verifyTitleContains(driver,"Leads");
	}
	
	public  void clickContacts() {
		WaitUntilPresenceOfElementLocatedBy(By.xpath("//*[@id='Contact_Tab']/a"), "Contact");
		WebElement contact = driver.findElement(By.xpath("//*[@id='Contact_Tab']/a"));
		contact.click();
		//CommonMethods.verifyTitleContains(driver,"Contacts");
	}
	
	public  void clickHome() {
		WebElement home = driver.findElement(By.xpath("//*[@id='home_Tab']/a"));
		home.click();
		
	}
	
	public boolean removeCustomTab(String tabvalue,String tabName) throws InterruptedException {
		Select tabSelect = new Select(driver.findElement(By.id("duel_select_0")));
		Select tabSelected = new Select(driver.findElement(By.id("duel_select_1")));
		//boolean valueInTabselect = CommonMethods.verifyDropDownOptions(tabSelect, tabvalue);
		boolean valueInTabselected = verifyDropDownOptions(tabSelected, tabvalue);
		WebElement addBtn = driver.findElement(By.id("duel_select_0_right"));
		WebElement removeBtn = driver.findElement(By.id("duel_select_0_left"));
		if(valueInTabselected) {
			tabSelected.selectByVisibleText(tabvalue);
			removeBtn.click();
			//addBtn.click();
		}else {
			tabSelect.selectByVisibleText(tabvalue);
			addBtn.click();
			tabSelected.selectByVisibleText(tabvalue);
			removeBtn.click();
		}
		
		WebElement saveBtn = driver.findElement(By.xpath("//*[@name='save']"));
		saveBtn.click();
		
		WebElement allTabHeader = driver.findElement(By.xpath("//*[@class='content']//h1"));
		//System.out.println(loginHistoryHeader.getText());
		
		logout_SalesForce();
		login_SalesForce();
		List<WebElement> menuList = driver.findElements(By.xpath("//*[@id='tabBar']/li/a"));
		boolean menuNotPresent = true;
		for(WebElement w:menuList) {
			if(w.getText().equals(tabvalue)) {
				menuNotPresent = false;
				return menuNotPresent;
			
			}
		}
		return menuNotPresent;
		
		
	}
	


	
}




//test1 test4 test16 test150--- application--