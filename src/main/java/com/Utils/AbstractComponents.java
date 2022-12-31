package com.Utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.PageElements.CartPage;
import com.PageElements.OrderPage;

public class AbstractComponents {
	
	WebDriver driver;
	
	public AbstractComponents(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[contains(text(),'Cart')][contains(@class,'btn btn-custom')]")
	WebElement cartNavgn;
	
	@FindBy(xpath="(//button[@class='btn btn-custom'])[2]")
	WebElement orderLink;


	public void waitForElementToAppear(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForElementToAppear_By(By element)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	}
	
	public void waitForElementToDisappear(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	public CartPage goToCart()
	{
		cartNavgn.click();
		CartPage cartLog = new CartPage(driver);
		return cartLog;
	}
	
	public OrderPage goToOrder()
	{
		orderLink.click();
		OrderPage orderLog = new OrderPage(driver);
		return orderLog;
	}

}
