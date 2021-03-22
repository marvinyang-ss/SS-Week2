/**
 * 
 */
package com.ss.utopia.views;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author marvin
 *
 */
public abstract class Menu implements View {

	protected List<String> options;
	
	public Menu() {
		this.options = new ArrayList<String>();
	}
	
	public Menu(List<String> options) {
		this.options = options;
	}
	
	public abstract void display(Scanner scanner);
	
	public void displayOptions() {
		for (int i = 0; i < options.size(); i++) {
			System.out.println((i+1) + ") " + options.get(i));
		}
	}
	
	public Integer getOptionChoice(Scanner scanner) {
		Integer input = null;
		
		while (true) {
			try {
				System.out.print("> ");
				input = scanner.nextInt();
				if (input < 1 || input > options.size()) {
					System.out.println("Invalid input!");
					scanner.nextLine();
					continue;
				}
				System.out.println();
				return input;
			} catch (Exception e) {
				System.out.println("Invalid input!");
				scanner.nextLine();
			}
		}
	}

	public List<String> getOptions() {
		return options;
	}

	public void setOptions(List<String> options) {
		this.options = options;
	}
	
}
