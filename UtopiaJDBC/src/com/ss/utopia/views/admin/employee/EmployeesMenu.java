/**
 * 
 */
package com.ss.utopia.views.admin.employee;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.ss.utopia.entity.User;
import com.ss.utopia.service.AdminService;
import com.ss.utopia.views.Menu;
import com.ss.utopia.views.admin.AdminMenu;

/**
 * @author marvin
 *
 */
public class EmployeesMenu extends Menu {
	
	private List<User> employees;
	
	public EmployeesMenu() {
		AdminService service = new AdminService();
		try {
			employees = service.readAllUsers();
			employees = employees.stream().filter(user -> user.getRole().getName().equals("agent")).collect(Collectors.toList());
			employees.forEach(employee -> options.add("Employee Id: " + employee.getId() + ", Name: " + employee.getGivenName() + " " + employee.getRole().getName()));
			options.add("Add Employee");
			options.add("Quit to previous");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void display(Scanner scanner) {
		System.out.println("Choose an employee to manage");
		displayOptions();
		Integer input = getOptionChoice(scanner);
		
		if (input < options.size()-1) {
			new EmployeeCrudMenu(employees.get(input-1)).display(scanner);
		} else if (input == options.size()-1) {
			new AddEmployeeView().display(scanner);;
		} else {
			new AdminMenu().display(scanner);
		}
	}

}