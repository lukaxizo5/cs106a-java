/*
 * File: StoneMasonKarel.java
 * --------------------------
 * The StoneMasonKarel subclass as it appears here does nothing.
 * When you finish writing it, it should solve the "repair the quad"
 * problem from Assignment 1.  In addition to editing the program,
 * you should be sure to edit this comment so that it no longer
 * indicates that the program does nothing.
 */

import stanford.karel.*;

public class StoneMasonKarel extends SuperKarel {

	public void run() {
		while(frontIsClear()){
			fillTheColumn();
			goToStartOfTheColumn();
			moveToTheNextColumn();
		}
		fillTheColumn();
		goToStartOfTheColumn();
	}
	/*
	 * Karel fills the column.
	 * pre: Karel is at the starting location (facing left).
	 * post: Karel has filled the column and is under the ceiling (facing north).
	 */
	private void fillTheColumn() {
		turnLeft();
		while(frontIsClear()){
			if (noBeepersPresent()){
				putBeeper();
			}
			move();
		}
		if (noBeepersPresent()){
			putBeeper();
		}
	}
	/*
	 * Karel goes back to the start of the column he filled.
	 * pre: Karel is under the ceiling (facing north).
	 * post: Karel is back to where he started filling the column (facing left).
	 */
	private void goToStartOfTheColumn() {
		turnAround();
		while(frontIsClear()){
			move();
		}
		turnLeft();
	}
	/*
	 * Karel moves to the next column.
	 * pre: Karel is at the start of the filled column (facing left).
	 * post: Karel has moved to the next column (facing left).
	 */
	private void moveToTheNextColumn() {
		for (int i = 0; i < 4; i++){
			move();
		}
	}
}
