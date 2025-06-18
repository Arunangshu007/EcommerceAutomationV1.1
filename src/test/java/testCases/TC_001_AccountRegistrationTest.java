package testCases;
/*
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'New User Signup!' is visible
6. Enter name and email address
7. Click 'Signup' button
8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
9. Fill details: Title, Name, Email, Password, Date of birth
10. Select checkbox 'Sign up for our newsletter!'
11. Select checkbox 'Receive special offers from our partners!'
12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
13. Click 'Create Account button'
14. Verify that 'ACCOUNT CREATED!' is visible
15. Click 'Continue' button
16. Verify that 'Logged in as username' is visible
17. Click 'Delete Account' button
18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
Test Case 2: Login User with correct email and password
Test Case 3: Login User with incorrect email and password
Test Case 4: Logout User
1. Launch browser
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

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;


public class TC_001_AccountRegistrationTest extends BaseClass{

	@Test(groups={"Regression", "Master"})
	public void verify_account_registration()
	{
		logger.info("***** Starting TC001_AccountRegistrationTest *****");
		HomePage hp=new HomePage(driver);
		hp.clickSignupLogin();
		logger.info("***** Clicked on Singup/Login Link *****");
		logger.info("***** Clicked on Registration Link *****");
		AccountRegistrationPage regPage= new AccountRegistrationPage(driver);
		logger.info("***** Validating expected message *****");
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
		
		logger.info("***** Providing customer details *****");
		String username=(randomString().toUpperCase());
		regPage.setUsername(username);
		regPage.setEmail(randomString()+"@gmail.com");
		regPage.clickSignup();
		
		logger.info("***** Validating expected message *****");
		String message2=regPage.getsaccinfoConfirmationMsg();
		if(message2.equals("ENTER ACCOUNT INFORMATION"))
				{
			      Assert.assertTrue(true);
				}
		else
		{
			logger.error("Test failed...");
			logger.debug("Debug log....");
			Assert.assertTrue(false);
		}
		
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
		
		logger.info("***** Validating expected message *****");
		String accreationMessage=regPage.getsaccreationConfirmationMsg();
		if(accreationMessage.equals("ACCOUNT CREATED!"))
		{
	      Assert.assertTrue(true);
		}
         
		else
		{
			logger.error("Test failed...");
			logger.debug("Debug log....");
			Assert.assertTrue(false);
		}
		
		logger.info("***** Clicking on continue link *****");
		regPage.clickContinue();
		
	    /*
		logger.info("***** Validating expected message *****");
		String userconfirmationMessage=regPage.getusernameConfirmationMsg();	
		Assert.assertTrue(userconfirmationMessage.contains("Logged in as"), "Username is not matched");
		/*
		if(userconfirmationMessage.contains("Logged in as"))
		{
			Assert.assertTrue(true);
		}		
		else
		{
			logger.error("Test failed...");
			logger.debug("Debug log....");
			Assert.assertTrue(false);
		}
		*/
		
		
		logger.info("***** Clicking on continue link *****");
		regPage.clickDeleteAccount();
		
		logger.info("***** Validating expected message *****");
		String acdeletedMessage=regPage.getACdeletedConfirmationMsg();
		
		if(acdeletedMessage.equals("ACCOUNT DELETED!"))
		{
			Assert.assertTrue(true);
		}
         
		else 
		{
			logger.error("Test failed...");
			logger.debug("Debug log....");
			Assert.assertTrue(false);
		}
		logger.info("***** Clicking on delete account link *****");
		regPage.clickContinue1();
		
		
		
	}
}
