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

public class TC13 extends BaseFirebase{
	BaseTest base = new BaseTest();
	BaseFirebase basefb = new BaseFirebase();

	@Test
	public void MergeAccounts() throws InterruptedException {
		//step1
		login_SalesForce();
		//clickUserMenu

		//driver.quit();

		WebElement accountTab = driver.findElement(By.xpath("//*[@id='Account_Tab']/a"));
		clickElement(accountTab,"Account Tab");
		Assert.assertEquals(this.getPageTitle().contains("Accounts"),true,"Account page not opened");
		BaseFirebasetlog.info("Account page opened");
		Reporter.log("Account page opened");

		//New Accounts for Merge
		//click accounts
		//clickAccountsTab(driver);

		//new account setup for merge
		createNewAccount("Test1");
		clickAccountsTab();
		createNewAccount("Test2");
		clickAccountsTab();
		
		//Merge Account
		WebElement mergeAccount  = driver.findElement(By.xpath("//a[text()='Merge Accounts']"));
		clickElement(mergeAccount,"Merge Account");
		//mergeAccount.click();
		Assert.assertEquals(this.getPageTitle().contains("Merge My Accounts"),true,"Merge My Account page not opened");
		BaseFirebasetlog.info("Merge My Account page opened");
		Reporter.log("Merge My Account page opened");
		WebElement search = driver.findElement(By.id("srch"));
		enterText(search,"Test","Search");
		
		WebElement findAcct = driver.findElement(By.name("srchbutton"));
		clickElement(findAcct,"Find Account");
		//findAcct.click();
		WebElement acct1 = driver.findElement(By.id("cid0"));
		WebElement acct2 = driver.findElement(By.id("cid1"));
		if(!acct1.isSelected()) {
			clickElement(acct1,"Find Account");
			//acct1.click();
		}else {
			clickElement(acct1,"Find Account");
			clickElement(acct1,"Find Account");
		}
		if(!acct2.isSelected()) {
			clickElement(acct2,"Find Account");
		}else {
			clickElement(acct2,"Find Account");
			clickElement(acct2,"Find Account");
		}
		WebElement next = driver.findElement(By.name("goNext"));
		clickElement(next,"Next");
		//next.click();
		WebElement step2 = driver.findElement(By.xpath("//*[@class='bWizardBlock tertiaryPalette']//h2"));
		Assert.assertEquals(step2.isDisplayed(), true,"Confirmation page to merge record not displayed");
		BaseFirebasetlog.info("Confirmation page to merge record displayed");
		Reporter.log("Confirmation page to merge record displayed");
		
		//CommonMethods.verifyElementDisplayed(step2, "Step2 to merge record");

		WebElement merge = driver.findElement(By.name("save"));
		clickElement(merge,"Merge");
	//	merge.click();
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		driver.switchTo().defaultContent();
		WebElement recentItem = driver.findElement(By.xpath("//a[text()='Test1']"));
		BaseFirebasetlog.info("Merged Account displayed");
		Reporter.log("Merge Account displayed");
		//CommonMethods.verifyElementDisplayed(recentItem, "Merged Item");		




		//cleanup
		recentItem.click();
		this.WaitUntilPresenceOfElementLocatedBy(By.name("delete"), "delete");
		Thread.sleep(4000);
		WebElement delete = driver.findElement(By.name("delete"));
		delete.click();
		driver.switchTo().alert();
		alert.accept();
		driver.quit();

	}
	

}











