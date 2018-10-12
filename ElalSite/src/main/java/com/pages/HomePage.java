package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.data.Global;
import com.data.Passenger;
import com.elal.test.TestBase;

public class HomePage extends TestBase {
	@FindBy(id = "flyFromDummy")
	WebElement flyFromDefaultField;

	@FindBy(id = "flyFrom01")
	WebElement flyFromField;
	@FindBy(id = "flyTo01")
	WebElement flyToField;
	@FindBy(id = "outdate1")
	WebElement fromDate;
	@FindBy(id = "backdate1")
	WebElement toDate;
	@FindBy(id = "ui-id-1")
	WebElement flyFrom01Autocomp;
	@FindBy(id = "ui-id-2")
	WebElement flyTo01Autocomp;
	@FindBy(css = ".btnSubmit")
	WebElement submitBtn;
	// ------------------------------------------------------
	@FindBy(id = "passengers-drop1")
	WebElement passengersDeopDown;
	@FindBy(className = "s-dropdown-qty-down")
	WebElement removeAdults;
	@FindBy(className = "s-dropdown-qty-up")
	WebElement addAdults;
	@FindBy(className = "s-dropdown-item-qty")
	WebElement adultAmount;
	@FindBy(xpath = "//div[@id='WebPartWPQ1']//div[2]/div[2]/div[8]//div[2]/div[2]/div[3]/div[2]/div")
	WebElement childrenAmount;

	@FindBy(css = "div.super-drop-close.super-drop-close-flight-search")
	WebElement chooseBtn;
	@FindBy(className = "noAdultsError")
	WebElement noAdultsErrorMsg;
	@FindBy(className = "s-dropdown-qty-down")
	WebElement remChild;
	@FindBy(xpath = "//div[@id='WebPartWPQ1']//div[2]/div[2]/div[8]//div[2]/div[2]/div[3]/div[2]/button[2]")
	WebElement addChild;

	public String getErrorMsg() {
		return noAdultsErrorMsg.getText().toString();

	}

	public void submit() {
		submitBtn.click();
	}

	// *****************************************************************************************
	public void fillSearchingForm(Passenger passenger) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		flyFromDefaultField.click();
		wait.until(ExpectedConditions.visibilityOf(flyFromField));
		flyFromField.clear();
		flyFromField.sendKeys(passenger.fromDist);
		wait.until(ExpectedConditions.visibilityOf(flyFrom01Autocomp));
		flyFrom01Autocomp.click();
		flyToField.clear();
		flyToField.sendKeys(passenger.toDist);
		wait.until(ExpectedConditions.visibilityOf(flyTo01Autocomp));
		flyTo01Autocomp.click();
		fromDate.clear();
		fromDate.sendKeys(passenger.fromDate);
		toDate.clear();
		toDate.sendKeys(passenger.toDate);
		// selectTypeOfPassenger(passenger);
		// return PageFactory.initElements(driver, ReservesionPage.class);

	}

	// **********************************************************************************************
	public ReservesionPage selectTypeOfPassenger(Passenger passenger, String mode) {

		passengersDeopDown.click();
		if (passenger.passengerType == "adult" && mode == "add") {
			addAdults(passenger.ticketAmount);
			// submit();
		}

		else if (passenger.passengerType == "child" && mode == "add") {
			addChild(passenger.ticketAmount);
			// submit();
		} else if (passenger.passengerType == "adult" && mode == "del") {
			removeAdult(passenger.ticketAmount);
			// submit();
		}

		else if (passenger.passengerType == "child" && mode == "del") {
			removeChild(passenger.ticketAmount);
			// submit();
		}

		return PageFactory.initElements(driver, ReservesionPage.class);
	}

	// *****************************************************************************************************
	public void addAdults(int amount) {

		switch (amount) {
		case 0:
			removeAdults.click();
			break;
		case 1:
			addAdults.click();
			break;
		case 3:
			for (int i = 0; i < 4; i++) {
				addAdults.click();
			}
			break;
		case 4:
			for (int i = 0; i < 4; i++) {
				addAdults.click();
			}
			break;
		case 8:
			for (int i = 0; i < 8; i++) {
				addAdults.click();
			}

			break;
		default:
			break;

		}

		getAdults();
		chooseBtn.click();
	}

	// **************************************************************************************************
	public void addChild(int amount) {

		switch (amount) {
		case 0:
			// addChild.click();
			break;
		case 1:
			addChild.click();
			break;
		case 2:
			for (int i = 0; i < 2; i++) {
				addChild.click();

			}

			break;
		case 3:
			for (int i = 0; i < 3; i++) {
				addChild.click();

			}

			break;
		case 4:
			for (int i = 0; i < 4; i++) {
				addChild.click();

			}
		case 5:
			for (int i = 0; i < 5; i++) {
				addAdults.click();

			}

			break;
		case 6:
			for (int i = 0; i < 6; i++) {
				addChild.click();

			}

			break;

		case 7:
			for (int i = 0; i < 7; i++) {
				addChild.click();

			}

			break;

		case 8:
			for (int i = 0; i < 8; i++) {
				addChild.click();

			}

			break;

		default:
			break;

		}
		getChild();
		chooseBtn.click();
	}

	public void removeAdult(int amount) {
		switch (amount) {
		case 1:
			removeAdults.click();
			break;
		case 2:
			for (int i = 0; i < 1; i++) {
				removeAdults.click();
			}
			break;
		case 3:
			for (int i = 0; i < 2; i++) {
				removeAdults.click();
			}
			break;
		case 4:
			for (int i = 0; i < 3; i++) {
				removeAdults.click();
			}
			break;
		case 5:
			for (int i = 0; i < 4; i++) {
				removeAdults.click();
			}
			break;
		case 6:
			for (int i = 0; i < 5; i++) {
				removeAdults.click();
			}
			break;
		case 7:
			for (int i = 0; i < 6; i++) {
				removeAdults.click();
			}
			break;
		case 8:
			for (int i = 0; i < 7; i++) {
				removeAdults.click();
			}
			break;
		case 9:
			for (int i = 0; i < 8; i++) {
				removeAdults.click();
			}
			break;
		case 10:
			for (int i = 0; i < 9; i++) {
				removeAdults.click();
			}
			break;

		default:
			break;
		}
		chooseBtn.click();
	}

	public void removeChild(int amount) {
		switch (amount) {
		case 1:
			remChild.click();
			break;
		case 2:
			for (int i = 0; i < 1; i++) {
				remChild.click();
			}
			break;
		case 3:
			for (int i = 0; i < 2; i++) {
				remChild.click();
			}
			break;
		case 4:
			for (int i = 0; i < 3; i++) {
				remChild.click();
			}
			break;
		case 5:
			for (int i = 0; i < 4; i++) {
				remChild.click();
			}
			break;
		case 6:
			for (int i = 0; i < 5; i++) {
				remChild.click();
			}
			break;
		case 7:
			for (int i = 0; i < 6; i++) {
				remChild.click();
			}
			break;
		case 8:
			for (int i = 0; i < 7; i++) {
				remChild.click();
			}
			break;
		case 9:
			for (int i = 0; i < 8; i++) {
				remChild.click();
			}
			break;
		case 10:
			for (int i = 0; i < 9; i++) {
				remChild.click();
			}
			break;

		default:
			break;
		}

	}

	public void getAdults() {
		String number = adultAmount.getText();
		int amount = Integer.parseInt(number);
		Global.adultsAmount = amount;

	}

	public void getChild() {
		String number = childrenAmount.getText();
		int amount = Integer.parseInt(number);
		//Global.adultsAmount = amount;
		Global.childAmount = amount;

	}
}
