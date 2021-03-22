/**
 * 
 */
package com.ss.utopia.views.employee;

import java.util.Arrays;
import java.util.Scanner;

import com.ss.utopia.views.MainMenu;
import com.ss.utopia.views.Menu;

/**
 * @author marvin
 *
 */
public class Employee1Menu extends Menu {

	public Employee1Menu() {
		super(Arrays.asList("Enter Flights You Manage", "Quit to previous"));
	}

	@Override
	public void display(Scanner scanner) {
		System.out.println("Employee");
		displayOptions();
		Integer optionChoice = getOptionChoice(scanner);

		switch (optionChoice) {
		case 1:
			new Employee2Menu().display(scanner);
			break;
		case 2:
			new MainMenu().display(scanner);
			break;
		default:
			System.out.println("Error: input value does not match any options");
			break;
		}
	}

}