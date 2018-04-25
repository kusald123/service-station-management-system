/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AutoMiraj.Controller;

import java.sql.SQLException;
import AutoMiraj.Model.Estimation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import AutoMiraj.DBconnect.DBconnect;
import java.sql.ResultSet;
/**
 *
 * @author USER
 */
public class EstimationController {
    
    
    public static int addCusDetails(Estimation estimation) throws ClassNotFoundException, SQLException{
        String sql = "INSERT INTO customerdetails VALUES(?,?,?,?,?,?,?,?,?)";
        int res = 0;
        Connection conn = DBconnect.connect();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setObject(1, estimation.getCusId());
        ps.setObject(2, estimation.getEstimatedDate());
        ps.setObject(3, estimation.getCusName());
        ps.setObject(4, estimation.getCusAddress());
        ps.setObject(5, estimation.getTelNo());
        ps.setObject(6, estimation.getCusNic());
        ps.setObject(7, estimation.getVeName());
        ps.setObject(8, estimation.getManuYear());
        ps.setObject(9, estimation.getVeNumber());
        res = ps.executeUpdate();
        return res;
    }
    
    public static int updateCusDetails(Estimation estimation) throws ClassNotFoundException, SQLException{
        String sql = "UPDATE customerdetails SET date=?, customerName=?, address=?, contact=?, nic=?, vehicleName=?, manufactureYear=?, vehicleNumber=? WHERE customerId=?";
        int res = 0;
        Connection conn = DBconnect.connect();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setObject(1, estimation.getEstimatedDate());
        ps.setObject(2, estimation.getCusName());
        ps.setObject(3, estimation.getCusAddress());
        ps.setObject(4, estimation.getTelNo());
        ps.setObject(5, estimation.getCusNic());
        ps.setObject(6, estimation.getVeName());
        ps.setObject(7, estimation.getManuYear());
        ps.setObject(8, estimation.getVeNumber());
        ps.setObject(9, estimation.getCusId());
        res = ps.executeUpdate();
        return res;
    }
    
    public static int deleteCusDetails(String cusName) throws ClassNotFoundException, SQLException{
        String sql = "DELETE FROM customerdetails WHERE customerName=?";
        int res = 0;
        Connection conn = DBconnect.connect();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setObject(1, cusName);
        res = ps.executeUpdate();
        return res;        
    }
    
    public static ResultSet searchSpareParts(String type, String make, String name)throws ClassNotFoundException, SQLException{
        String sql="SELECT PartId, PartName, Type, Make, Price FROM spareparts WHERE Type LIKE '%"+type+"' AND Make LIKE '%"+make+"%' AND PartName LIKE '%"+name+"%'";
        Connection conn = DBconnect.connect();
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        return rs;
    }
    
    public static int addSpareParts(Estimation estimation) throws ClassNotFoundException, SQLException{
        String sql="INSERT INTO spareparts (PartId, PartName, Type, Make, Price) VALUES (?,?,?,?,?)";
            
        int res = 0;
        Connection conn = DBconnect.connect();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setObject(1, estimation.getPartId());
        ps.setObject(2, estimation.getPartName());
        ps.setObject(3, estimation.getPartType());
        ps.setObject(4, estimation.getPartType());
        ps.setObject(5, estimation.getPartPrice());
        
        res = ps.executeUpdate();
        return res;
    }
    
    public static int updateSpareParts(Estimation estimation) throws ClassNotFoundException, SQLException{
        String sql="UPDATE spareparts SET PartId=?, PartName=?, Type=?, Make=?, Price=? WHERE PartId=?";
            
        int res = 0;
        Connection conn = DBconnect.connect();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setObject(1, estimation.getPartId());
        ps.setObject(2, estimation.getPartName());
        ps.setObject(3, estimation.getPartType());
        ps.setObject(4, estimation.getPartMake());
        ps.setObject(5, estimation.getPartPrice());
        ps.setObject(6, estimation.getPartId());
        
        res = ps.executeUpdate();
        return res;
    }
    
    public static int deleteSpareParts(String partId) throws ClassNotFoundException, SQLException{
        String sql="DELETE FROM spareparts WHERE PartId=?";  
        int res = 0;
        Connection conn = DBconnect.connect();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setObject(1, partId);
        res = ps.executeUpdate();
        return res;        
    }
    
    
}

    