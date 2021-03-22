/**
 * 
 */
package com.ss.utopia.views.admin.airport;

import java.util.Scanner;

import com.ss.utopia.entity.Airport;
import com.ss.utopia.service.AdminService;
import com.ss.utopia.views.View;

/**
 * @author marvin
 *
 */
public class AddAirportView implements View {

	@Override
	public void display(Scanner scanner) {
		AdminService service = new AdminService();

		Airport newAirport = new Airport();

		try {
			// Get Id
			System.out.print("Iata Id: ");
			scanner.nextLine();
			newAirport.setId(scanner.nextLine());

			// Get City
			System.out.print("City: ");
			newAirport.setCity(scanner.nextLine());

			// Add Airport
			System.out.println(service.addAirport(newAirport));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Could not add airport");
		} finally {
			System.out.println();
			new AirportsMenu().display(scanner);
		}
	}

}