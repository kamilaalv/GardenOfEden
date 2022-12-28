package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import HasaClass.Bouquet;
import InheritanceClasses.Flower;
import InheritanceClasses.FlowerJewelry;
import InheritanceClasses.Item;
import ManagementClasses.DbControls;
import ManagementClasses.ItemSystem;
import ManagementClasses.ShopManagement;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class CartFrame extends JFrame {

	private JPanel contentPane;
	private JTextField getIdField;
	private static JTextArea textAreaCart ;
	private JLabel ErrorMsg_1;
	private Login L=null;
	private SearchDeleteFrame SDF= null;
	private  CartFrame CFTemp=this;
	public static int ITEMSEARCHID;
	
	public static int getITEMSEARCHID() {
		return ITEMSEARCHID;
	}


	public static void setITEMSEARCHID(int iTEMSEARCHID) {
		ITEMSEARCHID = iTEMSEARCHID;
	}


	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CartFrame frame = new CartFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	public static JTextArea getTextAreaCart() {
		return textAreaCart;
	}


	/**
	 * Create the frame.
	 */
	
	public CartFrame(CustomerFrame cust) {
		setResizable(false);
		setTitle("CartFrame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 712, 504);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 65, 253, 376);
		contentPane.add(scrollPane);
		
		textAreaCart = new JTextArea();

		scrollPane.setViewportView(textAreaCart);
		
		scrollPane.setViewportView(textAreaCart);
		
	
		
		JLabel lblNewLabel = new JLabel("Items in Cart");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel.setBounds(64, 17, 143, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Would you like to delete anything from the cart?");
		lblNewLabel_1.setIcon(null);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(352, 71, 334, 32);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("(Enter item id)");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(352, 101, 185, 24);
		contentPane.add(lblNewLabel_2);
		
		getIdField = new JTextField();
		getIdField.setForeground(new Color(0, 0, 0));
		getIdField.setBounds(405, 138, 198, 32);
		contentPane.add(getIdField);
		getIdField.setColumns(10);
		
		JLabel ErrorMsg = new JLabel("");
		ErrorMsg.setForeground(new Color(255, 0, 0));
		ErrorMsg.setFont(new Font("Arial", Font.BOLD, 14));
		ErrorMsg.setBounds(335, 180, 334, 32);
		contentPane.add(ErrorMsg);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(CartFrame.class.getResource("/GUI/kamilaIcons/ButterflyBlue.png")));
		lblNewLabel_3.setBounds(310, 71, 53, 54);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setIcon(new ImageIcon(CartFrame.class.getResource("/GUI/kamilaIcons/ButterflyPink.png")));
		lblNewLabel_3_1.setBounds(20, 10, 46, 45);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Continue Shopping?");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(352, 229, 143, 32);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("");
		lblNewLabel_3_2.setIcon(new ImageIcon(CartFrame.class.getResource("/GUI/kamilaIcons/ButterflyYellow.png")));
		lblNewLabel_3_2.setBounds(310, 207, 53, 54);
		contentPane.add(lblNewLabel_3_2);
		
		JButton returnToCustomer = new JButton("Yes");
		returnToCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CustomerFrame CUS= new CustomerFrame(L);
				CUS.setVisible(true);
				setVisible(false);
				
			}
		});
		returnToCustomer.setBackground(new Color(255, 255, 255));
		returnToCustomer.setFont(new Font("Arial", Font.BOLD, 12));
		returnToCustomer.setBounds(405, 268, 198, 35);
		contentPane.add(returnToCustomer);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Done Shopping?");
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(352, 334, 143, 32);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_3_2_1 = new JLabel("");
		lblNewLabel_3_2_1.setIcon(new ImageIcon(CartFrame.class.getResource("/GUI/kamilaIcons/ButterflyPink.png")));
		lblNewLabel_3_2_1.setBounds(310, 316, 53, 54);
		contentPane.add(lblNewLabel_3_2_1);
		
		JButton Buy = new JButton("Purchase");
		Buy.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			boolean purchValid = true;
			//for statistics
			Map<String, Integer> stat = ShopManagement.getStat();
			ArrayList<Item> items = ItemSystem.getItems();
			ArrayList<Bouquet> bouquets = ItemSystem.getBouquets();
			if(!items.isEmpty()) {
				for(Item item: items) {
					if(item instanceof Flower) {
						Flower f = (Flower)item;
						if(!DbControls.sellFlower(f.getFlowerType(), f.getFlowerQuantity()))
								purchValid = false;
						else
							ShopManagement.addToStat(f.getFlowerType(), f.getFlowerQuantity());
					}
					else {
						FlowerJewelry fj = (FlowerJewelry)item;
						if(!DbControls.sellJew(fj.getFlowerJewelryType(), 1))
							purchValid = false;
						else
							ShopManagement.addToStat(fj.getFlowerJewelryType(), 1);
					}
				}
			}
			if(!bouquets.isEmpty()) {
				for(Bouquet bouquet: bouquets) {
					for(Flower f: bouquet.getFlowerQuantity()) {
						if(!DbControls.sellFlower(f.getFlowerType(), f.getFlowerQuantity()))
							purchValid = false;
						else
							ShopManagement.addToStat(f.getFlowerType(), f.getFlowerQuantity());
					}
					//adding wrapping paper price;
					DbControls.setMoney(DbControls.getMoney()+3);
				}
			}
			else if(items.isEmpty() && bouquets.isEmpty()) {
				purchValid=false;
				ErrorMsg_1.setText("Cart is empty!");
			}
			if(purchValid)
			{
				DbControls.recordStats();
				//when purchase is successfully, empty everything
				ItemSystem.getBouquets().removeAll(ItemSystem.getBouquets());
				ItemSystem.getItems().removeAll(ItemSystem.getItems());
				textAreaCart.setText(ItemSystem.cartToString());
				ErrorMsg_1.setText("Thanks for shopping from Garden of Eden ;)");
				
			}
		}
		});
		Buy.setBackground(new Color(255, 255, 255));
		Buy.setFont(new Font("Arial", Font.BOLD, 12));
		Buy.setBounds(405, 377, 198, 35);
		contentPane.add(Buy);
	
		JButton btnGoToDelete = new JButton("→");
		btnGoToDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(getIdField.getText().equals(""))
					ErrorMsg.setText("Id is Empty!");
				else {
					int id = Integer.parseInt(getIdField.getText());
					if(ItemSystem.searchItem(id)!=null || ItemSystem.searchBouquet(id)!=null){
						//open delete
						CartFrame.setITEMSEARCHID(id);
						SDF= new SearchDeleteFrame(CFTemp);
						SDF.setVisible(true);
						setVisible(false);
					}
					else
						ErrorMsg.setText("Id "+id +" does not exist. Please enter correct id");
				}
				
			}
		});
		btnGoToDelete.setFont(new Font("Arial", Font.BOLD, 12));
		btnGoToDelete.setBackground(Color.WHITE);
		btnGoToDelete.setBounds(614, 138, 55, 32);
		contentPane.add(btnGoToDelete);
		
		ErrorMsg_1 = new JLabel("");
		ErrorMsg_1.setForeground(Color.RED);
		ErrorMsg_1.setFont(new Font("Arial", Font.BOLD, 14));
		ErrorMsg_1.setBounds(322, 418, 334, 32);
		contentPane.add(ErrorMsg_1);
			
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(CartFrame.class.getResource("/GUI/kamilaIcons/bg0.jpg")));
		lblNewLabel_4.setBounds(-459, 10, 1157, 585);
		contentPane.add(lblNewLabel_4);
		
	   
		
	
		
		
	}
}
