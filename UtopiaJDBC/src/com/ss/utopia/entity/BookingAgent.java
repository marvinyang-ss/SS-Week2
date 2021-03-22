/**
 * 
 */
package com.ss.utopia.entity;

/**
 * @author marvin
 *
 */
public class BookingAgent {
	private Booking booking;
	private User agent;
	
	public Booking getBooking() {
		return booking;
	}
	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	public User getAgent() {
		return agent;
	}
	public void setAgent(User agent) {
		this.agent = agent;
	}
}
