/**
 * 
 */
package com.ss.utopia.views.employee;

import java.util.Arrays;
import java.util.Scanner;

import com.ss.utopia.entity.Flight;
import com.ss.utopia.views.Menu;

/**
 * @author marvin
 *
 */
public class Employee3Menu extends Menu {
	
	private Flight flight;

	public Employee3Menu(Flight flight) {
		super(Arrays.asList("View more details about the flight", 
				"Update the details of the Flight", 
				"Add Seats to Flight", 
				"Quit to previous"));
		this.flight = flight;
	}

	@Override
	public void display(Scanner scanner) {
		System.out.println("You have chosen the Flight with Flight Id: " + flight.getId());
		displayOptions();
		Integer optionChoice = getOptionChoice(scanner);

		switch (optionChoice) {
		case 1:
			new FlightDetailsView(flight).display(scanner);
			break;
		case 2:
			new UpdateFlightView(flight).display(scanner);
			break;
		case 3:
			new AddSeatsView(flight).display(scanner);
			break;
		case 4:
			new Employee2Menu().display(scanner);
			break;
		default:
			System.out.println("Error: input value does not match any options");
			break;
		}
	}

}