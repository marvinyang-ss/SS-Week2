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
public class UpdateBookingView implements View {
	
	private Booking booking;
	
	public UpdateBookingView(Booking booking) {
		this.booking = booking;
	}

	@Override
	public void display(Scanner scanner) {
		AdminService service = new AdminService();

		try {
			// Get IsActive
			Menu isActiveMenu = new Menu(Arrays.asList("True", "False", "No change")) {
				@Override
				public void display(Scanner scanner) {
					System.out.println("Set Active:");
					displayOptions();
				}
			};
			isActiveMenu.display(scanner);
			Integer selectedIndex = isActiveMenu.getOptionChoice(scanner);
			if (selectedIndex == 1) {
				booking.setIsActive(true);
			} else if (selectedIndex == 2) {
				booking.setIsActive(false);
			}

			// Add Booking
			System.out.println(service.updateBooking(booking));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Could not update booking");
		} finally {
			System.out.println();
			new BookingsMenu().display(scanner);
		}
	}

}