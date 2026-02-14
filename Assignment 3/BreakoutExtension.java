/* File: Breakout.java
 * -------------------
 * Name:
 * Section Leader:
 * 
 * This file will eventually implement the game of Breakout.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class BreakoutExtension extends GraphicsProgram {

/** Width and height of application window in pixels */
	public static final int APPLICATION_WIDTH = 400;
	public static final int APPLICATION_HEIGHT = 600;

/** Dimensions of game board (usually the same) */
	private static final int WIDTH = APPLICATION_WIDTH;
	private static final int HEIGHT = APPLICATION_HEIGHT;

/** Dimensions of the paddle */
	private static final int PADDLE_WIDTH = 60;
	private static final int PADDLE_HEIGHT = 10;

/** Offset of the paddle up from the bottom */
	private static final int PADDLE_Y_OFFSET = 30;

/** Number of bricks per row */
	private static final int NBRICKS_PER_ROW = 10;

/** Number of rows of bricks */
	private static final int NBRICK_ROWS = 10;

/** Separation between bricks */
	private static final int BRICK_SEP = 4;

/** Width of a brick */
	private static final int BRICK_WIDTH =
	  (WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;

/** Height of a brick */
	private static final int BRICK_HEIGHT = 8;

/** Radius of the ball in pixels */
	private static final int BALL_RADIUS = 10;

/** Offset of the top brick row from the top */
	private static final int BRICK_Y_OFFSET = 70;

/** Number of turns */
	private static final int NTURNS = 3;
/** PADDLE */	
	private GRect PADDLE = new GRect(WIDTH / 2 - PADDLE_WIDTH / 2, HEIGHT - PADDLE_Y_OFFSET - PADDLE_HEIGHT, PADDLE_WIDTH, PADDLE_HEIGHT);
/** BALL */	
	private GOval BALL = new GOval(WIDTH / 2 - BALL_RADIUS, HEIGHT / 2 - BALL_RADIUS, 2 * BALL_RADIUS, 2* BALL_RADIUS);
/** Current brick counter */	
	private int currentBrickCount = NBRICK_ROWS * NBRICKS_PER_ROW;
/**  BALL speed on the x axis */
	private double vx;
/**  BALL speed on the y axis */	
	private double vy = 3;
/** RandomGenerator */	
	private RandomGenerator rgen = RandomGenerator.getInstance();
/** Lives left tracker */
	private int livesLeft = NTURNS;
/** Animation delay time */
	private static final int DELAY = 6;
/** Another try delay */
	private static final int ANOTHER_TRY_DELAY = 500;
/** accelerates the ball speed */ 
    private static final double ACCELERATION = 1.07;
/** Collision counter to increase velocity */
	private int collisionCount = 0;
/** Label to tell the user how many tries has (s)he left */
	private GLabel triesLeftLabel;
/** Audio for PADDLE collision */
	AudioClip bounceClip = MediaTools.loadAudioClip("bounce.au");
/** Label for score count*/
	private GLabel scoreLabel;
/** Score counter*/
	private int score = 0;
	
	public void run() {
		addMouseListeners();
		InitializeGame();
		waitForClick();
		Play();
	}
	/*
	 * plays the game.
	 */
	private void Play() {
		vx = rgen.nextDouble(1.0, 3.0);
		if (rgen.nextBoolean(0.5)) {
			vx = -vx;
		}
		while (true) {
			if (currentBrickCount == 0) {
				gameWon();
				break;
			}
			BALL.move(vx, vy);
			changeDirection();
			pause(DELAY);
		}
	}
	/*
	 * displays the game losing message in the center when the game is lost, and removes everything.
	 */
	private void gameLost() {
		GLabel gameLostLabel = new GLabel("You lost!");
		gameLostLabel.setFont("Times-Bold-30");
		double xLabel = WIDTH / 2.0 - gameLostLabel.getWidth() / 2.0; 
		double yLabel = HEIGHT / 2.0 - gameLostLabel.getAscent() / 2.0; 
		double x = WIDTH / 2.0 - scoreLabel.getWidth() / 2.0;
		double y = HEIGHT / 2.0 - scoreLabel.getAscent() / 2.0;
		gameLostLabel.setLocation(xLabel, yLabel);
		removeAll();
		add(gameLostLabel);
		add(scoreLabel, x, y + 50);
	}
	/*
	 * displays the game winning message in the center when the game is won, and removes everything.
	 */
	private void gameWon() {
		GLabel gameWonLabel = new GLabel("You Won! Congratulations!");
		gameWonLabel.setFont("Times-Bold-30");
		double xLabel = WIDTH / 2.0 - gameWonLabel.getWidth() / 2.0; 
		double yLabel = HEIGHT / 2.0 - gameWonLabel.getAscent() / 2.0; 
		double x = WIDTH / 2.0 - scoreLabel.getWidth() / 2.0;
		double y = HEIGHT / 2.0 - scoreLabel.getAscent() / 2.0;
		gameWonLabel.setLocation(xLabel, yLabel);
		removeAll();
		add(gameWonLabel);
		add(scoreLabel, x, y + 50);
	}
	/*
	 * changes the direction of the ball after collision and updates the value of brick count if collision happened. 
	 */
	private void changeDirection() {
		GObject collider = getCollidingObject();
		//down wall check
		if (BALL.getY() + 2 * BALL_RADIUS >= HEIGHT) {
			tryOver();
		}
		//side wall checks 
		if ((BALL.getX() - vx <= 0 && vx < 0) || (BALL.getX() + 2 * BALL_RADIUS + vx >= WIDTH)) {
			vx *= -1;
		}
		//up wall check
		if (BALL.getY() - vy <= 0 && vy < 0) {
			vy *= -1;
		}
		//paddle collision but only if it's on the top.
		if (collider == PADDLE) {
			if (BALL.getY() + 2 * BALL_RADIUS >= PADDLE.getY() && BALL.getY() + 2 * BALL_RADIUS <= PADDLE.getY() + PADDLE_HEIGHT / 2.0) {
				collisionCount++;
				bounceClip.play();
				if (collisionCount <= 7) {
					vy *= -ACCELERATION;
				}
				else {
					vy *= -1;
				}
				BALL.move(vx, vy);
				pause(DELAY);
			}
			else {
				while (BALL.getY() <= HEIGHT) {
					BALL.move(vx, vy);
					pause(DELAY);
				}
				remove(BALL);
				tryOver();
			}
		}
		//brick collision
		else if (collider != null && collider != scoreLabel) {
			remove(collider);
			currentBrickCount--;
			vy *= -1;
			updateScore(collider);
			remove(scoreLabel);
			drawScore();
		}
		pause(DELAY);
	}
	/*
	 * updates the score depending on the brick y coordinate.
	 */
	private void updateScore(GObject obj) {
		// TODO Auto-generated method stub
		double add = 10 * (NBRICK_ROWS / 2 -((int)obj.getY()- BRICK_Y_OFFSET) / (2 * (BRICK_HEIGHT + BRICK_SEP)));
		score += add;
	}
	/*
	 * current try is over.
	 */
	private void tryOver() {
		livesLeft--;
		collisionCount = 0;
		if (livesLeft <= 0) {
			gameLost();
		}
		else {
			tellHowManyTriesLeft();
			waitForClick();
			remove(triesLeftLabel);
			pause(ANOTHER_TRY_DELAY);
			vy = 3;
			BALL.setLocation(WIDTH / 2 - BALL_RADIUS, HEIGHT / 2 - BALL_RADIUS);
			drawBall();
		}
	}
	/*
	 * tells the user how many tries has (s)he left.
	 */
	private void tellHowManyTriesLeft() {
		if (livesLeft == 1) {
			triesLeftLabel = new GLabel("You have " + livesLeft + " try left! Click to Continue!");
		}
		else {
			triesLeftLabel = new GLabel("You have " + livesLeft + " tries left! Click to Continue!");
		}
		triesLeftLabel.setFont("Times-Bold-15");
		double xLabel = WIDTH / 2.0 - triesLeftLabel.getWidth() / 2.0; 
		double yLabel = HEIGHT / 2.0 - triesLeftLabel.getAscent() / 2.0; 
		triesLeftLabel.setLocation(xLabel, yLabel);
		add(triesLeftLabel);
	}
	/*
	 * moves the paddle center with the mouse.
	 */
	public void mouseMoved(MouseEvent e) {
		if (e.getX() < PADDLE_WIDTH / 2 ) {
			PADDLE.setLocation(0, PADDLE.getY());
		}
		else if (e.getX() > WIDTH - PADDLE_WIDTH / 2 ) {
			PADDLE.setLocation(WIDTH - PADDLE_WIDTH, PADDLE.getY());
		}
		else PADDLE.setLocation(e.getX() - PADDLE_WIDTH / 2, PADDLE.getY());
	}
	/*
	 * returns the colliding object by checking up-left, up-right, down-left, and down-right points of the ball.
	 */
	private GObject getCollidingObject() {
		if (getElementAt(BALL.getX(), BALL.getY()) != null) {
			return getElementAt(BALL.getX(), BALL.getY());
		}
		if (getElementAt(BALL.getX() + 2 *  BALL_RADIUS, BALL.getY()) != null) {
			return getElementAt(BALL.getX() + 2 *  BALL_RADIUS, BALL.getY());
		}
		if (getElementAt(BALL.getX(), BALL.getY() + 2 *  BALL_RADIUS) != null) {
			return getElementAt(BALL.getX(), BALL.getY() + 2 *  BALL_RADIUS);
		}
		if (getElementAt(BALL.getX() + 2 * BALL_RADIUS, BALL.getY() + 2 *  BALL_RADIUS) != null) {
			return getElementAt(BALL.getX() + 2 * BALL_RADIUS, BALL.getY() + 2 *  BALL_RADIUS);
		}
		return null;
	}
	/*
	 * initializes game by drawing the ball, the bricks and the paddle.
	 */
	private void InitializeGame() {
		drawBricks();
		drawPaddle();
		drawBall();
		drawScore();
	}
	private void drawScore() {
		scoreLabel = new GLabel("Your Score: " + score);
		double xLabel = 5; 
		double yLabel = 15; 
		scoreLabel.setFont("Times-Bold-15");
		scoreLabel.setLocation(xLabel, yLabel);
		add(scoreLabel);
	}
	/*
	 * draws the ball in the center of the application.
	 */
	private void drawBall() {
		BALL.setFilled(true);
		BALL.setColor(Color.BLACK);
		add(BALL);
	}
	/*
	 * draws the paddle in the center slightly above the bottom wall.
	 */
	private void drawPaddle() {
		PADDLE.setColor(Color.BLACK);
		PADDLE.setFilled(true);
		add(PADDLE);
	}
	/*
	 * draws all the bricks in the game.
	 */
	private void drawBricks() {
		double xStart = WIDTH / 2.0 - NBRICKS_PER_ROW * BRICK_WIDTH / 2.0 - (NBRICKS_PER_ROW - 1) * BRICK_SEP / 2.0;
		double yStart = BRICK_Y_OFFSET;
		for (int i = 0; i < NBRICK_ROWS; i++) {
			fillRow(getColor(i), xStart, yStart);
			yStart += (BRICK_HEIGHT + BRICK_SEP);
		}
	}
	/*
	 * returns the color of the given row index.
	 */
	private Color getColor(int rowIndex) {
		if (rowIndex % 10 <= 1) {
			return Color.RED;
		}
		if (rowIndex % 10 <= 3) {
			return Color.ORANGE;
		}
		if (rowIndex % 10 <= 5) {
			return Color.YELLOW;
		}
		if (rowIndex % 10 <= 7) {
			return Color.GREEN;
		}
		else return Color.CYAN;
	}
	/*
	 * fills the row with color and the starting location of the first brick.
	 */
	private void fillRow(Color color, double xStart, double yStart) {
		for (int i = 0; i < NBRICKS_PER_ROW; i++) {
			GRect brick = new GRect(xStart, yStart, BRICK_WIDTH, BRICK_HEIGHT);
			add(brick);
			brick.setColor(color);
			brick.setFilled(true);
			xStart += BRICK_WIDTH + BRICK_SEP;
		}
	}
}
