/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AutoMiraj.Controller;

import java.sql.SQLException;
import AutoMiraj.Model.Fuel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import AutoMiraj.DBconnect.DBconnect;
import java.sql.ResultSet;
/**
 *
 * @author USER
 */
public class FuelController {
    
    public static int insertFuel(Fuel fuel) throws ClassNotFoundException, SQLException{
        String sql = "INSERT INTO insertfuel VALUES(?,?,?,?)";
        int res = 0;
        Connection conn = DBconnect.connect();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setObject(1, fuel.getFuelId());
        ps.setObject(2, fuel.getFuelName());
        ps.setObject(3, fuel.getFuelPrice());
        ps.setObject(4, fuel.getTankCapacity());
        res = ps.executeUpdate();
        return res;
    }
    
    public static int updateFuel(Fuel fuel) throws ClassNotFoundException, SQLException{
        String sql = "UPDATE insertfuel SET fuelName=?, fuelPrice=?, tankCapacity=? WHERE fuelId=?";
        int res = 0;
        Connection conn = DBconnect.connect();
        PreparedStatement ps = conn.prepareStatement(sql);
        
        ps.setObject(1, fuel.getFuelName());
        ps.setObject(2, fuel.getFuelPrice());
        ps.setObject(3, fuel.getTankCapacity());
        ps.setObject(4, fuel.getFuelId());
      
        res = ps.executeUpdate();
        return res;        
    }
    
    public static int deleteFuel(String fuelName) throws ClassNotFoundException, SQLException{
        String sql = "DELETE FROM insertfuel WHERE fuelName=?";
        int res = 0;
        Connection conn = DBconnect.connect();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setObject(1, fuelName);
        
        res = ps.executeUpdate();
        return res;        
    }
    
    
    
    
}