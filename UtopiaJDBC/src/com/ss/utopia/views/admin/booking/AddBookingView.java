/**
 * 
 */
package com.ss.utopia.views.admin.booking;

import java.util.Arrays;
import java.util.Scanner;

import com.ss.utopia.entity.Booking;
import com.ss.utopia.service.AdminService;
import com.ss.utopia.views.Menu;
import com.ss.utopia.views.View;

/**
 * @author marvin
 *
 */
public class AddBookingView implements View {

	@Override
	public void display(Scanner scanner) {
		AdminService service = new AdminService();

		Booking newBooking = new Booking();

		try {
			// Get Id
			newBooking.setId(null);

			// Get IsActive
			Menu isActiveMenu = new Menu(Arrays.asList("True", "False")) {
				@Override
				public void display(Scanner scanner) {
					System.out.println("Set Active:");
					displayOptions();
				}
			};
			isActiveMenu.display(scanner);
			Integer selectedIndex = isActiveMenu.getOptionChoice(scanner);
			if (selectedIndex == 1) {
				newBooking.setIsActive(true);
			} else {
				newBooking.setIsActive(false);
			}
			
			// Get Confirmation Code
			StringBuilder confirmationCode = new StringBuilder();
			for (int i = 0; i < 10; i++) {
				confirmationCode.append((int)(Math.random()*10));
			}
			newBooking.setConfirmationCode(confirmationCode.toString());

			// Add Booking
			System.out.println(service.addBooking(newBooking));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Could not add booking");
		} finally {
			System.out.println();
			new BookingsMenu().display(scanner);
		}
	}

}