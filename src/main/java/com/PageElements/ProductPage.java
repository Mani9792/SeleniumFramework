package com.PageElements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Utils.AbstractComponents;

    public class ProductPage extends AbstractComponents {
	
    WebDriver driver;
		
	public ProductPage(WebDriver driver)
	{
		super(driver);  //initialization of driver for parent AbstractComponents
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[contains(@class,'mb-3')]/div[@class='card']/div/h5/b")
	List<WebElement> products;
	
	By productBy = By.xpath("//div[contains(@class,'mb-3')]/div[@class='card']/div/h5/b");
	
	By clickCart = By.xpath("//div[@class='card-body']/button[2]");
	
	@FindBy(xpath="//div[@id='toast-container']")
	WebElement successMsg;
	
	public List<WebElement> getProductList()
	{
		waitForElementToAppear_By(productBy);
		return products;
	}
	
	public void getProduct_addToCart(String productName)
	{
		List<WebElement> products =  getProductList();
		
		for(int i=0;i<products.size();i++)
		{
			//System.out.println(products.get(i).getText());			
			
			if(products.get(i).getText().equalsIgnoreCase(productName))//ZARA COAT 3
			{   
				products.get(i).findElement(clickCart).click();
			}
			
		}		
	}
	
	public void verifySuccessMsg()
	{
        	
		waitForElementToAppear(successMsg);
		
		System.out.println(successMsg.getText());
		
		waitForElementToDisappear(successMsg);
	}
	
	
	
}
