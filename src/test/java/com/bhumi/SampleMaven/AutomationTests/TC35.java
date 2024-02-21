//Login Error Message - 1
package com.bhumi.SampleMaven.AutomationTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.bhumi.SampleMaven.base.BaseFirebase;
import com.bhumi.SampleMaven.base.BaseTest;

public class TC35 extends BaseFirebase{
	BaseTest base = new BaseTest();
	BaseFirebase basefb = new BaseFirebase();

	@Test
	public void verifyTabCustomize() throws InterruptedException {
		//step1
		login_SalesForce();
		//WebElement userMenu = driver.findElement(By.id("userNavButton"));
		//click Home
		clickHome();
		Assert.assertEquals(this.getPageTitle().contains("Salesforce - Developer Edition"), true,"Home Page not opened");
		BaseFirebasetlog.info("Home page opened");
		Reporter.log("Home page opened");

		WebElement allTabs = driver.findElement(By.xpath("//*[@id='AllTab_Tab']/a"));
		clickElement(allTabs,"All Tabs");
		//allTabs.click();
		WebElement customize = driver.findElement(By.name("customize"));
		clickElement(customize,"Customize");
		//customize.click();
		//remove tab
		boolean removeTab = removeCustomTab("Accounts","Account_Tab");
		Assert.assertEquals(removeTab,true,"Account tab not removed");
		BaseFirebasetlog.info("Accounts tab removed");
		Reporter.log("Accounts tab removed");
		//cleanup - add tab back
		
		
		 allTabs = driver.findElement(By.xpath("//*[@id='AllTab_Tab']/a"));
		clickElement(allTabs,"All Tabs");
		 customize = driver.findElement(By.name("customize"));
		clickElement(customize,"Customize");
		addSalesForceHomeCustomTab("Accounts","Account_Tab");
			
		

	}


}











