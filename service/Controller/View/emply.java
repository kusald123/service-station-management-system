package AutoMiraj.View;

//import Interfaces.main_gui;

import AutoMiraj.DBconnect.DBconnect;
import AutoMiraj.View.employcheat;
import AutoMiraj.View.employpaysheet;
import AutoMiraj.View.main_gui;
//import com.itextpdf.text.Paragraph;
//import com.itextpdf.text.pdf.PdfWriter;
//import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.sql.*;
import javax.swing.text.Document;
import net.proteanit.sql.DbUtils;
import java.text.*;
import java.awt.print.*;
import javax.swing.JTable;
import java.util.Date;
//import java.util.Calendar;
//import java.util.GregorianCalendar;
//import java.util.Calendar;
//import static java.util.Calendar.MONTH;
//import java.util.GregorianCalendar;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author universal cal
 */
public class emply extends javax.swing.JFrame {
    Connection con =null;
    ResultSet rs= null;
    PreparedStatement pst = null;
    
// private employ employ;
 //   private Calendar (Null);
    private Object sareg;

     
    public emply() {
        initComponents();
        
       con=DBconnect.connect();
       Update_table();
       Update_table2();
       Update_table3();
       Update_table4();
       Total_table();
       leave_total();
       fillcombo();
       Total_Amount();
    }

    public void errchcker(){
    
    
        String ereg=(eregno.getText());
        String eename=(ename.getText());
        String address=(eaddress.getText());
        String nic=(enic.getText()); 
        String phone=(ephoneno.getText());
        String estartda=((JTextField)estartdate.getDateEditor().getUiComponent()).getText();
        String etype=(eemptype.getSelectedItem().toString());
        String empsal=(empsa.getText());
        String eot=(eott.getText());
       
    
     if(eregno.getText().length()==0){
            JOptionPane.showMessageDialog(this, "Please add Employee RegNo");
            eregno.requestFocus();
            
            return;    
        }
    
    
     else if(ename.getText().length()==0){
            JOptionPane.showMessageDialog(this, "Please add Employee name");
            ename.requestFocus();
            
            return;
     }
    
    else if(eaddress.getText().length()==0){
            JOptionPane.showMessageDialog(this, "Please add Employee address");
            eaddress.requestFocus();
            
            return;
     }
    
    else if(enic.getText().length()!=10 && enic.getText().length()!=0){
            JOptionPane.showMessageDialog(this, "Please check Employee NIC");
            enic.requestFocus();
            
            return;
        }
        
        else if(enic.getText()=="^[0-9]"){
            JOptionPane.showMessageDialog(this, "Please check NIC");
            enic.requestFocus();
            
            return;
        }
        
        else if(enic.getText().length()==0){
            JOptionPane.showMessageDialog(this, "Please add Employee NIC");
            enic.requestFocus();
            
            return;
        }
        
        else if(ephoneno.getText().length()!=10 && enic.getText().length()!=0){
            JOptionPane.showMessageDialog(this, "Please check Employee phone no");
            ephoneno.requestFocus();
            
            return;
        }
      
    else if(ephoneno.getText().length()==0){
            JOptionPane.showMessageDialog(this, "Please add Employee phone No");
            ephoneno.requestFocus();
            
            return;
    }
     
     
     else if
       (eemptype.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(this, "Please select Employee type");
            eemptype.requestFocus();
            
            return;    
        
        
    }
      if(empsa.getText().length()==0){
            JOptionPane.showMessageDialog(this, "Please add Employee Basic Salary");
            empsa.requestFocus();
            
            return;    
        }
        else if(eott.getText().length()==0){
            JOptionPane.showMessageDialog(this, "Please add Employee OT Rate");
            eott.requestFocus();
            
            return;
     }
    
     
     
       else if
       (((JTextField)estartdate.getDateEditor().getUiComponent()).getText().length()==0){
           JOptionPane.showMessageDialog(this, "Please select Start date");
           estartdate.requestFocus();
            
           return;    
       }     
           
       else{
       
       
        try{
     
         
     String sql= "INSERT INTO employee_table (regno,emp_name,address,nic,ephone,emptype,basic_salary,OT,joined_date) values (?,?,?,?,?,?,?,?,?)";
     
     
        pst= con.prepareStatement(sql);
        pst.setString (1,eregno.getText());
        pst.setString (2,ename.getText());
        pst.setString (3,eaddress.getText());
        pst.setString (4,enic.getText());
        pst.setString (5,ephoneno.getText());
        pst.setString (6,eemptype.getSelectedItem().toString());
        pst.setString (7,empsa.getText());
        pst.setString (8,eott.getText());
        pst.setString (9,((JTextField)estartdate.getDateEditor().getUiComponent()).getText());
        
     
     
     
        pst.execute();
        Update_table();
          JOptionPane.showMessageDialog(null, "saved");
         
         
     }catch  (Exception e){
         
         JOptionPane.showMessageDialog(null, e);
    
     
     }
    
       
       }        
           
       
     
     
     
     
     
     
     
     
     
     
     
     

    }
    
    
    public void errchcker2(){ 
     
     
     
      String llreg=lreg.getText();
      String llname=lname.getText();
      String lldes=ldes.getText();
      String estartda=((JTextField)ldate.getDateEditor().getUiComponent()).getText();
      String lday=(ld.getSelectedItem().toString());
      String lappr=(lapp.getSelectedItem().toString());
     
     
          if(lreg.getText().length()==0){
            JOptionPane.showMessageDialog(this, "Please add Employee RegNo");
            lreg.requestFocus();
            
            return;    
        }
    
    
     else if(lname.getText().length()==0){
            JOptionPane.showMessageDialog(this, "Please add Employee name");
            lname.requestFocus();
            
            return;
     }
    
    else if(ldes.getText().length()==0){
            JOptionPane.showMessageDialog(this, "Please add Description");
            ldes.requestFocus();
            
            return;
     } 
    
          
        else if(((JTextField)ldate.getDateEditor().getUiComponent()).getText().length()==0){
            JOptionPane.showMessageDialog(this, "Please add Date");
            ldate.requestFocus();
            
            return;
     } 
         else if
       (ld.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(this, "Please add  leaves days");
            ld.requestFocus();
            
            return;    
        
        
    }
     else if(lapp.getSelectedIndex()!=4 && lapp.getSelectedIndex()!=0){
            JOptionPane.showMessageDialog(this, "You cannot enter 'NO' or 'YES'");
            lapp.requestFocus();
            
            return;
        }
        
         
        
        
          else{ 
        
        
         try{
              
              
      String sql= "INSERT INTO leave_management (ereg_no,emp_name,edes,edate,Days,Approval) values (?,?,?,?,?,?)";
     
     
        pst= con.prepareStatement(sql);
      
        pst.setString (1,lreg.getText());
        pst.setString (2,lname.getText());
        pst.setString (3,ldes.getText());
        pst.setString (4,((JTextField)ldate.getDateEditor().getUiComponent()).getText());
        pst.setString (5,ld.getSelectedItem().toString());
        pst.setString (6,lapp.getSelectedItem().toString());
        
       pst.execute();
     Update_table3();
          JOptionPane.showMessageDialog(null, "saved");
      
      
      }catch (Exception e){
          
           JOptionPane.showMessageDialog(null, e);
              
          }
   
          
          
          
        }
       
        
        
        
        }   
          
    
    
     
    public void errchcker1(){
    
    String ssreg=sreg.getText();
    String ssname=sname.getText();
    String estartda=((JTextField)sdate.getDateEditor().getUiComponent()).getText();
    String ssot=sot.getText();
    String etype=(stime.getSelectedItem().toString());
    String empwtype=(stype.getSelectedItem().toString());
    
    
    
    
     if(sreg.getText().length()==0){
            JOptionPane.showMessageDialog(this, "Please add Employee RegNo");
            sreg.requestFocus();
            
            return;    
        }
    
    
     else if(sname.getText().length()==0){
            JOptionPane.showMessageDialog(this, "Please add Employee name");
            sname.requestFocus();
            
            return;
     }
    
    else if(sot.getText().length()==0){
            JOptionPane.showMessageDialog(this, "Please add Employee OT Rate");
            sot.requestFocus();
            
            return;
     }
     
     
      else if(((JTextField)sdate.getDateEditor().getUiComponent()).getText().length()==0){
            JOptionPane.showMessageDialog(this, "Please add Date");
            sdate.requestFocus();
            
            return;
     }
      
      else if
       (stype.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(this, "Please select Employee Work Type");
            stype.requestFocus();
            
            return;    
        
        
    }
      
      else if
       (stime.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(this, "Please select Shift time");
            stime.requestFocus();
            
            return;    
        
        
    }
     
      
      
     
      else{
      
      try{
      
      String sql= "INSERT INTO shift_management (reg_no,emp_name,date,ot_rate,emp_work_type,Time) values (?,?,?,?,?,?)";
     
     
        pst= con.prepareStatement(sql);
      
        pst.setString (1,sreg.getText());
        pst.setString (2,sname.getText());
        pst.setString (3,((JTextField)sdate.getDateEditor().getUiComponent()).getText());
        pst.setString (4,sot.getText());
        pst.setString (5,stype.getSelectedItem().toString());
        pst.setString (6,stime.getSelectedItem().toString());
      
       pst.execute();
        Update_table2();
     
          JOptionPane.showMessageDialog(null, "saved");
      
      
      }catch (Exception e){
          
           JOptionPane.showMessageDialog(null, e);
      
      }
      
      
      
      }
    }
     
     
     
   
 
         
           
      
          private void Update_table(){
    
     try{   
        
    String sql="select * from employee_table";
    pst=con.prepareStatement(sql);
    rs=pst.executeQuery();
    jTable1.setModel(DbUtils.resultSetToTableModel(rs));
    
     }
    catch(Exception e){
    
    
    JOptionPane.showMessageDialog(null, e);
    
    
    }
    
    }    
          

