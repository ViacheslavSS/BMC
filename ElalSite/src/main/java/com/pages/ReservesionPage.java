package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReservesionPage {
	@FindBy(className = "NumOfPass")
	WebElement NumOfPassengers;

	// *********************************************************************
	@FindBy(className = "city")
	WebElement cityOutbound;
	@FindBy(xpath = "//div[@id='searchDatesHeader']/div[2]/span")
	WebElement cityInbound;

	// *********************************************************************

	public int getNumOfPass() {
		// System.out.println(NumOfPassengers.getAttribute(getNumOfPass()));
		int amount = Integer.parseInt(NumOfPassengers.getText().toString());
		return amount;

	}

	public Boolean getOutboundDirection() {
		if (cityOutbound.getText().toString().contains("Tel Aviv Yafo to Buffalo")) {
			return true;
		}

		else if (cityOutbound.getText().toString().contains("Buffalo to Tel Aviv Yafo")) {
			return true;

		}
		
		else if (cityOutbound.getText().toString().contains("Tel Aviv Yafo to Berlin")) {
			return true;

		}

		return false;
	}

	public String getIntboundDirection() {
		return cityInbound.getText().toString();
	}
}
