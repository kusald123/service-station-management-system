/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AutoMiraj.Controller;

import AutoMiraj.DBconnect.DBConnection;
import AutoMiraj.DBconnect.DBconnect;
import AutoMiraj.Model.BillStock;
import AutoMiraj.Model.CusBill;
import AutoMiraj.Model.ItemMove;
import AutoMiraj.Model.Service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Deshan
 */
public class ServiceContaller {

    public static int addService(Service serv) throws ClassNotFoundException, SQLException {
        String sql = "Insert into service values(?,?,?)";
        int res = 0;
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, serv.getSerId());
        stm.setObject(2, serv.getSerType());
        stm.setObject(3, serv.getSerAmount());
        res = stm.executeUpdate();
        return res;
    }

    public static ArrayList<Service> getAllService() throws ClassNotFoundException, SQLException {
        String sql = "Select * From Service";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<Service> ServiceList = new ArrayList<>();
        while (rst.next()) {
            Service service = new Service(rst.getString("serv_id"), rst.getString("serv_type"), rst.getDouble("serv_amount"));
            ServiceList.add(service);
        }
        return ServiceList;
    }

    public static int delteService(String serv_id) throws ClassNotFoundException, SQLException {
        String sql = "Delete From service where serv_id=?";
        int res = 0;
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, serv_id);
        res = stm.executeUpdate();
        return res;
    }

    public static int updateService(Service serv) throws ClassNotFoundException, SQLException {
        String sql = "Update service set serv_type=?,serv_amount=? where serv_id=?";
        int res = 0;
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(3, serv.getSerId());
        stm.setObject(1, serv.getSerType());
        stm.setObject(2, serv.getSerAmount());
        res = stm.executeUpdate();
        return res;
    }

    public static Service searchService(String serv_id) throws ClassNotFoundException, SQLException {
        String sql = "Select * from service where serv_id=?";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, serv_id);
        ResultSet rst = stm.executeQuery();
        if (rst.next()) {
            Service serv = new Service(rst.getString("serv_id"), rst.getString("serv_type"), rst.getDouble("serv_amount"));
            return serv;
        } else {
            return null;
        }
    }

    public static Service searchServiceType(String serv_type) throws ClassNotFoundException, SQLException {
        String sql = "Select * from service where serv_type=?";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, serv_type);
        ResultSet rst = stm.executeQuery();
        if (rst.next()) {
            Service serv = new Service(rst.getString("serv_id"), rst.getString("serv_type"), rst.getDouble("serv_amount"));
            return serv;
        } else {
            return null;
        }
    }

    public ArrayList getServiceType() {

        ArrayList service = null;
        try {
            String sql = "Select * from service";
            Connection conn = DBConnection.getDBConnection().getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            ResultSet rst = stm.executeQuery(sql);
            service = new ArrayList();
            while (rst.next()) {
                String sname = rst.getString(2);
                service.add(sname);
            }


        } catch (SQLException e) {
            System.err.println(e);
        } catch (ClassNotFoundException ex) {
            System.err.println(ex);
        }

        return service;
    }

    public static CusBill searchCusDetails(String vehicleNumber) throws ClassNotFoundException, SQLException {
        String sql = "Select * from customer where cvnumber=?";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, vehicleNumber);
        ResultSet rst = stm.executeQuery();
        if (rst.next()) {
            CusBill cb = new CusBill(rst.getString("cvnumber"), rst.getString("cnic"), rst.getString("cname"), rst.getString("upto"));
            return cb;
        } else {
            return null;
        }
    }

    public ArrayList getVehicleNo(String selectedDate) {

        ArrayList cust = null;
        try {
          //  System.out.println(selectedDate);
            String sql = "Select DISTINCT(cvnumber) from customer where upto ='"+selectedDate+"'";
            Connection conn = DBConnection.getDBConnection().getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            //stm.setString("a", "2015-08-13");
            ResultSet rst1 = stm.executeQuery(sql);
            cust = new ArrayList();
            while (rst1.next()) {
                String sname1 = rst1.getString(1);
                cust.add(sname1);
            }


        } catch (SQLException e) {
            System.err.println(e);
        } catch (ClassNotFoundException ex) {
            System.err.println(ex);
        }

        return cust;
    }
// MOVE OUT START-----------------------------------------------------------------------------------------------
    public ArrayList getItemType(String selectdate,String v_no) {
       
        ArrayList item = null;
        try {
           
            String sql = "Select  item_name from move_out where ((date ='"+selectdate+"') AND (vehicle_no='"+v_no+"'))";
            Connection conn = DBConnection.getDBConnection().getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            ResultSet rst1 = stm.executeQuery(sql);
            item = new ArrayList();
            while (rst1.next()) {
                String sname2 = rst1.getString(1);
                item.add(sname2);
            }


        } catch (SQLException e) {
            System.err.println(e);
        } catch (ClassNotFoundException ex) {
            System.err.println(ex);
        }

        return item;
    }

    public static ItemMove SelectItem(String item_type, String v_no,String date) throws ClassNotFoundException, SQLException {
        String sql = "Select * from move_out where ((item_name = '"+item_type+"') AND (vehicle_no = '"+v_no+"') AND (date = '"+date+"'))";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        //stm.setObject(1, item_type);
        ResultSet rst = stm.executeQuery();
        if (rst.next()) {
            ItemMove MI = new ItemMove(rst.getString("item_id"), rst.getString("item_name"), rst.getString("vehicle_no"), rst.getInt("quantity"), rst.getFloat("selling_price"), rst.getString("date"));
            return MI;
        } else {//( String item_id,String item_type,String vehicle_no,int quantity,float selling_price,String bdate)
            return null;
        }
    }

 


    //MOVE OUT END----------------------------------------------------------------------------------------------

    public static int addBillstock(BillStock BS) throws ClassNotFoundException, SQLException {
        String sql = "Insert into cus_bill values(?,?,?,?,?,?)";
        int res = 0;
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, BS.getcbillNo());
        stm.setObject(2, BS.getCusDate2());
        stm.setObject(3, BS.getvehicleNumber2());
        stm.setObject(4, BS.getNic2());
        stm.setObject(5, BS.getCusName2());
        stm.setObject(6, BS.getctotal());
        res = stm.executeUpdate();
        return res;
    }

    public static ArrayList<BillStock> getBillStock() throws ClassNotFoundException, SQLException {
        String sql = "Select * From cus_bill";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<BillStock> BillStockList = new ArrayList<>();
        while (rst.next()) {
            BillStock billSt = new BillStock(rst.getInt("cbill_no"), rst.getString("cbill_date"), rst.getString("cvehi_no"), rst.getString("cust_name"), rst.getString("cust_id"), rst.getDouble("cbill_total"));
            BillStockList.add(billSt);
        }
        return BillStockList;
    }
    
    
    
    public static int delteBill(String bill_id) throws ClassNotFoundException, SQLException {
        String sql = "Delete From cus_bill where cbill_no=?";
        int res = 0;
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, bill_id);
        res = stm.executeUpdate();
        return res;
    }
  public static BillStock searchBill(Integer bil_id) throws ClassNotFoundException, SQLException {
        String sql = "Select * from cus_bill where cbill_no=?";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, bil_id);
        ResultSet rst = stm.executeQuery();
        if (rst.next()) {
             BillStock BS = new BillStock(rst.getInt("cbill_no"), rst.getString("cbill_date"), rst.getString("cvehi_no"), rst.getString("cust_name"), rst.getString("cust_id"), rst.getDouble("cbill_total"));
            return BS;
        } else {
            return null;
        }
    }

}


