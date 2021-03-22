/**
 * 
 */
package com.ss.utopia.views.employee;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ss.utopia.entity.Flight;
import com.ss.utopia.entity.Route;
import com.ss.utopia.service.EmployeeService;
import com.ss.utopia.views.Menu;

/**
 * @author marvin
 *
 */
public class Employee2Menu extends Menu {
	
	private List<Flight> flights;

	public Employee2Menu() {
		EmployeeService service = new EmployeeService();
		try {
			// Read flights
			flights = service.readAllFlights();
			
			// Get routes
			List<Route> routes = new ArrayList<>();
			flights.forEach(flight -> routes.add(flight.getRoute()));
			
			// Get options
			routes.forEach(route -> options.add(route.getOrigin().getId() + ", " + route.getOrigin().getCity() 
					+ " -> " + route.getDestination().getId() + ", " + route.getDestination().getCity()));
			options.add("Quit to previous");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void display(Scanner scanner) {
		
		System.out.println("Choose a flight to manage");
		displayOptions();
		Integer optionChoice = getOptionChoice(scanner);

		if (optionChoice < options.size()) {
			new Employee3Menu(flights.get(optionChoice-1)).display(scanner);
		} else {
			new Employee1Menu().display(scanner);
		}
	}

}