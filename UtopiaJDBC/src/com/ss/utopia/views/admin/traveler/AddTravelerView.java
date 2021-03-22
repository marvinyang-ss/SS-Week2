/**
 * 
 */
package com.ss.utopia.views.admin.traveler;

import java.util.Scanner;

import com.ss.utopia.entity.User;
import com.ss.utopia.service.AdminService;
import com.ss.utopia.views.View;

/**
 * @author marvin
 *
 */
public class AddTravelerView implements View {

	@Override
	public void display(Scanner scanner) {
		AdminService service = new AdminService();

		User newTraveler = new User();

		try {
			// Get Id
			newTraveler.setId(null);

			// Get Role
			newTraveler.setRole(service.readUserRole("user"));
			
			// Get Given Name
			System.out.print("First name: ");
			scanner.nextLine();
			newTraveler.setGivenName(scanner.nextLine());
			
			// Get Family Name
			System.out.print("Last name: ");
			newTraveler.setFamilyName(scanner.nextLine());
			
			// Get Username
			System.out.print("Username: ");
			newTraveler.setUsername(scanner.nextLine());
			
			// Get Email
			System.out.print("Email: ");
			newTraveler.setEmail(scanner.nextLine());
			
			// Get Password
			System.out.print("Password: ");
			newTraveler.setPassword(scanner.nextLine());
			
			// Get Phone
			System.out.print("Phone: ");
			newTraveler.setPhone(scanner.nextLine());
			
			// Add Traveler
			System.out.println(service.addUser(newTraveler));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Could not add traveler");
		} finally {
			System.out.println();
			new TravelersMenu().display(scanner);
		}
	}

}