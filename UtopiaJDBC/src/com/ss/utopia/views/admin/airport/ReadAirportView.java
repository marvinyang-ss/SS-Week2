/**
 * 
 */
package com.ss.utopia.views.admin.airport;

import java.util.Scanner;

import com.ss.utopia.entity.Airport;
import com.ss.utopia.views.View;

/**
 * @author marvin
 *
 */
public class ReadAirportView implements View {

	private Airport airport;
	
	public ReadAirportView(Airport airport) {
		this.airport = airport;
	}

	@Override
	public void display(Scanner scanner) {
		System.out.println("Iata Id: " + airport.getId());
		System.out.println("City: " + airport.getCity());
		System.out.println("\nPress 'Enter' to return to previous menu");
		scanner.nextLine();
		scanner.nextLine();

		new AirportCrudMenu(airport).display(scanner);
	}

}