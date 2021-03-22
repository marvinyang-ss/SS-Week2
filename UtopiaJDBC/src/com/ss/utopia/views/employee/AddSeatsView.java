/**
 * 
 */
package com.ss.utopia.views.employee;

import java.util.Scanner;

import com.ss.utopia.entity.Flight;
import com.ss.utopia.service.EmployeeService;
import com.ss.utopia.views.View;

/**
 * @author marvin
 *
 */
public class AddSeatsView implements View {
	
	private Flight flight;
	
	public AddSeatsView(Flight flight) {
		this.flight = flight;
	}

	@Override
	public void display(Scanner scanner) {
		EmployeeService service = new EmployeeService();
		System.out.println("Existing number of seats: " + flight.getReservedSeats());
		System.out.print("Enter new number of seats: ");
		try {
			Integer input = scanner.nextInt();
			flight.setReservedSeats(input);
			service.updateFlight(flight);
		} catch (Exception e) {
			System.out.println("Invalid input.\n");
		}
		
		new Employee3Menu(flight).display(scanner);
	}

}