            private void Update_table2(){
    
     try{   
        
    String sql="select * from shift_management";
    pst=con.prepareStatement(sql);
    rs=pst.executeQuery();
    jTable2.setModel(DbUtils.resultSetToTableModel(rs));
    
     }
    catch(Exception e){
    
    
    JOptionPane.showMessageDialog(null, e);
    
    
    }
    
    }

     private void Update_table3(){
    
     try{   
        
    String sql="select * from leave_management";
    pst=con.prepareStatement(sql);
    rs=pst.executeQuery();
    jTable3.setModel(DbUtils.resultSetToTableModel(rs));
    
     }
    catch(Exception e){
    
    
    JOptionPane.showMessageDialog(null, e);
    
    
    }
    
    }

     
      private void Update_table4(){
    
     try{   
        
    String sql="select * from salary";
    pst=con.prepareStatement(sql);
    rs=pst.executeQuery();
    jTable5.setModel(DbUtils.resultSetToTableModel(rs));
    
     }
    catch(Exception e){
    
    
    JOptionPane.showMessageDialog(null, e);
    
    }
    
    }
     
 private void fillcombo() {
  try{
    
   String sql="select * from employee_table";
    
    pst=con.prepareStatement(sql);
    rs=pst.executeQuery();
    
    
    while(rs.next()){
    
    String reg =rs.getString("regno");
    regcom.addItem(reg);
    String name =rs.getString("emp_name");
    namcom.addItem(name);
    String salary =rs.getString("basic_salary");
    sbasic.addItem(salary);
    String sotr =rs.getString("OT");
    sotrate.addItem(sotr);
   }
    
    }catch(Exception e){
    
   JOptionPane.showMessageDialog(null, e);
    
  }
    
    
    
    
    } 
     
 public void salcal(){
 
 
 
  Double d = Double.parseDouble(sbasic.getSelectedItem().toString());
  Double e = Double.parseDouble(sotr.getText());
  Double f = Double.parseDouble(sall.getText());
  Double g = Double.parseDouble(sepf.getText());
  Double h = Double.parseDouble(snopa.getText());
  Double i = Double.parseDouble(sotrate.getSelectedItem().toString());
  Double j = Double.parseDouble(sloss.getText());
  Double am= d+(e*i)+f-g-(100*h)-j;
 
 samou.setText(am+ " ");
 
 
 
 }
  
  
   private void Total_table(){
    
     try{   
        
    String sql="select reg_no,emp_name,Sum(ot_rate)total from shift_management GROUP BY reg_no";
    pst=con.prepareStatement(sql);
    rs=pst.executeQuery();
    jTable4.setModel(DbUtils.resultSetToTableModel(rs));
    
     }
    catch(Exception e){
    
    
    JOptionPane.showMessageDialog(null, e);
    
    }
    
    }
    
