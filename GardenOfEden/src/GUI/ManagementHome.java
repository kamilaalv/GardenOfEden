package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

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
import javax.swing.ImageIcon;

public class ManagementHome extends JFrame {

	private JPanel contentPane;
	private static JTable tFlowers;
	private static JTable tJew;
	private static DefaultTableModel modelF;
	private static DefaultTableModel modelJ ;
	private static JLabel lblMoney;
	
	


	AddInventory add = new AddInventory(this);
	DeleteInventory del= new DeleteInventory(this);
	ManagementStatistics ms = new ManagementStatistics(this);
	
	
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
		
		lblMoney = new JLabel("Money:");
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
				del.getLblMoney().setText("Money: " + String.format("%.2f", DbControls.getMoney()) + "$");
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
				ms.setVisible(true);
				setVisible(false);
			}
		});
		btnViewStatistics.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnViewStatistics.setBounds(502, 364, 227, 44);
		contentPane.add(btnViewStatistics);
		
		JLabel lblNewLabel_1_3 = new JLabel("Jewelry Inventory");
		lblNewLabel_1_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_3.setBounds(10, 259, 183, 27);
		contentPane.add(lblNewLabel_1_3);
		
		JScrollPane scrollPaneJew = new JScrollPane();
		scrollPaneJew.setBounds(28, 296, 351, 89);
		contentPane.add(scrollPaneJew);
		
		String[][]dataJ = DbControls.getJewData();
		String columnJ[] = {"Flower Jewelry Type", "Quantity"};
		tJew = new JTable();
		modelJ = (DefaultTableModel) tJew.getModel();
		modelJ.setColumnIdentifiers(columnJ);
		tJew.setEnabled(false);
		for(int i = 0; i < dataJ.length; i++) {
			modelJ.addRow((Object[])dataJ[i]);
		}
		tJew.setModel(modelJ);
		tJew.setEnabled(false);
		scrollPaneJew.setViewportView(tJew);
		
		JScrollPane scrollPaneFlower = new JScrollPane();
		scrollPaneFlower.setBounds(28, 38, 351, 183);
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
		
		JLabel lblNewLabel_1_2 = new JLabel("Flower Inventory");
		lblNewLabel_1_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_2.setBounds(21, 0, 183, 27);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ManagementHome.class.getResource("/GUI/kamilaIcons/df6e8d2fe3957652c6f1541f664785c0.jpg")));
		lblNewLabel.setBounds(0, -12, 806, 482);
		contentPane.add(lblNewLabel);
	}


	public static DefaultTableModel getModelF() {
		return modelF;
	}

	public static DefaultTableModel getModelJ() {
		return modelJ;
	}

	public static JLabel getLblMoney() {
		return lblMoney;
	}
}
