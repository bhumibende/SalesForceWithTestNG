//Login Error Message - 1
package com.bhumi.SampleMaven.AutomationTests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.bhumi.SampleMaven.base.BaseFirebase;
import com.bhumi.SampleMaven.base.BaseTest;

public class TC05 extends BaseFirebase{
	BaseTest base = new BaseTest();
	BaseFirebase basefb = new BaseFirebase();
	
	@Test
	public void verifySalesforceUserMenu() throws InterruptedException {
		//step1
		login_SalesForce();
		WebElement userMenu = driver.findElement(By.id("userNavButton"));
		clickElement(userMenu, "SalesForce User Menu");
		Assert.assertEquals(userMenu.isDisplayed(), true,"SalesForce UserMenu not displayed");
		List<WebElement> userMenuOptions = driver.findElements(By.xpath("//*[@id='userNavMenu']//a"));
		List<String> userMenuOptionsText = new ArrayList<>();
		for(WebElement w:userMenuOptions) {
			userMenuOptionsText.add(w.getText());
			}
		List<String> expecteduserMenuOptionsText = new ArrayList<String>();
		expecteduserMenuOptionsText.add("My Profile");
		expecteduserMenuOptionsText.add("My Settings");
		expecteduserMenuOptionsText.add("Developer Console");
		expecteduserMenuOptionsText.add("Switch to Lightning Experience");
		expecteduserMenuOptionsText.add("Logout");
		Assert.assertEquals(userMenuOptionsText, expecteduserMenuOptionsText,"SalesForce Menu Options are not as expeceted");
		BaseFirebasetlog.info("SalesForce User Menu Drop Down options verified");
		Reporter.log("SalesForce User Menu Drop Down options verified");

		
		
		
		
		
	}

}
