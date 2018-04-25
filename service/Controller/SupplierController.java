/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AutoMiraj.Controller;

import AutoMiraj.DBconnect.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import AutoMiraj.Model.Supplier;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 *
 * @author Kusal Rodrigo
 */
public class SupplierController {
    
    public static int addSupplier(Supplier supplier) throws ClassNotFoundException, SQLException {

        
        
       String sql="Insert into suppliers values(?,?,?,?)";
        
        
        int res = 0;
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        
        
        
        
        
       stm.setObject(1, supplier.getS_id());
        stm.setObject(2, supplier.getS_name());
        stm.setObject(3, supplier.getS_location());
        stm.setObject(4, supplier.getS_email());
//        stm.setObject(5, supplier.getitem_id());
//        stm.setObject(6, supplier.getItem_name());
//        stm.setObject(7, supplier.getItem_type());
//        stm.setObject(8, supplier.getItem_brand());
//        stm.setObject(9, supplier.getItem_model());
//        stm.setObject(10, supplier.getItem_price());
//        stm.setObject(11, supplier.getItem_quantity());
        
        res = stm.executeUpdate();
        return res;
    }
    
    
    public static int updateSupplier(Supplier supplier) throws ClassNotFoundException, SQLException{
        String sql = "Update suppliers set sname=?, slocation=?, semail=? where sid=?" ;
        int res = 0;
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(4 , supplier.getS_id());
        stm.setObject(1 , supplier.getS_name());
        stm.setObject(2 , supplier.getS_location());
        stm.setObject(3 , supplier.getS_email());
       
        
        
        
        res = stm.executeUpdate();
        return res;        
    
    }
    
     public static int deleteSupplier(String s_ID) throws ClassNotFoundException, SQLException{
        String sql = "Delete From suppliers where sid=?";
        int res = 0;
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1,s_ID);
        res = stm.executeUpdate();
        return res;        
    }    
    
     //OR location LIKE '%"+location+"%' OR item_name LIKE '%"+itemname+"%'
     public static  ResultSet searchSupplier(String supname,String location) throws ClassNotFoundException, SQLException{
        String sql="Select * from suppliers where sname LIKE '%"+supname+"%' AND slocation LIKE '%"+location+"%'";
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
        String sql="Select * from suppliers where (iname LIKE '%"+name+"%' OR ibrand LIKE '%"+brand+"%' OR imodel LIKE '%"+model+"%') AND itype='"+combo+"'";
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
    
    public static int addmiddle(String supId,String itemCode) throws ClassNotFoundException, SQLException{
        String sql="Insert into suppliersitems (sup_id,itemid) values('"+supId+"','"+itemCode+"')";
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=conn.prepareStatement(sql);
//        stm.setObject(7, itemsofsup.getItem_price());
//        stm.setObject(6, itemsofsup.getItem_quantity());
        
        return stm.executeUpdate();
        
        
    }
    
    
}

     
