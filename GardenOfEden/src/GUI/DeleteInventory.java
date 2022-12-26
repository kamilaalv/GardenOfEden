package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

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
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class DeleteInventory extends JFrame {

	private JPanel contentPane;
	private JTable tFlowers;
	private JTextField textFieldID;
	private JLabel ErrorMsg; 
	private DefaultTableModel modelF;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
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
	}*/

	/**
	 * Create the frame.
	 */
	public DeleteInventory(ManagementHome home) {
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
		
		String[][]dataF = DbControls.getFlowersData();
		String columnF[] = {"Id", "Flower Type", "Quantity", "Date Bought"};
		tFlowers = new JTable();
		tFlowers.setEnabled(false);
	    modelF = (DefaultTableModel) tFlowers.getModel();
		modelF.setColumnIdentifiers(columnF);
		tFlowers.setEnabled(false);
		for(int i = 0; i < dataF.length; i++) {
			modelF.addRow((Object[])dataF[i]);
		}
		tFlowers.setModel(modelF);
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
		lblMoney.setText("Money: " + String.format("%.2f", DbControls.getMoney()) + "$");
		contentPane.add(lblMoney);
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				home.setVisible(true);
				dispose();
			}
		});
		btnHome.setBounds(748, 25, 82, 21);
		contentPane.add(btnHome);
		
		JLabel lblNewLabel = new JLabel("Delete Flower with ID:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(463, 90, 142, 21);
		contentPane.add(lblNewLabel);
		
		JButton btnDeleteID = new JButton("Delete");
		btnDeleteID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int id = Integer.parseInt(textFieldID.getText());
				if(DbControls.idExists(id)) {
					ErrorMsg.setText(DbControls.deleteByID(id));
					for(int i = 0; i< modelF.getRowCount(); i++)
					{
						if(Integer.parseInt(tFlowers.getModel().getValueAt(i, 0).toString()) == id)
							modelF.removeRow(i);
					}
				}
					
				else
					ErrorMsg.setText("Given Id does not exist");
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
				ArrayList<Integer> arr = DbControls.deleteExpiredAll();
				for(int i = 0; i< modelF.getRowCount(); i++)
				{
					for(Integer id : arr) {
						if(Integer.parseInt(tFlowers.getModel().getValueAt(i, 0).toString()) == id)
							modelF.removeRow(i);
							
					}
					
				}
			}
		});
		btnDeleteExpired.setBounds(538, 235, 146, 21);
		contentPane.add(btnDeleteExpired);
		
		textFieldID = new JTextField();
		textFieldID.setBounds(615, 93, 96, 19);
		contentPane.add(textFieldID);
		textFieldID.setColumns(10);
		
		ErrorMsg = new JLabel("");
		ErrorMsg.setFont(new Font("Tahoma", Font.BOLD, 12));
		ErrorMsg.setBounds(464, 281, 247, 27);
		contentPane.add(ErrorMsg);
	}
}
