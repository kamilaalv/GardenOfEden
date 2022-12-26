package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import InheritanceClasses.FlowerJewelry;
import ManagementClasses.ItemSystem;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class AddFlowerJeweleryFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddFlowerJeweleryFrame frame = new AddFlowerJeweleryFrame();
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
	public AddFlowerJeweleryFrame(CustomerFrame cust) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 450);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel lblNewLabel = new JLabel("Select Flower Jewelry Attributes");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		lblNewLabel.setBounds(116, 11, 306, 50);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Jewelry Type:");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(280, 103, 125, 30);
		contentPane.add(lblNewLabel_1);
		
		JComboBox JewelryType = new JComboBox();
		JewelryType.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		JewelryType.setModel(new DefaultComboBoxModel(new String[] {"Necklace", "Headwear", "Earings", "Bracelet"}));
		JewelryType.setBounds(406, 106, 88, 26);
		contentPane.add(JewelryType);
		
		JLabel lblNewLabel_4 = new JLabel("Real or Fake Flowers?");
		lblNewLabel_4.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(280, 159, 214, 30);
		contentPane.add(lblNewLabel_4);
		
		JRadioButton rdbtnFake = new JRadioButton("Fake");
		rdbtnFake.setBackground(Color.WHITE);
		rdbtnFake.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		rdbtnFake.setBounds(294, 209, 88, 23);
		contentPane.add(rdbtnFake);
		
		JRadioButton rdbtnReal = new JRadioButton("Real");
		rdbtnReal.setBackground(Color.WHITE);
		rdbtnReal.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		rdbtnReal.setBounds(384, 209, 109, 23);
		contentPane.add(rdbtnReal);
		
		JLabel lblDisplayError = new JLabel("");
		lblDisplayError.setForeground(new Color(128, 0, 128));
		lblDisplayError.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		lblDisplayError.setBounds(294, 342, 197, 22);
		contentPane.add(lblDisplayError);
		
		JLabel lblNewLabel_2 = new JLabel("Price:");
		lblNewLabel_2.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(294, 268, 63, 22);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblPrice = new JLabel("New label");
		lblPrice.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		lblPrice.setBounds(367, 268, 127, 22);
		contentPane.add(lblPrice);
		
		JButton btnAdd = new JButton("Add to Cart");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String flowerJewelryType = (String) JewelryType.getSelectedItem();
				boolean res = false;
				FlowerJewelry item = null;
				
				if(rdbtnFake.isSelected() && !(rdbtnReal.isSelected())) {
					res = ItemSystem.addFlowerJewelry( 1, flowerJewelryType, false);
					if(res == false) {
						lblDisplayError.setText("Could not be added!");
					} else {
					item = new FlowerJewelry(flowerJewelryType,false);
					lblDisplayError.setText("");
					lblPrice.setText(item.getItemPrice() + "");
					}
				}
				else if(!(rdbtnFake.isSelected()) && rdbtnReal.isSelected()) {
					res = ItemSystem.addFlowerJewelry( 1, flowerJewelryType, true);
					if(res == false) {
						lblDisplayError.setText("Could not be added!");
					} else {
					item = new FlowerJewelry(flowerJewelryType,true);
					lblDisplayError.setText("");
					lblPrice.setText(item.getItemPrice() + "");
					}
				}
				else {
					lblDisplayError.setText("Please select one option!");
				}
					
			}
		});
		btnAdd.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		btnAdd.setBounds(271, 301, 125, 30);
		contentPane.add(btnAdd);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cust.setVisible(true);
				setVisible(false);
			}
		});
		btnGoBack.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		btnGoBack.setBounds(406, 301, 97, 30);
		contentPane.add(btnGoBack);
		
		
		
		JLabel lblJewelpic = new JLabel("New label");
		lblJewelpic.setIcon(new ImageIcon(AddFlowerframe.class.getResource("/GUI/ahmetImages/jewelry.jpeg")));
		lblJewelpic.setBounds(36, 92, 197, 200);
		lblJewelpic.setOpaque(true);
		contentPane.add(lblJewelpic);
		
		JLabel lblbground = new JLabel("");
		lblbground.setBackground(Color.WHITE);
		lblbground.setBounds(0, 0, 534, 411);
		lblbground.setIcon(new ImageIcon(AddFlowerframe.class.getResource("/GUI/ahmetImages/jewelrybackground1.jpeg")));
		lblbground.setOpaque(true);
		contentPane.add(lblbground);
		
		
	}
}
