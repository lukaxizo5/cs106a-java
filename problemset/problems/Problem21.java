import acm.graphics.*;
import acm.program.*;

public class Problem21 extends GraphicsProgram {
	public static final int SENTINEL = 10;
	public void run() {
		drawNet();
	}
	
	private void drawNet() {
		drawHorizontals();
		drawVerticals();
	}
	
	private void drawHorizontals() {
		double length = (double) getHeight() / SENTINEL;
		for (int i = 1; i < SENTINEL ; i++) {
			GLine horizontalLine = new GLine(0,i * length,getWidth(),i * length);
			add(horizontalLine);
		}
	}
	
	private void drawVerticals() {
		double length = getWidth() / SENTINEL;
		for (int i = 1; i < SENTINEL ; i++) {
			GLine verticalLine = new GLine(i * length,0,i * length,getHeight());
			add(verticalLine);
		}
	}
}