package lesson6.borderlayout;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Border {
static JFrame f = new JFrame();
static JTextField jTextField = new JTextField();;

static class LoginButtonListener implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		String textVal = jTextField.getText();
		final String youWrote = "You wrote: ";
		jTextField.setText(youWrote + "\""+textVal+"\".");
	}
}

public static void main(String[] args) {
	JPanel p1 = new JPanel();
	p1.setLayout(new BorderLayout());
	
	JLabel jLabel = new JLabel("Type ID");
	JButton loginButton = new JButton("Login");
	loginButton.addActionListener(new LoginButtonListener());
	
	p1.add(jTextField, BorderLayout.NORTH);
	p1.add(jLabel, BorderLayout.SOUTH);
	
	f.add(p1, BorderLayout.NORTH);
	
	f.add(loginButton, BorderLayout.CENTER);
	
	f.setSize(300, 300);
	f.setVisible(true);
}
}
