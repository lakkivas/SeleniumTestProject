package Tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;
import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

public class ItemPriceEndToEndTest 
{
	public static void main(String[] args) throws InterruptedException 
	{	
		 //Initializing the variables
		 String searchKey="qa testing for beginners";
		 String firstItempriceFromResultsPage="";
		 String firstItempriceFromItemPage="";
		 String firstItempriceFromCartPage="";
		 WebDriver driver=null;
		 try
		 {
			 String chromeDriverPath = System.getProperty("user.dir")+"\\chromedriver.exe";			 
			 //Setting chrome driver path			 
			 System.setProperty("webdriver.chrome.driver",chromeDriverPath);
			 driver = new ChromeDriver();
			 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;
			 //Opening the amazon URL
			 driver.get("http://www.amazon.com");
			 
			 //Creating object of landing page
			 LandingPage home = new LandingPage(driver);
			 //Entering the search key word
			 home.EnterSearchItem(searchKey);
			 //Click the search button 
			 home.ClickSearchButton();
			 
			 //Creating object of search results page
			 SearchResultsPage searchResultsPg = new SearchResultsPage(driver);
			 //Getting the item price from the search results page
			 firstItempriceFromResultsPage = searchResultsPg.getFirstElementItemPrice();	
			 //Clicking the first item
			 searchResultsPg.ClickFirstItem();
			 
			 //Creating object of item page to add the first item to cart
			 ItemPage itemPage = new ItemPage(driver);
			 firstItempriceFromItemPage = itemPage.getFirstElementItemPrice();
			 assertEquals(firstItempriceFromItemPage, firstItempriceFromResultsPage);
			 itemPage.ClickItemtoCart();
			 
			 //Creating object of cart page to proceed checkout
			 CartPage cartPg = new CartPage(driver);
			 firstItempriceFromCartPage = cartPg.gettheFirstItemPriceOnCartPage();
			 assertEquals(firstItempriceFromCartPage, firstItempriceFromResultsPage);
			 cartPg.ClickProceedToChecoutButton(); 
		 }
		 catch(Exception ex)
		 {
			 //Log the error
		 }
		 finally
		 {
			 //Close browser instance
			 driver.quit();
		 }
	}
}
