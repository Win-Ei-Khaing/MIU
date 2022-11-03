package librarysystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JOptionPane;


public class LoginWindow extends JFrame implements LibWindow {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final LoginWindow INSTANCE = new LoginWindow();
	
	private boolean isInitialized = false;
	
	private JPanel mainPanel;
	private JPanel upperHalf;
	private JPanel middleHalf;
	//private JPanel lowerHalf;
	
	private JPanel topPanel;
	private JPanel middlePanel;
	private JPanel lowerPanel;
	private JPanel leftTextPanel;
	private JPanel rightTextPanel;
	
	private JTextField userid;
	private JTextField password;
	//private JLabel label;
	private JButton loginButton;
	
	public boolean isInitialized() {
		return isInitialized;
	}
	public void isInitialized(boolean val) {
		isInitialized = val;
	}
	private JTextField messageBar = new JTextField();
	public void clear() {
		messageBar.setText("");
	}
	
	/* This class is a singleton */
    private LoginWindow () {}
    
    public void init() {     		
    		mainPanel = new JPanel();
    		defineUpperHalf();
    		defineMiddleHalf();
    		//defineLowerHalf();
    		BorderLayout bl = new BorderLayout();
    		bl.setVgap(30);
    		mainPanel.setLayout(bl);
    					
    		mainPanel.add(upperHalf, BorderLayout.NORTH);
    		mainPanel.add(middleHalf, BorderLayout.CENTER);
    		//mainPanel.add(lowerHalf, BorderLayout.SOUTH);
    		getContentPane().add(mainPanel);
    		isInitialized(true);
    		pack();
    		setSize(400, 250);
    }
    
    private void defineUpperHalf() {
    		
    		upperHalf = new JPanel();
    		upperHalf.setLayout(new BorderLayout());
    		defineTopPanel();
    		defineMiddlePanel();
    		defineLowerPanel();
    		upperHalf.add(topPanel, BorderLayout.NORTH);
    		upperHalf.add(middlePanel, BorderLayout.CENTER);
    		upperHalf.add(lowerPanel, BorderLayout.SOUTH);
    		
    	}
    	private void defineMiddleHalf() {
    		middleHalf = new JPanel();
    		middleHalf.setLayout(new BorderLayout());
    		JSeparator s = new JSeparator();
    		s.setOrientation(SwingConstants.HORIZONTAL);
    		//middleHalf.add(Box.createRigidArea(new Dimension(0,50)));
    		middleHalf.add(s, BorderLayout.SOUTH);
    		
    	}
    	/*private void defineLowerHalf() {

    		lowerHalf = new JPanel();
    		lowerHalf.setLayout(new FlowLayout(FlowLayout.LEFT));
    		
    		JButton backButton = new JButton("<= Back to Main");
    		addBackButtonListener(backButton);
    		lowerHalf.add(backButton);
    		
    	}*/
    	private void defineTopPanel() {
    		topPanel = new JPanel();
    		JPanel intPanel = new JPanel(new BorderLayout());
    		intPanel.add(Box.createRigidArea(new Dimension(0,20)), BorderLayout.NORTH);
    		JLabel loginLabel = new JLabel("Login");
    		Util.adjustLabelFont(loginLabel, Color.BLUE.darker(), true);
    		intPanel.add(loginLabel, BorderLayout.CENTER);
    		topPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
    		topPanel.add(intPanel);
    		
    	}
    	
    	private void defineMiddlePanel() {
    		middlePanel=new JPanel();
    		middlePanel.setLayout(new BorderLayout());
    		deineUseridTextPanel();
    		definePasswordTextPanel();
    		middlePanel.add(leftTextPanel, BorderLayout.CENTER);
    		middlePanel.add(rightTextPanel, BorderLayout.SOUTH);
    	}
    	private void defineLowerPanel() {
    		lowerPanel = new JPanel();
    		loginButton = new JButton("Login");
    		addLoginButtonListener(loginButton);
    		lowerPanel.add(loginButton);
    	}

    	private void deineUseridTextPanel() {
    		
    		//JPanel topText = new JPanel();
    		JPanel bottomText = new JPanel();
    		//topText.setLayout(new FlowLayout(FlowLayout.CENTER));
    		bottomText.setLayout(new FlowLayout(FlowLayout.CENTER));		
    		
    		userid = new JTextField(15);
    		new TextPrompt("Enter User ID", userid);
    		userid.setFont(Util.makeSmallFont(userid.getFont()));
    		//label = new JLabel("User ID");
    		//label.setFont(Util.makeSmallFont(label.getFont()));    		
    		//topText.add(label);
    		bottomText.add(userid);
    		
    		leftTextPanel = new JPanel();
    		leftTextPanel.setLayout(new BorderLayout());
    		//leftTextPanel.add(topText,BorderLayout.CENTER);
    		leftTextPanel.add(bottomText,BorderLayout.SOUTH);
    	}
    	private void definePasswordTextPanel() {
    		
    		//JPanel topText = new JPanel();
    		JPanel bottomText = new JPanel();
    		//topText.setLayout(new FlowLayout(FlowLayout.CENTER));
    		bottomText.setLayout(new FlowLayout(FlowLayout.CENTER));		
    		
    		password = new JPasswordField(15);
    		new TextPrompt("Enter Password", password);
    		password.setFont(Util.makeSmallFont(password.getFont()));
    		//label = new JLabel("Password");
    		//label.setFont(Util.makeSmallFont(label.getFont()));
    		//topText.add(label);
    		bottomText.add(password);
    		
    		rightTextPanel = new JPanel();
    		rightTextPanel.setLayout(new BorderLayout());
    		//rightTextPanel.add(topText,BorderLayout.CENTER);
    		rightTextPanel.add(bottomText,BorderLayout.SOUTH);
    	}
    	
    	/*private void addBackButtonListener(JButton butn) {
    		butn.addActionListener(evt -> {
    			LibrarySystem.hideAllWindows();
    			LibrarySystem.INSTANCE.setVisible(true);
    		});
    	}*/
    	
    	private void addLoginButtonListener(JButton butn) {
    		butn.addActionListener(evt -> {
    			JOptionPane.showMessageDialog(this,"Successful Login");
    				
    		});
    	}
}
