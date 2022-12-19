package GUI;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
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
	ImageIcon rose = new ImageIcon("src\\GUI\\imanicons\\roses.jpg");
	ImageIcon tulip=new ImageIcon("src\\GUI\\imanicons\\tulip.jpg");
	ImageIcon Daffodil=new ImageIcon("src\\GUI\\imanicons\\Daffodil.jpg");
	ImageIcon Hyacinth=new ImageIcon("src\\GUI\\imanicons\\Hyacinth.jpg");
    ImageIcon Lilac=new ImageIcon("src\\GUI\\imanicons\\Lilac.jpg");
    ImageIcon Peony=new ImageIcon("src\\GUI\\imanicons\\Peony.jpg");
    ImageIcon Daisy=new ImageIcon("src\\GUI\\imanicons\\Daisy.jpg");
    ImageIcon Lily=new ImageIcon("src\\GUI\\imanicons\\Lily.jpg");
    ImageIcon Baby_Breath=new ImageIcon("src\\GUI\\imanicons\\Baby_Breath.jpg");
    ImageIcon Freesia=new ImageIcon("src\\GUI\\imanicons\\Freesia.jpg");
    ImageIcon Chrysanthemum=new ImageIcon("src\\GUI\\imanicons\\Chrysanthemum.jpg");
    ImageIcon Gladiolus=new ImageIcon("src\\GUI\\imanicons\\Gladiolus.jpg");
    Border border = BorderFactory.createLineBorder(Color.GRAY, 1);
    /**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddFlowerframe frame = new AddFlowerframe();
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
	public AddFlowerframe() {
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
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem().equals("Rose"))
					flowerpic.setIcon(rose);
				else if(comboBox.getSelectedItem().equals("Tulip"))
					flowerpic.setIcon(tulip);
				else if(comboBox.getSelectedItem().equals("Daffodil"))
					flowerpic.setIcon(Daffodil);
				else if(comboBox.getSelectedItem().equals("Hyacinth"))
					flowerpic.setIcon(Hyacinth);
				else if(comboBox.getSelectedItem().equals("Lilac"))
					flowerpic.setIcon(Lilac);
				else if(comboBox.getSelectedItem().equals("Peony"))
					flowerpic.setIcon(Peony);
				else if(comboBox.getSelectedItem().equals("Daisy"))
					flowerpic.setIcon(Daisy);
				else if(comboBox.getSelectedItem().equals("Lily"))
					flowerpic.setIcon(Lily);
				else if(comboBox.getSelectedItem().equals("Baby's Breath"))
					flowerpic.setIcon(Baby_Breath);
				else if(comboBox.getSelectedItem().equals("Freesia"))
					flowerpic.setIcon(Freesia);
				else if(comboBox.getSelectedItem().equals("Chrysanthemum"))
					flowerpic.setIcon(Chrysanthemum);
				else
					flowerpic.setIcon(Gladiolus);
				
				
					
				
			}
		});
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setFont(comboBox.getFont().deriveFont(12f));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Rose", "Tulip", "Daffodil", "Hyacinth", "Lilac", "Peony", "Daisy", "Lily", "Baby's Breath", "Freesia", "Chrysanthemum", "Gladiolus"}));
		comboBox.setBounds(152, 95, 160, 22);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_3 = new JLabel("Flower Colour:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(24, 143, 118, 29);
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_3.setOpaque(true);
        lblNewLabel_3.setBackground(Color.white);
		contentPane.add(lblNewLabel_3);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBackground(new Color(255, 255, 255));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"White", "Beige", "Transparent", "Baby Pink", "Lilac", "Light Blue"}));
		comboBox_1.setBounds(152, 151, 160, 22);
		contentPane.add(comboBox_1);
		
		
		
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
		incrementbtn.setFont(new Font("Arial Black", Font.BOLD, 16));
		incrementbtn.setBounds(73, 247, 46, 22);
		incrementbtn.setOpaque(true);
		incrementbtn.setBackground(Color.white);
		contentPane.add(incrementbtn);
		
		
		JButton decrementbtn = new JButton("-");
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
		addbtn.setBounds(363, 292, 134, 23);
		addbtn.setFont(new Font("Arial", Font.PLAIN, 16));
		addbtn.setOpaque(true);
		addbtn.setBackground(Color.white);
		contentPane.add(addbtn);
		
		JButton returnbtn = new JButton("Go back");
		returnbtn.setBounds(517, 292, 134, 23);
		returnbtn.setFont(new Font("Arial", Font.PLAIN, 16));
		returnbtn.setOpaque(true);
		returnbtn.setBackground(Color.white);
		contentPane.add(returnbtn);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(189, 359, 257, 14);
		lblNewLabel_6.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_6.setOpaque(true);
        lblNewLabel_6.setBackground(Color.white);
		contentPane.add(lblNewLabel_6);
		
		flowerpic = new JLabel("");
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
