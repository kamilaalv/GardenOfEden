package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import ManagementClasses.ItemSystem;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;

public class CartFrame extends JFrame {

	private JPanel contentPane;
	private JTextField getIdField;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CartFrame frame = new CartFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public CartFrame(CustomerFrame cust) {
		setResizable(false);
		setTitle("CartFrame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 712, 504);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Items in Cart");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel.setBounds(64, 17, 143, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Would you like to delete anything from the cart?");
		lblNewLabel_1.setIcon(null);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(352, 71, 334, 32);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("(Enter item id)");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(352, 101, 185, 24);
		contentPane.add(lblNewLabel_2);
		
		getIdField = new JTextField();
		getIdField.setForeground(new Color(0, 0, 0));
		getIdField.setBounds(405, 138, 198, 32);
		contentPane.add(getIdField);
		getIdField.setColumns(10);
		
		JLabel ErrorMsg = new JLabel("");
		ErrorMsg.setForeground(new Color(255, 128, 64));
		ErrorMsg.setFont(new Font("Arial", Font.PLAIN, 14));
		ErrorMsg.setBounds(335, 180, 334, 32);
		contentPane.add(ErrorMsg);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(CartFrame.class.getResource("/GUI/kamilaIcons/ButterflyBlue.png")));
		lblNewLabel_3.setBounds(310, 71, 53, 54);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setIcon(new ImageIcon(CartFrame.class.getResource("/GUI/kamilaIcons/ButterflyPink.png")));
		lblNewLabel_3_1.setBounds(20, 10, 46, 45);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Continue Shopping?");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(352, 229, 143, 32);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("");
		lblNewLabel_3_2.setIcon(new ImageIcon(CartFrame.class.getResource("/GUI/kamilaIcons/ButterflyYellow.png")));
		lblNewLabel_3_2.setBounds(310, 207, 53, 54);
		contentPane.add(lblNewLabel_3_2);
		
		JButton returnToCustomer = new JButton("Yes");
		returnToCustomer.setBackground(new Color(255, 255, 255));
		returnToCustomer.setFont(new Font("Arial", Font.BOLD, 12));
		returnToCustomer.setBounds(405, 268, 198, 35);
		contentPane.add(returnToCustomer);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Done Shopping?");
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(352, 334, 143, 32);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_3_2_1 = new JLabel("");
		lblNewLabel_3_2_1.setIcon(new ImageIcon(CartFrame.class.getResource("/GUI/kamilaIcons/ButterflyPink.png")));
		lblNewLabel_3_2_1.setBounds(310, 316, 53, 54);
		contentPane.add(lblNewLabel_3_2_1);
		
		JButton Buy = new JButton("Purchase");
		Buy.setBackground(new Color(255, 255, 255));
		Buy.setFont(new Font("Arial", Font.BOLD, 12));
		Buy.setBounds(405, 373, 198, 35);
		contentPane.add(Buy);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 65, 253, 376);
		contentPane.add(scrollPane);
		
		JTextArea textAreaCart = new JTextArea();
		scrollPane.setViewportView(textAreaCart);
		System.out.println(ItemSystem.cartToString());
		textAreaCart.setText(ItemSystem.cartToString());
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(CartFrame.class.getResource("/GUI/kamilaIcons/bg0.jpg")));
		lblNewLabel_4.setBounds(-459, 17, 1157, 585);
		contentPane.add(lblNewLabel_4);
		
		
	}
}
