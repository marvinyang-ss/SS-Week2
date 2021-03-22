/**
 * 
 */
package com.ss.utopia.views.admin.traveler;

import java.sql.SQLException;
import java.util.Scanner;

import com.ss.utopia.entity.User;
import com.ss.utopia.service.AdminService;
import com.ss.utopia.views.View;

/**
 * @author marvin
 *
 */
public class DeleteTravelerView implements View {

	private User traveler;
	
	public DeleteTravelerView(User traveler) {
		this.traveler = traveler;
	}

	@Override
	public void display(Scanner scanner) {
		AdminService service = new AdminService();
		
		try {
			System.out.println(service.deleteUser(traveler));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println();

		new TravelersMenu().display(scanner);
	}

}