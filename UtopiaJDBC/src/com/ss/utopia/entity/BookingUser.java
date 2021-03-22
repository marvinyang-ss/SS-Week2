/**
 * 
 */
package com.ss.utopia.entity;

/**
 * @author marvin
 *
 */
public class BookingUser {
	private Booking booking;
	private User user;
	
	public Booking getBooking() {
		return booking;
	}
	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
