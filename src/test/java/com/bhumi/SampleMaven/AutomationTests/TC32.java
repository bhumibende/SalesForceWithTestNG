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

public class TC32 extends BaseFirebase{
	BaseTest base = new BaseTest();
	BaseFirebase basefb = new BaseFirebase();

	@Test
	public void verifyNewContactsaveandnew() throws InterruptedException {
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
		enterText(lastName,"Indian","Last Name");
		enterText(account,"OppAccount","Account");


		WebElement saveandNew = driver.findElement(By.name("save_new"));
		clickElement(saveandNew,"Save and New");
		
		//verify new account page opened again
		Assert.assertEquals(this.getPageTitle().contains("New Contact"), true,"New Contact Page not opened");
		BaseFirebasetlog.info("New Contact page opened");
		Reporter.log("New Contact page opened");
		//click cancel on new account page
		WebElement cancel = driver.findElement(By.name("cancel"));
		clickElement(cancel,"Cancel");

		WebElement newContactval = driver.findElement(By.xpath("//*[@class='content']//h2"));
		
		Assert.assertEquals(this.getTextFromElement(newContactval,"New Contact value").contains("Indian"), true,"New Contact not created");
		BaseFirebasetlog.info("New Contact created");
		Reporter.log("New Contact created");

		////cleanup
		WebElement delete = driver.findElement(By.name("del"));
		delete.click();
		Alert alert = driver.switchTo().alert();
		alert.accept();






		


	}


}











