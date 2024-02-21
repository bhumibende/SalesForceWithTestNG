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

public class TC28 extends BaseFirebase{
	BaseTest base = new BaseTest();
	BaseFirebase basefb = new BaseFirebase();

	@Test
	public void verifyMyContacts() throws InterruptedException {
		//step1
		login_SalesForce();


		//Contacts tab
		clickContacts();

		//recetly created
		this.WaitUntilPresenceOfElementLocatedBy(By.name("fcf"), "view Drop down");
		WebElement viewDropDown = ( driver.findElement(By.name("fcf")));
		this.selectByTextData(viewDropDown, "My Contacts", "Contact View");
		logout_SalesForce();
		login_SalesForce();
		clickContacts();
		this.WaitUntilPresenceOfElementLocatedBy(By.name("go"), "go button");
		Thread.sleep(5000);
		WebElement goBtn = driver.findElement(By.name("go"));
		clickElement(goBtn,"Go");
		
		Select viewDropDown1 = new Select(driver.findElement(By.name("fcf")));
		Assert.assertEquals(viewDropDown1.getFirstSelectedOption().getText(),"My Contacts","My Contacts View not added");
		BaseFirebasetlog.info("My Contacts View Added");
		Reporter.log("My Contacts View Added");
		
		
		
		

		}


}











