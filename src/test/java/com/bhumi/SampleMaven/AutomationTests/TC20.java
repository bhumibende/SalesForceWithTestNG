//Login Error Message - 1
package com.bhumi.SampleMaven.AutomationTests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.bhumi.SampleMaven.base.BaseFirebase;
import com.bhumi.SampleMaven.base.BaseTest;

public class TC20 extends BaseFirebase{
	BaseTest base = new BaseTest();
	BaseFirebase basefb = new BaseFirebase();

	@Test
	public void verifyLeadsPage() throws InterruptedException {
		//step1
		login_SalesForce();
		//WebElement userMenu = driver.findElement(By.id("userNavButton"));
		//click Leads
		clickLeads();
		Assert.assertEquals(this.getPageTitle().contains("Leads"), true,"Leads Page not opened");
		BaseFirebasetlog.info("Leads page opened");
		Reporter.log("Leads page opened");
		//logout salesforce
		logout_SalesForce();

	}


}
