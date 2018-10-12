package com.elal.test;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.data.Adults;
import com.data.Global;
import com.pages.HomePage;
import com.pages.ReservesionPage;

public class TestSearchingTickets extends TestBase {

	
	@Test(description="Precondition:Passengers amount is 1**The goal of the test is to check adding one adult to ticket:Expected results Passengers amount is updated to 2",priority=1)
	public void testAddOneAdult()

	{
		Adults adult = new Adults("Slava", "Starusev", "Tel", "Moscow", "12/10/2018", "16/10/2018", 1);
		ReservesionPage reservesionPage;
		startBrowser("Chrome", URL);
		HomePage hompage = PageFactory.initElements(driver, HomePage.class);
		reservesionPage = hompage.fillSearchingForm(adult);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		assertEquals(reservesionPage.getNumOfPass(), Global.adultsAmount);

		//tearDown();
	}
	
	@Test(description=" Precondition:Passengers amount is 2**The goal of the test is to check adding 8 adults to ticket:Expected results Passengers amount is updated to 9 (Max amount!!)",priority=2)
	public void testAdd8Adults()

	{
		Adults adult = new Adults("Slava", "Starusev", "Tel", "Moscow", "12/10/2018", "16/10/2018", 8);
		ReservesionPage reservesionPage;
		startBrowser("Chrome", URL);
		HomePage hompage = PageFactory.initElements(driver, HomePage.class);
		reservesionPage = hompage.fillSearchingForm(adult);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		assertEquals(reservesionPage.getNumOfPass(), Global.adultsAmount);

		tearDown();
	}

}
