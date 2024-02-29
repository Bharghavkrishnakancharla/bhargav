import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Home {

	private JFrame frame;
	private final ButtonGroup buttonGroup = new ButtonGroup();

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
		frame.getContentPane().setBackground(new Color(255, 128, 255));
		frame.getContentPane().setForeground(new Color(255, 0, 255));
		frame.getContentPane().setLayout(null);
		
		JButton book1 = new JButton("");
		book1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		book1.setIcon(new ImageIcon("C:\\Users\\online\\Pictures\\Camera Roll\\newaynrand.png"));
		book1.setBounds(62, 95, 341, 417);
		frame.getContentPane().add(book1);
		
		JButton book2 = new JButton("");
		book2.setIcon(new ImageIcon("C:\\Users\\online\\Pictures\\Camera Roll\\alchemist.jfif"));
		book2.setBounds(443, 95, 289, 417);
		frame.getContentPane().add(book2);
		
		JLabel heading = new JLabel("Book Store");
		heading.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 38));
		heading.setBounds(300, 11, 247, 46);
		frame.getContentPane().add(heading);
		
		JLabel cart = new JLabel("Cart");
		cart.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));
		cart.setBounds(737, 24, 46, 14);
		frame.getContentPane().add(cart);
		JLabel cartvalue = new JLabel("0");
		cartvalue.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cartvalue.setBounds(783, 28, 46, 14);
		frame.getContentPane().add(cartvalue);
		
		JButton buy = new JButton("Buy");
		buy.setBounds(373, 612, 89, 23);
		frame.getContentPane().add(buy);
		
		JLabel dummy1 = new JLabel("0");
		dummy1.setVisible(false);
		dummy1.setBounds(390, 567, 46, 14);
//		fr)
		JLabel dummy2 = new JLabel("0");
		dummy2.setVisible(false);
		dummy2.setBounds(390, 567, 46, 14);
//		frame.getContentPane().add(dummy2);
		
		ImageIcon img = new ImageIcon("C:\\Users\\online\\Pictures\\Camera Roll\\Girl_in_room_105.png");
		 book1.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 String boo = dummy1.getText();
				 int booans = Integer.valueOf(boo)+1;
				 dummy1.setText(String.valueOf(booans));
				 String res = cartvalue.getText();
				 int ans = Integer.valueOf(res)+1;
				 cartvalue.setText(String.valueOf(ans));
			 }
		 });
		 book2.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 String boo = dummy2.getText();
				 int booans = Integer.valueOf(boo)+1;
				 dummy2.setText(String.valueOf(booans));
				 String res = cartvalue.getText();
				 int ans = Integer.valueOf(res)+1;
				 cartvalue.setText(String.valueOf(ans));
			 }
		 });
		 buy.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 String book1cnt = dummy1.getText();
				 String book2cnt = dummy2.getText();
				 int cost = Integer.valueOf(book1cnt)*500+Integer.valueOf(book2cnt)*400;
				 JOptionPane.showMessageDialog(frame, "Cost to be payed:"+cost);
			 }
		 });
		frame.setBounds(0, 0, 1340, 1200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
