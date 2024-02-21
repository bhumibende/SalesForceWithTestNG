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

public class TC10 extends BaseFirebase{
	BaseTest base = new BaseTest();
	BaseFirebase basefb = new BaseFirebase();

	@Test
	public void createAccount() throws InterruptedException {
		//step1
		login_SalesForce();
		//clickUserMenu
		
		//driver.quit();
		
		WebElement accountTab = driver.findElement(By.xpath("//*[@id='Account_Tab']/a"));
		clickElement(accountTab,"Account Tab");
		Assert.assertEquals(this.getPageTitle().contains("Accounts"),true,"Account page not opened");
		BaseFirebasetlog.info("Account page opened");
		Reporter.log("Account page opened");
		
		
		//new account
		WebElement newbtn = driver.findElement(By.name("new"));
		clickElement(newbtn,"New Account");
		Assert.assertEquals(this.getPageTitle().contains("New Account"),true,"New Account page not opened");
		BaseFirebasetlog.info("New Account page opened");
		Reporter.log("New Account page opened");
		
		
		WebElement accountName = driver.findElement(By.id("acc2"));
		enterText(accountName,"Test Account","Account Name");
		//accountName.sendKeys();
		WebElement typeSelect = driver.findElement(By.id("acc6"));
		this.selectByTextData(typeSelect, "Technology Partner", "Account Type");
		//typeSelect.selectByVisibleText("Technology Partner");
		//00Nan0000015xHu
		WebElement priority = driver.findElement(By.id("00Nan0000015xHu"));
		this.selectByTextData(priority, "High", "Priority");
		//priority.selectByVisibleText("High");
		WebElement save = driver.findElement(By.name("save"));
		clickElement(save,"Save");
		//save.click();
		WebElement newAccount = driver.findElement(By.xpath("//*[@id='contactHeaderRow']//h2"));
		Assert.assertEquals(newAccount.getText().contains("Test Account"),true,"Test Account not added");
		BaseFirebasetlog.info("New Account added");
		Reporter.log("New Account added");
		
		//cleanup to delete account created 
		WebElement delete = driver.findElement(By.name("delete"));
		delete.click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		
	}
	
	
}

		
		
		
		
	

		
	


