/*
 * File: FindRange.java
 * Name: 
 * Section Leader: 
 * --------------------
 * This file is the starter file for the FindRange problem.
 */

import acm.program.*;

public class FindRange extends ConsoleProgram {
	private static final int SPECIAL_SYMBOL = 0;

	public void run() {
		println("This program finds the largest and smallest numbers.");
		print("? ");
		int firstNumber = readInt();
		int min = firstNumber;
		int max = firstNumber;
		while (firstNumber == SPECIAL_SYMBOL) {
			println("First number can't be the special symbol. Try again!");
			print("?  ");
			firstNumber = readInt();
			min = firstNumber;
			max = firstNumber;
		}
		while (true) {
			print("? ");
			int number = readInt();
			if (checkSpecialSymbol(number)) {
				break;
			}
			min = updateMin(number, min);
			max = updateMax(number, max);
		}
		println("smallest: " + min);
		println("largest: " + max);
	}
	/*
	 * updates the current max value.
	 */
	private int updateMax(int number, int max) {
		return Math.max(number, max);
	}
	/*
	 * updates the current min value.
	 */
	private int updateMin(int number, int min) {
		return Math.min(number, min);
	}
	/*
	 * checks the equivalence of the given number and the special symbol.
	 */
	private boolean checkSpecialSymbol(int number) {
		return number == SPECIAL_SYMBOL;
	}
}