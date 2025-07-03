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
4. Click 'Cart' button
5. Scroll down to footer
6. Verify text 'SUBSCRIPTION'
7. Enter email address in input and click arrow button
*/

public class TC_011_VerificationofSubscriptionInCartPage extends BaseClass{
	
	@Test(groups={"Regression", "Master"})
	public void verify_SubscriptioninCartPage() throws InterruptedException
	{
		logger.info("***** Starting TC_011_VerificationofSubscriptionInCartPage *****");
		HomePage hp=new HomePage(driver);
		
		//3. Verify that home page is visible successfully
		logger.info("***** Getting the logo of Homepage *****");
		hp.getLogoOfPage();
		
		//4. Click 'Cart' button
		logger.info("***** Clicking on Cart Button of Homepage *****");
		hp.click_CartLinkButton();
		
		//5. Scroll down to footer
		logger.info("***** Scrolling down to footer of Cart *****");
		hp.scrolltoFooterCartPage();
		
		//6. Verify text 'SUBSCRIPTION'	
		logger.info("***** Verification if Subscription text is populating for Cart *****");
		String ActSubsMsg=hp.getSubscriptionMessageInCart();
		Assert.assertEquals(ActSubsMsg, "SUBSCRIPTION");
		
		//6. Enter email address in input and click arrow button
		logger.info("***** Provided email address in input box *****");	
		hp.setCartEmailAddress(p.getProperty("email"));
		hp.clickCartButton();
		
	
		
	}

	
	
	
}