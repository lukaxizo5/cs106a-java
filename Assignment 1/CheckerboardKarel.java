/* File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 */

import stanford.karel.*;

public class CheckerboardKarel extends SuperKarel {

	public void run() {
		draw();
	}
	/*
	 * Karel draws the checkerboard.
	 * pre: Karel is at 1x1.
	 * post: Karel has drawn the checkerboard successfully.
	 */
	private void draw() {
		fillOddRow();
		while(leftIsClear()){
			goToTheNextRow();
			fillEvenRow();
			if (leftIsClear()){
				goToTheNextRow();
				fillOddRow();
			}
		}
	}
	/*
	 * Karel fills the odd numbered rows.
	 * pre: Karel is at the start of the odd numbered row.
	 * post: Karel has filled the odd numbered row.
	 */
	private void fillOddRow() {
		putBeeper();
		while(frontIsClear()){
			if (frontIsClear()){
				move();
			}
			if (frontIsClear()){
				move();
				putBeeper();
			}
		}
	}
	/*
	 * Karel fills the even numbered rows.
	 * pre: Karel is at the start of the even numbered row.
	 * post: Karel has filled the even numbered row.
	 */
	private void fillEvenRow() {
		if(frontIsClear()){
			move();
			putBeeper();
		}
		while(frontIsClear()){
			if (frontIsClear()){
				move();
			}
			if (frontIsClear()){
				move();
				putBeeper();
			}
		}
	}
	/*
	 * Karel goes to the start of the upper row.
	 * pre: Karel is at the end of the filled row.
	 * post: Karel is at the start of the new unfilled row.
	 */
	private void goToTheNextRow() {
		turnAround();
		while(frontIsClear()){
			move();
		}
		turnRight();
		move();
		turnRight();
	}
}

