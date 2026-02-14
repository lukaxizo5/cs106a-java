import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class Problem22 extends GraphicsProgram {
	public void run() {
		double x = getWidth() / 8.0;
		double y = getHeight() / 8.0;
		drawChessboard(x,y);
	}
	
	private void drawChessboard(double x, double y) {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				GRect rectangle = new GRect(x, y);
				rectangle.setLocation(j * x, i * y);
				add(rectangle);
				if ((i + j) % 2 == 0) {
					rectangle.setFilled(true);
				}
			}
		}
	}
}