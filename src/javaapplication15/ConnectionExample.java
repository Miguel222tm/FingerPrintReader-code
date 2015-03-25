/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication15;

import java.sql.*;

public class ConnectionExample {
 
 
      Connection con;
      Statement st;
      ResultSet rs;
      
      public ConnectionExample(){
         connect();  
      }
       
     public void connect(){
         try{
             String driver= "sun.jdbc.odbc.JdbcOdbcDriver";
             Class.forName(driver);
             
             String db="jdbc:odbc:lectorhuella";
             con= DriverManager.getConnection(db);
             st= con.createStatement();
             
             String sql= "select * from subjects";
             rs= st.executeQuery(sql);
             
             while(rs.next()){
                 String ID= rs.getString("ID");
                 String Name = rs.getString("Name");
                 System.out.println(ID+""+Name);
                 
             }
             
         }catch (Exception ex){
             System.err.println(ex);
         }
     }
      
public static void main(String args[]) {
    new ConnectionExample();
}
}