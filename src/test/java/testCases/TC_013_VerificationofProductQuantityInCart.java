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
4. Click 'View Product' for any product on home page
5. Verify product detail is opened
6. Increase quantity to 4
7. Click 'Add to cart' button
8. Click 'View Cart' button
9. Verify that product is displayed in cart page with exact quantity
*/

public class TC_013_VerificationofProductQuantityInCart extends BaseClass{
	
	@Test(groups={"Regression", "Master"})
	public void verify_ProductQuantityCart()
	{
		logger.info("***** Starting TC_013_VerificationofProductQuantityInCart *****");
		HomePage hp=new HomePage(driver);
		
		//3. Verify that home page is visible successfully
		logger.info("***** Getting the logo of Homepage *****");
		hp.getLogoOfPage();
		
		//4. Click 'View Product' for any product on home page
		logger.info("***** Clicking on view product of any product *****");
		hp.click_ViewProduct();
		
		//5. Verify product detail is opened
		logger.info("***** Verifying  Product details is opened*****");	
		ProductDetailsPage pdpage=new ProductDetailsPage(driver);
		String ActualProductDetails=pdpage.getProductDetailsOpened();
		Assert.assertEquals(ActualProductDetails, "WRITE YOUR REVIEW");
		
		//6. Increase quantity to 4
		logger.info("***** Increasing quantity to 4*****");
		pdpage.setNoOfQuantity();
		
		//7. Click 'Add to cart' button
		
		logger.info("***** Clicking on Add to Cart Button****");
		pdpage.click_ProductAddinCart();
		
		//8. Click 'View Cart' button
		
		logger.info("***** Clicking on View Cart Button****");
		pdpage.click_ViewCart();
		
		//9. Verify that product is displayed in cart page with exact quantity
		
		logger.info("***** product is displayed in cart page with exact quantity****");	
		ProductCartPage pcpage=new ProductCartPage(driver);
		String ActualQuantity=pcpage.getNumberofQuantity();		
		Assert.assertEquals(ActualQuantity, "4");
		
		
		
		
	}

	
	
	
}