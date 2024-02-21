//Login Error Message - 1
package com.bhumi.SampleMaven.AutomationTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;	

import com.bhumi.SampleMaven.base.BaseFirebase;
import com.bhumi.SampleMaven.base.BaseTest;

public class TC27 extends BaseFirebase{
	BaseTest base = new BaseTest();
	BaseFirebase basefb = new BaseFirebase();

	@Test
	public void verifyRecentContactDropDown() throws InterruptedException {
		//step1
		login_SalesForce();


		//Contacts tab
		clickContacts();

		//recetly created
		WebElement recentContact = (driver.findElement(By.id("hotlist_mode")));
		this.selectByTextData(recentContact, "Recently Created","Recent Contact");
		//recentContact.selectByVisibleText("Recently Created");
		WebElement recentContacts = driver.findElement(By.xpath("//a[text()='bende']"));
		
		Assert.assertEquals(recentContacts.isDisplayed(),true,"Recent Contact not displayed");
		BaseFirebasetlog.info("Recent Contact drop down verified");
		Reporter.log("Recent Contact drop down verified");	

		}


}











