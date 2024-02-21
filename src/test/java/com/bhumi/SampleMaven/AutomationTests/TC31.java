//Login Error Message - 1
package com.bhumi.SampleMaven.AutomationTests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.bhumi.SampleMaven.base.BaseFirebase;
import com.bhumi.SampleMaven.base.BaseTest;

public class TC31 extends BaseFirebase{
	BaseTest base = new BaseTest();
	BaseFirebase basefb = new BaseFirebase();

	@Test
	public void CancelNewContact() throws InterruptedException {
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
		WebElement viewName = driver.findElement(By.id("fname"));
		enterText(viewName,"ABCD","View Name");

		WebElement uniqueViewName = driver.findElement(By.id("devname"));
		this.clearElement(uniqueViewName, "Unique view name");
		//uniqueViewName.clear();
		enterText(uniqueViewName,"EFGH","View Name");
		//uniqueViewName.sendKeys("EFGH");
		WebElement cancel = driver.findElement(By.name("cancel"));
		clickElement(cancel,"Cancel");
		//cancel.click();
		Select viewDropDown = new Select(driver.findElement(By.name("fcf")));
		List<WebElement> viewList = viewDropDown.getAllSelectedOptions();
		boolean elementFound = false;
		for(WebElement w: viewList) {
			if(w.getText().equals("ABCD")){
				System.out.println("Failed: View added after clicking cancel button");
				elementFound = true;
				break;
			}
		}
		Assert.assertFalse(elementFound,"Failed: View added after clicking cancel button");
		BaseFirebasetlog.info("View not added after clicking cancel button");
		Reporter.log("View not added after clicking cancel button");
		

	}


}











