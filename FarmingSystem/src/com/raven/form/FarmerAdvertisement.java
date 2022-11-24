package com.raven.form;

import com.raven.dialog.Message;
import com.raven.main.Main;
import com.raven.swing.table.EventActionFarmerAdvertisement;
import farmingsystem.controller.AdvertisementImpl;
import farmingsystem.controller.OfferImpl;
import farmingsystem.model.Advertisement;
import farmingsystem.model.Offer;
import farmingsystem.model.User;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class FarmerAdvertisement extends javax.swing.JPanel {
    private User user;
    public FarmerAdvertisement(User user) {
        initComponents();
        this.user = user;
        tableFarmerAdvertisement1.fixTable(jScrollPane3);
        table2.fixTable(jScrollPane2);
        jPanel2.add(jScrollPane3);
        jPanel1.add(jScrollPane2);
        setOpaque(false);
        initData();
        tableFarmerAdvertisement1.removeColumn(tableFarmerAdvertisement1.getColumnModel().getColumn(0));
    }

    private void initData() {
        initTableData();
        
    }
   
    private void initTableData() {
        EventActionFarmerAdvertisement eventAction = new EventActionFarmerAdvertisement() {
            @Override
            public void offer(Advertisement advertisement) {
                if (showMessage("Make an Offer? for product " + advertisement.getCropName())) {
                    MakeOfferAdvertisement ads= new MakeOfferAdvertisement();
                    ads.setVisible(true);
                    ads.pack();
                    
                    AdvertisementImpl adver = new AdvertisementImpl();
                    
                    Advertisement advertise=adver.get(advertisement.getId());
                   
                    ads.textCropName.setText(String.valueOf(advertise.getCropName()));
                    ads.QuantityNeeded.setText(String.valueOf(advertise.getQuantityNeeded()));
                    ads.DateNeeded.setText(String.valueOf(advertise.getDate()));
                    ads.userId.setText(String.valueOf(user.getId()));
                    ads.adsID.setText(String.valueOf(advertise.getId()));
                } else {
                    System.out.println("User click Cancel");
                }
            }
        };
        //List of Available Advertisement
        AdvertisementImpl ads = new AdvertisementImpl();
        List<Advertisement> list = ads.list();
        for (Advertisement advertisement : list) {
            
            int sid = advertisement.getId();
            String userName=advertisement.getFullName();
            String cropname = advertisement.getCropName();
            double quantityNeeded = advertisement.getQuantityNeeded();
            String date = advertisement.getDate();
            String status=advertisement.getStatus();
            if("Pending Transaction".equals(advertisement.getStatus())){
                tableFarmerAdvertisement1.addRow(new Advertisement(sid,userName,cropname,quantityNeeded,date).toRowTable1(eventAction));
            }else if("Pending Offer".equals(advertisement.getStatus())){
                tableFarmerAdvertisement1.addRow(new Advertisement(sid,userName,cropname,quantityNeeded,date).toRowTable1(eventAction));
            }
        }
        
        
        OfferImpl offer = new OfferImpl();
        System.out.println(user.getId());
        List<Offer> listOffer = offer.searchByUserID(user.getId());
        DefaultTableModel DFT = (DefaultTableModel) table2.getModel();
        DFT.setRowCount(0);
        for (Offer off : listOffer) {
            String cropname = off.getCropName();
            double price = off.getPriceOffer();
            String status = off.getStatus();
            
                DFT.addRow(new Object[]{cropname,price,status});
                
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
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table2 = new com.raven.swing.table.Table();
        jPanel2 = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableFarmerAdvertisement1 = new com.raven.swing.table.TableFarmerAdvertisement();
        test = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(4, 72, 210));
        jLabel1.setText("Farmer / Advertisement");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(76, 76, 76));
        jLabel2.setText("Advertisement you offered");
        jLabel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Crop Name", "Price Offer", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(table2);
        if (table2.getColumnModel().getColumnCount() > 0) {
            table2.getColumnModel().getColumn(0).setPreferredWidth(-50);
            table2.getColumnModel().getColumn(1).setPreferredWidth(-20);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(220, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(39, 39, 39)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 689, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        title.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        title.setForeground(new java.awt.Color(76, 76, 76));
        title.setText("List of Advertisement");
        title.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        tableFarmerAdvertisement1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ads ID", "Supplier Name", "Crop Request", "Quantity Needed", "Date Needed", "Action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tableFarmerAdvertisement1);

        test.setText("jLabel3");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(title)
                        .addGap(165, 165, 165)
                        .addComponent(test)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(title)
                    .addComponent(test))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 694, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private com.raven.swing.table.Table table2;
    private com.raven.swing.table.TableFarmerAdvertisement tableFarmerAdvertisement1;
    private javax.swing.JLabel test;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
