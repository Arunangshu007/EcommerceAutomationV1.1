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
import pageObjects.ProductDetailsPage;
import testBase.BaseClass;

/*
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Products' button
5. Verify user is navigated to ALL PRODUCTS page successfully
6. Enter product name in search input and click search button
7. Verify 'SEARCHED PRODUCTS' is visible
8. Verify all the products related to search are visible
*/

public class TC_009_VerificationofProductSearch extends BaseClass{
	
	@Test(groups={"Regression", "Master"})
	public void verify_productDetails()
	{
		logger.info("***** Starting TC_009_VerificationofProductSearch *****");
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
		
		//6. Enter product name in search input and click search button
		logger.info("***** Product name is searched *****");		
		pdpage.setSearchBox("Jeans");
		pdpage.clickonSearch();
		
		//7. Verify 'SEARCHED PRODUCTS' is visible
		logger.info("***** Verification of Search Product message is displayed *****");
		String ActSearchMessage =pdpage.getProductSearchMessage();
		Assert.assertEquals(ActSearchMessage, "SEARCHED PRODUCTS");
		
		//8. Verify all the products related to search are visible
		logger.info("***** Verification of all product searched is displayed *****");
		List<WebElement> allproducts=pdpage.getSearchResultProducts();
		
		for(WebElement products:allproducts)
		{	
			Assert.assertTrue(products.isDisplayed(), "Products not visible"+ products.getText());
		}
		
		
		
	}

	
	
	
}