package com.raven.form;

import com.raven.dialog.Message;
import com.raven.main.Main;
import com.raven.model.ModelCard;
import com.raven.swing.icon.GoogleMaterialDesignIcons;
import com.raven.swing.icon.IconFontSwing;
import com.raven.swing.table.EventActionCart;
import com.raven.swing.table.EventActionYourCart;
import farmingsystem.controller.CropsImpl;
import farmingsystem.controller.OrderImpl;
import farmingsystem.controller.UserImp;
import farmingsystem.model.Crops;
import farmingsystem.model.Order;
import farmingsystem.model.User;
import farmingsystem.view.UpdateUser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

public class SupplierHome extends javax.swing.JPanel {

    private User users;
    private Order order;
    private OrderImpl oi;

    public SupplierHome(User user) {
        this.users = user;
        initComponents();
        tableCart1.fixTable(jScrollPane1);
        tableYourCart1.fixTable(jScrollPane1);
//        lblFullName.setText(user.getFirstName() + " " + user.getLastName());
        setOpaque(false);
        initData();
        tableYourCart1.removeColumn(tableYourCart1.getColumnModel().getColumn(0));
        getSum();
    }

    private void initData() {
        initCardData();
        initTableData();
        initTableDataYourCart();
    }

    public void getSum() {
        int sum = 0;
        int init = 0;
        if (tableYourCart1.getRowCount() == 0) {
            textTotal.setText(init + "");
        }
        for (int i = 0; i < tableYourCart1.getRowCount(); i++) {
            sum += Double.parseDouble(tableYourCart1.getValueAt(i, 2) + "");
            textTotal.setText(sum + ".00");
        }
    }

    private void initTableData() {
        EventActionCart eventAction = new EventActionCart() {
            @Override
            public void update(Crops crops) {
                if (showMessage("Add to your cart?")) {
                    TableModel model1 = tableCart1.getModel();
                    int[] getSelectedRows = tableCart1.getSelectedRows();
                    Object[] row = new Object[5];
                    DefaultTableModel model2 = (DefaultTableModel) tableYourCart1.getModel();
                    for (int i = 0; i < getSelectedRows.length; i++) {
                        row[0] = model1.getValueAt(getSelectedRows[i], 0);
                        row[1] = model1.getValueAt(getSelectedRows[i], 1);
                        row[2] = model1.getValueAt(getSelectedRows[i], 2);
                        row[3] = model1.getValueAt(getSelectedRows[i], 3);
                        row[4] = 1;
                        order = new Order();
                        order.setSellerId((int) row[0]);
                        order.setProductName(String.valueOf(row[1]));
                        order.setSellerName(String.valueOf(row[2]));
                        order.setUnitPrice((double) row[3]);
                        order.setQuantity((int) row[4]);
                        model2.addRow(row);
                        oi = new OrderImpl();
                        oi.addCart(order, users);
                    }
                    getSum();
                } else {
                    System.out.println("User click Cancel");
                }
            }
        };
        CropsImpl crops = new CropsImpl();
        List<Crops> list = crops.list();
        tableCart1.getColumn("Image").setPreferredWidth(60);
        tableCart1.getColumn("Image").setCellRenderer(new myTableCellRenderer());
        for (Crops crop : list) {
            int cropId = crop.getId();
            String cropName = crop.getCropName();
            String farmerName = crop.getFullName();
            double price = crop.getPrice();
            double quantity = crop.getQuantity();
            ImageIcon im = new ImageIcon(crop.getCropImageData());
            Image image = im.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
            ImageIcon userImage = new ImageIcon(image);
            JLabel lbl = new JLabel();
            lbl.setIcon(userImage);
//            table1.addRow(new Object[]{cropName, farmerName, price, quantity, lbl});
            tableCart1.addRow(new Crops(cropId, cropName, farmerName, price, quantity, lbl).toRowTable1(eventAction));
        }
        //  table1.addRow(new ModelStudent(new ImageIcon(getClass().getResource("/com/raven/icon/profile.jpg")), "Jonh", "Male", "Java", 300).toRowTable(eventAction));
    }

    private void initTableDataYourCart() {
        EventActionYourCart eventAction = new EventActionYourCart() {
            @Override
            public void Add(Order order) {
                if (showMessage("Add Quantity?")) {

                } else {
                    System.out.println("User click Cancel");
                }
            }

            @Override
            public void Minus(Order order) {
                if (showMessage("Deduct Quantity ")) {

                } else {
                    System.out.println("User click Cancel");
                }
            }

            @Override
            public void RemoveCart(Order order) {
                if (showMessage("Remove from cart?")) {

                } else {
                    System.out.println("User click Cancel");
                }
            }
        };
        OrderImpl cartAt = new OrderImpl();
        List<Order> listCart = cartAt.listCart(users);
        for (Order order : listCart) {
            int id = order.getOrderId();
            String seller = order.getSellerName();
            String cropName = order.getProductName();
            double price = order.getUnitPrice();
            double quantity = order.getQuantity();
            tableYourCart1.addRow(new Order(id, cropName, seller, price, quantity).toRowTable(eventAction));
        }

    }

    class myTableCellRenderer implements TableCellRenderer {

