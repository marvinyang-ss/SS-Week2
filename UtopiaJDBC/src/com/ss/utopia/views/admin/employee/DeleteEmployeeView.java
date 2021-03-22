/**
 * 
 */
package com.ss.utopia.views.admin.employee;

import java.sql.SQLException;
import java.util.Scanner;

import com.ss.utopia.entity.User;
import com.ss.utopia.service.AdminService;
import com.ss.utopia.views.View;

/**
 * @author marvin
 *
 */
public class DeleteEmployeeView implements View {

	private User employee;
	
	public DeleteEmployeeView(User employee) {
		this.employee = employee;
	}

	@Override
	public void display(Scanner scanner) {
		AdminService service = new AdminService();
		
		try {
			System.out.println(service.deleteUser(employee));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println();

		new EmployeesMenu().display(scanner);
	}

}