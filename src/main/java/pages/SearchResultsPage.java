package pages;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
 * This is search results page
 */
public class SearchResultsPage 
{	
	 WebDriver driver;
	 
	 //Constructor that will be automatically called as soon as the object of the class is created
	 public SearchResultsPage(WebDriver driver) 
	 {
		 this.driver=driver;
	 }
	 	 
	 //Method to get first search item price
	 public String getFirstElementItemPrice() 
	 { 
		String firstItemprice="";
		try
		{
			List<WebElement> result= driver.findElements(By.xpath("//div[@data-component-type='s-search-result']//descendant::a[contains(text(),'Paperback')]//parent::div//following-sibling::div//descendant::span[\"@class='a-price'\"][2]"));
			firstItemprice = result.get(1).getText();
			firstItemprice=firstItemprice.replace("\n",".");
		}
		catch(Exception e)
		{
			System.out.println("Problem araised while getting the first item price"); 
		}
		return firstItemprice;
	 }
	 
	 //Click the first item on the search results page
	 public void ClickFirstItem()
	 {
		 try
		 {
			List<WebElement> HyperLinks = driver.findElements(By.xpath("//div[@data-component-type='s-search-result']//descendant::h2/a"));
			HyperLinks.get(0).click();
		 }
		 catch(Exception e)
		 {
			System.out.println("Problem araised while clicking the first item"); 
		 }
	 }
}
