import java.awt.event.MouseEvent;

import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.program.GraphicsProgram;

public class Problem43 extends GraphicsProgram {
	
	private static final int RADIUS = 20;
	private GOval oval = new GOval(2 * RADIUS, 2 * RADIUS); 
	private GObject lastPressed;
	private int x;
	private int y;
	public void run() {
		oval = new GOval(2 * RADIUS, 2 * RADIUS);
		oval.setFilled(true);
		add(oval, getWidth() / 2 - RADIUS, getHeight() / 2 - RADIUS);
		addMouseListeners();
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		GObject object = getElementAt(e.getX(), e.getY());
		lastPressed = object;
		if (object != null) {
			x = e.getX();
			y = e.getY();
		}
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		if (lastPressed != null) {
			lastPressed.move(e.getX()- x, e.getY() - y);
			x = e.getX();
			y = e.getY();
		}
	}
}
