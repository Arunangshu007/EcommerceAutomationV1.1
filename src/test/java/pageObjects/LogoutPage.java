package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class LogoutPage extends BasePage{

	public LogoutPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//a[text()=' Logout']")
	WebElement btn_logout;
	
	public void clickLogout()
	{
		btn_logout.click();
	}

}
