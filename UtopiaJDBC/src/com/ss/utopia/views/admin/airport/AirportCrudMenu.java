/**
 * 
 */
package com.ss.utopia.views.admin.airport;

import java.util.Arrays;
import java.util.Scanner;

import com.ss.utopia.entity.Airport;
import com.ss.utopia.views.Menu;

/**
 * @author marvin
 *
 */
public class AirportCrudMenu extends Menu {

	private Airport airport;

	public AirportCrudMenu(Airport airport) {
		super(Arrays.asList("Read Airport", "Update Airport", "Delete Airport", "Quit to previous"));
		this.airport = airport;
	}

	@Override
	public void display(Scanner scanner) {
		System.out.println("You have chosen the Airport with Airport Id: " + airport.getId());
		displayOptions();
		Integer input = getOptionChoice(scanner);

		switch (input) {
		case 1:
			new ReadAirportView(airport).display(scanner);
			break;
		case 2:
			new UpdateAirportView(airport).display(scanner);
			break;
		case 3:
			new DeleteAirportView(airport).display(scanner);
			break;
		case 4:
			new AirportsMenu().display(scanner);;
		default:
			break;
		}
	}

}
