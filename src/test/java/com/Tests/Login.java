	package com.Tests;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
import com.PageElements.OrderPage;
import com.PageElements.ProductPage;
import com.Test_Components.BaseTest_Drivers;
import com.Test_Components.RetryRun;
import com.Utils.Config;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login extends BaseTest_Drivers{
	
	WebDriver driver;
	
	@Test(enabled=true, retryAnalyzer = RetryRun.class)
	public void login_test() throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		Config config = new Config();
		
		//LoginPage
		System.out.println("----Login Page----");
		login.login_userName(config.configure("userName"));
		login.login_password(config.configure("password"));
		login.login_button();
		ProductPage productLog = login.verifyLoginSuccessMsg();
		System.out.println("----Login Complete----");		
		//Products
		List<WebElement> products = productLog.getProductList();
		System.out.println("----Product Page----");	
		productLog.getProduct_addToCart(config.configure("product"));
	
		productLog.verifySuccessMsg();
		
		CartPage cartLog=productLog.goToCart();
		System.out.println("----Product complete----");	
		
		//Cart		
		List<WebElement> cartProducts = cartLog.getCartList();
		System.out.println("----Cart Page----");	
		CheckOutPage checkOutLog=cartLog.verifyProduct_and_checkOut(config.configure("product"));
		System.out.println("----Cart Complete----");
		
		//checkout
		System.out.println("----Checkout Page----");	
		checkOutLog.selectCountry(config.configure("country"));
		
		ConfirmationPage confLog=checkOutLog.placeOrder();
		System.out.println("----Checkout Complete----");
		
		//confirm order
		System.out.println("----Order Confirmation Page----");
	    String orderPlaced = confLog.verifyOrderSuccessMsg();
        String msgOrder = config.configure("msgOrder");
		
		Assert.assertEquals(orderPlaced,msgOrder );
		
		System.out.println("Order Confirmation: "+orderPlaced);
		System.out.println("----Order Placed---");		

		
	}
	//(dependsOnMethods= {"login_test"})
	@Test(enabled = true,description="checking the order page",dependsOnMethods= {"login_test"})
	public void checkOrderPage() throws IOException
	{
        Config config = new Config();
        String productName = config.configure("product");
		
		//Login
		login.login_userName(config.configure("userName"));
		login.login_password(config.configure("password"));
		login.login_button();
		ProductPage productLog = login.verifyLoginSuccessMsg();
		
		OrderPage orderLog = productLog.goToOrder();
		Assert.assertTrue(orderLog.verifyProductOrder(productName),"Test Passed");
		
		//Order page
	}
	

}
