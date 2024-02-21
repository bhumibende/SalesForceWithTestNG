//Login Error Message - 1
package com.bhumi.SampleMaven.AutomationTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.bhumi.SampleMaven.base.BaseFirebase;
import com.bhumi.SampleMaven.base.BaseTest;

public class TC25 extends BaseFirebase{
	BaseTest base = new BaseTest();
	BaseFirebase basefb = new BaseFirebase();

	@Test
	public void createNewContacts() throws InterruptedException {
		//step1
		login_SalesForce();
		//WebElement userMenu = driver.findElement(By.id("userNavButton"));
		//click Leads
		clickContacts();
		Assert.assertEquals(this.getPageTitle().contains("Contact"), true,"Contact Page not opened");
		BaseFirebasetlog.info("Contact page opened");
		Reporter.log("Contact page opened");

		//new contact

		WebElement newContacts = driver.findElement(By.name("new"));
		clickElement(newContacts,"New Contacts");
		//newContacts.click();
		Assert.assertEquals(this.getPageTitle().contains("New Contact"), true,"New Contact Page not opened");
		BaseFirebasetlog.info("New Contact page opened");
		Reporter.log("New Contact page opened");
		

		WebElement lastName = driver.findElement(By.id("name_lastcon2"));
		WebElement account = driver.findElement(By.id("con4"));
		enterText(lastName,"bende","Last Name");
		enterText(account,"OppAccount","Account");
		

		WebElement save = driver.findElement(By.name("save"));
		clickElement(save,"Save");
		
		WebElement newContactval = driver.findElement(By.xpath("//*[@class='content']//h2"));
		Assert.assertEquals(this.getTextFromElement(newContactval,"New Contact value").contains("bende"), true,"New Contact not created");
		BaseFirebasetlog.info("New Contact created");
		Reporter.log("New Contact created");






		//logout salesforce
		logout_SalesForce();

	}


}
