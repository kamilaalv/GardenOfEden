package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ManagementClasses.DbControls;
import ManagementClasses.ShopManagement;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class DeleteInventory extends JFrame {

	private JPanel contentPane;
	private JTable tFlowers;
	private JTextField textFieldID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteInventory frame = new DeleteInventory();
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
	public DeleteInventory() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 854, 406);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Flower Inventory");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(7, 19, 152, 27);
		contentPane.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(7, 58, 407, 273);
		contentPane.add(scrollPane);
		
		String[][]dataF = DbControls.displayFlowersTable();
		String columnF[] = {"Id", "Flower Type", "Quantity", "Date Bought"};
		tFlowers = new JTable(dataF, columnF);
		tFlowers.setEnabled(false);
		scrollPane.setViewportView(tFlowers);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDate.setBackground(new Color(255, 128, 128));
		lblDate.setBounds(464, 20, 116, 27);
		lblDate.setText("Date: " + ShopManagement.dateF);
		contentPane.add(lblDate);
		
		JLabel lblMoney = new JLabel("Money:");
		lblMoney.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMoney.setBounds(621, 21, 127, 27);
		lblMoney.setText("Money: " + String.format("%.2f", ShopManagement.getMoney()) + "$");
		contentPane.add(lblMoney);
		
		JButton btnHome = new JButton("Home");
		btnHome.setBounds(748, 25, 82, 21);
		contentPane.add(btnHome);
		
		JLabel lblNewLabel = new JLabel("Delete Flower with ID:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(463, 90, 142, 21);
		contentPane.add(lblNewLabel);
		
		JButton btnDeleteID = new JButton("Delete");
		btnDeleteID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDeleteID.setBounds(538, 133, 146, 21);
		contentPane.add(btnDeleteID);
		
		JLabel lblDeleteAllExpired = new JLabel("Delete All Expired Flowers ");
		lblDeleteAllExpired.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDeleteAllExpired.setBounds(463, 198, 221, 21);
		contentPane.add(lblDeleteAllExpired);
		
		JButton btnDeleteExpired = new JButton("Delete");
		btnDeleteExpired.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDeleteExpired.setBounds(538, 235, 146, 21);
		contentPane.add(btnDeleteExpired);
		
		textFieldID = new JTextField();
		textFieldID.setBounds(615, 93, 96, 19);
		contentPane.add(textFieldID);
		textFieldID.setColumns(10);
	}
}
