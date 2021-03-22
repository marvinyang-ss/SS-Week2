/**
 * 
 */
package com.ss.utopia.views.admin.passenger;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
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
public class UpdatePassengerView implements View {
	
	private Passenger passenger;
	
	public UpdatePassengerView(Passenger passenger) {
		this.passenger = passenger;
	}

	@Override
	public void display(Scanner scanner) {
		AdminService service = new AdminService();

		try {
			// Get Booking
			List<Booking> bookings = service.readAllBookings();
			List<String> options = new ArrayList<>();
			bookings.forEach(booking -> options.add("Booking Id: " + booking.getId()));
			options.add("No change");
			Menu bookingMenu = new Menu(options) {
				@Override
				public void display(Scanner scanner) {
					System.out.println("Update Booking:");
					displayOptions();
				}
			};
			bookingMenu.display(scanner);
			Integer selectedIndex = bookingMenu.getOptionChoice(scanner) - 1;
			if (selectedIndex < options.size()-1) {
				Booking booking = bookings.get(selectedIndex);
				passenger.setBooking(booking);
			}
			
			// Get Given Name
			Menu givenNameMenu = new Menu(Arrays.asList("Yes", "No")) {
				@Override
				public void display(Scanner scanner) {
					System.out.println("Change first name?");
					displayOptions();
				}
			};
			givenNameMenu.display(scanner);
			selectedIndex = givenNameMenu.getOptionChoice(scanner);
			if (selectedIndex == 1) {
				System.out.print("First name: ");
				scanner.nextLine();
				passenger.setGivenName(scanner.nextLine());
			}
			
			// Get Family Name
			Menu familyNameMenu = new Menu(Arrays.asList("Yes", "No")) {
				@Override
				public void display(Scanner scanner) {
					System.out.println("Change last name?");
					displayOptions();
				}
			};
			familyNameMenu.display(scanner);
			selectedIndex = familyNameMenu.getOptionChoice(scanner);
			if (selectedIndex == 1) {
				System.out.print("Last name: ");
				scanner.nextLine();
				passenger.setFamilyName(scanner.nextLine());
			}
			
			// Get Date of Birth
			Menu dobMenu = new Menu(Arrays.asList("Yes", "No")) {
				@Override
				public void display(Scanner scanner) {
					System.out.println("Change BirthDate?");
					displayOptions();
				}
			};
			dobMenu.display(scanner);
			selectedIndex = dobMenu.getOptionChoice(scanner);
			if (selectedIndex == 1) {
				System.out.print("Date of Birth (yyyy-mm-dd): ");
				scanner.nextLine();
				passenger.setDateOfBirth(LocalDate.parse(scanner.nextLine()));
			}
			
			// Get Gender
			Menu genderMenu = new Menu(Arrays.asList("Yes", "No")) {
				@Override
				public void display(Scanner scanner) {
					System.out.println("Change Gender?");
					displayOptions();
				}
			};
			genderMenu.display(scanner);
			selectedIndex = genderMenu.getOptionChoice(scanner);
			if (selectedIndex == 1) {
				System.out.print("Gender (male/female): ");
				scanner.nextLine();
				passenger.setGender(scanner.nextLine());
			}
			
			// Get Address
			Menu addressMenu = new Menu(Arrays.asList("Yes", "No")) {
				@Override
				public void display(Scanner scanner) {
					System.out.println("Change Address?");
					displayOptions();
				}
			};
			addressMenu.display(scanner);
			selectedIndex = addressMenu.getOptionChoice(scanner);
			if (selectedIndex == 1) {
				System.out.print("Address: ");
				scanner.nextLine();
				passenger.setAddress(scanner.nextLine());
			}
			
			// Add Passenger
			System.out.println(service.updatePassenger(passenger));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Could not update passenger");
		} finally {
			System.out.println();
			new PassengersMenu().display(scanner);
		}
	}

}