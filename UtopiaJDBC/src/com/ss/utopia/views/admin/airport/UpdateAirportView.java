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
public class UpdateAirportView implements View {
	
	private Airport airport;
	
	public UpdateAirportView(Airport airport) {
		this.airport = airport;
	}

	@Override
	public void display(Scanner scanner) {
		AdminService service = new AdminService();

		try {
			// Get City
			System.out.print("City: ");
			scanner.nextLine();
			airport.setCity(scanner.nextLine());

			// Add Airport
			System.out.println(service.updateAirport(airport));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Could not update airport");
		} finally {
			System.out.println();
			new AirportsMenu().display(scanner);
		}
	}

}