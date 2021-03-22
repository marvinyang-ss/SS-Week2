/**
 * 
 */
package com.ss.utopia.views;

import java.util.Arrays;
import java.util.Scanner;

import com.ss.utopia.views.admin.AdminMenu;
import com.ss.utopia.views.employee.Employee1Menu;
import com.ss.utopia.views.traveler.LoginView;

/**
 * @author marvin
 *
 */
public class MainMenu extends Menu {

	public MainMenu() {
		super(Arrays.asList("Employee", "Administrator", "Traveler"));
	}

	@Override
	public void display(Scanner scanner) {
		System.out.println("Welcome to the Utopia Airlines Management System. Which category of a user are you?");
		displayOptions();
		Integer optionChoice = getOptionChoice(scanner);
		
		switch (optionChoice) {
			case 1:
				new Employee1Menu().display(scanner);
				break;
			case 2:
				new AdminMenu().display(scanner);
				break;
			case 3:
				new LoginView().display(scanner);
				break;
			default:
				System.out.println("Error: input value does not match any options");
				break;
		}
	}

}