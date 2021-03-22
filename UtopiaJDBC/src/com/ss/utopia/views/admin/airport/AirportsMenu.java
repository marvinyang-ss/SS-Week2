/**
 * 
 */
package com.ss.utopia.views.admin.airport;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.ss.utopia.entity.Airport;
import com.ss.utopia.service.AdminService;
import com.ss.utopia.views.Menu;
import com.ss.utopia.views.admin.AdminMenu;

/**
 * @author marvin
 *
 */
public class AirportsMenu extends Menu {
	
	private List<Airport> airports;
	
	public AirportsMenu() {
		AdminService service = new AdminService();
		try {
			airports = service.readAllAirports();
			airports.forEach(airport -> options.add("Id: " + airport.getId() + ", City: " + airport.getCity()));
			options.add("Add Airport");
			options.add("Quit to previous");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void display(Scanner scanner) {
		System.out.println("Choose an airport to manage");
		displayOptions();
		Integer input = getOptionChoice(scanner);
		
		if (input < options.size()-1) {
			new AirportCrudMenu(airports.get(input-1)).display(scanner);
		} else if (input == options.size()-1) {
			new AddAirportView().display(scanner);;
		} else {
			new AdminMenu().display(scanner);
		}
	}

}