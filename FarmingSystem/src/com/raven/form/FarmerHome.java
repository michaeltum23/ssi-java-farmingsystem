package com.raven.form;

import com.raven.dialog.Message;
import com.raven.main.Main;
import com.raven.model.ModelCard;
import com.raven.model.ModelStudent;
import com.raven.swing.icon.GoogleMaterialDesignIcons;
import com.raven.swing.icon.IconFontSwing;
import com.raven.swing.table.EventAction;
import farmingsystem.controller.UserImp;
import farmingsystem.model.User;
import farmingsystem.view.UpdateUser;
import java.awt.Color;
import java.awt.Image;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class FarmerHome extends javax.swing.JPanel {
    
    private User users;

    public FarmerHome(User user) {
        this.users = user;
        initComponents();
////        table1.fixTable(jScrollPane1);
      
        lblFullName.setText(user.getFirstName() + " " + user.getLastName());
        lblEmail.setText(user.getEmail());
        lblPhone.setText("63"+user.getContactNumber());
        
        String province = String.valueOf(user.getProvince());
        if (province.equalsIgnoreCase("null")){
            lblProvince.setText("Add province ");
            
        }
        else{
            lblProvince.setText("Provice "+user.getProvince());
        
        }
           
        lblCityAddress.setText("Lives at "+user.getCityAddress());
        lblStreetAddress.setText("Resident of "+user.getStreetAddress());
        lblHouseNo.setText("House No. "+user.getHouseNo());
        
        
        ImageIcon im = new ImageIcon(users.getUserImage());
        Image image = im.getImage().getScaledInstance(205, 200, Image.SCALE_SMOOTH);
        ImageIcon userImage = new ImageIcon(image);
        userProfilePic.setIcon(userImage);
        
        ImageIcon ic1 = new ImageIcon(getClass().getResource("/com/raven/icon/email.png"));
        Image icImage = ic1.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon emailIcon = new ImageIcon(icImage);
        lblEmailIcon.setIcon(emailIcon);
        
        ImageIcon ic2 = new ImageIcon(getClass().getResource("/com/raven/icon/phone-call.png"));
        Image icImage2 = ic2.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon phoneIcon = new ImageIcon(icImage2);
        lblPhoneIcon.setIcon(phoneIcon);
        
        ImageIcon ic3 = new ImageIcon(getClass().getResource("/com/raven/icon/messenger.png"));
        Image icImage3 = ic3.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon chatIcon = new ImageIcon(icImage3);
        lblChatIcon.setIcon(chatIcon);
        
        ImageIcon ic4 = new ImageIcon(getClass().getResource("/com/raven/icon/location.png"));
        Image icImage4 = ic4.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon locationIcon = new ImageIcon(icImage4);
        lblLocationIcon1.setIcon(locationIcon);
        
        ImageIcon ic5 = new ImageIcon(getClass().getResource("/com/raven/icon/pin.png"));
        Image icImage5 = ic5.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon cityIcon = new ImageIcon(icImage5);
        lblCityIcon.setIcon(cityIcon);
        setOpaque(false);
        initData();
    }
    
    public FarmerHome() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    private void initData() {
        initCardData();
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
        UserImp user = new UserImp();
        List<User> list = user.list();
//        table1.getColumn("Image").setPreferredWidth(60);
//        table1.getColumn("Image").setCellRenderer(new myTableCellRenderer());
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
//            table1.addRow(new Object[]{lbl, fullName, userType, email, active});

        }
        //  table1.addRow(new ModelStudent(new ImageIcon(getClass().getResource("/com/raven/icon/profile.jpg")), "Jonh", "Male", "Java", 300).toRowTable(eventAction));
    }

