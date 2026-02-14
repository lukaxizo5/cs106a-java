/*
 * File: CollectNewspaperKarel.java
 * --------------------------------
 * At present, the CollectNewspaperKarel subclass does nothing.
 * Your job in the assignment is to add the necessary code to
 * instruct Karel to walk to the door of its house, pick up the
 * newspaper (represented by a beeper, of course), and then return
 * to its initial position in the upper left corner of the house.
 */

import stanford.karel.*;

public class CollectNewspaperKarel extends SuperKarel {

	public void run() {
		goToTheNewspaper();
		safelyPickUpTheNewspaper();
		returnToTheStartingLocation();
	}
	/*
	 * Karel moves to the newspaper.
	 * pre: Karel is at the starting location (facing left).
	 * post: Karel is standing on the newspaper (facing left).
	 */
	private void goToTheNewspaper() {
		move();
		move();
		turnRight();
		move();
		turnLeft();
		move();
	}
	/*
	 * Karel takes the newspaper safely.
	 * pre: Karel is standing on the newspaper (facing left).
	 * post: Karel is at the same location, but has taken the newspaper (facing left).
	 */
	private void safelyPickUpTheNewspaper() {
		if (beepersPresent()){
			pickBeeper();
		}
	}
	/*
	 * Karel goes back home.
	 * pre: Karel has the newspaper (facing left).
	 * post: Karel has successfully come back home (facing left).
	 */
	private void returnToTheStartingLocation() {
		turnAround();
		move();
		turnRight();
		move();
		turnLeft();
		move();
		move();
		turnAround();
	}
}
