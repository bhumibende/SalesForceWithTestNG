//Login Error Message - 1
package com.bhumi.SampleMaven.AutomationTests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.bhumi.SampleMaven.base.BaseFirebase;
import com.bhumi.SampleMaven.base.BaseTest;

public class TC24 extends BaseFirebase{
	BaseTest base = new BaseTest();
	BaseFirebase basefb = new BaseFirebase();

	@Test
	public void createNewLeads() throws InterruptedException {
		//step1
		login_SalesForce();
		//WebElement userMenu = driver.findElement(By.id("userNavButton"));
		//click Leads
		clickLeads();
		Assert.assertEquals(this.getPageTitle().contains("Leads"), true,"Leads Page not opened");
		BaseFirebasetlog.info("Leads page opened");
		Reporter.log("Leads page opened");


		//New Lead
		WebElement newLeads = driver.findElement(By.name("new"));
		clickElement(newLeads,"New Leads");
		//newLeads.click();
		Assert.assertEquals(this.getPageTitle().contains("New Lead"), true,"New Leads Page not opened");
		BaseFirebasetlog.info("New Leads page opened");
		Reporter.log("New Leads page opened");

		WebElement lastName = driver.findElement(By.id("name_lastlea2"));
		WebElement company = driver.findElement(By.id("lea3"));

		enterText(lastName,"ABCD","Last Name");
		enterText(company,"ABCD","Company");
		

		WebElement save = driver.findElement(By.name("save"));
		clickElement(save,"Save");
		//save.click();
		WebElement newLeadVal = driver.findElement(By.xpath("//*[@class='content']//h2"));
		Assert.assertEquals(this.getTextFromElement(newLeadVal, "New lead value").contains("ABCD"), true,"New Leads not added");
		BaseFirebasetlog.info("New Leads added");
		Reporter.log("New Leads added");
		


		//cleanup
		WebElement delete = driver.findElement(By.name("del"));
		delete.click();
		Alert alert = driver.switchTo().alert();
		alert.accept();





		//logout salesforce
		logout_SalesForce();

	}


}