//    class myTableCellRenderer implements TableCellRenderer {
//
//        public Component getTableCellRendererComponent(JTable table,
//                Object value,
//                boolean isSelected,
//                boolean hasFocus,
//                int row,
//                int column) {
//            TableColumn tb = table1.getColumn("Image");
//            tb.setMaxWidth(60);
//            table1.setRowHeight(60);
//            return (Component) value;
//        }
//    }
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
        Jpanel = new javax.swing.JPanel();
        userProfilePic = new javax.swing.JLabel();
        lblFullName = new javax.swing.JLabel();
        lblStreetAddress = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblPhone = new javax.swing.JLabel();
        lblCityAddress = new javax.swing.JLabel();
        lblCityIcon = new javax.swing.JLabel();
        lblHouseNo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblPhoneIcon = new javax.swing.JLabel();
        lblEmailIcon = new javax.swing.JLabel();
        lblChatIcon = new javax.swing.JLabel();
        lblCityAddress1 = new javax.swing.JLabel();
        lblProvince = new javax.swing.JLabel();
        lblLocationIcon1 = new javax.swing.JLabel();

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
        jLabel5.setText("Users Data");
        jLabel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        userProfilePic.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout JpanelLayout = new javax.swing.GroupLayout(Jpanel);
        Jpanel.setLayout(JpanelLayout);
        JpanelLayout.setHorizontalGroup(
            JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(userProfilePic, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
        );
        JpanelLayout.setVerticalGroup(
            JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(userProfilePic, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
        );

        jPanel2.add(Jpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 46, -1, -1));

        lblFullName.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblFullName.setText("Users full name");
        jPanel2.add(lblFullName, new org.netbeans.lib.awtextra.AbsoluteConstraints(239, 82, -1, -1));

        lblStreetAddress.setBackground(new java.awt.Color(204, 204, 204));
        lblStreetAddress.setFont(new java.awt.Font("SansSerif", 2, 14)); // NOI18N
        lblStreetAddress.setForeground(new java.awt.Color(102, 102, 102));
        lblStreetAddress.setText("Street Address");
        jPanel2.add(lblStreetAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 190, 210, 20));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setText("Random Farming Tips");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(776, 82, -1, -1));

        jButton1.setBackground(new java.awt.Color(0, 102, 51));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/farmer.png"))); // NOI18N
        jButton1.setText("EDIT  PROFILE");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 413, 240, 144));

        jButton2.setBackground(new java.awt.Color(0, 102, 51));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/farmer.png"))); // NOI18N
        jButton2.setText("ADD CROPS");
        jButton2.setBorder(null);
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(268, 413, 240, 144));

        jButton5.setBackground(new java.awt.Color(0, 102, 51));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/farmer.png"))); // NOI18N
        jButton5.setText("OFFER CROPS");
        jButton5.setBorder(null);
        jPanel2.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(522, 413, 240, 144));

        jButton6.setBackground(new java.awt.Color(0, 102, 51));
        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/farmer.png"))); // NOI18N
        jButton6.setText("COMPLAINTS");
        jButton6.setBorder(null);
        jPanel2.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(778, 413, 240, 144));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel18.setText("0");

        jLabel19.setText("No. of Complaints");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(jLabel18))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jLabel19)))
                .addContainerGap(90, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 270, 260, -1));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel22.setText("0");

        jLabel23.setText("Crops Posted");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel22)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel23)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 260, -1));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel24.setText("PHP 0.00");

        jLabel25.setText("Crops Sold");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(jLabel25))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel24)))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel25)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 270, 260, -1));

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel26.setText("0");

        jLabel27.setText("Offered Crops");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel26)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel27)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 270, 260, -1));

        lblEmail.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(0, 102, 255));
        lblEmail.setText("Email");
        jPanel2.add(lblEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 130, 220, -1));

        lblPhone.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblPhone.setForeground(new java.awt.Color(0, 102, 255));
        lblPhone.setText("Phone");
        jPanel2.add(lblPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 190, 160, -1));

        lblCityAddress.setBackground(new java.awt.Color(204, 204, 204));
        lblCityAddress.setFont(new java.awt.Font("SansSerif", 2, 14)); // NOI18N
        lblCityAddress.setForeground(new java.awt.Color(102, 102, 102));
        lblCityAddress.setText("City Address");
        jPanel2.add(lblCityAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 160, 220, 20));

        lblCityIcon.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblCityIcon.setForeground(new java.awt.Color(0, 51, 255));
        jPanel2.add(lblCityIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 160, 30, 20));

        lblHouseNo.setBackground(new java.awt.Color(204, 204, 204));
        lblHouseNo.setFont(new java.awt.Font("SansSerif", 2, 14)); // NOI18N
        lblHouseNo.setForeground(new java.awt.Color(102, 102, 102));
        lblHouseNo.setText("House No.");
        jPanel2.add(lblHouseNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 220, 230, 20));

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 255));
        jLabel2.setText("Chat");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 160, 50, -1));
        jPanel2.add(lblPhoneIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 180, 30, 30));
        jPanel2.add(lblEmailIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, 30, 20));
        jPanel2.add(lblChatIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, 30, 20));

        lblCityAddress1.setBackground(new java.awt.Color(204, 204, 204));
        lblCityAddress1.setFont(new java.awt.Font("SansSerif", 2, 14)); // NOI18N
        lblCityAddress1.setForeground(new java.awt.Color(0, 51, 255));
        jPanel2.add(lblCityAddress1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 130, 30, -1));

        lblProvince.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblProvince.setForeground(new java.awt.Color(102, 102, 102));
        lblProvince.setText("Province");
        jPanel2.add(lblProvince, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 130, 190, 20));

        lblLocationIcon1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblLocationIcon1.setForeground(new java.awt.Color(0, 51, 255));
        jPanel2.add(lblLocationIcon1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 130, 30, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(card1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(card2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(card3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(card4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jLabel1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1031, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void card1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_card1MouseClicked
        // TODO add your handling code here:
        UpdateUser user = new UpdateUser();
        user.setVisible(true);
    }//GEN-LAST:event_card1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Jpanel;
    private com.raven.component.Card card1;
    private com.raven.component.Card card2;
    private com.raven.component.Card card3;
    private com.raven.component.Card card4;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel lblChatIcon;
    private javax.swing.JLabel lblCityAddress;
    private javax.swing.JLabel lblCityAddress1;
    private javax.swing.JLabel lblCityIcon;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEmailIcon;
    private javax.swing.JLabel lblFullName;
    private javax.swing.JLabel lblHouseNo;
    private javax.swing.JLabel lblLocationIcon1;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblPhoneIcon;
    private javax.swing.JLabel lblProvince;
    private javax.swing.JLabel lblStreetAddress;
    private javax.swing.JLabel userProfilePic;
    // End of variables declaration//GEN-END:variables
}
