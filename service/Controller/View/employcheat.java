/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AutoMiraj.View;

import AutoMiraj.DBconnect.DBconnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.sql.*;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
/**
 *
 * @author user
 */
public class employcheat extends javax.swing.JFrame {

    Connection con =null;
    ResultSet rs= null;
    PreparedStatement pst = null;
    
    
    
    
    
    
    public employcheat() {
        
        con=DBconnect.connect();
       
        initComponents();
        
        //table load
        Update_table11();
        Update_table22();
    }

    
    
    private void Update_table22(){
    
        try{   
        
            String sql="select cemp_id, cAmount from cheatemp";
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
    
            jTable22.setModel(DbUtils.resultSetToTableModel(rs));
    
        }
        catch(Exception e){
    
            JOptionPane.showMessageDialog(null, "tharaka");
    
        }
    
    }    
         
    
    private void Update_table11(){
    
        try{   
        
            String sql="select employeesRegNumbers,lostAmount from lost_fuel_income_profit";
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            
            jTable11.setModel(DbUtils.resultSetToTableModel(rs));
    
        }
        catch(Exception e){
   
            JOptionPane.showMessageDialog(null, "sachin");
    
        }
    
    }    
         
     public void chcal(){
 
  Double e = Double.parseDouble(fuch.getText());
  Double f = Double.parseDouble(chd.getText());
  
  
  Double am= e/f;
 
 eca.setText(am+ " ");
 
 }
          
          
          
          
          
          
          
          
          
          
          
          
          
          
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable11 = new javax.swing.JTable();
        eca = new javax.swing.JTextField();
        fuch = new javax.swing.JLabel();
        chd = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        chemp = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cham = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable22 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        ecc = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        getContentPane().setLayout(null);

        jTable11.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Emp_IDs", "Amount"
            }
        ));
        jTable11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable11MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable11);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(50, 60, 520, 89);
        getContentPane().add(eca);
        eca.setBounds(210, 210, 160, 30);

        fuch.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        fuch.setForeground(new java.awt.Color(204, 0, 0));
        getContentPane().add(fuch);
        fuch.setBounds(70, 160, 120, 30);
        getContentPane().add(chd);
        chd.setBounds(210, 160, 160, 30);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Emp_Id          :-");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 300, 90, 14);
        getContentPane().add(chemp);
        chemp.setBounds(120, 290, 120, 30);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Lost Amount  :-");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 350, 90, 14);
        getContentPane().add(cham);
        cham.setBounds(120, 340, 120, 30);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add.png"))); // NOI18N
        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(300, 290, 100, 30);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/remove.png"))); // NOI18N
        jButton2.setText("Delete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(300, 340, 100, 30);

        jTable22.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "EmployeeId", "Amount"
            }
        ));
        jTable22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable22MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable22);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(52, 409, 452, 100);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText(" Lost  Income");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(210, 14, 294, 15);

        ecc.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ecc.setForeground(new java.awt.Color(51, 51, 255));
        ecc.setText("Calculate");
        ecc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eccActionPerformed(evt);
            }
        });
        getContentPane().add(ecc);
        ecc.setBounds(70, 210, 100, 30);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fual employee loss", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(51, 255, 255))); // NOI18N
        jPanel2.setOpaque(false);
        getContentPane().add(jPanel2);
        jPanel2.setBounds(10, 40, 680, 210);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "All loss income", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(102, 255, 255))); // NOI18N
        jPanel3.setOpaque(false);
        getContentPane().add(jPanel3);
        jPanel3.setBounds(10, 270, 680, 250);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/InterfaceBackground.jpg"))); // NOI18N
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(-6, 0, 790, 560);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
 try{
        
        String sql= "Insert into cheatemp(cemp_id,cAmount) values (?,?)";
        
         pst= con.prepareStatement(sql);
         
         pst.setString (1, chemp.getText());
         pst.setString (2, cham.getText());
         
         pst.execute();
          JOptionPane.showMessageDialog(null, "Saved");
         
        }catch(Exception e){
        
        JOptionPane.showMessageDialog(null, e);
       }
        Update_table22();       
        
        
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       
         int x= JOptionPane.showConfirmDialog( null, "Do you want Delete");
       if(x==0) 
      {
          
           String cno= cham.getText();
           
          String sql= "DELETE from cheatemp where cAmount='"+cno+"'";
           try{
           
           pst= con.prepareStatement(sql);
           pst.execute();
          
           
           }catch(Exception e){}
            Update_table22();
        
       }
        
        
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable22MouseClicked
     
        try{
            
            int row = jTable22.getSelectedRow();
            String Table_click = ( jTable22.getModel().getValueAt(row, 0).toString());
            
            String sql ="select* from cheatemp where cemp_id='"+Table_click+"' ";
              pst= con.prepareStatement(sql);
               rs=pst.executeQuery();
               
               if(rs.next()){
                   
                  String add1=rs.getString("cemp_id");
                  chemp.setText(add1);
                  
                  String add2=rs.getString("cAmount");
                  cham.setText(add2);
               
                  
               }
               
               
        }catch(Exception e){
        
         JOptionPane.showMessageDialog(null, "all emp");
        
        }
        
        
        Update_table22();
        
        
        
        
        
        
        
    }//GEN-LAST:event_jTable22MouseClicked

    private void jTable11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable11MouseClicked
          try{
            
            int row = jTable11.getSelectedRow();
            String Table_click = ( jTable11.getModel().getValueAt(row, 0).toString());
            
            String sql ="select	employeesRegNumbers,lostAmount from lost_fuel_income_profit where employeesRegNumbers ='"+Table_click+"' ";
            pst= con.prepareStatement(sql);
            rs=pst.executeQuery();
               
               if(rs.next()){
                   
            String add1=rs.getString("lostAmount");
            fuch.setText(add1);
                  
                  
               }
               
               
        }catch(Exception e){
        
         JOptionPane.showMessageDialog(null, "ashen");
        
        }
        
        
        Update_table11();
      
        
    }//GEN-LAST:event_jTable11MouseClicked

    private void eccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eccActionPerformed
         chcal();
    }//GEN-LAST:event_eccActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(employcheat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(employcheat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(employcheat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(employcheat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new employcheat().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cham;
    private javax.swing.JTextField chd;
    private javax.swing.JTextField chemp;
    private javax.swing.JTextField eca;
    private javax.swing.JButton ecc;
    private javax.swing.JLabel fuch;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable11;
    private javax.swing.JTable jTable22;
    // End of variables declaration//GEN-END:variables
}
