import java.awt.Color;

import acm.graphics.GOval;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

public class Problem33 extends GraphicsProgram{
	public void run() {
		RandomGenerator rgen = new RandomGenerator();
		int radius = rgen.nextInt(50,150);
		int diameter = 2 * radius;
		Color color = rgen.nextColor();
		GOval goval = new GOval(getWidth() / 2 - radius, getHeight()/ 2 - radius, diameter, diameter);
		goval.setFilled(true);
		goval.setColor(color);
		add(goval);
	}
}
