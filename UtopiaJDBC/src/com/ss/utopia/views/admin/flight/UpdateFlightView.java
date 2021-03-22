/**
 * 
 */
package com.ss.utopia.views.admin.flight;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ss.utopia.entity.Airplane;
import com.ss.utopia.entity.Airport;
import com.ss.utopia.entity.Flight;
import com.ss.utopia.service.AdminService;
import com.ss.utopia.views.Menu;
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
		AdminService service = new AdminService();

		// Get Route
		try {
			// Get Origin
			List<Airport> airports = service.readAllAirports();
			List<String> options = new ArrayList<>();
			airports.forEach(airport -> options.add(airport.getId() + ", " + airport.getCity()));
			options.add("No change");
			Menu originMenu = new Menu(options) {
				@Override
				public void display(Scanner scanner) {
					System.out.println("Update Origin:");
					displayOptions();
				}
			};
			originMenu.display(scanner);
			Integer selectedIndex = originMenu.getOptionChoice(scanner) - 1;
			Airport origin = flight.getRoute().getOrigin();
			if (selectedIndex+1 < options.size()) {
				origin = airports.get(selectedIndex);
			}

			// Get Destination
			Menu destinationMenu = new Menu(options) {
				@Override
				public void display(Scanner scanner) {
					System.out.println("Update Destination:");
					displayOptions();
				}
			};
			destinationMenu.display(scanner);
			selectedIndex = destinationMenu.getOptionChoice(scanner) - 1;
			Airport destination = flight.getRoute().getDestination();
			if (selectedIndex+1 < options.size()) {
				destination = airports.get(selectedIndex);
			}

			flight.setRoute(service.readRouteByAirports(origin.getId(), destination.getId()));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// Get Airplane
		try {
			List<Airplane> airplanes = service.readAllAirplanes();
			List<String> options = new ArrayList<>();
			airplanes.forEach(airplane -> options
					.add("Id: " + airplane.getId() + ", Max Capacity: " + airplane.getType().getMaxCapacity()));
			options.add("No change");
			Menu airplaneMenu = new Menu(options) {
				@Override
				public void display(Scanner scanner) {
					System.out.println("Update Airplane:");
					displayOptions();
				}
			};
			airplaneMenu.display(scanner);
			Integer selectedIndex = airplaneMenu.getOptionChoice(scanner) - 1;
			Airplane airplane = flight.getAirplane();
			if (selectedIndex+1 < options.size()) {
				airplane = airplanes.get(selectedIndex);
			}

			flight.setAirplane(airplane);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Get Departure Date
		LocalDate departureDate;
		try {
			System.out.print(" Update Departure Date (yyyy-mm-dd) or N/A: ");
			scanner.nextLine();
			departureDate = LocalDate.parse(scanner.nextLine());
		} catch (Exception e) {
			departureDate = flight.getDepartureTime().toLocalDate();
			System.out.println("No change was made.");
		}

		// Get Departure Time
		LocalTime departureTime;
		try {
			System.out.print("Update Departure Time (hh:mm:ss) or N/A: ");
			departureTime = LocalTime.parse(scanner.nextLine());
		} catch (Exception e) {
			departureTime = flight.getDepartureTime().toLocalTime();
			System.out.println("No change was made.");
		}
		
		// Get Departure DateTime
		flight.setDepartureTime(LocalDateTime.of(departureDate, departureTime));

		// Get Reserved Seats
		Integer reservedSeats;
		try {
			System.out.print("Update Reserved Seats or N/A: ");
			reservedSeats = scanner.nextInt();
		} catch (Exception e) {
			reservedSeats = flight.getReservedSeats();
			System.out.println("No change was made.");
		}
		flight.setReservedSeats(reservedSeats);

		// Get Seat Price
		Float seatPrice;
		try {
			System.out.print("Update Seat Price or N/A: ");
			scanner.nextLine();
			seatPrice = scanner.nextFloat();
		} catch (Exception e) {
			seatPrice = flight.getSeatPrice();
			System.out.println("No change was made.");
		}
		flight.setSeatPrice(seatPrice);

		// Add Flight
		try {
			System.out.println(service.updateFlight(flight));
			System.out.println();
		} catch (SQLException e) {
			System.out.println("Could not update flight.");
		}

		new FlightsMenu().display(scanner);
	}

}