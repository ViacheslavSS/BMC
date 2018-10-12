package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReservesionPage {
	@FindBy(className = "NumOfPass")
	WebElement NumOfPassengers;
	
	public int getNumOfPass(){
		//System.out.println(NumOfPassengers.getAttribute(getNumOfPass()));
		int amount =Integer.parseInt(NumOfPassengers.getText().toString());
		return amount;
		
	}
}
