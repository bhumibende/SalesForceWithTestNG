package com.bhumi.SampleMaven.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class FirebaseListenerUtility implements ITestListener {
	protected Logger Listenerlog=LogManager.getLogger();
	@Override
	public void onTestStart(ITestResult result) {
		Listenerlog.info(result.getMethod().getMethodName()+".......test execution started........");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		Listenerlog.info(result.getMethod().getMethodName()+".......test execution completed with success........");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		Listenerlog.error(result.getMethod().getMethodName()+".......test execution completed with failure........");
	}

	@Override
	public void onStart(ITestContext context) {
		Listenerlog.info(context.getName()+" has started....................");
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
		Listenerlog.info(context.getName()+" has ended....................");
		
	}
	
	

}
