package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/*
 * This is landing page to start search item
 */
public class LandingPage 
{	
	 WebDriver driver;
	 
	 //Constructor that will be automatically called as soon as the object of the class is created
	 public LandingPage(WebDriver driver) 
	 {
		 this.driver=driver;
	 }
	 
	 //Locator for search textbox
	 By searchTxtbox = By.id("twotabsearchtextbox");
	 
	 //Locator for search submit button
	 By searchSubmitBtn = By.id("nav-search-submit-button");
	 
	 //Method to enter search criteria
	 public void EnterSearchItem(String searchString) 
	 {
		 driver.findElement(searchTxtbox).sendKeys(searchString);
	 }
	 
	 //Method to enter search criteria
	 public void ClickSearchButton() 
	 {
		 driver.findElement(searchSubmitBtn).click();
	 }
	 
}
