package testCases;

import java.util.List;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.ContactUsPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ProductCartPage;
import pageObjects.ProductDetailsPage;
import testBase.BaseClass;

/*
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Add products to cart
5. Click 'Cart' button
6. Verify that cart page is displayed
7. Click Proceed To Checkout
8. Click 'Register / Login' button
9. Fill all details in Signup and create account
10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
11. Verify ' Logged in as username' at top
12.Click 'Cart' button
13. Click 'Proceed To Checkout' button
14. Verify Address Details and Review Your Order
15. Enter description in comment text area and click 'Place Order'
16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
17. Click 'Pay and Confirm Order' button
18. Verify success message 'Your order has been placed successfully!'
19. Click 'Delete Account' button
20. Verify 'ACCOUNT DELETED!' and click 'Continue' button
*/

public class TC_014_VerificationofOrderPlacedRegisterWhileCheckout extends BaseClass{
	
	@Test(groups={"Regression", "Master"})
	public void verify_OrderPlacedWhileCheckout() throws InterruptedException
	{
		logger.info("***** Starting TC_013_VerificationofProductQuantityInCart *****");
		HomePage hp=new HomePage(driver);
		
		//3. Verify that home page is visible successfully
		logger.info("***** Getting the logo of Homepage *****");
		hp.getLogoOfPage();	
		
		//4. Add products to cart
		logger.info("***** Clicking on Product *****");	
		hp.ScrollToExpectedProduct();
		hp.click_AddProductInCart();
		
		//5. Click 'Cart' button
		logger.info("***** Clicking on the cart button *****");
		hp.ClickOnCartButton();
			
		//6. Verify that cart page is displayed
		ProductCartPage pcPage=new ProductCartPage(driver);
		
		logger.info("***** Verification of Checkout Message *****");
		String ActualCheckoutMsg=pcPage.getProceedToChekoutMessage();
		
		Assert.assertEquals(ActualCheckoutMsg, "Proceed To Checkout");
		
		//7. Click Proceed To Checkout
		logger.info("***** Clicking on Checkout Button *****");	
		pcPage.clickProceedToCheckout();
		
		//8. Click 'Register / Login' button
		logger.info("***** Clicking on Register-Login Button *****");	
		pcPage.clickRegisterLogin();
		
		//9. Fill all details in Signup and create account
		
		AccountRegistrationPage regPage=new AccountRegistrationPage(driver);
		logger.info("***** Providing customer details *****");
		String username=randomString().toUpperCase();
		regPage.setUsername(username);
		
		String useremail=(randomString()+"@gmail.com");
		regPage.setEmail(useremail);
		regPage.clickSignup();
		
		logger.info("***** Providing customer details *****");
		regPage.clickradioButton();
		String Password=randomAlphaNumeric();
		regPage.setPassword(Password);
		
		regPage.selectdropdowndays("21");
		regPage.selectdropdownmonths("June");
		regPage.selectdropdownyears("1998");
		regPage.clicknewsletterCheckbox();
		regPage.clickspecialCheckbox();
		regPage.setFirstName(randomString().toUpperCase());
		regPage.setLastName(randomString().toUpperCase());
		regPage.setCompany(randomString().toUpperCase());
		regPage.setaddress1(randomString().toUpperCase());
		regPage.selectdropdowncountry("Australia");
		regPage.setState(randomString().toUpperCase());
		regPage.setCity(randomString());
		regPage.setZip(randomNumber());
		regPage.setMobile(randomNumber());
		
		logger.info("***** Clicking on create account link *****");
		regPage.clickCreateAC();
		
		//10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
		logger.info("***** Validating expected message *****");
		String ActualaccreationMessage=regPage.getsaccreationConfirmationMsg();
		Assert.assertEquals(ActualaccreationMessage, "ACCOUNT CREATED!");
		
		logger.info("***** Clicking on continue link *****");
		regPage.clickContinue();
		
		//12.Click 'Cart' button
		logger.info("***** Clicking on cart button *****");
		hp.click_CartLinkButton();
		
		//13. Click 'Proceed To Checkout' button
		logger.info("***** Clicking on checkout button *****");
		pcPage.clickProceedToCheckout();
		
		//14. Verify Address Details and Review Your Order
		String ActualaddressMessage=pcPage.getAddressConfirmationMessage();
		
		logger.info("***** Validating expected message *****");
		Assert.assertEquals(ActualaddressMessage, "YOUR DELIVERY ADDRESS");
		
		//15. Enter description in comment text area and click 'Place Order'
		
		logger.info("***** Entering Message in textbox and click on Placeorder button *****");
		pcPage.setTextInCommentBox("I want to Order this Shirt");
		
		Thread.sleep(3000);
		
		pcPage.clickPlaceOrder();
		
		//16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
		logger.info("***** Providing customer details *****");
		pcPage.setNameOfCard("Arunangshu Banerjee");
		pcPage.setCardNumber("3333 5555 8888 4444");
		pcPage.setCardCVC("876");
		pcPage.setMonth("12");
		pcPage.setYear("2050");
		
		//17. Click 'Pay and Confirm Order' button
		pcPage.clickConfirmOrder();
	}
	
}