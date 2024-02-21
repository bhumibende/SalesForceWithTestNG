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

public class TC15 extends BaseFirebase{
	BaseTest base = new BaseTest();
	BaseFirebase basefb = new BaseFirebase();
	
	@Test
	public void verifyOpportunityDropDown() throws InterruptedException {
		//step1
		login_SalesForce();
	//	WebElement userMenu = driver.findElement(By.id("userNavButton"));
		//click opportunity
		clickOpportunityTab();
		Assert.assertEquals(this.getPageTitle().contains("Opportunities"), true,"Opportunities Page not opened");
		BaseFirebasetlog.info("Opportunities page opened");
		Reporter.log("Opportunities page opened");
		WebElement opportunityView	=driver.findElement(By.id("fcf"));
		Select opportunityViewdropdwn = new Select(opportunityView);
				List<WebElement> opportunityViewdropdwnOptn= opportunityViewdropdwn.getOptions();
				List<String> opportunityViewdropdwnOptnValues = new ArrayList<>();
				for(WebElement w:opportunityViewdropdwnOptn) {
					opportunityViewdropdwnOptnValues.add(w.getText());
					
				}
				
				List<String> expectedopportunityViewdropdwnOptnValues = new ArrayList<>();
				expectedopportunityViewdropdwnOptnValues.add("All Opportunities");
				expectedopportunityViewdropdwnOptnValues.add("Closing Next Month");
				expectedopportunityViewdropdwnOptnValues.add("Closing This Month");
				expectedopportunityViewdropdwnOptnValues.add("My Opportunities");
				expectedopportunityViewdropdwnOptnValues.add("New Last Week");
				expectedopportunityViewdropdwnOptnValues.add("New This Week");
				expectedopportunityViewdropdwnOptnValues.add("Opportunity Pipeline");
				expectedopportunityViewdropdwnOptnValues.add("Private");
				expectedopportunityViewdropdwnOptnValues.add("Recently Viewed Opportunities");
				expectedopportunityViewdropdwnOptnValues.add("Won");
				Assert.assertEquals(opportunityViewdropdwnOptnValues, expectedopportunityViewdropdwnOptnValues,"Opportunity drop down Options are not as expeceted");
				BaseFirebasetlog.info("Opportunity Drop Down options verified");
				Reporter.log("Opportunity Drop Down options verified");
				
		
		
		
		
		
	}

}
