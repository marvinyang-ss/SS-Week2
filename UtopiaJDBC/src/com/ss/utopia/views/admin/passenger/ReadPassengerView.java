/**
 * 
 */
package com.ss.utopia.views.admin.passenger;

import java.util.Scanner;

import com.ss.utopia.entity.Passenger;
import com.ss.utopia.views.View;

/**
 * @author marvin
 *
 */
public class ReadPassengerView implements View {

	private Passenger passenger;
	
	public ReadPassengerView(Passenger passenger) {
		this.passenger = passenger;
	}

	@Override
	public void display(Scanner scanner) {
		System.out.println("Passenger Id: " + passenger.getId());
		System.out.println("Booking Id: " + passenger.getBooking().getId());
		System.out.println("Given Name: " + passenger.getGivenName());
		System.out.println("Family Name: " + passenger.getFamilyName());
		System.out.println("Date of Birth: " + passenger.getDateOfBirth());
		System.out.println("Gender: " + passenger.getGender());
		System.out.println("Address: " + passenger.getAddress());
		System.out.println("\nPress 'Enter' to return to previous menu");
		scanner.nextLine();
		scanner.nextLine();

		new PassengerCrudMenu(passenger).display(scanner);
	}

}