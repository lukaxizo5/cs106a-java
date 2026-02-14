import stanford.karel.SuperKarel;

public class Problem07 extends SuperKarel{
	public void run(){
		while(leftIsClear()){
			fillRow();
			goBack();
			moveUp();
		}
		fillRow();
	}

	private void moveUp() {
		move();
		turnRight();
	}

	private void goBack() {
		turnAround();
		while(frontIsClear()){
			move();
		}
		turnRight();
	}

	private void fillRow() {
		if (!beepersPresent()){
			putBeeper();
		}
		while(frontIsClear()){
			move();
			if (!beepersPresent()){
				putBeeper();
			}
		}
	}
}