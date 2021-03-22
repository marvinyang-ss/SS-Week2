/**
 * 
 */
package com.ss.utopia.views.admin.passenger;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ss.utopia.entity.Booking;
import com.ss.utopia.entity.Passenger;
import com.ss.utopia.service.AdminService;
import com.ss.utopia.views.Menu;
import com.ss.utopia.views.View;

/**
 * @author marvin
 *
 */
public class AddPassengerView implements View {

	@Override
	public void display(Scanner scanner) {
		AdminService service = new AdminService();

		Passenger newPassenger = new Passenger();

		try {
			// Get Id
			newPassenger.setId(null);

			// Get Booking
			List<Booking> bookings = service.readAllBookings();
			List<String> options = new ArrayList<>();
			bookings.forEach(booking -> options.add("Booking Id: " + booking.getId()));
			Menu bookingMenu = new Menu(options) {
				@Override
				public void display(Scanner scanner) {
					System.out.println("Choose Booking:");
					displayOptions();
				}
			};
			bookingMenu.display(scanner);
			Integer selectedIndex = bookingMenu.getOptionChoice(scanner) - 1;
			Booking booking = bookings.get(selectedIndex);
			newPassenger.setBooking(booking);
			
			// Get Given Name
			System.out.print("First name: ");
			scanner.nextLine();
			newPassenger.setGivenName(scanner.nextLine());
			
			// Get Family Name
			System.out.print("Last name: ");
			newPassenger.setFamilyName(scanner.nextLine());
			
			// Get Date of Birth
			System.out.print("Date of Birth (yyyy-mm-dd): ");
			newPassenger.setDateOfBirth(LocalDate.parse(scanner.nextLine()));
			
			// Get Gender
			System.out.print("Gender (male/female): ");
			newPassenger.setGender(scanner.nextLine());
			
			// Get Address
			System.out.print("Address: ");
			newPassenger.setAddress(scanner.nextLine());
			
			// Add Passenger
			System.out.println(service.addPassenger(newPassenger));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Could not add passenger");
		} finally {
			System.out.println();
			new PassengersMenu().display(scanner);
		}
	}

}