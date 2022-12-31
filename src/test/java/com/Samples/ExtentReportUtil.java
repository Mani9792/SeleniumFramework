package com.Samples;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportUtil {
	
	ExtentReports extReport;
	@BeforeTest
	
	public void config()
	{
		//Use extent spark reporter to define the path of the report file
		ExtentSparkReporter reporter = new ExtentSparkReporter(System.getProperty("user.dir")+"\\reports\\report1");
		
		//Configure with report name, title...
		
		reporter.config().setDocumentTitle("reports");
		reporter.config().setReportName("Extent sample");
		reporter.config().setTheme(Theme.DARK);
		reporter.config().setTimeStampFormat("yyyy-MM-dd HH:mm:ss");
				
		// ExtentReports class is the main class which drives all about the execution results
		extReport = new ExtentReports();
		
		//Now attach the spark reporter to Main class
		
		extReport.attachReporter(reporter);
		
		extReport.setSystemInfo("Tester", "Mani");
		extReport.setSystemInfo("Enviromen", "QA");
				
	}
	
	
	@Test
	public void test()
	{
		//Add the extent to test class file
		
		extReport.createTest("test");
		
		//Test
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.saucedemo.com");
		
		driver.quit();
				
		//to close extent
		
		extReport.flush();
	}

}
