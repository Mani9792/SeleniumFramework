package com.Samples;

public class Sample {
	
	public void sample()
	{
		//LoginPage login = launchApplication();
		
				//LoginPage login = new LoginPage(driver);
				//CartPage cartLog = new CartPage(driver);
				//CheckOutPage checkOutLog = new CheckOutPage(driver);
				//ConfirmationPage confLog = new ConfirmationPage(driver);
		
		
		
		/*//driver.get("https://www.rahulshettyacademy.com/client");
		 * driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("slmkn666@gmail.com");
		  driver.findElement(By.xpath("//input[@id='userPassword']")).sendKeys("Mani@1996");
	      driver.findElement(By.xpath("//input[@id='login']")).click();
		 * List<WebElement> products = driver.findElements(By.xpath("//div[contains(@class,'mb-3')]/div[@class='card']/div/h5/b"));
		 * for(int i=0;i<products.size();i++) {
		 * System.out.println(products.get(i).getText());
		 * 
		 * if(products.get(i).getText().equalsIgnoreCase("ZARA COAT 3")) {
		 * 
		 * products.get(i).findElement(By.xpath("//div[@class='card-body']/button[2]")).
		 * click(); } }
		 * 
		 * //wait for success msg after add cart WebElement successMsg =
		 * driver.findElement(By.xpath("//div[@id='toast-container']"));
		 * 
		 * WebDriverWait wait = new WebDriverWait(driver,10);
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * "//div[@id='toast-container']")));
		 * 
		 * System.out.println(successMsg.getText());
		 * 
		 * wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(
		 * "//div[@id='toast-container']")));
		 */
		
		//driver.findElement(By.xpath("//button[contains(text(),'Cart')][contains(@class,'btn btn-custom')]")).click();
		
		//List<WebElement> cartProducts = driver.findElements(By.xpath("//div[@class='cartSection']/h3"));
		
		/*
		 * for(int i=0;i<cartProducts.size();i++) {
		 * System.out.println(cartProducts.get(i).getText());
		 * 
		 * if(cartProducts.get(i).getText().equalsIgnoreCase("ZARA COAT 3")) { //click
		 * on BuyNow
		 * 
		 * driver.findElement(By.xpath("//button[text()='Buy Now']")).click(); } }
		 */
		
		//Actions action = new Actions(driver);
		
		//WebElement selectCountry = driver.findElement(By.xpath("//input[@placeholder='Select Country']")); 
		
		//action.sendKeys(selectCountry, "India").build().perform();
		
		//driver.findElement(By.xpath("//button[contains(@class,'ta-item')][2]")).click();
		
		//Thread.sleep(8000);
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@class,'btnn action__submit')]")));
		
		//action.doubleClick(driver.findElement(By.xpath("//div[@class='actions']/a[contains(text(),'Place Order')]"))).build().perform();
		
		/*
		 * WebElement placeOrder =
		 * driver.findElement(By.xpath("//a[contains(@class,'btnn action__submit')]"));
		 * 
		 * JavascriptExecutor execute = (JavascriptExecutor) driver;
		 * execute.executeScript("arguments[0].scrollIntoView();", placeOrder);
		 * 
		 * placeOrder.click();
		 */
		
		//driver.findElement(By.cssSelector(".action__submit")).click();
		
		//String orderPlaced = driver.findElement(By.xpath("//h1[@class='hero-primary']")).getText();
		
		//String msgOrder = "THANKYOU FOR THE ORDER.";
		
		//Assert.assertEquals(orderPlaced,msgOrder );
	}

}
