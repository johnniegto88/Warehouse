package org.teipir.softeng;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Admin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin frame = new Admin();
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
	public Admin() {
		setTitle("Administation");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblItemid = new JLabel("itemID");
		lblItemid.setBounds(119, 99, 46, 14);
		contentPane.add(lblItemid);
		
		textField = new JTextField();
		textField.setBounds(211, 96, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String itemid = textField.getText();
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
		        String connectionUrl="jdbc:mysql://localhost:3306/warehouse";
		    	String username="root";
		    	String password="12345";
		 
		    	
		    	Connection conn = null;
				try {
					conn = DriverManager.getConnection(connectionUrl,username,password);
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
		   	java.sql.Statement stmt3 = null;
			try {
				stmt3 = conn.createStatement();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		   	
		   	String query = "delete from warehousefactory where itemID = '"+itemid +"' ";
		   	
		   	 try {
				stmt3.executeUpdate(query);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
				
			}
		});
		btnDelete.setBounds(159, 143, 89, 23);
		contentPane.add(btnDelete);
	}
}
