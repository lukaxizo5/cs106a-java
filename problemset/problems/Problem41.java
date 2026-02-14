import java.awt.event.MouseEvent;

import acm.graphics.GOval;
import acm.program.GraphicsProgram;

public class Problem41 extends GraphicsProgram {
	private static final int RADIUS = 20;
	public void run() {
		addMouseListeners();
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		addBrush(e.getX(),e.getY());
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		addBrush(e.getX(),e.getY());
	}
	
	private void addBrush(int xc, int yc) {
		GOval brush = new GOval (2 * RADIUS, 2 * RADIUS);
		brush.setFilled(true);
		int x = xc - RADIUS;
		int y = yc - RADIUS;
		add(brush, x, y);
	}
}
