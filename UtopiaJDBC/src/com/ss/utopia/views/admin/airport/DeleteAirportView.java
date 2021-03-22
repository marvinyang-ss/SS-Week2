/**
 * 
 */
package com.ss.utopia.views.admin.airport;

import java.sql.SQLException;
import java.util.Scanner;

import com.ss.utopia.entity.Airport;
import com.ss.utopia.service.AdminService;
import com.ss.utopia.views.View;

/**
 * @author marvin
 *
 */
public class DeleteAirportView implements View {

	private Airport airport;
	
	public DeleteAirportView(Airport airport) {
		this.airport = airport;
	}

	@Override
	public void display(Scanner scanner) {
		AdminService service = new AdminService();
		
		try {
			System.out.println(service.deleteAirport(airport));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println();

		new AirportsMenu().display(scanner);
	}

}