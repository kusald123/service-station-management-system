/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AutoMiraj.View;


import AutoMiraj.View.FuelInsert;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import AutoMiraj.Controller.EstimationController;
import AutoMiraj.Model.Estimation;

import AutoMiraj.DBconnect.DBconnect;
import AutoMiraj.View.CustomerDetails;
import AutoMiraj.View.EstimationReport;
import AutoMiraj.View.VehicleSpareParts;
import AutoMiraj.View.main_gui;
/**
 *
 * @author User
 */
public final class Reservoir extends javax.swing.JFrame {
    
    Connection conn=null;
    PreparedStatement pst=null;
    PreparedStatement pst1=null;
    PreparedStatement pst2=null;
    ResultSet rs_spareParts=null;
    ResultSet rs_selectFuel=null;
    ResultSet rs=null;
    
    
    
    
    public Reservoir() {
       
        
        initComponents();
        conn=DBconnect.connect();
        
        
       
        
        //to select fuel combo box load
        selectFuelLoad(); 
        
        //to view fuel details table load
        viewFuelTableLoad();
    }
    
   
    
    
    public boolean formValidation(){
        if(((JTextField)datebox.getDateEditor().getUiComponent()).getText().length()==0){
            JOptionPane.showMessageDialog(this, "Please add date");
            name.requestFocus();
            
        }
        
        else if(name.getText().length()==0){
            JOptionPane.showMessageDialog(this, "Please add customer name");
            name.requestFocus();
            
        }
        
        else if(address.getText().length()==0){
            JOptionPane.showMessageDialog(this, "Please add customer address");
            address.requestFocus();
            
        }
        
        else if(telephone.getText().length()==0){
            JOptionPane.showMessageDialog(this, "Please add customer contact number");
            telephone.requestFocus();
            
        }
        
        else if(telephone.getText().length()>10 || telephone.getText()=="^[0-9]" ){
            JOptionPane.showMessageDialog(this, "Please check customer contact number");
            telephone.requestFocus();
            
        }
        
        else if(nic.getText().length()==0){
            JOptionPane.showMessageDialog(this, "Please add customer NIC");
            nic.requestFocus();
            
        }
        
        else if(nic.getText().length()>10){
            JOptionPane.showMessageDialog(this, "Please check customer NIC");
            nic.requestFocus();
            
        }
        
        else if(vName.getText().length()==0){
            JOptionPane.showMessageDialog(this, "Please add vehicle name");
            vName.requestFocus();
            
        }
        
        else if(mYear.getSelectedItem().toString().length()==0){
            JOptionPane.showMessageDialog(this, "Please add vehicle manufacture year");
            mYear.requestFocus();
            
        }
        
        else if(vNumber.getText().length()==0){
            JOptionPane.showMessageDialog(this, "Please add vehicle number");
            vNumber.requestFocus();
            
        }
        return false;
        
        
      
    }
    
