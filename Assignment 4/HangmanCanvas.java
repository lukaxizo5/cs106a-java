/*
 * File: HangmanCanvas.java
 * ------------------------
 * This file keeps track of the Hangman display.
 */

import acm.graphics.*;

public class HangmanCanvas extends GCanvas {
	
	private String incorrectGuesses = "";
	private GLabel currentWord = new GLabel("");
	
	public HangmanCanvas() {
		setSize(377, 467);
	}
/** Resets the display so that only the scaffold appears */
	public void reset() {
		removeAll();
		drawScaffold();
		drawBeam();
		drawRope();
	}	
	/*
	 * draws the rope.
	 */
	private void drawRope() {
		GLine rope = new GLine(getWidth() / 2.0, getHeight() / 20.0, getWidth() / 2.0, getHeight() / 20.0 + ROPE_LENGTH);
		add(rope);
	}
	/*
	 * draws the beam.
	 */
	private void drawBeam() {
		GLine beam = new GLine(getWidth() / 2.0 - BEAM_LENGTH, getHeight() / 20.0, getWidth() / 2.0, getHeight() / 20.0);
		add(beam);
	}
	/*
	 * draws the scaffold.
	 */
    private void drawScaffold() {
    	GLine scaffold = new GLine(getWidth() / 2.0 - BEAM_LENGTH, getHeight() / 20.0, getWidth() / 2.0 - BEAM_LENGTH, getHeight() /8.0 + SCAFFOLD_HEIGHT);
    	add(scaffold);
    }
    /*
     * updates the man after a wrong guess.
     */
    public void updateMan(int guessesLeft) {
    	switch (guessesLeft) {
    		case 7: drawHead();
    				break;
    		case 6: drawBody();
    				break;
    		case 5: drawLeftHand();
    				break;
    		case 4: drawRightHand();
    				break;
    		case 3: drawLeftLeg();
    				break;
    		case 2: drawRightLeg();
    				break;
    		case 1: drawLeftFoot();
    				break;
    		case 0: drawRightFoot();
    				break;
    	}
    }
    /*
     * sets the incorrect guesses to an empty string because a new game has started;
     */
	public void setIncorrectGuesses() {
		this.incorrectGuesses = "";
	}
	/*
     * draws the right foot.
     */
	private void drawRightFoot() {
		GLine foot = new GLine(getWidth() / 2.0 + HIP_WIDTH, getHeight() / 20.0 + ROPE_LENGTH + 2 * HEAD_RADIUS + BODY_LENGTH + LEG_LENGTH, getWidth() / 2.0 + HIP_WIDTH + FOOT_LENGTH, getHeight() / 20.0 + ROPE_LENGTH + 2 * HEAD_RADIUS + BODY_LENGTH + LEG_LENGTH);
		add(foot);
	}
	/*
	 * draws the left foot.
	 */
	private void drawLeftFoot() {
		GLine foot = new GLine(getWidth() / 2.0 - HIP_WIDTH, getHeight() / 20.0 + ROPE_LENGTH + 2 * HEAD_RADIUS + BODY_LENGTH + LEG_LENGTH, getWidth() / 2.0 - HIP_WIDTH - FOOT_LENGTH, getHeight() / 20.0 + ROPE_LENGTH + 2 * HEAD_RADIUS + BODY_LENGTH + LEG_LENGTH);
		add(foot);
	}
	/*
	 * draws the right leg.
	 */
	private void drawRightLeg() {
		GLine hip = new GLine(getWidth() / 2.0, getHeight() / 20.0 + ROPE_LENGTH + 2 * HEAD_RADIUS + BODY_LENGTH, getWidth() / 2.0 + HIP_WIDTH, getHeight() / 20.0 + ROPE_LENGTH + 2 * HEAD_RADIUS + BODY_LENGTH);
		add(hip);
		GLine leg = new GLine(getWidth() / 2.0 + HIP_WIDTH, getHeight() / 20.0 + ROPE_LENGTH + 2 * HEAD_RADIUS + BODY_LENGTH, getWidth() / 2.0 + HIP_WIDTH, getHeight() / 20.0 + ROPE_LENGTH + 2 * HEAD_RADIUS + BODY_LENGTH + LEG_LENGTH);
		add(leg); 
	}
	/*
	 * draws the left leg.
	 */
	private void drawLeftLeg() {
		GLine hip = new GLine(getWidth() / 2.0, getHeight() / 20.0 + ROPE_LENGTH + 2 * HEAD_RADIUS + BODY_LENGTH, getWidth() / 2.0 - HIP_WIDTH, getHeight() / 20.0 + ROPE_LENGTH + 2 * HEAD_RADIUS + BODY_LENGTH);
		add(hip);
		GLine leg = new GLine(getWidth() / 2.0 - HIP_WIDTH, getHeight() / 20.0 + ROPE_LENGTH + 2 * HEAD_RADIUS + BODY_LENGTH, getWidth() / 2.0 - HIP_WIDTH, getHeight() / 20.0 + ROPE_LENGTH + 2 * HEAD_RADIUS + BODY_LENGTH + LEG_LENGTH);
		add(leg);
	}
	/*
	 * draws the right hand.
	 */
	private void drawRightHand() {
		GLine hand = new GLine(getWidth() / 2.0, getHeight() / 20.0 + ROPE_LENGTH + 2 * HEAD_RADIUS + ARM_OFFSET_FROM_HEAD, getWidth() / 2.0 + UPPER_ARM_LENGTH, getHeight() / 20.0 + ROPE_LENGTH + 2 * HEAD_RADIUS + ARM_OFFSET_FROM_HEAD);
		add(hand);
		GLine arm = new GLine(getWidth() / 2.0 + UPPER_ARM_LENGTH, getHeight() / 20.0 + ROPE_LENGTH + 2 * HEAD_RADIUS + ARM_OFFSET_FROM_HEAD, getWidth() / 2.0 + UPPER_ARM_LENGTH, getHeight() / 20.0 + ROPE_LENGTH + 2 * HEAD_RADIUS + ARM_OFFSET_FROM_HEAD + LOWER_ARM_LENGTH);
		add(arm);
	}
	/*
	 * draws the left hand.
	 */
	private void drawLeftHand() {
			GLine hand = new GLine(getWidth() / 2.0, getHeight() / 20.0 + ROPE_LENGTH + 2 * HEAD_RADIUS + ARM_OFFSET_FROM_HEAD, getWidth() / 2.0 - UPPER_ARM_LENGTH, getHeight() / 20.0 + ROPE_LENGTH + 2 * HEAD_RADIUS + ARM_OFFSET_FROM_HEAD);
			add(hand);
			GLine arm = new GLine(getWidth() / 2.0 - UPPER_ARM_LENGTH, getHeight() / 20.0 + ROPE_LENGTH + 2 * HEAD_RADIUS + ARM_OFFSET_FROM_HEAD, getWidth() / 2.0 - UPPER_ARM_LENGTH, getHeight() / 20.0 + ROPE_LENGTH + 2 * HEAD_RADIUS + ARM_OFFSET_FROM_HEAD + LOWER_ARM_LENGTH);
			add(arm);
	}
	/*
	 * draws the body.
	 */
	private void drawBody() {
		GLine body = new GLine(getWidth() / 2.0, getHeight() / 20.0 + ROPE_LENGTH + 2 * HEAD_RADIUS, getWidth() / 2.0, getHeight() / 20.0 + ROPE_LENGTH + 2 * HEAD_RADIUS + BODY_LENGTH);
		add(body);
	}
	/*
	 * draws the head.
	 */
	private void drawHead() {
		GOval head = new GOval(getWidth() / 2.0 - HEAD_RADIUS, getHeight() / 20.0 + ROPE_LENGTH , 2 * HEAD_RADIUS, 2 * HEAD_RADIUS);
		add(head);
	}
/**
 * Updates the word on the screen to correspond to the current
 * state of the game.  The argument string shows what letters have
 * been guessed so far; unguessed letters are indicated by hyphens.
 */
	public void displayWord(String word) {
		currentWord.setLabel(word);;
		currentWord.setFont("Ariel-22");
		currentWord.setLocation(getWidth() / 4.0 , getHeight() - WORD_OFFSET);
		add(currentWord);
	}

/**
 * Updates the display to correspond to an incorrect guess by the
 * user.  Calling this method causes the next body part to appear
 * on the scaffold and adds the letter to the list of incorrect
 * guesses that appears at the bottom of the window.
 */
	public void noteIncorrectGuess(char letter) {
		if (!incorrectGuesses.contains(String.valueOf(letter))) {
			incorrectGuesses += letter;
		}
		GLabel incorrectGuess = new GLabel(incorrectGuesses);
		incorrectGuess.setLocation(getWidth() / 4.0 , getHeight() - INCORRECT_GUESSES_OFFSET);
		incorrectGuess.setFont("Times-Bold-15");
		add(incorrectGuess);
	}

/* Constants for the simple version of the picture (in pixels) */
	private static final int SCAFFOLD_HEIGHT = 360;
	private static final int BEAM_LENGTH = 144;
	private static final int ROPE_LENGTH = 18;
	private static final int HEAD_RADIUS = 36;
	private static final int BODY_LENGTH = 144;
	private static final int ARM_OFFSET_FROM_HEAD = 28;
	private static final int UPPER_ARM_LENGTH = 72;
	private static final int LOWER_ARM_LENGTH = 44;
	private static final int HIP_WIDTH = 36;
	private static final int LEG_LENGTH = 108;
	private static final int FOOT_LENGTH = 28;
	private static final int WORD_OFFSET = 40;
	private static final int INCORRECT_GUESSES_OFFSET = 20;
}
