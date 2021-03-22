/**
 * 
 */
package com.ss.utopia.views.admin.traveler;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.ss.utopia.entity.User;
import com.ss.utopia.service.AdminService;
import com.ss.utopia.views.Menu;
import com.ss.utopia.views.admin.AdminMenu;

/**
 * @author marvin
 *
 */
public class TravelersMenu extends Menu {
	
	private List<User> travelers;
	
	public TravelersMenu() {
		AdminService service = new AdminService();
		try {
			travelers = service.readAllUsers();
			travelers = travelers.stream().filter(user -> user.getRole().getName().equals("user")).collect(Collectors.toList());
			travelers.forEach(traveler -> options.add("Traveler Id: " + traveler.getId() + ", Name: " + traveler.getGivenName() + " " + traveler.getFamilyName()));
			options.add("Add Traveler");
			options.add("Quit to previous");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void display(Scanner scanner) {
		System.out.println("Choose a traveler to manage");
		displayOptions();
		Integer input = getOptionChoice(scanner);
		
		if (input < options.size()-1) {
			new TravelerCrudMenu(travelers.get(input-1)).display(scanner);
		} else if (input == options.size()-1) {
			new AddTravelerView().display(scanner);;
		} else {
			new AdminMenu().display(scanner);
		}
	}

}