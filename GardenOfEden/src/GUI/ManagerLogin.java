package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManagerLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldID;
	private JTextField textFieldP;
	private JLabel errorLbl;
	private Login l=null;
	
	ManagementHome home = new ManagementHome(this);
	/**
	 * Launch the application.
	 */
 /**	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerLogin frame = new ManagerLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}  **/

	/**
	 * Create the frame.
	 */
	public ManagerLogin(Login log) {
		l=log;
		setResizable(false);
		setTitle("ManagerFrame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 851, 580);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(255, 165, 0));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 22, 815, 508);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ManagerLogin.class.getResource("/GUI/Bilalimages/Flower.png")));
		lblNewLabel.setBounds(399, 227, 406, 248);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ᴇɴᴛᴇʀ ʏᴏᴜʀ ʟᴏɢɪɴ ᴄʀᴇᴅᴇɴᴛɪᴀʟs");
		lblNewLabel_1.setForeground(new Color(139, 0, 0));
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(186, 11, 438, 52);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ID:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(35, 113, 49, 23);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("ᴘᴀssᴡᴏʀᴅ:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(35, 179, 95, 23);
		panel.add(lblNewLabel_3);
		
		textFieldID = new JTextField();
		textFieldID.setBackground(new Color(255, 250, 205));
		textFieldID.setBounds(155, 109, 203, 37);
		panel.add(textFieldID);
		textFieldID.setColumns(10);
		
		textFieldP = new JTextField();
		textFieldP.setBackground(new Color(224, 255, 255));
		textFieldP.setBounds(155, 175, 203, 37);
		panel.add(textFieldP);
		textFieldP.setColumns(10);
		
		JButton btnL = new JButton("Lᴏɢɪɴ");
		btnL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ID = textFieldID.getText();
				String pass = textFieldP.getText();
				if(ID.equalsIgnoreCase("admin") && pass.equalsIgnoreCase("password")) {
					home.setVisible(true);
					setVisible(false);
				}
				else {
					errorLbl.setText("Wrong ID or Password. Please, attempt again");
				}
			}
		});
		btnL.setForeground(Color.WHITE);
		btnL.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnL.setBackground(new Color(255, 69, 0));
		btnL.setBounds(155, 263, 203, 52);
		panel.add(btnL);
		
		errorLbl = new JLabel("");
		errorLbl.setForeground(new Color(255, 128, 0));
		errorLbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		errorLbl.setBounds(87, 350, 411, 62);
		panel.add(errorLbl);
	}
}
