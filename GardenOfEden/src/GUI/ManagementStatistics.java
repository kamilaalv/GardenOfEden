package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ManagementClasses.DbControls;
import ManagementClasses.ShopManagement;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;

public class ManagementStatistics extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagementStatistics frame = new ManagementStatistics();
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
	public ManagementStatistics() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 758, 447);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDate.setBackground(new Color(255, 128, 128));
		lblDate.setBounds(368, 0, 132, 27);
		contentPane.add(lblDate);
		lblDate.setText("Date: " + ShopManagement.dateF);
		
		JLabel lblMoney = new JLabel("Money:");
		lblMoney.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMoney.setBounds(525, 1, 117, 27);
		lblMoney.setText("Money: " + String.format("%.2f", DbControls.getMoney()) + "$");
		
		contentPane.add(lblMoney);
		
		JButton btnHome = new JButton("Home");
		btnHome.setBounds(652, 5, 82, 21);
		contentPane.add(btnHome);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(158, 56, 385, 344);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ManagementStatistics.class.getResource("/GUI/kamilaIcons/df6e8d2fe3957652c6f1541f664785c0.jpg")));
		lblNewLabel.setBounds(0, 0, 732, 397);
		contentPane.add(lblNewLabel);
	}

}
