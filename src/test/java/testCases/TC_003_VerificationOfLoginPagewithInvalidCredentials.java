package testCases;
/*
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'Login to your account' is visible
6. Enter incorrect email address and password
7. Click 'login' button
8. Verify error 'Your email or password is incorrect!' is visible
 */
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.LogoutPage;
import testBase.BaseClass;

public class TC_003_VerificationOfLoginPagewithInvalidCredentials extends BaseClass {
	
	@Test(groups={"Regression", "Master"})
	public void Verify_login_page() 
	{
		logger.info("***** Starting TC003_VerificationOfLoginPagewithInvalidCredentials *****");
		
		HomePage hp=new HomePage(driver);
		//4. Click on 'Signup / Login' button
		hp.clickSignupLogin();
		
		logger.info("***** Clicked on Signup/Login Link *****");
		logger.info("***** Clicked on Registration Link *****");
		
		LoginPage logPage=new LoginPage(driver);
		
		//5. Verify 'Login to your account' is visible
		String message=logPage.getLogintoaccountConfMsg();
		logger.info("***** Validating expected message *****");
		logPage.getLogintoaccountConfMsg();
		if(message.equals("Login to your account"))
		{
	      Assert.assertTrue(true);
		}	
		else
            {
	         logger.error("Test failed...");
	         logger.debug("Debug log....");
	         Assert.assertTrue(false);
            }
		
		//6. Enter incorrect email address and password
		logger.info("***** Providing incorrect login details *****");
		logPage.setInvalidLoginEmail(p.getProperty("Invalidemail"));
		logPage.setInvalidLoginPassword(p.getProperty("Invalidpassword"));
		
		//7. Click 'login' button
		logPage.clickLoginButton();
		logger.info("clicked on login button..");
		
		//8.Verify error 'Your email or password is incorrect!' is visible
		String Message1=logPage.getInvalidLoginMessage();
		
		if(Message1.contains("Your email or password is incorrect!"))
		{
			Assert.assertTrue(true);
		}
		
		else
        {
         logger.error("Test failed...");
         logger.debug("Debug log....");
         Assert.assertTrue(false);
        }		
	}

}
