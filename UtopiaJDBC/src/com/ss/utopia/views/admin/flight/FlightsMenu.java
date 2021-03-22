/**
 * 
 */
package com.ss.utopia.views.admin.flight;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.ss.utopia.entity.Flight;
import com.ss.utopia.entity.Route;
import com.ss.utopia.service.AdminService;
import com.ss.utopia.views.Menu;
import com.ss.utopia.views.admin.AdminMenu;

/**
 * @author marvin
 *
 */
public class FlightsMenu extends Menu {
	
	private List<Flight> flights;
	
	public FlightsMenu() {
		AdminService service = new AdminService();
		try {
			flights = service.readAllFlights();
			flights.forEach(flight -> {
				Route route = flight.getRoute();
				options.add(route.getOrigin().getId() + ", " + route.getOrigin().getCity() 
						+ " -> " + route.getDestination().getId() + ", " + route.getDestination().getCity());
			});
			options.add("Add Flight");
			options.add("Quit to previous");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void display(Scanner scanner) {
		System.out.println("Choose a flight to manage");
		displayOptions();
		Integer input = getOptionChoice(scanner);
		
		if (input < options.size()-1) {
			new FlightCrudMenu(flights.get(input-1)).display(scanner);
		} else if (input == options.size()-1) {
			new AddFlightView().display(scanner);;
		} else {
			new AdminMenu().display(scanner);
		}
	}

}
