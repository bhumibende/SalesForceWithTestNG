//Login Error Message - 1
package com.bhumi.SampleMaven.AutomationTests;

import org.testng.annotations.Test;

import com.bhumi.SampleMaven.base.BaseFirebase;
import com.bhumi.SampleMaven.base.BaseTest;

public class TC09 extends BaseFirebase{
	BaseTest base = new BaseTest();
	BaseFirebase basefb = new BaseFirebase();

	@Test
	public void verifyLogout() throws InterruptedException {
		//step1
		login_SalesForce();
			
		
		//step2
		logout_SalesForce();		
	}
}

		
	


