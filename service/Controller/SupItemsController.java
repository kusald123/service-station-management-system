/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AutoMiraj.Controller;

import AutoMiraj.DBconnect.DBConnection;
import AutoMiraj.Model.Supplier;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import AutoMiraj.Model.Itemsofsup;
/**
 *
 * @author Kusal Rodrigo
 */
public class SupItemsController {
    
        public static int addSupItems(Itemsofsup itemsofsup) throws ClassNotFoundException, SQLException {

        
        
       String sql="Insert into itemsneeded values(?,?,?,?,?)";
        
        
        int res = 0;
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        
        
        
        
        
       
        stm.setObject(1, itemsofsup.getItem_id());
        stm.setObject(2, itemsofsup.getItem_name());
        stm.setObject(3, itemsofsup.getItem_type());
        stm.setObject(4, itemsofsup.getItem_brand());
        stm.setObject(5, itemsofsup.getItem_model());
        
        
        res = stm.executeUpdate();
        return res;
    }
    
    
    public static int updateitemsofsup(Itemsofsup itemsofsup) throws ClassNotFoundException, SQLException{
        String sql = "Update itemsneeded set iname=?, itype=?, ibrand=?, imodel=? where iid=?" ;
        int res = 0;
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(5, itemsofsup.getItem_id());
        stm.setObject(1, itemsofsup.getItem_name());
        stm.setObject(2, itemsofsup.getItem_type());
        stm.setObject(3, itemsofsup.getItem_brand());
        stm.setObject(4, itemsofsup.getItem_model());
        
       
        
        
        
        res = stm.executeUpdate();
        return res;        
    
    }
    
     public static int deleteItemsofsup(String s_ID) throws ClassNotFoundException, SQLException{
        String sql = "Delete From itemsneeded where iid=?";
        int res = 0;
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1,s_ID);
        res = stm.executeUpdate();
        return res;        
    }    
    
     //OR location LIKE '%"+location+"%' OR item_name LIKE '%"+itemname+"%'
     public static  ResultSet searchItemsofsup(String itemname,String itemtype) throws ClassNotFoundException, SQLException{
        String sql="Select * from itemsneeded where iname LIKE '%"+itemname+"%' AND itype='"+itemtype+"'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        //stm.setObject(1,s_ID);
        ResultSet rst=stm.executeQuery();
//        if(rst.next()){
//            Supplier supplier=new Supplier(rst.getString("supplier_id"),rst.getString("supplier_name"),rst.getString("location"),rst.getString("item_name"),rst.getString("item_type"),rst.getString("brand"),rst.getString("model"),rst.getDouble("price"),rst.getInt("quantity"),rst.getString("email"));
//            return  supplier;
//        }else{
            return rst;
        }
    
     public static  ResultSet searchSupplierforOrders(String name,String brand,String model,String combo) throws ClassNotFoundException, SQLException{
        String sql="Select * from itemsneeded where (iname LIKE '%"+name+"%' OR ibrand LIKE '%"+brand+"%' OR imodel LIKE '%"+model+"%') AND itype='"+combo+"'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        //stm.setObject(1,s_ID);
        ResultSet rst=stm.executeQuery();
//        if(rst.next()){
//            Supplier supplier=new Supplier(rst.getString("supplier_id"),rst.getString("supplier_name"),rst.getString("location"),rst.getString("item_name"),rst.getString("item_type"),rst.getString("brand"),rst.getString("model"),rst.getDouble("price"),rst.getInt("quantity"),rst.getString("email"));
//            return  supplier;
//        }else{
            return rst;
        }
    
}
