//Login Error Message - 1
package com.bhumi.SampleMaven.AutomationTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.bhumi.SampleMaven.base.BaseFirebase;
import com.bhumi.SampleMaven.base.BaseTest;

public class TC29 extends BaseFirebase{
	BaseTest base = new BaseTest();
	BaseFirebase basefb = new BaseFirebase();

	@Test
	public void getContactDetails() throws InterruptedException {
		//step1
		login_SalesForce();


		//Contacts tab
		clickContacts();

		//recetly created
		WebElement recentContact = (driver.findElement(By.id("hotlist_mode")));
		this.selectByTextData(recentContact, "Recently Created","Recent Contact");
		//recentContact.selectByVisibleText("Recently Created");
		WebElement recentContacts = driver.findElement(By.xpath("//a[text()='bende']"));
		clickElement(recentContacts,"Recent Contact link");
		//recentContacts.click();
		this.waitUntilPageLoads();
		Assert.assertEquals(this.getPageTitle().contains("Contact: bende"),true,"Contact Details opened");
		BaseFirebasetlog.info("Contact Details opened");
		Reporter.log("Contact Details opened");
		
		WebElement newContactval = driver.findElement(By.xpath("//*[@class='content']//h2"));
		Assert.assertEquals(this.getTextFromElement(newContactval, "New Contact Value").contains("bende"),true,"Contact Details opened");
		BaseFirebasetlog.info("Contact Details opened with correct details");
		Reporter.log("Contact Details opened with correct details");
		
		
		
		
		
		
		
		
		

		}


}











