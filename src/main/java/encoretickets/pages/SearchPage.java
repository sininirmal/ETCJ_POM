package encoretickets.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import encoretickets.base.Base;

public class SearchPage extends Base {
	
	@FindBy(xpath="//input[@type='search']")
	WebElement search;
	@FindBy(xpath="//span[@class='search-results-product__thumbnail t-text-super']")
	WebElement searchresults;
	@FindBy(xpath="//span[text()='Find Tickets']")
	WebElement findtickets;
	
	public SearchPage() {
		PageFactory.initElements(driver, this);
	}

	
	public void search() throws Throwable {
	
		
		search.sendKeys("TINA");
		Thread.sleep(5000);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", searchresults);
		//searchresults.click();
		Thread.sleep(5000);
		//findtickets.click();
		JavascriptExecutor js1 = (JavascriptExecutor)driver;
		js1.executeScript("arguments[0].click()", findtickets);
		
	}


	
	
	
	
	
	
	
	
}
