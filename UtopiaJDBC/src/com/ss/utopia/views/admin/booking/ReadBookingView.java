/**
 * 
 */
package com.ss.utopia.views.admin.booking;

import java.util.Scanner;

import com.ss.utopia.entity.Booking;
import com.ss.utopia.views.View;

/**
 * @author marvin
 *
 */
public class ReadBookingView implements View {

	private Booking booking;
	
	public ReadBookingView(Booking booking) {
		this.booking = booking;
	}

	@Override
	public void display(Scanner scanner) {
		System.out.println("Booking Id: " + booking.getId());
		System.out.println("Is Active: " + booking.getIsActive());
		System.out.println("Confirmation Code: " + booking.getConfirmationCode());
		System.out.println("\nPress 'Enter' to return to previous menu");
		scanner.nextLine();
		scanner.nextLine();

		new BookingCrudMenu(booking).display(scanner);
	}

}