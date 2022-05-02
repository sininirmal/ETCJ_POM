

package encoretickets.tests;
import java. util. Random;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import encoretickets.base.Base;
import encoretickets.pages.CheckoutPage;
import encoretickets.pages.DateSelectionPage;
import encoretickets.pages.SearchPage;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Arrays;




public class CheckOutTest extends Base{
	String fromdate = "20220522";
	String Todate = "20220522";
	String randomdate;
	String randomtime;
	String seat1;
	String seat2;
	SearchPage searchpage;
	DateSelectionPage dateselectionPage;
	CheckoutPage checkoutPage;
	String availableday;
	String newDate;
	
//	public CheckOutTest() {
//		super();
//	} 

			
	@Test(priority=1)
	public void apitest() {
		Response res=
		given().
		header("affiliateId","encoretickets").
		when().
		get("http://inventory-service.tixuk.io/api/v4/availability/products/6362/quantity/2/from/"+fromdate+"/to/"+Todate+"?test=98 ").
		then().extract().response();
		
		 JsonPath j = new JsonPath(res.asString());
		//get values of JSON array after getting array size
	      int s = j.getInt("response.size()");
	      String[] dt= new String[s];
	      for(int i = 0; i < s; i++) {
	         String datetime = j.getString("response["+i+"].datetime");
	         dt[i]=datetime;
	         
	      }
	      System.out.println(Arrays.toString(dt));
	      int rnd = new Random().nextInt(dt.length);
	      System.out.println(rnd);
	      String randomdatetime=dt[rnd];
	      System.out.println("random datetime"+randomdatetime);
	      String apirandomdate = randomdatetime.substring(0, 10).replaceAll("[^a-zA-Z0-9]","");
	      String apirandomtime = randomdatetime.substring(11, 16).replaceAll("[^a-zA-Z0-9]","");
	      availableday = randomdatetime.substring(0,10);
	      System.out.println("random date  :  "+availableday);
	      
	      
	      DateTimeFormatter f = new DateTimeFormatterBuilder().appendPattern("yyyy-MM-dd")
                  .toFormatter();
          LocalDate parsedDate = LocalDate.parse(availableday, f);
          System.out.println("parsed date  :  "+parsedDate);
          DateTimeFormatter f2 = DateTimeFormatter.ofPattern("MMM d, yyyy");

          newDate = parsedDate.format(f2);
          
	      
          System.out.println("new formated date to use in UI  :  "+newDate);
	      randomtime=randomdatetime.substring(11, 16);
	      System.out.println("time to select tickets in UI  :  "+randomtime);     
	      Response res1=
	    			given().
	    			when().
	    			get("https://inventory-service.tixuk.io/api/v4/products/6362/areas?date="+apirandomdate+"&time="+apirandomtime+"&quantity=2").
	    			then().extract().response(); 

		
	      JsonPath i = new JsonPath(res1.asString());
	      seat1 = i.getString("response.areas[0].groupings[0].seatLumps[0].seats[0]");
	      seat2 = i.getString("response.areas[0].groupings[0].seatLumps[0].seats[1]");
	      System.out.println(seat1+"\n");
	      System.out.println(seat2+"\n");

			
			
	    
	      }
	@Test(priority=2)
	public void searchText() throws Throwable{
		init();
		searchpage = new SearchPage();
		dateselectionPage = new DateSelectionPage();
		checkoutPage = new CheckoutPage();
		searchpage.search();
		dateselectionPage.dateselection(newDate,randomtime);
		Thread.sleep(20000);
		checkoutPage.seatselection();
		driver.close();
		
		
	}
	
	
	
	
	
}
