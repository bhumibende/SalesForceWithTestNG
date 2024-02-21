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

public class TC22 extends BaseFirebase{
	BaseTest base = new BaseTest();
	BaseFirebase basefb = new BaseFirebase();

	@Test
	public void verifyLeadsList() throws InterruptedException {
		//step1
		login_SalesForce();
		//WebElement userMenu = driver.findElement(By.id("userNavButton"));
		//click Leads
		clickLeads();
		Assert.assertEquals(this.getPageTitle().contains("Leads"), true,"Leads Page not opened");
		BaseFirebasetlog.info("Leads page opened");
		Reporter.log("Leads page opened");
		//view drop down
		WebElement leadsView=driver.findElement(By.name("fcf"));
		Select leadsViewdropdwn = new Select(leadsView);
		//select my unread leads
		this.selectByTextData(leadsView, "My Unread Leads", "Leads View");
		//leadsViewdropdwn.selectByVisibleText("My Unread Leads");
		this.WaitUntilPresenceOfElementLocatedBy(By.name("fcf"), "Leads View");
		 leadsView=driver.findElement(By.name("fcf"));
		leadsViewdropdwn = new Select(leadsView);
		Assert.assertEquals(leadsViewdropdwn.getFirstSelectedOption().getText(), "My Unread Leads","Leads View");
		BaseFirebasetlog.info("Leads drop down selected");
		Reporter.log("Leads drop down selected");
		//logout
		//CommonMethods.LogOutSalesForce(driver);
		//driver.close();
		//login back
		logout_SalesForce();
		this.waitUntilPageLoads();
		login_SalesForce();
		clickLeads();
		leadsView=driver.findElement(By.name("fcf"));
		leadsViewdropdwn = new Select(leadsView);
		Assert.assertEquals(leadsViewdropdwn.getFirstSelectedOption().getText(), "My Unread Leads","My Unread leads not selected in view after login");
		BaseFirebasetlog.info("My Unread leads selected in view after login");
		Reporter.log("My Unread leads selected in view after login");

		WebElement goBtn = driver.findElement(By.name("go"));
		clickElement(goBtn,"Go");
		//goBtn.click();
		leadsView=driver.findElement(By.name("fcf"));
		leadsViewdropdwn = new Select(leadsView);
		Assert.assertEquals(leadsViewdropdwn.getFirstSelectedOption().getText(), "My Unread Leads","My Unread leads not selected in view after login");
		BaseFirebasetlog.info("My Unread leads selected in view after login");
		Reporter.log("My Unread leads selected in view after login");


		//logout salesforce
		logout_SalesForce();

	}


}
