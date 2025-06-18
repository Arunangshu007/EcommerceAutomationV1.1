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
import testBase.BaseClass;

/*
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Contact Us' button
5. Verify 'GET IN TOUCH' is visible
6. Enter name, email, subject and message
7. Upload file
8. Click 'Submit' button
9. Click OK button
10. Verify success message 'Success! Your details have been submitted successfully.' is visible
11. Click 'Home' button and verify that landed to home page successfully
*/

public class TC_006_VerificationofContactUsPage extends BaseClass{
	
	@Test(groups={"Regression", "Master"})
	public void verify_contactUsPage() throws TimeoutException
	{		
		logger.info("***** Starting TC_006_VerificationofContactUsPage *****");
		HomePage hp=new HomePage(driver);
				
		//3. Verify that home page is visible successfully
		logger.info("***** Getting the logo of Homepage *****");
		hp.getLogoOfPage();
		
		//4.Click on 'Contact Us' button
		logger.info("***** Clicking on ContactUs Link *****");
		hp.clickContactUs();
		
		ContactUsPage contactus=new ContactUsPage(driver);
		
		String Actualcontactmsg=contactus.getInTouchConfirmationMsg();
		
		//5. Verify 'GET IN TOUCH' is visible
		logger.info("***** Verification of Message is displaying correctly *****");
		Assert.assertEquals(Actualcontactmsg, "GET IN TOUCH");
		
		//6. Enter name, email, subject and message
		logger.info("***** Providing user credentials*****");
		String Uname=randomString().toUpperCase();
		contactus.setName(Uname);	
		contactus.setEmail(p.getProperty("email"));
		contactus.setSubjectMsg(p.getProperty("subject"));
		contactus.setMessage(p.getProperty("message"));
		
		//7. Upload file
		logger.info("***** Uploading file*****");
		contactus.uploadFile();
		
		//8. Click 'Submit' button
		logger.info("***** Clicking on submit button*****");
		contactus.clickSubmit();
		
		//9. Click OK button
		logger.info("***** Clicking on alert OK *****");
		contactus.clickOkoption();
		
		//10. Verify success message 'Success! Your details have been submitted successfully.' is visible
		logger.info("***** Verification of Details submitted sucessfully*****");
		String ActualMessage=contactus.getSuccessConfirmationMsg();
		Assert.assertEquals(ActualMessage, "Success! Your details have been submitted successfully.");
		
		//11. Click 'Home' button and verify that landed to home page successfully
		logger.info("***** Navigating into HomePage sucessfully*****");
		contactus.clickHomePage();
		
		logger.info("***** Navigating into HomePage sucessfully*****");
		String ActualCategory=contactus.getCategoryMessage();
		System.out.println("The message is: "+ActualCategory);
		Assert.assertEquals(ActualCategory, "CATEGORY");
		
	}
	
}