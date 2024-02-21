//Login Error Message - 1
package com.bhumi.SampleMaven.AutomationTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.bhumi.SampleMaven.base.BaseFirebase;
import com.bhumi.SampleMaven.base.BaseTest;

public class TC10a extends BaseFirebase{
	BaseTest base = new BaseTest();
	BaseFirebase basefb = new BaseFirebase();

	@Test
	public void verifyAccountTab() throws InterruptedException {
		//step1
		login_SalesForce();
		//clickUserMenu
		WebElement allTabs = driver.findElement(By.xpath("//*[@id='AllTab_Tab']/a"));
		clickElement(allTabs,"All Tabs");
		WebElement customize = driver.findElement(By.name("customize"));
		clickElement(customize,"Customize");
		addSalesForceHomeCustomTab("Accounts","Account_Tab");
		//driver.quit();
	}
	
	
}

		
		
		
		
	

		
	


