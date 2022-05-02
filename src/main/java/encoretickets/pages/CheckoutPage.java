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
	
	@FindBy(xpath="//div[@class=\"gui-layout hidden normal visible\"]")
	WebElement visiblearea;
	
	
public CheckoutPage() {
	PageFactory.initElements(driver, this);
}
public void seatselection() throws Throwable {
driver.switchTo().frame(0);
Dimension canvasdimension =canvas.getSize();
int canvas_center_x = canvasdimension.getWidth()/2;
int canvas_center_y = canvasdimension.getHeight()/2;
int button_X= (canvas_center_x/6)*1;
int button_Y= (canvas_center_y/3)*2;
Actions actions = new Actions(driver);
//actions.moveToElement(canvas, button_X, button_Y).click().perform();
actions.moveToElement(canvas, button_X, button_Y).click().build().perform();

Thread.sleep(10000);
Dimension visibleareadimension =visiblearea.getSize();
System.out.println("visible area size :"+visibleareadimension);
int visiblearea_center_x = visibleareadimension.getWidth()/2;
int visiblearea_center_y = visibleareadimension.getHeight()/2;
int visible_button_X= (visiblearea_center_x/8)*3;
int visible_button_Y= (visiblearea_center_y/4)*3;
System.out.println("visible area width:"+visiblearea_center_x);
System.out.println("visible area Height:"+visiblearea_center_y);

System.out.println("visible_button_X  :"+visible_button_X);
System.out.println("visible_button_Y  :"+visible_button_Y);

Actions actions1 = new Actions(driver);
//actions.moveToElement(canvas, button_X, button_Y).click().perform();
actions1.moveToElement(visiblearea, visible_button_X, visible_button_Y).click().build().perform();
Thread.sleep(6000);
}







}


