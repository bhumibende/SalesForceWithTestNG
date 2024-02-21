//Login Error Message - 1
package com.bhumi.SampleMaven.AutomationTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.bhumi.SampleMaven.base.BaseFirebase;
import com.bhumi.SampleMaven.base.BaseTest;
import com.bhumi.SampleMaven.utilities.Constants;
import com.bhumi.SampleMaven.utilities.PropertiesUtility;

public class TC03 extends BaseFirebase{
	BaseTest base = new BaseTest();
	BaseFirebase basefb = new BaseFirebase();
	
	@Test
	public void loginErrorMessage3() throws InterruptedException {
		//step1
		
		//goToUrl("https://login.salesforce.com");
		driver.manage().window().maximize();
		String expectedTitle = "Login | Salesforce";
		Assert.assertEquals(getPageTitle(), expectedTitle,"Page Title not Displayed correctly");
		Reporter.log("Page Title Verified");
		//step2
		String userName=PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES,"username");
		String passWord=PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES,"password");		
		//Thread.sleep(5000);
		BaseFirebasetlog.info("Entering UserName & Password and login to salesforce");
		
		WebElement username= driver.findElement(By.id("username"));	
		enterText(username,userName,"username");
		Reporter.log("UserName entered on login page");
		WebElement password=driver.findElement(By.id("password"));
		enterText(password,passWord, "password");		
		Reporter.log("Password entered on login page");
		WebElement loginButton= driver.findElement(By.id("Login"));
		WebElement remeberUserName = driver.findElement(By.id("rememberUn"));
		clickElement(remeberUserName,"Remember UserName checkbox");
		Reporter.log("Remember UserName Checkbox on login page checked");
		clickElement(loginButton, "loginbutton");
		Reporter.log("Login Button Clicked");
		BaseFirebasetlog.info("Login Successfull");
		Reporter.log("Login Successfull");
		waitUntilPageLoads();
		
		logout_SalesForce();
		waitUntilPageLoads();
		WaitUntilPresenceOfElementLocatedBy(By.xpath("//span[contains(@id,'identity')]"),"Username");
		WebElement usernames= driver.findElement(By.xpath("//span[contains(@id,'identity')]"));
		waitForVisibility(usernames,10,5,"Remember Username");
		Assert.assertEquals(getTextFromElement(usernames,"UserName" ),userName,"UserName not remebered");
		BaseFirebasetlog.info("Remember username verified post logout");
		Reporter.log("Remember username verified post logout");
		
		//driver.quit();
		
		
	}

}
