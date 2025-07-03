package pageObjects;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends BasePage {

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//5. Verify user is navigated to ALL PRODUCTS page successfully
	
	@FindBy(xpath="//img[@id='sale_image']")
	WebElement logoDisplay;
	
	public boolean isLogoDisplayed()
	{
		return logoDisplay.isDisplayed();
	}

	//6. The products list is visible
	@FindBy(xpath="//div[@class='features_items']")
	WebElement listAllProducts;
	
	public boolean islistOfAllProductVisible()
	{
		return listAllProducts.isDisplayed();
		
	}
	
	//7. Click on 'View Product' of first product
	
	@FindBy(xpath="//a[@href='/product_details/1']")
	WebElement link_ViewProduct;
	
	public void clickOnViewProduct()
	{
			
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", link_ViewProduct);
	}
	
	//8. Verify  User is landed to product detail page
	
	@FindBy(xpath="//a[text()='Write Your Review']")
	WebElement txt_productdetailMsg;
	
	public String getProductDetailMessage()
	{
		try
		{
		return txt_productdetailMsg.getText();
		}
		
		catch(Exception e)
		{
			return e.getMessage();
		}
		
	}
	
	//9. Verify that detail detail is visible: product name, category, price, availability, condition, brand
	
	@FindBy(xpath="//h2[text()='Blue Top']")
	WebElement Productname;
	
	@FindBy(xpath="//p[contains(text(),'Category')]")
    WebElement category;
	
	@FindBy(xpath="//span[text()='Rs. 500']")
	WebElement price;
	
	@FindBy(xpath="//b[text()='Availability:']")
	WebElement availability;
	
	@FindBy(xpath="//b[text()='Condition:']")
	WebElement condition;

	@FindBy(xpath="//b[text()='Brand:']")
	WebElement brand;
	
	public boolean isProductNameVisible()
	{
		return Productname.isDisplayed();
		
	}
	public boolean isCategoryVisible() {
	    return category.isDisplayed();
	}
	public boolean isPriceVisible() {
	    return price.isDisplayed();
	}
	public boolean isAvailabilityVisible() {
	    return availability.isDisplayed();
	}
	public boolean isConditionVisible() {
	    return condition.isDisplayed();
	}
	public boolean isBrandVisible() {
	    return brand.isDisplayed();
	}
	
	//6. Enter product name in search input and click search button
	@FindBy(xpath="//input[@id='search_product']")
	WebElement searchbox;
	
	public void setSearchBox(String name)
	{
		searchbox.sendKeys(name);
	}
	
	@FindBy(xpath="//button[@id='submit_search']")
	WebElement btn_search;
	
	public void clickonSearch()
	{
		btn_search.click();
	}
	
	//7. Verify 'SEARCHED PRODUCTS' is visible
	@FindBy(xpath="//h2[@class='title text-center']")
	WebElement txt_searchedProduct;
	
	public String getProductSearchMessage()
	{
		try
		{
		return txt_searchedProduct.getText();
		}
		catch(Exception e)
		{
			return e.getMessage();
		}
		
	}
	//8. Verify all the products related to search are visible
	
	@FindBy(xpath="//div[@class='features_items']")
	List<WebElement> allsearchproducts;
	
	   public List<WebElement> getSearchResultProducts() {
	        return allsearchproducts;
	    }
	   
	 //5. Hover over first product and click 'Add to cart'
		
		@FindBy(xpath="(//p[text()='Blue Top'])[1]")
		
		WebElement first_product;
		
		@FindBy(xpath="(//a[@class='btn btn-default add-to-cart'])[1]")
		WebElement Add_to_cart;
		
		public void scrollToFirstProduct()
		{	
			Actions actions = new Actions(driver);
			actions.moveToElement(first_product).perform();
		}
		
		public void clickAddToCart()
		{
			JavascriptExecutor js=(JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true)", Add_to_cart);
		}
		
		@FindBy(xpath="//button[@data-dismiss='modal']")
		WebElement shop;
		
		//6. Click 'Continue Shopping' button
		public void clickContinueShopping()
		{
			shop.click();
		}
		
		//7. Hover over second product and click 'Add to cart'
		
		@FindBy(xpath="(//a[@data-product-id='2'])[1]")
		WebElement Add_to_cart2;
		
		public void clickAddToCart2()
		{
			Add_to_cart2.click();
		}
		
		//8. Click 'View Cart' button
		
				@FindBy(xpath="//u[text()='View Cart']")
				WebElement view_cart;
				
				public void clickViewCart()
				{
					view_cart.click();
				}
				
				//5. Verify product detail is opened
				
				@FindBy(xpath="//a[text()='Write Your Review']")
				WebElement txt_productdetails;
				
				public  String getProductDetailsOpened()
				{
					try 
					{
					return txt_productdetails.getText();
					}
					
					catch(Exception e)
					{
						return e.getMessage();
					}
				}
				
				//6. Increase quantity to 4
				
				@FindBy(xpath="//input[@id='quantity']")
				WebElement btn_Quantity;
				
				public void setNoOfQuantity()
				{
					btn_Quantity.clear();
					btn_Quantity.sendKeys("4");
				}
				
				//7. Click 'Add to cart' button
				
				@FindBy(xpath="//button[@class='btn btn-default cart']")
				WebElement btn_Addtocart;
				
				public void click_ProductAddinCart()
				{
					btn_Addtocart.click();
				}
				
				//8. Click 'View Cart' button
				
				@FindBy(xpath="//u[text()='View Cart']")
				WebElement btn_viewcart;
				
				public void click_ViewCart()
				{
					btn_viewcart.click();
				}
				
				
}
