package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ManagementClasses.ItemOptions;

import javax.swing.JLabel;
import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;

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
		setResizable(false);
		setTitle("Bouquet");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 869, 849);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 11, 833, 788);
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
		
		JButton btnNewButton = new JButton("ᴀᴅᴅ ʙᴏᴜǫᴜᴇᴛ ᴛᴏ ᴛʜᴇ ᴄᴀʀᴛ");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBackground(new Color(238, 169, 6));
		btnNewButton.setBounds(28, 630, 230, 45);
		panel.add(btnNewButton);
		
		JButton btnDiscard = new JButton("Discard");
		btnDiscard.setForeground(Color.WHITE);
		btnDiscard.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnDiscard.setBackground(new Color(15, 215, 135));
		btnDiscard.setBounds(28, 686, 230, 45);
		panel.add(btnDiscard);
		
		JLabel lblNewLabel_3 = new JLabel("ᴀᴅᴅ ғʟᴏᴡᴇʀ ᴛᴏ ᴛʜᴇ ʙᴏᴜǫᴇᴜᴛ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(473, 69, 235, 45);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("ғʟᴏᴡᴇʀ ᴛʏᴘᴇ:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(423, 151, 127, 35);
		panel.add(lblNewLabel_4);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(new Color(204, 255, 153));
		comboBox.setBounds(559, 151, 179, 35);
		comboBox.setModel(new DefaultComboBoxModel(ItemOptions.FLOWER_TYPES.toArray(new String[ItemOptions.FLOWER_TYPES.size()])));
		panel.add(comboBox);
		
		JLabel lblNewLabel_5 = new JLabel("ғʟᴏᴡᴇʀ ᴄᴏʟᴏʀ:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(423, 210, 127, 35);
		panel.add(lblNewLabel_5);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBackground(new Color(204, 204, 255));
		comboBox_1.setModel(new DefaultComboBoxModel(ItemOptions.FLOWER_COLORS.toArray(new String[ItemOptions.FLOWER_COLORS.size()])));
		comboBox_1.setBounds(559, 210, 179, 35);
		panel.add(comboBox_1);
		
		JLabel lblNewLabel_6 = new JLabel("ғʟᴏᴡᴇʀ ǫᴜᴀɴᴛɪᴛʏ:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_6.setBounds(508, 282, 160, 35);
		panel.add(lblNewLabel_6);
		
		JLabel Counter = new JLabel("   0\r\n");
		Counter.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Counter.setBounds(548, 328, 44, 35);
		panel.add(Counter);
		
		JButton Dec = new JButton("-");
		Dec.setForeground(Color.WHITE);
		Dec.setFont(new Font("Tahoma", Font.PLAIN, 17));
		Dec.setBackground(new Color(153, 204, 255));
		Dec.setBounds(473, 328, 62, 35);
		panel.add(Dec);
		
		JButton Incre = new JButton(" +");
		Incre.setForeground(Color.WHITE);
		Incre.setFont(new Font("Tahoma", Font.PLAIN, 17));
		Incre.setBackground(new Color(153, 204, 255));
		Incre.setBounds(619, 328, 62, 35);
		panel.add(Incre);
		
		JLabel lblNewLabel_7 = new JLabel("ᴘʀɪᴄᴇ:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_7.setBounds(423, 392, 77, 35);
		panel.add(lblNewLabel_7);
		
		JLabel Price = new JLabel("");
		Price.setBounds(526, 392, 113, 35);
		panel.add(Price);
		
		JButton AddB = new JButton("ᴀᴅᴅ ᴛᴏ ʙᴏᴜǫᴜᴇᴛ");
		AddB.setForeground(Color.WHITE);
		AddB.setFont(new Font("Tahoma", Font.PLAIN, 17));
		AddB.setBackground(new Color(255, 102, 51));
		AddB.setBounds(425, 460, 166, 45);
		panel.add(AddB);
		
		JButton GoBack = new JButton("ɢᴏ ʙᴀᴄᴋ");
		GoBack.setForeground(Color.WHITE);
		GoBack.setFont(new Font("Tahoma", Font.PLAIN, 17));
		GoBack.setBackground(new Color(255, 102, 51));
		GoBack.setBounds(612, 460, 166, 45);
		panel.add(GoBack);
		
		JLabel CouldntAddtoCart = new JLabel("");
		CouldntAddtoCart.setBounds(28, 742, 240, 35);
		panel.add(CouldntAddtoCart);
		
		JLabel LimitReached = new JLabel("");
		LimitReached.setBounds(423, 527, 355, 28);
		panel.add(LimitReached);
		
		JLabel lblNewLabel_8 = new JLabel("ᴛᴏᴛᴀʟ ᴘʀɪᴄᴇ:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_8.setBounds(423, 560, 112, 28);
		panel.add(lblNewLabel_8);
		
		JLabel TotPrice = new JLabel("");
		TotPrice.setBounds(570, 560, 138, 28);
		panel.add(TotPrice);
		
		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setIcon(new ImageIcon(CreateBouquet.class.getResource("/GUI/Bilalimages/Bouquet2.png")));
		lblNewLabel_9.setBounds(394, 595, 400, 182);
		panel.add(lblNewLabel_9);
	}
}
