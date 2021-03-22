/**
 * 
 */
package com.ss.utopia.views.employee;

import java.util.Scanner;

import com.ss.utopia.entity.Flight;
import com.ss.utopia.views.View;

/**
 * @author marvin
 *
 */
public class FlightDetailsView implements View {

	private Flight flight;
	
	public FlightDetailsView(Flight flight) {
		this.flight = flight;
	}

	@Override
	public void display(Scanner scanner) {
		String originId = flight.getRoute().getOrigin().getId();
		String destinationId = flight.getRoute().getDestination().getId();
		Integer availableSeats = flight.getAirplane().getType().getMaxCapacity() - flight.getReservedSeats();
		System.out.println("You have chosen to view the Flight with Flight Id: " + flight.getId() + ".\n"
			+ "Departure Airport: " + originId 
			+ " | Arrival Airport: " + destinationId 
			+ " | Departure Date: " + flight.getDepartureTime().toLocalDate() 
			+ " | Departure Time: " + flight.getDepartureTime().toLocalTime() + "\n"
			+ "Available Seats: " + availableSeats + "\n" 
			+ "Press 'Enter' to return to previous menu");
		scanner.nextLine();
		scanner.nextLine();

		new Employee3Menu(flight).display(scanner);
	}

}