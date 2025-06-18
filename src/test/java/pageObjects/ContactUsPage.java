package pageObjects;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactUsPage extends BasePage{

	public ContactUsPage(WebDriver driver) {
		super(driver);
		
	}
		//5. Verify 'GET IN TOUCH' is visible
		
		@FindBy(xpath="//h2[text()='Get In Touch']")
		WebElement txt_getintouch;
		
		public String getInTouchConfirmationMsg()
		{
			try
			{
			return txt_getintouch.getText();
			}
			
			catch(Exception e)
			{
				return e.getMessage();
			}
		}
		
		//6. Enter name, email, subject and message
		
		@FindBy(xpath="//input[@name='name']")
		WebElement txt_name;
		
		@FindBy(xpath="//input[@name='email']")
		WebElement txt_email;
		
		@FindBy(xpath="//input[@name='subject']")
		WebElement txt_subject;
		
		@FindBy(xpath="//textarea[@id='message']")
		WebElement txt_message;
		
		public void setName(String name)
		{
			txt_name.sendKeys(name);
		}
		
		public void setEmail(String email)
		{
			txt_email.sendKeys(email);
		}
		
		public void setSubjectMsg(String sub)
		{
			txt_subject.sendKeys(sub);
		}
		
		public void setMessage(String msg)
		{
			txt_message.sendKeys(msg);
		}
		
		//7. Upload file
	    @FindBy(xpath="//input[@name='upload_file']")
		WebElement file_upload;
	    
	    public void uploadFile()
	    {
	    	String File="C:\\Automation Testing\\Text_File.txt";
	    	file_upload.sendKeys(File);    	
	    }
	    	    
		
		//8. Click 'Submit' button
	    
	    @FindBy(xpath="//input[@name='submit']")
	    WebElement click_btn;
	    
	    public void clickSubmit()
	    {
	    	JavascriptExecutor js=(JavascriptExecutor) driver;
	    	js.executeScript("arguments[0].click();", click_btn);
	    	
	    	//click_btn.click();
	    }
	    //9. Click OK button    
	    public void clickOkoption()
	    {
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.alertIsPresent());
	        Alert myalert=driver.switchTo().alert();
	    	myalert.accept();
	    }
	    
	    //10. Verify success message 'Success! Your details have been submitted successfully.' is visible
	    @FindBy(xpath="//div[@class='status alert alert-success']")
	    WebElement submissionMessage;
		
	    public String getSuccessConfirmationMsg()
	    {
	    	try 
	    	{
	    			return submissionMessage.getText();    		
	    	}
	    	catch(Exception e)
	    	{
	    		return e.getMessage();
	    	}
	    }
	    
	    //11. Click 'Home' button and verify that landed to home page successfully
	    
	    @FindBy(xpath="//i[@class='fa fa-home']")
	    WebElement click_homepage;
	    
	    public void clickHomePage()
	    {
	    	click_homepage.click();
	    }
	    
	    @FindBy(xpath="//h2[text()='Category']")
	    WebElement txt_category;
	    
	    public String getCategoryMessage()
	    {
	    	try 
	    	{
	    			return txt_category.getText();    		
	    	}
	    	catch(Exception e)
	    	{
	    		return e.getMessage();
	    	}
	    }

}
		
		


