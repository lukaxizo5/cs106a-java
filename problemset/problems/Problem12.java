import java.awt.*;
import acm.graphics.*;
import acm.program.GraphicsProgram;

public class Problem12 extends GraphicsProgram {
	private static final double HOUSE_WIDTH = 200;
	private static final double HOUSE_HEIGHT  = 200;
	private static final double DOOR_WIDTH  = 50;
	private static final double DOOR_HEIGHT  = 100;
	private static final double ROOF_HEIGHT  = 100;
	
	public void run() {
		drawHouse();
	}

	private void drawHouse() {
		drawBody();
		drawDoor();
		drawRoof();
	}

	private void drawRoof() {
		double x1 = getWidth() / 2 - HOUSE_WIDTH / 2;
		double y1 = getHeight() - HOUSE_HEIGHT;
		double x2 = x1 + HOUSE_WIDTH / 2;
		double y2 = y1 - ROOF_HEIGHT;
		GLine first = new GLine(x1,y1,x2,y2);
		add(first);
		double x3 = x2 + HOUSE_WIDTH / 2;
		double y3 = y1;
		GLine second = new GLine(x2,y2,x3,y3);
		add(second);
	}

	private void drawDoor() {
		GRect door = new GRect (DOOR_WIDTH, DOOR_HEIGHT);
		double x = getWidth() / 2 - HOUSE_WIDTH / 2 + DOOR_WIDTH * 2;
		double y = getHeight() - DOOR_HEIGHT;
		door.setFilled(true);
		door.setColor(Color.BLACK);
		add(door,x,y);
	}

	private void drawBody() {
		GRect body = new GRect(HOUSE_WIDTH, HOUSE_HEIGHT);
		double x = getWidth() / 2 - HOUSE_WIDTH / 2;
		double y = getHeight() - HOUSE_HEIGHT;
		body.setFilled(true);
		body.setColor(Color.RED);
		add(body,x,y);
	}
	
}
