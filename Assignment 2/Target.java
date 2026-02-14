/*
 * File: Target.java
 * Name: 
 * Section Leader: 
 * -----------------
 * This file is the starter file for the Target problem.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class Target extends GraphicsProgram {
	private static final double OUTER_RADIUS = 72;
	private static final double MIDDLE_RADIUS = 72 * 1.65 / 2.54;
	private static final double INNER_RADIUS = 72 * 0.76 / 2.54;
	
	public void run() {
		drawTarget();
	}
	/*
	 * draws the target by drawing 3 colored circles.
	 */
	private void drawTarget() {
		drawCircle(OUTER_RADIUS, Color.RED);
		drawCircle(MIDDLE_RADIUS, Color.WHITE);
		drawCircle(INNER_RADIUS, Color.RED);
	}
	/*
	 * draws a circle with given radius and color in the center of the window.
	 */
	private void drawCircle(double radius, Color color) {
		double diameter = 2 * radius;
		GOval circle = new GOval(getWidth() / 2 - radius, getHeight() / 2 - radius, diameter, diameter);
		circle.setFilled(true);
		circle.setColor(color);
		add(circle);
	}
}