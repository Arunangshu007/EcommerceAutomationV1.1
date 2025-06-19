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
4. Scroll down to footer
5. Verify text 'SUBSCRIPTION'
6. Enter email address in input and click arrow button
*/

public class TC_010_VerificationofSubscriptionInHomePage extends BaseClass{
	
	@Test(groups={"Master"})
	public void verify_SubscriptioninHomePage() throws InterruptedException
	{
		logger.info("***** Starting TC_009_VerificationofProductSearch *****");
		HomePage hp=new HomePage(driver);
		
		//3. Verify that home page is visible successfully
		logger.info("***** Getting the logo of Homepage *****");
		hp.getLogoOfPage();
		
		//4. Scroll down to footer
		logger.info("***** Scrolling down to footer of Homepage *****");
		hp.scrolltoFooter();
		
		//5. Verify text 'SUBSCRIPTION'	
		logger.info("***** Verification if Subscription text is populating in Homepage *****");
		String ActSubsMsg=hp.getSubscriptionMessage();
		Assert.assertEquals(ActSubsMsg, "SUBSCRIPTION");
		
		//6. Enter email address in input and click arrow button
		logger.info("***** Provided email address in input box *****");	
		hp.setEmailAdd(p.getProperty("email"));
		hp.clickbutton();
		
	
		
	}

	
	
	
}