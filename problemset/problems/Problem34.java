import java.awt.Color;

import acm.graphics.GOval;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

public class Problem34 extends GraphicsProgram {
	private static final int SENTINEL = 1000;
	
	public void run() {
		RandomGenerator rgen = new RandomGenerator();
		for (int i = 0; i < SENTINEL; i++) {
			int radius = rgen.nextInt(25, 50);
			int diameter = 2 * radius;
			int x = rgen.nextInt(0, getWidth());
			int y = rgen.nextInt(0, getHeight());
			Color color = rgen.nextColor();
			GOval goval = new GOval(x, y, diameter, diameter);
			goval.setFilled(true);
			goval.setColor(color);
			add(goval);
		}
	}
}
