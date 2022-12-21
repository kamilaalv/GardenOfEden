package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
	private JTable table;
	private JTextField textField;

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
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1_1 = new JLabel("Date:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBackground(new Color(255, 128, 128));
		lblNewLabel_1_1.setBounds(464, 20, 90, 27);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Money:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(621, 21, 90, 27);
		contentPane.add(lblNewLabel_1_2);
		
		JButton btnNewButton_4 = new JButton("Home");
		btnNewButton_4.setBounds(748, 25, 82, 21);
		contentPane.add(btnNewButton_4);
		
		JLabel lblNewLabel = new JLabel("Delete Flower with ID:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(463, 90, 221, 21);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(538, 133, 146, 21);
		contentPane.add(btnNewButton);
		
		JLabel lblDeleteAllExpired = new JLabel("Delete All Expired Flowers ");
		lblDeleteAllExpired.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDeleteAllExpired.setBounds(463, 198, 221, 21);
		contentPane.add(lblDeleteAllExpired);
		
		JButton btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(538, 235, 146, 21);
		contentPane.add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setBounds(615, 93, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
	}
}
