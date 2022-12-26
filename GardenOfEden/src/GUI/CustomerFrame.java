package GUI;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ManagementClasses.ItemSystem;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomerFrame extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_4;
	private JButton jewelrybtn;
	private JLabel lblNewLabel_3;
	private JButton bouquetbtn;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JButton cartbtn;
	private Login L=null;
	AddFlowerframe af= new AddFlowerframe(this);
	AddFlowerJeweleryFrame aj = new AddFlowerJeweleryFrame(this);
	CreateBouquet bouquet = new CreateBouquet(this);
	CartFrame cart = new CartFrame(this);
	
	

	/**
	 * Launch the application.
	 */
	/**public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerFrame frame = new CustomerFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	**/

	/**
	 * Create the frame.
	 */
	public CustomerFrame(Login f) {
		setResizable(false);
		L=f;
		setTitle("Customer Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 734, 461);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(CustomerFrame.class.getResource("/GUI/imanicons/icons8-sakura-48.png")));
		lblNewLabel.setBounds(23, 23, 49, 48);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Lets go on a shopping spree! Which products would you like to buy?");
		lblNewLabel_1.setBounds(82, 23, 622, 48);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 20));
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\hp\\OneDrive\\Desktop\\221 project\\GardenOfEden\\GardenOfEden\\src\\GUI\\imanicons\\icons8-hibiscus-48.png"));
		lblNewLabel_2.setBounds(206, 105, 64, 59);
		contentPane.add(lblNewLabel_2);
		
		JButton flowerbtn = new JButton("Flowers");
		flowerbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				af.setVisible(true);
				setVisible(false);
				
			}
		});
		flowerbtn.setBackground(new Color(232, 57, 132));
		flowerbtn.setForeground(new Color(255, 255, 255));
		flowerbtn.setBounds(269, 116, 152, 35);
		flowerbtn.setFont(new Font("Arial", Font.PLAIN, 16));
		contentPane.add(flowerbtn);
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(CustomerFrame.class.getResource("/GUI/imanicons/icons8-flower-64.png")));
		lblNewLabel_4.setBounds(195, 168, 64, 74);
		contentPane.add(lblNewLabel_4);
		
		jewelrybtn = new JButton("Flower Jewelry");
		jewelrybtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aj.setVisible(true);
				setVisible(false);
			}
		});
		jewelrybtn.setForeground(new Color(255, 255, 255));
		jewelrybtn.setBackground(new Color(15, 215, 135));
		jewelrybtn.setBounds(269, 186, 152, 35);
		jewelrybtn.setFont(new Font("Arial", Font.PLAIN, 16));
		contentPane.add(jewelrybtn);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(CustomerFrame.class.getResource("/GUI/imanicons/icons8-bouquet-48.png")));
		lblNewLabel_3.setBounds(205, 253, 46, 48);
		contentPane.add(lblNewLabel_3);
		
		bouquetbtn = new JButton("Flower Bouquet");
		bouquetbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bouquet.setVisible(true);
				setVisible(false);
			}
		});
		bouquetbtn.setForeground(new Color(255, 255, 255));
		bouquetbtn.setBackground(new Color(238, 169, 6));
		bouquetbtn.setBounds(269, 253, 152, 36);
		bouquetbtn.setFont(new Font("Arial", Font.PLAIN, 16));
		contentPane.add(bouquetbtn);
		
		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(CustomerFrame.class.getResource("/GUI/imanicons/icons8-sakura-48.png")));
		lblNewLabel_5.setBounds(23, 330, 64, 35);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Done Shopping? Lets check-out!");
		lblNewLabel_6.setBounds(82, 330, 319, 35);
		lblNewLabel_6.setFont(new Font("Arial", Font.PLAIN, 20));
		contentPane.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon(CustomerFrame.class.getResource("/GUI/imanicons/icons8-favorite-cart-30.png")));
		lblNewLabel_7.setBounds(479, 377, 30, 35);
		contentPane.add(lblNewLabel_7);
		
		cartbtn = new JButton("Shopping Cart");
		cartbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//CartFrame.getTextAreaCart().setText(AddFlowerframe.str);
				CartFrame.getTextAreaCart().setText(ItemSystem.cartToString());
				cart.setVisible(true);
				setVisible(false);
				
			}
		});
		cartbtn.setBounds(519, 377, 168, 34);
		cartbtn.setFont(new Font("Arial", Font.PLAIN, 16));
		contentPane.add(cartbtn);
	}
}
