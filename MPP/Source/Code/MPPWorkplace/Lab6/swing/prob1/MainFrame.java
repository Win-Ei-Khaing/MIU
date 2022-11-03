package swing.prob1;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 * 
 * @author wineikhaing
 *
 */

@SuppressWarnings("serial")
public class MainFrame extends JFrame{

	private static final int maxWidth = 700;
	private static final int maxLength = 400;
	JPanel borders;
	JPanel cards;
	ListItem item1;
	ListItem item2;
	ListItem item3;

	//common usage
	JList<ListItem> menuList;
	JList<String> titleList;
	static JTextArea footerText = new JTextArea("Welcome to the Book Club!");
	JTextArea txtAreaForBooks = new JTextArea("");
	//List<String> lstBooks = new ArrayList<String>();

	//login page
	static JTextField txtUsername=new JTextField(20);
	static JPasswordField txtPassword=new JPasswordField(20);

	static JTextField txtAuthorFirst=new JTextField(20);
	static JTextField txtAuthorLast=new JTextField(20);
	static JTextField txtBookTitle=new JTextField(20);

	public MainFrame() {
		setSize(maxWidth, maxLength);
		//create list menu items
		createLinkLabels();
		//create card panels to positions
		createPanels();	
		//merge them into split pane
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, menuList, cards);
		splitPane.setDividerLocation(100);
		//add border
		Border blackline = BorderFactory.createLineBorder(Color.black);
		splitPane.setBorder(blackline);
		add(splitPane, BorderLayout.CENTER);

		//to make height wider
		footerText.setRows(5);
		//to show blue texts
		footerText.setForeground(Color.BLUE);

