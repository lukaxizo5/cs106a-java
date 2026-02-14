import stanford.karel.Karel;

public class Problem05 extends Karel{
	public void run(){
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
