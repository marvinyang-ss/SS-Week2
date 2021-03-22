/**
 * 
 */
package com.ss.utopia.views.admin.passenger;

import java.util.Arrays;
import java.util.Scanner;

import com.ss.utopia.entity.Passenger;
import com.ss.utopia.views.Menu;

/**
 * @author marvin
 *
 */
public class PassengerCrudMenu extends Menu {

	private Passenger passenger;

	public PassengerCrudMenu(Passenger passenger) {
		super(Arrays.asList("Read Passenger", "Update Passenger", "Delete Passenger", "Quit to previous"));
		this.passenger = passenger;
	}

	@Override
	public void display(Scanner scanner) {
		System.out.println("You have chosen the Passenger with Passenger Id: " + passenger.getId());
		displayOptions();
		Integer input = getOptionChoice(scanner);

		switch (input) {
		case 1:
			new ReadPassengerView(passenger).display(scanner);
			break;
		case 2:
			new UpdatePassengerView(passenger).display(scanner);
			break;
		case 3:
			new DeletePassengerView(passenger).display(scanner);
			break;
		case 4:
			new PassengersMenu().display(scanner);;
		default:
			break;
		}
	}

}
