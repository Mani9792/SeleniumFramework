package com.PageElements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Utils.AbstractComponents;

public class CartPage extends AbstractComponents{
	
	WebDriver driver;
	
	public CartPage(WebDriver driver)
	{
		super(driver);  //initialization of driver for parent AbstractComponents
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='cartSection']/h3")
	List<WebElement> cartProducts;
	
	@FindBy(xpath="//button[contains(text(),'Checkout')]")
	WebElement checkOut;
	
	public List<WebElement> getCartList()
	{
		return cartProducts;
	}
	
	public CheckOutPage verifyProduct_and_checkOut(String productName)
	{
		
        List<WebElement> cartProducts = getCartList();
		
		for(int i=0;i<cartProducts.size();i++)
		{
			System.out.println(cartProducts.get(i).getText());
			
			if(cartProducts.get(i).getText().equalsIgnoreCase(productName))
			{
				//click on BuyNow
				checkOut.click();
			}
		}
		
		CheckOutPage checkOutLog = new CheckOutPage(driver);
		return checkOutLog;
		
	}
	

}
