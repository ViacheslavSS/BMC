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
//------------------------------------------------------
	@FindBy(id = "passengers-drop1")
	WebElement passengersDeopDown;
	@FindBy(className = "s-dropdown-qty-down")
	WebElement removeAdults;
	@FindBy(className = "s-dropdown-qty-up")
	WebElement addAdults;
	@FindBy(className = "s-dropdown-item-qty")
	WebElement adultAmount;
	@FindBy(css = "div.super-drop-close.super-drop-close-flight-search")
	WebElement chooseBtn;
	
	
	

	
	
	

	public void submit() {
		submitBtn.click();
	}

	public ReservesionPage fillSearchingForm(Passenger passenger) {
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
		passengersDeopDown.click();
		addAdults(passenger.ticketAmount);
	
		submit();
		//driver.navigate().back();
		return PageFactory.initElements(driver, ReservesionPage.class);

	}
	
	public void addAdults(int amount){
	
		switch (amount) {
		case 1:
			addAdults.click();
			break;
		case 2:
			for (int i=0;i<2;i++){
				addAdults.click();
				
			}
			
			break;
		case 8:
			for (int i=0;i<8;i++){
				addAdults.click();
				
			}
			
			break;

		default:
			break;
			
		}
		getAdults();
		chooseBtn.click();
	}
	public void getAdults(){
		String number= adultAmount.getText();
	int amount =Integer.parseInt(number);
	Global.adultsAmount=amount;
	
		
		
		
	}
}
