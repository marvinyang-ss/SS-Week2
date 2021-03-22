/**
 * 
 */
package com.ss.utopia.views.admin.flight;

import java.util.Scanner;

import com.ss.utopia.entity.Flight;
import com.ss.utopia.views.View;

/**
 * @author marvin
 *
 */
public class ReadFlightView implements View {

	private Flight flight;
	
	public ReadFlightView(Flight flight) {
		this.flight = flight;
	}

	@Override
	public void display(Scanner scanner) {
		System.out.println("Flight Id: " + flight.getId());
		System.out.println("Route: " + flight.getRoute().getOrigin().getId() + ", " + flight.getRoute().getOrigin().getCity()
				+ " -> " + flight.getRoute().getDestination().getId() + ", " + flight.getRoute().getDestination().getCity());
		System.out.println("Airplane Id: " + flight.getAirplane().getId() + ", Max Capacity: " + flight.getAirplane().getType().getMaxCapacity());
		System.out.println("Departure Time: " + flight.getDepartureTime());
		System.out.println("Reserved Seats: " + flight.getReservedSeats());
		System.out.println("Seat Price: " + flight.getSeatPrice());
		System.out.println("\nPress 'Enter' to return to previous menu");
		scanner.nextLine();
		scanner.nextLine();

		new FlightCrudMenu(flight).display(scanner);
	}

}