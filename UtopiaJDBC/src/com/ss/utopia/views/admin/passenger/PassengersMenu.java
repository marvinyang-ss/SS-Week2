/**
 * 
 */
package com.ss.utopia.views.admin.passenger;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.ss.utopia.entity.Passenger;
import com.ss.utopia.service.AdminService;
import com.ss.utopia.views.Menu;
import com.ss.utopia.views.admin.AdminMenu;

/**
 * @author marvin
 *
 */
public class PassengersMenu extends Menu {
	
	private List<Passenger> passengers;
	
	public PassengersMenu() {
		AdminService service = new AdminService();
		try {
			passengers = service.readAllPassengers();
			passengers.forEach(passenger -> options.add("Id: " + passenger.getId() + ", Name: " + passenger.getGivenName() + " " + passenger.getFamilyName()));
			options.add("Add Passenger");
			options.add("Quit to previous");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void display(Scanner scanner) {
		System.out.println("Choose a passenger to manage");
		displayOptions();
		Integer input = getOptionChoice(scanner);
		
		if (input < options.size()-1) {
			new PassengerCrudMenu(passengers.get(input-1)).display(scanner);
		} else if (input == options.size()-1) {
			new AddPassengerView().display(scanner);;
		} else {
			new AdminMenu().display(scanner);
		}
	}

}