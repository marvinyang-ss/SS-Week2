/**
 * 
 */
package com.ss.utopia.views.admin.employee;

import java.util.Scanner;

import com.ss.utopia.entity.User;
import com.ss.utopia.service.AdminService;
import com.ss.utopia.views.View;

/**
 * @author marvin
 *
 */
public class AddEmployeeView implements View {

	@Override
	public void display(Scanner scanner) {
		AdminService service = new AdminService();

		User newEmployee = new User();

		try {
			// Get Id
			newEmployee.setId(null);

			// Get Role
			newEmployee.setRole(service.readUserRole("agent"));
			
			// Get Given Name
			System.out.print("First name: ");
			scanner.nextLine();
			newEmployee.setGivenName(scanner.nextLine());
			
			// Get Family Name
			System.out.print("Last name: ");
			newEmployee.setFamilyName(scanner.nextLine());
			
			// Get Username
			System.out.print("Username: ");
			newEmployee.setUsername(scanner.nextLine());
			
			// Get Email
			System.out.print("Email: ");
			newEmployee.setEmail(scanner.nextLine());
			
			// Get Password
			System.out.print("Password: ");
			newEmployee.setPassword(scanner.nextLine());
			
			// Get Phone
			System.out.print("Phone: ");
			newEmployee.setPhone(scanner.nextLine());
			
			// Add Employee
			System.out.println(service.addUser(newEmployee));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Could not add employee");
		} finally {
			System.out.println();
			new EmployeesMenu().display(scanner);
		}
	}

}