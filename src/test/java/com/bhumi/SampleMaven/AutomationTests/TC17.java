//Login Error Message - 1
package com.bhumi.SampleMaven.AutomationTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.bhumi.SampleMaven.base.BaseFirebase;
import com.bhumi.SampleMaven.base.BaseTest;

public class TC17 extends BaseFirebase{
	BaseTest base = new BaseTest();
	BaseFirebase basefb = new BaseFirebase();

	@Test
	public void verifyOpportunityPipeline() throws InterruptedException {
		//step1
		login_SalesForce();
		//WebElement userMenu = driver.findElement(By.id("userNavButton"));
		//click opportunity
		clickOpportunityTab();
		Assert.assertEquals(this.getPageTitle().contains("Opportunities"), true,"Opportunities Page not opened");
		BaseFirebasetlog.info("Opportunities page opened");
		Reporter.log("Opportunities page opened");
		//new opportunity
		WebElement oppPipeline = driver.findElement(By.xpath("//a[text()='Opportunity Pipeline']"));
		clickElement(oppPipeline,"Opportunity Pipeline");
		//oppPipeline.click();
		//CommonMethods.verifyTitleContains(driver, "Opportunity Pipeline");
		Assert.assertEquals(this.getPageTitle().contains("Opportunity Pipeline"),true,"Opportunity Pipeline not opened");
		BaseFirebasetlog.info("Opportunity Pipeline page opened");
		Reporter.log("Opportunity Pipeline page opened");


	}

}
