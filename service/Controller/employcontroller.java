/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AutoMiraj.Controller;

//import employ.model.salary;
import AutoMiraj.View.emply;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import AutoMiraj.Model.employ;
import AutoMiraj.DBconnect.DBconnect;
import AutoMiraj.Model.leave;
import AutoMiraj.Model.shift;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import java.sql.*;
import javax.swing.*;
import java.sql.Statement;
import java.util.ArrayList;
/**
 *
 * @author user
 */
public class employcontroller {
    
    Connection con =null;
    ResultSet rs= null;
    PreparedStatement pst = null;
    
    
  private static Object conn;
    
    
   public static int addemploy(employ employ ) throws ClassNotFoundException, SQLException {
        String sql = "Insert into employee_table values(?,?,?,?,?,?,?,?)";
        int res = 0;
        @SuppressWarnings("LocalVariableHidesMemberVariable")
        Connection conn = (Connection) DBconnect.connect();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, employ.getregno());
        stm.setObject(2, employ.getName());
        stm.setObject(3, employ.getAddress());
        stm.setObject(4, employ.getnic());
        stm.setObject(5, employ.getphoneno());
        stm.setObject(6, employ.getempltype());
        stm.setObject(7, employ.getstartdate());
        stm.setObject(8, employ.otrate());
        //stm.setObject(9, employ());
        
        res = stm.executeUpdate();
              
        return res;  

        } 
   
   
   
    public static int addsalaary(salary salary ) throws ClassNotFoundException, SQLException {
        String sql = "Insert into salary values(?,?,?,?,?)";
        int res = 0;
        @SuppressWarnings("LocalVariableHidesMemberVariable")
        Connection conn = (Connection) DBconnect.connect();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, salary.getregno());
        stm.setObject(2, salary.getName());
        stm.setObject(3,salary.basicsalary());
        stm.setObject(4, salary.otrate());
        stm.setObject(5, salary.allowance());
      
        
        res = stm.executeUpdate();
              
        return res;  

        } 
   
   
    public static int addleave(leave leave) throws ClassNotFoundException, SQLException {
        String sql = "Insert into leave_management values(?,?,?,?)";
        int res = 0;
        @SuppressWarnings("LocalVariableHidesMemberVariable")
        Connection conn = (Connection) DBconnect.connect();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, leave.getregno());
        stm.setObject(2, leave.getName());
        stm.setObject(3, leave.getdes());
        stm.setObject(4, leave.getdate());
        res = stm.executeUpdate();
              
        return res;  

        } 
   
   
     public static int addshift(shift shift) throws ClassNotFoundException, SQLException {
        String sql = "Insert into shift_management values(?,?,?,?)";
        int res = 0;
        @SuppressWarnings("LocalVariableHidesMemberVariable")
        Connection conn = (Connection) DBconnect.connect();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, shift.getregno());
        stm.setObject(2, shift.getName());
        stm.setObject(3, shift.getotrate());
        stm.setObject(4, shift.getstartdate());
        res = stm.executeUpdate();
              
        return res;  

        } 
   
   
   
   
   
   
   
   
   
   
   
    private void Update_table(){
    
     try{   
        
    String sql="select * from employee";
    pst=con.prepareStatement(sql);
    rs=pst.executeQuery();
    jTable1.setModel(DbUtils.resultSetToTableModel(rs));
    
     }
    catch(Exception e){
    
    
    JOptionPane.showMessageDialog(null, e);
    
    
    }
    
    }
    
      private void Update_table4(){
    
     try{   
        
    String sql="select * from employee";
    pst=con.prepareStatement(sql);
    rs=pst.executeQuery();
    jTable1.setModel(DbUtils.resultSetToTableModel(rs));
    
     }
    catch(Exception e){
    
    
    JOptionPane.showMessageDialog(null, e);
    
    
    }
    
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    private static class jTable1 {

        private static void setModel(Object object) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        public jTable1() {
        }
    }

    private static class salary {

        public salary() {
        }

        private Object getregno() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private Object getName() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private Object basicsalary() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private Object otrate() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private Object allowance() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
} 


    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
