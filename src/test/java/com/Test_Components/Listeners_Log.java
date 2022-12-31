package com.Test_Components;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.Utils.ExtentReporterNG;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;

public class Listeners_Log extends BaseTest_Drivers implements ITestListener{
	
	ExtentTest test;
	ExtentReports extent = ExtentReporterNG.getExtentReport();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	
	   
    @Override		
    public void onTestStart(ITestResult result) {					
        // TODO Auto-generated method stub	
    	
    	test = extent.createTest(result.getMethod().getMethodName());
    	extentTest.set(test);
        		
    }	
    
    @Override		
    public void onTestSuccess(ITestResult result) {					
        // TODO Auto-generated method stub
    	
    	//test.log(Status.PASS, "Testmethod passed");
    	extentTest.get().log(Status.PASS, "Testmethod passed");
    	
        //To add screenshot
        // to give the life to driver we get it through the 'result' which has all test info  
        //and ensure code flow using below...
        try {
        	//fields are associated at Class level
        	//so we use the test class and real class to point to the class and get the driver it used
        	
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
			
		} 
        catch (Exception e) {
			
			e.printStackTrace();
		}
        
        // to get the screenshot method
        String filepath=null;
		try {
			filepath = getScreenshot(result.getMethod().getMethodName(),driver);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//to add screenshot
        
        try 
        {      	
			//test.addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());	
        	extentTest.get().addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());	
        	
        	MediaEntityModelProvider mediaModel = MediaEntityBuilder.createScreenCaptureFromPath(filepath).build();
        	
        	extentTest.get().log(Status.INFO, result.getMethod().getMethodName(),mediaModel);
		} 
        catch (IOException e) 
        {
			e.printStackTrace();
		}
        		
    }

    @Override		
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {					
        // TODO Auto-generated method stub				
        		
    }		

    @Override		
    public void onTestFailure(ITestResult result) {					
        // TODO Auto-generated method stub				
    	extentTest.get().fail(result.getThrowable());	
        
        //To add screenshot
        // to give the life to driver we get it through the 'result' which has all test info  
        //and ensure code flow using below...
        try {
        	//fields are associated at Class level
        	//so we use the test class and real class to point to the class and get the driver it used
        	
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
			
		} 
        catch (Exception e) {
			
			e.printStackTrace();
		}
        
        // to get the screenshot method
        String filepath=null;
		try {
			filepath = getScreenshot(result.getMethod().getMethodName(),driver);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//to add screenshot
        
        try 
        {      	
			//test.addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());	
        	extentTest.get().addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());	
		} 
        catch (IOException e) 
        {
			e.printStackTrace();
		}
    }		

    @Override		
    public void onTestSkipped(ITestResult result) {					
     			
        test.log(Status.SKIP, "Test Skipped");		
    }		
    
    @Override		
    public void onFinish(ITestContext context) {					
     
   //to close extent 
    	extent.flush();
        		
    }		

    @Override		
    public void onStart(ITestContext context) {					
        // TODO Auto-generated method stub				
        		
    }		
		
	
	
}
