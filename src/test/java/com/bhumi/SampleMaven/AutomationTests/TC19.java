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

public class TC19 extends BaseFirebase{
	BaseTest base = new BaseTest();
	BaseFirebase basefb = new BaseFirebase();

	@Test
	public void verifyOpportunityReport() throws InterruptedException {
		//step1
		login_SalesForce();
		//WebElement userMenu = driver.findElement(By.id("userNavButton"));
		//click opportunity
		clickOpportunityTab();
		Assert.assertEquals(this.getPageTitle().contains("Opportunities"), true,"Opportunities Page not opened");
		BaseFirebasetlog.info("Opportunities page opened");
		Reporter.log("Opportunities page opened");
		//stuck opportunity
		runQuarterlyReport("Current FQ","All Opportunities");
		validateQuarterlyReport("Current FQ","Any");

		clickOpportunityTab();
		runQuarterlyReport("Current FQ","Open Opportunities");
		validateQuarterlyReport("Current FQ","Open");

		clickOpportunityTab();
		runQuarterlyReport("Next FQ","Closed Opportunities");
		validateQuarterlyReport("Next FQ","Closed");

	



	}

	private  void validateQuarterlyReport( String range, String oppStatus) {
		// TODO Auto-generated method stub

		//CommonMethods.verifyTitleContains(driver, "Opportunity Report");
		Assert.assertEquals(getPageTitle().contains("Opportunity Report"),true,"Opportunity Report page opened");
		BaseFirebasetlog.info("Opportunities Report page opened");	
		Reporter.log("Opportunities Report page opened");

		Select intervaldrpDwn = new Select(driver.findElement(By.id("quarter_q")));
		Select includedrpDwn = new Select(driver.findElement(By.id("open")));
		String rangeSelected = intervaldrpDwn.getFirstSelectedOption().getText();
		String oppStatusSelected = includedrpDwn.getFirstSelectedOption().getText();
		Assert.assertEquals(rangeSelected, range,"Opportunity Report not opened with correct range");
		BaseFirebasetlog.info("Opporunity Report opened with correct Range");	
		Reporter.log("Opporunity Report opened with correct Range");
		Assert.assertEquals(oppStatusSelected, oppStatus,"Opportunity Report not opened with correct status");
		BaseFirebasetlog.info("Opporunity Report opened with correct status");	
		Reporter.log("Opporunity Report opened with correct status");

		

	}

	public  void runQuarterlyReport(String interval, String include) {
		WebElement intervaldrpDwn = (driver.findElement(By.id("quarter_q")));
		WebElement includedrpDwn =(driver.findElement(By.id("open")));
		WebElement runReport = driver.findElement(By.xpath("//*[@title='Run Report']"));
		this.selectByTextData(intervaldrpDwn, interval, "Interval");
		this.selectByTextData(includedrpDwn, include, "Include");
		//intervaldrpDwn.selectByVisibleText(interval);
		//includedrpDwn.selectByVisibleText(include);
		clickElement(runReport,"Run Report");
		//runReport.click();


	}

}
