/**
 * 
 */
package com.ss.utopia.entity;

/**
 * @author marvin
 *
 */
public class BookingGuest {
	private Booking booking;
	private String contactEmail;
	private String contactPhone;
	
	public Booking getBooking() {
		return booking;
	}
	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	public String getContactEmail() {
		return contactEmail;
	}
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
	public String getContactPhone() {
		return contactPhone;
	}
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
}
