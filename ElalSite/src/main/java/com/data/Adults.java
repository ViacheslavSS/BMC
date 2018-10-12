package com.data;

public class Adults extends Passenger{
	public int adultAmount;

	public Adults(String firstName, String lastName, String fromDist, String toDist, String fromDate, String toDate,
			int ticketAmount) {
		super(firstName, lastName, fromDist, toDist, fromDate, toDate, ticketAmount);
	
	}

}
