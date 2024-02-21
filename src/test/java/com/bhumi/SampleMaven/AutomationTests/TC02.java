//Login Error Message - 1
package com.bhumi.SampleMaven.AutomationTests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.bhumi.SampleMaven.base.BaseFirebase;
import com.bhumi.SampleMaven.base.BaseTest;

public class TC02 extends BaseFirebase{
	BaseTest base = new BaseTest();
	BaseFirebase basefb = new BaseFirebase();
	
	@Test
	public void loginErrorMessage2() throws InterruptedException {
		//step1
		
		//goToUrl("https://login.salesforce.com");
		
		String expectedTitle = "Login | Salesforce";
		Assert.assertEquals(getPageTitle(), expectedTitle,"Page Title not Displayed correctly");
		Reporter.log("Page Title Verified");
		//step2
		login_SalesForce();
		 expectedTitle = "Home Page ~ Salesforce - Developer Edition";
		 Assert.assertEquals(getPageTitle(), expectedTitle,"Page Title not displayed as expected post login");
			//driver.quit();
		 //BaseFirebasetlog.info("Login Successfull");
		
		
	}

}
