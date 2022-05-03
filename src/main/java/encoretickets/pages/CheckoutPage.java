package encoretickets.pages;

import org.openqa.selenium.WebElement;

import java.awt.Window;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
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
	
	@FindBy(xpath="//div[@class='gui-layout hidden normal visible']")
	WebElement visiblearea;
	@FindBy(xpath="//div[div[text()='GRAND CIRCLE'] and span[text()='A'] and span[text()='2']]")
	WebElement seat;
	
	@FindBy(xpath="//button/span[text()='Add to Basket']")
	WebElement addtobasket;
	
	@FindBy(xpath="//span[@class='seat-info__link-text' and text()='Booking has restricted view']")
	WebElement seatinfo_restrictedaccess;
	@FindBy(xpath="//span[@class='//span[@class='seat-info__link-text' and text()='Important seat info']")
	WebElement bookinginfo;
	
	
	
	
	
	
public CheckoutPage() {
	PageFactory.initElements(driver, this);
}
public void seatselection() throws Throwable {
driver.switchTo().frame(0);
Dimension canvasdimension =canvas.getSize();
int canvas_center_x = canvasdimension.getWidth()/2;
int canvas_center_y = canvasdimension.getHeight()/2;
//int button_X= (canvas_center_x/6)*1;
//int button_Y= (canvas_center_y/3)*2;

//int button_X= (canvas_center_x/6)*1;
//int button_Y= (canvas_center_y/3)*2;
int button_X= (canvas_center_x/8)*1;
int button_Y= (canvas_center_y/16)*15;
Actions actions = new Actions(driver);
//actions.moveToElement(canvas, button_X, button_Y).click().perform();
actions.moveToElement(canvas, button_X, button_Y).click().build().perform();


Dimension visibleareadimension =visiblearea.getSize();
System.out.println("visible area size :"+visibleareadimension);
//int visiblearea_center_x = visibleareadimension.getWidth()/2;
//int visiblearea_center_y = visibleareadimension.getHeight()/2;


//int visible_button_X= (visiblearea_center_x/8)*3;
//int visible_button_Y= (visiblearea_center_y/8)*6;
//int visible_button_X= (visiblearea_center_x/16)*1;
//int visible_button_Y= (visiblearea_center_y/16)*1;
//for(int i=0;i>-16; i--) {
//	for(int j=1;j<16;j++) {
		int visible_button_X= (canvas_center_x/8)*-3;
		int visible_button_Y= (canvas_center_y/8)*5;
//		int button_X= (canvas_center_x/6)*1;
//		int button_Y= (canvas_center_y/3)*2;
		
		
		Actions actions1 = new Actions(driver);
		//actions1.moveToElement(canvas, visible_button_X, visible_button_Y).click().build().perform();
		
	
		actions1.moveToElement(canvas, visible_button_X, visible_button_Y).click().build().perform();
		Thread.sleep(5000);
		System.out.println("canvas dimension:"+canvasdimension);
		System.out.println("visible area width:"+visible_button_X);
		System.out.println("visible area Height:"+visible_button_Y);
//		driver.switchTo().defaultContent();
		String parentwindow = driver.getWindowHandle();
//		List<String> allwindows = new ArrayList<>(driver.getWindowHandles());
//		driver.switchTo().window(allwindows.get(1));
		driver.switchTo().window(parentwindow);
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", addtobasket);
		
//		addtobasket.click();
		Thread.sleep(10000);
//		if (seat.isDisplayed()) {
//			actions1.moveToElement(visiblearea, visible_button_X, visible_button_Y).click().build().perform();
//		}
//	}}
	
		seatinfo_restrictedaccess.isDisplayed();
		bookinginfo.isDisplayed();

//for(int i=visiblearea_center_x;i<visibleareadimension.getWidth(); i=1+10)
//{
//	for (int j=visiblearea_center_y;j<visibleareadimension.getHeight();j=j+50) {
//	Actions actions1 = new Actions(driver);
//	actions1.moveToElement(visiblearea, i, j).perform();
//	System.out.println("visible_button_X  :"+i);
//	System.out.println("visible_button_Y  :"+j);
//	if (seat.isDisplayed()) {
//		actions1.moveToElement(visiblearea, i, j).click().build().perform();
//	}
	
//}}



//Actions actions1 = new Actions(driver);
////actions.moveToElement(canvas, button_X, button_Y).click().perform();
//actions1.moveToElement(visiblearea, visible_button_X, visible_button_Y).click().build().perform();


}







}


