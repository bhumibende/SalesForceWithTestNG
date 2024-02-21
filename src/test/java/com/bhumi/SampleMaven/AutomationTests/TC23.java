//Login Error Message - 1
package com.bhumi.SampleMaven.AutomationTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.bhumi.SampleMaven.base.BaseFirebase;
import com.bhumi.SampleMaven.base.BaseTest;

public class TC23 extends BaseFirebase{
	BaseTest base = new BaseTest();
	BaseFirebase basefb = new BaseFirebase();

	@Test
	public void verifyTodaysList() throws InterruptedException {
		//step1
		login_SalesForce();
		//WebElement userMenu = driver.findElement(By.id("userNavButton"));
		//click Leads
		clickLeads();
		Assert.assertEquals(this.getPageTitle().contains("Leads"), true,"Leads Page not opened");
		BaseFirebasetlog.info("Leads page opene	d");
		Reporter.log("Leads page opened");
		//view drop down
		WebElement leadsView=driver.findElement(By.id("fcf"));
		Select leadsViewdropdwn = new Select(leadsView);
		//select my unread leads		
		this.selectByTextData(leadsView, "Today's Leads", "Leads View");
		//leadsViewdropdwn.selectByVisibleText("My Unread Leads");
		Thread.sleep(5000);
		leadsView=driver.findElement(By.name("fcf"));
		leadsViewdropdwn = new Select(leadsView);
		Assert.assertEquals(leadsViewdropdwn.getFirstSelectedOption().getText(), "Today's Leads","Leads View");
		BaseFirebasetlog.info("Leads drop down selected");
		Reporter.log("Leads drop down selected");
		logout_SalesForce();
		login_SalesForce();
		clickLeads();
		WebElement goBtn = driver.findElement(By.name("go"));
		clickElement(goBtn,"Go");
		//goBtn.click();
		leadsView=driver.findElement(By.name("fcf"));
		leadsViewdropdwn = new Select(leadsView);
		Assert.assertEquals(leadsViewdropdwn.getFirstSelectedOption().getText(), "Today's Leads","My Unread leads not selected in view after login");
		BaseFirebasetlog.info("Today's Leads selected in view after login");
		Reporter.log("Today's Leads  selected in view after login");


		//logout salesforce
		logout_SalesForce();

	}


}
