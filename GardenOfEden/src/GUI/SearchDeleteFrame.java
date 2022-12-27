package GUI;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import HasaClass.Bouquet;
import InheritanceClasses.Item;
import ManagementClasses.ItemSystem;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SearchDeleteFrame extends JFrame {

	private JPanel contentPane;
	CartFrame cframe=null;

	/**
	 * Launch the application.
	 */
	/* public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchDeleteFrame frame = new SearchDeleteFrame(cframe, defaultCloseOperation);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	} */

	/**
	 * Create the frame.
	 */

	public SearchDeleteFrame(CartFrame cf) {
		cframe = cf;
	    System.out.println(CartFrame.getITEMSEARCHID());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 444);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setText("Item with the id " + CartFrame.getITEMSEARCHID());
	
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		lblNewLabel.setBounds(121, 21, 317, 35);
		contentPane.add(lblNewLabel);
		
		JLabel itempic = new JLabel("");
		itempic.setBounds(120, 76, 179, 166);
		
		contentPane.add(itempic);
		
		JLabel iteminfo = new JLabel("");
		iteminfo.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		iteminfo.setBounds(337, 71, 146, 166);
		contentPane.add(iteminfo);
		if(CartFrame.getITEMSEARCHID() >= 800) {
			iteminfo.setText(ItemSystem.searchBouquet(CartFrame.getITEMSEARCHID()).toString());
			iteminfo.setIcon(new ImageIcon(CreateBouquet.class.getResource("/GUI/Bilalimages/Bouquet.png")));
			
		}else if(CartFrame.getITEMSEARCHID() >= 400) {
			iteminfo.setText(ItemSystem.searchItem(CartFrame.getITEMSEARCHID()).toString());
			itempic.setIcon(new ImageIcon(AddFlowerframe.class.getResource("/GUI/ahmetImages/jewelry.jpg")));
			
		}else if(cf.getITEMSEARCHID() >= 1) {
			iteminfo.setText(ItemSystem.searchItem(CartFrame.getITEMSEARCHID()).toString());
			itempic.setIcon(new ImageIcon(AddFlowerframe.class.getResource("/GUI/imanicons/roses.jpg")));
			
		}
		
		itempic.setOpaque(true);
		
		JLabel lblNewLabel_1 = new JLabel("Want to remove this item from the Cart?");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(106, 266, 332, 35);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblError = new JLabel("");
		lblError.setForeground(new Color(255, 20, 147));
		lblError.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblError.setBounds(106, 352, 317, 21);
		contentPane.add(lblError);
		
		JButton removebtn = new JButton("Yes, remove the item");
		removebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(CartFrame.getITEMSEARCHID() >= 800) {
					Bouquet res = ItemSystem.removeBouquet(CartFrame.getITEMSEARCHID());
					if(res == null) {
						lblError.setText("Could not be deleted!");
					} else {
						lblError.setText("Deleted successfully! Now return to Cart");
					}
				} else {
					Item res = ItemSystem.removeItem(CartFrame.getITEMSEARCHID());
					if(res == null) {
						lblError.setText("Could not be deleted!");
					} else {
						lblError.setText("Deleted successfully! Now return to Cart");
					}
				}
				
			}
		});
		removebtn.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		removebtn.setBounds(71, 312, 187, 29);
		contentPane.add(removebtn);
		
		JButton returnbtn = new JButton("No, return to Cart");
		returnbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblError.setText("");
				cframe.getTextAreaCart().setText(ItemSystem.cartToString());
				cframe.setVisible(true);
				setVisible(false);
			}
		});
		returnbtn.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		returnbtn.setBounds(268, 312, 187, 29);
		contentPane.add(returnbtn);
		
		JLabel icon = new JLabel("New label");
		icon.setIcon(new ImageIcon(AddFlowerframe.class.getResource("/GUI/ahmetImages/pngegg.png")));
		icon.setOpaque(true);
		icon.setBounds(55, 265, 42, 40);
		contentPane.add(icon);
		
		JLabel bg = new JLabel("");
		bg.setBounds(0, 0, 534, 405);
		bg.setIcon(new ImageIcon(AddFlowerframe.class.getResource("/GUI/ahmetImages/searchdeletebg.jpg")));
		bg.setOpaque(true);
		contentPane.add(bg);
	}
}
