package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class AddInventory extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddInventory frame = new AddInventory();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddInventory() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 839, 667);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Flower Inventory");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(21, 9, 152, 27);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Date:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBackground(new Color(255, 128, 128));
		lblNewLabel_1_1.setBounds(449, 10, 90, 27);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Money:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(579, 10, 90, 27);
		contentPane.add(lblNewLabel_1_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 47, 407, 273);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1_3 = new JLabel("Jewelry Inventory");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_3.setBounds(10, 330, 152, 27);
		contentPane.add(lblNewLabel_1_3);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(28, 358, 351, 155);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		JLabel lblNewLabel = new JLabel("Flower Type:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(471, 82, 102, 32);
		contentPane.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(583, 82, 168, 32);
		contentPane.add(comboBox);
		
		JLabel lblFlowerQuantity = new JLabel("Flower Quantity:");
		lblFlowerQuantity.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFlowerQuantity.setBounds(554, 146, 128, 32);
		contentPane.add(lblFlowerQuantity);
		
		JButton btnNewButton = new JButton("+");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(503, 209, 56, 32);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("-");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(680, 209, 56, 32);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("0");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(608, 209, 11, 32);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("0");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1.setBounds(608, 457, 11, 32);
		contentPane.add(lblNewLabel_2_1);
		
		JButton btnNewButton_2 = new JButton("+");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_2.setBounds(503, 457, 56, 32);
		contentPane.add(btnNewButton_2);
		
		JLabel lblJewelryQuantity = new JLabel("Jewelry Quantity:");
		lblJewelryQuantity.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblJewelryQuantity.setBounds(554, 394, 128, 32);
		contentPane.add(lblJewelryQuantity);
		
		JButton btnNewButton_1_1 = new JButton("-");
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1_1.setBounds(680, 457, 56, 32);
		contentPane.add(btnNewButton_1_1);
		
		JLabel lblJewelryType = new JLabel("Jewelry Type:");
		lblJewelryType.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblJewelryType.setBounds(471, 330, 102, 32);
		contentPane.add(lblJewelryType);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(583, 330, 168, 32);
		contentPane.add(comboBox_1);
		
		JButton btnNewButton_3 = new JButton("BUY");
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_3.setBounds(568, 536, 114, 44);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_3 = new JLabel("Price:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(411, 554, 45, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel ErrorMsg = new JLabel("");
		ErrorMsg.setBounds(10, 534, 358, 54);
		contentPane.add(ErrorMsg);
		
		JButton btnNewButton_4 = new JButton("Home");
		btnNewButton_4.setBounds(733, 15, 82, 21);
		contentPane.add(btnNewButton_4);
	}
}
