/**
 * 
 */
package com.ss.utopia.views.admin.booking;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.ss.utopia.entity.Booking;
import com.ss.utopia.service.AdminService;
import com.ss.utopia.views.Menu;
import com.ss.utopia.views.admin.AdminMenu;

/**
 * @author marvin
 *
 */
public class BookingsMenu extends Menu {
	
	private List<Booking> bookings;
	
	public BookingsMenu() {
		AdminService service = new AdminService();
		try {
			bookings = service.readAllBookings();
			bookings.forEach(booking -> options.add("Id: " + booking.getId() + ", Active: " + booking.getIsActive()));
			options.add("Add Booking");
			options.add("Quit to previous");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void display(Scanner scanner) {
		System.out.println("Choose a booking to manage");
		displayOptions();
		Integer input = getOptionChoice(scanner);
		
		if (input < options.size()-1) {
			new BookingCrudMenu(bookings.get(input-1)).display(scanner);
		} else if (input == options.size()-1) {
			new AddBookingView().display(scanner);;
		} else {
			new AdminMenu().display(scanner);
		}
	}

}