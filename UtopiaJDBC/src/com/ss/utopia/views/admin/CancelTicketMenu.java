/**
 * 
 */
package com.ss.utopia.views.admin;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.ss.utopia.entity.Booking;
import com.ss.utopia.service.AdminService;
import com.ss.utopia.views.Menu;

/**
 * @author marvin
 *
 */
public class CancelTicketMenu extends Menu {
	
	private List<Booking> bookings;
	AdminService service = new AdminService();
	
	public CancelTicketMenu() {
		try {
			bookings = service.readAllBookings().stream().filter(booking -> booking.getIsActive()).collect(Collectors.toList());
			bookings.forEach(booking -> options.add("Booking Id: " + booking.getId() + ", Active: " + booking.getIsActive()));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void display(Scanner scanner) {
		System.out.println("Choose a Ticket to cancel");
		displayOptions();
		Integer selectedIndex = getOptionChoice(scanner) - 1;
		Booking selectedBooking = bookings.get(selectedIndex);
		selectedBooking.setIsActive(false);
		try {
			System.out.println(service.updateBooking(selectedBooking));
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Failed to cancel ticket");
		} finally {
			new AdminMenu().display(scanner);
		}
		
	}

}
