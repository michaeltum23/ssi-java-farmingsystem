/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.raven.form;

import farmingsystem.controller.AdvertisementImpl;
import farmingsystem.controller.OfferImpl;
import farmingsystem.model.Advertisement;
import farmingsystem.model.Offer;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author jtamayo
 */
public class MakeOfferAdvertisement extends javax.swing.JFrame {
    /**
     * Creates new form SupplierDetails
     */
    public MakeOfferAdvertisement() {
        initComponents();
        this.setLocationRelativeTo(null);
        userId.setVisible(false);
        adsID.setVisible(false);
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGender = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        textCropName = new com.raven.swing.MyTextField();
        QuantityNeeded = new com.raven.swing.MyTextField();
        jLabel6 = new javax.swing.JLabel();
        DateNeeded = new com.raven.swing.MyTextField();
        cancelButton = new javax.swing.JButton();
        offerButton = new javax.swing.JButton();
        userId = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        adsID = new javax.swing.JLabel();
        priceOffer = new com.raven.swing.MyTextField();
        jLabel7 = new javax.swing.JLabel();
        test = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(59, 122, 87));
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(17, 129, 70));
        jLabel3.setText("Crop Name:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(17, 129, 70));
        jLabel4.setText("QuantityNeeded:");

        textCropName.setEditable(false);
        textCropName.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("")));
        textCropName.setFont(new java.awt.Font("sansserif", 0, 12)); // NOI18N
        textCropName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textCropNameActionPerformed(evt);
            }
        });

        QuantityNeeded.setEditable(false);
        QuantityNeeded.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("")));
        QuantityNeeded.setFont(new java.awt.Font("sansserif", 0, 12)); // NOI18N
        QuantityNeeded.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuantityNeededActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(17, 129, 70));
        jLabel6.setText("Date Needed:");

        DateNeeded.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("")));
        DateNeeded.setFont(new java.awt.Font("sansserif", 0, 12)); // NOI18N
        DateNeeded.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DateNeededActionPerformed(evt);
            }
        });

        cancelButton.setBackground(new java.awt.Color(17, 129, 70));
        cancelButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cancelButton.setForeground(new java.awt.Color(255, 255, 255));
        cancelButton.setText("Cancel");
        cancelButton.setBorder(null);
        cancelButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        offerButton.setBackground(new java.awt.Color(17, 129, 70));
        offerButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        offerButton.setForeground(new java.awt.Color(255, 255, 255));
        offerButton.setText("Offer");
        offerButton.setBorder(null);
        offerButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        offerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                offerButtonActionPerformed(evt);
            }
        });

        userId.setText("FarmerID");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(17, 129, 70));
        jLabel18.setText("Offer Advertisement");

        adsID.setText("AdsID");

        priceOffer.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("")));
        priceOffer.setFont(new java.awt.Font("sansserif", 0, 12)); // NOI18N
        priceOffer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceOfferActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(17, 129, 70));
        jLabel7.setText("Price Offer:");

        test.setText("jLabel1");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(296, 296, 296)
                                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(18, 18, 18)
                                    .addComponent(textCropName, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(test)
                                            .addComponent(jLabel6)))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(offerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(DateNeeded, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                                            .addComponent(QuantityNeeded, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(priceOffer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                        .addContainerGap(49, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(userId)
                            .addComponent(adsID))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel18)
                        .addGap(140, 140, 140))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(userId)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(adsID))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textCropName, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(QuantityNeeded, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(DateNeeded, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(priceOffer, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(offerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(test)))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textCropNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textCropNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textCropNameActionPerformed

    private void DateNeededActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DateNeededActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DateNeededActionPerformed

    private void QuantityNeededActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuantityNeededActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_QuantityNeededActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void offerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_offerButtonActionPerformed
        Offer offer = new Offer();
        Advertisement ads = new Advertisement();
        
        int userID = Integer.parseInt(userId.getText());
        int advertisementId = Integer.parseInt(adsID.getText());
        double offer_price = Double.parseDouble(priceOffer.getText());

        offer.setAdvertisementID(advertisementId);
        offer.setUserId(userID);
        offer.setPriceOffer(offer_price);
        
        ads.setStatus("Pending Transaction");
        ads.setId(advertisementId);
        
        OfferImpl offerImpl = new OfferImpl();
        try {
            if(offerImpl.validateOfferuser(userID,advertisementId)){               
                offerImpl.updateuserOffer(offer,ads);    
                this.dispose();
            }else{
                offerImpl.addOffer(offer,ads);
                this.dispose();
            }
        } catch (Exception ex) {
            Logger.getLogger(MakeOfferAdvertisement.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_offerButtonActionPerformed

    private void priceOfferActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceOfferActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceOfferActionPerformed

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
            java.util.logging.Logger.getLogger(MakeOfferAdvertisement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MakeOfferAdvertisement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MakeOfferAdvertisement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MakeOfferAdvertisement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MakeOfferAdvertisement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public com.raven.swing.MyTextField DateNeeded;
    public com.raven.swing.MyTextField QuantityNeeded;
    public javax.swing.JLabel adsID;
    public javax.swing.ButtonGroup buttonGender;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton offerButton;
    public com.raven.swing.MyTextField priceOffer;
    private javax.swing.JLabel test;
    public com.raven.swing.MyTextField textCropName;
    public javax.swing.JLabel userId;
    // End of variables declaration//GEN-END:variables
}
