/**
 * 
 */
package com.ss.utopia.views.admin.booking;

import java.util.Arrays;
import java.util.Scanner;

import com.ss.utopia.entity.Booking;
import com.ss.utopia.views.Menu;

/**
 * @author marvin
 *
 */
public class BookingCrudMenu extends Menu {

	private Booking booking;

	public BookingCrudMenu(Booking booking) {
		super(Arrays.asList("Read Booking", "Update Booking", "Delete Booking", "Quit to previous"));
		this.booking = booking;
	}

	@Override
	public void display(Scanner scanner) {
		System.out.println("You have chosen the Booking with Booking Id: " + booking.getId());
		displayOptions();
		Integer input = getOptionChoice(scanner);

		switch (input) {
		case 1:
			new ReadBookingView(booking).display(scanner);
			break;
		case 2:
			new UpdateBookingView(booking).display(scanner);
			break;
		case 3:
			new DeleteBookingView(booking).display(scanner);
			break;
		case 4:
			new BookingsMenu().display(scanner);;
		default:
			break;
		}
	}

}
