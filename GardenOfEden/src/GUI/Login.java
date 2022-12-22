package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Label;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	CustomerFrame CF= new CustomerFrame(this);
	ManagerLogin log = new ManagerLogin(this);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/GUI/Bilalimages/GOE.png")));
		setResizable(false);
		setTitle("Garden Of Eden Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 869, 619);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 11, 832, 556);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ɢᴀʀᴅᴇɴ ᴏғ ᴇᴅᴇɴ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 80));
		lblNewLabel.setIcon(null);
		lblNewLabel.setBounds(141, 26, 573, 112);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Wᴇʟᴄᴏᴍᴇ ᴛᴏ ᴛʜᴇ Gᴀʀᴅᴇɴ ᴏғ Eᴅᴇɴ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(235, 306, 356, 73);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Cᴏɴᴛɪɴᴜᴇ ᴀs Cᴜsᴛᴏᴍᴇʀ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CF.setVisible(true);
				
			}
		});
		btnNewButton.setBackground(new Color(232, 57, 132));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(235, 390, 356, 52);
		panel.add(btnNewButton);
		
		JButton btnLsM = new JButton("Lᴏɢɪɴ ᴀs Mᴀɴᴀɢᴇʀ");
		btnLsM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				log.setVisible(true);
				
			}
		});
		btnLsM.setForeground(Color.WHITE);
		btnLsM.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnLsM.setBackground(new Color(15, 215, 135));
		btnLsM.setBounds(235, 453, 356, 52);
		panel.add(btnLsM);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Login.class.getResource("/GUI/Bilalimages/Flower.png")));
		lblNewLabel_2.setBounds(-52, -106, 1436, 662);
		panel.add(lblNewLabel_2);
	}
}
