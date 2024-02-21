//Login Error Message - 1
package com.bhumi.SampleMaven.AutomationTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.bhumi.SampleMaven.base.BaseFirebase;
import com.bhumi.SampleMaven.base.BaseTest;

public class TC30 extends BaseFirebase{
	BaseTest base = new BaseTest();
	BaseFirebase basefb = new BaseFirebase();

	@Test
	public void verifyNewContactRequiredFieldError() throws InterruptedException {
		//step1
		login_SalesForce();


		//Contacts tab
		clickContacts();


		//new view
		WebElement newView = driver.findElement(By.xpath("//a[text()='Create New View']"));
		clickElement(newView,"New View");
		//newView.click();
		Assert.assertEquals(this.getPageTitle().contains("Create New View"),true,"Create New View opened");
		BaseFirebasetlog.info("Create New View opened");
		Reporter.log("Create New View opened");
		

		WebElement uniqueViewName = driver.findElement(By.id("devname"));
		this.clearElement(uniqueViewName, "Unique view name");
		//uniqueViewName.clear();
		enterText(uniqueViewName,"EFGH","View Name");
		//uniqueViewName.sendKeys("EFGH");
		WebElement save = driver.findElement(By.name("save"));
		clickElement(save,"Save");
		//save.click();
		WebElement error = driver.findElement(By.xpath("//div[@class='requiredInput']//div[@class='errorMsg']"));
		Assert.assertEquals(error.isDisplayed(), true,"Error not displayed");
		String errorText = this.getTextFromElement(error, "Error");
		Assert.assertEquals(errorText, "Error: You must enter a value","Error text not correct");
		BaseFirebasetlog.info("Error for required field verified");
		Reporter.log("Error for required field verified");
		

	}


}











