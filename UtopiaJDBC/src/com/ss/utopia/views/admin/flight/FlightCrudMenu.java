/**
 * 
 */
package com.ss.utopia.views.admin.flight;

import java.util.Arrays;
import java.util.Scanner;

import com.ss.utopia.entity.Flight;
import com.ss.utopia.views.Menu;

/**
 * @author marvin
 *
 */
public class FlightCrudMenu extends Menu {

	private Flight flight;

	public FlightCrudMenu(Flight flight) {
		super(Arrays.asList("Read Flight", "Update Flight", "Delete Flight", "Quit to previous"));
		this.flight = flight;
	}

	@Override
	public void display(Scanner scanner) {
		System.out.println("You have chosen the Flight with Flight Id: " + flight.getId());
		displayOptions();
		Integer input = getOptionChoice(scanner);

		switch (input) {
		case 1:
			new ReadFlightView(flight).display(scanner);
			break;
		case 2:
			new UpdateFlightView(flight).display(scanner);
			break;
		case 3:
			new DeleteFlightView(flight).display(scanner);
			break;
		case 4:
			new FlightsMenu().display(scanner);;
		default:
			break;
		}
	}

}
