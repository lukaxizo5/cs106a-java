/* 
 * File: FacePamphlet.java
 * -----------------------
 * When it is finished, this program will implement a basic social network
 * management system.
 */

import acm.program.*;
import acm.graphics.*;
import java.awt.event.*;
import java.util.Iterator;

import javax.swing.*;

public class FacePamphlet extends Program 
					implements FacePamphletConstants {

	/**
	 * This method has the responsibility for initializing the 
	 * interactors in the application, and taking care of any other 
	 * initialization that needs to be performed.
	 */
	public void init() {
		database = new FacePamphletDatabase();
		canvas = new FacePamphletCanvas();
		add(canvas);
		addInteractors();
		addAllListeners();
    }
    
	/*
	 * adds all the listeners to the program.
	 */
	private void addAllListeners() {
		statusField.addActionListener(this);
		pictureField.addActionListener(this);
		addField.addActionListener(this);
		addActionListeners();
	}
	
  /*
   * adds the interactors in the program.
   */
    private void addInteractors() {
		JLabel nameLabel = new JLabel("Name");
		add(nameLabel, NORTH);
		nameField = new JTextField(TEXT_FIELD_SIZE);
		add(nameField, NORTH);
		JButton addButton = new JButton("Add");
		add(addButton, NORTH);
		JButton deleteButton = new JButton("Delete");
		add(deleteButton, NORTH);
		JButton lookupButton = new JButton("Lookup");
		add(lookupButton, NORTH);
		statusField = new JTextField(TEXT_FIELD_SIZE);
		add(statusField, WEST);
		JButton statusButton = new JButton("Change Status");
		add(statusButton, WEST);
		addEmptyLabel(); 
		pictureField = new JTextField(TEXT_FIELD_SIZE);
		add(pictureField, WEST);
		JButton pictureButton = new JButton("Change Picture");
		add(pictureButton, WEST);
		addEmptyLabel(); 
		addField = new JTextField(TEXT_FIELD_SIZE);
		add(addField, WEST);
		JButton addFriendButton = new JButton("Add Friend");
		add(addFriendButton, WEST);
	}
    
    /*
     * This method adds the empty label on the west side of the program.
     */
    private void addEmptyLabel() {
    	add(new JLabel(EMPTY_LABEL_TEXT), WEST);
    }

	/**
     * This class is responsible for detecting when the buttons are
     * clicked or interactors are used, so you will have to add code
     * to respond to these actions.
     */
    public void actionPerformed(ActionEvent e) {
    	String command = e.getActionCommand();
    	if (command.equals("Add")) {
    		addClicked();
    	}
    	if (command.equals("Delete")) {
    		deleteClicked();
    	}
    	if (command.equals("Lookup")) {
    		lookupClicked();
    	}
    	if (command.equals("Change Status") || e.getSource() == statusField) {
    		statusChanged();
    	}
    	if (command.equals("Change Picture") || e.getSource() == pictureField) { 
    		pictureChanged();
    	}
    	if (command.equals("Add Friend") || e.getSource() == addField) {
    		friendAdded();
    	}
	}
    
    /*
     * This method is called whenever user tries to create an account.
     */
	private void addClicked() {
    	canvas.removeAll();
		if (!database.containsProfile(nameField.getText())) {
			if (nameField.getText().equals("")) {
				canvas.showMessage("You can not add a profile with an empty name");
				return;
			}
			database.addProfile(new FacePamphletProfile(nameField.getText()));
			canvas.showMessage("New profile created");
		}
		else {
			canvas.showMessage("A profile with the name " + nameField.getText() + " already exists");
		}
		profile = database.getProfile(nameField.getText());
		canvas.displayProfile(profile);
		nameField.setText("");
    }
    
	/*
	 * This method is called whenever user tries to delete an account.
	 */
    private void deleteClicked() {
    	canvas.removeAll();
		if (!database.containsProfile(nameField.getText())) {
			canvas.showMessage("A profile with the name " + nameField.getText() + " does not exist");
		}
		else {
			database.deleteProfile(nameField.getText());
			canvas.showMessage("Profile of " + nameField.getText() + " deleted");
		}
		profile = null;
		nameField.setText("");
    }
    
    /*
	 * This method is called whenever user tries to lookup an account.
	 */
    private void lookupClicked() {
    	canvas.removeAll();
		if (database.containsProfile(nameField.getText())) {
			profile = database.getProfile(nameField.getText());
			canvas.showMessage("Displaying " + nameField.getText());
			canvas.displayProfile(database.getProfile(nameField.getText()));
		}
		else {
			canvas.showMessage("Profile with the name " + nameField.getText() + " does not exist");
			profile = null;
		}
		nameField.setText("");
	}
    
    /*
	 * This method is called whenever user tries to change the status of the current profile.
	 */
    private void statusChanged() {
    	canvas.removeAll();
		if (profile != null) {
			profile.setStatus(statusField.getText());
			canvas.showMessage("Status updated to " + statusField.getText());
			canvas.displayProfile(profile);
		}
		else {
			canvas.showMessage("Please select a profile to change status");
		}
		statusField.setText("");
    }
    
    /*
	 * This method is called whenever user tries to change the picture of the current profile.
	 */
    private void pictureChanged() {
    	canvas.removeAll();
		if (profile != null) {
			GImage image = null;
			try {
				image = new GImage(pictureField.getText());
			} catch (Exception e1) {
				e1.printStackTrace();
				canvas.removeAll();
				canvas.showMessage("Unable to open image file: " + pictureField.getText());
			}
			if (image != null) {
				profile.setImage(image);
    			canvas.showMessage("Picture Updated");
			}
			canvas.displayProfile(profile);
		}
		else {
			canvas.showMessage("Please select a profile to change picture");
		}
		pictureField.setText("");
    }
    
    /*
	 * This method is called whenever user tries to add friend.
	 */
    private void friendAdded() {
    	canvas.removeAll(); 
		if (profile != null) {
			if (database.containsProfile(addField.getText())) {
				boolean isFriend = false;
   				Iterator<String> iterator = profile.getFriends();
				while (iterator.hasNext()) {
					if (iterator.next().equals(addField.getText())) {
						isFriend = true;
						break;
					}
				}
				if (!isFriend) {
					profile.addFriend(addField.getText());
					database.getProfile(addField.getText()).addFriend(profile.getName());
					canvas.showMessage(addField.getText() + " added as a friend");
				}
				else {
					canvas.showMessage(profile.getName() + " already has " + addField.getText() + " as a friend");
				}
			}
			else {
				canvas.showMessage("Profile with the name " + addField.getText() + " does not exist");
			}
			canvas.displayProfile(profile);
		}
		else {
			canvas.showMessage("Please select a profile to add friend");
		}
		addField.setText("");
    }
    
    private JTextField nameField;
    private JTextField statusField;
    private JTextField pictureField;
    private JTextField addField;
    private FacePamphletCanvas canvas;
    private FacePamphletDatabase database;
    private FacePamphletProfile profile;
}
