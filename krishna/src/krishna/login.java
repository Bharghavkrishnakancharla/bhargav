package krishna;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class login {

	private JFrame frame;
	private JTextField tb1;
	private JTextField tb2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(128, 128, 128));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login Page ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(168, 11, 124, 24);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel name = new JLabel("Username");
		name.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		name.setBounds(53, 85, 94, 14);
		frame.getContentPane().add(name);
		
		JLabel pwd = new JLabel("Password");
		pwd.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		pwd.setBounds(53, 149, 94, 14);
		frame.getContentPane().add(pwd);
		
		tb1 = new JTextField();
		tb1.setBounds(217, 82, 86, 20);
		frame.getContentPane().add(tb1);
		tb1.setColumns(10);
		
		tb2 = new JTextField();
		tb2.setBounds(217, 143, 86, 20);
		frame.getContentPane().add(tb2);
		tb2.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = tb1.getText();
				String pwd = tb2.getText();
				try {
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/nikhil","root","mysql");
					PreparedStatement st = conn.prepareStatement("select username,password from employee where username=? and password=?");
					st.setString(1, name);
					st.setString(2, pwd);
					ResultSet rs = st.executeQuery();
					if(rs.next()) {
						JOptionPane.showMessageDialog(btnNewButton, "valid user");
					}
					else {
						JOptionPane.showMessageDialog(btnNewButton, "Invalid user!");
					}
//					while(rs.next()) {
//						String uname = rs.getString("username");
//						String pass = rs.getString("password");
//						if(uname.equals(name) && pass.equals(pwd)){
						
//					}
				}
				catch(Exception e1) {
					e1.printStackTrace();
					
				}
				
			}
		});
		btnNewButton.setBounds(134, 202, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}

}
