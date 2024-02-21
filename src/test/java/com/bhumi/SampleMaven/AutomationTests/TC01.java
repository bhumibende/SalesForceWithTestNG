//Login Error Message - 1
package com.bhumi.SampleMaven.AutomationTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.bhumi.SampleMaven.base.BaseFirebase;
import com.bhumi.SampleMaven.base.BaseTest;

public class TC01 extends BaseFirebase{
	BaseTest base = new BaseTest();
	BaseFirebase basefb = new BaseFirebase();
	
	@Test
	public void loginErrorMessage1() {
		//step1
		
		//goToUrl("https://login.salesforce.com");
		driver.manage().window().maximize();
		String expectedTitle = "Login | Salesforce";
		Assert.assertEquals(getPageTitle(), expectedTitle,"Page Title not Displayed correctly");
		Reporter.log("Page Title Verified");
		//step2
		WebElement userName = driver.findElement(By.id("username"));
		enterText(userName, "bhumi.gmail.com", "usernName");
		Assert.assertEquals(userName.getAttribute("value"), "bhumi.gmail.com","UserName not Entered correctly");
		Reporter.log("UserName Field Verified");
		WebElement password = driver.findElement(By.id("password"));
		//password.clear();
		clearElement(password, "Password");
		Assert.assertEquals(password.getAttribute("value"), "","Password cleared");
		Reporter.log("UserName Field is clear Verified");
		WebElement loginBtn = driver.findElement(By.id("Login"));
		clickElement(loginBtn, "LoginButton");
		WebElement error = driver.findElement(By.id("error"));
		BaseFirebasetlog.info("Error for blank password verified");
		Reporter.log("Error for blank password Verified");
		
		Assert.assertEquals(error.isDisplayed(), true,"Error not Displayed for no password");
		Assert.assertEquals(error.getText(), "Please enter your password.","Error not Displayed for no password with correct text");
		
		//driver.quit();
		
		
	}

}
