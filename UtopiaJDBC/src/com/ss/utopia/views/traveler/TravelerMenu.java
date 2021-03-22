/**
 * 
 */
package com.ss.utopia.views.traveler;

import java.util.Arrays;
import java.util.Scanner;

import com.ss.utopia.entity.User;
import com.ss.utopia.views.MainMenu;
import com.ss.utopia.views.Menu;

/**
 * @author marvin
 *
 */
public class TravelerMenu extends Menu {

	private User user;
	
	public TravelerMenu(User user) {
		super(Arrays.asList("Book a Ticket", "Cancel an Upcoming Trip", "Quit to previous"));
		this.user = user;
	}

	@Override
	public void display(Scanner scanner) {
		System.out.println("You are logged in.");
		displayOptions();
		Integer input = getOptionChoice(scanner);

		switch (input) {
		case 1:
			new BookTicketMenu(user).display(scanner);
			break;
		case 2:
			new CancelTripMenu(user).display(scanner);
			break;
		case 3:
			new MainMenu().display(scanner);
			break;
		default:
			break;

		}
	}

}
