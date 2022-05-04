package encoretickets.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.PageFactory;

import encoretickets.base.Base;

public class DateSelectionPage extends Base {

	
	
	public DateSelectionPage() {
	PageFactory.initElements(driver, this);
	}


By TimeToSelect = By.xpath("//input[@type='radio']");
By PickYourSeats= By.xpath("//button[@class='o-btn o-btn__ticket o-btn--quicksearch o-btn__cta o-btn__cta--primary u-w--100% t-btn o-btn__cta--mobile t-btn-super']");
public void dateselection(String availableday,String randomtime) throws Throwable {
Thread.sleep(8000);	
By dateToSelect = By.xpath("//span[@aria-label='"+availableday+"']");
driver.findElement(dateToSelect).click();

//	List<WebElement> datelist =driver.findElements(dateToSelect);
//	WebElement dateselection;
//	List<WebElement> timeslotlist =driver.findElements(TimeToSelect);
//	WebElement timeslot;	
//	
//	Thread.sleep(5000);
//	for (int i=0; i<datelist.size();i++) {
//		
//		String s = datelist.get(i).getText();
//		
//		System.out.println("found date in UI "+ s);
//		  dateselection = datelist.get(i);
//			
//			
//			if(s ==availableday) {
//				dateselection.click();
//			}
//			else {
//				System.out.println("no selection");
//			}
//		
//	}
//	for (int j=0; j<timeslotlist.size();j++) {
//		timeslot = timeslotlist.get(j);
//			String t = timeslotlist.get(j).getText();
//			if(t ==randomtime) {
//				timeslot.click();
//			}
//			else {
//				System.out.println("no time available");
//			}
//			
//		
//	}
	By TimetoSelect = By.xpath("//span[@class='c-quick-search__timeslot-time' and text()='"+randomtime+"']");
	driver.findElement(TimetoSelect).click();
	Thread.sleep(1000);  
	WebElement PickYourSeatsbutton = driver.findElement(PickYourSeats);
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].click()", PickYourSeatsbutton);
	
	Thread.sleep(5000);  
		
		
	}
	
}
