import stanford.karel.SuperKarel;

public class Problem06 extends SuperKarel{
	public void run(){
		move();
		moveFromSecond();
		move();
		moveFromThird();
	}

	private void moveFromSecond() {
		while(beepersPresent()){
			pickBeeper();
			move();
			move();
			putBeeper();
			turnAround();
			move();
			move();
			turnAround();
		}
	}
	
	private void moveFromThird() {
		while(beepersPresent()){
			pickBeeper();
			move();
			putBeeper();
			turnAround();
			move();
			turnAround();
		}
	}
}

