package com.elal.test;

import static org.testng.Assert.assertEquals;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.data.Passenger;
import com.pages.HomePage;
import com.pages.ReservesionPage;

public class SearchingByDefferentDestinations extends TestBase {
	
	@Test(description="The goal of the test is to check tickets when Origin and Destanation are not matched and type of trip is **Round**"
			+ "Expected resul:Should be shown Outbound and Inbound according with entered directions",enabled=true,priority=1)
	public void originAndDestinationAreNotMatched(){
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
		LocalDate localDate = LocalDate.now();
	
		String local=localDate.toString();
		System.out.println(dtf.format(localDate)); //2016/11/16
		
		Passenger passenger = new Passenger("Slava", "Starusev", "Tel", "Lond", local, "16/10/2018", 1,
				"adult");
		ReservesionPage reservesionPage;
		startBrowser("Chrome", URL);
		HomePage hompage = PageFactory.initElements(driver, HomePage.class);
		hompage.fillSearchingForm(passenger);
		reservesionPage = hompage.selectTypeOfPassenger(passenger, "add");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		hompage.submit();
		//assertEquals(reservesionPage.getNumOfPass(), Global.adultsAmount);
		assertEquals(reservesionPage.getOutboundDirection(), "Tel Aviv Yafo to London");
		assertEquals(reservesionPage.getIntboundDirection(), "London to Tel Aviv Yafo");
		// driver.navigate().back();
		tearDown();
	}

}
