/**
 * 
 */
package com.ss.utopia.views.admin.traveler;

import java.util.Arrays;
import java.util.Scanner;

import com.ss.utopia.entity.User;
import com.ss.utopia.views.Menu;

/**
 * @author marvin
 *
 */
public class TravelerCrudMenu extends Menu {

	private User traveler;

	public TravelerCrudMenu(User traveler) {
		super(Arrays.asList("Read Traveler", "Update Traveler", "Delete Traveler", "Quit to previous"));
		this.traveler = traveler;
	}

	@Override
	public void display(Scanner scanner) {
		System.out.println("You have chosen the Traveler with Traveler Id: " + traveler.getId());
		displayOptions();
		Integer input = getOptionChoice(scanner);

		switch (input) {
		case 1:
			new ReadTravelerView(traveler).display(scanner);
			break;
		case 2:
			new UpdateTravelerView(traveler).display(scanner);
			break;
		case 3:
			new DeleteTravelerView(traveler).display(scanner);
			break;
		case 4:
			new TravelersMenu().display(scanner);;
		default:
			break;
		}
	}

}
