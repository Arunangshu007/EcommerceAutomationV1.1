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
3. Verify that home page is visible successfully
4. Click 'Products' button
5. Hover over first product and click 'Add to cart'
6. Click 'Continue Shopping' button
7. Hover over second product and click 'Add to cart'
8. Click 'View Cart' button
9. Verify both products are added to Cart
10. Verify their prices, quantity and total price
*/

public class TC_012_VerificationofAddingProductInCart extends BaseClass{
	
	@Test(groups={"Regression", "Master"})
	public void verify_AddingProductCart()
	{
		logger.info("***** Starting TC_012_VerificationofAddingProductInCart *****");
		HomePage hp=new HomePage(driver);
		
		//3. Verify that home page is visible successfully
		logger.info("***** Getting the logo of Homepage *****");
		hp.getLogoOfPage();
		
		//4. Click 'Products' button
		logger.info("***** Clicking on the Product Button *****");
		hp.clickonProductLink();
		
		
		//5. Hover over first product and click 'Add to cart'
		ProductDetailsPage pdPage=new ProductDetailsPage(driver);
		logger.info("***** Scrolling to the First Product and Clicking on Add to cart *****");
		pdPage.scrollToFirstProduct();
		pdPage.clickAddToCart();
		
		
		//6. Click 'Continue Shopping' button
		logger.info("***** Clicking on Continue shopping button *****");
		pdPage.clickContinueShopping();
		
		/*
		//7. Hover over second product and click 'Add to cart'
		logger.info("***** Scrolling to the Second Product and Clicking on Add to cart *****"); 
		pdPage.clickAddToCart2();
		
		//8. Click 'View Cart' button
		
		logger.info("***** Clicking on View Cart *****"); 		
		pdPage.clickViewCart();
		
		//9. Verify both products are added to Cart
		ProductCartPage pdcart=new ProductCartPage(driver);
			
		Assert.assertTrue(pdcart.isFirstProductAddedToCart(), "First Product is not displayed");
		Assert.assertTrue(pdcart.isSecondProductAddedToCart(), "Second Product is not displayed");
		
		//10. Verify their prices, quantity and total price
		
		Assert.assertTrue(pdcart.isFirstProductPriceDisplayed(), "First Product price is not displayed");
		Assert.assertTrue(pdcart.isFirstProductQuantityDisplayed(), "First Product Quantity is not displayed");
		Assert.assertTrue(pdcart.isFirstProductTotalPriceDisplayed(), "First Product Total Price is not displayed");
		
		*/
	
		
	}

	
	
	
}