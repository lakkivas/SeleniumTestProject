package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
 * This is Item page
 */
public class ItemPage 
{
	
	 WebDriver driver;
	 
	 //Constructor that will be automatically called as soon as the object of the class is created
	 public ItemPage(WebDriver driver) 
	 {
		 this.driver=driver;
	 }
	 	 
	 //Method to get the item price
	 public String getFirstElementItemPrice() 
	 { 
		String ItemPrice="";
		WebElement priceOnCart=null;
		try
		{
			priceOnCart = driver.findElement(By.id("newBuyBoxPrice"));
		}
		catch(Exception ex)
		{
			priceOnCart = driver.findElement(By.xpath("//span[@id='price']"));
		}		
		finally
		{
			if(priceOnCart != null)
			{
				ItemPrice = priceOnCart.getText();
			}
		}
		return ItemPrice;
	 }	 
	 
	 //Click the Item to the cart
	 public void ClickItemtoCart()
	 {
		 try
		 {
			 WebElement btnAddToCart = driver.findElement(By.id("add-to-cart-button"));
			 btnAddToCart.click();
		 }
		 catch(Exception ex)
		 {
			 System.out.println("Problem araised while adding the item to cart"); 
		 }	
	 }
}
