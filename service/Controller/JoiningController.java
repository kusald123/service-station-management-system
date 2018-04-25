/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AutoMiraj.Controller;

import AutoMiraj.DBconnect.DBConnection;
import AutoMiraj.Model.Itemsofsup;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import AutoMiraj.Model.SupItems;

/**
 *
 * @author Kusal Rodrigo
 */
public class JoiningController {
    
    public static int addMiddle(SupItems supitems) throws ClassNotFoundException, SQLException {

        
        
       String sql="Insert into suppliersitems (sup_id,itemid,iprice,iquantity) values (?,?,?,?)";
        
        
        int res = 0;
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        
        
        
        
        
       
        stm.setObject(1, supitems.getSupId());
        stm.setObject(2, supitems.getItemCode());
        stm.setObject(3, supitems.getItem_price());
        stm.setObject(4, supitems.getItem_quantity());
       
        
        
        res = stm.executeUpdate();
        return res;
    }
    
    
    public static int updateMiddle(SupItems supitems) throws ClassNotFoundException, SQLException{
        String sql = "Update suppliersitems set iprice=?, iquantity=? where sup_id=? AND itemid=?" ;
        int res = 0;
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(4, supitems.getItemCode());
        stm.setObject(3, supitems.getSupId());
        stm.setObject(1, supitems.getItem_price());
        stm.setObject(2, supitems.getItem_quantity());
 
        
       
        
        
        
        res = stm.executeUpdate();
        return res;        
    
    }
    
     public static int deleteMiddle(String s_ID,String iid) throws ClassNotFoundException, SQLException{
        String sql = "Delete From suppliersitems where sup_id='"+s_ID+"' AND itemid='"+iid+"'";
        int res = 0;
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        res = stm.executeUpdate();
        return res;        
    }    
    
     //OR location LIKE '%"+location+"%' OR item_name LIKE '%"+itemname+"%'
     public static  ResultSet searchMiddle(String itemname,String itemtype) throws ClassNotFoundException, SQLException{
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
    
//     public static  ResultSet searchSupplierforOrders(String name,String brand,String model,String combo) throws ClassNotFoundException, SQLException{
//        String sql="Select * from itemsneeded where (iname LIKE '%"+name+"%' OR ibrand LIKE '%"+brand+"%' OR imodel LIKE '%"+model+"%') AND itype='"+combo+"'";
//        Connection conn = DBConnection.getDBConnection().getConnection();
//        PreparedStatement stm = conn.prepareStatement(sql);
//        //stm.setObject(1,s_ID);
//        ResultSet rst=stm.executeQuery();
////        if(rst.next()){
////            Supplier supplier=new Supplier(rst.getString("supplier_id"),rst.getString("supplier_name"),rst.getString("location"),rst.getString("item_name"),rst.getString("item_type"),rst.getString("brand"),rst.getString("model"),rst.getDouble("price"),rst.getInt("quantity"),rst.getString("email"));
////            return  supplier;
////        }else{
//            return rst;
//        }
    

    
    
}
