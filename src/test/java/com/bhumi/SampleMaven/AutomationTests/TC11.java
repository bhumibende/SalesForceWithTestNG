//Login Error Message - 1
package com.bhumi.SampleMaven.AutomationTests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.bhumi.SampleMaven.base.BaseFirebase;
import com.bhumi.SampleMaven.base.BaseTest;

public class TC11 extends BaseFirebase{
	BaseTest base = new BaseTest();
	BaseFirebase basefb = new BaseFirebase();

	@Test
	public void createNewAccountView() throws InterruptedException {
		//step1
		login_SalesForce();
		//clickUserMenu
		
		//driver.quit();
		
		WebElement accountTab = driver.findElement(By.xpath("//*[@id='Account_Tab']/a"));
		clickElement(accountTab,"Account Tab");
		Assert.assertEquals(this.getPageTitle().contains("Accounts"),true,"Account page not opened");
		BaseFirebasetlog.info("Account page opened");
		Reporter.log("Account page opened");
		
		Select viewDropDown = new Select( driver.findElement(By.name("fcf")));
		List<String> viewDropDownText = new ArrayList<>();
		List<WebElement> viewDropDownElement = viewDropDown.getOptions();
		for(WebElement w:viewDropDownElement) {
			viewDropDownText.add(w.getText());
		}
		if(viewDropDownText.contains("Test View")){
			viewDropDown.selectByVisibleText("Test View");
			driver.findElement(By.xpath("//a[text()='Edit']")).click();
			this.waitUntilPageLoads();
			WebElement delete = driver.findElement(By.xpath("//div[@class='pbHeader']//*[@value='Delete']"));
			delete.click();
			Alert alert = driver.switchTo().alert();
			alert.accept();
		}else if(viewDropDownText.contains("Test1 View")){
			viewDropDown.selectByVisibleText("Test1 View");
			driver.findElement(By.xpath("//a[text()='Edit']")).click();
			this.waitUntilPageLoads();
			WebElement delete = driver.findElement(By.xpath("//div[@class='pbHeader']//*[@value='Delete']"));
			delete.click();
			Alert alert = driver.switchTo().alert();
			alert.accept();
		}
		
		
		//new view
		WebElement newView = driver.findElement(By.xpath("//a[text()='Create New View']"));
		clickElement(newView,"New Accounts View");
		Assert.assertEquals(this.getPageTitle().contains("Create New View"),true,"Create New View page not opened");
		BaseFirebasetlog.info("New Accounts View page opened");
		Reporter.log("New Accounts View page opened");		
		WebElement viewName = driver.findElement(By.id("fname"));
		enterText(viewName,"Test View","New View Name");
		
		WebElement uniqueViewName = driver.findElement(By.id("devname"));
		clearElement(uniqueViewName,"Unique View Name");
		enterText(uniqueViewName,"TestView","Unqieue View Name");
		//Thread.sleep(10000);
		WebElement save = driver.findElement(By.name("save"));
		clickElement(save,"Save");
		this.waitUntilElementToBeClickable(By.name("fcf"), "view Drop Down");
		viewDropDown = new Select( driver.findElement(By.name("fcf")));
		Assert.assertEquals(verifyDropDownOptions(viewDropDown, "Test View"),true,"New View not added");
		BaseFirebasetlog.info("New Account View Added");
		Reporter.log("New Account View Added");
		//cleanup
		WebElement delete = driver.findElement(By.xpath("//a[contains(text(),'Delete')]"));
		delete.click();
		Alert alert = driver.switchTo().alert();
		alert.accept();

		
	}
	
	
}

		
		
		
		
	

		
	


