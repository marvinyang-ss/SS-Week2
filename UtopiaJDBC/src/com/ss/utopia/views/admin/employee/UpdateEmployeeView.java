/**
 * 
 */
package com.ss.utopia.views.admin.employee;

import java.util.Arrays;
import java.util.Scanner;

import com.ss.utopia.entity.User;
import com.ss.utopia.service.AdminService;
import com.ss.utopia.views.Menu;
import com.ss.utopia.views.View;

/**
 * @author marvin
 *
 */
public class UpdateEmployeeView implements View {
	
	private User employee;
	
	public UpdateEmployeeView(User employee) {
		this.employee = employee;
	}

	@Override
	public void display(Scanner scanner) {
		AdminService service = new AdminService();

		try {
			// Get Given Name
			Menu givenNameMenu = new Menu(Arrays.asList("Yes", "No")) {
				@Override
				public void display(Scanner scanner) {
					System.out.println("Change first name?");
					displayOptions();
				}
			};
			givenNameMenu.display(scanner);
			Integer selectedIndex = givenNameMenu.getOptionChoice(scanner);
			if (selectedIndex == 1) {
				System.out.print("First name: ");
				scanner.nextLine();
				employee.setGivenName(scanner.nextLine());
			}
			
			// Get Family Name
			Menu familyNameMenu = new Menu(Arrays.asList("Yes", "No")) {
				@Override
				public void display(Scanner scanner) {
					System.out.println("Change last name?");
					displayOptions();
				}
			};
			familyNameMenu.display(scanner);
			selectedIndex = familyNameMenu.getOptionChoice(scanner);
			if (selectedIndex == 1) {
				System.out.print("Last name: ");
				scanner.nextLine();
				employee.setFamilyName(scanner.nextLine());
			}
			
			// Get Username
			Menu usernameMenu = new Menu(Arrays.asList("Yes", "No")) {
				@Override
				public void display(Scanner scanner) {
					System.out.println("Change username?");
					displayOptions();
				}
			};
			usernameMenu.display(scanner);
			selectedIndex = usernameMenu.getOptionChoice(scanner);
			if (selectedIndex == 1) {
				System.out.print("Username: ");
				scanner.nextLine();
				employee.setUsername(scanner.nextLine());
			}
			
			// Get Email
			Menu emailMenu = new Menu(Arrays.asList("Yes", "No")) {
				@Override
				public void display(Scanner scanner) {
					System.out.println("Change email?");
					displayOptions();
				}
			};
			emailMenu.display(scanner);
			selectedIndex = emailMenu.getOptionChoice(scanner);
			if (selectedIndex == 1) {
				System.out.print("Email: ");
				scanner.nextLine();
				employee.setEmail(scanner.nextLine());
			}
			
			// Get Password
			Menu passwordMenu = new Menu(Arrays.asList("Yes", "No")) {
				@Override
				public void display(Scanner scanner) {
					System.out.println("Change password?");
					displayOptions();
				}
			};
			passwordMenu.display(scanner);
			selectedIndex = passwordMenu.getOptionChoice(scanner);
			if (selectedIndex == 1) {
				System.out.print("Password: ");
				scanner.nextLine();
				employee.setPassword(scanner.nextLine());
			}
			
			// Get Phone
			Menu phoneMenu = new Menu(Arrays.asList("Yes", "No")) {
				@Override
				public void display(Scanner scanner) {
					System.out.println("Change phone?");
					displayOptions();
				}
			};
			phoneMenu.display(scanner);
			selectedIndex = phoneMenu.getOptionChoice(scanner);
			if (selectedIndex == 1) {
				System.out.print("Phone: ");
				scanner.nextLine();
				employee.setPhone(scanner.nextLine());
			}
			
			// Add Employee
			System.out.println(service.updateUser(employee));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Could not update employee");
		} finally {
			System.out.println();
			new EmployeesMenu().display(scanner);
		}
	}

}