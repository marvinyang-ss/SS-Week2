/**
 * 
 */
package com.ss.utopia.views.employee;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import com.ss.utopia.entity.Airport;
import com.ss.utopia.entity.Flight;
import com.ss.utopia.entity.Route;
import com.ss.utopia.service.EmployeeService;
import com.ss.utopia.views.View;

/**
 * @author marvin
 *
 */
public class UpdateFlightView implements View {

	private Flight flight;

	public UpdateFlightView(Flight flight) {
		this.flight = flight;
	}

	@Override
	public void display(Scanner scanner) {
		EmployeeService service = new EmployeeService();

		String originId = flight.getRoute().getOrigin().getId();
		String destinationId = flight.getRoute().getDestination().getId();

		System.out.println("You have chosen to update the Flight with Flight Id: " + flight.getId()
				+ " and Flight Origin: " + originId + " and Flight Destination:  " + destinationId + ".\n"
				+ "Enter ‘quit’ at any prompt to cancel operation.\n");

		String input;
		Route updatedRoute = flight.getRoute();
		LocalDate updatedDate = flight.getDepartureTime().toLocalDate();
		LocalTime updatedTime = flight.getDepartureTime().toLocalTime();

		scanner.nextLine();

		// Update Origin
		input = askUserInput(scanner, "Origin Airport");
		if ("quit".equalsIgnoreCase(input)) {
			updateFlight(scanner, service, updatedRoute, LocalDateTime.of(updatedDate, updatedTime));
			return;
		}
		if (input.equalsIgnoreCase("N/A")) {
			System.out.println("No change was made.");
		} else {
			try {
				Airport newOrigin = service.readAirportById(input);
				updatedRoute.setOrigin(newOrigin);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		// Update Destination
		input = askUserInput(scanner, "Destination Airport");
		if ("quit".equalsIgnoreCase(input)) {
			updateFlight(scanner, service, updatedRoute, LocalDateTime.of(updatedDate, updatedTime));
			return;
		}
		if (input.equalsIgnoreCase("N/A")) {
			System.out.println("No change was made.");
		} else {
			try {
				Airport newDestination = service.readAirportById(input);
				updatedRoute.setDestination(newDestination);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		// Update Departure Date
		input = askUserInput(scanner, "Departure Date");
		if ("quit".equalsIgnoreCase(input)) {
			updateFlight(scanner, service, updatedRoute, LocalDateTime.of(updatedDate, updatedTime));
			return;
		}
		if (input.equalsIgnoreCase("N/A")) {
			System.out.println("No change was made.");
		} else {
			try {
				updatedDate = LocalDate.parse(input);
			} catch (DateTimeParseException e) {
				System.out.println("Format should be yyyy-mm-dd");
			}
		}

		// Update Departure Time
		input = askUserInput(scanner, "Departure Time");
		if ("quit".equalsIgnoreCase(input)) {
			updateFlight(scanner, service, updatedRoute, LocalDateTime.of(updatedDate, updatedTime));
			return;
		}
		if (input.equalsIgnoreCase("N/A")) {
			System.out.println("No change was made.");
		} else {
			try {
				updatedTime = LocalTime.parse(input);
			} catch (DateTimeParseException e) {
				System.out.println("Format should be hh:mm:ss");
			}
		}

		updateFlight(scanner, service, updatedRoute, LocalDateTime.of(updatedDate, updatedTime));
	}

	private void updateFlight(Scanner scanner, EmployeeService service, Route updatedRoute, LocalDateTime updatedDepartureTime) {
		try {
			// Find Route
			Route newRoute = service.readRouteByAirports(updatedRoute.getOrigin().getId(), updatedRoute.getDestination().getId());
		
			// Update Flight
			flight.setRoute(newRoute);
			flight.setDepartureTime(updatedDepartureTime);
			String message = service.updateFlight(flight);
			System.out.println(message);
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("There is no route from " + updatedRoute.getOrigin().getId() + " to " + updatedRoute.getDestination().getId());
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Failed to update flight");
		}

		System.out.println();

		new Employee3Menu(flight).display(scanner);
	}

	private String askUserInput(Scanner scanner, String propertyName) {
		System.out.println("Please enter new " + propertyName + " or enter N/A for no change:");
		System.out.print("> ");
		return scanner.nextLine();
	}

}