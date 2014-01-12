package org.teipir.softeng;

import java.awt.BorderLayout;
import java.sql.Statement;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;






import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.DropMode;
import javax.swing.JPasswordField;

import org.teipir.softeng.auction.client.AuctionsClient;

import javax.swing.JCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UserLogin extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7072032697389841939L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField username;
	Connection conn = null;
	Statement stmt,stmt1;
	private JPasswordField passwordField;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserLogin frame = new UserLogin(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param sqlstatement 
	 */
	public UserLogin(java.sql.Statement sqlstatement) {
		setTitle("Account Manager");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 473, 347);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setVisible(false);
		tabbedPane.addTab("Sign In", null, panel, null);
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
	
		try{Class.forName("com.mysql.jdbc.Driver");
       String connectionUrl="jdbc:mysql://localhost:3306/warehouse";
    	String username="root";
   	String password="12345";
   	Connection conn=DriverManager.getConnection(connectionUrl,username,password);
   	stmt = conn.createStatement();
		}
    	catch(Exception e){
		e.printStackTrace();
		}
		
		JLabel lblUsername = new JLabel("username");
		panel.add(lblUsername, "8, 8");
		
		username = new JTextField();
		panel.add(username, "14, 8, fill, default");
		username.setColumns(10);
		
		JLabel lblPassword = new JLabel("password");
		panel.add(lblPassword, "8, 12");
		
		passwordField = new JPasswordField();
		panel.add(passwordField, "14, 12, fill, default");
		passwordField.setColumns(10);
		
		JButton btnLgin = new JButton("Login");
		btnLgin.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String user = username.getText();
				//String strpass = passwordField.getText();
	            try {
	                Class.forName("com.mysql.jdbc.Driver");
	             } catch (ClassNotFoundException ex) {
	                 Logger.getLogger(UserLogin.class.getName()).log(Level.SEVERE, null, ex);
	             }
	             try {
	                 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/warehouse", "root", "12345");
	                 Statement st = con.createStatement();
	                 String query = "SELECT password FROM users where username='"+user+"'";
	                 System.out.println(query);
	                 
	              
	             ResultSet rs =  st.executeQuery(query)  ; 
	             String pass=null;
	             while(rs.next()){
	             	 pass = rs.getString("password");
	             }
	              // System.out.println(pass);
	                    
	                 char[] psw = passwordField.getPassword();
	                 String pswstr = new String(psw);
	             //    System.out.println(pswstr);
	                 
	                  
	                     if(pswstr.equals(pass)){
	                    	 
	                     JOptionPane.showMessageDialog(null,"Login Successful! ","Success",JOptionPane.PLAIN_MESSAGE);
	             
	                TableToJTable table = new TableToJTable(con);
	                try {
	                	setVisible(false);
						table.main(null);
						
					//	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						
					AuctionsClient	ac = new AuctionsClient(table);
					ac.setVisible(true);
						//ac.main(table);
						
					} catch (Exception e1) {
						
						e1.printStackTrace();
					}
	                 }
	            
	                
	                 else
	                 {
	                     JOptionPane.showMessageDialog(null,"User and/or password not found","Error",1);
	                 }
	             } catch (SQLException ex) {
	                 Logger.getLogger(UserLogin.class.getName()).log(Level.SEVERE, null, ex);
	             }



			}
		});
		
		
		panel.add(btnLgin, "14, 18");
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Create account", null, panel_1, null);
		panel_1.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		
		JLabel lblName = new JLabel("name");
		panel_1.add(lblName, "4, 2");
		
		textField = new JTextField();
		panel_1.add(textField, "8, 2, fill, default");
		textField.setColumns(10);
		
		JLabel lblSname = new JLabel("sName");
		panel_1.add(lblSname, "4, 4");
		
		textField_1 = new JTextField();
		textField_1.setDropMode(DropMode.INSERT);
		panel_1.add(textField_1, "8, 4, fill, default");
		textField_1.setColumns(10);
		
		JLabel lblEmail = new JLabel("e-mail");
		panel_1.add(lblEmail, "4, 6");
		
		textField_2 = new JTextField();
		panel_1.add(textField_2, "8, 6, fill, default");
		textField_2.setColumns(10);
		
		JLabel lblTelnumber = new JLabel("telnumber");
		panel_1.add(lblTelnumber, "4, 8");
		
		textField_3 = new JTextField();
		panel_1.add(textField_3, "8, 8, fill, default");
		textField_3.setColumns(10);
		
		JLabel lblCity = new JLabel("city");
		panel_1.add(lblCity, "4, 10");
		
		textField_4 = new JTextField();
		panel_1.add(textField_4, "8, 10, fill, default");
		textField_4.setColumns(10);
		
		JLabel lblAdress = new JLabel("adress");
		panel_1.add(lblAdress, "4, 12");
		
		textField_5 = new JTextField();
		panel_1.add(textField_5, "8, 12, fill, default");
		textField_5.setColumns(10);
		
		JLabel lblUsername_1 = new JLabel("username");
		panel_1.add(lblUsername_1, "4, 14");
		
		textField_6 = new JTextField();
		panel_1.add(textField_6, "8, 14, fill, default");
		textField_6.setColumns(10);
		
		JLabel lblPassword_1 = new JLabel("password");
		panel_1.add(lblPassword_1, "4, 16");
		
		textField_7 = new JTextField();
		panel_1.add(textField_7, "8, 16, fill, default");
		textField_7.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent f) {
			
				
					String nm = textField.getText();
					String snm = textField_1.getText();
					String mail = textField_2.getText();
					String tel = textField_3.getText();
					String cty = textField_4.getText();
					String adr = textField_5.getText();
					String uname = textField_6.getText();
					String psw = textField_7.getText();
					
					if (nm==null | snm ==null |mail == null |tel == null | cty == null | adr == null |uname == null |psw == null){
						
						JOptionPane.showMessageDialog(null," One or more fields are empty ","Error",JOptionPane.PLAIN_MESSAGE);
						System.exit(0);
					}
					
					try{
				
			                 Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/warehouse", "root", "12345");
			                 stmt1 = con1.createStatement();
			                 String query2 = ("insert into users(name,sName,email,telnumber,city,adr,username,password) values('"+nm+"','"+snm+"','"+mail+"','"+tel+"','"+cty+"','"+adr+"','"+uname+"','"+psw+"')");
			             //    String query3 = ("insert into login(username,password) values('"+uname+"','"+psw+"')");
			                 System.out.println(query2);
			             //    System.out.println(query3);
			                 stmt1.executeUpdate(query2);
			            //     stmt1.executeUpdate(query3);
			                 
					
					
				}
					
				catch(Exception e){
					e.printStackTrace();
				}
				finally{
					
					
					
						if(stmt1 !=null)
							try {
								stmt1.close();
							} catch (SQLException e) {
								
								e.printStackTrace();
							}
				
			}
					
				}
			
		});
		
		JCheckBox chckbxAccept = new JCheckBox("Accept terms");
		chckbxAccept.addMouseListener(new MouseAdapter() {
			
			public void mouseReleased(MouseEvent arg0) {
				
				//Edw prepei na emfanizetai ena arxeio keimenou  me tous orous xrisis.
			}
		});
		panel_1.add(chckbxAccept, "8, 18");
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("");
				textField_7.setText("");
			}
		});
		panel_1.add(btnClear, "4, 20");
		
	
		panel_1.add(btnSubmit, "8, 20");
	}

}

