/*
 * File: MidpointFindingKarel.java
 * -------------------------------
 * When you finish writing it, the MidpointFindingKarel class should
 * leave a beeper on the corner closest to the center of 1st Street
 * (or either of the two central corners if 1st Street has an even
 * number of corners).  Karel can put down additional beepers as it
 * looks for the midpoint, but must pick them up again before it
 * stops.  The world may be of any size, but you are allowed to
 * assume that it is at least as tall as it is wide.
 */

import stanford.karel.*;

public class MidpointFindingKarel extends SuperKarel {
 
	public void run() {
		fillFirstRow();
		findTheMidpoint();
		putBeeper();
	}
	/*
	 * Karel finds the midpoint by removing rightmost and leftmost beepers one by one.
	 * pre: Karel has filled the first row and now has to find the midpoint.
	 * post: Karel has successfully found the midpoint and now has to put the beeper there.
	 */
	private void findTheMidpoint() {
		while(beepersPresent()){
			takeRightmostBeeper();
			goToTheNextFarthestBeeper();
			takeLeftmostBeeper();
			goToTheNextFarthestBeeper();
		}
	}
	/*
	 * Karel fills the first row with beepers.
	 * pre: Karel is standing at 1x1.
	 * post: Karel has filled the first row and is at the end of it.
	 */
	private void fillFirstRow() {
		putBeeper();
		while (frontIsClear()){
			move();
			putBeeper();
		}
	}
	/*
	 * Karel takes the leftmost beeper.
	 * pre: Karel is next to leftmost beeper and has to take it.
	 * post: Karel has successfully taken the leftmost beeper.
	 */
	private void takeLeftmostBeeper() {
		if (facingWest()){
			turnAround();
		}
		takeFarthestBeeper();
	}
	/*
	 * Karel takes the rightmost beeper
	 * pre: Karel is next to rightmost beeper and has to take it.
	 * post: Karel has successfully taken the rightmost beeper.
	 */
	private void takeRightmostBeeper() {
		if (facingEast()){
			turnAround();
		}
		takeFarthestBeeper();
	}
	/*
	 * Karel goes to the next farthest beeper.
	 * pre: Karel has picked up the beeper and now has to go for the next one.
	 * post: Karel has gone to the next beeper and is ready to start taking it.
	 */
	private void goToTheNextFarthestBeeper() {
		while(beepersPresent() && frontIsClear()){
			move();
		}
		if (noBeepersPresent()){
			turnAround();
			safelyMove();
		}
	}
	/*
	 * Karel takes 2 beepers, one which is the leftmost/rightmost and the other next to it, then puts extra beeper back.
	 * pre: Karel is at the leftmost/rightmost beeper and ready to take it.
	 * post: Karel has succesfully taken the leftmost/rightmost beeper.
	 */
	private void takeFarthestBeeper() {
		safelyMove();
		if (beepersPresent()){
			safelyPickBeeper();
			turnAround();
			safelyMove();
			safelyPickBeeper();
			turnAround();
			safelyMove();
		}
		safelyMove();
		if (beepersPresent()){
			turnAround();
			safelyMove();
			putBeeper();
			turnAround();
		}
	}
	/*
	 * Karel safely picks the beeper.
	 * pre: Karel is standing at the location.
	 * post: Karel has picked it up in case beeper was there.
	 */
	private void safelyPickBeeper() {
		if (beepersPresent()){
			pickBeeper();
		}
	}
	/*
	 * Karel safely moves to the location.
	 * pre: Karel is standing at the location.
	 * post: Karel has moved to another location in case there was no wall.
	 */
	private void safelyMove() {
		if (frontIsClear()){
			move();
		}
	}
}
