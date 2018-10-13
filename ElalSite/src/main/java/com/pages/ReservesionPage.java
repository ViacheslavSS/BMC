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
	
	public int getNumOfPass(){
		//System.out.println(NumOfPassengers.getAttribute(getNumOfPass()));
		int amount =Integer.parseInt(NumOfPassengers.getText().toString());
		return amount;
		
	}
	public String getOutboundDirection() {
		return cityOutbound.getText().toString();
		
	}

	public String getIntboundDirection() {
		return cityInbound.getText().toString();
	}
}
