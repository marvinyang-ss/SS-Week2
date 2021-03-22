/**
 * 
 */
package com.ss.utopia.entity;

/**
 * @author marvin
 *
 */
public class BookingPayment {
	private Booking booking;
	private String stripe;
	private Boolean refunded;
	
	public Booking getBooking() {
		return booking;
	}
	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	public String getStripe() {
		return stripe;
	}
	public void setStripe(String stripe) {
		this.stripe = stripe;
	}
	public Boolean getRefunded() {
		return refunded;
	}
	public void setRefunded(Boolean refunded) {
		this.refunded = refunded;
	}
}
