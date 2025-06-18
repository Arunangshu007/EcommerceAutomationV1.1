package testCases;

import java.util.concurrent.TimeoutException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.ContactUsPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ProductDetailsPage;
import testBase.BaseClass;

/*
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Products' button
5. Verify user is navigated to ALL PRODUCTS page successfully
6. The products list is visible
7. Click on 'View Product' of first product
8. User is landed to product detail page
9. Verify that detail detail is visible: product name, category, price, availability, condition, brand
*/

public class TC_008_VerificationofProductDetailsPage extends BaseClass{
	
	@Test(groups={"Regression", "Master"})
	public void verify_productDetails()
	{
		logger.info("***** Starting TC_008_VerificationofProductDetailsPage *****");
		HomePage hp=new HomePage(driver);
		
		//3. Verify that home page is visible successfully
		logger.info("***** Getting the logo of Homepage *****");
		hp.getLogoOfPage();
		
		//4. Click on 'Products' button
		logger.info("***** Clicking on the Products button of Homepage *****");
		hp.clickonProductLink();
		
		//5. Verify user is navigated to ALL PRODUCTS page successfully		
		ProductDetailsPage pdpage=new ProductDetailsPage(driver);
		logger.info("***** User navigated to ALL PRODUCTS page successfully *****");
		Assert.assertTrue(pdpage.isLogoDisplayed(), "Logo is not displayed on the Product Page");
		
		//6. The products list is visible
		logger.info("***** The products list is visible *****");		
		Assert.assertTrue(pdpage.islistOfAllProductVisible(), "The List of Product is not displayed on the Product Page");
		
		//7. Click on 'View Product' of first product
		pdpage.clickOnViewProduct();
		
		//8. User is landed to product detail page
		String ActualProductMessage=pdpage.getProductDetailMessage();
		Assert.assertEquals(ActualProductMessage, "WRITE YOUR REVIEW");
		
		//9. Verify that detail detail is visible: product name, category, price, availability, condition, brand
		Assert.assertTrue(pdpage.isProductNameVisible(), "The product name is visible");
		Assert.assertTrue(pdpage.isCategoryVisible(), "The category is not visible");
		Assert.assertTrue(pdpage.isPriceVisible(), "The price is not visible");
		Assert.assertTrue(pdpage.isAvailabilityVisible(), "The availability is not visible");
		Assert.assertTrue(pdpage.isConditionVisible(), "The condition is not visible");
		Assert.assertTrue(pdpage.isBrandVisible(), "The brand is not visible");
		
	}

	
	
	
}