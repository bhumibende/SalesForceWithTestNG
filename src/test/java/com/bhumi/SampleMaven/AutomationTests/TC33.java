//Login Error Message - 1
package com.bhumi.SampleMaven.AutomationTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.bhumi.SampleMaven.base.BaseFirebase;
import com.bhumi.SampleMaven.base.BaseTest;

public class TC33 extends BaseFirebase{
	BaseTest base = new BaseTest();
	BaseFirebase basefb = new BaseFirebase();

	@Test
	public void verifyHomePageUserName() throws InterruptedException {
		//step1
		login_SalesForce();
		//WebElement userMenu = driver.findElement(By.id("userNavButton"));
		//click Home
		clickHome();
		Assert.assertEquals(this.getPageTitle().contains("Salesforce - Developer Edition"), true,"Home Page not opened");
		BaseFirebasetlog.info("Home page opened");
		Reporter.log("Home page opened");

		//new contact
		//verify login user first name and last name shows on home tag
		WebElement userdetail = driver.findElement(By.xpath("//*[@class='content']//h1/a"));
		String userDetailsText = this.getTextFromElement(userdetail, "User Details");
		Assert.assertEquals(userDetailsText.contains("bhumi pawde"), true,"User Details not displayed");
		BaseFirebasetlog.info("User Details displayed");
		Reporter.log("User Details displayed");
		//click on user first name last name link
		//userdetail.click();
		clickElement(userdetail,"User Detail Link");
		Assert.assertEquals(this.getPageTitle().contains("User: bhumi pawde"), true,"User Details Page not opened");
		BaseFirebasetlog.info("User Details page opened");
		Reporter.log("User Details page opened");
		

	}


}











