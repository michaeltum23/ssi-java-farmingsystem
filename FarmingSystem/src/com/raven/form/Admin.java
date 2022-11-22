package com.raven.form;

import com.raven.dialog.Message;
import com.raven.main.Main;
import com.raven.model.ModelCard;
import com.raven.model.ModelStudent;
import com.raven.swing.icon.GoogleMaterialDesignIcons;
import com.raven.swing.icon.IconFontSwing;
import com.raven.swing.noticeboard.ModelNoticeBoard;
import com.raven.swing.table.EventAction;
import com.raven.swing.table.EventActionUser;
import farmingsystem.controller.UserImp;
import farmingsystem.model.User;
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

public class Admin extends javax.swing.JPanel {

    public Admin() {
        initComponents();
        table1.fixTable(jScrollPane1);
        setOpaque(false);
        initData();
    }

    private void initData() {
        initTableData();
    }

    private void initTableData() {
         EventActionUser eventAction = new EventActionUser() {
            @Override
            public void delete(User user) {
                if (showMessage("Delete Student : " + user.getFullName())) {
                    UserImp u = new UserImp();
                    user.setEmail(user.getEmail());
                    u.deleteUser(user);
                } else {
                    System.out.println("User click Cancel");
                }
            }

            @Override
            public void update(User user) {
                if (showMessage("Update Student : " + user.getFullName())) {
                    UserDetails supdets = new UserDetails();
                    supdets.setVisible(true);
                    supdets.pack();
                    
                    UserImp users =new UserImp();
                    
                    User u= users.get(user.getEmail());
                    
                    supdets.textFirstName.setText(String.valueOf(u.getFirstName()));
                    supdets.textMiddleName.setText(String.valueOf(u.getMiddleName()));
                    supdets.textLastName.setText(String.valueOf(u.getLastName()));
                    supdets.textBDate.setText(String.valueOf(u.getBirthDate()));
                    supdets.cmbCStatus.setSelectedItem(String.valueOf(u.getCivilStatus()));
                        if(u.getGender().equals("Male")){
                             supdets.buttonGender.setSelected(supdets.rbnMale.getModel(), true);
                        }else if(u.getGender().equals("Female")){
                            supdets.buttonGender.setSelected(supdets.rbnFemale.getModel(), true);
                        }
                    
                    supdets.textContactNo.setText(String.valueOf(u.getContactNumber()));
                    supdets.textEmail.setText(String.valueOf(u.getEmail()));
                    supdets.textHouseNo.setText(String.valueOf(u.getHouseNo()));
                    supdets.textStreet.setText(String.valueOf(u.getStreetAddress()));
                    supdets.cmbCity.setSelectedItem(String.valueOf(u.getCityAddress()));
                    supdets.cmbProvince.setSelectedItem(String.valueOf(u.getProvince()));
                    supdets.textPostalcode.setText(String.valueOf(u.getZipCode()));
                    
                    ImageIcon im = new ImageIcon(u.getUserImage());
                    Image image = im.getImage().getScaledInstance(249, 238, Image.SCALE_SMOOTH);
                    ImageIcon userImage = new ImageIcon(image);
                    supdets.profile.setIcon(userImage);
                } else {
                    System.out.println("User click Cancel");
                }
            }
        };
        UserImp user = new UserImp();
        List<User> list = user.list();
        table1.getColumn("Profile").setPreferredWidth(60);
        table1.getColumn("Profile").setCellRenderer(new Admin.myTableCellRenderer());
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
            if("Admin".equals(users.getUserType())){
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
            TableColumn tb = table1.getColumn("Profile");
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
        searchFiealds = new com.raven.swing.MyTextField();
        btnSearch = new javax.swing.JButton();
        btnSearch1 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(911, 645));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(4, 72, 210));
        jLabel1.setText("Dashboard / Admin");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(76, 76, 76));
        jLabel5.setText("List of Admin");
        jLabel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Profile", "Name", "Role", "Email", "Active", "Action"
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

        searchFiealds.setText("Search...");
        searchFiealds.setFont(new java.awt.Font("sansserif", 0, 12)); // NOI18N
        searchFiealds.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchFiealdsMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                searchFiealdsMousePressed(evt);
            }
        });
        searchFiealds.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFiealdsActionPerformed(evt);
            }
        });

        btnSearch.setBackground(new java.awt.Color(204, 204, 204));
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnSearch1.setBackground(new java.awt.Color(204, 204, 204));
        btnSearch1.setText("Add Admin");
        btnSearch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearch1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSearch1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(searchFiealds, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSearch)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 899, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnSearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(searchFiealds, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(btnSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 634, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(798, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(692, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(36, 36, 36)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 672, Short.MAX_VALUE)
                    .addContainerGap()))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void searchFiealdsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchFiealdsMouseClicked

    }//GEN-LAST:event_searchFiealdsMouseClicked

    private void searchFiealdsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchFiealdsMousePressed
        this.searchFiealds.setText("");
    }//GEN-LAST:event_searchFiealdsMousePressed

    private void searchFiealdsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFiealdsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchFiealdsActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        EventActionUser eventAction = new EventActionUser() {
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
                    UserDetails supdets = new UserDetails();
                    supdets.setVisible(true);
                    supdets.pack();

                    UserImp users =new UserImp();

                    User u= users.get(user.getEmail());

                    supdets.textFirstName.setText(String.valueOf(u.getFirstName()));
                    supdets.textMiddleName.setText(String.valueOf(u.getMiddleName()));
                    supdets.textLastName.setText(String.valueOf(u.getLastName()));
                    supdets.textBDate.setText(String.valueOf(u.getBirthDate()));
                    supdets.cmbCStatus.setSelectedItem(String.valueOf(u.getCivilStatus()));
                    if(u.getGender().equals("Male")){
                        supdets.buttonGender.setSelected(supdets.rbnMale.getModel(), true);
                    }else if(u.getGender().equals("Female")){
                        supdets.buttonGender.setSelected(supdets.rbnFemale.getModel(), true);
                    }

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
        String search = searchFiealds.getText();

        UserImp userImpl = new UserImp();
        List<User>list = userImpl.searchUser(search);
        DefaultTableModel DFT = (DefaultTableModel) table1.getModel();
        DFT.setRowCount(0);

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

            if("Admin".equals(users.getUserType())){
                table1.addRow(new User(lbl, fullName, userType,email, active).toRowTable(eventAction));
            }
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnSearch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearch1ActionPerformed
        AddAdmin add = new AddAdmin();
        add.setVisible(true);
        add.pack();
    }//GEN-LAST:event_btnSearch1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSearch1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private com.raven.swing.MyTextField searchFiealds;
    private com.raven.swing.table.Table table1;
    // End of variables declaration//GEN-END:variables
}
