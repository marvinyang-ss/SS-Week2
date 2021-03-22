/**
 * 
 */
package com.ss.utopia.views.admin.flight;

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
public class AddFlightView implements View {

	@Override
	public void display(Scanner scanner) {
		AdminService service = new AdminService();

		Flight newFlight = new Flight();

		try {
			// Get Id
			System.out.print("Flight Id: ");
			Integer id = scanner.nextInt();
			newFlight.setId(id);

			// Get Origin
			List<Airport> airports = service.readAllAirports();
			List<String> options = new ArrayList<>();
			airports.forEach(airport -> options.add(airport.getId() + ", " + airport.getCity()));
			Menu originMenu = new Menu(options) {
				@Override
				public void display(Scanner scanner) {
					System.out.println("Choose Origin:");
					displayOptions();
				}
			};
			originMenu.display(scanner);
			Integer selectedIndex = originMenu.getOptionChoice(scanner) - 1;
			String originId = airports.get(selectedIndex).getId();

			// Get Destination
			airports.remove(selectedIndex.intValue());
			options.remove(selectedIndex.intValue());
			Menu destinationMenu = new Menu(options) {
				@Override
				public void display(Scanner scanner) {
					System.out.println("Choose Destination:");
					displayOptions();
				}
			};
			destinationMenu.display(scanner);
			selectedIndex = destinationMenu.getOptionChoice(scanner) - 1;
			String destinationId = airports.get(selectedIndex).getId();

			newFlight.setRoute(service.readRouteByAirports(originId, destinationId));

			// Get Airplane
			List<Airplane> airplanes = service.readAllAirplanes();
			options.clear();
			airplanes.forEach(airplane -> options
					.add("Id: " + airplane.getId() + ", Max Capacity: " + airplane.getType().getMaxCapacity()));
			Menu airplaneMenu = new Menu(options) {
				@Override
				public void display(Scanner scanner) {
					System.out.println("Choose Airplane:");
					displayOptions();
				}
			};
			airplaneMenu.display(scanner);
			selectedIndex = airplaneMenu.getOptionChoice(scanner) - 1;
			Airplane airplane = airplanes.get(selectedIndex);

			newFlight.setAirplane(airplane);

			// Get Departure Date
			System.out.print("Departure Date (yyyy-mm-dd): ");
			scanner.nextLine();
			LocalDate departureDate = LocalDate.parse(scanner.nextLine());

			// Get Departure Time
			System.out.print("Departure Time (hh:mm:ss): ");
			LocalTime departureTime = LocalTime.parse(scanner.nextLine());

			newFlight.setDepartureTime(LocalDateTime.of(departureDate, departureTime));

			// Get Reserved Seats
			newFlight.setReservedSeats(0);

			// Get Seat Price
			System.out.print("Seat Price: ");
			Float seatPrice = scanner.nextFloat();
			newFlight.setSeatPrice(seatPrice);

			// Add Flight
			System.out.println(service.addFlight(newFlight));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Could not add flight");
		} finally {
			System.out.println();
			new FlightsMenu().display(scanner);
		}
	}

}