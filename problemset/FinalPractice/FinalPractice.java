package finalsPractice;

import java.awt.event.ActionEvent;

import javax.swing.JButton;

import acm.program.Program;

/*
 * program that prints Clicked when the mouse is clicked on its only button
 */

public class FinalPractice extends Program{
	public void run(){
		JButton but = new JButton("Click Me"); 
		add(but, SOUTH);
		but.addActionListener(this);
	}
	
	@Override 
	public void actionPerformed(ActionEvent e){
		if (e.getActionCommand().equals("Click Me")) {
			println("Clicked");
		}
	}
}
