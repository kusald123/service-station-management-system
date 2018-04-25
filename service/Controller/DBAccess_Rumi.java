/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AutoMiraj.Controller;
import AutoMiraj.DBconnect.DBconnect;
import AutoMiraj.DBconnect.DBconnect;
import AutoMiraj.DBconnect.DBconnect;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import net.proteanit.sql.DbUtils;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Rumesha
 */
public class DBAccess_Rumi {
    static Connection conn = DBconnect.connect();
    static PreparedStatement ps = null;
    static ResultSet rs = null;
    static Statement st = null;
    
    public static ResultSet getUser(){
        try{
            String sql;
            sql = "Select username,Address,teleNumber,DateJoined,UserType from users";
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            return rs;
        }catch (Exception e){
            return null;
        }
    }
    
    public static void addUsers (String name, String add, String tele, String dj, String type, String pw){
        try{
            String sql;
            sql = "Insert into users (username, Password, UserType, Address, teleNumber, DateJoined) values(?,?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, pw);
            ps.setString(3, type);
            ps.setString(4, add);
            ps.setString(5, tele);
            ps.setString(6, dj);
            
            ps.execute();
            
        }catch(Exception e){
        
        }
    
    } 
    
    public static ResultSet tableSelect (String name){
        try{
            String sql;
            sql = "Select * from users where username = '"+name+"'";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            return rs;
            
        }catch(Exception e){
            return null;
        } 
    }
    
    // Here its checking the current password is correct or not for the change password purpose.
    public static ResultSet chkPw(String name, String pw){
        try{
            String sql;
            sql = "Select username and Password from users where username = '"+name+"' and Password = '"+pw+"'";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            return rs;
            
        }catch(Exception e){
            return null;
        }
    }
    
    // After checking the current password, saving the new password if the current is correct
    public static void updatePW(String name, String newPW){
        try{
            String sql;
            sql = "update users SET Password = ? where username = '"+name+"'";
            ps = conn.prepareStatement(sql);
            ps.setString(1, newPW);
            
            ps.execute();
        }catch(Exception e){
            
        }
    }
    
    // Remove selected users from the system
    public static void removeUser(String name){
        try{
            String sql;
            sql = "delete from users where username = '"+name+"'";
            
            ps = conn.prepareStatement(sql);
            ps.execute();
            
        }catch(Exception e){
        
        }
    }
    
    //update user information but users cat change the username since user name is the primary key and its unique
    public static void updateUser(String name, String add, String tele, String dj, String type){
        try{
            String sql;
            sql = "update users set Address = ?, DateJoined = ?, UserType = ?, teleNumber = ? where username = '"+name+"'";
            ps = conn.prepareStatement(sql);
            ps.setString(1, add);
            ps.setString(2, dj);
            ps.setString(3, type);
            ps.setString(4, tele);
            
            ps.execute();
        }catch(Exception e){
        
        }
    }
    
    //Maintenance
    public static void insertMaintenance (String machineId,String s_date,String name ,String add_parts,String mec_detail,String remarks1,String cost1)
    {
        try {
            String q = "INSERT INTO maintenance(machine_id, service_date, machine_name, additional_parts, mechanic_details, remarks, cost) values (?,?,?,?,?,?,?)";
            ps = conn.prepareStatement(q);
            ps.setString(1, machineId);
            ps.setString(2, s_date);
            ps.setString(3, name);
            ps.setString(4, add_parts);
            ps.setString(5, mec_detail);
            ps.setString(6, remarks1);
            ps.setString(7, cost1);
            ps.execute();
           
        }
        catch (Exception e){
        }
    }  
    
    public static void login_details(String userType,String username,String currentTime)
    {
        try {
            String sql2 = "INSERT INTO session(username, userType, last_accessed) values (?,?,?)";
      
            ps = conn.prepareStatement(sql2);
           
            ps.setString(1, username);
            ps.setString(2, userType);
            ps.setString(3, currentTime);    
           
            ps.execute();
        }   
            catch (Exception e){
        }
           // System.out.println("done");
 //           tableLoad();
            
        }
    
    public static ResultSet getSession(){
        try{
            String sql;
            sql = "Select * from session";
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            
            return rs;
        }catch(Exception e){
            return null;
        }
    }
    
//Accessing available employee details         
    public static ResultSet getAvailableEmp(String type, String date, String time){
        try{
            String sql;
            //sql = "Select emp_name from shift_management where emp_work_type = '"+type+"' and date = '"+date+"' and Time = '"+time+"'";
            //sql = "Select sm.emp_name from shift_management sm inner join appoinment a on sm.emp_name = a.username where sm.emp_work_type = '"+type+"' and sm.date = '"+date+"' and sm.Time = '"+time+"'";
            //sql = "Select username from appoinment where tenTo12 <> '1'";
            sql = "Select username from tempschedule where time = '"+time+"' and Date = '"+date+"'";
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            
            return rs;
        }catch(Exception e){
            return null;
        }
    }
    
    public static ResultSet getUnavailableEmp(String date){
        try{
            String sql;
            //sql = "Select username from appoinment where date = '"+date+"'";
            sql = "Select * from appoinment where date = '"+date+"'";
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            
            return rs;
        }catch(Exception e){
            return null;
        }
    }
    
    //Getting a copy of shift management table to scheduling table
    //Step 01 delete all data from the scedule table 
    public static void deleteData(){
        try{
            String sql;
            sql = "Delete from tempschedule";
            ps = conn.prepareStatement(sql);
            ps.execute();
        }catch(Exception e){
        
        }
    }
    
    //STEP 02 making a copy
    public static ResultSet gettingDetails (){
        try{
            String sql;
            sql = "select emp_name, Time, Date, emp_work_type from shift_management";
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            
            return rs;
        }catch(Exception e){
            return null;
        }
    }
    //Step 03 Saving details in the new database
    public static void saveDetails(String name, String Time, String date, String work){
        try{
            String sql;
            sql = "insert into appoinment(Date, username, Time, WorkType, 8To10, tenTo12, oneTo3, threeTo5, fiveTo7, eightTo20) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            ps = conn.prepareStatement(sql);
            
            ps.setString(1, date);
            ps.setString(2, name);
            ps.setString(3, Time);
            ps.setString(4, work);         
            ps.setInt(5, 0);
            ps.setInt(6, 0);
            ps.setInt(7, 0);
            ps.setInt(8, 0);
            ps.setInt(9, 0);
            ps.setInt(10, 0);
            ps.execute();
            
        }catch(Exception e){
        
        }
    }
    

}
    
    

//    public void insertMaintenance(String machineId, String cat, String add_parts, String mec_detail, String remarks1, String cost1) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    
    
    