		add(footerText, BorderLayout.SOUTH);
	}

	public void createLinkLabels() {
		item1 = new ListItem("Login", true);
		item2 = new ListItem("View Titles", false);
		item3 = new ListItem("Add Book", false);

		DefaultListModel<ListItem> model = new DefaultListModel<>();
		model.addElement(item1);
		model.addElement(item2);
		model.addElement(item3);
		menuList = new JList<ListItem>(model);
		menuList.setCellRenderer(new DefaultListCellRenderer() {

			@SuppressWarnings("rawtypes")
			@Override
			public Component getListCellRendererComponent(JList list, 
					Object value, int index,
					boolean isSelected, boolean cellHasFocus) {
				Component c = super.getListCellRendererComponent(list, 
						value, index, isSelected, cellHasFocus);
				if (value instanceof ListItem) {
					ListItem nextItem = (ListItem) value;
					setText(nextItem.getItemName());
					if (nextItem.highlight()) {
						setForeground(Util.LINK_AVAILABLE);
					} else {
						setForeground(Util.LINK_NOT_AVAILABLE);
					}
					if (isSelected) {
						setForeground(Color.BLACK);
						setBackground(new Color(236,243,245));
					}
				} else {
					setText("illegal item");
				}
				return c;
			}

		});

		menuList.addListSelectionListener(event -> {
			String value = menuList.getSelectedValue().getItemName();
			boolean allowed = menuList.getSelectedValue().highlight();
			System.out.println(value + " " + allowed);

			CardLayout cl = (CardLayout) (cards.getLayout());

			if (!allowed) {
				value = item1.getItemName();
				menuList.setSelectedIndex(0);
			}
			cl.show(cards, value);
			footerText.setText("");
		});
	}

	public void createPanels() {
		JPanel pnlLogin = createLoginPanel();

		JPanel pnlViewDetails = createViewTitlePanel();

		JPanel pnlAddBook = createAddBookPanel();

		cards = new JPanel(new CardLayout());
		cards.add(pnlLogin, "Login");
		cards.add(pnlViewDetails, "View Titles");
		cards.add(pnlAddBook, "Add Book");

		menuList.addListSelectionListener(event -> {
			String value = menuList.getSelectedValue().getItemName().toString();
			CardLayout cl = (CardLayout) (cards.getLayout());
			cl.show(cards, value);
		});
	}

	private JPanel createLoginPanel() {
		JPanel pnlLogin = new JPanel(); 
		pnlLogin.setLayout(new GridBagLayout());  

		GridBagConstraints c = new GridBagConstraints();

		c.gridx=0;
		c.gridy=0;
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setForeground(Color.BLUE);
		lblLogin.setFont (lblLogin.getFont ().deriveFont (18.0f));
		pnlLogin.add(lblLogin, c);

		c.gridx=0;
		c.gridy=2;
		c.gridwidth = 2;  
		pnlLogin.add(txtUsername, c);

		c.gridx=2;
		pnlLogin.add(txtPassword, c);

		c.gridx=0;
		c.gridy=3;
		c.gridwidth = 1;  
		JLabel lblName = new JLabel("Username");
		pnlLogin.add(lblName, c);

		c.gridx=2;
		JLabel lblPassword = new JLabel("Password");
		pnlLogin.add(lblPassword, c);

		c.gridx=2;
		c.gridy=4;
		c.gridwidth = 1; 
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new LoginButtonListener());
		pnlLogin.add(btnLogin, c);

		return pnlLogin;
	}

	private JPanel createViewTitlePanel() {
		JPanel pnlViewDetails = new JPanel(); 
		pnlViewDetails.setLayout(new BorderLayout());  

		JLabel lblTitle = new JLabel("View Titles");
		lblTitle.setForeground(Color.BLUE);
		lblTitle.setFont (lblTitle.getFont ().deriveFont (18.0f));
		pnlViewDetails.add(lblTitle, BorderLayout.NORTH);

		String strBooks = "";
		for(String s : Data.bookTitles) {
			strBooks += s + "\n";
		}
		txtAreaForBooks.setText(strBooks);

		JScrollPane scrollPane = new JScrollPane(txtAreaForBooks);
		pnlViewDetails.add(scrollPane, BorderLayout.CENTER);
		return pnlViewDetails;
	}

	private JPanel createAddBookPanel() {
		JPanel pnlBook = new JPanel();
		pnlBook.setLayout(new BorderLayout());
		JLabel lblAddBookTitle = new JLabel("Add Book Title");
		lblAddBookTitle.setFont (lblAddBookTitle.getFont ().deriveFont (18.0f));
		lblAddBookTitle.setForeground(Color.BLUE);
		pnlBook.add(lblAddBookTitle, BorderLayout.NORTH);
		
		JPanel pnlAdd = new JPanel(); 
		pnlAdd.setLayout(new GridBagLayout());  

		GridBagConstraints c = new GridBagConstraints();
		
		c.gridx=0;
		c.gridy=0;
		c.gridwidth = 1;  
		JLabel lblFirstName = new JLabel("Author First Name");
		pnlAdd.add(lblFirstName, c);

		c.gridx=1;
		pnlAdd.add(txtAuthorFirst, c);

		c.gridx=0;
		c.gridy=1;  
		JLabel lblLastname = new JLabel("Author Last Name");
		pnlAdd.add(lblLastname, c);

		c.gridx=1;
		pnlAdd.add(txtAuthorLast, c);

		c.gridx=0;
		c.gridy=2; 
		JLabel lblBookTitle = new JLabel("Book Title");
		pnlAdd.add(lblBookTitle, c);

		c.gridx=1;
		pnlAdd.add(txtBookTitle, c);

		c.gridx=1;
		c.gridy=3;
		JButton btnAdd = new JButton("Add Book");
		btnAdd.addActionListener(new AddBookButtonListener());
		pnlAdd.add(btnAdd, c);

		pnlBook.add(pnlAdd, BorderLayout.CENTER);
		return pnlBook;
	}

	//login button click event
	class LoginButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String username = txtUsername.getText();
			String password = new String(txtPassword.getPassword());
			if(username.length() == 0 || password.length() == 0) {
				footerText.setText("Id and Password fields must be nonempty");
				footerText.setForeground(Color.RED);
			}
			else {
				List<User> userList = Data.logins;
				User testUser = new User(username, password, null);
				User result = Util.findUser(userList, testUser);
				if(result != null) {
					footerText.setText("Login successful");
					footerText.setForeground(Color.GREEN);

					//to do next
					if(result.authorization == Auth.MEMBER)
						updateList(new ListItem[] { item1, item2});
					else if(result.authorization == Auth.SELLER)
						updateList(new ListItem[] { item1, item3});
					else
						updateList(new ListItem[] { item1, item2 , item3});
					repaint();
				}
				else {
					footerText.setText("Login failed!");
					footerText.setForeground(Color.RED);
					updateList(new ListItem[] {});
				}
			}
		}
	}

	//add button click event
	class AddBookButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			//String authorFirstName = txtAuthorFirst.getText();
			//String authorLastName = txtAuthorLast.getText();
			String bookTitle = txtBookTitle.getText();
			Data.addBookTitle(bookTitle);
			footerText.setText("");
			footerText.setText("The book a has been added to the collection!");
			footerText.setForeground(Color.GREEN);
			
			String strBooks = "";
			for(String s : Data.bookTitles) {
				strBooks += s + "\n";
			}
			txtAreaForBooks.setText(strBooks);
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void updateList(ListItem[] items) {
		DefaultListModel<ListItem> model = (DefaultListModel) menuList.getModel();
		int size = model.getSize();
		if (items != null) {
			java.util.List<Integer> indices = new ArrayList<>();
			for (ListItem item : items) {
				int index = model.indexOf(item);
				indices.add(index);
				ListItem next = (ListItem) model.get(index);
				next.setHighlight(true);

			}
			for (int i = 0; i < size; ++i) {
				if (!indices.contains(i)) {
					ListItem next = (ListItem) model.get(i);
					next.setHighlight(false);
				}
			}
		} else {
			for (int i = 0; i < size; ++i) {
				ListItem next = (ListItem) model.get(i);
				next.setHighlight(true);
			}
		}
	}
}
