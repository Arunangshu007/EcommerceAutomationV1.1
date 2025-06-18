package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

/*
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'New User Signup!' is visible
6. Enter name and already registered email address
7. Click 'Signup' button
8. Verify error 'Email Address already exist!' is visible
 */

public class  TC_005_VerificationofRegistrationwithExistingEmail extends BaseClass{
	
	@Test(groups={"Regression", "Master"})
	public void verify_registrationwith_ExistingEmail()
	{
		logger.info("***** Starting TC_005_VerificationofRegistrationwithExistingEmailTest *****");
		
		HomePage hp=new HomePage(driver);
		//3. Verify that home page is visible successfully
		hp.getLogoOfPage();
		//4. Click on 'Signup / Login' button
		hp.clickSignupLogin();
		//5. Verify 'New User Signup!' is visible
		AccountRegistrationPage regPage=new AccountRegistrationPage(driver);
		String message=regPage.getnewuserSignupConfirmationMsg();
		if(message.equals("New User Signup!"))
		{
	      Assert.assertTrue(true);
		}
        else
        {
	     logger.error("Test failed...");
	     logger.debug("Debug log....");
	     Assert.assertTrue(false);
        }
	
	    //6. Enter name and already registered email address
		String username=randomString().toUpperCase();
		regPage.setUsername(username);		
		regPage.setEmail(p.getProperty("email"));
		logger.info("***** Existing Email *****");
		
		//7. Click 'Signup' button
		regPage.clickSignup();
		
		//8. Verify error 'Email Address already exist!' is visible	
		LoginPage lp=new LoginPage(driver);
		String ErrorMessage=lp.getExistingMemberErrorMessage();
		Assert.assertEquals(ErrorMessage, "Email Address already exist!");

		
	}
}