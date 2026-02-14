/*
 * File: NameSurferGraph.java
 * ---------------------------
 * This class represents the canvas on which the graph of
 * names is drawn. This class is responsible for updating
 * (redrawing) the graphs whenever the list of entries changes or the window is resized.
 */

import acm.graphics.*;
import javafx.util.Pair;

import java.awt.event.*;
import java.util.*;
import java.awt.*;

public class NameSurferGraph extends GCanvas
	implements NameSurferConstants, ComponentListener {
	
	private ArrayList<NameSurferEntry> entries;
	/**
	* Creates a new NameSurferGraph object that displays the data.
	*/
	public NameSurferGraph() {
		addComponentListener(this);
		entries = new ArrayList<>();
	}
	
	/**
	* Clears the list of name surfer entries stored inside this class.
	*/
	public void clear() {
		entries.clear();
		update();
	}
	
	/*
	 * getter method for entries ArrayList.
	 */
	public ArrayList<NameSurferEntry> getEntries() {
		return entries;
	}
	
	/* Method: addEntry(entry) */
	/**
	* Adds a new NameSurferEntry to the list of entries on the display.
	* Note that this method does not actually draw the graph, but
	* simply stores the entry; the graph is drawn by calling update.
	*/
	public void addEntry(NameSurferEntry entry) {
		entries.add(entry);
		update();
	}
	
	/**
	* Updates the display image by deleting all the graphical objects
	* from the canvas and then reassembling the display according to
	* the list of entries. Your application must call update after
	* calling either clear or addEntry; update is also called whenever
	* the size of the canvas changes.
	*/
	public void update() {
		removeAll();
		drawGraph();
		drawEntries();
	}
	
	/*
	 * draws all the entries by calling drawEntry method for each entry.
	 */
	private void drawEntries() {
		for (int i = 0; i < entries.size(); i++) {
			drawEntry(entries.get(i), getColor(i));
		}
	}
	
	/*
	 * returns the color of an entry.
	 */
	private Color getColor(int i) {
		switch (i % 4) {
			case 0: 
				return Color.BLACK;
			case 1: 
				return Color.RED;
			case 2:	
				return Color.BLUE;
			case 3: 
				return Color.GREEN;
		}
		return Color.BLACK;
	}
	
	/*
	 * draws current entry by adding labels and lines on the canvas.
	 */
	private void drawEntry(NameSurferEntry nameSurferEntry, Color c) {
		ArrayList<Pair<Double, Double>> array = new ArrayList<>();
		int graphHeight = getHeight() - 2 * GRAPH_MARGIN_SIZE;
		double xStart  = 0;
		double xIncrement = (double) getWidth() / NDECADES;
		double yProportion = (double) graphHeight / MAX_RANK;
		for (int i = 0; i < NDECADES; i++) {
			double yStart = nameSurferEntry.getRank(i) * yProportion + GRAPH_MARGIN_SIZE;
			String labelText = nameSurferEntry.getName();
			if (nameSurferEntry.getRank(i) == 0) {
				yStart = getHeight() - GRAPH_MARGIN_SIZE;
				labelText += " *";
			}
			else {
				labelText += (" " + nameSurferEntry.getRank(i));
			}
			GLabel label = new GLabel(labelText, xStart, yStart - 5);
			array.add(new Pair<>(xStart,yStart));
			label.setColor(c);
			add(label);
			xStart += xIncrement;
		}
		for (int i = 0; i < array.size() - 1; i++) {
			GLine line = new GLine(array.get(i).getKey(), array.get(i).getValue(), array.get(i+1).getKey(), array.get(i+1).getValue());
			line.setColor(c);
			add(line);
		}
		GLine line = new GLine(array.get(array.size()-2).getKey(), array.get(array.size()-2).getValue(), array.get(array.size()-1).getKey(), array.get(array.size()-1).getValue());
		line.setColor(c);
		add(line);
	}
	
	/*
	 * draws the initial graph.
	 */
	private void drawGraph() {
		GLine upHorizon = new GLine(0, GRAPH_MARGIN_SIZE, getWidth(), GRAPH_MARGIN_SIZE);
		add(upHorizon);
		GLine downHorizon = new GLine(0, getHeight() - GRAPH_MARGIN_SIZE, getWidth(), getHeight() - GRAPH_MARGIN_SIZE);
		add(downHorizon);
		for (int i = 1; i <= NDECADES; i++) {
			GLine vertical = new GLine(i * getWidth() / NDECADES, 0, i * getWidth() / NDECADES, getHeight());
			add(vertical);
			GLabel decade = new GLabel(""+(START_DECADE + (i - 1) * 10));
			add(decade, (i - 1) * getWidth() / NDECADES + 2, getHeight() - 5);
		}
	}
	
	
	/* Implementation of the ComponentListener interface */
	public void componentHidden(ComponentEvent e) { }
	public void componentMoved(ComponentEvent e) { }
	public void componentResized(ComponentEvent e) { update(); }
	public void componentShown(ComponentEvent e) { }
}
