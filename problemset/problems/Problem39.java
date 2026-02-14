import acm.graphics.*;
import acm.program.*;

public class Problem39 extends GraphicsProgram {
	
	private static final double DELTA_X = 5;
	private static final int PAUSE_TIME = 20;
	private static final int RADIUS = 30;
	
	public void run() {
		GOval oval = new GOval(2 * RADIUS,2 * RADIUS);
		add(oval, 0, getHeight() / 2 - RADIUS);
		while (getWidth() - oval.getLocation().getX() - 2 * RADIUS > 0) {
			oval.move(DELTA_X, 0);
			pause(PAUSE_TIME);
		}
	}
}