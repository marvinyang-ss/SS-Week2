/**
 * 
 */
package com.ss.utopia.entity;

/**
 * @author marvin
 *
 */
public class FlightBookings {
	private Flight flight;
	private Booking booking;
	
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	public Booking getBooking() {
		return booking;
	}
	public void setBooking(Booking booking) {
		this.booking = booking;
	}
}
