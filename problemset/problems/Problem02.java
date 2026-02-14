import stanford.karel.Karel;

public class Problem02 extends Karel{
	public void run(){
		for (int i=0;i<4;i++){
			move();
		}
		while(beepersPresent()){
			pickBeeper();
		}
		move();
		while(beepersInBag()){
			putBeeper();
		}
	}
}
