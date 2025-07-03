package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
		
	}
	
	//Displaying homepage
	
	@FindBy(xpath="//img[@alt='Website for automation practice']")
	
	WebElement pageLogo;
	
	public boolean getLogoOfPage()
	{
		return pageLogo.isDisplayed();
	}
		
	//4. Click on 'Signup / Login' button
	@FindBy(xpath="//a[normalize-space()='Signup / Login']")
	WebElement link_signup;
	
	public void clickSignupLogin()
	{	
	link_signup.click();
	}
	
	//4. Click on 'Contact Us' button
	
	@FindBy(xpath="//i[@class='fa fa-envelope']")
	WebElement link_ContactUs;
	
	public void clickContactUs()
	{
		link_ContactUs.click();
	}
	
	//4. Click on 'Test Cases' button
	@FindBy(xpath="//a[contains(text(),'Test Cases')]")
	WebElement link_Testcase;
	
	public void clickTestcases()
	{
		link_Testcase.click();
	}
	
	//5. Verify user is navigated to test cases page successfully
	
	@FindBy(xpath="//span[contains(text(),'Below is the list of test Cases')]")
	WebElement testCasePageCnfMessage;
	
	public String getTestCasePageConfirmationMessage()
	{
		try
		{
		return testCasePageCnfMessage.getText();
		}
		catch(Exception e)
		{
			return e.getMessage();
		}
	}
	
	//4. Click on 'Products' button
	
	@FindBy(xpath="//a[text()=' Products']")
	WebElement btn_Product;
	
	public void clickonProductLink()
	{
		btn_Product.click();
	}
	
	//4. Scroll down to footer	
	public void scrolltoFooter() throws InterruptedException
	{
	JavascriptExecutor js=(JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	
	Thread.sleep(3000);
	System.out.println(js.executeScript("return window.pageYOffset;"));
	}
	
	//5. Verify text 'SUBSCRIPTION'
	@FindBy(xpath="//h2[text()='Subscription']")
	WebElement txt_subscription;
	
	public String getSubscriptionMessage()
	{
		try
		{
			return txt_subscription.getText();
		}
		catch(Exception e)
		{
			return e.getMessage();
		}
	}
	
	//6. Enter email address in input and click arrow button
	@FindBy(xpath="//input[@id='susbscribe_email']")
	WebElement searchbox_email;
	
	@FindBy(xpath="//i[@class='fa fa-arrow-circle-o-right']")
	WebElement click_btn;
	
	public void setEmailAdd(String email)
	{
		searchbox_email.sendKeys(email);
	}
	
	public void clickbutton()
	{
		click_btn.click();
	}
	
	//4. Click 'Cart' button
	@FindBy(xpath="//a[normalize-space()='Cart']//i[@class='fa fa-shopping-cart']")
	WebElement Btn_CartLinkButton;
	
	public void click_CartLinkButton()
	{
		Btn_CartLinkButton.click();
	}
	
	//5. Scroll down to footer
	public void scrolltoFooterCartPage() throws InterruptedException
	{
	JavascriptExecutor js=(JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	
	Thread.sleep(3000);
	System.out.println(js.executeScript("return window.pageYOffset;"));
	}
	
	//6. Verify text 'SUBSCRIPTION'
	@FindBy(xpath="//h2[text()='Subscription']")
	WebElement txt_CartSubscription;
	public String getSubscriptionMessageInCart()
	{
		try
		{
			return txt_CartSubscription.getText();
		}
		catch(Exception e)
		{
			return e.getMessage();
		}
	}
	
	//7. Enter email address in input and click arrow button
	@FindBy(xpath="//input[@placeholder='Your email address']")
	WebElement searchbox_CartEmail;
	
	@FindBy(xpath="//i[@class='fa fa-arrow-circle-o-right']")
	WebElement click_Cartbtn;
	
	public void setCartEmailAddress(String email)
	{
		searchbox_CartEmail.sendKeys(email);
	}
	
	public void clickCartButton()
	{
		click_Cartbtn.click();
	}
	
	//4. Click 'View Product' for any product on home page
	@FindBy(xpath="(//i[@class='fa fa-plus-square'])[5]")
	WebElement btn_viewproduct;
	
	public void click_ViewProduct()
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;		
		js.executeScript("arguments[0].click();", btn_viewproduct);
	}
	
	//4. Add products to cart
	@FindBy(xpath="(//a[@class='btn btn-default add-to-cart'])[45]")
	WebElement link_AddProduct;
	
	public void ScrollToExpectedProduct()
	{
		//Actions actions=new Actions (driver);
		//actions.moveToElement(link_AddProduct).perform();
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", link_AddProduct);
	}
				
	public void click_AddProductInCart()
	{
		link_AddProduct.click();;
	}
	
	//5. Click 'Cart' button
	
	@FindBy(xpath="//u[text()='View Cart']")
	
	WebElement link_ViewCart;
	
	public void ClickOnCartButton()
	{
		link_ViewCart.click();
	}
	
	
	
}
