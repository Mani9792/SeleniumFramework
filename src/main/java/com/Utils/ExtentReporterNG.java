package com.Utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporterNG {
	
	public static ExtentReports getExtentReport()
	
	{
		
		//To add time stamp
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy_MM_dd HH_mm_ss");  
		LocalDateTime dateTime = LocalDateTime.now();
		String getTimeNow = formatter.format(dateTime);
		
		//Use extent spark reporter to define the path of the report file
		//System.getProperty("user.dir")+"\\reports\\"+dateTime+".html"
		//"./Extent_Reports/"+ getTimeNow() + "_ExtentReport.html" "+ getTimeNow +"
				ExtentSparkReporter reporter = new ExtentSparkReporter("./Extent_Reports/_ExtentReport.html");
				
				//Configure with report name, title...
					
				reporter.config().setDocumentTitle("reports");
				reporter.config().setReportName("Extent sample");
				//reporter.config().setTheme(Theme.DARK);
				reporter.config().setTimeStampFormat("yyyy-MM-dd HH:mm:ss");
						
				// ExtentReports class is the main class which drives all about the execution results
				ExtentReports extent = new ExtentReports();
				
				//Now attach the spark reporter to Main class
				
				extent.attachReporter(reporter);
				
				extent.setSystemInfo("Tester", "Mani");
				extent.setSystemInfo("Enviroment", "QA");
				
				return extent;
		
	}
	

}
