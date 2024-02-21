//Login Error Message - 1
package com.bhumi.SampleMaven.AutomationTests;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.bhumi.SampleMaven.base.BaseFirebase;
import com.bhumi.SampleMaven.base.BaseTest;

public class TC08 extends BaseFirebase{
	BaseTest base = new BaseTest();
	BaseFirebase basefb = new BaseFirebase();

	@Test
	public void verifyDevConsole() throws InterruptedException {
		//step1
		login_SalesForce();
		WebElement userMenu = driver.findElement(By.id("userNavButton"));
		clickElement(userMenu, "SalesForce User Menu");
		Assert.assertEquals(userMenu.isDisplayed(), true,"SalesForce UserMenu not displayed");
		BaseFirebasetlog.info("Salesforce User Menu Displayed");
		Reporter.log("Salesforce User Menu Displayed");
		
		//step2
		String parent = driver.getWindowHandle();
		WebElement devConsole = driver.findElement(By.xpath("//*[@id='userNavMenu']//a[@title='Developer Console (New Window)']"));
		clickElement(devConsole,"Devleoper console");
	
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Set<String> pageList = driver.getWindowHandles();
		//System.out.println(pageList.size());
		Iterator<String> page = pageList.iterator();
		
		while(page.hasNext()) {
			String child = page.next();
			if(!parent.equals(child)) {
				driver.switchTo().window(child);
				String childTitle = driver.getTitle();
				Assert.assertEquals(childTitle, "Developer Console","Developer console not opened");
				BaseFirebasetlog.info("Developer console opened as expected");
				Reporter.log("Developer console opened as expected");
			}
		}
		
	}
}

		
	


