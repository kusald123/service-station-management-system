/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AutoMiraj.View;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import AutoMiraj.DBconnect.DBconnect;
import AutoMiraj.Model.Fuel;
import AutoMiraj.Controller.FuelController;

/**
 *
 * @author User
 */
public class FuelInsert extends javax.swing.JFrame {

    
    Connection conn=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    
    
    public FuelInsert() {
        initComponents();
        
        //Connect to DB
        conn=DBconnect.connect();
        
        tableLoad();
    }

    
    public void tableLoad(){
        try{
            String sql="SELECT fuelId, fuelName, fuelPrice, fuelSellingPrice, tankCapacity FROM insertfuel";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            fuelTable.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void formValidation(){
        
        if(fuelNametxt.getText().length()==0){
            JOptionPane.showMessageDialog(this, "Please add fuel name");
            fuelNametxt.requestFocus();
            
        }
        
        else if(fuelPricetxt.getText().length()==0){
            JOptionPane.showMessageDialog(this, "Please add fuel price");
            fuelPricetxt.requestFocus();
            
        }
        
        else if(fuelPricetxt.getText()=="^[0-9]"){
            JOptionPane.showMessageDialog(this, "Please check fuel price");
            fuelPricetxt.requestFocus();
            
        }
        
        else if(tankCapacitytxt.getText().length()==0){
            JOptionPane.showMessageDialog(this, "Please add tank capacity");
            tankCapacitytxt.requestFocus();
            
        }
        
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        addBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        fuelNametxt = new javax.swing.JTextField();
        fuelPricetxt = new javax.swing.JTextField();
        tankCapacitytxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        fuelTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        idtxt = new javax.swing.JLabel();
        deleteFuelbox = new javax.swing.JButton();
        fuelSellingPricetxt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        fuelInsertBackground = new javax.swing.JLabel();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Insert New Fuel Type"));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Reservoir - Insert new fuel type");
        setMinimumSize(new java.awt.Dimension(401, 350));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Purchase Price");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 140, 100, 30);

        addBtn.setText("Add");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });
        getContentPane().add(addBtn);
        addBtn.setBounds(20, 350, 110, 50);