     private void leave_total(){
    
     try{   
        
    String sql="select ereg_no,emp_name,Sum(Days)total_leaves from leave_management GROUP BY ereg_no";
    pst=con.prepareStatement(sql);
    rs=pst.executeQuery();
    jTable6.setModel(DbUtils.resultSetToTableModel(rs));
    
     }
    catch(Exception e){
    
    
    JOptionPane.showMessageDialog(null, e);
    
    }
    
    }
    
      
    private void Total_Amount(){
    
     try{   
        
    String sql="select cemp_id,Sum(cAmount)total from cheatemp GROUP BY cemp_id";
    pst=con.prepareStatement(sql);
    rs=pst.executeQuery();
    jTable7.setModel(DbUtils.resultSetToTableModel(rs));
    
     }
    catch(Exception e){
    
    
    JOptionPane.showMessageDialog(null, e);
    
    }
    
    }      
        
            
       
       
    
    
 
    
  
         
        
     
          
     


     
    
     
     
     
     
    

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton14 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        eregno = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        ename = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        eaddress = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        enic = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        ephoneno = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        eemptype = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        estartdate = new com.toedter.calendar.JDateChooser();
        eno = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        empsa = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        eott = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton13 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        sreg = new javax.swing.JTextField();
        sname = new javax.swing.JTextField();
        sot = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        sdate = new com.toedter.calendar.JDateChooser();
        stime = new javax.swing.JComboBox();
        jLabel32 = new javax.swing.JLabel();
        sno = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        stype = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        search = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        mass = new javax.swing.JLabel();
        jButton17 = new javax.swing.JButton();
        ott = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        backBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        lreg = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        lname = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        ldes = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        ldate = new com.toedter.calendar.JDateChooser();
        jLabel31 = new javax.swing.JLabel();
        jButton21 = new javax.swing.JButton();
        lapp = new javax.swing.JComboBox();
        jLabel37 = new javax.swing.JLabel();
        ld = new javax.swing.JComboBox();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        regcom = new javax.swing.JComboBox();
        namcom = new javax.swing.JComboBox();
        sotr = new javax.swing.JTextField();
        sall = new javax.swing.JTextField();
        sepf = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        samou = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        snopa = new javax.swing.JTextField();
        jButton20 = new javax.swing.JButton();
        sbasic = new javax.swing.JComboBox();
        jLabel36 = new javax.swing.JLabel();
        sotrate = new javax.swing.JComboBox();
        printPay = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable7 = new javax.swing.JTable();
        sloss = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jButton23 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jButton24 = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Employee Management");
        setMinimumSize(new java.awt.Dimension(1280, 720));
        getContentPane().setLayout(null);

        jTabbedPane1.setPreferredSize(new java.awt.Dimension(1280, 720));
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jPanel1.setPreferredSize(new java.awt.Dimension(1280, 720));
        jPanel1.setLayout(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Reg No", "Name", "Address", "NIC", "Phone No", "Emp type", "basic salary", "OT_Rate", "joined date"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(30, 470, 1070, 140);

        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/back.png"))); // NOI18N
        jButton14.setText("Back");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton14);
        jButton14.setBounds(20, 610, 90, 30);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Add New Employee", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 255, 255))); // NOI18N
        jPanel6.setOpaque(false);
        jPanel6.setLayout(null);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Reg No   :-");
        jPanel6.add(jLabel1);
        jLabel1.setBounds(10, 50, 80, 14);
        jPanel6.add(eregno);
        eregno.setBounds(110, 50, 220, 30);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Name      :-");
        jPanel6.add(jLabel2);
        jLabel2.setBounds(10, 90, 90, 14);
        jPanel6.add(ename);
        ename.setBounds(110, 90, 220, 30);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Address  :-");
        jPanel6.add(jLabel3);
        jLabel3.setBounds(10, 140, 90, 14);
        jPanel6.add(eaddress);
        eaddress.setBounds(110, 130, 220, 50);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("NIC          :-");
        jPanel6.add(jLabel4);
        jLabel4.setBounds(10, 200, 90, 14);
        jPanel6.add(enic);
        enic.setBounds(110, 190, 220, 30);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Phone No :-");
        jPanel6.add(jLabel5);
        jLabel5.setBounds(10, 230, 90, 31);