    public boolean checkFuelFormValidation(){
        if(fuelNamebox.getSelectedItem().toString().length()==0){
            JOptionPane.showMessageDialog(this, "Please select fuel name");
            fuelNamebox.requestFocus();
        }
        
        else if(((JTextField)selectDate.getDateEditor().getUiComponent()).getText().length()==0){
            JOptionPane.showMessageDialog(this, "Please add date");
            selectDate.requestFocus();
        }
        
        else if(calcTime.getSelectedItem().toString().length()==0){
            JOptionPane.showMessageDialog(this, "Please select time");
            calcTime.requestFocus();
        }
        
        else if(currentLevelbox.getText().length()==0){
            JOptionPane.showMessageDialog(this, "Please add current fuel level");
            currentLevelbox.requestFocus();
        }
        
        else if("^[0-9]".equals(currentLevelbox.getText()) ){
            JOptionPane.showMessageDialog(this, "Please check current fuel level");
            currentLevelbox.requestFocus();
            
        }
        return false;
        
    }
    
    
    public boolean refillFuelFormValidation(){
        if(refillFuelbox.getSelectedItem().toString().length()==0){
            JOptionPane.showMessageDialog(this, "Please select fuel name");
            refillFuelbox.requestFocus();
        }
        
        else if(((JTextField)refillDatebox.getDateEditor().getUiComponent()).getText().length()==0){
            JOptionPane.showMessageDialog(this, "Please add date");
            refillDatebox.requestFocus();
        }
        
        else if(refillCurrentLevel.getText().length()==0){
            JOptionPane.showMessageDialog(this, "Please add current fuel level");
            refillCurrentLevel.requestFocus();
        }
        
        else if("^[0-9]".equals(refillCurrentLevel.getText()) ){
            JOptionPane.showMessageDialog(this, "Please check current fuel level");
            refillCurrentLevel.requestFocus();
            
        }
        return false;
    }
    
    
    public void selectFuelLoad(){
        try{
            String sql="SELECT fuelName FROM insertFuel";
            pst=conn.prepareStatement(sql);
            rs_selectFuel=pst.executeQuery();
            
            while(rs_selectFuel.next()){
               String nameFuel=rs_selectFuel.getString("fuelName");
                fuelNamebox.addItem(nameFuel);
                refillFuelbox.addItem(nameFuel);
            }   
           
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }

    //Searched spareparts details add to estimation report table
    public void addToReport(){
        int selectRow=searchTable.getSelectedRow();
       
       String partNo=searchTable.getModel().getValueAt(selectRow, 0).toString();
       String partName=searchTable.getModel().getValueAt(selectRow, 1).toString();
       String price=searchTable.getModel().getValueAt(selectRow, 4).toString();
       
       DefaultTableModel mod=(DefaultTableModel) reportTable.getModel();
       mod.addRow(new Object[]{partNo, partName, price});
    }
    
    
    //Generate final estimation report
    public void generateEstimationReport(){
        
        EstimationReport er=new EstimationReport();
        er.setVisible(true);

        er.report.append("                                    AUTO MIRAJ\n");
        er.report.append("                                   Mount Lavenia\n");
        er.report.append("                           Tel : 011-2884562/0777185269\n");
        er.report.append("                           Email : AutoMiraj@gmail.com \n");
        er.report.append("                                   \n");
        er.report.append("                            Collision Repair Estimation\n");
        er.report.append("_________________________________________________________________________\n");
        er.report.append("=========================================================================\n");
        er.report.append(" Estimated Date"+"\t -:  "+((JTextField)datebox.getDateEditor().getUiComponent()).getText()+"\n");
        er.report.append("_________________________________________________________________________\n");
        er.report.append(" Name"+"\t\t\t -:  "+name.getText().toString()+"\n");
        er.report.append(" Address"+"\t\t -:  "+address.getText().toString()+"\n");
        er.report.append(" Contact Number"+"\t -:  "+telephone.getText().toString()+"\n");
        er.report.append(" Vehicle"+"\t\t -:  "+mYear.getSelectedItem().toString()+" "+vName.getText().toString()+"\n");
        er.report.append(" Vehicle Number"+"\t -:  "+vNumber.getText().toString()+"\n");
        er.report.append("_________________________________________________________________________\n");
        er.report.append("=========================================================================\n");
        er.report.append(" Part No"+"          Description\t"+" Price\t"+"\n");
        er.report.append("=========================================================================\n");
        
        DefaultTableModel dtm=(DefaultTableModel)reportTable.getModel();
        int nRow=dtm.getRowCount();
        int nCol=dtm.getColumnCount();
        Object[][] tableData=new Object[nRow][nCol];
        for(int i=0; i<nRow; i++)
        {
            for(int j=0; j<nCol; j++)
            {
                tableData[i][j]=dtm.getValueAt(i, j);
                er.report.append(" "+tableData[i][j].toString()+"\t\t");
            }
            er.report.append("          \n");
        }
        
        er.report.append("________________________________________________________________________\n");
        
        int total=0;
        int rows=reportTable.getRowCount();
        for(int x=0; x<rows; x++)
        {
            total+=(Integer.parseInt(reportTable.getValueAt(x, 2).toString()));
            
        }
         er.report.append(" Total amount                      "+total+"\n");
         er.report.append("========================================================================\n");
       
        
    }
    
    public void viewFuelTableLoad(){
        try{
            String sql="SELECT fName, currentLevel, fuelUsage, incomeProfit, calculatedTime, calculatedDate FROM viewfueldetails";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            viewFuelTable.setModel(DbUtils.resultSetToTableModel(rs));
            
            int total=0;
            int rows=viewFuelTable.getRowCount();
            for(int x=0; x<rows; x++)
            {
                total+=(Integer.parseInt(viewFuelTable.getValueAt(x, 3).toString()));
            
            }
            sumOfProfit.setText(String.valueOf(total));
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
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

        calculateTime = new javax.swing.ButtonGroup();
        mainTab = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        viewFuelTable = new javax.swing.JTable();
        insertBtn = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        sumOfProfit = new javax.swing.JTextField();
        notice = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        fuelNamebox = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        selectDate = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        currentLevelbox = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        usagebox = new javax.swing.JLabel();
        viewFuelDetailsBtn = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        calcTime = new javax.swing.JComboBox();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        refillFuelbox = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        refillDatebox = new com.toedter.calendar.JDateChooser();
        jButton12 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        refillCurrentLevel = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        generatebtn = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        vName = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        mYear = new javax.swing.JComboBox();
        vNumber = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        address = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        telephone = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        nic = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        datebox = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        searchTable = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        reportTable = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        searchTypebox = new javax.swing.JComboBox();
        jLabel16 = new javax.swing.JLabel();
        searchMakebox = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        searchNamebox = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        descriptiontxt = new javax.swing.JTextField();
        valuetxt = new javax.swing.JTextField();
        jButton13 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jButton15 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        backEstimationBtn = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        mainbackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("RESERVOIR");
        setResizable(false);
        getContentPane().setLayout(null);

        mainTab.setPreferredSize(new java.awt.Dimension(1280, 720));

        jPanel1.setMinimumSize(new java.awt.Dimension(1280, 720));
        jPanel1.setPreferredSize(new java.awt.Dimension(1280, 720));
        jPanel1.setLayout(null);

        viewFuelTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"  ", "", null, null, null, null},
                {"  ", "  ", null, null, null, null},
                {"", "", null, null, null, null},
                {" ", " ", null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Fuel Name", "Current Volume", "Fuel Usage", "Income Profit", "Calculated Time", "Calculated Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        viewFuelTable.setIntercellSpacing(new java.awt.Dimension(2, 2));
        viewFuelTable.setRowHeight(40);
        viewFuelTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewFuelTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(viewFuelTable);
        if (viewFuelTable.getColumnModel().getColumnCount() > 0) {
            viewFuelTable.getColumnModel().getColumn(0).setResizable(false);
            viewFuelTable.getColumnModel().getColumn(1).setResizable(false);
            viewFuelTable.getColumnModel().getColumn(2).setResizable(false);
            viewFuelTable.getColumnModel().getColumn(3).setResizable(false);
            viewFuelTable.getColumnModel().getColumn(4).setResizable(false);
            viewFuelTable.getColumnModel().getColumn(5).setResizable(false);
        }

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(80, 280, 900, 250);

        insertBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add.png"))); // NOI18N
        insertBtn.setText("Add Fuel Tank ");
        insertBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertBtnActionPerformed(evt);
            }
        });
        jPanel1.add(insertBtn);
        insertBtn.setBounds(1000, 280, 160, 60);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sum of Profit", ""
            }
        ));
        jScrollPane3.setViewportView(jTable2);

        jPanel1.add(jScrollPane3);
        jScrollPane3.setBounds(80, 540, 440, 30);
        jPanel1.add(sumOfProfit);
        sumOfProfit.setBounds(520, 540, 150, 30);

        notice.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        notice.setForeground(new java.awt.Color(255, 0, 51));
        notice.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.add(notice);
        notice.setBounds(680, 530, 490, 40);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Check fuel levels", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(102, 255, 255))); // NOI18N
        jPanel3.setOpaque(false);
        jPanel3.setLayout(null);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Select Fuel Name");
        jPanel3.add(jLabel3);
        jLabel3.setBounds(70, 20, 110, 30);

        fuelNamebox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        fuelNamebox.setMinimumSize(new java.awt.Dimension(50, 20));
        fuelNamebox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fuelNameboxActionPerformed(evt);
            }
        });
        jPanel3.add(fuelNamebox);
        fuelNamebox.setBounds(200, 20, 130, 30);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Select Date");
        jPanel3.add(jLabel4);
        jLabel4.setBounds(70, 70, 80, 30);

        selectDate.setDateFormatString("dd-MM-yyyy");
        jPanel3.add(selectDate);
        selectDate.setBounds(200, 70, 130, 30);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Select Time ");
        jPanel3.add(jLabel1);
        jLabel1.setBounds(70, 120, 100, 30);

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Current Fuel Level(litre)");
        jPanel3.add(jLabel9);
        jLabel9.setBounds(70, 170, 150, 30);
        jPanel3.add(currentLevelbox);
        currentLevelbox.setBounds(200, 170, 130, 30);

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Fuel Usage(litre)");
        jPanel3.add(jLabel6);
        jLabel6.setBounds(70, 220, 110, 30);

        usagebox.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        usagebox.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(usagebox);
        usagebox.setBounds(200, 220, 130, 30);

        viewFuelDetailsBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add.png"))); // NOI18N
        viewFuelDetailsBtn.setText("Add to Fuel Table");
        viewFuelDetailsBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                viewFuelDetailsBtnMouseEntered(evt);
            }
        });
        viewFuelDetailsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewFuelDetailsBtnActionPerformed(evt);
            }
        });
        jPanel3.add(viewFuelDetailsBtn);
        viewFuelDetailsBtn.setBounds(340, 20, 160, 60);

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/update.png"))); // NOI18N
        jButton10.setText("Update");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton10);
        jButton10.setBounds(340, 100, 160, 60);

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/remove.png"))); // NOI18N
        jButton11.setText("Delete");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton11);
        jButton11.setBounds(340, 180, 160, 60);

        calcTime.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "6 am", "6 pm" }));
        jPanel3.add(calcTime);
        calcTime.setBounds(200, 120, 130, 30);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(70, 10, 520, 260);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Refill fuel tanks", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(102, 255, 255))); // NOI18N
        jPanel4.setOpaque(false);
        jPanel4.setLayout(null);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Select Fuel Name");
        jPanel4.add(jLabel2);
        jLabel2.setBounds(30, 20, 100, 30);

        refillFuelbox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        jPanel4.add(refillFuelbox);
        refillFuelbox.setBounds(160, 20, 130, 30);

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Select Date");
        jPanel4.add(jLabel12);
        jLabel12.setBounds(30, 70, 70, 30);

        refillDatebox.setDateFormatString("dd-MM-yyyy");
        jPanel4.add(refillDatebox);
        refillDatebox.setBounds(160, 70, 130, 30);

        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add.png"))); // NOI18N
        jButton12.setText("Refill");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton12);
        jButton12.setBounds(300, 20, 160, 60);

        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/remove.png"))); // NOI18N
        jButton14.setText("Remove Refill");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton14);
        jButton14.setBounds(300, 100, 160, 60);
        jPanel4.add(refillCurrentLevel);
        refillCurrentLevel.setBounds(160, 120, 130, 30);

        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Current Fuel Level(litre)");
        jPanel4.add(jLabel17);
        jLabel17.setBounds(30, 120, 150, 30);

        jPanel1.add(jPanel4);
        jPanel4.setBounds(700, 10, 480, 260);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/InterfaceBackground.jpg"))); // NOI18N
        jLabel5.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel5);
        jLabel5.setBounds(0, 0, 1330, 690);

        mainTab.addTab("Fuel Level Details", jPanel1);

        jPanel2.setPreferredSize(new java.awt.Dimension(1280, 720));
        jPanel2.setLayout(null);

        generatebtn.setText("Generate Report");
        generatebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generatebtnActionPerformed(evt);
            }
        });
        jPanel2.add(generatebtn);
        generatebtn.setBounds(530, 520, 160, 43);

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Vehicle Name");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(50, 340, 78, 30);

        vName.setBorder(null);
        vName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vNameActionPerformed(evt);
            }
        });
        jPanel2.add(vName);
        vName.setBounds(180, 340, 280, 30);

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Vehicle Number");
        jPanel2.add(jLabel13);
        jLabel13.setBounds(50, 460, 92, 30);

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Manufacture Year");
        jPanel2.add(jLabel14);
        jLabel14.setBounds(50, 400, 101, 30);

        mYear.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015" }));
        mYear.setBorder(null);
        mYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mYearActionPerformed(evt);
            }
        });
        jPanel2.add(mYear);
        mYear.setBounds(180, 400, 280, 30);

        vNumber.setBorder(null);
        jPanel2.add(vNumber);
        vNumber.setBounds(180, 460, 280, 30);

        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Customer Name");
        jPanel2.add(jLabel19);
        jLabel19.setBounds(50, 100, 99, 30);

        name.setBorder(null);
        jPanel2.add(name);
        name.setBounds(180, 100, 282, 30);

        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Address");
        jPanel2.add(jLabel20);
        jLabel20.setBounds(50, 160, 64, 30);

        address.setBorder(null);
        jPanel2.add(address);
        address.setBounds(180, 160, 282, 30);

        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Tel No");
        jPanel2.add(jLabel21);
        jLabel21.setBounds(50, 220, 64, 30);

        telephone.setBorder(null);
        jPanel2.add(telephone);
        telephone.setBounds(180, 220, 282, 30);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add.png"))); // NOI18N
        jButton1.setText("Add Customer Details");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(20, 520, 190, 40);

        jButton3.setText("View Customer Details");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3);
        jButton3.setBounds(210, 520, 190, 40);

        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("NIC");
        jPanel2.add(jLabel25);
        jLabel25.setBounds(50, 280, 50, 20);

        nic.setBorder(null);
        jPanel2.add(nic);
        nic.setBounds(180, 280, 280, 30);

        jButton8.setText("Add New Part");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton8);
        jButton8.setBounds(690, 520, 150, 43);

        jButton9.setText("Clear");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton9);
        jButton9.setBounds(400, 520, 100, 40);

        datebox.setDateFormatString("yyyy-MM-dd");
        jPanel2.add(datebox);
        datebox.setBounds(180, 40, 280, 30);

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Date");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(50, 40, 50, 20);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Add customer details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 255, 255))); // NOI18N
        jPanel5.setOpaque(false);
        jPanel5.setLayout(null);
        jPanel2.add(jPanel5);
        jPanel5.setBounds(20, 10, 480, 500);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Add estimated vehicle parts", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 255, 255))); // NOI18N
        jPanel6.setOpaque(false);
        jPanel6.setLayout(null);

        searchTable.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        searchTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Part Id", "Part Name", "Type", "Make", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        searchTable.setToolTipText("");
        searchTable.setRowHeight(30);
        searchTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(searchTable);
        if (searchTable.getColumnModel().getColumnCount() > 0) {
            searchTable.getColumnModel().getColumn(0).setResizable(false);
            searchTable.getColumnModel().getColumn(1).setResizable(false);
            searchTable.getColumnModel().getColumn(2).setResizable(false);
            searchTable.getColumnModel().getColumn(3).setResizable(false);
            searchTable.getColumnModel().getColumn(4).setResizable(false);
        }

        jPanel6.add(jScrollPane2);
        jScrollPane2.setBounds(30, 70, 650, 160);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add.png"))); // NOI18N
        jButton6.setText("Add to Report");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton6);
        jButton6.setBounds(30, 240, 530, 30);

        reportTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Part No", "Part Name", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        reportTable.setRowHeight(30);
        jScrollPane5.setViewportView(reportTable);
        if (reportTable.getColumnModel().getColumnCount() > 0) {
            reportTable.getColumnModel().getColumn(1).setResizable(false);
            reportTable.getColumnModel().getColumn(2).setResizable(false);
        }

        jPanel6.add(jScrollPane5);
        jScrollPane5.setBounds(30, 280, 650, 170);

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Type");
        jPanel6.add(jLabel11);
        jLabel11.setBounds(30, 30, 50, 30);

        searchTypebox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Car", "Jeep", "Cab", "Bus", "Lorry" }));
        jPanel6.add(searchTypebox);
        searchTypebox.setBounds(60, 30, 120, 30);

        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Make");
        jPanel6.add(jLabel16);
        jLabel16.setBounds(220, 30, 40, 30);

        searchMakebox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Toyota", "Nissan", "Mitsubishi", "Mazda", "Suzuki" }));
        jPanel6.add(searchMakebox);
        searchMakebox.setBounds(250, 30, 100, 30);

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Part Name");
        jPanel6.add(jLabel15);
        jLabel15.setBounds(400, 30, 70, 30);
        jPanel6.add(searchNamebox);
        searchNamebox.setBounds(460, 30, 70, 30);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search.png"))); // NOI18N
        jButton2.setText("Search");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton2);
        jButton2.setBounds(560, 30, 120, 30);
        jPanel6.add(descriptiontxt);
        descriptiontxt.setBounds(130, 460, 340, 30);
        jPanel6.add(valuetxt);
        valuetxt.setBounds(470, 460, 90, 30);

        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add.png"))); // NOI18N
        jButton13.setText("Add");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton13);
        jButton13.setBounds(559, 460, 120, 30);

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Other  Payments");
        jPanel6.add(jLabel18);
        jLabel18.setBounds(30, 460, 100, 30);

        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/remove.png"))); // NOI18N
        jButton15.setText("Remove");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton15);
        jButton15.setBounds(560, 240, 120, 30);

        jPanel2.add(jPanel6);
        jPanel6.setBounds(530, 10, 710, 500);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/InterfaceBackground.jpg"))); // NOI18N
        jLabel7.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel2.add(jLabel7);
        jLabel7.setBounds(0, 0, 1280, 710);

        mainTab.addTab("Vehicle Estimation", jPanel2);

        getContentPane().add(mainTab);
        mainTab.setBounds(10, 70, 1280, 730);

        backEstimationBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/back.png"))); // NOI18N
        backEstimationBtn.setText("Back");
        backEstimationBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backEstimationBtnActionPerformed(evt);
            }
        });
        getContentPane().add(backEstimationBtn);
        backEstimationBtn.setBounds(1040, 10, 110, 40);

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/log out.png"))); // NOI18N
        jButton7.setText("Log Out");
        getContentPane().add(jButton7);
        jButton7.setBounds(1160, 10, 110, 40);

        mainbackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/InterfaceBackground.jpg"))); // NOI18N
        mainbackground.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        mainbackground.setPreferredSize(new java.awt.Dimension(1280, 720));
        getContentPane().add(mainbackground);
        mainbackground.setBounds(0, 0, 1290, 730);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void insertBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertBtnActionPerformed
        FuelInsert I1=new FuelInsert();
        I1.setVisible(true);

    }//GEN-LAST:event_insertBtnActionPerformed

    private void viewFuelDetailsBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewFuelDetailsBtnMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_viewFuelDetailsBtnMouseEntered

    private void vNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vNameActionPerformed

    private void mYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mYearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mYearActionPerformed

    private void backEstimationBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backEstimationBtnActionPerformed
        main_gui M2=new main_gui();
        M2.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backEstimationBtnActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
       addToReport();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void fuelNameboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fuelNameboxActionPerformed
        
    }//GEN-LAST:event_fuelNameboxActionPerformed

    private void viewFuelDetailsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewFuelDetailsBtnActionPerformed
       boolean res=checkFuelFormValidation();
       if(res==true){
       }
           
       else{
        try{
            
            String fuelName=fuelNamebox.getSelectedItem().toString();
            String calculatedDate=((JTextField)selectDate.getDateEditor().getUiComponent()).getText();
            String calculatedTime=calcTime.getSelectedItem().toString();
            int currentLevel=Integer.parseInt(currentLevelbox.getText());
            int usage=0;
            int incomeProfit = 0;
            int fId=0;
            int fuelPrice=0;
            int fuelSellingPrice=0;
            int fuelProfit;
            
            
            
            ResultSet rs2=pst.executeQuery("SELECT MAX(fId) FROM viewfueldetails WHERE fName='"+fuelName+"'");
            while(rs2.next()){
               
                fId = rs2.getInt(1);
            }
            ResultSet rs1=pst.executeQuery("SELECT currentLevel FROM viewfueldetails WHERE fId='"+fId+"'");
            while(rs1.next()){
               
                int latestLevel=rs1.getInt(1);
                
                usage=latestLevel-currentLevel;
                usagebox.setText(String.valueOf(usage));
            }
            
            ResultSet rs=pst.executeQuery("SELECT fuelPrice, fuelSellingPrice FROM insertfuel WHERE fuelName='"+fuelName+"'");
            while(rs.next()){
               
                fuelPrice = rs.getInt(1);
                fuelSellingPrice = rs.getInt(2);
                fuelProfit=fuelSellingPrice-fuelPrice;
                
                incomeProfit=fuelProfit*usage;
                String sql = "INSERT INTO viewfueldetails (fName, currentLevel, fuelUsage, incomeProfit, calculatedTime, calculatedDate) VALUES('"+fuelName+"', '"+currentLevel+"', '"+usage+"', '"+incomeProfit+"', '"+calculatedTime+"', '"+calculatedDate+"')";
                
                pst=conn.prepareStatement(sql);
                pst.execute();       
            }
            
            
            if(currentLevel<7000){
                notice.setText(fuelName+" tank fuel level is low. Please refill fuel tank!! ");
            }
        }
        
        
        catch(Exception e){
            //JOptionPane.showMessageDialog(null, e);
        }
        viewFuelTableLoad();
       }
    }//GEN-LAST:event_viewFuelDetailsBtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        boolean val=formValidation();
        if (val==true){
            
        }
        else{
            String cusId=null;
            String date=((JTextField)datebox.getDateEditor().getUiComponent()).getText();
            String cusName=name.getText();
            String cusAddress=address.getText();
            String telNo=telephone.getText();
            String cusNic=nic.getText();
            String veName=vName.getText();
            String manuYear=mYear.getSelectedItem().toString();
            String veNumber=vNumber.getText();
        
        
        
            try{
           
                Estimation estimation=new Estimation (cusId, date, cusName, cusAddress, telNo, cusNic, veName, manuYear, veNumber);
                int res= EstimationController.addCusDetails(estimation);
            
                if(res>0){
                    JOptionPane.showMessageDialog(this,"Added success");
                
                }
            
            
            }
            catch(Exception e){
                //JOptionPane.showMessageDialog(null, e);
            
            }
        
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        CustomerDetails M3=new CustomerDetails();
        M3.setVisible(true);
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        VehicleSpareParts M2=new VehicleSpareParts();
        M2.setVisible(true);
        
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String type=searchTypebox.getSelectedItem().toString();
        String make=searchMakebox.getSelectedItem().toString();
        String name=searchNamebox.getText();
        
        
        
        try{
            
            ResultSet res=EstimationController.searchSpareParts(type, make, name);
            searchTable.setModel(DbUtils.resultSetToTableModel(res));
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void searchTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchTableMouseClicked
             
              
    }//GEN-LAST:event_searchTableMouseClicked

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        
        name.setText("");
        address.setText("");
        telephone.setText("");
        nic.setText("");
        vName.setText("");
        mYear.setSelectedItem("");
        vNumber.setText("");
    }//GEN-LAST:event_jButton9ActionPerformed

    private void generatebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generatebtnActionPerformed
        generateEstimationReport();
    }//GEN-LAST:event_generatebtnActionPerformed

    private void viewFuelTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewFuelTableMouseClicked
         int r=viewFuelTable.getSelectedRow();
        
        String fuelName=viewFuelTable.getValueAt(r, 0).toString();
        String date=viewFuelTable.getValueAt(r, 5).toString();
        String calculatedTime=viewFuelTable.getValueAt(r, 4).toString();
        String currentFuel=viewFuelTable.getValueAt(r, 1).toString();
        String usage=viewFuelTable.getValueAt(r, 2).toString();
        
        fuelNamebox.setSelectedItem(fuelName);
        ((JTextField)selectDate.getDateEditor().getUiComponent()).setText(date);
        currentLevelbox.setText(currentFuel);
        usagebox.setText(usage);
        calcTime.setSelectedItem(calculatedTime);
        
    }//GEN-LAST:event_viewFuelTableMouseClicked

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
         int update=JOptionPane.showConfirmDialog(null, "Do you want to really update?");
        if(update==0)
        {
        
            try{
            
                String fuelName=fuelNamebox.getSelectedItem().toString();
                String calculatedDate=((JTextField)selectDate.getDateEditor().getUiComponent()).getText();
                String calculatedTime=calcTime.getSelectedItem().toString();
                int currentLevel=Integer.parseInt(currentLevelbox.getText());
                int usage=0;
                int incomeProfit = 0;
            
                ResultSet rs1=pst.executeQuery("SELECT MIN(currentLevel) FROM viewfueldetails WHERE fName='"+fuelName+"'");
                while(rs1.next()){
               
                    int latestLevel=rs1.getInt(1);
                
                    usage=currentLevel-latestLevel;
                    usagebox.setText(String.valueOf(usage));
                }
            
            
                ResultSet rs=pst.executeQuery("SELECT fuelPrice FROM insertfuel WHERE fuelName='"+fuelName+"'");
                while(rs.next()){
                    int fuelPrice=rs.getInt(1);
                    incomeProfit=fuelPrice*usage;
            
            
                    String sql = "UPDATE viewfueldetails SET fName='"+fuelName+"', currentLevel='"+currentLevel+"', fuelUsage='"+usage+"', incomeProfit='"+incomeProfit+"', calculatedTime='"+calculatedTime+"', calculatedDate='"+calculatedDate+"' WHERE fName='"+fuelName+"' AND calculatedTime='"+calculatedTime+"' AND calculatedDate='"+calculatedDate+"'";
                
                    pst=conn.prepareStatement(sql);
                    pst.execute();
                
                
                }
            
                if(currentLevel<7000){
                    notice.setText(fuelName+" tank fuel level is low. Please refill fuel tank!! ");
                }
            }
        
        
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
        }
        viewFuelTableLoad();
        
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        try{
            int x=JOptionPane.showConfirmDialog(null, "Do you want to Delete this?");
            if(x==0){
                int currentLevel=Integer.parseInt(currentLevelbox.getText());
                String sql="DELETE FROM viewfueldetails WHERE currentLevel='"+currentLevel+"'";  
                pst=conn.prepareStatement(sql);
                pst.execute();
            }
        }
        
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        
        }
        viewFuelTableLoad();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        boolean val=refillFuelFormValidation();
        if(val==true){
            
        }
        else{
            try{
                String fuelName=refillFuelbox.getSelectedItem().toString();
                String calculatedDate=((JTextField)refillDatebox.getDateEditor().getUiComponent()).getText();
                int currentLevel=Integer.parseInt(refillCurrentLevel.getText());
        
                String sql = "INSERT INTO viewfueldetails (fName, currentLevel, fuelUsage, incomeProfit, calculatedTime, calculatedDate) VALUES('"+fuelName+"','"+currentLevel+"', 'Refill', 0, 'Refill', '"+calculatedDate+"')";
                
                pst=conn.prepareStatement(sql);
                pst.execute(); 
            }
            catch(Exception e){
                //JOptionPane.showMessageDialog(null, e);
            }
            viewFuelTableLoad();
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        try{
            int x=JOptionPane.showConfirmDialog(null, "Do you want to Delete this?");
            if(x==0){
                int currentLevel=Integer.parseInt(currentLevelbox.getText());
                String sql="DELETE FROM viewfueldetails WHERE currentLevel='"+currentLevel+"'";  
                pst=conn.prepareStatement(sql);
                pst.execute();
            }
        }
        
        catch(Exception e){
            //JOptionPane.showMessageDialog(null, e);
        
        }
        viewFuelTableLoad();
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
   
       String description=descriptiontxt.getText();
       String cost=valuetxt.getText();
       String Other="-----";
       
       DefaultTableModel mod=(DefaultTableModel) reportTable.getModel();
      
       mod.addRow(new Object[]{Other, description, cost});
       
       descriptiontxt.setText("");
       valuetxt.setText("");
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
       int selectRow=reportTable.getSelectedRow();
      
       DefaultTableModel mod=(DefaultTableModel) reportTable.getModel();
       mod.removeRow(selectRow);
    }//GEN-LAST:event_jButton15ActionPerformed

      
   
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
            java.util.logging.Logger.getLogger(Reservoir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reservoir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reservoir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reservoir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reservoir().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField address;
    private javax.swing.JButton backEstimationBtn;
    private javax.swing.JComboBox calcTime;
    private javax.swing.ButtonGroup calculateTime;
    private javax.swing.JTextField currentLevelbox;
    public static com.toedter.calendar.JDateChooser datebox;
    private javax.swing.JTextField descriptiontxt;
    private javax.swing.JComboBox fuelNamebox;
    private javax.swing.JButton generatebtn;
    private javax.swing.JButton insertBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
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
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable2;
    public static javax.swing.JComboBox mYear;
    private javax.swing.JTabbedPane mainTab;
    private javax.swing.JLabel mainbackground;
    public static javax.swing.JTextField name;
    public static javax.swing.JTextField nic;
    private javax.swing.JLabel notice;
    private javax.swing.JTextField refillCurrentLevel;
    private com.toedter.calendar.JDateChooser refillDatebox;
    private javax.swing.JComboBox refillFuelbox;
    private javax.swing.JTable reportTable;
    private javax.swing.JComboBox searchMakebox;
    private javax.swing.JTextField searchNamebox;
    private javax.swing.JTable searchTable;
    private javax.swing.JComboBox searchTypebox;
    private com.toedter.calendar.JDateChooser selectDate;
    private javax.swing.JTextField sumOfProfit;
    public static javax.swing.JTextField telephone;
    private javax.swing.JLabel usagebox;
    public static javax.swing.JTextField vName;
    public static javax.swing.JTextField vNumber;
    private javax.swing.JTextField valuetxt;
    private javax.swing.JButton viewFuelDetailsBtn;
    private javax.swing.JTable viewFuelTable;
    // End of variables declaration//GEN-END:variables
    
   
    
    
    
       
}



