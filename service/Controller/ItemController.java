/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AutoMiraj.Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import AutoMiraj.Model.Item;
import AutoMiraj.DBconnect.DBConnection;
import java.sql.ResultSet;
import java.util.ArrayList;
//import net.proteanit.sql.DbUtils;
/**
 *
 * @author Kusal Rodrigo
 */
public class ItemController {
    
    public static int addItem(Item item ) throws ClassNotFoundException, SQLException {
        String sql = "Insert into stock_inventory values(?,?,?,?,?,?,?,?,?)";
        int res = 0;
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, item.getItem_ID());
        stm.setObject(2, item.getItem_name());
        stm.setObject(3, item.getItem_type());
        stm.setObject(4, item.getItem_brand());
        stm.setObject(5, item.getItem_model());
        stm.setObject(6, item.getItem_price());
        stm.setObject(7, item.getItem_selling());
        stm.setObject(8, item.getItem_quantity());
        stm.setObject(9, item.getDate_received());
        res = stm.executeUpdate();
        return res;
    }
    public static int updateItem(Item item) throws ClassNotFoundException, SQLException{
        String sql = "Update stock_inventory set item_name=?, item_type=?, item_brand=?, item_model=?, item_purchase_price=?, item_selling_price=?, quantity=?, date_received=? where item_id=?";
        int res = 0;
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(9, item.getItem_ID());
        stm.setObject(1, item.getItem_name());
        stm.setObject(2, item.getItem_type());
        stm.setObject(3, item.getItem_brand());
        stm.setObject(4, item.getItem_model());
        stm.setObject(5, item.getItem_price());
        stm.setObject(6, item.getItem_selling());
        stm.setObject(7, item.getItem_quantity());
        stm.setObject(8, item.getDate_received());
        
        res = stm.executeUpdate();
        return res;        
    }
    
    
    public static int deleteItem(String item_id) throws ClassNotFoundException, SQLException{
        String sql = "Delete From Stock_inventory where item_id=?";
        int res = 0;
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1,item_id);
        res = stm.executeUpdate();
        return res;        
    }    
    
    public static ResultSet searchItem(String item_name,String combo) throws ClassNotFoundException, SQLException{
        String sql="select * from Stock_inventory where item_name LIKE '%"+item_name+"%' AND item_type='"+combo+"'";
        int res=0;
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
//        stm.setObject(1,item_name);
//        stm.setObject(2, combo);
        ResultSet rst=stm.executeQuery();
        

        
        return rst;
        
    }
 

        public static ArrayList getVehicleNo() {
        
            ArrayList cust = null;
            try {
         String sql="Select * from customer";
         Connection conn = DBConnection.getDBConnection().getConnection();
         PreparedStatement stm = conn.prepareStatement(sql);
         ResultSet rst1=stm.executeQuery(sql);
         cust = new ArrayList();
         while(rst1.next()){
             String sname1 = rst1.getString(10);
             cust.add(sname1);
         }
        
         
            } catch (SQLException e) {
                System.err.println(e);
            }
            catch(ClassNotFoundException ex){
                System.err.println(ex);
            }
             
      return cust; 
        }
        
        

    
    
}
