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
4. Click on 'Test Cases' button
5. Verify user is navigated to test cases page successfully
*/

public class TC_007_VerificationofTestCasesPage extends BaseClass{
	
	@Test(groups={"Regression", "Master"})
	public void verify_testCasesPage() 
	{		
		
		logger.info("***** Starting TC_007_VerificationofTestCasesPage *****");
		HomePage hp=new HomePage(driver);
				
		//3. Verify that home page is visible successfully
		logger.info("***** Getting the logo of Homepage *****");
		hp.getLogoOfPage();
		
		//4. Click on 'Test Cases' button
		logger.info("***** Clicking on the Test Cases button *****");
		hp.clickTestcases();
		
		//5. Verify user is navigated to test cases page successfully
		logger.info("***** Verification of navigation of Test Case page *****");
		String actualMessage=hp.getTestCasePageConfirmationMessage();
		
		Assert.assertEquals(actualMessage, "Below is the list of test Cases for you to practice the Automation. Click on the scenario for detailed Test Steps:");
	
	}
	
}