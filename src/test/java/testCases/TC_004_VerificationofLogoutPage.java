package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.LogoutPage;
import testBase.BaseClass;

/*
 *1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'Login to your account' is visible
6. Enter correct email address and password
7. Click 'login' button
8. Verify that 'Logged in as username' is visible
9. Click 'Logout' button
10. Verify that user is navigated to login page
 */
public class TC_004_VerificationofLogoutPage extends BaseClass{
	
	@Test(groups= {"Regression"})
	public void verify_logout_page()
	{
		logger.info("***** Starting TC004_AccountRegistrationTest *****");
		HomePage hp=new HomePage(driver);
		//4. Click on 'Signup / Login' button
		hp.clickSignupLogin();	
		logger.info("***** Clicked on Signup/Login Link *****");
		logger.info("***** Clicked on Registration Link *****");
		
		LoginPage lp=new LoginPage(driver);
		//5. Verify 'Login to your account' is visible
		String Message=lp.getLogintoaccountConfMsg();
		if(Message.equals("Login to your account"))
				{ 
			      Assert.assertTrue(true);	
				}
		else
        {
         logger.error("Test failed...");
         logger.debug("Debug log....");
         Assert.assertTrue(false);
        }
		
		//6. Enter correct email address and password
		lp.setLoginEmail(p.getProperty("email"));
		lp.setLoginPassword(p.getProperty("password"));
		
		//7. Click 'login' button
		lp.clickLoginButton();
		
		//8. Verify that 'Logged in as username' is visible
		String Message1=lp.getUsernameCnfMsg();
		
		if(Message1.contains("Arunangshu Banerjee"))
		{
			Assert.assertTrue(true);
		}
		
		else
		{
			logger.error("Test failed..");
			logger.debug("Debug log...");
			Assert.assertFalse(false);
		}
		
		//9. Click 'Logout' button
		LogoutPage logout=new LogoutPage(driver);
		logout.clickLogout();
		
		//10. Verify that user is navigated to login page(will verify with title)
		String ActTitle=driver.getTitle();
		Assert.assertEquals(ActTitle, "Automation Exercise - Signup / Login");
				
	}

}
