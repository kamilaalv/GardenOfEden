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

public class AddFlowerframe extends JFrame {

	private JPanel contentPane;

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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblNewLabel_1 = new JLabel("Select Flower Attributes");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(117, 21, 400, 39);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1.setOpaque(true);
        lblNewLabel_1.setBackground(Color.white);
		contentPane.add(lblNewLabel_1);
		
		
		JLabel lblNewLabel_2 = new JLabel("Flower Type:");
		lblNewLabel_2.setBounds(24, 93, 118, 24);
		lblNewLabel_2.setFont((new Font("Arial", Font.PLAIN, 16)));
		lblNewLabel_2.setOpaque(true);
        lblNewLabel_2.setBackground(Color.white);
		contentPane.add(lblNewLabel_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setFont(comboBox.getFont().deriveFont(12f));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Rose", "Tulip", "Daffodil", "Violet", "Hyacinth", "Lilac", "Peony", "Daisy", "Lily", "Baby's Breath", "Freesia", "Chrysanthemum", "Gladiolus"}));
		comboBox.setBounds(152, 95, 160, 22);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_3 = new JLabel("Flower Colour:");
		lblNewLabel_3.setBounds(24, 148, 118, 24);
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
		lblNewLabel_4.setBounds(77, 198, 118, 24);
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_4.setOpaque(true);
        lblNewLabel_4.setBackground(Color.white);
		contentPane.add(lblNewLabel_4);
		
		
		JLabel counter = new JLabel("0");
		counter.setForeground(new Color(0, 0, 0));
		counter.setHorizontalAlignment(SwingConstants.CENTER);
		counter.setBounds(87, 233, 46, 45);
		counter.setFont(new Font("Arial", Font.BOLD, 16));
		counter.setOpaque(true);
		counter.setBackground(Color.white);
		 Border border = BorderFactory.createLineBorder(Color.GRAY, 1);
	     counter.setBorder(border);
		contentPane.add(counter);
		
		
		
		JButton incrementbtn = new JButton("+");
		incrementbtn.setFont(new Font("Arial Black", Font.BOLD, 20));
		incrementbtn.setBounds(24, 245, 46, 24);
		incrementbtn.setOpaque(true);
		incrementbtn.setBackground(Color.white);
		contentPane.add(incrementbtn);
		
		
		JButton decrementbtn = new JButton("-");
		decrementbtn.setFont(new Font("Arial Black", Font.BOLD, 20));
		decrementbtn.setBounds(152, 245, 46, 24);
		decrementbtn.setOpaque(true);
		decrementbtn.setBackground(Color.white);
		contentPane.add(decrementbtn);
	

		
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\hp\\OneDrive\\Desktop\\221 project\\GardenOfEden\\GardenOfEden\\src\\GUI\\bg.jpg"));
		lblNewLabel.setBounds(-36, -11, 736, 446);
		contentPane.add(lblNewLabel);
		
		


		
	}
}
