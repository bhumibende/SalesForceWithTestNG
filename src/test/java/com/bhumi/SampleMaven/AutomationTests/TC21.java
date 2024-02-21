//Login Error Message - 1
package com.bhumi.SampleMaven.AutomationTests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.bhumi.SampleMaven.base.BaseFirebase;
import com.bhumi.SampleMaven.base.BaseTest;

public class TC21 extends BaseFirebase{
	BaseTest base = new BaseTest();
	BaseFirebase basefb = new BaseFirebase();

	@Test
	public void verifyLeadsViewDropDown() throws InterruptedException {
		//step1
		login_SalesForce();
		//WebElement userMenu = driver.findElement(By.id("userNavButton"));
		//click Leads
		clickLeads();
		Assert.assertEquals(this.getPageTitle().contains("Leads"), true,"Leads Page not opened");
		BaseFirebasetlog.info("Leads page opened");
		Reporter.log("Leads page opened");
		//view drop down
		WebElement leadsView=driver.findElement(By.id("fcf"));
		Select leadsViewdropdwn = new Select(leadsView);
		List<WebElement> leadsViewdropdwnOptn= leadsViewdropdwn.getOptions();
		List<String> leadsViewdropdwnOptnValues = new ArrayList<>();
		for(WebElement w:leadsViewdropdwnOptn) {
			leadsViewdropdwnOptnValues.add(w.getText());
			
		}
		
		List<String> expectedleadsViewdropdwnOptnValues = new ArrayList<>();
		expectedleadsViewdropdwnOptnValues.add("All Open Leads");
		expectedleadsViewdropdwnOptnValues.add("My Unread Leads");
		expectedleadsViewdropdwnOptnValues.add("Recently Viewed Leads");
		expectedleadsViewdropdwnOptnValues.add("Today's Leads");
		expectedleadsViewdropdwnOptnValues.add("View - Custom 1");
		expectedleadsViewdropdwnOptnValues.add("View - Custom 2");
		
		
		Assert.assertEquals(leadsViewdropdwnOptnValues, expectedleadsViewdropdwnOptnValues,"Leads view drop down Options are not as expeceted");
		BaseFirebasetlog.info("Leads view drop down options verified");
		Reporter.log("Leads view drop down options verified");
		
		//CommonMethods.LogOutSalesForce(driver);

		
		//logout salesforce
		logout_SalesForce();

	}


}
