package com.PageElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Utils.AbstractComponents;

public class LoginPage extends AbstractComponents{
	
	WebDriver driver;

	public LoginPage(WebDriver driver)
	{
		super(driver); //initialization of driver for parent AbstractComponents
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='userEmail']")
	WebElement userName;
	
	@FindBy(xpath="//input[@id='userPassword']")
	WebElement password;
	
	@FindBy(xpath="//input[@id='login']")
	WebElement login_clk;
	
	@FindBy(xpath="//div[@id='toast-container']")
	WebElement loginSuccessMsg;
	
	@FindBy(xpath="//div[@id='toast-container']")
	WebElement errorMessage;
	
	public void goTo(String url)
	{
		driver.get(url);
	}
	
	public void login_userName(String email) 
	{
		userName.sendKeys(email);
	}
	
	public void login_password(String pass) 
	{
		password.sendKeys(pass);
	}
	
	public void login_button()
	{
		login_clk.click();
	}
	
	public ProductPage verifyLoginSuccessMsg()
	{
        	
		waitForElementToAppear(loginSuccessMsg);
		
		System.out.println(loginSuccessMsg.getText());
		
		waitForElementToDisappear(loginSuccessMsg);
		
		ProductPage productLog = new ProductPage(driver);
		
		return productLog;
	}
	
	
	public String errorValidn()
	{
		waitForElementToAppear(errorMessage);
		System.out.println(errorMessage.getText());
		waitForElementToDisappear(errorMessage);
		return errorMessage.getText();			
	}
		

}
