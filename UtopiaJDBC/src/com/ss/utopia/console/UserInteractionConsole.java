/**
 * 
 */
package com.ss.utopia.console;

import java.util.Scanner;

import com.ss.utopia.views.*;

/**
 * @author marvin
 *
 */
public class UserInteractionConsole {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		new MainMenu().display(scanner);
	}

}
