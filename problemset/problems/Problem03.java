import stanford.karel.Karel;

public class Problem03 extends Karel{
	public void run(){
		while(frontIsClear()){
			move();
		}
	}
}
