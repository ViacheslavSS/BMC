package com.elal.test;

import static org.testng.Assert.assertEquals;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.data.Global;
import com.data.Passenger;
import com.pages.HomePage;
import com.pages.ReservesionPage;

public class AddingRemovingPassengers extends TestBase {
//**************	Searching and booking by different kind of passengers**********

	// **************************************************************************************************************************************************************
	@Test(description = "TC1**The goal of the test is to check adding one adult to ticket,"
			+ "By default there is one adult added once site is open"
			+ ":Expected results Passengers amount is updated to 2**", priority = 1, enabled = true)
	public void testAddOneAdult()

	{
		
		
		Passenger passenger = new Passenger("Slava", "Starusev", "Tel", "Moscow", "14/10/2018", "16/10/2018", 1,
				"adult");
		ReservesionPage reservesionPage;
		startBrowser("Chrome", URL);
		HomePage hompage = PageFactory.initElements(driver, HomePage.class);
		hompage.fillSearchingForm(passenger);
		reservesionPage = hompage.selectTypeOfPassenger(passenger, "add");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		hompage.submit();
		assertEquals(reservesionPage.getNumOfPass(), Global.adultsAmount);
		// driver.navigate().back();
		tearDown();
	}

	// **************************************************************************************************************************************************************
	@Test(description = "TC2**The goal of the test is to check adding 4 adults to ticket"
			+ ":Expected results Passengers amount is updated to 5", priority = 2, enabled = true)
	public void testAdd5Adults()

	{
		Passenger passenger = new Passenger("Slava", "Starusev", "Tel", "Moscow", "14/10/2018", "16/10/2018", 4,
				"adult");
		ReservesionPage reservesionPage;
		startBrowser("Chrome", URL);
		HomePage hompage = PageFactory.initElements(driver, HomePage.class);
		hompage.fillSearchingForm(passenger);
		reservesionPage = hompage.selectTypeOfPassenger(passenger, "add");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		hompage.submit();
		assertEquals(reservesionPage.getNumOfPass(), Global.adultsAmount);
		tearDown();
	}

	// **************************************************************************************************************************************************************
	@Test(description = "TC3**The goal of the test is to check adding 9 adults to ticket:Expected results"
			+ "**Error message shown,Max adulst is 9", priority = 3, enabled = true)
	public void testAdd9Adults()

	{

		Passenger passenger = new Passenger("Slava", "Starusev", "Tel", "Moscow", "14/10/2018", "16/10/2018", 8,
				"adult");
		ReservesionPage reservesionPage;
		startBrowser("Chrome", URL);
		HomePage hompage = PageFactory.initElements(driver, HomePage.class);
		hompage.fillSearchingForm(passenger);
		reservesionPage = hompage.selectTypeOfPassenger(passenger, "add");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		hompage.submit();
		assertEquals(reservesionPage.getNumOfPass(), Global.adultsAmount);
		tearDown();
	}

	// **************************************************************************************************************************************************************
	@Test(description = "TC4**The goal of the test is to check removing of 3 adults from a  ticket:"
			+ "Before will be add 4 adults and then remove 1"
			+ "Expected results Passengers amount is updated to 4", priority = 4, enabled = true)
	public void testRemove3Adults()

	{
		// Adults adult = new Adults("Slava", "Starusev", "Tel", "Moscow",
		// "12/10/2018", "16/10/2018", 3);
		Passenger passenger = new Passenger("Slava", "Starusev", "Tel", "Moscow", "14/10/2018", "16/10/2018", 3,
				"adult");
		ReservesionPage reservesionPage;
		startBrowser("Chrome", URL);
		HomePage hompage = PageFactory.initElements(driver, HomePage.class);
		hompage.fillSearchingForm(passenger);
		reservesionPage = hompage.selectTypeOfPassenger(passenger, "add");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		hompage.submit();
		assertEquals(reservesionPage.getNumOfPass(), Global.adultsAmount);
		tearDown();
	}

	// ***************************************************************************************************************************************************************
	@Test(description = "TC5**The goal of the test is to check remove all adults from a  ticket:Expected results**Error message shown,"
			+ "Choose Adult Tickets", priority = 5, enabled = true)
	public void testRemoveAllAdults()

	{
		Passenger passenger = new Passenger("Slava", "Starusev", "Tel", "Moscow", "14/10/2018", "16/10/2018", 1,
				"adult");
		// ReservesionPage reservesionPage;
		startBrowser("Chrome", URL);
		HomePage hompage = PageFactory.initElements(driver, HomePage.class);
		hompage.fillSearchingForm(passenger);
		hompage.selectTypeOfPassenger(passenger, "del");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// hompage.submit();
		assertEquals(hompage.getErrorMsg("noAdultsErrorMsg"), "Choose Adult Tickets");
		tearDown();
	}

	// ********************************************************************************************************************************************************************
	@Test(description = "TC6**The goal of the test is to check adding to  adults 2 children,Total amount of children "
			+ "and Adults should 7", priority = 6, enabled = true)
	public void testaddAdult_Children()

	{

		Passenger passenger = new Passenger("Slava", "Starusev", "Tel", "Moscow", "14/10/2018", "16/10/2018", 4,
				"adult");
		Passenger passenger1 = new Passenger("Slava", "Starusev", "Tel", "Moscow", "14/10/2018", "16/10/2018", 2,
				"child");
		// Passenger child = new Passenger("Slava", "Starusev", "Tel", "Moscow",
		// "12/10/2018", "16/10/2018", 4,"child");
		ReservesionPage reservesionPage;
		startBrowser("Chrome", URL);
		HomePage hompage = PageFactory.initElements(driver, HomePage.class);
		hompage.fillSearchingForm(passenger);
		reservesionPage = hompage.selectTypeOfPassenger(passenger, "add");
		reservesionPage = hompage.selectTypeOfPassenger(passenger1, "add");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		hompage.submit();
		assertEquals(reservesionPage.getNumOfPass(), Global.adultsAmount + Global.childAmount);

		tearDown();
	}

	// ********************************************************************************************************************************************************************
	@Test(description = "The goal of the test is to check apearing error message when total amount of passangers Adults and Children is greater than 9", enabled = true)
	public void testOneAdult9Children() {

		Passenger adult = new Passenger("Slava", "Starusev", "Tel", "Moscow", "14/10/2018", "16/10/2018", 1, "adult");
		Passenger child = new Passenger("Slava", "Starusev", "Tel", "Moscow", "14/10/2018", "16/10/2018", 8, "child");
		// ReservesionPage reservesionPage;
		startBrowser("Chrome", URL);
		HomePage hompage = PageFactory.initElements(driver, HomePage.class);
		hompage.fillSearchingForm(adult);
		hompage.selectTypeOfPassenger(adult, "add");
		hompage.selectTypeOfPassenger(child, "add");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		hompage.submit();
		assertEquals(hompage.getErrorMsg("maxAdultsErrorMsg"), "Max Adult Tickets Num Is 9");
		tearDown();
	}

}