        cancelBtn.setText("Cancel");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });
        getContentPane().add(cancelBtn);
        cancelBtn.setBounds(570, 350, 110, 50);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Tank Capacity");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 240, 80, 30);

        fuelNametxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fuelNametxtActionPerformed(evt);
            }
        });
        getContentPane().add(fuelNametxt);
        fuelNametxt.setBounds(90, 90, 120, 30);
        getContentPane().add(fuelPricetxt);
        fuelPricetxt.setBounds(90, 140, 120, 30);
        getContentPane().add(tankCapacitytxt);
        tankCapacitytxt.setBounds(90, 240, 120, 30);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Fuel Name");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 90, 90, 30);

        fuelTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Fuel Id", "Fuel Name", "Fuel Price", "Selling Price", "Tank Capacity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        fuelTable.setRowHeight(30);
        fuelTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fuelTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(fuelTable);
        if (fuelTable.getColumnModel().getColumnCount() > 0) {
            fuelTable.getColumnModel().getColumn(0).setResizable(false);
            fuelTable.getColumnModel().getColumn(1).setResizable(false);
            fuelTable.getColumnModel().getColumn(2).setResizable(false);
            fuelTable.getColumnModel().getColumn(3).setResizable(false);
            fuelTable.getColumnModel().getColumn(4).setResizable(false);
        }

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(230, 90, 450, 220);

        jButton1.setText("Clear");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(440, 350, 110, 50);

        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(160, 350, 110, 50);

        idtxt.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        idtxt.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(idtxt);
        idtxt.setBounds(10, 40, 60, 30);

        deleteFuelbox.setText("Delete");
        deleteFuelbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteFuelboxActionPerformed(evt);
            }
        });
        getContentPane().add(deleteFuelbox);
        deleteFuelbox.setBounds(300, 350, 110, 50);
        getContentPane().add(fuelSellingPricetxt);
        fuelSellingPricetxt.setBounds(90, 190, 120, 30);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Selling Price");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 190, 80, 30);

        fuelInsertBackground.setForeground(new java.awt.Color(255, 255, 255));
        fuelInsertBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/InterfaceBackground.jpg"))); // NOI18N
        fuelInsertBackground.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(fuelInsertBackground);
        fuelInsertBackground.setBounds(0, 0, 950, 590);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        formValidation();
        
        
        try{
            String fuelId=null;
            String fuelName=fuelNametxt.getText();
            String fuelPrice=fuelPricetxt.getText();
            String fuelSellingPrice=fuelSellingPricetxt.getText();
            String tankCapacity=tankCapacitytxt.getText();
            
            
            Fuel fuel=new Fuel(fuelId, fuelName, fuelPrice, fuelSellingPrice, tankCapacity);
            int res= FuelController.insertFuel(fuel);
            
            if(res>0){
                JOptionPane.showMessageDialog(this,"Added success");
            }
            
            else{
                JOptionPane.showMessageDialog(this, "Fail");
            }
            
        }
        catch(Exception e){
            //JOptionPane.showMessageDialog(null, e);
        }
        
        tableLoad();
       
    }//GEN-LAST:event_addBtnActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void fuelNametxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fuelNametxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fuelNametxtActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        fuelNametxt.setText("");
        fuelPricetxt.setText("");
        fuelSellingPricetxt.setText("");
        tankCapacitytxt.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void fuelTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fuelTableMouseClicked
        int r=fuelTable.getSelectedRow();
        
        String fuelId=fuelTable.getValueAt(r, 0).toString();
        String fuelName=fuelTable.getValueAt(r, 1).toString();
        String fuelPrice=fuelTable.getValueAt(r, 2).toString();
        String fuelSellingPrice=fuelTable.getValueAt(r, 3).toString();
        String tankCapacity=fuelTable.getValueAt(r, 4).toString();
        
        idtxt.setText(fuelId);
        fuelNametxt.setText(fuelName);
        fuelPricetxt.setText(fuelPrice);
        fuelSellingPricetxt.setText(fuelSellingPrice);
        tankCapacitytxt.setText(tankCapacity);
        
    }//GEN-LAST:event_fuelTableMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int update=JOptionPane.showConfirmDialog(null, "Do you want to really update?");
        if(update==0)
        {
            String fuelId=idtxt.getText();
            String fuelName=fuelNametxt.getText();
            String fuelPrice=fuelPricetxt.getText();
            String fuelSellingPrice=fuelSellingPricetxt.getText();
            String tankCapacity=tankCapacitytxt.getText();
     
            
        
            try{
                
                Fuel fuelUpdate=new Fuel(fuelId, fuelName, fuelPrice, fuelSellingPrice, tankCapacity);
                int res=FuelController.updateFuel(fuelUpdate);
                
                if(res>0){
                    JOptionPane.showMessageDialog(this, "Update Success");
                }
                //else{
                //    JOptionPane.showMessageDialog(this, "Update Fail");
                //}     
            }
        
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
        }
        tableLoad();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void deleteFuelboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteFuelboxActionPerformed
          int x=JOptionPane.showConfirmDialog(null, "Do you want to delete this?");
       
        if(x==0){
            
            String fuelName=fuelNametxt.getText();
            try{
                FuelController.deleteFuel(fuelName);
               
            }
            
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
        }
        tableLoad();
    }//GEN-LAST:event_deleteFuelboxActionPerformed

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
            java.util.logging.Logger.getLogger(FuelInsert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FuelInsert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FuelInsert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FuelInsert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FuelInsert().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JButton deleteFuelbox;
    private javax.swing.JLabel fuelInsertBackground;
    private javax.swing.JTextField fuelNametxt;
    private javax.swing.JTextField fuelPricetxt;
    private javax.swing.JTextField fuelSellingPricetxt;
    private javax.swing.JTable fuelTable;
    private javax.swing.JLabel idtxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tankCapacitytxt;
    // End of variables declaration//GEN-END:variables
}
