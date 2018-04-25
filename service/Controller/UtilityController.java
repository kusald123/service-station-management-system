/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AutoMiraj.Controller;

import AutoMiraj.DBconnect.DBConnection;
import AutoMiraj.Model.Utility;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



/**
 *
 * @author Amith
 */
public class UtilityController {
    
    public static int addBillPayment(Utility utility) throws ClassNotFoundException, SQLException{
        String sql = "Insert into utilitybill values(?,?,?,?,?,?,?)";
        int re = 0;
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, utility.getNo());
        stm.setObject(2, utility.getYear());
        stm.setObject(3, utility.getMonth());
        stm.setObject(4, utility.getElecBillPay());
        stm.setObject(5, utility.getTeleBillPay());
        stm.setObject(6, utility.getOtherBillPay());
        stm.setObject(7, utility.calcUtilityBill());
        re = stm.executeUpdate();
        
        return re;
    }
    
    public static int updateBillPayment(Utility utility) throws ClassNotFoundException, SQLException{
        String sql = "Update utilitybill set Elec_Bill_Payment=?, Tele_Bill_Payment=?, Other_Bill_Payment=?, Total_Bill=? where No=?";
        int re = 0;
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(5, utility.getNo());
        stm.setObject(1, utility.getElecBillPay());
        stm.setObject(2, utility.getTeleBillPay());
        stm.setObject(3, utility.getOtherBillPay());
        stm.setObject(4, utility.calcUtilityBill());        
        
        re = stm.executeUpdate();
        return re;        
    }
    
    public static int deleteBillPayment(String no) throws ClassNotFoundException, SQLException{
        String sql = "Delete From utilitybill where No=?";
        int re = 0;
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1,no);
        re = stm.executeUpdate();
        return re;        
    }
    
    
//////    public ArrayList getVehicleNo() {
//////        
//////            ArrayList cust = null;
//////            try {
//////         String sql="Select * from customer";
//////         Connection conn = DBConnection.getDBConnection().getConnection();
//////         PreparedStatement stm = conn.prepareStatement(sql);
//////         ResultSet rst1=stm.executeQuery(sql);
//////         cust = new ArrayList();
//////         while(rst1.next()){
//////             String sname1 = rst1.getString(7);
//////             cust.add(sname1);
//////         }
//////        
//////         
//////            } catch (SQLException e) {
//////                System.err.println(e);
//////            }
//////            catch(ClassNotFoundException ex){
//////                System.err.println(ex);
//////            }
//////             
//////      return cust; 
//////        }
    
    

}
