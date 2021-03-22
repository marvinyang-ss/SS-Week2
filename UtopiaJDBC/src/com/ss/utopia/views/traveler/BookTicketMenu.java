/**
 * 
 */
package com.ss.utopia.views.traveler;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.ss.utopia.entity.Airport;
import com.ss.utopia.entity.Booking;
import com.ss.utopia.entity.BookingUser;
import com.ss.utopia.entity.Flight;
import com.ss.utopia.entity.FlightBookings;
import com.ss.utopia.entity.User;
import com.ss.utopia.service.TravelerService;
import com.ss.utopia.views.Menu;

/**
 * @author marvin
 *
 */
public class BookTicketMenu extends Menu {

	private TravelerService service = new TravelerService();
	private List<Flight> flights;
	private User user;
	
	public BookTicketMenu(User user) {
		this.user = user;
		try {
			flights = service.readAllFlights();
			flights.forEach(flight -> {
				Airport origin = flight.getRoute().getOrigin();
				Airport destination = flight.getRoute().getDestination();
				options.add(origin.getId() + ", " + origin.getCity() 
				+ " -> " + destination.getId() + ", " + destination.getCity());
			});
			options.add("Quit to previous");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void display(Scanner scanner) {
		System.out.println("Pick the Flight you want to book a ticket for:");
		displayOptions();
		Integer input = getOptionChoice(scanner);
		
		if (input < options.size()) {
			// Get Flight
			Flight flight = flights.get(input-1);
			
			// Create Booking
			Booking booking = new Booking();
			booking.setId(null);
			booking.setIsActive(true);
			StringBuilder confirmationCode = new StringBuilder();
			for (int i = 0; i < 10; i++) {
				confirmationCode.append((int)(Math.random() * 10));
			}
			booking.setConfirmationCode(confirmationCode.toString());
			
			// Create flightBookings
			FlightBookings flightBooking = new FlightBookings();
			flightBooking.setFlight(flight);
			flightBooking.setBooking(booking);
			
			// Create BookingUser
			BookingUser bookingUser = new BookingUser();
			bookingUser.setBooking(booking);
			bookingUser.setUser(user);
			
			// Add to database
			try {
				Integer key = service.addBooking(booking);
				booking.setId(key);
				System.out.println(service.addFlightBookings(flightBooking));
				System.out.println(service.addBookingUser(bookingUser));
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				System.out.println();
				new TravelerMenu(user).display(scanner);
			}
		} else {
			new TravelerMenu(user);
		}
	}

}
