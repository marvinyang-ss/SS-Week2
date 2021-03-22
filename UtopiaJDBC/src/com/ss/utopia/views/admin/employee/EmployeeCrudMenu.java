/**
 * 
 */
package com.ss.utopia.views.admin.employee;

import java.util.Arrays;
import java.util.Scanner;

import com.ss.utopia.entity.User;
import com.ss.utopia.views.Menu;

/**
 * @author marvin
 *
 */
public class EmployeeCrudMenu extends Menu {

	private User employee;

	public EmployeeCrudMenu(User employee) {
		super(Arrays.asList("Read Employee", "Update Employee", "Delete Employee", "Quit to previous"));
		this.employee = employee;
	}

	@Override
	public void display(Scanner scanner) {
		System.out.println("You have chosen the Employee with Employee Id: " + employee.getId());
		displayOptions();
		Integer input = getOptionChoice(scanner);

		switch (input) {
		case 1:
			new ReadEmployeeView(employee).display(scanner);
			break;
		case 2:
			new UpdateEmployeeView(employee).display(scanner);
			break;
		case 3:
			new DeleteEmployeeView(employee).display(scanner);
			break;
		case 4:
			new EmployeesMenu().display(scanner);;
		default:
			break;
		}
	}

}
