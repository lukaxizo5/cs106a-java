import java.awt.event.MouseEvent;

import acm.graphics.GOval;
import acm.program.GraphicsProgram;

public class Problem44 extends GraphicsProgram {
	
	private GOval oval;
	private static final int RADIUS = 20;
	public void run () {
		oval = new GOval(2 * RADIUS, 2 * RADIUS);
		oval.setFilled(true);
		add(oval);
		addMouseListeners();
		while (true) {
			oval.move(0, 5);
			pause(10);
		}
	}
	
	@Override
	public void mouseClicked (MouseEvent e) {
		add(oval, e.getX() - RADIUS, e.getY() - RADIUS);
	}
}
