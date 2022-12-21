package GUI;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import InheritanceClasses.Flower;
import ManagementClasses.ItemOptions;
import ManagementClasses.ItemSystem;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddFlowerframe extends JFrame {

	private JPanel contentPane;
	private JLabel flowerpic;
	private JLabel display;
    Border border = BorderFactory.createLineBorder(Color.GRAY, 1);
    CustomerFrame cf;
    
    /**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 * @param customerFrame 
	 */
	public AddFlowerframe(CustomerFrame frame) {
		cf =frame;
		setResizable(false);
		setTitle("AddFlowerFrame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 684, 438);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblNewLabel_1 = new JLabel("Select Flower Attributes");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(117, 21, 400, 39);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1.setOpaque(true);
		contentPane.add(lblNewLabel_1);
		
		
		JLabel lblNewLabel_2 = new JLabel("Flower Type:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(24, 93, 118, 29);
		lblNewLabel_2.setFont((new Font("Arial", Font.PLAIN, 16)));
		lblNewLabel_2.setOpaque(true);
        lblNewLabel_2.setBackground(Color.white);
		contentPane.add(lblNewLabel_2);
		
		JComboBox typecb = new JComboBox();
		typecb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String key = typecb.getSelectedItem().toString();
				ImageIcon img = new ImageIcon("src\\GUI\\imanicons\\"+ItemOptions.FLOWER_IMAGES.get(key));
				flowerpic.setIcon(img);	
			}
		});
		typecb.setBackground(new Color(255, 255, 255));
		typecb.setFont(typecb.getFont().deriveFont(12f));
		typecb.setModel(new DefaultComboBoxModel(ItemOptions.FLOWER_TYPES.toArray(new String[ItemOptions.FLOWER_TYPES.size()])));
		typecb.setBounds(152, 95, 160, 22);
		contentPane.add(typecb);
		
		JLabel lblNewLabel_3 = new JLabel("Flower Colour:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(24, 143, 118, 29);
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_3.setOpaque(true);
        lblNewLabel_3.setBackground(Color.white);
		contentPane.add(lblNewLabel_3);
		
		JComboBox colorcb = new JComboBox();
		colorcb.setBackground(new Color(255, 255, 255));
		colorcb.setModel(new DefaultComboBoxModel(ItemOptions.FLOWER_COLORS.toArray(new String[ItemOptions.FLOWER_COLORS.size()])));
		colorcb.setBounds(152, 151, 160, 22);
		contentPane.add(colorcb);
		
		
		
		JLabel lblNewLabel_4 = new JLabel("Flower Quantity:");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(99, 198, 118, 24);
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_4.setOpaque(true);
        lblNewLabel_4.setBackground(Color.white);
		contentPane.add(lblNewLabel_4);
		
		
		JLabel counter = new JLabel("0");
		counter.setForeground(new Color(0, 0, 0));
		counter.setHorizontalAlignment(SwingConstants.CENTER);
		counter.setBounds(145, 237, 46, 45);
		counter.setFont(new Font("Arial", Font.BOLD, 16));
		counter.setOpaque(true);
		counter.setBackground(Color.white);
		contentPane.add(counter);
		
		
		
		JButton incrementbtn = new JButton("+");
		incrementbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int count=Integer.parseInt(counter.getText())+1;
				counter.setText(count+"");
			}
		});
		incrementbtn.setFont(new Font("Arial Black", Font.BOLD, 16));
		incrementbtn.setBounds(73, 247, 46, 22);
		incrementbtn.setOpaque(true);
		incrementbtn.setBackground(Color.white);
		contentPane.add(incrementbtn);
		
		
		JButton decrementbtn = new JButton("-");
		decrementbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Integer.parseInt(counter.getText())>0) {
					int count=Integer.parseInt(counter.getText())-1;
					counter.setText(count+"");
				}
			}
		});
		decrementbtn.setFont(new Font("Arial Black", Font.BOLD, 16));
		decrementbtn.setBounds(211, 247, 46, 22);
		decrementbtn.setOpaque(true);
		decrementbtn.setBackground(Color.white);
		contentPane.add(decrementbtn);
	

		JLabel lblNewLabel_5 = new JLabel("Total Price:");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(57, 289, 118, 29);
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_5.setOpaque(true);
        lblNewLabel_5.setBackground(Color.white);
		contentPane.add(lblNewLabel_5);
		
		JLabel tprice = new JLabel("New label");
		tprice.setHorizontalAlignment(SwingConstants.CENTER);
		tprice.setBounds(201, 289, 111, 29);
		tprice.setFont(new Font("Arial", Font.PLAIN, 16));
		tprice.setOpaque(true);
       	tprice.setBackground(Color.white);
		contentPane.add(tprice);
		
		JButton addbtn = new JButton("Add to Cart");
		addbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String type=(String) typecb.getSelectedItem();
				String color=(String) colorcb.getSelectedItem();
				int num=Integer.parseInt(counter.getText());
				boolean rest= ItemSystem.addFlowers(num, type, color);
				
				if(rest)
				{
					display.setText("Your item has been successfully added to the cart!");
					
				}
				else {
					display.setText("The maximum qaunitity is 20, please select the qauntity again!");
					counter.setText("0");
				}
					
			
			}
		});
		addbtn.setBounds(363, 292, 134, 23);
		addbtn.setFont(new Font("Arial", Font.PLAIN, 16));
		addbtn.setOpaque(true);
		addbtn.setBackground(Color.white);
		contentPane.add(addbtn);
		
		JButton returnbtn = new JButton("Go back");
		returnbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cf.setVisible(true);
			}
		});
		returnbtn.setBounds(517, 292, 134, 23);
		returnbtn.setFont(new Font("Arial", Font.PLAIN, 16));
		returnbtn.setOpaque(true);
		returnbtn.setBackground(Color.white);
		contentPane.add(returnbtn);
		
		display = new JLabel("New label");
		display.setHorizontalAlignment(SwingConstants.CENTER);
		display.setBounds(35, 359, 598, 29);
		display.setFont(new Font("Arial", Font.PLAIN, 16));
		display.setOpaque(true);
        display.setBackground(Color.white);
		contentPane.add(display);
		
		flowerpic = new JLabel("");
		flowerpic.setIcon(new ImageIcon(AddFlowerframe.class.getResource("/GUI/imanicons/roses.jpg")));
		flowerpic.setBounds(400, 93, 209, 172);
		flowerpic.setOpaque(true);
        flowerpic.setBackground(Color.white);
		contentPane.add(flowerpic);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AddFlowerframe.class.getResource("/GUI/imanicons/bg2.jpg")));
		lblNewLabel.setBounds(0, 0, 668, 399);
		contentPane.add(lblNewLabel);
		
		
		
		
		
		
		
	
		
		
		

		
	}
}
