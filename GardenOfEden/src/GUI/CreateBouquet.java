package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class CreateBouquet extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateBouquet frame = new CreateBouquet();
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
	public CreateBouquet() {
		setTitle("Bouquet");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 869, 772);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 11, 833, 711);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(CreateBouquet.class.getResource("/GUI/Bilalimages/Bouquet.png")));
		lblNewLabel.setBounds(-31, 22, 342, 262);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ғʟᴏᴡᴇʀs ɪɴ ᴛʜᴇ ʙᴏᴜǫᴜᴇᴛ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(50, 282, 197, 35);
		panel.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 315, 246, 281);
		panel.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(new Color(255, 255, 224));
		scrollPane.setViewportView(textArea);
		
		JLabel lblNewLabel_2 = new JLabel("ʜᴀᴘᴘʏ ᴡɪᴛʜ ʏᴏᴜʀ ʙᴏᴜǫᴜᴇᴛ?");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(38, 595, 230, 35);
		panel.add(lblNewLabel_2);
	}
}
