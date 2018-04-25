/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AutoMiraj.View;

import AutoMiraj.View.Admin_int;
import java.sql.ResultSet;
import AutoMiraj.Controller.DBAccess_Rumi;
import AutoMiraj.DBconnect.DBconnect;
import AutoMiraj.View.changePW;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 * 
 *
 * @author Rumesha
 */
public class Manage_Users extends javax.swing.JFrame {
    
    static Connection conn = DBconnect.connect();
    static PreparedStatement ps = null;
    static ResultSet rs = null;
    static Statement st = null; 
    DBAccess_Rumi rm = new DBAccess_Rumi();
    static String name = null;
    
   
    
    /**
     * Creates new form Manage_Users
     */
    public Manage_Users() {
        initComponents();
        this.viewUsers();
        
        //Dissabling the buttons
        remove.setEnabled(false);
        update.setEnabled(false);
        changePw.setEnabled(false);
        edit.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_add = new javax.swing.JButton();
        remove = new javax.swing.JButton();
        update = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        btn_back = new javax.swing.JButton();
        btn_close = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        userTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        cmb_userType2 = new javax.swing.JComboBox();
        lbl_userType2 = new javax.swing.JLabel();
        lbl_tele = new javax.swing.JLabel();
        lbl_date = new javax.swing.JLabel();
        add = new javax.swing.JTextField();
        txt_tele = new javax.swing.JTextField();
        lbl_password2 = new javax.swing.JLabel();
        changePw = new javax.swing.JButton();
        txt_username2 = new javax.swing.JTextField();
        lbl_address = new javax.swing.JLabel();
        lbl_username2 = new javax.swing.JLabel();
        pass = new javax.swing.JPasswordField();
        dc_dateJoined = new com.toedter.calendar.JDateChooser();
        edit = new javax.swing.JButton();
        lbl_ = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("User Management");
        getContentPane().setLayout(null);

        btn_add.setText("Add");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });
        getContentPane().add(btn_add);
        btn_add.setBounds(550, 420, 80, 30);

        remove.setText("Remove");
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });
        getContentPane().add(remove);
        remove.setBounds(650, 420, 80, 30);

        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        getContentPane().add(update);
        update.setBounds(850, 420, 79, 30);

        clear.setText("Clear");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });
        getContentPane().add(clear);
        clear.setBounds(950, 420, 81, 30);

        btn_back.setText("Back");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });
        getContentPane().add(btn_back);
        btn_back.setBounds(120, 510, 81, 30);

        btn_close.setText("Close");
        getContentPane().add(btn_close);
        btn_close.setBounds(270, 510, 81, 30);

        userTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Username", "Address", "Tele. Number", "Date Joined", "User Type"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Object.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        userTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(userTable);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(540, 70, 570, 320);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Add New User", javax.swing.border.TitledBorder.LEADING, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 255, 255))); // NOI18N
        jPanel1.setOpaque(false);
        jPanel1.setLayout(null);

        cmb_userType2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select a type", "Admin", "Manager", "Stock Manager", "Data Entry Operator", " " }));
        jPanel1.add(cmb_userType2);
        cmb_userType2.setBounds(160, 350, 158, 30);

        lbl_userType2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_userType2.setForeground(new java.awt.Color(255, 255, 255));
        lbl_userType2.setText("User Type");
        jPanel1.add(lbl_userType2);
        lbl_userType2.setBounds(20, 350, 80, 20);

        lbl_tele.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_tele.setForeground(new java.awt.Color(255, 255, 255));
        lbl_tele.setText("Tel. Number");
        jPanel1.add(lbl_tele);
        lbl_tele.setBounds(20, 230, 80, 14);

        lbl_date.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_date.setForeground(new java.awt.Color(255, 255, 255));
        lbl_date.setText("Date Joined");
        jPanel1.add(lbl_date);
        lbl_date.setBounds(20, 290, 80, 15);
        jPanel1.add(add);
        add.setBounds(160, 150, 158, 30);
        jPanel1.add(txt_tele);
        txt_tele.setBounds(160, 220, 158, 30);

        lbl_password2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_password2.setForeground(new java.awt.Color(255, 255, 255));
        lbl_password2.setText("Password");
        jPanel1.add(lbl_password2);
        lbl_password2.setBounds(20, 100, 80, 14);

        changePw.setText("Change Password");
        changePw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePwActionPerformed(evt);
            }
        });
        jPanel1.add(changePw);
        changePw.setBounds(330, 90, 140, 30);
        jPanel1.add(txt_username2);
        txt_username2.setBounds(160, 30, 158, 30);

        lbl_address.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_address.setForeground(new java.awt.Color(255, 255, 255));
        lbl_address.setText("Address");
        jPanel1.add(lbl_address);
        lbl_address.setBounds(20, 160, 80, 15);

        lbl_username2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_username2.setForeground(new java.awt.Color(255, 255, 255));
        lbl_username2.setText("Username");
        jPanel1.add(lbl_username2);
        lbl_username2.setBounds(20, 40, 80, 15);
        jPanel1.add(pass);
        pass.setBounds(160, 90, 160, 30);
        jPanel1.add(dc_dateJoined);
        dc_dateJoined.setBounds(160, 280, 160, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(40, 70, 480, 420);

        edit.setText("Edit");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });
        getContentPane().add(edit);
        edit.setBounds(750, 420, 80, 30);

        lbl_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BackgroundNew.jpg"))); // NOI18N
        lbl_.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lbl_.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        getContentPane().add(lbl_);
        lbl_.setBounds(0, 0, 0, 0);

        jButton2.setText("jButton2");
        getContentPane().add(jButton2);
        jButton2.setBounds(740, 420, 70, 70);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        // update the user details 
        String address = add.getText();
        String tele = txt_tele.getText();
        SimpleDateFormat sdf= new SimpleDateFormat("YYYY-MM-dd");
        Date temp = dc_dateJoined.getDate();
        String dj = sdf.format(temp);
        String type = cmb_userType2.getSelectedItem().toString();
        
        rm.updateUser(name,address,tele,dj,type);
        JOptionPane.showMessageDialog(null, "Successfully updated the user details");
        this.viewUsers();
        this.clearAll();
        txt_username2.setEditable(true);
        pass.setEnabled(true);
        add.setEditable(true);
        txt_tele.setEditable(true);
