package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
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
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class AddInventory extends JFrame {

	private JPanel contentPane;
	private JTable tFlowers;
	private JTable tJew;
	private JLabel lblFlQ;
	private JLabel lblJewQ;
	private JComboBox comboBoxJew;
	private JComboBox comboBoxFlowers;
	private JLabel errorMsg;
	private DefaultTableModel modelF;
	private DefaultTableModel modelJ ;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
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
	}*/

	/**
	 * Create the frame.
	 */
	public AddInventory(ManagementHome home) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 839, 667);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Flower Inventory");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(21, 9, 177, 27);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDate.setBackground(new Color(255, 128, 128));
		lblDate.setBounds(449, 10, 120, 27);
		contentPane.add(lblDate);
		lblDate.setText("Date: " + ShopManagement.dateF);
		
		JLabel lblMoney = new JLabel("Money:");
		lblMoney.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMoney.setBounds(579, 10, 144, 27);
		contentPane.add(lblMoney);
		DbControls.getMoney();
		lblMoney.setText("Money: " + String.format("%.2f", DbControls.getMoney()) + "$");
		
		JScrollPane scrollPaneFlower = new JScrollPane();
		scrollPaneFlower.setBounds(28, 47, 407, 260);
		contentPane.add(scrollPaneFlower);
		
		String[][]dataF = DbControls.getFlowersData();
		String columnF[] = {"Id", "Flower Type", "Quantity", "Date Bought"};
		tFlowers = new JTable();
		modelF = (DefaultTableModel) tFlowers.getModel();
		modelF.setColumnIdentifiers(columnF);
		tFlowers.setEnabled(false);
		for(int i = 0; i < dataF.length; i++) {
			modelF.addRow((Object[])dataF[i]);
		}
		tFlowers.setModel(modelF);
		scrollPaneFlower.setViewportView(tFlowers);
		
		JLabel lblNewLabel_1_3 = new JLabel("Jewelry Inventory");
		lblNewLabel_1_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_3.setBounds(10, 330, 188, 27);
		contentPane.add(lblNewLabel_1_3);
		
		JScrollPane scrollPaneJew = new JScrollPane();
		scrollPaneJew.setBounds(28, 358, 351, 89);
		contentPane.add(scrollPaneJew);
		
		String[][]dataJ = DbControls.getJewData();
		String columnJ[] = {"Flower Jewelry Type", "Quantity"};
		tJew = new JTable();
		modelJ = (DefaultTableModel) tJew.getModel();
		modelJ.setColumnIdentifiers(columnJ);
		tFlowers.setEnabled(false);
		for(int i = 0; i < dataJ.length; i++) {
			modelJ.addRow((Object[])dataJ[i]);
		}
		tJew.setModel(modelJ);
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
		btnPlusJew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblJewQ.setText(Integer.toString(Integer.parseInt(lblJewQ.getText())+1));
			}
		});
		btnPlusJew.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnPlusJew.setBounds(503, 457, 56, 32);
		contentPane.add(btnPlusJew);
		
		JLabel lblJewelryQuantity = new JLabel("Jewelry Quantity:");
		lblJewelryQuantity.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblJewelryQuantity.setBounds(554, 394, 128, 32);
		contentPane.add(lblJewelryQuantity);
		
		JButton btnMinusJew = new JButton("-");
		btnMinusJew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Integer.parseInt(lblJewQ.getText())-1>= 5)
					lblJewQ.setText(Integer.toString(Integer.parseInt(lblJewQ.getText())-1));
			}
		});
		btnMinusJew.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnMinusJew.setBounds(680, 457, 56, 32);
		contentPane.add(btnMinusJew);
		
		JLabel lblJewelryType = new JLabel("Jewelry Type:");
		lblJewelryType.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblJewelryType.setBounds(471, 330, 102, 32);
		contentPane.add(lblJewelryType);
		
		comboBoxJew = new JComboBox();
		comboBoxJew.setBounds(583, 330, 168, 32);
		comboBoxJew.setModel(new DefaultComboBoxModel(ItemOptions.FLOWER_JEWELRY_TYPES.toArray(new String[ItemOptions.FLOWER_JEWELRY_TYPES.size()])));
		contentPane.add(comboBoxJew);
		
		JButton btnBuyJew = new JButton("BUY");
		btnBuyJew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int q = Integer.parseInt(lblJewQ.getText());
				String type = comboBoxJew.getSelectedItem().toString();
				errorMsg.setText(DbControls.buyJewelry(type, q));
				lblMoney.setText("Money: " + String.format("%.2f", DbControls.getMoney()) + "$");
				int newQ = DbControls.getQuantityJew(type);
				int row;
				if(type == "Earings")
					row = 0;
				else if(type == "Bracelet")
					row = 1;
				else if(type == "Necklace")
					row = 2;
				else
					row = 3;
				modelJ.setValueAt((Object)newQ,row,1);
			}
		});
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
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				home.getLblMoney().setText("Money: " + String.format("%.2f", DbControls.getMoney()) + "$");
				home.setVisible(true);
				dispose();
			}
		});
		btnHome.setBounds(733, 15, 82, 21);
		contentPane.add(btnHome);
		
		JButton btnBuyFl = new JButton("BUY");
		btnBuyFl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int q = Integer.parseInt(lblFlQ.getText());
				String type = comboBoxFlowers.getSelectedItem().toString();
				errorMsg.setText(DbControls.buyFlower(type, q));
				lblMoney.setText("Money: " + String.format("%.2f", DbControls.getMoney()) + "$");
				modelF.addRow(DbControls.getLastFlower());
			
				
			}
		});
		btnBuyFl.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBuyFl.setBounds(568, 263, 114, 44);
		contentPane.add(btnBuyFl);
		
		JLabel lblPriceFl = new JLabel("Price:");
		lblPriceFl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPriceFl.setBounds(449, 294, 45, 13);
		contentPane.add(lblPriceFl);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(AddInventory.class.getResource("/GUI/kamilaIcons/df6e8d2fe3957652c6f1541f664785c0.jpg")));
		lblNewLabel_2.setBounds(0, 0, 823, 628);
		contentPane.add(lblNewLabel_2);
	}
}
