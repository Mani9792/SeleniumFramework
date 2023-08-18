package com.PageElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Utils.AbstractComponents;

public class ConfirmationPage extends AbstractComponents{
	
WebDriver driver;
	
	public ConfirmationPage(WebDriver driver)
	{
		super(driver);  //initialization of driver for parent AbstractComponents
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h1[@class='hero-primary']")
	WebElement orderConfirmationMsg;
	
	@FindBy(xpath="//div[@id='toast-container']")
	WebElement orderSuccessMsg;
	
	public String verifyOrderSuccessMsg()
	{
		waitForElementToAppear(orderSuccessMsg);
		System.out.println(orderSuccessMsg.getText());
		return orderConfirmationMsg.getText();
	}

}
