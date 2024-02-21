//Login Error Message - 1
package com.bhumi.SampleMaven.AutomationTests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.bhumi.SampleMaven.base.BaseFirebase;
import com.bhumi.SampleMaven.base.BaseTest;

public class TC16 extends BaseFirebase{
	BaseTest base = new BaseTest();
	BaseFirebase basefb = new BaseFirebase();

	@Test
	public void createNewOpportunity() throws InterruptedException {
		//step1
		login_SalesForce();
		//WebElement userMenu = driver.findElement(By.id("userNavButton"));
		//click opportunity
		clickOpportunityTab();
		BaseFirebasetlog.info("Opportunities page opened");
		Reporter.log("Opportunities page opened");
		Assert.assertEquals(this.getPageTitle().contains("Opportunities"), true,"Opportunities Page not opened");
		//new opportunity
		WebElement newOpportunity = driver.findElement(By.name("new"));
		clickElement(newOpportunity,"New Opportunity");
		//newOpportunity.click();
		Assert.assertEquals(this.getPageTitle().contains("New Opportunity"), true,"New Opportunity Page Opened");
		BaseFirebasetlog.info("New Opportunity Page Opened");
		Reporter.log("New Opportunity Page Opened");
		//CommonMethods.verifyTitleContains(driver, "New Opportunity");

		WebElement oppName = driver.findElement(By.id("opp3"));
		WebElement accntName = driver.findElement(By.id("opp4"));
		WebElement closeDate = driver.findElement(By.id("opp9"));
		WebElement probablity = driver.findElement(By.id("opp12"));
		WebElement stage = (driver.findElement(By.id("opp11")));
		WebElement leadSource =(driver.findElement(By.id("opp6")));
		//WebElement campaignSource = driver.findElement(By.id("opp17"));
		enterText(oppName,"TestOpportunity","Opportunity name");
		//oppName.sendKeys("TestOpportunity");
		//accntName.sendKeys("OppAccount");
		enterText(accntName,"OppAccount","Opportunity Account");
		String date = getCurrentDate();
		enterText(closeDate,date,"Opportunity Closed Date");
		//closeDate.sendKeys(date);
		clearElement(probablity,"Proabablity");
		//probablity.clear();
		enterText(probablity,"10","Proabablity");
		//probablity.sendKeys("10");
		this.selectByTextData(stage,"Prospecting","Stage");
		this.selectByTextData(leadSource,"Web","Lead Source");
		//leadSource.selectByVisibleText("Web");
		//campaignSource.sendKeys("Test");
		WebElement save = driver.findElement(By.name("save"));
		clickElement(save,"Save");
		//save.click();
		WebElement newOpportunityval = driver.findElement(By.xpath("//*[@class='content']//h2"));
		Assert.assertEquals(this.getTextFromElement(newOpportunityval, "New Opportiunity").contains("TestOpportunity"), true,"New Opportunity not created");
		//CommonMethods.verifyElementText(newOpportunityval, "TestOpportunity");
		BaseFirebasetlog.info("New Opportunity verified");
		Reporter.log("New Opportunity Verified");
		//cleanup

		WebElement delete = driver.findElement(By.name("del"));
		delete.click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		driver.quit();




	}

}
