package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
		
	}
	
	//5. Verify 'Login to your account' is visible
		@FindBy(xpath="//h2[text()='Login to your account']")
		WebElement acLoginMessage;
		
		public String getLogintoaccountConfMsg()
		{
			try 
			{
			return acLoginMessage.getText();
		    }
			catch(Exception e)
			{
				return e.getMessage();
			}
			
		}
		
		//6. Enter correct email address and password
		
		@FindBy(xpath="//input[@data-qa='login-email']")
		WebElement txt_loginEmail;
		
		@FindBy(xpath="//input[@data-qa='login-password']")
		WebElement txt_loginPassword;
		
		//7. Click 'login' button
		
		@FindBy(xpath="//button[@data-qa='login-button']")
		WebElement btn_login;
		
		//8. Verify that  username' is visible
		
		@FindBy(xpath="//b[normalize-space()='Arunangshu Banerjee']")
		WebElement usernameConfMsg;
		
		public String getUsernameCnfMsg()
		{
			try 
			{
				return usernameConfMsg.getText();
			}
			catch(Exception e)
			{
				return e.getMessage();
			}
		}
		
		//Testing with valid email and Password
		public void setLoginEmail(String email)
		{
			txt_loginEmail.sendKeys(email);
		}
		
		public void setLoginPassword(String pwd)
		{
			txt_loginPassword.sendKeys(pwd);
		}
		
		//8.Verify error 'Your email or password is incorrect!' is visible
		@FindBy(xpath="//p[text()='Your email or password is incorrect!']")
		WebElement invalidLoginMsg;
		
		public String getInvalidLoginMessage()
		{
			try 
			{
			return invalidLoginMsg.getText();
			}
		
		catch(Exception e)
		{
			return e.getMessage();
		}
			
		}
		//Testing with invalid email and Password
				public void setInvalidLoginEmail(String email)
				{
					txt_loginEmail.sendKeys(email);
				}
				
				public void setInvalidLoginPassword(String pwd)
				{
					txt_loginPassword.sendKeys(pwd);
				}
		
		public void clickLoginButton()
		{
			btn_login.click();
		}
		
		
		//9. Click 'Delete Account' button
		//will call it from registration page--clickDeleteAccount()
		
		//10. Verify that 'ACCOUNT DELETED!' is visible 
		//will call it from registration page--getACdeletedConfirmationMsg()
		
		@FindBy(xpath="//p[text()='Email Address already exist!']")
		WebElement errorMessage;
		
		public String getExistingMemberErrorMessage()
		{
			try {
			return errorMessage.getText();
			}
			
			catch(Exception e)
			{
			return e.getMessage();
			}			
		}

	
}
		


