package com.raven.form;

import com.raven.dialog.Message;
import com.raven.main.Main;
import com.raven.swing.table.EventActionSupplier;
import farmingsystem.controller.UserImp;
import farmingsystem.model.User;
import java.awt.Component;
import java.awt.Image;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

public class Supplier extends javax.swing.JPanel {

    public Supplier() {
        initComponents();
        table1.fixTable(jScrollPane1);
        setOpaque(false);
        initData();
    }

    private void initData() {
        initTableData();
    }
    
    private void initTableData() {
        EventActionSupplier eventAction = new EventActionSupplier() {
            @Override
            public void delete(User user) {
                if (showMessage("Delete Supplier : " + user.getFullName())) {
                    
                    UserImp u = new UserImp();
                    user.setEmail(user.getEmail());
                    u.deleteUser(user);
                } else {
                    System.out.println("User click Cancel");
                }
            }

            @Override
            public void update(User user) {
                if (showMessage("Update Supplier : " +  user.getFullName())) {
                    SupplierDetails supdets = new SupplierDetails();
                    supdets.setVisible(true);
                    supdets.pack();
                    
                    UserImp users =new UserImp();
                    
                    User u= users.get(user.getEmail());
                    
                    supdets.textFirstName.setText(String.valueOf(u.getFirstName()));
                    supdets.textMiddleName.setText(String.valueOf(u.getMiddleName()));
                    supdets.textLastName.setText(String.valueOf(u.getLastName()));
                    supdets.textBDate.setText(String.valueOf(u.getBirthDate()));
                    supdets.cmbCStatus.setSelectedItem(String.valueOf(u.getCivilStatus()));
//                    supdets.buttonGender.setSelected(u.getGender(), true);
                    supdets.textContactNo.setText(String.valueOf(u.getContactNumber()));
                    supdets.textEmail.setText(String.valueOf(u.getEmail()));
                    supdets.textHouseNo.setText(String.valueOf(u.getHouseNo()));
                    supdets.textStreet.setText(String.valueOf(u.getStreetAddress()));
                    supdets.cmbCity.setSelectedItem(String.valueOf(u.getCityAddress()));
                    supdets.cmbProvince.setSelectedItem(String.valueOf(u.getProvince()));
                    supdets.textPostalcode.setText(String.valueOf(u.getZipCode()));
                    
                    ImageIcon im = new ImageIcon(u.getUserImage());
                    Image image = im.getImage().getScaledInstance(249, 290, Image.SCALE_SMOOTH);
                    ImageIcon userImage = new ImageIcon(image);
                    supdets.profile.setIcon(userImage);
                    
                } else {
                    System.out.println("User click Cancel");
                }
            }
        };
        UserImp user = new UserImp();
        List<User> list = user.list();
        table1.getColumn("Image").setPreferredWidth(60);
        table1.getColumn("Image").setCellRenderer(new myTableCellRenderer());
        for (User users : list) {

            String fullName = users.getLastName() + "," + users.getFirstName();
            String userType = users.getUserType();
            String email = users.getEmail();
            Boolean active = users.getActive();
            ImageIcon im = new ImageIcon(users.getUserImage());
            Image image = im.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
            ImageIcon userImage = new ImageIcon(image);
            JLabel lbl = new JLabel();
            lbl.setIcon(userImage);
            if("Supplier".equals(users.getUserType())){
                table1.addRow(new User(lbl, fullName, userType,email, active).toRowTable(eventAction));
            }
        }
    }
    class myTableCellRenderer implements TableCellRenderer {

        public Component getTableCellRendererComponent(JTable table,
                Object value,
                boolean isSelected,
                boolean hasFocus,
                int row,
                int column) {
            TableColumn tb = table1.getColumn("Image");
            tb.setMaxWidth(60);
            table1.setRowHeight(60);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new com.raven.swing.table.Table();

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(4, 72, 210));
        jLabel1.setText("Dashboard / Supplier");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(76, 76, 76));
        jLabel5.setText("List of Supplier");
        jLabel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Image", "Name", "Role", "Email", "Active", "Action"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table1);
        if (table1.getColumnModel().getColumnCount() > 0) {
            table1.getColumnModel().getColumn(1).setPreferredWidth(150);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE)
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
                        .addGap(0, 781, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private com.raven.swing.table.Table table1;
    // End of variables declaration//GEN-END:variables
}
