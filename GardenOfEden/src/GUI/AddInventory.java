package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;

import ManagementClasses.DbControls;
import ManagementClasses.ItemOptions;
import ManagementClasses.ShopManagement;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddInventory extends JFrame {

	private JPanel contentPane;
	private JTable tFlowers;
	private JTable tJew;
	private JLabel lblFlQ;
	private JLabel lblJewQ;
	private JComboBox comboBoxJew;
	private JComboBox comboBoxFlowers;
	private JLabel errorMsg;

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
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDate.setBackground(new Color(255, 128, 128));
		lblDate.setBounds(449, 10, 120, 27);
		contentPane.add(lblDate);
		//lblDate.setText("Date: " + ShopManagement.dateF);
		
		JLabel lblMoney = new JLabel("Money:");
		lblMoney.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMoney.setBounds(579, 10, 144, 27);
		contentPane.add(lblMoney);
		//lblMoney.setText("Money: " + String.format("%.2f", ShopManagement.getMoney()) + "$");
		
		JScrollPane scrollPaneFlower = new JScrollPane();
		scrollPaneFlower.setBounds(28, 47, 407, 260);
		contentPane.add(scrollPaneFlower);
		
		String[][]dataF = DbControls.displayFlowersTable();
		String columnF[] = {"Id", "Flower Type", "Quantity", "Date Bought"};
		tFlowers = new JTable(dataF, columnF);
		tFlowers.setEnabled(false);
		scrollPaneFlower.setViewportView(tFlowers);
		
		JLabel lblNewLabel_1_3 = new JLabel("Jewelry Inventory");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_3.setBounds(10, 330, 152, 27);
		contentPane.add(lblNewLabel_1_3);
		
		JScrollPane scrollPaneJew = new JScrollPane();
		scrollPaneJew.setBounds(28, 358, 351, 89);
		contentPane.add(scrollPaneJew);
		
		String[][]dataJ = DbControls.displayJewTable();
		String columnJ[] = {"Flower Jewelry Type", "Quantity"};
		tJew = new JTable(dataJ, columnJ);
		tJew.setEnabled(false);
		scrollPaneJew.setViewportView(tJew);
		
		JLabel lblNewLabel = new JLabel("Flower Type:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(471, 82, 102, 32);
		contentPane.add(lblNewLabel);
		
		comboBoxFlowers = new JComboBox();
		comboBoxFlowers.setBounds(583, 82, 168, 32);
		comboBoxFlowers.setModel(new DefaultComboBoxModel(ItemOptions.FLOWER_TYPES.toArray(new String[ItemOptions.FLOWER_TYPES.size()])));
		contentPane.add(comboBoxFlowers);
		
		JLabel lblFlowerQuantity = new JLabel("Flower Quantity:");
		lblFlowerQuantity.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFlowerQuantity.setBounds(554, 146, 128, 32);
		contentPane.add(lblFlowerQuantity);
		
		JButton btnPlusF = new JButton("+");
		btnPlusF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblFlQ.setText(Integer.toString(Integer.parseInt(lblFlQ.getText())+1));
			}
		});
		btnPlusF.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnPlusF.setBounds(503, 209, 56, 32);
		contentPane.add(btnPlusF);
		
		JButton btnMinusF = new JButton("-");
		btnMinusF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Integer.parseInt(lblFlQ.getText())-1>= 20)
					lblFlQ.setText(Integer.toString(Integer.parseInt(lblFlQ.getText())-1));
			}
		});
		btnMinusF.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnMinusF.setBounds(680, 209, 56, 32);
		contentPane.add(btnMinusF);
		
		lblFlQ = new JLabel("20");
		lblFlQ.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFlQ.setBounds(604, 209, 40, 32);
		contentPane.add(lblFlQ);
		
		lblJewQ = new JLabel("5");
		lblJewQ.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblJewQ.setBounds(604, 457, 31, 32);
		contentPane.add(lblJewQ);
		
		JButton btnPlusJew = new JButton("+");
		btnPlusJew.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnPlusJew.setBounds(503, 457, 56, 32);
		contentPane.add(btnPlusJew);
		
		JLabel lblJewelryQuantity = new JLabel("Jewelry Quantity:");
		lblJewelryQuantity.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblJewelryQuantity.setBounds(554, 394, 128, 32);
		contentPane.add(lblJewelryQuantity);
		
		JButton btnMinusJew = new JButton("-");
		btnMinusJew.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnMinusJew.setBounds(680, 457, 56, 32);
		contentPane.add(btnMinusJew);
		
		JLabel lblJewelryType = new JLabel("Jewelry Type:");
		lblJewelryType.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblJewelryType.setBounds(471, 330, 102, 32);
		contentPane.add(lblJewelryType);
		
		comboBoxJew = new JComboBox();
		comboBoxJew.setBounds(583, 330, 168, 32);
		contentPane.add(comboBoxJew);
		
		JButton btnBuyJew = new JButton("BUY");
		btnBuyJew.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBuyJew.setBounds(568, 536, 114, 44);
		contentPane.add(btnBuyJew);
		
		JLabel lblPriceJew = new JLabel("Price:");
		lblPriceJew.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPriceJew.setBounds(449, 567, 45, 13);
		contentPane.add(lblPriceJew);
		
		errorMsg = new JLabel("");
		errorMsg.setBounds(10, 534, 358, 54);
		contentPane.add(errorMsg);
		
		JButton btnHome = new JButton("Home");
		btnHome.setBounds(733, 15, 82, 21);
		contentPane.add(btnHome);
		
		JButton btnBuyFl = new JButton("BUY");
		btnBuyFl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int q = Integer.parseInt(lblFlQ.getText());
				String type = comboBoxFlowers.getSelectedItem().toString();
				//errorMsg.setText(DbControls.buyFlower(type, q));
				//lblMoney.setText("Money: " + String.format("%.2f", ShopManagement.getMoney()) + "$");
				
			}
		});
		btnBuyFl.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBuyFl.setBounds(568, 263, 114, 44);
		contentPane.add(btnBuyFl);
		
		JLabel lblPriceFl = new JLabel("Price:");
		lblPriceFl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPriceFl.setBounds(449, 294, 45, 13);
		contentPane.add(lblPriceFl);
	}
}