        public Component getTableCellRendererComponent(JTable table,
                Object value,
                boolean isSelected,
                boolean hasFocus,
                int row,
                int column) {
            TableColumn tb = tableCart1.getColumn("Image");
            tb.setMaxWidth(60);
            tableCart1.setRowHeight(60);
            return (Component) value;
        }
    }

    private void initCardData() {
        UserImp ui = new UserImp();
        Icon icon1 = IconFontSwing.buildIcon(GoogleMaterialDesignIcons.PEOPLE, 60, new Color(255, 255, 255, 100), new Color(255, 255, 255, 15));
        card1.setData(new ModelCard("Pending Transactions", 100, 20, icon1));
        Icon icon2 = IconFontSwing.buildIcon(GoogleMaterialDesignIcons.MONETIZATION_ON, 60, new Color(255, 255, 255, 100), new Color(255, 255, 255, 15));
        card2.setData(new ModelCard("Pending Order", 2000, 60, icon2));
        Icon icon3 = IconFontSwing.buildIcon(GoogleMaterialDesignIcons.SHOPPING_BASKET, 60, new Color(255, 255, 255, 100), new Color(255, 255, 255, 15));
        card3.setData(new ModelCard("Pending Delivery", 3000, 80, icon3));
        Icon icon4 = IconFontSwing.buildIcon(GoogleMaterialDesignIcons.BUSINESS_CENTER, 60, new Color(255, 255, 255, 100), new Color(255, 255, 255, 15));
        card4.setData(new ModelCard("Pending Response", 550, 95, icon4));
    }

    private boolean showMessage(String message) {
        Message obj = new Message(Main.getFrames()[0], true);
        obj.showMessage(message);
        return obj.isOk();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        card1 = new com.raven.component.Card();
        jLabel1 = new javax.swing.JLabel();
        card2 = new com.raven.component.Card();
        card3 = new com.raven.component.Card();
        card4 = new com.raven.component.Card();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCart1 = new com.raven.swing.table.TableCart();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        textTotal = new com.raven.swing.MyTextField();
        btnPay = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableYourCart1 = new com.raven.swing.table.TableYourCart();

        card1.setBackground(new java.awt.Color(59, 122, 87));
        card1.setColorGradient(new java.awt.Color(0, 102, 51));
        card1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                card1MouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(4, 72, 210));
        jLabel1.setText("Dashboard / Home");

        card2.setBackground(new java.awt.Color(59, 122, 87));
        card2.setColorGradient(new java.awt.Color(0, 102, 51));

        card3.setBackground(new java.awt.Color(59, 122, 87));
        card3.setColorGradient(new java.awt.Color(0, 102, 51));

        card4.setBackground(new java.awt.Color(59, 122, 87));
        card4.setColorGradient(new java.awt.Color(0, 102, 51));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(76, 76, 76));
        jLabel5.setText("Product");
        jLabel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        tableCart1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Crop ID", "Crop Name", "Seller", "Price", "Quantity", "Image", "Action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableCart1);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 590, 530));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setOpaque(true);

        jLabel6.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(76, 76, 76));
        jLabel6.setText("Your Cart");
        jLabel6.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Total:");

        textTotal.setEditable(false);
        textTotal.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        textTotal.setMinimumSize(new java.awt.Dimension(64, 64));

        btnPay.setBackground(new java.awt.Color(204, 204, 204));
        btnPay.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnPay.setText("PAY NOW");
        btnPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPayActionPerformed(evt);
            }
        });

        tableYourCart1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Crop Id", "Crop Name", "Seller", "Price", "Quantity", "Action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tableYourCart1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPay, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(22, 22, 22))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPay, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(card1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(card2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(card3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(card4, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(card1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void card1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_card1MouseClicked
        // TODO add your handling code here:
        UpdateUser user = new UpdateUser();
        user.setVisible(true);
    }//GEN-LAST:event_card1MouseClicked

    private void btnPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPayActionPerformed
        oi = new OrderImpl();
        order = new Order();
        DefaultTableModel model2 = (DefaultTableModel) tableYourCart1.getModel();;
        if (showMessage("Purchase your order?")) {
            for (int i = 0; i < tableYourCart1.getRowCount(); i++) {
                order.setSellerId(Integer.parseInt(model2.getValueAt(i, 0).toString()));
                order.setProductName(model2.getValueAt(i, 1).toString());
                order.setSellerName(model2.getValueAt(i, 2).toString());
                order.setUnitPrice(Double.parseDouble(model2.getValueAt(i, 3).toString()));
                order.setQuantity(Double.parseDouble(model2.getValueAt(i, 4).toString()));
                oi.addOrder(order, users);
            }
            System.out.println(users.getId());
            oi.deleteCart(users);
        } else {
            return;
        }
    }//GEN-LAST:event_btnPayActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPay;
    private com.raven.component.Card card1;
    private com.raven.component.Card card2;
    private com.raven.component.Card card3;
    private com.raven.component.Card card4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private com.raven.swing.table.TableCart tableCart1;
    private com.raven.swing.table.TableYourCart tableYourCart1;
    private com.raven.swing.MyTextField textTotal;
    // End of variables declaration//GEN-END:variables
}
