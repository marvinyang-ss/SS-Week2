/**
 * 
 */
package com.ss.utopia.views.admin.passenger;

import java.sql.SQLException;
import java.util.Scanner;

import com.ss.utopia.entity.Passenger;
import com.ss.utopia.service.AdminService;
import com.ss.utopia.views.View;

/**
 * @author marvin
 *
 */
public class DeletePassengerView implements View {

	private Passenger passenger;
	
	public DeletePassengerView(Passenger passenger) {
		this.passenger = passenger;
	}

	@Override
	public void display(Scanner scanner) {
		AdminService service = new AdminService();
		
		try {
			System.out.println(service.deletePassenger(passenger));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println();

		new PassengersMenu().display(scanner);
	}

}