//Login Error Message - 1
package com.bhumi.SampleMaven.AutomationTests;

import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.bhumi.SampleMaven.base.BaseFirebase;
import com.bhumi.SampleMaven.base.BaseTest;

public class TC14 extends BaseFirebase{
	BaseTest base = new BaseTest();
	BaseFirebase basefb = new BaseFirebase();

	@Test
	public void CreateAccountsReport() throws InterruptedException {
		//step1
		login_SalesForce();
		//clickUserMenu

		//driver.quit();
		
		WebElement accountTab = driver.findElement(By.xpath("//*[@id='Account_Tab']/a"));
		clickElement(accountTab,"Account Tab");
		Assert.assertEquals(this.getPageTitle().contains("Accounts"),true,"Account page not opened");
		BaseFirebasetlog.info("Account page opened");
		Reporter.log("Account page opened");
		
		
		
		//new account setup for Report
		createNewAccount("ReportTest");
		clickAccountsTab();
		//click last 30 days activity report link
		WebElement lastActivityLink  = driver.findElement(By.xpath("//a[text()='Accounts with last activity > 30 days']"));
		clickElement(lastActivityLink,"Last Activity Link");
		//lastActivityLink.click();
		Assert.assertEquals(this.getPageTitle().contains("Unsaved Report"), true,"Unsaved Report page not opened");
		BaseFirebasetlog.info("Unsaved Report page opened");
		Reporter.log("Unsaved Report page opened");
		
		WebElement dateOption = driver.findElement(By.name("dateColumn"));
		clickElement(dateOption,"Date Option");
		//dateOption.click();
		WebElement createdDateOptn = driver.findElement(By.xpath("//*[@class='x-combo-list-inner']//*[text()='Created Date']"));
		clickElement(createdDateOptn,"Created Date Option");
		//createdDateOptn.click();
		WebElement startDate = driver.findElement(By.name("startDate"));
		String date = getCurrentDate();
		enterText(startDate,date,"Start Date");
		//startDate.sendKeys(date);
		
		WebElement endDate = driver.findElement(By.xpath("//*[@name='endDate']/parent::*/img"));
		clickElement(endDate,"End Date");
		//endDate.click();
		WebElement todayendDate = driver.findElement(By.xpath("//*[contains(@class,'date-menu')]//button[text()='Today']"));
		//endDate.sendKeys(Keys.ENTER);
		clickElement(todayendDate,"Today End Date");
		//todayendDate.click();
		
		this.WaitUntilPresenceOfElementLocatedBy(By.xpath("//tbody//td[contains(@class,'ACCOUNT.NAME')]//div"), "Report Name");
		WebElement reportName = driver.findElement(By.xpath("//tbody//td[contains(@class,'ACCOUNT.NAME')]//div"));
		
		Assert.assertEquals(this.getTextFromElement(reportName, "Report Name").contains("ReportTest"), true,"Report Data Displayed");
		BaseFirebasetlog.info("Report Data Displayed");
		Reporter.log("Report Data Displayed");
		Thread.sleep(8000);
		//CommonMethods.verifyElementText(reportName, "ReportTest");
		
		//Save report
		WebElement saveReport = driver.findElement(By.xpath("//*[text()='Save']"));
		clickElement(saveReport,"Save Report");
		//saveReport.click();
		driver.switchTo().activeElement();
		WebElement SavereportName = driver.findElement(By.name("reportName"));
		//WebElement savereportButton = driver.findElement(By.xpath("//*[@id='dlgSaveReport']//*[text()='Save and Run Report']"));
		Random random = new Random();
		int rand =  random.nextInt(1000);
		enterText(SavereportName,"TestReport" + rand,"Report Name");
		
		//SavereportName.sendKeys(Keys.TAB);
		WebElement reportDescription = driver.findElement(By.name("reportDescription"));
		clickElement(reportDescription,"Report Description");
		reportDescription.click();
		this.WaitUntilPresenceOfElementLocatedBy(By.xpath("//button[text()='Save and Run Report']"), "Save and Run Report");
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement savereportButton = driver.findElement(By.xpath("//*[@id='dlgSaveAndRun']//button"));
		this.waitUntilElementToBeClickable(By.xpath("//*[@id='dlgSaveAndRun']//button"), "Save and Run");
		
		Thread.sleep(3000);
		
		
		clickElement(savereportButton,"Save Report");
		this.waitUntilPageLoads();
		Thread.sleep(5000);
		//savereportButton.click();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.switchTo().activeElement();
		this.WaitUntilPresenceOfElementLocatedBy(By.xpath("//*[@class='content']//h1"), "Saved Report");
		WebElement reportSaved = driver.findElement(By.xpath("//*[@class='content']//h1"));
		Thread.sleep(10000);
		
		//CommonMethods.verifyElementDisplayed(reportSaved, "Saved Report");
		System.out.println(reportSaved.getText());
		Assert.assertEquals(this.getTextFromElement(reportSaved, "Saved Report").contains("TestReport"),true,"Report not saved with correct name");
		BaseFirebasetlog.info("Report Saved with correct name ");
		Reporter.log("Report  Saved with correct name");
		
		
				
		
		
		
		
		//cleanup
		this.WaitUntilPresenceOfElementLocatedBy(By.name("delrep"), "Delete");
		Thread.sleep(3000);
		WebElement deleteReport = driver.findElement(By.name("delrep"));
		deleteReport.click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		clickAccountsTab();
		WebElement recentItem = driver.findElement(By.xpath("//a[contains(text(),'ReportTest')]"));
		recentItem.click();
		WebElement delete = driver.findElement(By.name("delete"));
		delete.click();
		driver.switchTo().alert();
		alert.accept();
				
	}
	
	
	
}