        ephoneno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ephonenoActionPerformed(evt);
            }
        });
        jPanel6.add(ephoneno);
        ephoneno.setBounds(110, 230, 220, 30);

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Emp Type :-");
        jPanel6.add(jLabel6);
        jLabel6.setBounds(10, 280, 90, 14);

        eemptype.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Employee type", "Maintenance Engineer", "Stock Manager", "Data entry operator", "Employee" }));
        eemptype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eemptypeActionPerformed(evt);
            }
        });
        jPanel6.add(eemptype);
        eemptype.setBounds(110, 270, 220, 30);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add.png"))); // NOI18N
        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton1);
        jButton1.setBounds(70, 370, 110, 40);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/remove.png"))); // NOI18N
        jButton4.setText("Delete");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton4);
        jButton4.setBounds(190, 370, 110, 40);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/update.png"))); // NOI18N
        jButton5.setText("Update");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton5);
        jButton5.setBounds(310, 370, 110, 40);

        estartdate.setDateFormatString("yyyy-MM-dd");
        jPanel6.add(estartdate);
        estartdate.setBounds(110, 310, 220, 30);

        eno.setForeground(new java.awt.Color(255, 255, 255));
        eno.setText("NO");
        jPanel6.add(eno);
        eno.setBounds(120, 20, 60, 14);

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("NO          :-");
        jPanel6.add(jLabel10);
        jLabel10.setBounds(10, 20, 60, 14);

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Start data  :-");
        jPanel6.add(jLabel8);
        jLabel8.setBounds(10, 320, 80, 14);
        jPanel6.add(empsa);
        empsa.setBounds(450, 310, 220, 30);

        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Basic  Salary :-");
        jPanel6.add(jLabel33);
        jLabel33.setBounds(350, 320, 90, 14);

        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("OT Rate        :-");
        jPanel6.add(jLabel35);
        jLabel35.setBounds(350, 280, 90, 14);

        eott.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eottActionPerformed(evt);
            }
        });
        jPanel6.add(eott);
        eott.setBounds(450, 270, 220, 30);

        jPanel1.add(jPanel6);
        jPanel6.setBounds(70, 40, 680, 430);

        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/InterfaceBackground.jpg"))); // NOI18N
        jLabel18.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel18.setAutoscrolls(true);
        jPanel1.add(jLabel18);
        jLabel18.setBounds(10, 0, 1280, 720);

        jTabbedPane1.addTab("Registration", jPanel1);

        jPanel3.setPreferredSize(new java.awt.Dimension(1280, 720));
        jPanel3.setLayout(null);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Sno", "Reg No", "Name", "Date", "OT Rate", "Shift time"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable2);

        jPanel3.add(jScrollPane4);
        jScrollPane4.setBounds(100, 460, 910, 120);

        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/back.png"))); // NOI18N
        jButton13.setText("Back");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton13);
        jButton13.setBounds(100, 590, 90, 30);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Shift Managing Details", javax.swing.border.TitledBorder.LEADING, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 255, 255))); // NOI18N
        jPanel5.setOpaque(false);
        jPanel5.setLayout(null);

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Reg No                  :-");
        jPanel5.add(jLabel14);
        jLabel14.setBounds(10, 70, 110, 14);

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Name                    :-");
        jPanel5.add(jLabel15);
        jLabel15.setBounds(10, 110, 110, 14);

        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Date                     :-");
        jPanel5.add(jLabel16);
        jLabel16.setBounds(10, 150, 100, 14);

        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("OT Rate               :-");
        jPanel5.add(jLabel17);
        jLabel17.setBounds(10, 190, 100, 14);

        sreg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sregActionPerformed(evt);
            }
        });
        jPanel5.add(sreg);
        sreg.setBounds(120, 60, 220, 30);
        jPanel5.add(sname);
        sname.setBounds(120, 100, 220, 30);
        jPanel5.add(sot);
        sot.setBounds(120, 180, 220, 30);

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add.png"))); // NOI18N
        jButton9.setText("Add");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton9);
        jButton9.setBounds(70, 320, 100, 30);

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/remove.png"))); // NOI18N
        jButton10.setText("Delete");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton10);
        jButton10.setBounds(180, 320, 100, 30);

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/update.png"))); // NOI18N
        jButton11.setText("Update");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton11);
        jButton11.setBounds(290, 320, 110, 30);

        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Shift Time              :-");
        jPanel5.add(jLabel29);
        jLabel29.setBounds(10, 270, 110, 14);

        sdate.setDateFormatString("yyyy-MM-dd");
        jPanel5.add(sdate);
        sdate.setBounds(120, 140, 220, 30);

        stime.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Time", "8.00am to  3.00pm", "3.00pm to  10.00pm " }));
        jPanel5.add(stime);
        stime.setBounds(120, 260, 220, 30);

        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("No");
        jPanel5.add(jLabel32);
        jLabel32.setBounds(10, 30, 70, 14);

        sno.setForeground(new java.awt.Color(255, 255, 255));
        sno.setText("no");
        jPanel5.add(sno);
        sno.setBounds(120, 30, 50, 14);

        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("emp_work_type   :-");
        jPanel5.add(jLabel34);
        jLabel34.setBounds(10, 230, 110, 14);

        stype.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Employee Work Type", "Technician", "Interior Clean", "Car Wash", "Fuel Filling" }));
        jPanel5.add(stype);
        stype.setBounds(120, 220, 220, 30);

        jPanel3.add(jPanel5);
        jPanel5.setBounds(100, 60, 550, 370);

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Reg No");
        jPanel3.add(jLabel9);
        jLabel9.setBounds(680, 70, 60, 20);
        jPanel3.add(search);
        search.setBounds(730, 70, 110, 30);

        jButton6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(0, 102, 255));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search.png"))); // NOI18N
        jButton6.setText("Search");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton6);
        jButton6.setBounds(870, 70, 110, 30);

        jButton12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton12.setForeground(new java.awt.Color(51, 51, 255));
        jButton12.setText("Print");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton12);
        jButton12.setBounds(930, 300, 90, 30);

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable4MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jTable4);

        jPanel3.add(jScrollPane5);
        jScrollPane5.setBounds(700, 180, 340, 90);

        mass.setForeground(new java.awt.Color(255, 0, 51));
        jPanel3.add(mass);
        mass.setBounds(730, 380, 210, 30);

        jButton17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton17.setForeground(new java.awt.Color(51, 51, 255));
        jButton17.setText("Update OT Rate");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton17);
        jButton17.setBounds(700, 300, 200, 30);
        jPanel3.add(ott);
        ott.setBounds(930, 370, 90, 30);

        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/InterfaceBackground.jpg"))); // NOI18N
        jLabel20.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel20.setAutoscrolls(true);
        jPanel3.add(jLabel20);
        jLabel20.setBounds(0, 10, 1280, 720);

        jTabbedPane1.addTab("Shift Management", jPanel3);

        jPanel4.setPreferredSize(new java.awt.Dimension(1280, 720));
        jPanel4.setLayout(null);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Reg No", "Name", "Description", "Date", "Days", "Approval"
            }
        ));
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable3);

        jPanel4.add(jScrollPane3);
        jScrollPane3.setBounds(20, 420, 950, 160);

        backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/back.png"))); // NOI18N
        backBtn.setText("Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });
        jPanel4.add(backBtn);
        backBtn.setBounds(30, 600, 90, 30);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Leave Details of Employee", javax.swing.border.TitledBorder.LEADING, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 255, 255))); // NOI18N
        jPanel2.setOpaque(false);
        jPanel2.setLayout(null);

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Reg No                       :-");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(10, 50, 140, 14);

        lreg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lregActionPerformed(evt);
            }
        });
        jPanel2.add(lreg);
        lreg.setBounds(160, 40, 200, 30);

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Name                         :-");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(10, 90, 140, 14);
        jPanel2.add(lname);
        lname.setBounds(160, 80, 200, 30);

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Description                 :-");
        jPanel2.add(jLabel13);
        jLabel13.setBounds(10, 130, 150, 14);
        jPanel2.add(ldes);
        ldes.setBounds(160, 120, 200, 30);

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Consume Date           :-");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(10, 170, 120, 14);

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/remove.png"))); // NOI18N
        jButton8.setText("Delete");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton8);
        jButton8.setBounds(200, 290, 100, 30);

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add.png"))); // NOI18N
        jButton7.setText("Add");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton7);
        jButton7.setBounds(90, 290, 100, 30);

        ldate.setDateFormatString("yyyy-MM-dd");
        jPanel2.add(ldate);
        ldate.setBounds(160, 160, 200, 30);

        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Approval                    :-");
        jPanel2.add(jLabel31);
        jLabel31.setBounds(10, 250, 150, 14);

        jButton21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/update.png"))); // NOI18N
        jButton21.setText("Update");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton21);
        jButton21.setBounds(310, 290, 110, 30);

        lapp.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "None", "OK", "NO" }));
        jPanel2.add(lapp);
        lapp.setBounds(160, 240, 200, 30);

        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("Days                          :-");
        jPanel2.add(jLabel37);
        jLabel37.setBounds(10, 210, 150, 14);

        ld.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Days", "0.5   ", "1      ", "2      ", "3      ", "4      ", "5      ", "6      ", "7     ", "8    ", "9    ", "10    " }));
        jPanel2.add(ld);
        ld.setBounds(160, 200, 200, 30);

        jPanel4.add(jPanel2);
        jPanel2.setBounds(30, 60, 470, 340);

        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "regno", "emp_name", "total"
            }
        ));
        jScrollPane6.setViewportView(jTable6);

        jPanel4.add(jScrollPane6);
        jScrollPane6.setBounds(620, 90, 430, 130);

        jButton18.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton18.setForeground(new java.awt.Color(0, 51, 255));
        jButton18.setText("Update Total Leaves");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton18);
        jButton18.setBounds(640, 250, 220, 30);

        jButton19.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton19.setForeground(new java.awt.Color(0, 51, 204));
        jButton19.setText("Print");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton19);
        jButton19.setBounds(900, 250, 90, 30);

        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/InterfaceBackground.jpg"))); // NOI18N
        jLabel21.setText("Date");
        jLabel21.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel21.setAutoscrolls(true);
        jLabel21.setPreferredSize(new java.awt.Dimension(1280, 720));
        jPanel4.add(jLabel21);
        jLabel21.setBounds(0, 0, 1280, 720);

        jTabbedPane1.addTab("Leave Management", jPanel4);

        jPanel7.setLayout(null);

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Reg no", "Name", "Basic salary", "Ot time", "Allowance", "EPF", "No Pay", "Date", "Amount"
            }
        ));
        jTable5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable5MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable5);

        jPanel7.add(jScrollPane2);
        jScrollPane2.setBounds(40, 500, 990, 120);

        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Reg No             :-");
        jPanel7.add(jLabel19);
        jLabel19.setBounds(30, 50, 120, 14);

        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Name                          :-");
        jPanel7.add(jLabel22);
        jLabel22.setBounds(400, 50, 130, 14);

        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Basic Salary      :-");
        jPanel7.add(jLabel23);
        jLabel23.setBounds(30, 110, 120, 14);

        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("OT Time            :-");
        jPanel7.add(jLabel24);
        jLabel24.setBounds(30, 230, 110, 14);

        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Allowance               :-");
        jPanel7.add(jLabel25);
        jLabel25.setBounds(20, 170, 110, 14);

        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("EPF                            :-");
        jPanel7.add(jLabel26);
        jLabel26.setBounds(400, 170, 130, 14);

        regcom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regcomActionPerformed(evt);
            }
        });
        jPanel7.add(regcom);
        regcom.setBounds(170, 40, 170, 40);

        jPanel7.add(namcom);
        namcom.setBounds(540, 40, 170, 40);
        jPanel7.add(sotr);
        sotr.setBounds(170, 220, 190, 30);
        jPanel7.add(sall);
        sall.setBounds(170, 160, 190, 30);
        jPanel7.add(sepf);
        sepf.setBounds(540, 160, 190, 30);

        jButton2.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 204));
        jButton2.setText("amount");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton2);
        jButton2.setBounds(170, 320, 120, 40);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add.png"))); // NOI18N
        jButton3.setText("add");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton3);
        jButton3.setBounds(250, 440, 110, 30);

        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/remove.png"))); // NOI18N
        jButton15.setText("delete");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton15);
        jButton15.setBounds(390, 440, 100, 30);

        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/update.png"))); // NOI18N
        jButton16.setText("update");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton16);
        jButton16.setBounds(520, 440, 100, 30);

        samou.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        samou.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                samouActionPerformed(evt);
            }
        });
        jPanel7.add(samou);
        samou.setBounds(460, 320, 220, 40);

        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("No Pay days              :-");
        jPanel7.add(jLabel30);
        jLabel30.setBounds(400, 220, 120, 14);
        jPanel7.add(snopa);
        snopa.setBounds(540, 210, 190, 30);

        jButton20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/clear.png"))); // NOI18N
        jButton20.setText("Clear");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton20);
        jButton20.setBounds(640, 440, 100, 30);

        jPanel7.add(sbasic);
        sbasic.setBounds(170, 100, 170, 40);

        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("OT_Rate                    :-");
        jPanel7.add(jLabel36);
        jLabel36.setBounds(400, 110, 130, 14);

        jPanel7.add(sotrate);
        sotrate.setBounds(540, 100, 170, 40);

        printPay.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        printPay.setForeground(new java.awt.Color(0, 0, 204));
        printPay.setText("Print Pay Sheet");
        printPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printPayActionPerformed(evt);
            }
        });
        jPanel7.add(printPay);
        printPay.setBounds(770, 440, 140, 30);

        jButton22.setForeground(new java.awt.Color(0, 153, 0));
        jButton22.setText("More");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton22);
        jButton22.setBounds(940, 440, 80, 30);

        jTable7.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Reg no", "Amount"
            }
        ));
        jScrollPane7.setViewportView(jTable7);

        jPanel7.add(jScrollPane7);
        jScrollPane7.setBounds(770, 40, 330, 100);
        jPanel7.add(sloss);
        sloss.setBounds(540, 260, 190, 30);

        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Loss income               :-");
        jPanel7.add(jLabel27);
        jLabel27.setBounds(400, 270, 130, 14);

        jButton23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton23.setForeground(new java.awt.Color(0, 0, 255));
        jButton23.setText("Refresh");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton23);
        jButton23.setBounds(850, 170, 130, 30);

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Salary Calculate", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(51, 255, 255))); // NOI18N
        jPanel8.setOpaque(false);
        jPanel7.add(jPanel8);
        jPanel8.setBounds(10, 20, 750, 470);

        jButton24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/back.png"))); // NOI18N
        jButton24.setText("Back");
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton24);
        jButton24.setBounds(20, 620, 90, 30);

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/InterfaceBackground.jpg"))); // NOI18N
        jPanel7.add(jLabel28);
        jLabel28.setBounds(0, 0, 1280, 720);

        jTabbedPane1.addTab("Salary", jPanel7);

        getContentPane().add(jTabbedPane1);
        jTabbedPane1.setBounds(0, 10, 1280, 720);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        main_gui M2=new main_gui();
        M2.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backBtnActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        main_gui M2=new main_gui();
        M2.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        
          int x =   JOptionPane.showConfirmDialog(null, "Do you want to Update");

        if(x==0)
        {
            String srno= sno.getText();
            String regno= sreg.getText();
            String name= sname.getText();
            Float saot= Float.parseFloat(sot.getText());
            String typ=stime.getSelectedItem().toString();
            String empwor=stype.getSelectedItem().toString();
            String datee=((JTextField)sdate.getDateEditor().getUiComponent()).getText();

            String sql="UPDATE shift_management SET reg_no='"+regno+"',emp_name='"+name+"',ot_rate='"+saot+"',date='"+datee+"',emp_work_type='"+empwor+"',Time='"+typ+"' where Sno='"+srno+"'";

            try{

                pst=con.prepareStatement(sql);
                pst.execute();
               
                 
       
                        
               Update_table2();  
            }catch(Exception e){}

        }
        
        
        
        
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        main_gui M=new main_gui();
        M.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        
    int x =   JOptionPane.showConfirmDialog(null, "Do you want to Update");

        if(x==0)
        {
            String no= eno.getText();
            String regno= eregno.getText();
            String name= ename.getText();
            String address= eaddress.getText();
            String nic= enic.getText();
            String phone= ephoneno.getText();
            String type=eemptype.getSelectedItem().toString();
            String empsala=empsa.getText();
            String eot=eott.getText();
            String edate=((JTextField)estartdate.getDateEditor().getUiComponent()).getText();

            String sql="UPDATE employee_table SET regno='"+regno+"',emp_name='"+name+"',address='"+address+"',nic='"+nic+"',ephone='"+phone+"',emptype='"+type+"',basic_salary='"+empsala+"',OT='"+eot+"',joined_date='"+edate+"' where NO='"+no+"'";

            try{

                pst=con.prepareStatement(sql);
                pst.execute();
                Update_table();

            }catch(Exception e){}

        }

    }//GEN-LAST:event_jButton5ActionPerformed

    private void ephonenoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ephonenoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ephonenoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        errchcker(); 
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void eemptypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eemptypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eemptypeActionPerformed

    private void lregActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lregActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lregActionPerformed

    private void sregActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sregActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sregActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
       errchcker1();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        errchcker2();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
      
        String sql="delete from employee_table where regno =?";
        
        try{
           
            pst= con.prepareStatement(sql);
            pst.setString(1,eregno.getText());
            pst.execute();
        JOptionPane.showMessageDialog(null, "Deleted");
        
        }catch(Exception e){
        
        JOptionPane.showMessageDialog(null, e);
        
        }
        
        Update_table();
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
try{
            
            int row = jTable1.getSelectedRow();
            String Table_click = ( jTable1.getModel().getValueAt(row, 0).toString());
            
            String sql ="select* from employee_table where NO='"+Table_click+"' ";
            pst= con.prepareStatement(sql);
            rs=pst.executeQuery();
               
               if(rs.next()){
                   
                   String add1=rs.getString("NO");
                  eno.setText(add1);
                  
                  String add2=rs.getString("regno");
                  eregno.setText(add2);
               
                  String add3=rs.getString("emp_name");
                  ename.setText(add3);
                   
                  String add4=rs.getString("address");
                  eaddress.setText(add4);
                   
                  String add5=rs.getString("nic");
                  enic.setText(add5);
                  String add6=rs.getString("ephone");
                  ephoneno.setText(add6);
                  String add7=rs.getString("emptype");
                  eemptype.setSelectedItem(add7);
                  String add8=rs.getString("basic_salary");
                  empsa.setText(add8);
                   String add9=rs.getString("OT");
                 eott.setText(add9);
                Date add10=rs.getDate("joined_date");
                estartdate.setDate(add10);
               
               }
               
               
        }catch(Exception e){
        
         JOptionPane.showMessageDialog(null, e);
        
        }
        
        
        Update_table();
        
        
        
      
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

        String reg= search.getText();
        String sql="Select reg_no,emp_name,date,ot_rate from shift_management where reg_no LIKE '%"+reg+"%'";
        try{
         pst= con.prepareStatement(sql);
         rs=pst.executeQuery();
         jTable2.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            
         JOptionPane.showMessageDialog(null, e);
        }
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        
    try{
            
            int row = jTable2.getSelectedRow();
            String Table_click1 = ( jTable2.getModel().getValueAt(row, 0).toString());
            
            String sql ="select* from shift_management where Sno='"+Table_click1+"' ";
              pst= con.prepareStatement(sql);
               rs=pst.executeQuery();
               
               if(rs.next()){
                  String add1=rs.getString("Sno");
                sno.setText(add1);
                   
                 String add2=rs.getString("reg_no");
                  sreg.setText(add2);
               
                 String add3=rs.getString("emp_name");
                 sname.setText(add3);
                   
                  Date add4=rs.getDate("date");
                  sdate.setDate(add4);
                   
                  String add5=rs.getString("ot_rate");
                  sot.setText(add5);
                  String add6=rs.getString("emp_work_type");
                  stype.setSelectedItem(add6);
                 String add7=rs.getString("Time");
                  stime.setSelectedItem(add7);
                  
               }
               
               
        }catch(Exception e){
        
         JOptionPane.showMessageDialog(null, e);
        
        } 
        
        

        
       
        
    }//GEN-LAST:event_jTable2MouseClicked

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
       int x= JOptionPane.showConfirmDialog( null, "Do you want Delete");
       if(x==0) 
      {
          //String typ=stime.getSelectedItem().toString();
          // String da=((JTextField)sdate.getDateEditor().getUiComponent()).getText();
           String no= sno.getText();
           
          String sql= "DELETE from shift_management where Sno='"+no+"'";
           try{
           
           pst= con.prepareStatement(sql);
           pst.execute();
           Update_table2();
           
           }catch(Exception e){}
           
        
       }
        
       
        
        
        
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       salcal();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try{
            DateFormat dateformat=new SimpleDateFormat("yyyy-MM-dd");
        Date cdate=new Date();
        String date=dateformat.format(cdate);
        
        String sql= "Insert into salary(reg_No,emp_name,basic_salary,OT,ot_rate,allowance,EPF,no_pay_day,loss_income,date,amount) values (?,?,?,?,?,?,?,?,?,?,?)";
        
         pst= con.prepareStatement(sql);
         pst.setString (1,regcom.getSelectedItem().toString());
         pst.setString (2,namcom.getSelectedItem().toString());
         pst.setString (3, sbasic.getSelectedItem().toString());
         pst.setString (4, sotrate.getSelectedItem().toString());
         pst.setString (5, sotr.getText());
         pst.setString (6, sall.getText());
         pst.setString (7, sepf.getText());
         pst.setString (8, snopa.getText());
         pst.setString (9, sloss.getText());
         pst.setString (10, date);
         pst.setString (11, samou.getText());
         pst.execute();
          JOptionPane.showMessageDialog(null, "Saved");
         
        }catch(Exception e){
        
        JOptionPane.showMessageDialog(null, e);
       }
        Update_table4();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        
         int x =   JOptionPane.showConfirmDialog(null, "Do you want to Update");

        if(x==0)
        {
            String typee=regcom.getSelectedItem().toString();
            String type=namcom.getSelectedItem().toString();
            String bsal= sbasic.getSelectedItem().toString();
            String saotr= sotrate.getSelectedItem().toString();
            String saot= sotr.getText();
            String sallo= sall.getText();
            String saepf=sepf.getText();
            String samount= samou.getText();
            String snop=snopa.getText();
            String loss=sloss.getText();
            

  String sql="UPDATE salary SET reg_No='"+typee+"',emp_name='"+type+"',basic_salary='"+bsal+"',ot_rate='"+saot+"',OT='"+saotr+"',EPF='"+saepf+"',amount='"+samount+"', no_pay_day='"+snop+"',loss_income='"+loss+"' where reg_No='"+typee+"'";

            try{

                pst=con.prepareStatement(sql);
                pst.execute();
                Update_table4();

            }catch(Exception e){
            
            JOptionPane.showMessageDialog(null, e);
            
            }

        }
        
        
        
        
        
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jTable5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable5MouseClicked
        
        
         try{
            
            int row = jTable5.getSelectedRow();
            String Table_click1 = ( jTable5.getModel().getValueAt(row, 0).toString());
            
            String sql ="select* from salary where reg_No='"+Table_click1+"' ";
              pst= con.prepareStatement(sql);
               rs=pst.executeQuery();
               
               if(rs.next()){
                   
               String add1=rs.getString("reg_No");
                 regcom.setSelectedItem(add1);
               
                String add2=rs.getString("emp_name");
                  namcom.setSelectedItem(add2);
                   String add3=rs.getString("basic_salary");
                  namcom.setSelectedItem(add3); 
                  String add4=rs.getString("OT");
                  namcom.setSelectedItem(add4);
                 
                   
                  String add5=rs.getString("ot_rate");
                 sotr.setText(add5);
                  String add6=rs.getString("allowance");
                  sall.setText(add6);
                  String add7=rs.getString("EPF");
                  sepf.setText(add7);
                  String add8=rs.getString("no_pay_day");
                  snopa.setText(add8);
                  String add9=rs.getString("loss_income");
                  sloss.setText(add9);
                 
                  String add10=rs.getString("amount");
                 samou.setText(add10);
               }
               
               
        }catch(Exception e){
        
         JOptionPane.showMessageDialog(null, e);
        
        } 
        
        

        
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_jTable5MouseClicked

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        
         String sql="delete from salary where reg_No =?";
        
        try{
           
            pst= con.prepareStatement(sql);
            pst.setString(1,regcom.getSelectedItem().toString());
            pst.execute();
        JOptionPane.showMessageDialog(null, "Deleted");
        
        }catch(Exception e){
        
        JOptionPane.showMessageDialog(null, e);
        
        }
        
        Update_table4();
        
        
        
        
        
        
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
     
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        
        Total_table();
       //Float saott= Float.parseFloat(sot.getText());
           //if(saott==25){
           // mass.setText("red");
           //}
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
  
        MessageFormat header=new MessageFormat("Overtime Report"); 
        
         MessageFormat footer=new MessageFormat("Page{0,number,integer}"); 
        
        try{
        
        jTable4.print(JTable.PrintMode.NORMAL, header, footer);
        }catch(java.awt.print.PrinterException e){
            System.err.format("Cannot prinnt %s%n",e.getMessage());
        
        
        }
        
        
        
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
       
        
      int x= JOptionPane.showConfirmDialog( null, "Do you want Delete");
       if(x==0) 
       {
           String de=ldes.getText();
           String sql= "DELETE from leave_management where edes='"+de+"'";
           try{
           
           pst= con.prepareStatement(sql);
           pst.execute();
           Update_table3();
           
           }catch(Exception e){}
           
        
       }
        
        
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
         try{
            
            int row = jTable3.getSelectedRow();
            String Table_click1 = ( jTable3.getModel().getValueAt(row, 0).toString());
            
            String sql ="select* from leave_management where ereg_no='"+Table_click1+"' ";
              pst= con.prepareStatement(sql);
               rs=pst.executeQuery();
               
               if(rs.next()){
                   
                 String add1=rs.getString("ereg_no");
                  lreg.setText(add1);
               
                 String add2=rs.getString("emp_name");
                 lname.setText(add2);
                   String add3=rs.getString("edes");
                  ldes.setText(add3);
                 
                  Date add4=rs.getDate("edate");
                  ldate.setDate(add4);
                  String add5=rs.getString("Days");
                  ld.setSelectedItem(add5);
                  String add6=rs.getString("Approval");
                  lapp.setSelectedItem(add6);
               }
               
               
        }catch(Exception e){
        
         JOptionPane.showMessageDialog(null, e);
        
        }   
    }//GEN-LAST:event_jTable3MouseClicked

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        leave_total();
    }//GEN-LAST:event_jButton18ActionPerformed

    private void samouActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_samouActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_samouActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
     
     sotr.setText("");
     sall.setText("");
     sepf.setText("");
     snopa.setText("");
     samou.setText("");
      sloss.setText("");
    
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
         int x =   JOptionPane.showConfirmDialog(null, "Do you want to Update");

        if(x==0)
        {
           
            String lre= lreg.getText();
            String lnam= lname.getText();
            String ldesc=ldes.getText();
            String esdate=((JTextField)ldate.getDateEditor().getUiComponent()).getText();
            String lda= ld.getSelectedItem().toString();
            String lap= lapp.getSelectedItem().toString();
            

  String sql="UPDATE leave_management SET ereg_no='"+lre+"',emp_name='"+lnam+"',edes='"+ldesc+"',edate='"+esdate+"',Days='"+lda+"',Approval='"+lap+"' where ereg_no='"+lre+"'";

            try{

                pst=con.prepareStatement(sql);
                pst.execute();
                Update_table3();

            }catch(Exception e){
            
            JOptionPane.showMessageDialog(null, e);
            
            }

        }
    
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        
        MessageFormat header=new MessageFormat("Leave Report"); 
        
         MessageFormat footer=new MessageFormat("Page{0,number,integer}"); 
        
        try{
        
        jTable6.print(JTable.PrintMode.NORMAL, header, footer);
        }catch(java.awt.print.PrinterException e){
            System.err.format("Cannot prinnt %s%n",e.getMessage());
        
        
        }
        
        
        
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jTable4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable4MouseClicked
       try{
        int row = jTable4.getSelectedRow();
            String Table_click1 = ( jTable4.getModel().getValueAt(row, 0).toString());
            
            String sql ="select Sum(ot_rate)ot_rate  from shift_management where reg_no='"+Table_click1+"' ";
              pst= con.prepareStatement(sql);
               rs=pst.executeQuery();
               if(rs.next()){
                   
                 String add1=rs.getString("");
                  ott.setText(add1);
               
                 
               }
       
       
       
       }catch(Exception e){
       
        JOptionPane.showMessageDialog(null, e);
       }
        
        
        
    }//GEN-LAST:event_jTable4MouseClicked

    private void eottActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eottActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eottActionPerformed

    private void printPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printPayActionPerformed
        employpaysheet eps=new employpaysheet();
        eps.setVisible(true);
        
        DateFormat dateformat=new SimpleDateFormat("yyyy-MM-dd");
        Date cdate=new Date();
        String date=dateformat.format(cdate);
        
        String regNo=regcom.getSelectedItem().toString();
        String name=namcom.getSelectedItem().toString();
        String basicSal=sbasic.getSelectedItem().toString();
        String otRate=sotrate.getSelectedItem().toString();
        String bonus=sall.getText();
        String epf=sepf.getText();
        String ot=sotr.getText();
        String noPay=snopa.getText();
        String loss=sloss.getText();
        String amount=samou.getText();
        
        
        eps.paySheet.append("                             AUTO MIRAJ\n");
        eps.paySheet.append("                            Mount Lavinia\n");
        eps.paySheet.append("                        Tel 0112834527 0112834528\n");
        eps.paySheet.append("------------------------------------------------------------------------\n");
        eps.paySheet.append("                            Employee Pay Sheet\n");
        eps.paySheet.append("------------------------------------------------------------------------\n");
        eps.paySheet.append("\n");
        eps.paySheet.append("Date               -:  "+date+"\n");
        eps.paySheet.append("\n");
        eps.paySheet.append("RegNo              -:  "+regNo+"\n");
        eps.paySheet.append("\n");
        eps.paySheet.append("Name               -:  "+name+"\n");
        eps.paySheet.append("\n");
        eps.paySheet.append("Basic Salary       -:  "+basicSal+"\n");
        eps.paySheet.append("\n");
        eps.paySheet.append("OT Rate            -:  "+otRate+"\n");
        eps.paySheet.append("\n");
        eps.paySheet.append("Bonus              -:  "+bonus+"\n");
        eps.paySheet.append("\n");
        eps.paySheet.append("EPF                -:  "+ epf+"\n");
        eps.paySheet.append("\n");
        eps.paySheet.append("OT Hours           -:  "+ot+"\n");
        eps.paySheet.append("\n");
        eps.paySheet.append("NO Pay Days        -:  "+noPay+"\n");
        eps.paySheet.append("\n");
        eps.paySheet.append("Loss Income        -:  "+loss+"\n");
        eps.paySheet.append("\n");
        eps.paySheet.append("------------------------------------------------------------------------\n");
        eps.paySheet.append("Sub Total          -:  "+amount+"\n");
        eps.paySheet.append("------------------------------------------------------------------------\n");
        
        
        
        
        
        
    }//GEN-LAST:event_printPayActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
       employcheat ec=new employcheat();
       ec.setVisible(true);
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        Total_Amount();
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        main_gui M=new main_gui();
        M.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton24ActionPerformed

    private void regcomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regcomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_regcomActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(emply.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(emply.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(emply.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(emply.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*/
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new emply().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField eaddress;
    private javax.swing.JComboBox eemptype;
    private javax.swing.JTextField empsa;
    private javax.swing.JTextField ename;
    private javax.swing.JTextField enic;
    private javax.swing.JLabel eno;
    private javax.swing.JTextField eott;
    private javax.swing.JTextField ephoneno;
    private javax.swing.JTextField eregno;
    private com.toedter.calendar.JDateChooser estartdate;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    private javax.swing.JTable jTable7;
    private javax.swing.JComboBox lapp;
    private javax.swing.JComboBox ld;
    private com.toedter.calendar.JDateChooser ldate;
    private javax.swing.JTextField ldes;
    private javax.swing.JTextField lname;
    private javax.swing.JTextField lreg;
    private javax.swing.JLabel mass;
    private javax.swing.JComboBox namcom;
    private javax.swing.JLabel ott;
    private javax.swing.JButton printPay;
    public static javax.swing.JComboBox regcom;
    private javax.swing.JTextField sall;
    private javax.swing.JTextField samou;
    private javax.swing.JComboBox sbasic;
    private com.toedter.calendar.JDateChooser sdate;
    private javax.swing.JTextField search;
    private javax.swing.JTextField sepf;
    private javax.swing.JTextField sloss;
    private javax.swing.JTextField sname;
    private javax.swing.JLabel sno;
    private javax.swing.JTextField snopa;
    private javax.swing.JTextField sot;
    private javax.swing.JTextField sotr;
    private javax.swing.JComboBox sotrate;
    private javax.swing.JTextField sreg;
    private javax.swing.JComboBox stime;
    private javax.swing.JComboBox stype;
    // End of variables declaration//GEN-END:variables

  // private void initComponents() {
    //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
 //  }

//private void initComponents() {
 //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
// }
//private String appro;
  
}
