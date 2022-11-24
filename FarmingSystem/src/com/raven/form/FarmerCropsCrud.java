package com.raven.form;

import com.raven.dialog.Message;
import com.raven.main.Main;
import farmingsystem.controller.CropsImpl;
import farmingsystem.model.Crops;
import farmingsystem.model.User;
import java.util.List;
import com.raven.swing.table.EventActionCrops;
import java.awt.Component;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;



public class FarmerCropsCrud extends javax.swing.JPanel {
private User user;
    public FarmerCropsCrud(User user) {
        this.user = user;
        initComponents();
        table21.fixTable(jScrollPane1);
        jPanel2.add(jScrollPane1);
        setOpaque(false);
        initData();
        table21.removeColumn(table21.getColumnModel().getColumn(1));
    }

    private void initData() {
        
        initTableData();
    }
    
  private void initTableData() {
         EventActionCrops eventAction = new EventActionCrops() {
            @Override
            public void delete(Crops crops) {
                if (showMessage("Delete Crops : " )) {
                    CropsImpl c = new CropsImpl();
                    crops.setId(crops.getId());
                    c.deleteCrops(crops);
                } else {
                    System.out.println("User click Cancel");
                }
            }

            @Override
            public void update(Crops crops) {
                if (showMessage("Update Crops : ")) {
                    UpdateCrops update = new UpdateCrops();
                    update.jLabel1.setText(String.valueOf(crops.getId()));
                    
                    update.setVisible(true);
                    update.pack();
                    
                    CropsImpl users =new CropsImpl();
                    
                    Crops u= users.get(crops.getId());

                    update.textCropName.setText(String.valueOf(u.getCropName()));
                    update.textPrice.setText(String.valueOf(u.getPrice()));
                    update.textQuantity.setText(String.valueOf(u.getQuantity()));           
                    ImageIcon im = new ImageIcon(u.getCropImageData());
                    Image image = im.getImage().getScaledInstance(249, 238, Image.SCALE_SMOOTH);
                    ImageIcon userImage = new ImageIcon(image);
                    update.profile.setIcon(userImage);
                } else {
                    System.out.println("User click Cancel");
                }
            }
        };
        CropsImpl crops = new CropsImpl();
        List<Crops> list = crops.searchCropsByUserID(user.getId());
        table21.getColumn("Image").setPreferredWidth(120);
        table21.getColumn("Image").setCellRenderer(new FarmerCropsCrud.myTableCellRenderer());
        for (Crops crop : list) {
            
            int id = crop.getId();
            String cropName = crop.getCropName();
            double price = crop.getPrice();
            double quantity = crop.getQuantity();
            
            ImageIcon im = new ImageIcon(crop.getCropImageData());
            Image image = im.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
            ImageIcon userImage = new ImageIcon(image);
            
            JLabel lbl = new JLabel();
            lbl.setIcon(userImage);
           
                table21.addRow(new Crops(lbl,id,cropName,price,quantity).toRowTable(eventAction));
 
        }
    }

    class myTableCellRenderer implements TableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table,
                Object value,
                boolean isSelected,
                boolean hasFocus,
                int row,
                int column) {
            TableColumn tb = table21.getColumn("Image");
            tb.setMaxWidth(120);
            table21.setRowHeight(120);
            
            return (Component) value;
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
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        button1 = new com.raven.swing.Button();
        jScrollPane1 = new javax.swing.JScrollPane();
        table21 = new com.raven.swing.table.TableCrops();

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(4, 72, 210));
        jLabel1.setText("Dashboard / Crops");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(76, 76, 76));
        jLabel5.setText("List of Crops");
        jLabel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        button1.setBackground(new java.awt.Color(204, 204, 204));
        button1.setText("Add Crops");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        table21.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Image", "id", "Crops Name", "Price", "Quantity", "Action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table21);
        if (table21.getColumnModel().getColumnCount() > 0) {
            table21.getColumnModel().getColumn(5).setPreferredWidth(-50);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5))
                    .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 785, Short.MAX_VALUE)
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
                        .addGap(0, 940, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        AddCrops add = new AddCrops();
        add.jLabel1.setText(String.valueOf(user.getId()));
        add.setVisible(true);
        add.pack();
    }//GEN-LAST:event_button1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.swing.Button button1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private com.raven.swing.table.TableCrops table21;
    // End of variables declaration//GEN-END:variables
}
