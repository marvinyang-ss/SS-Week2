/**
 * 
 */
package com.ss.utopia.views.traveler;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.ss.utopia.entity.Airport;
import com.ss.utopia.entity.Booking;
import com.ss.utopia.entity.BookingUser;
import com.ss.utopia.entity.FlightBookings;
import com.ss.utopia.entity.User;
import com.ss.utopia.service.TravelerService;
import com.ss.utopia.views.Menu;

/**
 * @author marvin
 *
 */
public class CancelTripMenu extends Menu {
	
	private TravelerService service = new TravelerService();
	private List<FlightBookings> flightBookings;
	private User user;
	
	public CancelTripMenu(User user) {
		this.user = user;
		try {
			// Filter bookings that belong to user
			List<BookingUser> bookingUsers = service.readAllBookingUsers().stream()
					.filter(bookingUser -> bookingUser.getUser().getId() == user.getId()).collect(Collectors.toList());
			
			List<Integer> bookingIds = bookingUsers.stream().map(bookingUser -> bookingUser.getBooking().getId()).collect(Collectors.toList());
			
			// Filter flights that belong to user
			flightBookings = service.readAllFlightBookings().stream()
					.filter(flightBooking -> bookingIds.contains(flightBooking.getBooking().getId())).collect(Collectors.toList());
			
			flightBookings.forEach(flightBooking -> {
				Airport origin = flightBooking.getFlight().getRoute().getOrigin();
				Airport destination = flightBooking.getFlight().getRoute().getDestination();
				options.add(origin.getId() + ", " + origin.getCity() 
				+ " -> " + destination.getId() + ", " + destination.getCity() + " | Active: " + flightBooking.getBooking().getIsActive());
			});
			options.add("Quit to previous");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void display(Scanner scanner) {
		System.out.println("Pick the trip you want to cancel.");
		displayOptions();
		Integer input = getOptionChoice(scanner);
		
		if (input < options.size()) {
			FlightBookings flightBooking = flightBookings.get(input-1);
			Booking booking = flightBooking.getBooking();
			booking.setIsActive(false);
			
			try {
				System.out.println(service.updateBooking(booking));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println();
		new TravelerMenu(user).display(scanner);
	}

}
