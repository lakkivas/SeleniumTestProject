package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
 * This is cart page
 */
public class CartPage 
{
	
	 WebDriver driver;
	 
	 //Constructor that will be automatically called as soon as the object of the class is created
	 public CartPage(WebDriver driver) 
	 {
		 this.driver=driver;
	 }
	 	 
	 //Method to get the item price
	 public String gettheFirstItemPriceOnCartPage() 
	 { 
		String itemPrice="";
		WebElement priceBeforeCheckout=null;
		try
		{
			priceBeforeCheckout = driver.findElement(By.xpath("//span[@data-maple-math='cost']"));
			itemPrice = priceBeforeCheckout.getText();	
		}
		catch(Exception ex)
		{
			//
		}	
		return itemPrice;
	 }	 
	 
	 //Click the Proceed To Checkout Button
	 public void ClickProceedToChecoutButton()
	 {
		 try
		 {
			WebElement checkoutBtn = driver.findElement(By.id("hlb-ptc-btn-native"));
			checkoutBtn.click();
		 }
		 catch(Exception ex)
		 {
			 System.out.println("Click the Proceed To Checkout Button"); 
		 }	
	 }
}
