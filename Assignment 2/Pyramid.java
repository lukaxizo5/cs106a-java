/*
 * File: Pyramid.java
 * Name: 
 * Section Leader: 
 * ------------------
 * This file is the starter file for the Pyramid problem.
 * It includes definitions of the constants that match the
 * sample run in the assignment, but you should make sure
 * that changing these values causes the generated display
 * to change accordingly.
 */

import acm.graphics.*;
import acm.program.*;

public class Pyramid extends GraphicsProgram {
	private static final int BRICK_WIDTH = 30;
	private static final int BRICK_HEIGHT = 12;
	private static final int BRICKS_IN_BASE = 14;
	
	public void run() {
		drawPyramid();
	}
	/*
	 * draws a pyramid with given sizes in the center of the window.
	 */
	private void drawPyramid() {
		double xStart = getWidth() / 2.0 - BRICKS_IN_BASE * BRICK_WIDTH / 2.0;
		double yStart = getHeight() - BRICK_HEIGHT;
		for (int i = 0; i < BRICKS_IN_BASE; i++) {
			fillRow(i, xStart, yStart);
			xStart += BRICK_WIDTH / 2.0;
			yStart -= BRICK_HEIGHT;
		}
	}
	/*
	 * fills a row of the pyramid with row index, x and y coordinates of the starting brick. 
	 */
	private void fillRow(int rowIndex, double xCoordinate, double yCoordinate) {
		for (int i = 0; i < BRICKS_IN_BASE - rowIndex; i++) {
			GRect brick = new GRect(xCoordinate, yCoordinate, BRICK_WIDTH, BRICK_HEIGHT);
			add(brick);
			xCoordinate += BRICK_WIDTH;
		}
	}
}