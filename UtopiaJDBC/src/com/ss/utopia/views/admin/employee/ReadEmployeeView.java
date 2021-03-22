/**
 * 
 */
package com.ss.utopia.views.admin.employee;

import java.util.Scanner;

import com.ss.utopia.entity.User;
import com.ss.utopia.views.View;

/**
 * @author marvin
 *
 */
public class ReadEmployeeView implements View {

	private User employee;
	
	public ReadEmployeeView(User employee) {
		this.employee = employee;
	}

	@Override
	public void display(Scanner scanner) {
		System.out.println("Employee Id: " + employee.getId());
		System.out.println("Role: " + employee.getRole().getName());
		System.out.println("Given Name: " + employee.getGivenName());
		System.out.println("Family Name: " + employee.getFamilyName());
		System.out.println("Username: " + employee.getUsername());
		System.out.println("Email: " + employee.getEmail());
		System.out.println("Password: " + employee.getPassword());
		System.out.println("Phone: " + employee.getPhone());
		System.out.println("\nPress 'Enter' to return to previous menu");
		scanner.nextLine();
		scanner.nextLine();

		new EmployeeCrudMenu(employee).display(scanner);
	}

}