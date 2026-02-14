/*
 * File: Hailstone.java
 * Name: 
 * Section Leader: 
 * --------------------
 * This file is the starter file for the Hailstone problem.
 */

import acm.program.*;

public class Hailstone extends ConsoleProgram {
	
	public void run() {
		int n = readInt("Enter a natural number: ");
		n = edgeCase(n);
		printCount(findNumberOfOperations(n));
	}
	/*
	 * forces client to input a natural number.
	 * returns the given natural input. 
	 */
	private int edgeCase(int n) {
		while (n < 1) {
			print("You should enter a natural number! Try again: ");
			n = readInt();
		}
		return n;
	}
	/*
	 * returns the number of operations needed to reach 1.
	 * in the process it also prints everything that is displayed on the console.
	 */
	private int findNumberOfOperations(int n) {
		int count = 0;
		while (n > 1) {
			count++;
			if (isEven(n)) {
				evenPrint(n);
				n = evenCase(n);
			}
			else {
				oddPrint(n);
				n = oddCase(n);
			}
		}
		return count;
	}
	/*
	 * returns half value of an even number.
	 */
	private int evenCase(int n) {
		return n / 2;
	}
	/*
	 * returns triple + 1 of an odd number.
	 */
	private int oddCase(int n) {
		return 3 * n +1;
	}
	/*
	 * prints the message for an even number.
	 */
	private void evenPrint(int n) {
		println(n+" is even, so I take half: " + n / 2);
	}
	/*
	 * prints the message for an odd number.
	 */
	private void oddPrint(int n) {
		println(n+" is odd, so I make 3n + 1: " + (n * 3 + 1));
	}
	/*
	 * prints the number of operations needed to reach 1.
	 */
	private void printCount(int count) {
		println("The process took " + count + " operations to reach 1");
	}
	/*
	 * checks the evenness of an integer.
	 */
	private boolean isEven(int n) {
		return n % 2 == 0;
	}
}