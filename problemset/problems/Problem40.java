import acm.graphics.*;
import acm.program.*;

public class Problem40 extends GraphicsProgram {
	
	private static final double DELTA_X = 10;
	private static final int PAUSE_TIME = 20;
	private static final int RADIUS = 30;
	
	public void run() {
			GOval oval = new GOval(2 * RADIUS,2 * RADIUS);
			add(oval, 0, getHeight() / 2 - RADIUS);
		while (true) {
			while (getWidth() - oval.getX() - 2 * RADIUS*0 > 0) {
				oval.move(DELTA_X, 0);
				pause(PAUSE_TIME);
			}
			while (oval.getX() != 0) {
				oval.move(-DELTA_X, 0);
				pause(PAUSE_TIME);
			}
		}
	}
}