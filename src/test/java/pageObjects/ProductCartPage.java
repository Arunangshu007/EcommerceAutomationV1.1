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
		
		
		//9. Verify that product is displayed in cart page with exact quantity
		
		@FindBy(xpath="//button[@class='disabled']")
		WebElement txt_countQuantity;
		
		public String getNumberofQuantity()
		{
			try
			{
				return txt_countQuantity.getText();
			}
			catch(Exception e)
			{
				return e.getMessage();
			}
			
		}
		
		//6. Verify that cart page is displayed
		
		@FindBy(xpath="//a[text()='Proceed To Checkout']")
		WebElement txt_Checkout;
		
		public String getProceedToChekoutMessage()
		{
			try
			{
				return txt_Checkout.getText();
			}
			
			catch(Exception e)
			{
				return e.getMessage();
			}
		}
		
		//7. Click Proceed To Checkout
		
		@FindBy(xpath="//a[@class='btn btn-default check_out']")
		WebElement btn_checkout;
		
		public void clickProceedToCheckout()
		{
			btn_checkout.click();
		}
		
		//8. Click 'Register / Login' button
		@FindBy(xpath="//u[normalize-space()='Register / Login']")
		WebElement btn_Register;
		
		public void clickRegisterLogin()
		{
			btn_Register.click();
		}
		
		//14. Verify Address Details and Review Your Order
		@FindBy(xpath="(//h3[@class='page-subheading'])[1]")
		WebElement txt_Address;
		
		public String getAddressConfirmationMessage()
		{
			try
			{
				return txt_Address.getText();
			}
			catch(Exception e)
			{
				return e.getMessage();
			}
		}
		
		//15. Enter description in comment text area and click 'Place Order'
		@FindBy(xpath="//textarea[@class='form-control']")
		WebElement text_box;
		
		public void setTextInCommentBox(String textmessage)
		{
			text_box.sendKeys(textmessage);
		}
		
		@FindBy(xpath="//a[@class='btn btn-default check_out']")
		WebElement btn_PlaceOrder;
		
		public void clickPlaceOrder()
		{
			btn_PlaceOrder.click();
		}
		
		//16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
		@FindBy(xpath="//input[@class='form-control']")
		WebElement txt_Cardname;
		
		@FindBy(xpath="//input[@name='card_number']")
		WebElement txt_CardNo;
		
		@FindBy(xpath="//input[@class='form-control card-cvc']")
		WebElement txt_CVC;
		
		@FindBy(xpath="//input[@class='form-control card-expiry-month']")
		WebElement txt_month;
		
		@FindBy(xpath="//input[@class='form-control card-expiry-year']")
		WebElement txt_year;
		
		public void setNameOfCard(String name)
		{
			txt_Cardname.sendKeys(name);
		}
		
		public void setCardNumber(String number)
		{
			txt_CardNo.sendKeys(number);
		}
		
		public void setCardCVC(String number)
		{
			txt_CVC.sendKeys(number);
		}
		
		public void setMonth(String month)
		{
			txt_month.sendKeys(month);
		}
		
		public void setYear(String year)
		{
			txt_year.sendKeys(year);
		}
		
		//17. Click 'Pay and Confirm Order' button
		
		@FindBy(xpath="//button[@id='submit']")
		WebElement btn_Confirmorder;
		
		public void clickConfirmOrder()
		{
			btn_Confirmorder.click();
		}
		
}

