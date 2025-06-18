package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
		
	}
	
	//5. Verify 'New User Signup!' is visible
		
			@FindBy(xpath="//h2[text()='New User Signup!']")
			WebElement newusersignup;
			
			public String getnewuserSignupConfirmationMsg()
			{
				try {
				return newusersignup.getText();
			}
				
				catch(Exception e)
				{
					return e.getMessage();
				}
			
			}
	
	//6. Enter name and email address
			@FindBy(xpath="//input[@name='name']")
			WebElement txt_username;
			
			@FindBy(xpath="//input[@name='email'][@data-qa='signup-email']")
			WebElement txt_emailadd;
	
		//7. Click 'Signup' button			
			@FindBy(xpath="//button[@class='btn btn-default'][text()='Signup']")
			WebElement click_signup;
			
		//8. Verify that 'ENTER ACCOUNT INFORMATION' is visible	
			@FindBy(xpath="//h2//b[text()='Enter Account Information']")
			WebElement accinfoConfirmation;
			
			//8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
			public String getsaccinfoConfirmationMsg()
			{
				try {
				return accinfoConfirmation.getText();
			}
				
				catch(Exception e)
				{
					return e.getMessage();
				}
			
			}
					
		//9. Fill details: Title, Name, Email, Password, Date of birth
			
			@FindBy(xpath="//input[@id='id_gender1']")
			WebElement click_rdbtn;
						 
			 @FindBy(xpath="//input[@id='password']")
			WebElement txt_password;
		    
		  
		    @FindBy(xpath="//select[@data-qa='days']")
		    WebElement txt_days;
		    
		   @FindBy(xpath="//select[@id='months']")
		   WebElement txt_months;
		   
		    @FindBy(xpath="//select[@id='years']")
		    WebElement txt_years;
		    	
		 //10. Select checkbox 'Sign up for our newsletter!'
		 @FindBy(xpath="//input[@name='newsletter']")
		 WebElement newsletterCheckbox;
		 
		// 11. Select checkbox 'Receive special offers from our partners!'		 
		 @FindBy(xpath="//input[@id='optin']")
		 WebElement specialCheckbox;
		 
		 //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
		 
		 @FindBy(xpath="//input[@id='first_name']")
		 WebElement txt_firstname;
		 
		 @FindBy(xpath="//input[@id='last_name']")
		 WebElement txt_lastname;
		 
		 @FindBy(xpath="//input[@id='company']")
		 WebElement txt_company;
		 
		 @FindBy(xpath="//input[@id='address1']")
		 WebElement txt_address1;
		 	
		@FindBy(xpath="//select[@id='country']")
		 WebElement dropdownCountry;
		 

		 @FindBy(xpath="//input[@id='state']")
		 WebElement txt_state;
	 
		 @FindBy(xpath="//input[@id='city']")
		 WebElement txt_city;
		 		 
		 @FindBy(xpath="//input[@id='zipcode']")
		 WebElement txt_zip;
			 
		 @FindBy(xpath="//input[@id='mobile_number']")
		 WebElement txt_mobile;
		
		//13. Click 'Create Account button'		 
		 @FindBy(xpath="//button[@class='btn btn-default'][@data-qa='create-account']")
		 WebElement click_createac;
		 
		//14. Verify that 'ACCOUNT CREATED!' is visible	 
		 @FindBy(xpath = "//h2//b[text()='Account Created!']")
			WebElement AC_creationConfirmation;
		 
		//14. Verify that 'ACCOUNT CREATED!' is visible
		
		public String getsaccreationConfirmationMsg()
		{
			try 
			{
			return AC_creationConfirmation.getText();
			}
			catch(Exception e)
			{
				return e.getMessage();
			}		

		}
		 
		 //15. Click 'Continue' button	 
		 @FindBy(xpath="//a[@class='btn btn-primary']")
		 WebElement click_continue;
	
	
	
	public void setUsername(String uname)
	{
		txt_username.sendKeys(uname);
	}
	
	public void setEmail(String email)
	{
		txt_emailadd.sendKeys(email);
	}
	
	public void clickSignup() 
	{
		click_signup.click();
	}
	
	public void clickradioButton()
	{
		click_rdbtn.click();
	}
	
	public void setPassword(String pwd)
	{
		txt_password.sendKeys(pwd);
	}
	
	public void selectdropdowndays(String day)
	{
		Select dropdowndays=new Select(txt_days);
		dropdowndays.selectByVisibleText(day);
	}
	
	public void selectdropdownmonths(String month)
	{
		Select dropdownmonths=new Select(txt_months);
		dropdownmonths.selectByVisibleText(month);
	}
	
	public void selectdropdownyears(String year)
	{
		Select dropdownyears=new Select(txt_years);
		dropdownyears.selectByVisibleText(year);
	}
	
	public void clicknewsletterCheckbox()
	{	   		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", newsletterCheckbox);
	}
	
	public void clickspecialCheckbox()
	{
		specialCheckbox.click();
	}
	
	public void setFirstName(String fname)
	{
		txt_firstname.sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		txt_lastname.sendKeys(lname);
	}
	public void setCompany(String companyname)
	{
		txt_company.sendKeys(companyname);
	}
	
	public void setaddress1(String address)
	{
		txt_address1.sendKeys(address);
	}
		
	public void selectdropdowncountry(String country)
	{
		 Select drpcnty=new Select(dropdownCountry);
		drpcnty.selectByVisibleText(country);
	}
	
	public void setState(String state)
	{
		txt_state.sendKeys(state);
	}
	
	public void setCity(String city)
	{
		txt_city.sendKeys(city);
	}
	
	public void setZip(String zip)
	{
		txt_zip.sendKeys(zip);
	}
	
	public void setMobile(String Mobile)
	{
		txt_mobile.sendKeys(Mobile);
	}
	
	public void clickCreateAC()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", click_createac);

	}
	
	public void clickContinue()
	{
		click_continue.click();
	}
	

	 //16. Verify that 'Logged in as username' is visible
	 
	 @FindBy(xpath = "//li//a//i[@class='fa fa-user']")
		WebElement usernameConfirmation;
	 
	 public String getusernameConfirmationMsg()
		{
			try {
			return usernameConfirmation.getText();
		}
			
			catch(Exception e)
			{
				return e.getMessage();
			}
		
		}
	 
	 //17.Click 'Delete Account' button
	 @FindBy(xpath="//a[text()=' Delete Account']")
	 WebElement click_deleteac;
	
	 public void clickDeleteAccount()
		{	
		click_deleteac.click();
		}
	 
	 //18. Verify that 'ACCOUNT DELETED!' is visible  
	 @FindBy(xpath = "//b[text()='Account Deleted!']")
		WebElement acdeletedConfirmation;
	 
	 public String getACdeletedConfirmationMsg()
		{
			try {
			return acdeletedConfirmation.getText();
		}
			
			catch(Exception e)
			{
				return e.getMessage();
			}
		
		}
	
	 //19.click 'Continue' button 
	 @FindBy(xpath="//a[normalize-space()='Continue']")
	 WebElement click_continue1;

	
	 public void clickContinue1()
		{	
		click_continue1.click();
		}
	 
	 

	
	
}