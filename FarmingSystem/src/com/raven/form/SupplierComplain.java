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
import farmingsystem.model.User;
import java.awt.Color;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

public class SupplierComplain extends javax.swing.JPanel {
    
    private Complain complain;
    private Respond respond;
    private User user;
    public SupplierComplain(User user) {
        this.user=user;
        initComponents();
        tableSupplierComplain1.fixTable(jScrollPane2);
        LoadComplain();
        setOpaque(false);
        initData();
    }
    public final void LoadComplain()
    {
        ComplainImpl complain = new ComplainImpl();
        List<Complain> list = complain.listAll();
        DefaultTableModel DFT = (DefaultTableModel) tableSupplierComplain1.getModel();
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
        filterbtn = new javax.swing.JComboBox<>();
        filterBtn1 = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableSupplierComplain1 = new com.raven.swing.table.TableSupplierComplain();
        btnAddAds = new javax.swing.JButton();

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

        filterbtn.setFont(new java.awt.Font("Sylfaen", 1, 12)); // NOI18N
        filterbtn.setForeground(new java.awt.Color(0, 102, 51));
        filterbtn.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "pending", "responded", "resolved", "failed", "" }));
        filterbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterbtnActionPerformed(evt);
            }
        });

        filterBtn1.setBackground(new java.awt.Color(204, 204, 204));
        filterBtn1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        filterBtn1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "pending", "responded", "resolved", "failed", "" }));
        filterBtn1.setBorder(null);
        filterBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterBtn1ActionPerformed(evt);
            }
        });

        tableSupplierComplain1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "training id", "Ticket No", "Crop Mame", "Message", "Status", "Action"
            }
        ));
        jScrollPane2.setViewportView(tableSupplierComplain1);

        btnAddAds.setBackground(new java.awt.Color(204, 204, 204));
        btnAddAds.setText("Add Complain");
        btnAddAds.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddAdsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAddAds)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 551, Short.MAX_VALUE)
                        .addComponent(filterbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(filterBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(filterBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(filterbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAddAds, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5))
                .addGap(8, 8, 8)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 642, Short.MAX_VALUE)
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
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
         LoadComplain();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void filterBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterBtn1ActionPerformed
//        String filter = filterBtn.getSelectedItem().toString();
//
//        EventActionAdvertisement eventAction = new EventActionAdvertisement() {
//            @Override
//            public void delete(Advertisement advertisement) {
//                if (showMessage("Delete Advertisement : " + advertisement.getCropName())) {
//
//                } else {
//                    System.out.println("User click Cancel");
//                }
//            }
//
//            @Override
//            public void update(Advertisement advertisement) {
//                if (showMessage("Update Advertisement : " + advertisement.getCropName())) {
//                    UpdateAdvertisement ads= new UpdateAdvertisement();
//                    ads.setVisible(true);
//                    ads.pack();
//
//                    AdvertisementImpl adver = new AdvertisementImpl();
//
//                    Advertisement advertise=adver.get(advertisement.getId());
//
//                    ads.textCropName.setText(String.valueOf(advertise.getCropName()));
//                    ads.QuantityNeeded.setText(String.valueOf(advertise.getQuantityNeeded()));
//                    ads.DateNeeded.setText(String.valueOf(advertise.getDate()));
//                    ads.userId.setText(String.valueOf(user.getId()));
//                    ads.cropID.setText(String.valueOf(advertise.getId()));
//                } else {
//                    System.out.println("User click Cancel");
//                }
//            }
//        };
//        AdvertisementImpl ads = new AdvertisementImpl();
//        List<Advertisement> list = ads.searchAdvertisementByUserID(user.getId());
//        DefaultTableModel DFT = (DefaultTableModel) tableAdvertisement1.getModel();
//        DFT.setRowCount(0);
//        for (Advertisement advertisement : list) {
//            int adsID = advertisement.getId();
//            String cropname = advertisement.getCropName();
//            double quantityNeeded = advertisement.getQuantityNeeded();
//            String date = advertisement.getDate();
//            String status = advertisement.getStatus();
//
//            if(filter.equals("Pending Offer")){
//                if("Pending Offer".equals(advertisement.getStatus()))
//                tableAdvertisement1.addRow(new Advertisement(adsID,cropname,quantityNeeded,date,status).toRowTable(eventAction));
//
//            }else if(filter.equals("Pending Transaction")){
//                if("Pending Transaction".equals(advertisement.getStatus()))
//                tableAdvertisement1.addRow(new Advertisement(adsID,cropname,quantityNeeded,date,status).toRowTable(eventAction));
//            }else if(filter.equals("Done")){
//                if("Done".equals(advertisement.getStatus()))
//                tableAdvertisement1.addRow(new Advertisement(adsID,cropname,quantityNeeded,date,status).toRowTable(eventAction));
//            }else if(filter.equals("All")){
//                tableAdvertisement1.addRow(new Advertisement(adsID,cropname,quantityNeeded,date,status).toRowTable(eventAction));
//            }
//        }

    }//GEN-LAST:event_filterBtn1ActionPerformed

    private void filterbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterbtnActionPerformed

        String filter = filterbtn.getSelectedItem().toString();

        ComplainImpl complain = new ComplainImpl();
        List<Complain> list = complain.listAll();
        DefaultTableModel DFT = (DefaultTableModel) tableSupplierComplain1.getModel();
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

    private void btnAddAdsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddAdsActionPerformed
        AddSupplierComplain add = new AddSupplierComplain();
        add.userID.setText(String.valueOf(user.getId()));
        add.setVisible(true);
        add.pack();
    }//GEN-LAST:event_btnAddAdsActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddAds;
    public javax.swing.JComboBox<String> filterBtn;
    public javax.swing.JComboBox<String> filterBtn1;
    private javax.swing.JComboBox<String> filterbtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private com.raven.swing.table.TableSupplierComplain tableSupplierComplain1;
    // End of variables declaration//GEN-END:variables
}
