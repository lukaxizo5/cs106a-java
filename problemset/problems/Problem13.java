import acm.graphics.*;
import acm.program.GraphicsProgram;

public class Problem13 extends GraphicsProgram{
	public void run() {
		drawLine();
	}

	private void drawLine() {
		double y1 = getHeight()/2;
		double x1 = 0;
		double x2 = getWidth();
		GLine line = new GLine(x1,y1,x2,y1);
		add(line);
	}

}
