/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.raven.form;

import com.raven.main.LoginForm;
import farmingsystem.controller.UserImp;
import farmingsystem.model.User;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author MTUMANGAN
 */
public class RegisterForm extends javax.swing.JFrame {

    private LoginForm lf;
    private final User user;

    public RegisterForm(User user) {
        this.user = user;
        initComponents();
        lblFilePath.setVisible(false);
    }

    InputStream is;
    File f;

    public void register() {

        String firstName = txtFirstname.getText();
        String middleName = txtMiddlename.getText();
        String lastName = txtLastname.getText();
        rbnMale.setActionCommand("Male");
        rbnFemale.setActionCommand("Female");
        String gender = rbnGender.getSelection().getActionCommand();
        String civilStats = cmbCivilStatus.getSelectedItem().toString();
        String birthday = txtDate.getText();
        String houseNo = txtHouse.getText();
        String street = txtBarangay.getText();
        String city = cmbCity.getSelectedItem().toString();
        String province = cmbProvince.getSelectedItem().toString();
        String contactNo = txtContactNo.getText();
        int zipCode = Integer.parseInt(txtZipCode.getText());
        f = new File(lblFilePath.getText());
        System.out.println(f);
        try {
            is = new FileInputStream(f);
        } catch (FileNotFoundException ex) {
        }
        rbnFarmer.setActionCommand("Farmer");
        rbnSupplier.setActionCommand("Supplier");
        String role = btnGrpRole.getSelection().getActionCommand();

        user.setProfielImage(is);
        user.setFile(f);
        user.setFirstName(firstName);
        user.setMiddleName(middleName);
        user.setLastName(lastName);
        user.setBirthDate(birthday);
        user.setGender(gender);
        user.setCivilStatus(civilStats);
        user.setHouseNo(houseNo);
        user.setStreetAddress(street);
        user.setCityAddress(city);
        user.setProvince(province);
        user.setZipCode(zipCode);
        user.setContactNumber(contactNo);
        user.setUserType(role);

        UserImp ui = new UserImp();
        ui.register(user);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rbnGender = new javax.swing.ButtonGroup();
        btnGrpRole = new javax.swing.ButtonGroup();
        dateChooser1 = new com.raven.datechooser.DateChooser();
        jPanel2 = new javax.swing.JPanel();
        button1 = new com.raven.swing.Button();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lblPicture = new javax.swing.JLabel();
        btnBrowse = new com.raven.swing.Button();
        txtFirstname = new com.raven.swing.MyTextField();
        txtMiddlename = new com.raven.swing.MyTextField();
        txtLastname = new com.raven.swing.MyTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        rbnMale = new javax.swing.JRadioButton();
        rbnFemale = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtDate = new com.raven.swing.MyTextField();
        cmbCivilStatus = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtHouse = new com.raven.swing.MyTextField();
        jLabel11 = new javax.swing.JLabel();
        cmbProvince = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cmbCity = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        txtZipCode = new com.raven.swing.MyTextField();
        txtBarangay = new com.raven.swing.MyTextField();
        jLabel15 = new javax.swing.JLabel();
        txtContactNo = new com.raven.swing.MyTextField();
        jLabel16 = new javax.swing.JLabel();
        rbnFarmer = new javax.swing.JRadioButton();
        rbnSupplier = new javax.swing.JRadioButton();
        button2 = new com.raven.swing.Button();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        lblFilePath = new javax.swing.JLabel();

        dateChooser1.setTextRefernce(txtDate);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Register");
        setMaximumSize(new java.awt.Dimension(1200, 950));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1130, 950));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));

        button1.setText("REGISTER ACCOUNT DETAILS");
        button1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 1102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 690, 1130, 50));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane1.setForeground(new java.awt.Color(204, 204, 204));
        jScrollPane1.setViewportBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane1.setAutoscrolls(true);
        jScrollPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(1200, 950));
        jScrollPane1.setRequestFocusEnabled(false);
        jScrollPane1.setVerifyInputWhenFocusTarget(false);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setMaximumSize(new java.awt.Dimension(0, 0));
        jPanel1.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(1130, 970));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jPanel3.setPreferredSize(new java.awt.Dimension(200, 200));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(lblPicture, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(lblPicture, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 26, -1, -1));

        btnBrowse.setText("BROWSE PICTURE");
        btnBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseActionPerformed(evt);
            }
        });
        jPanel1.add(btnBrowse, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 232, 200, -1));
        jPanel1.add(txtFirstname, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 101, 258, -1));
        jPanel1.add(txtMiddlename, new org.netbeans.lib.awtextra.AbsoluteConstraints(576, 101, 258, -1));
        jPanel1.add(txtLastname, new org.netbeans.lib.awtextra.AbsoluteConstraints(852, 101, 258, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Middle Name");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(576, 63, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Last Name");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(852, 63, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("House No/Block/Lot/Phase");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, 399, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Personal Information");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 26, -1, -1));

        rbnGender.add(rbnMale);
        rbnMale.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        rbnMale.setText("Male");
        jPanel1.add(rbnMale, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 214, -1, -1));

        rbnGender.add(rbnFemale);
        rbnFemale.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        rbnFemale.setText("Female");
        jPanel1.add(rbnFemale, new org.netbeans.lib.awtextra.AbsoluteConstraints(401, 214, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Birthday");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(576, 176, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Civil Status");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(852, 176, -1, -1));
        jPanel1.add(txtDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(576, 214, 258, -1));

        cmbCivilStatus.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmbCivilStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select:", "Single", "Married", "Divorced", "Widowed" }));
        jPanel1.add(cmbCivilStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(852, 219, 258, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Gender");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 176, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setText("Contact Information");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, -1, 20));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("First Name");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 63, -1, -1));
        jPanel1.add(txtHouse, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 370, 450, 40));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Province");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 430, 109, 30));

        cmbProvince.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmbProvince.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select:", "Abra", "Agusan del Norte", "Agusan del Sur", "Aklan", "Albay", "Antique", "Apayao", "Aurora", "Basilan", "Bataan", "Batanes", "Batangas", "Benguet", "Biliran", "Bohol", "Bukidnon", "Bulacan", "Cagayan", "Camarines Norte", "Camarines Sur", "Camiguin", "Capiz", "Catanduanes", "Cavite", "Cebu", "Cotabato", "Davao de Oro (Compostela Valley)", "Davao del Norte", "Davao del Sur", "Davao Occidental", "Davao Oriental", "Dinagat Islands", "Eastern Samar", "Guimaras", "Ifugao", "Ilocos Norte", "Ilocos Sur", "Iloilo", "Isabela", "Kalinga", "La Union", "Laguna", "Lanao del Norte", "Lanao del Sur", "Leyte", "Maguindanao", "Marinduque", "Masbate", "Misamis Occidental", "Misamis Oriental", "Mountain Province", "Negros Occidental", "Negros Oriental", "Northern Samar", "Nueva Ecija", "Nueva Vizcaya", "Occidental Mindoro", "Oriental Mindoro", "Palawan", "Pampanga", "Pangasinan", "Quezon", "Quirino", "Rizal", "Romblon", "Samar", "Sarangani", "Siquijor", "Sorsogon", "South Cotabato", "Southern Leyte", "Sultan Kudarat", "Sulu", "Surigao del Norte", "Surigao del Sur", "Tarlac", "Tawi-Tawi", "Zambales", "Zamboanga del Norte", "Zamboanga del Sur", "Zamboanga Sibugay" }));
        jPanel1.add(cmbProvince, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 470, 296, 30));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("ZIP Code");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 430, 189, 30));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Street/Barangay");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(525, 330, 370, 30));

        cmbCity.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmbCity.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select:", "Alaminos", "Angeles", "Antipolo", "Bacolod", "Bacoor", "Bago", "Baguio", "Bais", "Balanga", "Batac", "Batangas City", "Bayawan", "Baybay", "Bayugan", "Biñan", "Bislig", "Bogo", "Borongan", "Butuan", "Cabadbaran", "Cabanatuan", "Cabuyao", "Cadiz", "Cagayan de Oro", "Calamba", "Calapan", "Calbayog", "Caloocan", "Candon", "Canlaon", "Carcar", "Catbalogan", "Cauayan", "Cavite City", "Cebu City", "Cotabato City", "Dagupan", "Danao", "Dapitan", "Dasmariñas", "Davao City", "Digos", "Dipolog", "Dumaguete", "El Salvador", "Escalante", "Gapan", "General Santos", "General Trias", "Gingoog", "Guihulngan", "Himamaylan", "Ilagan", "Iligan", "Iloilo City", "Imus", "Iriga", "Isabela", "Kabankalan", "Kidapawan", "Koronadal", "La Carlota", "Lamitan", "Laoag", "Lapu-Lapu", "Las Piñas", "Legazpi", "Ligao", "Lipa", "Lucena", "Maasin", "Mabalacat", "Makati", "Malabon", "Malaybalay", "Malolos", "Mandaluyong", "Mandaue", "Manila", "Marawi", "Marikina", "Masbate City", "Mati", "Meycauayan", "Muñoz", "Muntinlupa", "Naga", "Naga", "Navotas", "Olongapo", "Ormoc", "Oroquieta", "Ozamiz", "Pagadian", "Palayan", "Panabo", "Parañaque", "Pasay", "Pasig", "Passi", "Puerto Princesa", "Quezon City", "Roxas", "Sagay", "Samal", "San Carlos", "San Carlos", "San Fernando", "San Fernando", "San Jose", "San Jose del Monte", "San Juan", "San Pablo", "San Pedro", "Santa Rosa", "Santiago", "Silay", "Sipalay", "Sorsogon City", "Surigao City", "Tabaco", "Tabuk", "Tacloban", "Tacurong", "Tagaytay", "Tagbilaran", "Taguig", "Tagum", "Talisay", "Talisay", "Tanauan", "Tandag", "Tangub", "Tanjay", "Tarlac City", "Tayabas", "Toledo", "Trece Martires", "Tuguegarao", "Urdaneta", "Valencia", "Valenzuela", "Victorias", "Vigan", "Zamboanga City" }));
        jPanel1.add(cmbCity, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 370, 189, 30));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("City");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 330, 189, 30));
        jPanel1.add(txtZipCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 470, 189, 40));
        jPanel1.add(txtBarangay, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 370, 380, 40));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Contact Number");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 430, 285, 30));
        jPanel1.add(txtContactNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 470, 285, 40));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel16.setText("Select Role");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 520, -1, -1));

        btnGrpRole.add(rbnFarmer);
        rbnFarmer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/farmerDefault.jpg"))); // NOI18N
        rbnFarmer.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/farmerSelected.jpg"))); // NOI18N
        jPanel1.add(rbnFarmer, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 570, -1, -1));

        btnGrpRole.add(rbnSupplier);
        rbnSupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/supplierDefault.jpg"))); // NOI18N
        rbnSupplier.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/supplierSelected.jpg"))); // NOI18N
        jPanel1.add(rbnSupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 570, -1, -1));

        button2.setText("CLEAR FIELDS");
        button2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jPanel1.add(button2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 840, 320, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/log.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 550, 330, 280));

        jPanel4.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 740, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 550, 740, 10));

        jPanel5.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1050, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, 1050, 10));

        jPanel6.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 810, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, 810, 10));

        lblFilePath.setText("jLabel17");
        jPanel1.add(lblFilePath, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, -1));

        jScrollPane1.setViewportView(jPanel1);

        jScrollPane1.getVerticalScrollBar().setUnitIncrement(16);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 690));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter fileFilter = new FileNameExtensionFilter("Image Type", "png", "jpg", "jpeg");
        fileChooser.addChoosableFileFilter(fileFilter);
        int load = fileChooser.showOpenDialog(null);
        if (load == fileChooser.APPROVE_OPTION) {

            File f = fileChooser.getSelectedFile();
            String path = f.getAbsolutePath();
            lblFilePath.setText(path);
            System.out.println("Path: " + path);
            ImageIcon ii = new ImageIcon(path);
            Image img = ii.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            lblPicture.setText("");
            lblPicture.setIcon(new ImageIcon(img));
        }
    }//GEN-LAST:event_btnBrowseActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        // TODO add your handling code here:
        if (txtFirstname.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Missing Fields");
            return;
        } 
        register();
    }//GEN-LAST:event_button1ActionPerformed
    public static void main(User user) {
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
            java.util.logging.Logger.getLogger(RegisterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterForm(user).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.swing.Button btnBrowse;
    private javax.swing.ButtonGroup btnGrpRole;
    private com.raven.swing.Button button1;
    private com.raven.swing.Button button2;
    private javax.swing.JComboBox<String> cmbCity;
    private javax.swing.JComboBox<String> cmbCivilStatus;
    private javax.swing.JComboBox<String> cmbProvince;
    private com.raven.datechooser.DateChooser dateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFilePath;
    private javax.swing.JLabel lblPicture;
    private javax.swing.JRadioButton rbnFarmer;
    private javax.swing.JRadioButton rbnFemale;
    private javax.swing.ButtonGroup rbnGender;
    private javax.swing.JRadioButton rbnMale;
    private javax.swing.JRadioButton rbnSupplier;
    private com.raven.swing.MyTextField txtBarangay;
    private com.raven.swing.MyTextField txtContactNo;
    private com.raven.swing.MyTextField txtDate;
    private com.raven.swing.MyTextField txtFirstname;
    private com.raven.swing.MyTextField txtHouse;
    private com.raven.swing.MyTextField txtLastname;
    private com.raven.swing.MyTextField txtMiddlename;
    private com.raven.swing.MyTextField txtZipCode;
    // End of variables declaration//GEN-END:variables
}
