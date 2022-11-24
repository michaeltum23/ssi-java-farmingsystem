package com.raven.form;

import com.raven.dialog.Message;
import com.raven.dialog.MessageCheckOut;
import com.raven.main.Main;
import com.raven.swing.table.EventActionAdvertisement;
import com.raven.swing.table.EventActionOffer;
import farmingsystem.controller.AdvertisementImpl;
import farmingsystem.controller.OfferImpl;
import farmingsystem.model.Advertisement;
import farmingsystem.model.Offer;
import farmingsystem.model.User;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class AdminAdvertisement extends javax.swing.JPanel {

    public AdminAdvertisement() {
        initComponents();

        tableAdvertisement1.fixTable(jScrollPane3);
        tableOffer1.fixTable(jScrollPane1);
        setOpaque(false);
        jPanel2.add(jScrollPane1);
        initData();
        tableAdvertisement1.removeColumn(tableAdvertisement1.getColumnModel().getColumn(0));
    }

    private void initData() {
        initTableData();
    }

    private void initTableData() {

        AdvertisementImpl ads = new AdvertisementImpl();
        List<Advertisement> list = ads.list();
        for (Advertisement advertisement : list) {

            String userName = advertisement.getFullName();
            int adsID = advertisement.getId();
            String cropname = advertisement.getCropName();
            double quantityNeeded = advertisement.getQuantityNeeded();
            String date = advertisement.getDate();
            String status = advertisement.getStatus();

            tableAdvertisement1.addRow(new Object[]{adsID, userName, cropname, quantityNeeded, date, status});

        }
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
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableOffer1 = new com.raven.swing.table.TableOffer();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        filterBtn = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableAdvertisement1 = new com.raven.swing.table.TableAdvertisement();

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(4, 72, 210));
        jLabel1.setText("Dashboard / Advertisement");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setOpaque(true);

        jLabel6.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(76, 76, 76));
        jLabel6.setText("List of Offers");
        jLabel6.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        tableOffer1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Farmer Name", "Price Offer"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableOffer1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 745, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(76, 76, 76));
        jLabel5.setText("List of Advertisement");
        jLabel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        filterBtn.setBackground(new java.awt.Color(204, 204, 204));
        filterBtn.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        filterBtn.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Pending Offer", "Pending Transaction", "Done" }));
        filterBtn.setBorder(null);
        filterBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterBtnActionPerformed(evt);
            }
        });

        tableAdvertisement1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ads ID", "Supplier Name", "Crop Request", "Quantity Needed", "Date Needed", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableAdvertisement1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableAdvertisement1MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tableAdvertisement1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(filterBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5)
                    .addComponent(filterBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 745, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void filterBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterBtnActionPerformed
        String filter = filterBtn.getSelectedItem().toString();

        AdvertisementImpl ads = new AdvertisementImpl();
        List<Advertisement> list = ads.list();
        DefaultTableModel DFT = (DefaultTableModel) tableAdvertisement1.getModel();
        DFT.setRowCount(0);
        for (Advertisement advertisement : list) {
            String userName = advertisement.getFullName();
            int adsID = advertisement.getId();
            String cropname = advertisement.getCropName();
            double quantityNeeded = advertisement.getQuantityNeeded();
            String date = advertisement.getDate();
            String status = advertisement.getStatus();

            if (filter.equals("Pending Offer")) {
                if ("Pending Offer".equals(advertisement.getStatus())) {
                    tableAdvertisement1.addRow(new Object[]{adsID, userName, cropname, quantityNeeded, date, status});
                }

            } else if (filter.equals("Pending Transaction")) {
                if ("Pending Transaction".equals(advertisement.getStatus())) {
                    tableAdvertisement1.addRow(new Object[]{adsID, userName, cropname, quantityNeeded, date, status});
                }
            } else if (filter.equals("Done")) {
                if ("Done".equals(advertisement.getStatus())) {
                    tableAdvertisement1.addRow(new Object[]{adsID, userName, cropname, quantityNeeded, date, status});
                }
            } else if (filter.equals("All")) {
                tableAdvertisement1.addRow(new Object[]{adsID, userName, cropname, quantityNeeded, date, status});
            }
        }


    }//GEN-LAST:event_filterBtnActionPerformed

    private void tableAdvertisement1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableAdvertisement1MouseClicked
        int i = tableAdvertisement1.getSelectedRow();

        TableModel model = tableAdvertisement1.getModel();
        String status = model.getValueAt(i, 5).toString();

        if (status.equals("Done")) {
            DefaultTableModel DFT = (DefaultTableModel) tableOffer1.getModel();
            DFT.setRowCount(0);
            tableOffer1.disable();
        } else {
            int adsId = (int) model.getValueAt(i, 0);

            OfferImpl offer = new OfferImpl();
            List<Offer> list = offer.list(adsId);
            DefaultTableModel DFT = (DefaultTableModel) tableOffer1.getModel();
            DFT.setRowCount(0);
            for (Offer offers : list) {

                String farmerName = offers.getFarmerName();
                double priceOffer = offers.getPriceOffer();

                tableOffer1.addRow(new Object[]{farmerName, priceOffer});

            }

        }
    }//GEN-LAST:event_tableAdvertisement1MouseClicked
    private boolean showMessageCheckOut(String message) {
        MessageCheckOut obj = new MessageCheckOut(Main.getFrames()[0], true);
        obj.showMessage(message);
        return obj.isOk();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox<String> filterBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private com.raven.swing.table.TableAdvertisement tableAdvertisement1;
    private com.raven.swing.table.TableOffer tableOffer1;
    // End of variables declaration//GEN-END:variables
}
