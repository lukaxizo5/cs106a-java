import stanford.karel.Karel;

public class Problem04 extends Karel{
	public void run(){
		putBeeper();
		while (frontIsClear()){
			move();
			putBeeper();
		}
	}
}
