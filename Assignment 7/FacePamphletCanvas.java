/*
 * File: FacePamphletCanvas.java
 * -----------------------------
 * This class represents the canvas on which the profiles in the social
 * network are displayed.  NOTE: This class does NOT need to update the
 * display when the window is resized.
 */


import acm.graphics.*;
import java.awt.*;
import java.util.*;

public class FacePamphletCanvas extends GCanvas 
					implements FacePamphletConstants {
	
	double nameAscent;
	
	/** 
	 * Constructor
	 * This method takes care of any initialization needed for 
	 * the display
	 */
	public FacePamphletCanvas() {
	}
	
	/** 
	 * This method displays a message string near the bottom of the 
	 * canvas.  Every time this method is called, the previously 
	 * displayed message (if any) is replaced by the new message text 
	 * passed in.
	 */
	public void showMessage(String msg) {
		GLabel label = new GLabel(msg);
		label.setLocation(new GPoint((getWidth() - label.getWidth()) / 2, getHeight() - BOTTOM_MESSAGE_MARGIN));
		label.setFont(MESSAGE_FONT);
		add(label);
	}
	
	
	/** 
	 * This method displays the given profile on the canvas.  The 
	 * canvas is first cleared of all existing items (including 
	 * messages displayed near the bottom of the screen) and then the 
	 * given profile is displayed.  The profile display includes the 
	 * name of the user from the profile, the corresponding image 
	 * (or an indication that an image does not exist), the status of
	 * the user, and a list of the user's friends in the social network.
	 */
	public void displayProfile(FacePamphletProfile profile) {
		displayName(profile.getName());
		displayStatus(profile.getName(), profile.getStatus());
		displayImage(profile.getImage());
		displayFriendList(profile.getFriends());
	}

	/*
	 *  displays the list of friends of the current profile on the canvas.
	 */
	private void displayFriendList(Iterator<String> friends) {
		GLabel label = new GLabel("Friends: ");
		label.setFont(PROFILE_FRIEND_LABEL_FONT);
		add(label, (getWidth() - label.getWidth()) / 2, TOP_MARGIN + nameAscent + IMAGE_MARGIN + label.getAscent());
		double nameStart = TOP_MARGIN + nameAscent + IMAGE_MARGIN + label.getAscent(); 
		while (friends.hasNext()) {
			String name = friends.next();
			GLabel nameLabel = new GLabel(name);
			nameLabel.setFont(PROFILE_FRIEND_FONT);
			nameStart += nameLabel.getHeight();
			add(nameLabel, (getWidth() - label.getWidth()) / 2, nameStart);
		}
	}

	/*
	 *  displays the image of the current profile on the canvas.
	 */
	private void displayImage(GImage image) {
		if (image != null) {
			image.scale(IMAGE_WIDTH / image.getWidth(), IMAGE_HEIGHT / image.getHeight());
			add(image, LEFT_MARGIN, TOP_MARGIN + nameAscent + IMAGE_MARGIN);
		}
		else {
			GRect imageRect = new GRect(IMAGE_WIDTH, IMAGE_HEIGHT);
			GLabel label = new GLabel("No Image");
			label.setFont(PROFILE_IMAGE_FONT);
			add(imageRect, LEFT_MARGIN, TOP_MARGIN + nameAscent + IMAGE_MARGIN);
			label.setLocation(new GPoint(LEFT_MARGIN + (imageRect.getWidth() - label.getWidth()) / 2, TOP_MARGIN + nameAscent + IMAGE_MARGIN + (imageRect.getHeight() + label.getAscent()) / 2));
			add(label);
		}
	}

	/*
	 *  displays the status of the current profile on the canvas.
	 */
	private void displayStatus(String name, String status) {
		String statusString = name + " is " + status;
		if (status.equals(" ")) {
			statusString = "No current status";
		}
		GLabel label = new GLabel(statusString);
		label.setFont(PROFILE_STATUS_FONT);
		label.setLocation(new GPoint(LEFT_MARGIN, TOP_MARGIN + nameAscent + IMAGE_MARGIN + IMAGE_HEIGHT + STATUS_MARGIN + label.getAscent()));
		add(label);
	}

	/*
	 *  displays the name of the current profile on the canvas.
	 */
	private void displayName(String name) {
		GLabel label = new GLabel(name);
		label.setColor(Color.BLUE);
		label.setFont(PROFILE_NAME_FONT);
		label.setLocation(new GPoint(LEFT_MARGIN, TOP_MARGIN + label.getAscent()));
		add(label);
		nameAscent = label.getAscent();
	}
	
}