/*
 * File: NameSurfer.java
 * ---------------------
 * When it is finished, this program will implements the viewer for
 * the baby-name database described in the assignment handout.
 */

import acm.program.*;
import java.awt.event.*;
import javax.swing.*;


public class NameSurfer extends Program implements NameSurferConstants {
	
/* Method: init() */
/**
 * This method has the responsibility for reading in the data base
 * and initializing the interactors at the bottom of the window.
 */
	public void init() {
		graph = new NameSurferGraph();
		database = new NameSurferDataBase(NAMES_DATA_FILE);
		add(graph);
		addInteractors();
		addActionListeners();
	}
	/*
	 * adds the buttons and the textfield.
	 */
	private void addInteractors() {
		JLabel nameLabel = new JLabel("Name");
		add(nameLabel, SOUTH);
		textField = new JTextField(15);
		add(textField, SOUTH);
		JButton graphButton = new JButton("Graph");
		add(graphButton, SOUTH);
		JButton clearButton = new JButton("Clear");
		add(clearButton, SOUTH);
		textField.addActionListener(this);
	}

/* Method: actionPerformed(e) */
/**
 * This class is responsible for detecting when the buttons are
 * clicked, so you will have to define a method to respond to
 * button actions.
 */
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		
		if (command.equals("Graph") || e.getSource() == textField) {
			String name = modify(textField.getText());
			if (database.findEntry(name) != null && !graph.getEntries().contains(database.findEntry(name))) {
				graph.addEntry(database.findEntry(name));
				graph.update();
			}
			textField.setText("");
		}
		else if (command.equals("Clear")) {
			graph.clear();
		}
	}
	
	/*
	 * modifies string in a way that it is in the database.
	 * Example: lizzie -> Lizzie. LUKE -> Luke.
	 */
	private String modify(String text) {
		String s = "";
		if (text.length() == 0) {
			return null;
		}
		s += Character.toUpperCase(text.charAt(0));
		for (int i = 1; i < text.length(); i++) {
			s += Character.toLowerCase(text.charAt(i));
		}
		return s;
	}

	private NameSurferGraph graph;
	private NameSurferDataBase database;
	private JTextField textField;
}
