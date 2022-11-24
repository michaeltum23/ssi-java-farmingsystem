package com.raven.form;

import static com.raven.component.Header.usersession;
import com.raven.dialog.Message;
import com.raven.main.Main;
import com.raven.model.ModelCard;
import com.raven.model.ModelStudent;
import com.raven.swing.icon.GoogleMaterialDesignIcons;
import com.raven.swing.icon.IconFontSwing;
import com.raven.swing.noticeboard.ModelNoticeBoard;
import com.raven.swing.table.EventAction;
import farmingsystem.controller.ComplainImpl;
import farmingsystem.model.Complain;
import farmingsystem.model.Respond;
import java.awt.Color;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

public class SupplierComplain extends javax.swing.JPanel {
    
    private Complain complain;
    private Respond respond;
    public SupplierComplain() {
        
        initComponents();
        ComplainTable.fixTable(jScrollPane1);
        LoadComplain();
        setOpaque(false);
        initData();
    }
    public final void LoadComplain()
    {
        ComplainImpl complain = new ComplainImpl();
        List<Complain> list = complain.listAll();
        DefaultTableModel DFT = (DefaultTableModel) ComplainTable.getModel();
        DFT.setRowCount(0);
        for(Complain complains: list)
        {
            String status = complains.getStatus();
            int user = complains.getUser_id();
            int Id = complains.getId();
                       String message = complains.getMessage();  
           if(complains.getUser_id()==usersession){ 
            DFT.addRow(new Object[]{status,user,Id,message});
        }}
    }

    private void initData() {
        initCardData();
//        initNoticeBoard();
        initTableData();
    }

    private void initTableData() {
        EventAction eventAction = new EventAction() {
            @Override
            public void delete(ModelStudent student) {
                if (showMessage("Delete Student : " + student.getName())) {
                    System.out.println("User click OK");
                } else {
                    System.out.println("User click Cancel");
                }
            }

            @Override
            public void update(ModelStudent student) {
                if (showMessage("Update Student : " + student.getName())) {
                    System.out.println("User click OK");
                } else {
                    System.out.println("User click Cancel");
                }
            }
        };
  }

    private void initCardData() {
        Icon icon1 = IconFontSwing.buildIcon(GoogleMaterialDesignIcons.REPORT_PROBLEM, 60, new Color(255, 255, 255, 100), new Color(255, 255, 255, 15));
 }


    private boolean showMessage(String message) {
        Message obj = new Message(Main.getFrames()[0], true);
        obj.showMessage(message);
        return obj.isOk();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ComplainTable = new com.raven.swing.table.Table();
        filterbtn = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 51));
        jLabel1.setText("Dashboard / Complaints");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(76, 76, 76));
        jLabel5.setText("Complain List");
        jLabel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        ComplainTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Status", "User", "Order ID", "Message", "Action"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(ComplainTable);
        if (ComplainTable.getColumnModel().getColumnCount() > 0) {
            ComplainTable.getColumnModel().getColumn(0).setMinWidth(200);
            ComplainTable.getColumnModel().getColumn(0).setMaxWidth(200);
            ComplainTable.getColumnModel().getColumn(1).setMinWidth(100);
            ComplainTable.getColumnModel().getColumn(1).setMaxWidth(100);
            ComplainTable.getColumnModel().getColumn(2).setMinWidth(100);
            ComplainTable.getColumnModel().getColumn(2).setMaxWidth(100);
            ComplainTable.getColumnModel().getColumn(3).setMinWidth(500);
            ComplainTable.getColumnModel().getColumn(3).setMaxWidth(500);
        }

        filterbtn.setFont(new java.awt.Font("Sylfaen", 1, 12)); // NOI18N
        filterbtn.setForeground(new java.awt.Color(0, 102, 51));
        filterbtn.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "pending", "responded", "resolved", "failed", " " }));
        filterbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(169, 169, 169)
                        .addComponent(filterbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(filterbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(0, 102, 0));

        jLabel2.setFont(new java.awt.Font("Sylfaen", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("List Complaints By Status");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(324, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(263, 263, 263))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
         LoadComplain();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void filterbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterbtnActionPerformed

        String filter = filterbtn.getSelectedItem().toString();
        
        
        ComplainImpl complain = new ComplainImpl();
        List<Complain> list = complain.listAll();
        DefaultTableModel DFT = (DefaultTableModel) ComplainTable.getModel();
        DFT.setRowCount(0);
        
//        for(Complain complains: list){
//            String status = complains.getStatus();
//            int user = complains.getUser_id();
//            int Id = complains.getId();
//             String message = complains.getMessage();  
//           if(complains.getUser_id()==usersession){ 
//            DFT.addRow(new Object[]{status,user,Id,message});}
//        }

           if(filter.equals("pending")){
                for(Complain complains: list){
                if("Pending".equals(complains.getStatus())){
                  String status = complains.getStatus();
            int user = complains.getUser_id();
            int Id = complains.getId();
             String message = complains.getMessage();  
           if(complains.getUser_id()==usersession){ 
            DFT.addRow(new Object[]{status,user,Id,message});}
             } } } 
           
           if(filter.equals("resolved")){
                for(Complain complains: list){
                if("Resolved".equals(complains.getStatus())){
                  String status = complains.getStatus();
            int user = complains.getUser_id();
            int Id = complains.getId();
             String message = complains.getMessage();  
           if(complains.getUser_id()==usersession){ 
            DFT.addRow(new Object[]{status,user,Id,message});}
             } } } 
           
           if(filter.equals("responded")){
                for(Complain complains: list){
                if("Responded".equals(complains.getStatus())){
                  String status = complains.getStatus();
            int user = complains.getUser_id();
            int Id = complains.getId();
             String message = complains.getMessage();  
           if(complains.getUser_id()==usersession){ 
            DFT.addRow(new Object[]{status,user,Id,message});}
             } } } 
        
        if(filter.equals("failed")){
                for(Complain complains: list){
                if("Failed".equals(complains.getStatus())){
                  String status = complains.getStatus();
            int user = complains.getUser_id();
            int Id = complains.getId();
             String message = complains.getMessage();  
           if(complains.getUser_id()==usersession){ 
            DFT.addRow(new Object[]{status,user,Id,message});}
             } } } 
        
    }//GEN-LAST:event_filterbtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.swing.table.Table ComplainTable;
    private javax.swing.JComboBox<String> filterbtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
