package com.elal.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.data.Passenger;
import com.pages.HomePage;
import com.pages.ReservesionPage;

public class SearchingByDefferentDestinations extends TestBase {
	
	
	 @DataProvider
	  public Object[][] dp() {
	    return new Object[][] {
	      new Object[] { "Tel", "New York" },
	      new Object[] { "New", "Tel" },
	      new Object[] { "Tel", "Berlin" },
	    };
	  }
	
	@Test(description="The goal of the test is to check tickets when Origin and Destanation are not matched and type of trip is **Round**"
			+ "Expected resul:Should be shown Outbound and Inbound according with entered directions",enabled=true,priority=1,dataProvider = "dp")
	public void originAndDestinationAreNotMatched(String origin, String destination){
		
		

		Passenger passenger = new Passenger("Slava", "Starusev", origin, destination, FromDate, ToDate, 1,
				"adult");
		ReservesionPage reservesionPage;
		startBrowser("Chrome", URL);
		HomePage hompage = PageFactory.initElements(driver, HomePage.class);
		hompage.fillSearchingForm(passenger);
		reservesionPage = hompage.selectTypeOfPassenger(passenger, "add");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		hompage.submit();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//assertEquals(reservesionPage.getNumOfPass(), Global.adultsAmount);
		assertTrue((reservesionPage.getOutboundDirection()));
		//assertEquals(reservesionPage.getIntboundDirection(), destination);
		// driver.navigate().back();
		tearDown();
	}

}
