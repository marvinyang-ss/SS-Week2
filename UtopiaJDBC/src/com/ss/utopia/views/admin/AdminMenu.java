/**
 * 
 */
package com.ss.utopia.views.admin;

import java.util.Arrays;
import java.util.Scanner;

import com.ss.utopia.views.MainMenu;
import com.ss.utopia.views.Menu;
import com.ss.utopia.views.admin.airport.AirportsMenu;
import com.ss.utopia.views.admin.booking.BookingsMenu;
import com.ss.utopia.views.admin.employee.EmployeesMenu;
import com.ss.utopia.views.admin.flight.FlightsMenu;
import com.ss.utopia.views.admin.passenger.PassengersMenu;
import com.ss.utopia.views.admin.traveler.TravelersMenu;

/**
 * @author marvin
 *
 */
public class AdminMenu extends Menu {

	public AdminMenu() {
		super(Arrays.asList(
			"Add/Update/Delete/Read Flights", 
			"Add/Update/Delete/Read Bookings", 
			"Add/Update/Delete/Read Passengers", 
			"Add/Update/Delete/Read Airports", 
			"Add/Update/Delete/Read Travelers", 
			"Add/Update/Delete/Read Employees", 
			"Over-ride Trip Cancellation for a ticket",
			"Quit to previous")
		);
	}

	@Override
	public void display(Scanner scanner) {
		System.out.println("Administrator");
		displayOptions();
		Integer optionChoice = getOptionChoice(scanner);

		switch (optionChoice) {
		case 1:
			new FlightsMenu().display(scanner);
			break;
		case 2:
			new BookingsMenu().display(scanner);
			break;
		case 3:
			new PassengersMenu().display(scanner);
			break;
		case 4:
			new AirportsMenu().display(scanner);
			break;
		case 5:
			new TravelersMenu().display(scanner);
			break;
		case 6:
			new EmployeesMenu().display(scanner);
			break;
		case 7:
			new CancelTicketMenu().display(scanner);
			break;
		case 8:
			new MainMenu().display(scanner);
			break;
		default:
			System.out.println("Error: input value does not match any options");
			break;
		}
	}
	
}