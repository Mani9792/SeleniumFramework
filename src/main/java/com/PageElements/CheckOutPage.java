package com.PageElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Utils.AbstractComponents;

public class CheckOutPage extends AbstractComponents{
	
    WebDriver driver;
	
	public CheckOutPage(WebDriver driver)
	{
		super(driver);  //initialization of driver for parent AbstractComponents
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement country;
	
	@FindBy(xpath="//button[contains(@class,'ta-item')][2]")
	WebElement selectCountry;
	
	@FindBy(css=".action__submit")
	WebElement placeOrder;	
	
	public void selectCountry(String countryName)
	{
		//waitForElementToAppear(country);
        country.sendKeys(countryName);
		
		selectCountry.click();
	}
	
	public ConfirmationPage placeOrder()
	{
        placeOrder.click();
        
        ConfirmationPage confLog = new ConfirmationPage(driver);
        return confLog;
		
	}


}
