/**
 * 
 */
package com.ss.utopia.views.admin.booking;

import java.sql.SQLException;
import java.util.Scanner;

import com.ss.utopia.entity.Booking;
import com.ss.utopia.service.AdminService;
import com.ss.utopia.views.View;

/**
 * @author marvin
 *
 */
public class DeleteBookingView implements View {

	private Booking booking;
	
	public DeleteBookingView(Booking booking) {
		this.booking = booking;
	}

	@Override
	public void display(Scanner scanner) {
		AdminService service = new AdminService();
		
		try {
			System.out.println(service.deleteBooking(booking));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println();

		new BookingsMenu().display(scanner);
	}

}