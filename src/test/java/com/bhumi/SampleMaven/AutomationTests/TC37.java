//Login Error Message - 1
package com.bhumi.SampleMaven.AutomationTests;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.bhumi.SampleMaven.base.BaseFirebase;
import com.bhumi.SampleMaven.base.BaseTest;

public class TC37 extends BaseFirebase{
	BaseTest base = new BaseTest();
	BaseFirebase basefb = new BaseFirebase();

	@Test
	public void verifyCalendarEventBlock() throws InterruptedException {
		//step1
		login_SalesForce();
		//WebElement userMenu = driver.findElement(By.id("userNavButton"));
		//click Home
		clickHome();
		Assert.assertEquals(this.getPageTitle().contains("Salesforce - Developer Edition"), true,"Home Page not opened");
		BaseFirebasetlog.info("Home page opened");
		Reporter.log("Home page opened");

		//verify current date in Day Month dd,yyyy format on page
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("EEEE MMMM dd, yyyy");
		LocalDateTime now = LocalDateTime.now();
		String expectedDate = dtf.format(now);
		WebElement pageDate = driver.findElement(By.xpath("//*[@class='pageDescription']/a"));
		//System.out.println(pageDate.getText());
		
		Assert.assertEquals(pageDate.getText(),expectedDate,"Current Date");
		BaseFirebasetlog.info("Current Date on Home page verified");
		Reporter.log("Current Date on Home page verified");

		

		//click on link
		clickElement(pageDate,"Page Date");
		String title = getPageTitle();
		Assert.assertEquals(title.contains("Calendar for bhumi pawde"), true,"Calendar page not opened");
		BaseFirebasetlog.info("Calendar Page Opened");
		Reporter.log("Calendar Page Opened");

		//create new event at 4 PM
		WebElement create4PMEvent = driver.findElement(By.xpath("//*[contains(@class,'hour')]/a[contains(text(),'4:00 PM')]"));
		clickElement(create4PMEvent,"4 Pm Event");
		//create8PMEvent.click();
		title = getPageTitle();
		Assert.assertEquals(title.contains("Calendar: New Event"), true,"Calendar New Event page not opened");
		BaseFirebasetlog.info("Calendar New Event Page Opened");
		Reporter.log("Calendar New Event Page Opened");
		
		//CommonMethods.verifyTitleContains(driver, "Calendar: New Event");

		//click on subject combo icon
		String parent = driver.getWindowHandle();
		WebElement subjectComboIcon = driver.findElement(By.xpath("//a[contains(@title,'Combo')]"));
		clickElement(subjectComboIcon,"Subject Combo");
		//subjectComboIcon.click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Set<String> pageList = driver.getWindowHandles();
		//System.out.println(pageList.size());
		Iterator<String> page = pageList.iterator();

		while(page.hasNext()) {
			String child = page.next();
			if(!parent.equals(child)) {
				driver.switchTo().window(child);
				driver.manage().window().maximize();
				title = getPageTitle();
				Assert.assertEquals(title.contains("ComboBox"), true,"ComboBox page not opened");
				BaseFirebasetlog.info("ComboBox Page Opened");
				Reporter.log("ComboBox Page Opened");
				
				WebElement otherSubject = driver.findElement(By.linkText("Other"));
				clickElement(otherSubject,"Other Subject");
				//otherSubject.click();				
			}
		}

		Set<String> pageListUpdated = driver.getWindowHandles();
		Assert.assertEquals(pageListUpdated.size(),1,"ComboBox subject popup not closed as expected");
		BaseFirebasetlog.info("ComboBox subject popup closed as expected");
		Reporter.log("ComboBox subject popup closed as expected");
		
		driver.switchTo().window(parent);
		WebElement subject = driver.findElement(By.id("evt5"));
		String sub = subject.getAttribute("value");
		Assert.assertEquals(sub,"Other","Other not selected as subject as expected");
		BaseFirebasetlog.info("Other selected as subject as expected");
		Reporter.log("Other selected as subject as expected");
		
		
		
		//End time verification
		WebElement endTime = driver.findElement(By.id("EndDateTime_time"));
		clickElement(endTime,"End Time");
		WebElement timePicker = driver.findElement(By.id("simpleTimePicker"));
		Assert.assertEquals(timePicker.isDisplayed(),true,"drop down for time pick for end time not displayed");
		BaseFirebasetlog.info("drop down for time pick for end time displayed");
		Reporter.log("drop down for time pick for end time displayed");	
		

		//select 9 PM as end time
		//select 7 PM as end time
		WebElement eventEnd7PM = driver.findElement(By.id("timePickerItem_38"));
		//WebElement eventEnd9PM = driver.findElement(By.id("timePickerItem_42"));
		clickElement(eventEnd7PM,"7 PM Event");
		String endTimval = endTime.getAttribute("value");
		Assert.assertEquals(endTimval,"7:00 PM","End time not selected as 7:00 PM");
		BaseFirebasetlog.info("End time selected as 7:00 PM");
		Reporter.log("End time selected as 7:00 PM");	

		WebElement recurrence = driver.findElement(By.id("IsRecurrence"));
		clickElement(recurrence,"Recurrence");
		//recurrence.click();
		WebElement frequency = driver.findElement(By.className("recurrenceTable"));
		Assert.assertEquals(frequency.isDisplayed(), true,"Frequency field not displayed");
		BaseFirebasetlog.info("Frequency section with radio buttons displayed");
		Reporter.log("Frequency section with radio buttons displayed");	
		
		WebElement recurrenceStartDate = driver.findElement(By.id("RecurrenceStartDateTime"));
		Assert.assertEquals(recurrenceStartDate.isDisplayed(), true,"Recurrence start date field not displayed");
		BaseFirebasetlog.info("Recurrence start date field displayed");
		Reporter.log("Recurrence start date field displayed");	
		
		WebElement RecurrenceEndDate = driver.findElement(By.id("RecurrenceEndDateOnly"));
		Assert.assertEquals(RecurrenceEndDate.isDisplayed(), true,"Recurrence end date field not displayed");
		BaseFirebasetlog.info("Recurrence end date field displayed");
		Reporter.log("Recurrence end date field displayed");
		
		
		
		WebElement weekly = driver.findElement(By.id("rectypeftw"));
		clickElement(weekly,"Weekly");
		//weekly.click();
		WebElement recurEvery = driver.findElement(By.id("wi"));
		Assert.assertEquals(recurEvery.isDisplayed(), true,"Recurs every field not displayed");
		BaseFirebasetlog.info("Recurs every field  displayed");
		Reporter.log("Recurs every field displayed");
		String recursnew = recurEvery.getAttribute("value");
		Assert.assertEquals(recursnew, "1","Recurs every field not displayed with 1 as default");
		BaseFirebasetlog.info("Recurs every field displayed with 1 as default");
		Reporter.log("Recurs every field displayed with 1 as default");
		
		
		DateTimeFormatter dtfs = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		 String recurEnd  = dtfs.format(LocalDateTime.now().plusWeeks(2));
		 enterText(RecurrenceEndDate,recurEnd,"recurrent end date");
		// RecurrenceEndDate.sendKeys(recurEnd);
		
		//Save
		WebElement save = driver.findElement(By.name("save"));
		clickElement(save,"Save");
		title = getPageTitle();
		Assert.assertEquals(title.contains("Calendar for bhumi pawde"), true,"Calendar for bhumi pawde page not opened");
		BaseFirebasetlog.info("Calendar for bhumi pawde Page Opened");
		Reporter.log("Calendar for bhumi pawde Page Opened");
		
		
		WebElement newEvent = driver.findElement(By.xpath("//a[contains(@title,'Other')]"));
		Assert.assertEquals(newEvent.isDisplayed(), true,"New Event Other for Calendar not added");
		BaseFirebasetlog.info("New Event Other for Calendar added");
		Reporter.log("New Event Other for Calendar added");
		
		WebElement Monthly = driver.findElement(By.xpath("//a[@title='Month View']/img"));
		clickElement(Monthly,"Monthly");
		newEvent = driver.findElement(By.xpath("//a[contains(text(),'Other')]"));
		Assert.assertEquals(newEvent.isDisplayed(), true,"New Event Other for Calendar in monthly view added");
		BaseFirebasetlog.info("New Event Other for Calendar in monthly view");
		Reporter.log("New Event Other for Calendar in monthly view");
		//CommonMethods.verifyElementDisplayed(newEvent, "New Event Other for Calendar in monthly view");
		//cleanup: delete event created
		clickElement(newEvent,"NewEvent");
		//newEvent.click();
		WebElement viewSeries = driver.findElement(By.xpath("//a[@title='View Series Subtab']"));
		clickElement(viewSeries,"View Series");
	//	viewSeries.click();
		
		//cleanup: delete event created
		
		Thread.sleep(5000);
		this.WaitUntilPresenceOfElementLocatedBy(By.name("del"),"delete");
		WebElement deleteEvent = driver.findElement(By.name("del"));
		deleteEvent.click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		driver.switchTo().defaultContent();
		Thread.sleep(5000);
		pageDate = driver.findElement(By.xpath("//*[@class='pageDescription']/a"));
		//System.out.println(pageDate.getText());
		newEvent = driver.findElement(By.xpath("//a[contains(text(),'Other')]"));
		
		//CommonMethods.verifyElementDisplayed(newEvent, "New Event Other for Calendar in monthly view");
		//cleanup: delete event created
		clickElement(newEvent,"NewEvent");
		this.WaitUntilPresenceOfElementLocatedBy(By.name("del"),"delete");
		 deleteEvent = driver.findElement(By.name("del"));
		deleteEvent.click();
		 alert = driver.switchTo().alert();
		alert.accept();
		driver.switchTo().defaultContent();
		Thread.sleep(5000);
		

		

		//click on link
		//clickElement(pageDate,"Page Date");
		Thread.sleep(3000);
		
		//driver.close();



	}


}











