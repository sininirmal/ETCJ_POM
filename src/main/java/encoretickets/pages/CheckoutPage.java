package encoretickets.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import encoretickets.base.Base;

public class CheckoutPage extends Base {
	@FindBy(xpath="//iframe")
	WebElement seatplan;
	
	@FindBy(xpath="//canvas")
	WebElement canvas;
	
public CheckoutPage() {
	PageFactory.initElements(driver, this);
}
public void seatselection() throws Throwable {
driver.switchTo().frame(0);
Dimension canvasdimension =canvas.getSize();
int canvas_center_x = canvasdimension.getWidth()/2;
int canvas_center_y = canvasdimension.getHeight()/2;
int button_X= (canvas_center_x/3)*2;
int button_Y= (canvas_center_y/3)*2;
Actions actions = new Actions(driver);
actions.moveToElement(canvas, button_X, button_Y).click().perform();

Thread.sleep(20000);
}







}


