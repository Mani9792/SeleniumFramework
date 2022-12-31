package com.Tests;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.PageElements.CartPage;
import com.PageElements.CheckOutPage;
import com.PageElements.ConfirmationPage;
import com.PageElements.LoginPage;
import com.PageElements.ProductPage;
import com.Test_Components.BaseTest_Drivers;
import com.Utils.Config;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ErrorValidation extends BaseTest_Drivers{
	
	WebDriver driver;
	
	@Test(description="error validation on login page")
	public void login_test() throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		Config config = new Config();
		
		//Login
		login.login_userName(config.configure("userName_EV"));
		login.login_password(config.configure("password_EV"));
		login.login_button();
		login.errorValidn();
		Assert.assertEquals("Incorrect email or password", login.errorValidn());
			
	}

}
