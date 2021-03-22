/**
 * 
 */
package com.ss.utopia.views.traveler;

import java.sql.SQLException;
import java.util.Scanner;

import com.ss.utopia.entity.User;
import com.ss.utopia.service.TravelerService;
import com.ss.utopia.views.View;

/**
 * @author marvin
 *
 */
public class LoginView implements View {

	public void display(Scanner scanner) {
		System.out.println("Enter your Login");
		scanner.nextLine();
		
		TravelerService service = new TravelerService();
		
		while (true) {
			System.out.print("Username: ");
			String username = scanner.nextLine();
			System.out.print("Password: ");
			String password = scanner.nextLine();
			System.out.println();
			
			try {
				User user = service.readUserByLogin(username, password);
				if (user != null) {
					new TravelerMenu(user).display(scanner);
					break;
				} else {
					System.out.println("Incorrect username or password.");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}