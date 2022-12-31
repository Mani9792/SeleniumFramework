package com.PageElements;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Utils.AbstractComponents;

public class OrderPage extends AbstractComponents{
	
	WebDriver driver;

	
	
	@FindBy(xpath="//table[contains(@class,'table')]/tbody/tr/td[2]")
	List<WebElement> orderProductNames;

	public OrderPage(WebDriver driver) {
		super(driver); //initialization of driver for parent AbstractComponents
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public List<WebElement> getOrderList()
	{
		return orderProductNames;
	}
	
	public Boolean verifyProductOrder(String productName)
	{
       List<WebElement> orderProducts = getOrderList();
       
       Boolean flag=false;
		
		for(int i=0;i<orderProducts.size();i++)
		{
			System.out.println(orderProducts.get(i).getText());
			
			if(orderProducts.get(i).getText().equalsIgnoreCase(productName))
			{
				//click on BuyNow
				flag=true;
				break;
			}
		}
		
		return flag;
	}

}
