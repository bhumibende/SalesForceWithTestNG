//Login Error Message - 1
package com.bhumi.SampleMaven.AutomationTests;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.bhumi.SampleMaven.base.BaseFirebase;
import com.bhumi.SampleMaven.base.BaseTest;

public class TC07 extends BaseFirebase{
	BaseTest base = new BaseTest();
	BaseFirebase basefb = new BaseFirebase();

	@Test
	public void verifyMySettings() throws InterruptedException {
		//step1
		login_SalesForce();
		WebElement userMenu = driver.findElement(By.id("userNavButton"));
		clickElement(userMenu, "SalesForce User Menu");
		Assert.assertEquals(userMenu.isDisplayed(), true,"SalesForce UserMenu not displayed");
		BaseFirebasetlog.info("Salesforce User Menu Displayed");
		Reporter.log("Salesforce User Menu Displayed");
		
		WebElement mySettings = driver.findElement(By.xpath("//*[@id='userNavMenu']//a[@title='My Settings']"));
		clickElement(mySettings, "My Setting");
		String settingUrl = driver.getCurrentUrl();
		Assert.assertEquals(settingUrl.contains("PersonalSetup"), true,"Setting Page is not displayed");
		BaseFirebasetlog.info("Settings Page Displayed");
		Reporter.log("Settings Page Displayed");
		
		//click personal menu
		this.WaitUntilPresenceOfElementLocatedBy(By.xpath("//*[@id='PersonalInfo']//span[@class='accordionIcon expand_icon']"), "personalMenu");
		Thread.sleep(5000);
		WebElement personalMenu = driver.findElement(By.xpath("//*[@id='PersonalInfo']//span[@class='accordionIcon expand_icon']"));
		mouseOverOnElement(personalMenu, "Personal Menu");
		clickElement(personalMenu,"Personal Menu");
		WebElement loginHistory = driver.findElement(By.xpath("//span[@id='LoginHistory_font']"));
		clickElement(loginHistory,"Login History");
		WebElement loginHistoryHeader = driver.findElement(By.xpath("//*[@class='content']//h1"));
		//System.out.println(loginHistoryHeader.getText());
		Assert.assertEquals(loginHistoryHeader.getText().contains("Login History"), true,"Login History Page not displayed");
		BaseFirebasetlog.info("Login History Page Displayed");
		Reporter.log("Login History Page Displayed");
		
		//download login history
		WebElement downloadLoginHistory = driver.findElement(By.xpath("//a[contains(text(),'Download')]"));
		clickElement(downloadLoginHistory,"Download Login History");
		Assert.assertEquals(verifyFileDownloaded("LoginHistory"),true,"File not downloaded");
		BaseFirebasetlog.info("File Download verified");
		Reporter.log("File Download verified");
		
			
		//display & layout
		
		this.WaitUntilPresenceOfElementLocatedBy(By.xpath("//*[@id='DisplayAndLayout']//span[@class='accordionIcon expand_icon']"), "Display and layout");
		WebElement displayLayout = driver.findElement(By.xpath("//*[@id='DisplayAndLayout']//span[@class='accordionIcon expand_icon']"));
		this.mouseOverOnElement(displayLayout, "Display Layout");
		clickElement(displayLayout,"Display Layout");
		
		//customize my tabs
		WebElement customizeTab = driver.findElement(By.xpath("//span[@id='CustomizeTabs_font']"));
		clickElement(customizeTab,"Customize tab");
		
		
		//Select Salesforce Chatter
		WebElement customApp = driver.findElement(By.id("p4"));
		this.selectByTextData(customApp, "Salesforce Chatter", "Custom App");
		WebElement customAppTab = driver.findElement(By.id("duel_select_0"));
		this.selectByTextData(customAppTab, "Reports", "Custom App tab");
		WebElement addBtn = driver.findElement(By.id("duel_select_0_right"));
		clickElement(addBtn,"Add");
		Select tabSelected = new Select(driver.findElement(By.id("duel_select_1")));
		Assert.assertEquals(verifyDropDownContainsOptions(tabSelected,"Reports"),true,"Selected option not available in dropdown");
		BaseFirebasetlog.info("Reports Tab Selected");
		Reporter.log("Reports Tab Selected");
		
		
		//email setup
		WebElement emailTab = driver.findElement(By.xpath("//*[@id='EmailSetup_font']"));
		clickElement(emailTab,"Email tab");
		
		//my email setting
		WebElement myEmailSetting = driver.findElement(By.xpath("//span[@id='EmailSettings_font']"));
		clickElement(myEmailSetting,"My Email Settings");
		
		WebElement emailName = driver.findElement(By.id("sender_name"));
		WebElement emailId = driver.findElement(By.id("sender_email"));
		WebElement autoBCCNo = driver.findElement(By.id("auto_bcc0"));
		WebElement autoBCCYes = driver.findElement(By.id("auto_bcc1"));
		WebElement saveBtn = driver.findElement(By.name("save"));
		clearElement(emailName,"Email name");
		clearElement(emailId,"Email Id");
		clickElement(autoBCCNo,"Auto BCC");
		enterText(emailName,"Bhumi Bende","Email Name");
		enterText(emailId,"bhumi.bende@outlook.com","Email id");
		clickElement(autoBCCYes,"Auto BCC Yes");
		clickElement(saveBtn,"Save");
		WebElement confirmMsg = driver.findElement(By.id("meSaveCompleteMessage"));
		Assert.assertEquals(confirmMsg.isDisplayed(), true,"Confirm Message not displayed");
		BaseFirebasetlog.info("Save confirmation on email setting verified");
		Reporter.log("Save confirmation on email setting verified");
		
		
		
		//calendar and reminder
		WebElement calandReminder = driver.findElement(By.xpath("//*[@id='CalendarAndReminders']"));
		clickElement(calandReminder,"Calendar Reminder");
		
		//
		WebElement activityReminder = driver.findElement(By.xpath("//span[@id='Reminders_font']"));
		clickElement(activityReminder,"Activity Reminder");
		
		//open test reminder
		String parent = driver.getWindowHandle();
		WebElement testBtn = driver.findElement(By.name("test"));
		clickElement(testBtn,"Test reminder");
		
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
				WebElement reminder = driver.findElement(By.id("reminder"));
				Assert.assertEquals(reminder.isDisplayed(), true,"Reminder Screen not displayed");
				BaseFirebasetlog.info("Reminder Screen Displayed");
				Reporter.log("Reminder Screen Displayed");
			}
		}
		driver.switchTo().window(parent);
		
		
		
		
		
		
		
	}

}
