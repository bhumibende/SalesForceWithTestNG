//Login Error Message - 1
package com.bhumi.SampleMaven.AutomationTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.bhumi.SampleMaven.base.BaseFirebase;
import com.bhumi.SampleMaven.base.BaseTest;

public class TC34 extends BaseFirebase{
	BaseTest base = new BaseTest();
	BaseFirebase basefb = new BaseFirebase();

	@Test
	public void verifyHomeLastNameEdit() throws InterruptedException {
		//step1
		login_SalesForce();
		//WebElement userMenu = driver.findElement(By.id("userNavButton"));
		//click Home
		clickHome();
		Assert.assertEquals(this.getPageTitle().contains("Salesforce - Developer Edition"), true,"Home Page not opened");
		BaseFirebasetlog.info("Home page opened");
		Reporter.log("Home page opened");

		WebElement userdetail = driver.findElement(By.xpath("//*[@class='content']//h1/a"));
		//CommonMethods.verifyElementText(userdetail, "bhumi pawde");
		//click on user first name last name link
		clickElement(userdetail,"User Detail");
		//userdetail.click();

		WebElement editProfile = driver.findElement(By.xpath("//*[@class='editPen']//a[contains(@class,'contactInfo')]/img"));
		clickElement(editProfile,"Edit Profile");
		//editProfile.click();

		driver.switchTo().frame("contactInfoContentId"); 
		WebElement aboutTab = driver.findElement(By.id("aboutTab")); 
		// WebElement contactTab =  driver.findElement(By.id("contactTab"));


		clickElement(aboutTab,"About Tab");			
		//aboutTab.click(); 
		WebElement lastName =  driver.findElement(By.id("lastName")); 
		this.clearElement(lastName, "Last Name");
		enterText(lastName,"abcd","Last Name");
		
		WebElement saveBtn =   driver.findElement(By.xpath("//input[@value='Save All']")); 
		clickElement(saveBtn,"Save");
		driver.switchTo().defaultContent(); //verify last name is modified
		WebElement  nameEdit = driver.findElement(By.id("tailBreadcrumbNode"));
		
		Assert.assertEquals(nameEdit.getText().contains("abcd"), true,"Edited Name not saved");
		BaseFirebasetlog.info("Edited Name saved");
		Reporter.log("Edited Name saved");
		
		String title = this.getPageTitle();
		Assert.assertEquals(title.contains("User: bhumi abcd"),true,"Edited Name not saved");
		BaseFirebasetlog.info("Edited Name saved");
		Reporter.log("Edited Name saved");
		
		
		//revert last name as other tests have dependency
		editProfile = driver.findElement(By.xpath("//*[@class='editPen']//a[contains(@class,'contactInfo')]/img"));
		clickElement(editProfile,"Edit Profile");
		//editProfile.click();

		driver.switchTo().frame("contactInfoContentId"); 
		aboutTab = driver.findElement(By.id("aboutTab")); 
		
		clickElement(aboutTab,"About tab");
		lastName =  driver.findElement(By.id("lastName")); 
		clearElement(lastName,"Last Name");
		enterText(lastName,"pawde","Last Name");
		
		saveBtn =   driver.findElement(By.xpath("//input[@value='Save All']")); 
		clickElement(saveBtn,"Save");
		//saveBtn.click();
		driver.switchTo().defaultContent();

		
		
		

	}


}











