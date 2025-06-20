package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ProductCartPage extends BasePage {

	public ProductCartPage(WebDriver driver) {
		super(driver);
		
	}
		
		//9. Verify both products are added to Cart
		
		@FindBy(xpath="//a[text()='Blue Top']")
		WebElement product1;
		
		@FindBy(xpath="//a[text()='Men Tshirt']")
		WebElement product2;
		
		public boolean isFirstProductAddedToCart()
		{
			return product1.isDisplayed();
			
		}
		
		public boolean isSecondProductAddedToCart()
		{
			return product2.isDisplayed();
		}
		
		//10. Verify their prices, quantity and total price
		
		@FindBy(xpath="//p[text()='Rs. 500']")
		WebElement price1;
		
		@FindBy(xpath="(//button[@class='disabled'])[1]")
		WebElement quantity1;
		
		@FindBy(xpath="(//p[@class='cart_total_price'])[1]")
		WebElement total_price1;
		
		public boolean isFirstProductPriceDisplayed()
		{
			return price1.isDisplayed();
		}
		
		public boolean isFirstProductQuantityDisplayed() 
		{
			return quantity1.isDisplayed();
		}
		
		public boolean isFirstProductTotalPriceDisplayed()
		{
			return total_price1.isDisplayed();
		}

}
