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
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Home {

	private JFrame frame;
	private JTextField tb1;
	private JTextField tb2;
	private JTextField tb3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
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
	public Home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 128, 0));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Details");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(161, 21, 124, 25);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel name = new JLabel("Name");
		name.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		name.setBounds(48, 76, 62, 14);
		frame.getContentPane().add(name);
		
		JLabel rollno = new JLabel("Roll no");
		rollno.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		rollno.setBounds(48, 120, 62, 14);
		frame.getContentPane().add(rollno);
		
		JLabel branch = new JLabel("branch");
		branch.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		branch.setBounds(48, 158, 76, 25);
		frame.getContentPane().add(branch);
		
		tb1 = new JTextField();
		tb1.setBounds(199, 73, 86, 20);
		frame.getContentPane().add(tb1);
		tb1.setColumns(10);
		
		tb2 = new JTextField();
		tb2.setBounds(199, 117, 86, 20);
		frame.getContentPane().add(tb2);
		tb2.setColumns(10);
		
		tb3 = new JTextField();
		tb3.setBounds(199, 164, 86, 20);
		frame.getContentPane().add(tb3);
		tb3.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name1 = tb1.getText();
				String rollno1 = tb2.getText();
				int roll = Integer.valueOf(rollno1);
				String branch1 = tb3.getText();
				try {
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/nikhil","root","mysql");
					Statement sta = conn.createStatement();
					String query = "insert into emp values('"+name1+"','"+roll+"','"+branch1+"')";
					sta.executeUpdate(query);
					JOptionPane.showMessageDialog(btnNewButton, "Successful!!");
					sta.close();
					conn.close();
				}
				catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(123, 209, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
