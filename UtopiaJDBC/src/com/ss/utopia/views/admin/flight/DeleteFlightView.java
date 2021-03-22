/**
 * 
 */
package com.ss.utopia.views.admin.flight;

import java.sql.SQLException;
import java.util.Scanner;

import com.ss.utopia.entity.Flight;
import com.ss.utopia.service.AdminService;
import com.ss.utopia.views.View;

/**
 * @author marvin
 *
 */
public class DeleteFlightView implements View {

	private Flight flight;
	
	public DeleteFlightView(Flight flight) {
		this.flight = flight;
	}

	@Override
	public void display(Scanner scanner) {
		AdminService service = new AdminService();
		
		try {
			System.out.println(service.deleteFlight(flight));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println();

		new FlightsMenu().display(scanner);
	}

}