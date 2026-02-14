import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import acm.graphics.GLabel;
import acm.program.GraphicsProgram;

public class Problem68 extends GraphicsProgram implements ActionListener {
    JTextField txt = new JTextField(15);

    public void run() {
    	addActionListeners();
        JButton enter = new JButton("Enter");
        enter.addActionListener(this); // Link the button to the ActionListener
        add(txt, SOUTH);
        add(enter, SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (s.equals("Enter")) {
            String enteredText = txt.getText();
            GLabel label = new GLabel(enteredText);
            add(label, getWidth() / 2 - label.getWidth() / 2, getHeight() / 2);
            txt.setText("");
        }
    }
}

