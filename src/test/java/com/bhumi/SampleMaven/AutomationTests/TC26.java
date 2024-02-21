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

public class TC26 extends BaseFirebase{
	BaseTest base = new BaseTest();
	BaseFirebase basefb = new BaseFirebase();

	@Test
	public void createContactView() throws InterruptedException {
		//step1
		login_SalesForce();
		
		
		//Contacts tab
		clickContacts();
		
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
		}
		
		
		//new view
		this.WaitUntilPresenceOfElementLocatedBy(By.xpath("//a[text()='Create New View']"), "New View");
		WebElement newView = driver.findElement(By.xpath("//a[text()='Create New View']"));
		clickElement(newView,"New Contact View");
		Assert.assertEquals(this.getPageTitle().contains("Create New View"),true,"Create New View page not opened");
		BaseFirebasetlog.info("New Contact View page opened");
		Reporter.log("New Contact View page opened");		
		WebElement viewName = driver.findElement(By.id("fname"));
		enterText(viewName,"Test View","New View Name");
		
		WebElement uniqueViewName = driver.findElement(By.id("devname"));
		clearElement(uniqueViewName,"Unique View Name");
		enterText(uniqueViewName,"TestView","Unqieue View Name");
		Thread.sleep(3000);
		WebElement save = driver.findElement(By.name("save"));
		clickElement(save,"Save");
		this.WaitUntilPresenceOfElementLocatedBy(By.name("fcf"), "view Drop down");
		 viewDropDown = new Select( driver.findElement(By.name("fcf")));
		Assert.assertEquals(verifyDropDownOptions(viewDropDown, "Test View"),true,"New View not added");
		BaseFirebasetlog.info("New Contact View Added");
		Reporter.log("New Contact View Added");
		//cleanup
		Thread.sleep(5000);
		WebElement delete = driver.findElement(By.xpath("//a[contains(text(),'Delete')]"));
		delete.click();
		Alert alert = driver.switchTo().alert();
		alert.accept();

		
	}
	
	
}

		
		
		
		
	

		
	


