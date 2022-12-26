package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import HasaClass.Bouquet;
import InheritanceClasses.Flower;
import ManagementClasses.ItemOptions;
import ManagementClasses.ItemSystem;

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
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class CreateBouquet extends JFrame {

	private JPanel contentPane;
    private static int count=0;
    private static Bouquet bouquet  = new Bouquet();
    private JTextField textField;
    private JComboBox comboBox_2;
    private JTextArea textArea;
    private JLabel CouldntAddtoCart;
    private double totalPrice=0f;
    private CustomerFrame f=null;
	/**
	 * Launch the application.
	 */
   /**	public static void main(String[] args) {
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
}	**/

	/**
	 * Create the frame.
	 */
	public CreateBouquet(CustomerFrame ff) {
		f=ff;
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
		panel.setBounds(12, -17, 833, 792);
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
		
		textArea = new JTextArea();
		textArea.setBackground(new Color(255, 255, 224));
		scrollPane.setViewportView(textArea);
		
		JLabel lblNewLabel_2 = new JLabel("ʜᴀᴘᴘʏ ᴡɪᴛʜ ʏᴏᴜʀ ʙᴏᴜǫᴜᴇᴛ?");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(38, 595, 230, 35);
		panel.add(lblNewLabel_2);
		JLabel TotPrice = new JLabel("");
		TotPrice.setFont(new Font("Tahoma", Font.BOLD, 18));
		TotPrice.setBounds(535, 546, 138, 28);
		panel.add(TotPrice);
		
		JButton btnNewButton = new JButton("ᴀᴅᴅ ʙᴏᴜǫᴜᴇᴛ ᴛᴏ ᴛʜᴇ ᴄᴀʀᴛ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String wrappingPaper=comboBox_2.getSelectedItem().toString();
				String Card= textField.getText();
				bouquet.setCard(Card);
				bouquet.setWrappingPaper(wrappingPaper);
				TotPrice.setText("$ " + bouquet.calculateBouquetPrice() + "");
				String str = bouquet.toString();
				textArea.setText(str);
				if(ItemSystem.addBouquet(bouquet)) {
					CouldntAddtoCart.setText("Bouquet is added to cart!");
					CartFrame.getTextAreaCart().append("\n"+ str);
				}
				
				else
					CouldntAddtoCart.setText("Bouquet is not added to cart(. Flowers you selected are out of stock");
				
				
				
				//creating new bouquet object since this one is done
				bouquet = new Bouquet();
				
				//UserMsg.setText()
				
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBackground(new Color(238, 169, 6));
		btnNewButton.setBounds(28, 630, 230, 45);
		panel.add(btnNewButton);
		
		JButton btnDiscard = new JButton("Discard");
		btnDiscard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				totalPrice=0;
				TotPrice.setText("$ " + totalPrice + "");
				ItemSystem.DiscardBouquets();
				textArea.setText(ItemSystem.DisplayBouquet());
			}
		});
		btnDiscard.setForeground(Color.WHITE);
		btnDiscard.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnDiscard.setBackground(new Color(15, 215, 135));
		btnDiscard.setBounds(28, 686, 230, 45);
		panel.add(btnDiscard);
		
		JLabel lblNewLabel_3 = new JLabel("ᴀᴅᴅ ғʟᴏᴡᴇʀ ᴛᴏ ᴛʜᴇ ʙᴏᴜǫᴇᴜᴛ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(473, 22, 235, 45);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("ғʟᴏᴡᴇʀ ᴛʏᴘᴇ:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(376, 78, 127, 35);
		panel.add(lblNewLabel_4);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(new Color(204, 255, 153));
		comboBox.setBounds(565, 78, 179, 35);
		comboBox.setModel(new DefaultComboBoxModel(ItemOptions.FLOWER_TYPES.toArray(new String[ItemOptions.FLOWER_TYPES.size()])));
		panel.add(comboBox);
		
		JLabel lblNewLabel_5 = new JLabel("ғʟᴏᴡᴇʀ ᴄᴏʟᴏʀ:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(376, 137, 127, 35);
		panel.add(lblNewLabel_5);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBackground(new Color(204, 204, 255));
		comboBox_1.setModel(new DefaultComboBoxModel(ItemOptions.FLOWER_COLORS.toArray(new String[ItemOptions.FLOWER_COLORS.size()])));
		comboBox_1.setBounds(565, 137, 179, 35);
		panel.add(comboBox_1);
		
		JLabel lblNewLabel_6 = new JLabel("ғʟᴏᴡᴇʀ ǫᴜᴀɴᴛɪᴛʏ:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_6.setBounds(535, 194, 160, 35);
		panel.add(lblNewLabel_6);
		
		
		JLabel LimitReached = new JLabel("");
		LimitReached.setBounds(359, 355, 435, 28);
		panel.add(LimitReached);
		
		JLabel Counter = new JLabel("0\r\n");
		Counter.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Counter.setBounds(586, 240, 39, 35);
		panel.add(Counter);
		comboBox_2 = new JComboBox();
		comboBox_2.setBackground(new Color(255, 255, 204));
		comboBox_2.setModel(new DefaultComboBoxModel(ItemOptions.BOUQUET_WRAP_COLOR.toArray(new String[ItemOptions.BOUQUET_WRAP_COLOR.size()])));

		comboBox_2.setBounds(566, 413, 179, 35);
		panel.add(comboBox_2);
		JButton Dec = new JButton("-");
		Dec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(count>0)
				{
					count --;
					Counter.setText(count + "");
				}
				

			}
		});
		Dec.setForeground(Color.WHITE);
		Dec.setFont(new Font("Tahoma", Font.PLAIN, 17));
		Dec.setBackground(new Color(153, 204, 255));
		Dec.setBounds(486, 240, 62, 35);
		panel.add(Dec);
		
		JButton Incre = new JButton(" +");
		Incre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				count++;
				Counter.setText(count + "");
			}
		});
		Incre.setForeground(Color.WHITE);
		Incre.setFont(new Font("Tahoma", Font.PLAIN, 17));
		Incre.setBackground(new Color(153, 204, 255));
		Incre.setBounds(646, 240, 62, 35);
		panel.add(Incre);
		
		JLabel lblNewLabel_7 = new JLabel("ᴘʀɪᴄᴇ:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_7.setBounds(394, 302, 77, 35);
		panel.add(lblNewLabel_7);
		
		JLabel Price = new JLabel("");
		Price.setFont(new Font("Tahoma", Font.BOLD, 15));
		Price.setBounds(473, 302, 113, 35);
		panel.add(Price);
		
		JButton AddB = new JButton("ᴀᴅᴅ ᴛᴏ ʙᴏᴜǫᴜᴇᴛ");
		AddB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int quantity=count;
				if(quantity!=0)
				{
					String FlowerType=comboBox.getSelectedItem().toString();
					String Color=comboBox_1.getSelectedItem().toString();
					//check total quantity of flowers
					if(bouquet.CalculateFlowerQuantity()+quantity > bouquet.getMaxQuantity()) {
						LimitReached.setText("The MAX quantity is "+bouquet.getMaxQuantity() + " flowers per bouquet. The limit has been reached!");
					}
					
					else {
						boolean flowerExists = false;
						double price = ItemOptions.FLOWER_PRICES.get(FlowerType)*quantity;
						ArrayList<Flower> flowers = bouquet.getFlowerQuantity();
						for(Flower f: flowers) {
							if(f.getFlowerType().equalsIgnoreCase(FlowerType)) {
								flowerExists = true;
								f.setFlowerQuantity(f.getFlowerQuantity()+quantity);
								f.setItemPrice(f.getItemPrice()+price);
							}
						}
						if(!flowerExists)
							flowers.add(new Flower(FlowerType, Color, quantity));
						
						
						bouquet.setFlowerQuantity(flowers);
						bouquet.setBouquetPrice(bouquet.getBouquetPrice()+price);
						
						LimitReached.setText("");
						Price.setText("$ " + price+"");
						
						
					}
				}
				
				
				
				
			}
		});
		AddB.setForeground(Color.WHITE);
		AddB.setFont(new Font("Tahoma", Font.PLAIN, 17));
		AddB.setBackground(new Color(255, 102, 51));
		AddB.setBounds(628, 300, 166, 45);
		panel.add(AddB);
		
		JButton GoBack = new JButton("ɢᴏ ʙᴀᴄᴋ");
		GoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				textArea.setText("");
				setVisible(false);
				f.setVisible(true);
				
			}
		});
		GoBack.setForeground(Color.WHITE);
		GoBack.setFont(new Font("Tahoma", Font.PLAIN, 17));
		GoBack.setBackground(new Color(255, 102, 51));
		GoBack.setBounds(499, 585, 166, 45);
		panel.add(GoBack);
		
		CouldntAddtoCart = new JLabel("");
		CouldntAddtoCart.setBounds(28, 742, 443, 35);
		panel.add(CouldntAddtoCart);
		
	
		
		JLabel lblNewLabel_8 = new JLabel("ᴛᴏᴛᴀʟ ᴘʀɪᴄᴇ:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_8.setBounds(413, 522, 112, 28);
		panel.add(lblNewLabel_8);
		
		
		
		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setIcon(new ImageIcon(CreateBouquet.class.getResource("/GUI/Bilalimages/Bouquet2.png")));
		lblNewLabel_9.setBounds(394, 652, 400, 182);
		panel.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("ʙᴏᴜǫᴜᴇᴛ ᴡʀᴀᴘ ᴄᴏʟᴏʀ:");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_10.setBounds(377, 413, 173, 28);
		panel.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("ᴄᴀʀᴅ ɴᴀᴍᴇ:");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_11.setBounds(376, 473, 127, 28);
		panel.add(lblNewLabel_11);
		
		textField = new JTextField();
		textField.setBackground(new Color(255, 255, 255));
		textField.setBounds(565, 477, 180, 27);
		panel.add(textField);
		textField.setColumns(10);
		
	
	}
}
