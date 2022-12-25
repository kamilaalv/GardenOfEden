package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ManagementClasses.DbControls;
import ManagementClasses.ShopManagement;

import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManagementHome extends JFrame {

	private JPanel contentPane;
	private ManagerLogin ml = null;
	private JTable tFlowers;
	private JTable tJew;
	
	AddInventory add = new AddInventory(this);
	DeleteInventory del= new DeleteInventory(this);
	
	
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagementHome frame = new ManagementHome();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	} */

	/**
	 * Create the frame.
	 */
	public ManagementHome(ManagerLogin log) {
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 822, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMoney = new JLabel("Money:");
		lblMoney.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMoney.setBounds(668, 11, 130, 27);
		contentPane.add(lblMoney);
		lblMoney.setText("Money: " + String.format("%.2f", DbControls.getMoney()) + "$");
		
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setBackground(new Color(255, 128, 128));
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDate.setBounds(516, 10, 105, 27);
		contentPane.add(lblDate);
		lblDate.setText("Date: " + ShopManagement.dateF);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add.setVisible(true);
				dispose();
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAdd.setBounds(534, 130, 152, 44);
		contentPane.add(btnAdd);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				del.setVisible(true);
				dispose();
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnDelete.setBounds(534, 210, 152, 44);
		contentPane.add(btnDelete);
		
		JLabel lblNewLabel_2 = new JLabel("Would you like to add or delete from inventory?");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(464, 72, 334, 37);
		contentPane.add(lblNewLabel_2);
		
		JButton btnViewStatistics = new JButton("VIEW STATISTICS");
		btnViewStatistics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnViewStatistics.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnViewStatistics.setBounds(502, 364, 227, 44);
		contentPane.add(btnViewStatistics);
		
		JLabel lblNewLabel_1_3 = new JLabel("Jewelry Inventory");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_3.setBounds(10, 259, 152, 27);
		contentPane.add(lblNewLabel_1_3);
		
		JScrollPane scrollPaneJew = new JScrollPane();
		scrollPaneJew.setBounds(28, 296, 351, 89);
		contentPane.add(scrollPaneJew);
		
		String[][]dataJ = DbControls.getJewData();
		String columnJ[] = {"Flower Jewelry Type", "Quantity"};
		tJew = new JTable(dataJ, columnJ);
		tJew.setEnabled(false);
		scrollPaneJew.setViewportView(tJew);
		
		JScrollPane scrollPaneFlower = new JScrollPane();
		scrollPaneFlower.setBounds(28, 38, 351, 183);
		contentPane.add(scrollPaneFlower);
		
		String[][]dataF = DbControls.getFlowersData();
		String columnF[] = {"Id", "Flower Type", "Quantity", "Date Bought"};
		tFlowers = new JTable(dataF, columnF);
		tFlowers.setEnabled(false);
		scrollPaneFlower.setViewportView(tFlowers);
		
		JLabel lblNewLabel_1_2 = new JLabel("Flower Inventory");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2.setBounds(21, 0, 152, 27);
		contentPane.add(lblNewLabel_1_2);
	}
}
