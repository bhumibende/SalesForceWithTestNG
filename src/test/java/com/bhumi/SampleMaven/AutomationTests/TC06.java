//Login Error Message - 1
package com.bhumi.SampleMaven.AutomationTests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.bhumi.SampleMaven.base.BaseFirebase;
import com.bhumi.SampleMaven.base.BaseTest;

public class TC06 extends BaseFirebase{
	BaseTest base = new BaseTest();
	BaseFirebase basefb = new BaseFirebase();

	@Test
	public void verifyMyProfile() throws InterruptedException {
		//step1
		login_SalesForce();
		WebElement userMenu = driver.findElement(By.id("userNavButton"));
		clickElement(userMenu, "SalesForce User Menu");
		Assert.assertEquals(userMenu.isDisplayed(), true,"SalesForce UserMenu not displayed");
		List<WebElement> userMenuOptions = driver.findElements(By.xpath("//*[@id='userNavMenu']//a"));
		List<String> userMenuOptionsText = new ArrayList<>();
		for(WebElement w:userMenuOptions) {
			userMenuOptionsText.add(w.getText());
		}
		List<String> expecteduserMenuOptionsText = new ArrayList<String>();
		expecteduserMenuOptionsText.add("My Profile");
		expecteduserMenuOptionsText.add("My Settings");
		expecteduserMenuOptionsText.add("Developer Console");
		expecteduserMenuOptionsText.add("Switch to Lightning Experience");
		expecteduserMenuOptionsText.add("Logout");
		Assert.assertEquals(userMenuOptionsText, expecteduserMenuOptionsText,"SalesForce Menu Options are not as expeceted");
		BaseFirebasetlog.info("SalesForce User Menu Drop Down options verified");
		Reporter.log("SalesForce User Menu Drop Down options verified");
		
		//click My Profile
		WebElement myProfile = driver.findElement(By.xpath("//*[@id='userNavMenu']//a[@title='My Profile']"));
		clickElement(myProfile, "My Profile Menu");
		Assert.assertEquals(this.getPageTitle().contains("User"),true,"My Profile page is not displayed");
		BaseFirebasetlog.info("My Profile Page displayed after clicking My Profile Menu");
		Reporter.log("My Profile Page displayed after clicking My Profile Menu");
		
		
		//click edit profile button
		WebElement editButton =  driver.findElement(By.id("moderatorMutton")); 
		clickElement(editButton,"Edit");
		
		WebElement  editProfile = driver.findElement(By.xpath("//a[@title='Edit Profile']"));
		clickElement(editProfile,"Edit Profile ");
		
		WebElement aboutMe = driver.findElement(By.id("aboutMe"));
		Assert.assertEquals(aboutMe.isDisplayed(), true,"Edit Profile pop up not displayed");
		BaseFirebasetlog.info("Edit Profile pop up displayed after clicking Edit Profile button");
		Reporter.log("Edit Profile pop up displayed after clicking Edit Profile button");
		
		
		//Click on About Tab & Edit last name
		
		clickElement(aboutMe,"About Me");
		
		driver.switchTo().frame("aboutMeContentId"); 
		WebElement aboutTab = driver.findElement(By.id("aboutTab")); 
		//WebElement contactTab =  driver.findElement(By.id("contactTab"));
		Assert.assertEquals(aboutTab.isDisplayed(), true,"ABout Tab not present on Edit Profile pop up");
		BaseFirebasetlog.info("About Tab present on Edit Profile pop up");
		
		clickElement(aboutTab,"About Tab on Edit Profile pop up");
	
		WebElement lastName = driver.findElement(By.id("lastName"));
		clearElement(lastName,"Last Name field");
		
		enterText(lastName, "pawde", "Last Name Field");
		WebElement saveBtn = driver.findElement(By.xpath("//input[@value='Save All']")); 
		clickElement(saveBtn,"Save on Edit Profile pop up");
		driver.switchTo().defaultContent(); 
		
		//verify last name is modified
		WebElement  nameEdit = driver.findElement(By.id("tailBreadcrumbNode"));
		Assert.assertEquals(getTextFromElement(nameEdit, "Last Name on My Profile page").contains("pawde"), true,"Last Name not updated");
		BaseFirebasetlog.info("Last Name updated from edit profile popup");
		Reporter.log("Last Name updated from edit profile popup");
		
		
		//click on post tab
		WebElement post = driver.findElement(By.id("publisherAttachTextPost"));
		clickElement(post, "Post Comment ");
		driver.switchTo().frame(0);
		
		//add post & share 
		WebElement sendPost =  driver.findElement(By.tagName("body"));
		clickElement(sendPost, "Send Post Comment ");
		enterText(sendPost, "Test", "Send Post Comment Text");
		driver.switchTo().defaultContent();
		WaitUntilPresenceOfElementLocatedBy(By.id("publishersharebutton"), "Share Button");
		WebElement share = driver.findElement(By.id("publishersharebutton"));
		clickElement(share,"Share Post"); 
		WebElement feedText = driver.findElement(By.xpath("//span[@class='feeditemtext cxfeeditemtext']/p"));
		
		
		//verify shared post is added
		Assert.assertEquals(getTextFromElement(feedText, "Feed Text"), "Test");
		BaseFirebasetlog.info("Feed Text Verified");
		Reporter.log("Feed Text Verified");
		Thread.sleep(3000);
		//click on File link
		WebElement userFile = driver.findElement(By.xpath("//*[@title='File']/span[text()='File']"));
		//mouseOverOnElement(userFile, "userFile");
		clickElement(userFile,"User File");
		//clickElement(userFile,"User File");
		Thread.sleep(3000);
		this.WaitUntilPresenceOfElementLocatedBy(By.id("chatterUploadFileAction"), "User File Upload Screen");
		this.waitUntilElementToBeClickable(By.id("chatterUploadFileAction"), "User File Upload Screen");
		WebElement userFileUploadLink = driver.findElement(By.id("chatterUploadFileAction"));
		mouseOverOnElement(userFileUploadLink, "User File Upload");
		clickElement(userFileUploadLink,"User File Upload");
		this.WaitUntilPresenceOfElementLocatedBy(By.id("chatterFile"), "User File Upload Screen");
		WebElement userFileUpload = driver.findElement(By.id("chatterFile"));
		String filePath="C:\\Users\\vinay\\OneDrive\\Desktop\\SelemiumUpload.txt";
		enterText(userFileUpload, filePath, "Upload File");
		share = driver.findElement(By.id("publishersharebutton"));
		clickElement(share,"Share Post"); 
		this.WaitUntilPresenceOfElementLocatedBy(By.xpath("//a//span[@title='SelemiumUpload']"), "Uploaded File");
		WebElement uploadedFile = driver.findElement(By.xpath("//a//span[@title='SelemiumUpload']"));
		Assert.assertEquals(uploadedFile.isDisplayed(), true,"Uploaded File is not displayed");
		BaseFirebasetlog.info("Uploaded File is Verified");
		Reporter.log("Uploaded File is Verified");
		
		
		//upload Photo
		Thread.sleep(5000);
		this.WaitUntilPresenceOfElementLocatedBy(By.xpath("//*[@class='recImage photo']"), "Uploaded File");
		this.waitUntilElementToBeClickable(By.xpath("//*[@class='recImage photo']"), "Uploaded File");
		
		WebElement uploadPhoto = driver.findElement(By.xpath("//*[@class='recImage photo']"));
		clickElement(uploadPhoto, "Upload Photo");
		driver.switchTo().frame("uploadPhotoContentId");
		WebElement photoLink = driver.findElement(By.xpath("//input[@class='fileInput']"));
		mouseOverOnElement(photoLink, "Photo Link");
		String photoPath = "C:\\Users\\vinay\\OneDrive\\Desktop\\SeleniumUploadPhoto.jpg";
		enterText(photoLink,photoPath,"Photo Path");
		WebElement savePhoto = driver.findElement(By.xpath("//*[contains(@value,'Save')][2]"));
		this.clickElement(savePhoto, "Save Photo Button");
		driver.switchTo().defaultContent();
		this.waitUntilPageLoads();








	}

}
