/**
 * 
 */
package com.ss.utopia.views.admin.traveler;

import java.util.Scanner;

import com.ss.utopia.entity.User;
import com.ss.utopia.views.View;

/**
 * @author marvin
 *
 */
public class ReadTravelerView implements View {

	private User traveler;
	
	public ReadTravelerView(User traveler) {
		this.traveler = traveler;
	}

	@Override
	public void display(Scanner scanner) {
		System.out.println("Traveler Id: " + traveler.getId());
		System.out.println("Role: " + traveler.getRole().getName());
		System.out.println("Given Name: " + traveler.getGivenName());
		System.out.println("Family Name: " + traveler.getFamilyName());
		System.out.println("Username: " + traveler.getUsername());
		System.out.println("Email: " + traveler.getEmail());
		System.out.println("Password: " + traveler.getPassword());
		System.out.println("Phone: " + traveler.getPhone());
		System.out.println("\nPress 'Enter' to return to previous menu");
		scanner.nextLine();
		scanner.nextLine();

		new TravelerCrudMenu(traveler).display(scanner);
	}

}