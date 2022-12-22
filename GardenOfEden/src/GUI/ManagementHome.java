package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTable;

public class ManagementHome extends JFrame {

	private JPanel contentPane;
	private ManagerLogin ml = null;

	/*
	public static void main(String[] args) {
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
		ml = log;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 822, 562);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Money:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(668, 11, 90, 27);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Date:");
		lblNewLabel_1_1.setBackground(new Color(255, 128, 128));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(516, 10, 90, 27);
		contentPane.add(lblNewLabel_1_1);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(534, 130, 152, 44);
		contentPane.add(btnNewButton);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnDelete.setBounds(534, 210, 152, 44);
		contentPane.add(btnDelete);
		
		JLabel lblNewLabel_2 = new JLabel("Would you like to add or delete from inventory?");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(464, 72, 334, 37);
		contentPane.add(lblNewLabel_2);
		
		JButton btnViewStatistics = new JButton("VIEW STATISTICS");
		btnViewStatistics.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnViewStatistics.setBounds(502, 364, 227, 44);
		contentPane.add(btnViewStatistics);
		
		JLabel lblNewLabel_1_3 = new JLabel("Jewelry Inventory");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_3.setBounds(10, 321, 152, 27);
		contentPane.add(lblNewLabel_1_3);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(28, 358, 351, 155);
		contentPane.add(scrollPane_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 38, 407, 273);
		contentPane.add(scrollPane);
		
		JLabel lblNewLabel_1_2 = new JLabel("Flower Inventory");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2.setBounds(21, 0, 152, 27);
		contentPane.add(lblNewLabel_1_2);
	}
}