//        txt_date.setEditable(true);
        cmb_userType2.setEnabled(true);
        btn_add.setEnabled(true);
        remove.setEnabled(false);
        edit.setEnabled(false);
        changePw.setEnabled(false);
        update.setEnabled(false);
    }//GEN-LAST:event_updateActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        this.clearAll();
        txt_username2.setEditable(true);
        pass.setEnabled(true);
        add.setEditable(true);
        txt_tele.setEditable(true);
//        txt_date.setEditable(true);
        cmb_userType2.setEnabled(true);
        btn_add.setEnabled(true);
        remove.setEnabled(false);
        edit.setEnabled(false);
        changePw.setEnabled(false);
        
    }//GEN-LAST:event_clearActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        String name = txt_username2.getText();
        String pw = pass.getText();
        String address = add.getText();
        String tele = txt_tele.getText();
        String type = cmb_userType2.getSelectedItem().toString();
        SimpleDateFormat sdf= new SimpleDateFormat("YYYY-MM-dd");
        Date temp = dc_dateJoined.getDate();
        String dj = sdf.format(temp);
        
        try{
            rm.addUsers(name,address,tele,dj,type,pw);
            this.clearAll();
            this.viewUsers();
            
        }catch(Exception e){
        
        }
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
            Admin_int ad = new Admin_int();
            ad.setVisible(true);
            this.dispose();
    }//GEN-LAST:event_btn_backActionPerformed

    private void userTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userTableMouseClicked
        btn_add.setEnabled(false);
        remove.setEnabled(true);
        edit.setEnabled(true);
        changePw.setEnabled(true);
        
        
        int row = userTable.getSelectedRow();
        String user_name = userTable.getValueAt(row, 0).toString();
        
        rs = DBAccess_Rumi.tableSelect(user_name);
        try{
            if(rs.next()){
                name = rs.getString("username");
                txt_username2.setText(name);
                txt_username2.setEditable(false);
                
                pass.setEnabled(false);
                
                String address = rs.getString("Address");
                add.setText(address);
                add.setEditable(false);
                
                String tele = rs.getString("teleNumber");
                txt_tele.setText(tele);
                txt_tele.setEditable(false);
                
//                String dj = rs.getString("DateJoined");
//                dc_dateJoined.setText(dj);
//                txt_date.setEditable(false);
                
                String type = rs.getString("UserType");
                
                switch (type){
                    case "Admin":
                        cmb_userType2.setSelectedIndex(1);
                        cmb_userType2.setEnabled(false);
                        break;
                    case "Manager":
                        cmb_userType2.setSelectedIndex(2);
                        cmb_userType2.setEnabled(false);
                        break;
                    case "Stock Manager":
                        cmb_userType2.setSelectedIndex(3);
                        cmb_userType2.setEnabled(false);
                        break;
                    case "Data Entry Operator":    
                        cmb_userType2.setSelectedIndex(4);
                        cmb_userType2.setEnabled(false);
                        
                }
            }
        }catch(Exception e){
            
        }
    }//GEN-LAST:event_userTableMouseClicked

    private void changePwActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changePwActionPerformed
        changePW ch = new changePW();
        ch.setVisible(true);
    }//GEN-LAST:event_changePwActionPerformed

    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
        // remove selected user from the table
        rm.removeUser(name);
        this.viewUsers();
        this.clearAll();
        txt_username2.setEditable(true);
        pass.setEnabled(true);
        add.setEditable(true);
        txt_tele.setEditable(true);
