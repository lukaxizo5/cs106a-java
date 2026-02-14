/*
 * File: ProgramHierarchy.java
 * Name: 
 * Section Leader: 
 * ---------------------------
 * This file is the starter file for the ProgramHierarchy problem.
 */

import acm.graphics.*;
import acm.program.*;

public class ProgramHierarchy extends GraphicsProgram {	
	private static final int RECTANGLE_WIDTH = 160;
	private static final int RECTANGLE_HEIGHT = 50;
	
	public void run() {
		drawProgram();
		drawGraphicsProgram();
		drawConsoleProgram();
		drawDialogProgram();
		drawConsoleLine();
		drawDialogLine();
		drawGraphicsLine();
	}
	/*
	 * draws the line which connects Program and GraphicsProgram rectangles.
	 */
	private void drawGraphicsLine() {
		double xStart = getWidth() / 2.0;
		double yStart = getHeight() / 2.0 - 0.5 * RECTANGLE_HEIGHT;
		double xEnd = xStart - 1.2 * RECTANGLE_WIDTH ;
		double yEnd = yStart + RECTANGLE_HEIGHT;
		GLine graphicsLine = new GLine(xStart, yStart, xEnd, yEnd);
		add(graphicsLine);
	}
	/*
	 * draws the line which connects Program and ConsoleProgram rectangles.
	 * the center of the whole window is the midpoint of this line.
	 */
	private void drawConsoleLine() {
		double xStart = getWidth() / 2.0;
		double yStart = getHeight() / 2.0 - 0.5 * RECTANGLE_HEIGHT;
		double xEnd = xStart;
		double yEnd = yStart + RECTANGLE_HEIGHT;
		GLine consoleLine = new GLine(xStart, yStart, xEnd, yEnd);
		add(consoleLine);
	}
	/*
	 * draws the line which connects Program and DialogProgram rectangles.
	 */
	private void drawDialogLine() {
		double xStart = getWidth() / 2.0;
		double yStart = getHeight() / 2.0 - 0.5 * RECTANGLE_HEIGHT;
		double xEnd = xStart + 1.2 * RECTANGLE_WIDTH;
		double yEnd = yStart + RECTANGLE_HEIGHT;
		GLine dialogLine = new GLine(xStart, yStart, xEnd, yEnd);
		add(dialogLine);
	}
	/*
	 * draws the rectangle with DialogProgram written in the center of it.
	 */
	private void drawDialogProgram() {
		double xStart = getWidth() / 2.0 + 0.7 * RECTANGLE_WIDTH;
		double yStart = getHeight() / 2.0 + 0.5 * RECTANGLE_HEIGHT;
		GLabel dialogProgram = new GLabel("DialogProgram");
		double xLabel = xStart + RECTANGLE_WIDTH / 2.0 - dialogProgram.getWidth() / 2.0;
		double yLabel = yStart + RECTANGLE_HEIGHT / 2.0 + dialogProgram.getAscent() / 2.0;
		add(new GRect(xStart, yStart, RECTANGLE_WIDTH, RECTANGLE_HEIGHT));
		add(dialogProgram, xLabel, yLabel);
	}
	/*
	 * draws the rectangle with ConsoleProgram written in the center of it.
	 */
	private void drawConsoleProgram() {
		double xStart = getWidth() / 2.0 - RECTANGLE_WIDTH / 2.0;
		double yStart = getHeight() / 2.0 + 0.5 * RECTANGLE_HEIGHT;
		GLabel consoleProgram = new GLabel("ConsoleProgram");
		double xLabel = xStart + RECTANGLE_WIDTH / 2.0 - consoleProgram.getWidth() / 2.0;
		double yLabel = yStart + RECTANGLE_HEIGHT / 2.0 + consoleProgram.getAscent() / 2.0;
		add(new GRect(xStart, yStart, RECTANGLE_WIDTH, RECTANGLE_HEIGHT));
		add(consoleProgram, xLabel, yLabel);
	}
	/*
	 * draws the rectangle with GraphicsProgram written in the center of it.
	 */
	private void drawGraphicsProgram() {
		double xStart = getWidth() / 2.0 - 1.7 * RECTANGLE_WIDTH ;
		double yStart = getHeight() / 2.0 + 0.5 * RECTANGLE_HEIGHT;
		GLabel graphicsProgram = new GLabel("GraphicsProgram");
		double xLabel = xStart + RECTANGLE_WIDTH / 2.0 - graphicsProgram.getWidth() / 2.0;
		double yLabel = yStart + RECTANGLE_HEIGHT / 2.0 + graphicsProgram.getAscent() / 2.0;
		add(new GRect(xStart, yStart, RECTANGLE_WIDTH, RECTANGLE_HEIGHT));
		add(graphicsProgram, xLabel, yLabel);
	}
	/*
	 * draws the rectangle with Program written in the center of it.
	 */
	private void drawProgram() {
		double xStart = getWidth() / 2.0 - RECTANGLE_WIDTH / 2.0;
		double yStart = getHeight() / 2.0 - 1.5 * RECTANGLE_HEIGHT;
		GLabel program = new GLabel("Program");
		double xLabel = xStart + RECTANGLE_WIDTH / 2.0 - program.getWidth() / 2.0;
		double yLabel = yStart + RECTANGLE_HEIGHT / 2.0 + program.getAscent() / 2.0;
		add(new GRect(xStart, yStart, RECTANGLE_WIDTH, RECTANGLE_HEIGHT));
		add(program, xLabel, yLabel);
	}
}