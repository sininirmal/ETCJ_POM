package encoretickets.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import encoretickets.base.Base;

public class CheckoutPage extends Base {
	@FindBy(xpath="//div[@class='venue__c-seat-plan']")
	WebElement seatplan;
	
public CheckoutPage() {
	PageFactory.initElements(driver, this);
}













}


