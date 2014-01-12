package org.teipir.softeng.auction.client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Dimension;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;






import com.mysql.jdbc.Statement;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;

import org.teipir.softeng.DateGet;
import org.teipir.softeng.TableToJTable;
import org.teipir.softeng.UserLogin;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;


public class AuctionsClient extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	Statement stmt;
	Connection conn;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField itemTitle;
	private JTextField itemStartPrice;
	private JTextField itemDesc;
	private JTextField expDay;
	private JTextField userNameAdd;
	private final TableToJTable ntable;
	/**
	 * Launch the application.
	 */
	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//AuctionsClient frame = new AuctionsClient(null);
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AuctionsClient(TableToJTable table) {
		ntable=table;
		setSize(new Dimension(475, 325));
		setTitle("Auction Manager");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Auction Bids", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblItemid = new JLabel("itemID");
		lblItemid.setBounds(22, 37, 60, 14);
		panel.add(lblItemid);
		
		textField = new JTextField();
		textField.setBounds(82, 34, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblBidprice = new JLabel("bidPrice");
		lblBidprice.setBounds(22, 76, 60, 14);
		panel.add(lblBidprice);
		
		textField_1 = new JTextField();
		textField_1.setBounds(82, 73, 86, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblUsername = new JLabel("username");
		lblUsername.setBounds(22, 120, 60, 14);
		panel.add(lblUsername);
		
		textField_2 = new JTextField();
		textField_2.setBounds(82, 117, 126, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		//Prepei  me kapoio tropo na kratisw to uername otan ginei login gia na ginei elegxos
		
		JRadioButton rdbtnInformViaEmail = new JRadioButton("Inform via e-mail if bidPrice Changed");
		rdbtnInformViaEmail.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				
		//Prepei na enimerwnetai ena pedio tis vasis wste kathe fora pou allazei timi na enimerwnetai o xristis me email
			}
		});
		rdbtnInformViaEmail.setBounds(22, 150, 298, 23);
		panel.add(rdbtnInformViaEmail);
		
		
		
		JButton btnBid = new JButton("BID");
		btnBid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 String itemid = textField.getText();
				 String bid = textField_1.getText();
				 String uname = textField_2.getText();
				
				 
				   try {
		               Class.forName("com.mysql.jdbc.Driver");
		            } catch (ClassNotFoundException ex) {
		                Logger.getLogger(UserLogin.class.getName()).log(Level.SEVERE, null, ex);
		            }
				
				
				try{Class.forName("com.mysql.jdbc.Driver");
			        String connectionUrl="jdbc:mysql://localhost:3306/warehouse";
			    	String username="root";
			    	String password="12345";
			   	Connection conn=DriverManager.getConnection(connectionUrl,username,password);
			   	java.sql.Statement stmt3 = conn.createStatement();
			   	java.sql.Statement stmt4 = conn.createStatement();
			   	java.sql.Statement stmt5 = conn.createStatement();
			   	java.sql.Statement stmt6 = conn.createStatement();
			   
			   	String query3 = "select id from users where username='"+uname+"'";
			   	
			   	stmt3.executeQuery(query3); 
			   	
			   	String query6 = "select itemPrice from warehousefactory where itemID = '"+itemid+"'";
			   	
			   	ResultSet rs = stmt6.executeQuery(query6);
			   	
			   	String itPr = null;
			   	while (rs.next()){
			   	itPr = rs.getString("itemPrice"); 
			   	}
			   	
			   	
			   	if(Integer.parseInt(bid)>=Integer.parseInt(itPr)){
			   	String query4 = "update warehousefactory set itemPrice ='"+bid+"' where itemID = '"+itemid+"'";
			   	
			   	stmt4.executeUpdate(query4);
			   	
			   	String query5 = "update warehousefactory set lastBidFromUser = '"+uname+"' where itemID = '"+itemid+"'";
			   	
			   	stmt5.executeUpdate(query5);
			   	
			   	JOptionPane.showMessageDialog(null,"Please Refresh to get the latest Updates","Bid Success",JOptionPane.PLAIN_MESSAGE);
			   	}
			   	else{
			   		JOptionPane.showMessageDialog(null,"Bid Price lower than item Price ","Bid Failed",JOptionPane.PLAIN_MESSAGE);
			   	}
			   	
				
				}
				catch(Exception e2){
					e2.printStackTrace();
					}	
				
				
					
			}
		});
		btnBid.setBounds(138, 193, 89, 23);
		panel.add(btnBid);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.setForeground(Color.RED);
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//TableToJTable tnew= new TableToJTable(conn);
				
				try {
					//tnew.setVisible(false);
					//tnew.invalidate();
					//tnew.revalidate();
					//tnew.repaint();
					ntable.changeTable();
					//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				
				
			}
		});
		btnRefresh.setBounds(22, 193, 89, 23);
		panel.add(btnRefresh);
		
		JLabel lblBidpriceMustBe = new JLabel("bidPrice must be higher than the itemPrice");
		lblBidpriceMustBe.setForeground(Color.BLUE);
		lblBidpriceMustBe.setBounds(178, 66, 251, 34);
		panel.add(lblBidpriceMustBe);
		
		JLabel lblInsertYourUsername = new JLabel("insert your username");
		lblInsertYourUsername.setForeground(Color.BLUE);
		lblInsertYourUsername.setBounds(238, 120, 171, 14);
		panel.add(lblInsertYourUsername);
		
		JLabel lblInsertTheItemid = new JLabel("insert the itemID tha you want to bid");
		lblInsertTheItemid.setForeground(Color.BLUE);
		lblInsertTheItemid.setBounds(211, 37, 208, 14);
		panel.add(lblInsertTheItemid);
		
		JLabel lblHitBidAnd = new JLabel("Hit BID to Apply");
		lblHitBidAnd.setForeground(Color.BLUE);
		lblHitBidAnd.setBounds(257, 197, 132, 14);
		panel.add(lblHitBidAnd);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("New Item", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblItemname = new JLabel("item Title");
		lblItemname.setBounds(10, 36, 62, 22);
		panel_1.add(lblItemname);
		
		JLabel lblNewLabel = new JLabel("Expired Day");
		lblNewLabel.setBounds(10, 102, 91, 14);
		panel_1.add(lblNewLabel);
		
		JLabel lblItemstartingprice = new JLabel("item Starting Price");
		lblItemstartingprice.setBounds(10, 69, 128, 22);
		panel_1.add(lblItemstartingprice);
		
		JLabel lblItemdescreption = new JLabel("item Descreption");
		lblItemdescreption.setBounds(10, 132, 91, 22);
		panel_1.add(lblItemdescreption);
		
		itemTitle = new JTextField();
		itemTitle.setBounds(113, 37, 86, 20);
		panel_1.add(itemTitle);
		itemTitle.setColumns(10);
		
		itemStartPrice = new JTextField();
		itemStartPrice.setBounds(113, 70, 86, 20);
		panel_1.add(itemStartPrice);
		itemStartPrice.setColumns(10);
		
		itemDesc = new JTextField();
		itemDesc.setBounds(111, 127, 259, 33);
		panel_1.add(itemDesc);
		itemDesc.setColumns(10);
		
		expDay = new JTextField();
		
		
		
		expDay.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent arg0) {
				DateGet dg = new DateGet();
				String gd = dg.getNewDate();
				 JOptionPane.showMessageDialog(null,"Expired Day Must Be Higher than "+gd,"Attention",JOptionPane.PLAIN_MESSAGE);

			}
		});
		expDay.setBounds(113, 98, 86, 22);
		panel_1.add(expDay);
		expDay.setColumns(10);
		
		JLabel lblUsername_1 = new JLabel("username");
		lblUsername_1.setBounds(10, 11, 62, 14);
		panel_1.add(lblUsername_1);
		
		userNameAdd = new JTextField();
		userNameAdd.setBounds(113, 6, 86, 20);
		panel_1.add(userNameAdd);
		userNameAdd.setColumns(10);
		
		//if (userNameAdd!=user ){	}
		
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 String usradd = userNameAdd.getText();
				 String iT = itemTitle.getText();
				 String iD = itemDesc.getText();
				 String isP = itemStartPrice.getText();
				 String d = expDay.getText();
				 
				 if (usradd != "" & iT != "" & iD != "" & isP != "" & d != ""){
			
					 
				 
				 
				   try {
		               Class.forName("com.mysql.jdbc.Driver");
		            } catch (ClassNotFoundException ex) {
		                Logger.getLogger(UserLogin.class.getName()).log(Level.SEVERE, null, ex);
		            }
				
				
				try{Class.forName("com.mysql.jdbc.Driver");
			       String connectionUrl="jdbc:mysql://localhost:3306/warehouse";
			    	String username="root";
			   	String password="12345";
			   	Connection conn=DriverManager.getConnection(connectionUrl,username,password);
			   	java.sql.Statement stmt = conn.createStatement();
			   	java.sql.Statement stmt1 = conn.createStatement();
			   	
			   
			   	
			   	String query = "select id from users where username='"+usradd+"'";
			   	
			    
			   	
			    ResultSet rs =  stmt.executeQuery(query); 
	             int id=0;
	           while(rs.next()){
	            	id = rs.getInt("id");
	              }
	             	
	             
	         
			   	
			  	String query1="insert into warehousefactory(itemTitle,itemDesc,itemPrice,userId,expDate) values ('"+iT+"','"+iD+"','"+isP+"','"+id+"','"+d+"')";
			  	stmt1.executeUpdate(query1);
			   	System.out.println(query1);
	             
			   	
					}
			    	catch(Exception e1){
					e1.printStackTrace();
					}	
				
			}
				 else {		 JOptionPane.showMessageDialog(null,"One or more fields are empty ","Error",JOptionPane.PLAIN_MESSAGE);
				 System.exit(0);
				 }
			}
			 
		});
		
		btnAdd.setBounds(306, 189, 89, 23);
		panel_1.add(btnAdd);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				userNameAdd.setText("");
				itemTitle.setText("");
				itemStartPrice.setText("");
				expDay.setText("");
				itemDesc.setText("");
				
			}
		});
		btnClear.setBounds(207, 189, 89, 23);
		panel_1.add(btnClear);
		
		JLabel lblDateFormatDdmmyy = new JLabel("Date Format dd/mm/yy");
		lblDateFormatDdmmyy.setForeground(Color.BLUE);
		lblDateFormatDdmmyy.setBounds(209, 102, 186, 14);
		panel_1.add(lblDateFormatDdmmyy);
		
		JLabel lblInsertPriceThat = new JLabel("insert price that auction will start with");
		lblInsertPriceThat.setForeground(Color.BLUE);
		lblInsertPriceThat.setBounds(199, 73, 220, 14);
		panel_1.add(lblInsertPriceThat);
		
		JLabel lblInsertYourUsername_1 = new JLabel("insert your username");
		lblInsertYourUsername_1.setForeground(Color.BLUE);
		lblInsertYourUsername_1.setBounds(232, 11, 177, 14);
		panel_1.add(lblInsertYourUsername_1);
		
		JButton btnNewButton = new JButton("Upload Images");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				//Edw prepei na anoigei parathiro dialogou gia anebasma eikonas kai eisagwgi sti vasi
			}
		});
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setBounds(10, 189, 113, 23);
		panel_1.add(btnNewButton);
		
		JLabel lblInsertAShort = new JLabel("insert a short title about your item");
		lblInsertAShort.setForeground(Color.BLUE);
		lblInsertAShort.setBounds(209, 40, 200, 14);
		panel_1.add(lblInsertAShort);
		
		JButton btnRefresh_1 = new JButton("Refresh");
		btnRefresh_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				TableToJTable ttj2 = new TableToJTable(conn);
				try {
					ttj2.main(null);
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			}
		});
		btnRefresh_1.setBounds(258, 165, 89, 23);
		panel_1.add(btnRefresh_1);
		
		
			
	
	}
}
