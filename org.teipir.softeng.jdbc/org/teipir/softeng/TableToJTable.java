package org.teipir.softeng;
import javax.swing.*;
import javax.swing.table.*;

import java.sql.*;


public class TableToJTable extends JFrame{

	private static final long serialVersionUID = 1L;

    private Connection con;
    JFrame f = new JFrame("Title");
    public TableToJTable(Connection con){
        this.con=con;
    }
  
    
    
    public JTable getTable(String table)throws Exception{
        JTable t1=new JTable();
        DefaultTableModel dm=new DefaultTableModel();
        Statement st=con.createStatement();   
        ResultSet rs=st.executeQuery("select * from "+table);
        ResultSetMetaData rsmd=rs.getMetaData();
       
        
        int cols=rsmd.getColumnCount();
        String c[]=new String[cols];
        for(int i=0;i<cols;i++){
            c[i]=rsmd.getColumnName(i+1);
            dm.addColumn(c[i]);
        }
        
        
        Object row[]=new Object[cols];
        while(rs.next()){
             for(int i=0;i<cols;i++){
                    row[i]=rs.getString(i+1);
                }
            dm.addRow(row);
        }
        t1.setModel(dm);
        con.close();
        return t1;
    }
    


    public void main(Object object)throws Exception{
    	
    	f.setVisible(true);   
        f.setTitle("Auction Table");
        Class.forName("com.mysql.jdbc.Driver");
		  String connectionUrl="jdbc:mysql://localhost:3306/warehouse";
	     	String username="root";
	     	String password="12345";
	     Connection con=DriverManager.getConnection(connectionUrl,username,password);
    	org.teipir.softeng.TableToJTable obj = new org.teipir.softeng.TableToJTable(con);
		JScrollPane sp=new JScrollPane(obj.getTable("warehousefactory"));
		f.getContentPane().add(sp);
		f.setBounds(200,200,400,349);
            
    }
    
    public void changeTable(){
    
    	f.setVisible(false);
    	
    	TableToJTable table = new TableToJTable(con);
    	try {
			table.main(null);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
    	
 
}

}