//        txt_date.setEditable(true);
        cmb_userType2.setEnabled(true);
        btn_add.setEnabled(true);
        remove.setEnabled(false);
        edit.setEnabled(false);
        changePw.setEnabled(false);
    }//GEN-LAST:event_removeActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        //add and remove buttons getting dissabled and update button will get enabled
        btn_add.setEnabled(false);
        remove.setEnabled(false);
        update.setEnabled(true);
        
        //certain text boxes will get enabled to  edit such as date joined, address user type and tele number
        add.setEditable(true);
        txt_tele.setEditable(true);
//        txt_date.setEditable(true);
        cmb_userType2.setEnabled(true);
    }//GEN-LAST:event_editActionPerformed

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
            java.util.logging.Logger.getLogger(Manage_Users.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Manage_Users.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Manage_Users.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Manage_Users.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Manage_Users().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField add;
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_close;
    private javax.swing.JButton changePw;
    private javax.swing.JButton clear;
    private javax.swing.JComboBox cmb_userType2;
    private com.toedter.calendar.JDateChooser dc_dateJoined;
    private javax.swing.JButton edit;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_;
    private javax.swing.JLabel lbl_address;
    private javax.swing.JLabel lbl_date;
    private javax.swing.JLabel lbl_password2;
    private javax.swing.JLabel lbl_tele;
    private javax.swing.JLabel lbl_userType2;
    private javax.swing.JLabel lbl_username2;
    private javax.swing.JPasswordField pass;
    private javax.swing.JButton remove;
    private javax.swing.JTextField txt_tele;
    private javax.swing.JTextField txt_username2;
    private javax.swing.JButton update;
    private javax.swing.JTable userTable;
    // End of variables declaration//GEN-END:variables

    public void viewUsers (){
        rs = DBAccess_Rumi.getUser();
        userTable.setModel(DbUtils.resultSetToTableModel(rs));  
    } 
    
    public void clearAll(){
        txt_username2.setText("");
        pass.setText("");
        add.setText("");
        txt_tele.setText("");
//        txt_date.setText("");
        cmb_userType2.setSelectedIndex(0);
    }

}