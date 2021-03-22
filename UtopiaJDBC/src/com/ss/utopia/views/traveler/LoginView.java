/**
 * 
 */
package com.ss.utopia.views.traveler;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;

import com.ss.utopia.entity.User;
import com.ss.utopia.service.TravelerService;
import com.ss.utopia.views.MainMenu;
import com.ss.utopia.views.Menu;
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
			
			Menu tryAgainMenu = new Menu(Arrays.asList("Yes", "No")) {
				@Override
				public void display(Scanner scanner) {
					System.out.println("Try Again?");
					displayOptions();
				}
			};
			tryAgainMenu.display(scanner);
			Integer input = tryAgainMenu.getOptionChoice(scanner);
			if (input == 2) {
				new MainMenu().display(scanner);
				break;
			} else {
				scanner.nextLine();
			}
		}
	}
	
}