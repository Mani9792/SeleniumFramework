package com.Test_Components;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.PageElements.LoginPage;
import com.Utils.Config;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest_Drivers {
	
	public WebDriver driver;
	public LoginPage login ;
	Config config = new Config();
	
	public WebDriver initializeDriver() throws IOException
	{		
		//System.getProperty is added in String browser to ensure that the project run as per updates
		// through the maven commands from terminal
		
		String browser = System.getProperty("browser")!=null ? 
				System.getProperty("browser"):config.configure("browser");
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		
		else if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		else if(browser.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
        driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		return driver;
	}

	@BeforeMethod
	public LoginPage launchApplication() throws IOException
	{
		driver = initializeDriver();
		
		login = new LoginPage(driver);
		
		String url = config.configure("url");
		
		login.goTo(url);
		
		return login;
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException 
	{
		TakesScreenshot takeScreenshot = (TakesScreenshot)driver;
		
		// driver in takes screenshot do not have life now
		// so we are getting the driver through listeners--> on test fail method
		// Here we add the driver in the constructor of the method and call it in listeners
		
		File source_Scrshot = takeScreenshot.getScreenshotAs(OutputType.FILE);
		
		String scrShot_Path = System.getProperty("user.dir")+"//Screenshots//"+ testCaseName + ".png"; 
		
		File dest_Scrshot = new File(scrShot_Path);
		
		FileUtils.copyFile(source_Scrshot, dest_Scrshot);
		
		//return dest_Scrshot;
		
		return scrShot_Path;
	}

}
