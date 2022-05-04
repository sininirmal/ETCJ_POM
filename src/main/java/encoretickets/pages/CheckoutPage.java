package encoretickets.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import encoretickets.base.Base;

public class CheckoutPage extends Base {
	@FindBy(xpath="//iframe")
	WebElement seatplan;
	
	@FindBy(xpath="//div[@class='chart-layer']/canvas")
	WebElement canvas;
	
	@FindBy(xpath = "//*[@id=\"visibleArea\"]")
    private WebElement seatVisibleArea;
	
	
	@FindBy(xpath="//button/span[text()='Add to Basket']")
	WebElement addtobasket;
	
	@FindBy(xpath="//span[@class='seat-info__link-text' and text()='Booking has restricted view']")
	WebElement seatinfo_restrictedaccess;
	
	@FindBy(xpath="//span[@class='//span[@class='seat-info__link-text' and text()='Important seat info']")
	WebElement bookinginfo;
	
	@FindBy(xpath="//div[@class='action-message hint' and text()='Click to select']")
	WebElement tooltip;
	
	@FindBy(css =  "span.seat-info__link-text")
    private WebElement seatInfo;
	
	
	
	
public CheckoutPage() {
	PageFactory.initElements(driver, this);
}
public void seatselection(String seat1) throws Throwable {

driver.switchTo().frame(0);
Dimension canvasdimension =canvas.getSize();
int canvas_center_x = canvasdimension.getWidth()/2;
int canvas_center_y = canvasdimension.getHeight()/2;
//int button_X= (canvas_center_x/6)*1;
//int button_Y= (canvas_center_y/3)*2;

//int button_X= (canvas_center_x/6)*1;
//int button_Y= (canvas_center_y/3)*2;
int button_X= (canvas_center_x/8)*1;
int button_Y= (canvas_center_y/8)*7;
Actions actions = new Actions(driver);
//actions.moveToElement(canvas, button_X, button_Y).click().perform();
System.out.println("canvas area size :"+canvas.getSize());
actions.moveToElement(canvas, 49, 175).click().build().perform();

System.out.println("canvas x :"+button_X);
System.out.println("canvas Y :"+button_Y);

//Dimension visibleareadimension =seatVisibleArea.getSize();
//System.out.println("visible area size :"+visibleareadimension);
//int visiblearea_center_x = visibleareadimension.getWidth()/2;
//int visiblearea_center_y = visibleareadimension.getHeight()/2;
int i=-1;
int j=-1;

//int visible_button_X= (visiblearea_center_x/8)*3;
//int visible_button_Y= (visiblearea_center_y/8)*6;
//int visible_button_X= (visiblearea_center_x/16)*1;
//int visible_button_Y= (visiblearea_center_y/16)*1;
//while(i>8)
//	while(j>16) {
		int visible_button_X= (canvas_center_x/8)*i;
		int visible_button_Y= (canvas_center_y/8)*j;
//		int button_X= (canvas_center_x/6)*1;
//		int button_Y= (canvas_center_y/3)*2;
		
		
		Actions actions1 = new Actions(driver);
//		actions1.moveToElement(canvas, visible_button_X, visible_button_Y).perform();
		System.out.println("random seat frm API : "+seat1);
		String row = seat1.substring(13, 14);
		System.out.println("row to book the ticket : "+row);
//		String seatnumber = seat1.substring(14, 16);
//		System.out.println("row to book the ticket : "+seatnumber);
		
//		By seat = By.xpath("//div[div[text()='GRAND CIRCLE'] and span[text()='"+row+"'] and span[text()='"+seatnumber+"']]");
		
//		try {
//			if(driver.findElement(seat).isDisplayed()) {
				//actions1.moveToElement(seatVisibleArea,visible_button_X ,visible_button_Y ).click().build().perform();Thread.sleep(5000);
				actions1.moveToElement(seatVisibleArea).moveByOffset(visible_button_X, visible_button_Y).click().build().perform();
				System.out.println("visible area width:"+visible_button_X);
				System.out.println("visible area Height:"+visible_button_Y);
				String parentwindow = driver.getWindowHandle();
				driver.switchTo().window(parentwindow);
				Thread.sleep(1000);
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("arguments[0].click()", addtobasket);
//				seatInfo.isDisplayed();
//				break;
//				}
//			}catch(Exception e) {
//		j--;
//		}
//		i--;
//	}
		
	
		
//		driver.switchTo().defaultContent();
		
//		List<String> allwindows = new ArrayList<>(driver.getWindowHandles());
//		driver.switchTo().window(allwindows.get(1));
		
		
//		addtobasket.click();
		Thread.sleep(15000);
//		if (seat.isDisplayed()) {
//			actions1.moveToElement(visiblearea, visible_button_X, visible_button_Y).click().build().perform();
//		}
//	}}
	
		
		

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


