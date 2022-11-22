/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.raven.form;

import com.raven.main.LoginForm;
import farmingsystem.controller.UserImp;
import farmingsystem.model.User;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
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
        ImageIcon imageIcon = new ImageIcon("com\\raven\\icon\\NO_PIC.png");
        Image image = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(image);
        lblPicture.setIcon(icon);
        lblPicture.setText("      Upload Picture");
        JTextField textLimit = new JTextField(4);
        txtZipCode.setColumns(4);
        txtZipCode.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();  // if it's not a number, ignore the event
                }
            }
        });
        txtContactNo.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();  // if it's not a number, ignore the event
                }
            }
        });
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
        btnRegister = new com.raven.swing.Button();
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
        btnClear = new com.raven.swing.Button();
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

        btnRegister.setBackground(new java.awt.Color(59, 122, 87));
        btnRegister.setForeground(new java.awt.Color(255, 255, 255));
        btnRegister.setText("REGISTER ACCOUNT DETAILS");
        btnRegister.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btnRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 1102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(btnRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        jPanel1.setBackground(new java.awt.Color(240, 240, 240));
        jPanel1.setMaximumSize(new java.awt.Dimension(0, 0));
        jPanel1.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(1130, 970));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jPanel3.setPreferredSize(new java.awt.Dimension(200, 200));

        lblPicture.setBackground(new java.awt.Color(59, 122, 87));
        lblPicture.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblPicture.setForeground(new java.awt.Color(59, 122, 87));

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

        btnBrowse.setBackground(new java.awt.Color(59, 122, 87));
        btnBrowse.setForeground(new java.awt.Color(255, 255, 255));
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
        jLabel2.setForeground(new java.awt.Color(59, 122, 87));
        jLabel2.setText("Middle Name");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(576, 63, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(59, 122, 87));
        jLabel3.setText("Last Name");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(852, 63, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(59, 122, 87));
        jLabel4.setText("House No/Block/Lot/Phase");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, 399, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(59, 122, 87));
        jLabel5.setText("Personal Information");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 26, -1, -1));

        rbnGender.add(rbnMale);
        rbnMale.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        rbnMale.setForeground(new java.awt.Color(59, 122, 87));
        rbnMale.setText("Male");
        jPanel1.add(rbnMale, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 214, -1, -1));

        rbnGender.add(rbnFemale);
        rbnFemale.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        rbnFemale.setForeground(new java.awt.Color(59, 122, 87));
        rbnFemale.setText("Female");
        jPanel1.add(rbnFemale, new org.netbeans.lib.awtextra.AbsoluteConstraints(401, 214, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(59, 122, 87));
        jLabel6.setText("Birthday");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(576, 176, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(59, 122, 87));
        jLabel7.setText("Civil Status");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(852, 176, -1, -1));
        jPanel1.add(txtDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(576, 214, 258, -1));

        cmbCivilStatus.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmbCivilStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select:", "Single", "Married", "Divorced", "Widowed" }));
        jPanel1.add(cmbCivilStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(852, 219, 258, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(59, 122, 87));
        jLabel8.setText("Gender");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 176, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(59, 122, 87));
        jLabel9.setText("Contact Information");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, -1, 20));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(59, 122, 87));
        jLabel10.setText("First Name");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 63, -1, -1));
        jPanel1.add(txtHouse, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 370, 450, 40));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(59, 122, 87));
        jLabel11.setText("Province");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 430, 109, 30));

        cmbProvince.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmbProvince.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select:", "Abra", "Agusan del Norte", "Agusan del Sur", "Aklan", "Albay", "Antique", "Apayao", "Aurora", "Basilan", "Bataan", "Batanes", "Batangas", "Benguet", "Biliran", "Bohol", "Bukidnon", "Bulacan", "Cagayan", "Camarines Norte", "Camarines Sur", "Camiguin", "Capiz", "Catanduanes", "Cavite", "Cebu", "Cotabato", "Davao de Oro (Compostela Valley)", "Davao del Norte", "Davao del Sur", "Davao Occidental", "Davao Oriental", "Dinagat Islands", "Eastern Samar", "Guimaras", "Ifugao", "Ilocos Norte", "Ilocos Sur", "Iloilo", "Isabela", "Kalinga", "La Union", "Laguna", "Lanao del Norte", "Lanao del Sur", "Leyte", "Maguindanao", "Marinduque", "Masbate", "Misamis Occidental", "Misamis Oriental", "Mountain Province", "Negros Occidental", "Negros Oriental", "Northern Samar", "Nueva Ecija", "Nueva Vizcaya", "Occidental Mindoro", "Oriental Mindoro", "Palawan", "Pampanga", "Pangasinan", "Quezon", "Quirino", "Rizal", "Romblon", "Samar", "Sarangani", "Siquijor", "Sorsogon", "South Cotabato", "Southern Leyte", "Sultan Kudarat", "Sulu", "Surigao del Norte", "Surigao del Sur", "Tarlac", "Tawi-Tawi", "Zambales", "Zamboanga del Norte", "Zamboanga del Sur", "Zamboanga Sibugay" }));
        cmbProvince.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbProvinceActionPerformed(evt);
            }
        });
        jPanel1.add(cmbProvince, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 470, 296, 30));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(59, 122, 87));
        jLabel12.setText("ZIP Code");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 430, 189, 30));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(59, 122, 87));
        jLabel13.setText("Street/Barangay");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(525, 330, 370, 30));

        cmbCity.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmbCity.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select:" }));
        jPanel1.add(cmbCity, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 470, 189, 30));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(59, 122, 87));
        jLabel14.setText("City");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 430, 189, 30));

        txtZipCode.setColumns(4);
        jPanel1.add(txtZipCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 470, 189, 40));
        jPanel1.add(txtBarangay, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 370, 380, 40));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(59, 122, 87));
        jLabel15.setText("Contact Number");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 430, 285, 30));

        txtContactNo.setColumns(11);
        jPanel1.add(txtContactNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 470, 285, 40));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(59, 122, 87));
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

        btnClear.setBackground(new java.awt.Color(59, 122, 87));
        btnClear.setForeground(new java.awt.Color(255, 255, 255));
        btnClear.setText("CLEAR FIELDS");
        btnClear.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        jPanel1.add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 840, 320, -1));

        jLabel1.setForeground(new java.awt.Color(59, 122, 87));
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

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        // TODO add your handling code here:
        if (txtFirstname.getText().isEmpty() || txtLastname.getText().isEmpty() || txtMiddlename.getText().isEmpty()
                || lblPicture.getText().equals("      Upload Picture") || txtDate.getText().isEmpty()
                || (!rbnMale.isSelected() && !rbnFemale.isSelected()) || cmbCivilStatus.getSelectedIndex() == 0
                || cmbCity.getSelectedItem().equals("Select:") || cmbProvince.getSelectedIndex() == 0
                || txtHouse.getText().isEmpty() || txtBarangay.getText().isEmpty() || txtZipCode.getText().isEmpty()
                || txtContactNo.getText().isEmpty() || (!rbnFarmer.isSelected() || !rbnSupplier.isSelected())) {
            JOptionPane.showMessageDialog(null, "Missing Fields");
            return;
        }
        register();
        this.dispose();
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void cmbProvinceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbProvinceActionPerformed
        // TODO add your handling code here:
        if (cmbProvince.getSelectedItem().equals("Abra")) {
            cmbCity.removeAllItems();
            cmbCity.addItem("Bangued");
            cmbCity.addItem("Boliney");
            cmbCity.addItem("Bucay");
            cmbCity.addItem("Bucloc");
            cmbCity.addItem("Daguioman");
            cmbCity.addItem("Danglas");
            cmbCity.addItem("Dolores");
            cmbCity.addItem("Lacub");
            cmbCity.addItem("Lagangilang");
            cmbCity.addItem("Lagayan");
            cmbCity.addItem("Langiden");
            cmbCity.addItem("La Paz");
            cmbCity.addItem("Licuan-Baay (Licuan)");
            cmbCity.addItem("Luba");
            cmbCity.addItem("Malibcong");
            cmbCity.addItem("Manabo");
            cmbCity.addItem("Peñarrubia");
            cmbCity.addItem("Pidigan");
            cmbCity.addItem("Pilar");
            cmbCity.addItem("Sallapadan");
            cmbCity.addItem("San Isidro");
            cmbCity.addItem("San Juan");
            cmbCity.addItem("San Quintin");
            cmbCity.addItem("Tayum");
            cmbCity.addItem("Tineg");
            cmbCity.addItem("Tubo");
            cmbCity.addItem("Villaviciosa");
            cmbCity.setSelectedItem(null);
        } else if (cmbProvince.getSelectedItem().equals("Albay")) {
            cmbCity.removeAllItems();
            cmbCity.addItem("Bacacay");
            cmbCity.addItem("Camalig");
            cmbCity.addItem("Daraga (Locsin)");
            cmbCity.addItem("Guinobatan");
            cmbCity.addItem("Jovellar");
            cmbCity.addItem("Legazpi");
            cmbCity.addItem("Libon");
            cmbCity.addItem("Ligao");
            cmbCity.addItem("Malilipot");
            cmbCity.addItem("Malinao");
            cmbCity.addItem("Manito");
            cmbCity.addItem("Oas");
            cmbCity.addItem("Pio Duran");
            cmbCity.addItem("Polangui");
            cmbCity.addItem("Rapu-Rapu");
            cmbCity.addItem("Santo Domingo (Libog)");
            cmbCity.addItem("Tabaco");
            cmbCity.addItem("Tiwi : Municipalit");
            cmbCity.setSelectedItem(null);
        } else if (cmbProvince.getSelectedItem().equals("Apayao")) {
            cmbCity.removeAllItems();
            cmbCity.addItem("Calanasan (Bayag)");
            cmbCity.addItem("Conner");
            cmbCity.addItem("Flora");
            cmbCity.addItem("Kabugao");
            cmbCity.addItem("Luna");
            cmbCity.addItem("Pudtol");
            cmbCity.addItem("Santa Marcela");
            cmbCity.setSelectedItem(null);
        } else if (cmbProvince.getSelectedItem().equals("Aurora")) {
            cmbCity.removeAllItems();
            cmbCity.addItem("Baler");
            cmbCity.addItem("Casiguran");
            cmbCity.addItem("Dilasag");
            cmbCity.addItem("Dinalungan");
            cmbCity.addItem("Dingalan");
            cmbCity.addItem("Dipaculao");
            cmbCity.addItem("Maria Aurora");
            cmbCity.addItem("San Luis");
            cmbCity.setSelectedItem(null);
        } else if (cmbProvince.getSelectedItem().equals("Bataan")) {
            cmbCity.removeAllItems();
            cmbCity.addItem("Abucay");
            cmbCity.addItem("Bagac");
            cmbCity.addItem("Balanga");
            cmbCity.addItem("Dinalupihan");
            cmbCity.addItem("Hermosa");
            cmbCity.addItem("Limay");
            cmbCity.addItem("Mariveles");
            cmbCity.addItem("Morong");
            cmbCity.addItem("Orani");
            cmbCity.addItem("Orion");
            cmbCity.addItem("Pilar");
            cmbCity.addItem("Samal");
            cmbCity.setSelectedItem(null);
        } else if (cmbProvince.getSelectedItem().equals("Batanes")) {
            cmbCity.removeAllItems();
            cmbCity.addItem("Basco");
            cmbCity.addItem("Itbayat");
            cmbCity.addItem("Ivana");
            cmbCity.addItem("Mahatao");
            cmbCity.addItem("Sabtang");
            cmbCity.addItem("Uyugan");
            cmbCity.setSelectedItem(null);
        } else if (cmbProvince.getSelectedItem().equals("Batangas")) {
            cmbCity.removeAllItems();
            cmbCity.addItem("Agoncillo");
            cmbCity.addItem("Alitagtag");
            cmbCity.addItem("Balayan");
            cmbCity.addItem("Balete");
            cmbCity.addItem("Batangas");
            cmbCity.addItem("Bauan");
            cmbCity.addItem("Calaca");
            cmbCity.addItem("Calatagan");
            cmbCity.addItem("Cuenca");
            cmbCity.addItem("Ibaan");
            cmbCity.addItem("Laurel");
            cmbCity.addItem("Lemery");
            cmbCity.addItem("Lian");
            cmbCity.addItem("Lipa");
            cmbCity.addItem("Lobo");
            cmbCity.addItem("Mabini");
            cmbCity.addItem("Malvar");
            cmbCity.addItem("Mataasnakahoy");
            cmbCity.addItem("Nasugbu");
            cmbCity.addItem("Padre Garcia");
            cmbCity.addItem("Rosario");
            cmbCity.addItem("San Jose");
            cmbCity.addItem("San Juan");
            cmbCity.addItem("San Luis");
            cmbCity.addItem("San Nicolas");
            cmbCity.addItem("San Pascual");
            cmbCity.addItem("Santa Teresita");
            cmbCity.addItem("Santo Tomas");
            cmbCity.addItem("Taal");
            cmbCity.addItem("Talisay");
            cmbCity.addItem("Tanauan");
            cmbCity.addItem("Taysan");
            cmbCity.addItem("Tingloy");
            cmbCity.addItem("Tuy");
            cmbCity.setSelectedItem(null);
        } else if (cmbProvince.getSelectedItem().equals("Benguet")) {
            cmbCity.removeAllItems();
            cmbCity.addItem("Atok");
            cmbCity.addItem("Baguio");
            cmbCity.addItem("Bakun");
            cmbCity.addItem("Bokod");
            cmbCity.addItem("Buguias");
            cmbCity.addItem("Itogon");
            cmbCity.addItem("Kabayan");
            cmbCity.addItem("Kapangan");
            cmbCity.addItem("Kibungan");
            cmbCity.addItem("La Trinidad");
            cmbCity.addItem("Mankayan");
            cmbCity.addItem("Sablan");
            cmbCity.addItem("Tuba");
            cmbCity.addItem("Tublay");
            cmbCity.setSelectedItem(null);
        } else if (cmbProvince.getSelectedItem().equals("Bulacan")) {
            cmbCity.removeAllItems();
            cmbCity.addItem("Angat");
            cmbCity.addItem("Balagtas (Bigaa)");
            cmbCity.addItem("Baliuag");
            cmbCity.addItem("Bocaue");
            cmbCity.addItem("Bulacan (Bulakan)");
            cmbCity.addItem("Bustos");
            cmbCity.addItem("Calumpit");
            cmbCity.addItem("Doña Remedios Trinidad");
            cmbCity.addItem("Guiguinto");
            cmbCity.addItem("Hagonoy");
            cmbCity.addItem("Malolos");
            cmbCity.addItem("Marilao");
            cmbCity.addItem("Meycauayan");
            cmbCity.addItem("Norzagaray");
            cmbCity.addItem("Obando");
            cmbCity.addItem("Pandi");
            cmbCity.addItem("Paombong");
            cmbCity.addItem("Plaridel");
            cmbCity.addItem("Pulilan");
            cmbCity.addItem("San Ildefonso");
            cmbCity.addItem("San Jose del Monte");
            cmbCity.addItem("San Miguel");
            cmbCity.addItem("San Rafael");
            cmbCity.addItem("Santa Maria");
            cmbCity.setSelectedItem(null);
        } else if (cmbProvince.getSelectedItem().equals("Cagayan")) {
            cmbCity.removeAllItems();
            cmbCity.addItem("Abulug");
            cmbCity.addItem("Alcala");
            cmbCity.addItem("Allacapan");
            cmbCity.addItem("Amulung");
            cmbCity.addItem("Aparri");
            cmbCity.addItem("Baggao");
            cmbCity.addItem("Ballesteros");
            cmbCity.addItem("Buguey");
            cmbCity.addItem("Calayan");
            cmbCity.addItem("Camalaniugan");
            cmbCity.addItem("Claveria");
            cmbCity.addItem("Enrile");
            cmbCity.addItem("Gattaran");
            cmbCity.addItem("Gonzaga");
            cmbCity.addItem("Iguig");
            cmbCity.addItem("Lal-Lo");
            cmbCity.addItem("Lasam");
            cmbCity.addItem("Pamplona");
            cmbCity.addItem("Peñablanca");
            cmbCity.addItem("Piat");
            cmbCity.addItem("Rizal");
            cmbCity.addItem("Sanchez-Mira");
            cmbCity.addItem("Santa Ana");
            cmbCity.addItem("Santa Praxedes");
            cmbCity.addItem("Santa Teresita");
            cmbCity.addItem("Santo Niño (Faire)");
            cmbCity.addItem("Solana");
            cmbCity.addItem("Tuao");
            cmbCity.addItem("Tuguegarao");
            cmbCity.setSelectedItem(null);
        } else if (cmbProvince.getSelectedItem().equals("Camarines Norte")) {
            cmbCity.removeAllItems();
            cmbCity.addItem("Basud");
            cmbCity.addItem("Capalonga");
            cmbCity.addItem("Daet");
            cmbCity.addItem("Jose Panganiban");
            cmbCity.addItem("Labo");
            cmbCity.addItem("Mercedes");
            cmbCity.addItem("Paracale");
            cmbCity.addItem("San Lorenzo Ruiz (Imelda)");
            cmbCity.addItem("Santa Elena");
            cmbCity.addItem("San Vicente");
            cmbCity.addItem("Talisay");
            cmbCity.addItem("Vinzons");
            cmbCity.setSelectedItem(null);
        } else if (cmbProvince.getSelectedItem().equals("Camarines Sur")) {
            cmbCity.removeAllItems();
            cmbCity.addItem("Baao");
            cmbCity.addItem("Balatan");
            cmbCity.addItem("Bato");
            cmbCity.addItem("Bombon");
            cmbCity.addItem("Buhi");
            cmbCity.addItem("Bula");
            cmbCity.addItem("Cabusao");
            cmbCity.addItem("Calabanga");
            cmbCity.addItem("Camaligan");
            cmbCity.addItem("Canaman");
            cmbCity.addItem("Caramoan");
            cmbCity.addItem("Del Gallego");
            cmbCity.addItem("Gainza");
            cmbCity.addItem("Garchitorena");
            cmbCity.addItem("Goa");
            cmbCity.addItem("Iriga");
            cmbCity.addItem("Lagonoy");
            cmbCity.addItem("Libmanan");
            cmbCity.addItem("Lupi");
            cmbCity.addItem("Magarao");
            cmbCity.addItem("Milaor");
            cmbCity.addItem("Minalabac");
            cmbCity.addItem("Nabua");
            cmbCity.addItem("Naga");
            cmbCity.addItem("Ocampo");
            cmbCity.addItem("Pamplona");
            cmbCity.addItem("Pasacao");
            cmbCity.addItem("Pili");
            cmbCity.addItem("Presentacion (Parubcan)");
            cmbCity.addItem("Ragay");
            cmbCity.addItem("Sagñay");
            cmbCity.addItem("San Fernando");
            cmbCity.addItem("San Jose");
            cmbCity.addItem("Sipocot");
            cmbCity.addItem("Siruma");
            cmbCity.addItem("Tigaon");
            cmbCity.addItem("Tinambac");
            cmbCity.setSelectedItem(null);
        } else if (cmbProvince.getSelectedItem().equals("Catanduanes")) {
            cmbCity.removeAllItems();
            cmbCity.addItem("Bagamanoc");
            cmbCity.addItem("Baras");
            cmbCity.addItem("Bato");
            cmbCity.addItem("Caramoran");
            cmbCity.addItem("Gigmoto");
            cmbCity.addItem("Pandan");
            cmbCity.addItem("Panganiban (Payo)");
            cmbCity.addItem("San Andres (Calolbon)");
            cmbCity.addItem("San Miguel");
            cmbCity.addItem("Viga");
            cmbCity.addItem("Virac");
            cmbCity.setSelectedItem(null);
        } else if (cmbProvince.getSelectedItem().equals("Cavite")) {
            cmbCity.removeAllItems();
            cmbCity.addItem("Alfonso");
            cmbCity.addItem("Amadeo");
            cmbCity.addItem("Bacoor");
            cmbCity.addItem("Carmona");
            cmbCity.addItem("Cavite");
            cmbCity.addItem("Dasmariñas");
            cmbCity.addItem("General Emilio Aguinaldo");
            cmbCity.addItem("General Mariano Alvarez");
            cmbCity.addItem("General Trias");
            cmbCity.addItem("Imus");
            cmbCity.addItem("Indang");
            cmbCity.addItem("Kawit");
            cmbCity.addItem("Magallanes");
            cmbCity.addItem("Maragondon");
            cmbCity.addItem("Mendez (Mendez-Nuñez)");
            cmbCity.addItem("Naic");
            cmbCity.addItem("Noveleta");
            cmbCity.addItem("Rosario");
            cmbCity.addItem("Silang");
            cmbCity.addItem("Tagaytay");
            cmbCity.addItem("Tanza");
            cmbCity.addItem("Ternate");
            cmbCity.addItem("Trece Martires");
            cmbCity.setSelectedItem(null);
        } else if (cmbProvince.getSelectedItem().equals("Ifugao")) {
            cmbCity.removeAllItems();
            cmbCity.addItem("Aguinaldo");
            cmbCity.addItem("Alfonso Lista (Potia)");
            cmbCity.addItem("Asipulo");
            cmbCity.addItem("Banaue");
            cmbCity.addItem("Hingyon");
            cmbCity.addItem("Hungduan");
            cmbCity.addItem("Kiangan");
            cmbCity.addItem("Lagawe");
            cmbCity.addItem("Lamut");
            cmbCity.addItem("Mayoyao");
            cmbCity.addItem("Tinoc");
            cmbCity.setSelectedItem(null);
        } else if (cmbProvince.getSelectedItem().equals("Ilocos Norte")) {
            cmbCity.removeAllItems();
            cmbCity.addItem("Adams");
            cmbCity.addItem("Bacarra");
            cmbCity.addItem("Badoc");
            cmbCity.addItem("Bangui");
            cmbCity.addItem("Banna (Espiritu)");
            cmbCity.addItem("Batac");
            cmbCity.addItem("Burgos");
            cmbCity.addItem("Carasi");
            cmbCity.addItem("Currimao");
            cmbCity.addItem("Dingras");
            cmbCity.addItem("Dumalneg");
            cmbCity.addItem("Laoag");
            cmbCity.addItem("Marcos");
            cmbCity.addItem("Nueva Era");
            cmbCity.addItem("Pagudpud");
            cmbCity.addItem("Paoay");
            cmbCity.addItem("Pasuquin");
            cmbCity.addItem("Piddig");
            cmbCity.addItem("Pinili");
            cmbCity.addItem("San Nicolas");
            cmbCity.addItem("Sarrat");
            cmbCity.addItem("Solsona");
            cmbCity.addItem("Vintar");
            cmbCity.setSelectedItem(null);
        } else if (cmbProvince.getSelectedItem().equals("Ilocos Sur")) {
            cmbCity.removeAllItems();
            cmbCity.addItem("Alilem");
            cmbCity.addItem("Banayoyo");
            cmbCity.addItem("Bantay");
            cmbCity.addItem("Burgos");
            cmbCity.addItem("Cabugao");
            cmbCity.addItem("Candon");
            cmbCity.addItem("Caoayan");
            cmbCity.addItem("Cervantes");
            cmbCity.addItem("Galimuyod");
            cmbCity.addItem("Gregorio del Pilar (Concepcion)");
            cmbCity.addItem("Lidlidda");
            cmbCity.addItem("Magsingal");
            cmbCity.addItem("Nagbukel");
            cmbCity.addItem("Narvacan");
            cmbCity.addItem("Quirino (Angkaki)");
            cmbCity.addItem("Salcedo (Baugen)");
            cmbCity.addItem("San Emilio");
            cmbCity.addItem("San Esteban");
            cmbCity.addItem("San Ildefonso");
            cmbCity.addItem("San Juan (Lapog)");
            cmbCity.addItem("Santa");
            cmbCity.addItem("Santa Catalina");
            cmbCity.addItem("Santa Cruz");
            cmbCity.addItem("Santa Lucia");
            cmbCity.addItem("Santa Maria");
            cmbCity.addItem("Santiago");
            cmbCity.addItem("Santo Domingo");
            cmbCity.addItem("San Vicente");
            cmbCity.addItem("Sigay");
            cmbCity.addItem("Sinait");
            cmbCity.addItem("Sugpon");
            cmbCity.addItem("Suyo");
            cmbCity.addItem("Tagudin");
            cmbCity.addItem("Vigan");
            cmbCity.setSelectedItem(null);
        } else if (cmbProvince.getSelectedItem().equals("Isabela")) {
            cmbCity.removeAllItems();
            cmbCity.addItem("Alicia");
            cmbCity.addItem("Angadanan");
            cmbCity.addItem("Aurora");
            cmbCity.addItem("Benito Soliven");
            cmbCity.addItem("Burgos");
            cmbCity.addItem("Cabagan");
            cmbCity.addItem("Cabatuan");
            cmbCity.addItem("Cauayan");
            cmbCity.addItem("Cordon");
            cmbCity.addItem("Delfin Albano (Magsaysay)");
            cmbCity.addItem("Dinapigue");
            cmbCity.addItem("Divilacan");
            cmbCity.addItem("Echague");
            cmbCity.addItem("Gamu");
            cmbCity.addItem("Ilagan");
            cmbCity.addItem("Jones");
            cmbCity.addItem("Luna");
            cmbCity.addItem("Maconacon");
            cmbCity.addItem("Mallig");
            cmbCity.addItem("Naguilian");
            cmbCity.addItem("Palanan");
            cmbCity.addItem("Quezon");
            cmbCity.addItem("Quirino");
            cmbCity.addItem("Ramon");
            cmbCity.addItem("Reina Mercedes");
            cmbCity.addItem("Roxas");
            cmbCity.addItem("San Agustin");
            cmbCity.addItem("San Guillermo");
            cmbCity.addItem("San Isidro");
            cmbCity.addItem("San Manuel");
            cmbCity.addItem("San Mariano");
            cmbCity.addItem("San Mateo");
            cmbCity.addItem("San Pablo");
            cmbCity.addItem("Santa Maria");
            cmbCity.addItem("Santiago");
            cmbCity.addItem("Santo Tomas");
            cmbCity.addItem("Tumauini");
            cmbCity.setSelectedItem(null);
        } else if (cmbProvince.getSelectedItem().equals("Kalinga")) {
            cmbCity.removeAllItems();
            cmbCity.addItem("Balbalan");
            cmbCity.addItem("Lubuagan");
            cmbCity.addItem("Pasil");
            cmbCity.addItem("Pinukpuk");
            cmbCity.addItem("Rizal (Liwan)");
            cmbCity.addItem("Tabuk");
            cmbCity.addItem("Tanudan");
            cmbCity.addItem("Tinglayan");
            cmbCity.setSelectedItem(null);
        } else if (cmbProvince.getSelectedItem().equals("Laguna")) {
            cmbCity.removeAllItems();
            cmbCity.addItem("Alaminos");
            cmbCity.addItem("Bay");
            cmbCity.addItem("Biñan");
            cmbCity.addItem("Cabuyao");
            cmbCity.addItem("Calamba");
            cmbCity.addItem("Calauan");
            cmbCity.addItem("Cavinti");
            cmbCity.addItem("Famy");
            cmbCity.addItem("Kalayaan");
            cmbCity.addItem("Liliw");
            cmbCity.addItem("Los Baños");
            cmbCity.addItem("Luisiana");
            cmbCity.addItem("Lumban");
            cmbCity.addItem("Mabitac");
            cmbCity.addItem("Magdalena");
            cmbCity.addItem("Majayjay");
            cmbCity.addItem("Nagcarlan");
            cmbCity.addItem("Paete");
            cmbCity.addItem("Pagsanjan");
            cmbCity.addItem("Pakil");
            cmbCity.addItem("Pangil");
            cmbCity.addItem("Pila");
            cmbCity.addItem("Rizal");
            cmbCity.addItem("San Pablo");
            cmbCity.addItem("San Pedro");
            cmbCity.addItem("Santa Cruz");
            cmbCity.addItem("Santa Maria");
            cmbCity.addItem("Santa Rosa");
            cmbCity.addItem("Siniloan");
            cmbCity.addItem("Victoria");
            cmbCity.setSelectedItem(null);
        } else if (cmbProvince.getSelectedItem().equals("La Union")) {
            cmbCity.removeAllItems();
            cmbCity.addItem("Agoo");
            cmbCity.addItem("Aringay");
            cmbCity.addItem("Bacnotan");
            cmbCity.addItem("Bagulin");
            cmbCity.addItem("Balaoan");
            cmbCity.addItem("Bangar");
            cmbCity.addItem("Bauang");
            cmbCity.addItem("Burgos");
            cmbCity.addItem("Caba");
            cmbCity.addItem("Luna");
            cmbCity.addItem("Naguilian");
            cmbCity.addItem("Pugo");
            cmbCity.addItem("Rosario");
            cmbCity.addItem("San Fernando");
            cmbCity.addItem("San Gabriel");
            cmbCity.addItem("San Juan");
            cmbCity.addItem("Santol");
            cmbCity.addItem("Santo Tomas");
            cmbCity.addItem("Sudipen");
            cmbCity.addItem("Tubao");
            cmbCity.setSelectedItem(null);
        } else if (cmbProvince.getSelectedItem().equals("Marinduque")) {
            cmbCity.removeAllItems();
            cmbCity.addItem("Boac");
            cmbCity.addItem("Buenavista");
            cmbCity.addItem("Gasan");
            cmbCity.addItem("Mogpog");
            cmbCity.addItem("Santa Cruz");
            cmbCity.addItem("Torrijos");
            cmbCity.setSelectedItem(null);
        } else if (cmbProvince.getSelectedItem().equals("Masbate")) {
            cmbCity.removeAllItems();
            cmbCity.addItem("Aroroy");
            cmbCity.addItem("Baleno");
            cmbCity.addItem("Balud");
            cmbCity.addItem("Batuan");
            cmbCity.addItem("Cataingan");
            cmbCity.addItem("Cawayan");
            cmbCity.addItem("Claveria");
            cmbCity.addItem("Dimasalang");
            cmbCity.addItem("Esperanza");
            cmbCity.addItem("Mandaon");
            cmbCity.addItem("Masbate");
            cmbCity.addItem("Milagros");
            cmbCity.addItem("Mobo");
            cmbCity.addItem("Monreal");
            cmbCity.addItem("Palanas");
            cmbCity.addItem("Pio V. Corpuz (Limbuhan)");
            cmbCity.addItem("Placer");
            cmbCity.addItem("San Fernando");
            cmbCity.addItem("San Jacinto");
            cmbCity.addItem("San Pascual");
            cmbCity.addItem("Uson");
            cmbCity.setSelectedItem(null);
        } else if (cmbProvince.getSelectedItem().equals("Metro Manila")) {
            cmbCity.removeAllItems();
            cmbCity.addItem("Barlig");
            cmbCity.addItem("Bauko");
            cmbCity.addItem("Besao");
            cmbCity.addItem("Bontoc");
            cmbCity.addItem("Natonin");
            cmbCity.addItem("Paracelis");
            cmbCity.addItem("Sabangan");
            cmbCity.addItem("Sadanga");
            cmbCity.addItem("Sagada");
            cmbCity.addItem("Tadian");
            cmbCity.addItem("N.C.R., 1st District (Capital District, Manila)");
            cmbCity.addItem("Manila");
            cmbCity.addItem("N.C.R., 2nd District (Eastern Manila District)");
            cmbCity.addItem("Mandaluyong");
            cmbCity.addItem("Marikina");
            cmbCity.addItem("Pasig");
            cmbCity.addItem("Quezon City");
            cmbCity.addItem("San Juan");
            cmbCity.addItem("N.C.R., 3rd District (CAMANAVA District)");
            cmbCity.addItem("Caloocan");
            cmbCity.addItem("Malabon");
            cmbCity.addItem("Navotas");
            cmbCity.addItem("Valenzuela");
            cmbCity.addItem("N.C.R., 4th District (Southern Manila District)");
            cmbCity.addItem("Las Piñas");
            cmbCity.addItem("Makati");
            cmbCity.addItem("Muntinlupa");
            cmbCity.addItem("Parañaque");
            cmbCity.addItem("Pasay");
            cmbCity.addItem("Pateros");
            cmbCity.addItem("Taguig");
            cmbCity.setSelectedItem(null);
        } else if (cmbProvince.getSelectedItem().equals("Nueva Ecija")) {
            cmbCity.removeAllItems();
            cmbCity.addItem("Aliaga");
            cmbCity.addItem("Bongabon");
            cmbCity.addItem("Cabanatuan");
            cmbCity.addItem("Cabiao");
            cmbCity.addItem("Carranglan");
            cmbCity.addItem("Cuyapo");
            cmbCity.addItem("Gabaldon (Bitulok – Sabani)");
            cmbCity.addItem("Gapan");
            cmbCity.addItem("General Mamerto Natividad");
            cmbCity.addItem("General Tinio (Papaya)");
            cmbCity.addItem("Guimba");
            cmbCity.addItem("Jaen");
            cmbCity.addItem("Laur");
            cmbCity.addItem("Licab");
            cmbCity.addItem("Llanera");
            cmbCity.addItem("Lupao");
            cmbCity.addItem("Muñoz (Science City of Muñoz)");
            cmbCity.addItem("Nampicuan");
            cmbCity.addItem("Palayan");
            cmbCity.addItem("Pantabangan");
            cmbCity.addItem("Peñaranda");
            cmbCity.addItem("Quezon");
            cmbCity.addItem("Rizal");
            cmbCity.addItem("San Antonio");
            cmbCity.addItem("San Isidro");
            cmbCity.addItem("San Jose");
            cmbCity.addItem("San Leonardo");
            cmbCity.addItem("Santa Rosa");
            cmbCity.addItem("Santo Domingo");
            cmbCity.addItem("Talavera");
            cmbCity.addItem("Talugtug");
            cmbCity.addItem("Zaragoza");
            cmbCity.setSelectedItem(null);
        } else if (cmbProvince.getSelectedItem().equals("Nueva Vizcaya")) {
            cmbCity.removeAllItems();
            cmbCity.addItem("Alfonso Castañeda");
            cmbCity.addItem("Ambaguio");
            cmbCity.addItem("Aritao");
            cmbCity.addItem("Bagabag");
            cmbCity.addItem("Bambang");
            cmbCity.addItem("Bayombong");
            cmbCity.addItem("Diadi");
            cmbCity.addItem("Dupax del Norte");
            cmbCity.addItem("Dupax del Sur");
            cmbCity.addItem("Kasibu");
            cmbCity.addItem("Kayapa");
            cmbCity.addItem("Quezon");
            cmbCity.addItem("Santa Fe");
            cmbCity.addItem("Solano");
            cmbCity.addItem("Villaverde");
            cmbCity.setSelectedItem(null);
        } else if (cmbProvince.getSelectedItem().equals("Occidental Mindoro")) {
            cmbCity.removeAllItems();
            cmbCity.addItem("Abra de Ilog");
            cmbCity.addItem("Calintaan");
            cmbCity.addItem("Looc");
            cmbCity.addItem("Lubang");
            cmbCity.addItem("Magsaysay");
            cmbCity.addItem("Mamburao");
            cmbCity.addItem("Paluan");
            cmbCity.addItem("Rizal");
            cmbCity.addItem("Sablayan");
            cmbCity.addItem("San Jose");
            cmbCity.addItem("Santa Cruz");
            cmbCity.setSelectedItem(null);
        } else if (cmbProvince.getSelectedItem().equals("Oriental Mindoro")) {
            cmbCity.removeAllItems();
            cmbCity.addItem("Baco");
            cmbCity.addItem("Bansud");
            cmbCity.addItem("Bongabong");
            cmbCity.addItem("Bulalacao (San Pedro)");
            cmbCity.addItem("Calapan");
            cmbCity.addItem("Gloria");
            cmbCity.addItem("Mansalay");
            cmbCity.addItem("Naujan");
            cmbCity.addItem("Pinamalayan");
            cmbCity.addItem("Pola");
            cmbCity.addItem("Puerto Galera");
            cmbCity.addItem("Roxas");
            cmbCity.addItem("San Teodoro");
            cmbCity.addItem("Socorro");
            cmbCity.addItem("Victoria");
            cmbCity.setSelectedItem(null);
        } else if (cmbProvince.getSelectedItem().equals("Palawan")) {
            cmbCity.removeAllItems();
            cmbCity.addItem("Aborlan");
            cmbCity.addItem("Agutaya");
            cmbCity.addItem("Araceli");
            cmbCity.addItem("Balabac");
            cmbCity.addItem("Bataraza");
            cmbCity.addItem("Brooke’s Point");
            cmbCity.addItem("Busuanga");
            cmbCity.addItem("Cagayancillo");
            cmbCity.addItem("Coron");
            cmbCity.addItem("Culion");
            cmbCity.addItem("Cuyo");
            cmbCity.addItem("Dumaran");
            cmbCity.addItem("El Nido (Bacuit)");
            cmbCity.addItem("Kalayaan [Spratly Islands]");
            cmbCity.addItem("Linapacan");
            cmbCity.addItem("Magsaysay");
            cmbCity.addItem("Narra");
            cmbCity.addItem("Puerto Princesa");
            cmbCity.addItem("Quezon");
            cmbCity.addItem("Rizal (Marcos)");
            cmbCity.addItem("Roxas");
            cmbCity.addItem("San Vicente");
            cmbCity.addItem("Sofronio Española");
            cmbCity.addItem("Taytay");
            cmbCity.setSelectedItem(null);
        } else if (cmbProvince.getSelectedItem().equals("Pampanga")) {
            cmbCity.removeAllItems();
            cmbCity.addItem("Angeles");
            cmbCity.addItem("Apalit");
            cmbCity.addItem("Arayat");
            cmbCity.addItem("Bacolor");
            cmbCity.addItem("Candaba");
            cmbCity.addItem("Floridablanca");
            cmbCity.addItem("Guagua");
            cmbCity.addItem("Lubao");
            cmbCity.addItem("Mabalacat");
            cmbCity.addItem("Macabebe");
            cmbCity.addItem("Magalang");
            cmbCity.addItem("Masantol");
            cmbCity.addItem("Mexico");
            cmbCity.addItem("Minalin");
            cmbCity.addItem("Porac");
            cmbCity.addItem("San Fernando");
            cmbCity.addItem("San Luis");
            cmbCity.addItem("San Simon");
            cmbCity.addItem("Santa Ana");
            cmbCity.addItem("Santa Rita");
            cmbCity.addItem("Santo Tomas");
            cmbCity.addItem("Sasmuan (Sexmoan)");
            cmbCity.setSelectedItem(null);
        } else if (cmbProvince.getSelectedItem().equals("Pangasinan")) {
            cmbCity.removeAllItems();
            cmbCity.addItem("Agno");
            cmbCity.addItem("Aguilar");
            cmbCity.addItem("Alaminos");
            cmbCity.addItem("Alcala");
            cmbCity.addItem("Anda");
            cmbCity.addItem("Asingan");
            cmbCity.addItem("Balungao");
            cmbCity.addItem("Bani");
            cmbCity.addItem("Basista");
            cmbCity.addItem("Bautista");
            cmbCity.addItem("Bayambang");
            cmbCity.addItem("Binalonan");
            cmbCity.addItem("Binmaley");
            cmbCity.addItem("Bolinao");
            cmbCity.addItem("Bugallon");
            cmbCity.addItem("Burgos");
            cmbCity.addItem("Calasiao");
            cmbCity.addItem("Dagupan");
            cmbCity.addItem("Dasol");
            cmbCity.addItem("Infanta");
            cmbCity.addItem("Labrador");
            cmbCity.addItem("Laoac");
            cmbCity.addItem("Lingayen");
            cmbCity.addItem("Mabini");
            cmbCity.addItem("Malasiqui");
            cmbCity.addItem("Manaoag");
            cmbCity.addItem("Mangaldan");
            cmbCity.addItem("Mangatarem");
            cmbCity.addItem("Mapandan");
            cmbCity.addItem("Natividad");
            cmbCity.addItem("Pozzorrubio");
            cmbCity.addItem("Rosales");
            cmbCity.addItem("San Carlos");
            cmbCity.addItem("San Fabian");
            cmbCity.addItem("San Jacinto");
            cmbCity.addItem("San Manuel");
            cmbCity.addItem("San Nicolas");
            cmbCity.addItem("San Quintin");
            cmbCity.addItem("Santa Barbara");
            cmbCity.addItem("Santa Maria");
            cmbCity.addItem("Santo Tomas");
            cmbCity.addItem("Sison");
            cmbCity.addItem("Sual");
            cmbCity.addItem("Tayug");
            cmbCity.addItem("Umingan");
            cmbCity.addItem("Urbiztondo");
            cmbCity.addItem("Urdaneta");
            cmbCity.addItem("Villasis");
            cmbCity.setSelectedItem(null);
        } else if (cmbProvince.getSelectedItem().equals("Quezon")) {
            cmbCity.removeAllItems();
            cmbCity.addItem("Agdangan");
            cmbCity.addItem("Alabat");
            cmbCity.addItem("Atimonan");
            cmbCity.addItem("Buenavista");
            cmbCity.addItem("Burdeos");
            cmbCity.addItem("Calauag");
            cmbCity.addItem("Candelaria");
            cmbCity.addItem("Catanauan");
            cmbCity.addItem("Dolores");
            cmbCity.addItem("General Luna");
            cmbCity.addItem("General Nakar");
            cmbCity.addItem("Guinayangan");
            cmbCity.addItem("Gumaca");
            cmbCity.addItem("Infanta");
            cmbCity.addItem("Jomalig");
            cmbCity.addItem("Lopez");
            cmbCity.addItem("Lucban");
            cmbCity.addItem("Lucena");
            cmbCity.addItem("Macalelon");
            cmbCity.addItem("Mauban");
            cmbCity.addItem("Mulanay");
            cmbCity.addItem("Padre Burgos");
            cmbCity.addItem("Pagbilao");
            cmbCity.addItem("Panukulan");
            cmbCity.addItem("Patnanungan");
            cmbCity.addItem("Perez");
            cmbCity.addItem("Pitogo");
            cmbCity.addItem("Plaridel");
            cmbCity.addItem("Polillo");
            cmbCity.addItem("Quezon");
            cmbCity.addItem("Real");
            cmbCity.addItem("Sampaloc");
            cmbCity.addItem("San Andres (Calolbon)");
            cmbCity.addItem("San Antonio");
            cmbCity.addItem("San Francisco (Aurora)");
            cmbCity.addItem("San Narciso");
            cmbCity.addItem("Sariaya");
            cmbCity.addItem("Tagkawayan");
            cmbCity.addItem("Tayabas");
            cmbCity.addItem("Tiaong");
            cmbCity.addItem("Unisan");
            cmbCity.setSelectedItem(null);
        } else if (cmbProvince.getSelectedItem().equals("Quirino")) {
            cmbCity.removeAllItems();
            cmbCity.addItem("Aglipay");
            cmbCity.addItem("Cabarroguis");
            cmbCity.addItem("Diffun");
            cmbCity.addItem("Maddela");
            cmbCity.addItem("Nagtipunan");
            cmbCity.addItem("Saguday");
            cmbCity.setSelectedItem(null);
        } else if (cmbProvince.getSelectedItem().equals("Rizal")) {
            cmbCity.removeAllItems();
            cmbCity.addItem("Angono");
            cmbCity.addItem("Antipolo");
            cmbCity.addItem("Baras");
            cmbCity.addItem("Binangonan");
            cmbCity.addItem("Cainta");
            cmbCity.addItem("Cardona");
            cmbCity.addItem("Jala-Jala");
            cmbCity.addItem("Morong");
            cmbCity.addItem("Pililla");
            cmbCity.addItem("Rodriguez (Montalban)");
            cmbCity.addItem("San Mateo");
            cmbCity.addItem("Tanay");
            cmbCity.addItem("Taytay");
            cmbCity.addItem("Teresa");
            cmbCity.setSelectedItem(null);
        } else if (cmbProvince.getSelectedItem().equals("Romblon")) {
            cmbCity.removeAllItems();
            cmbCity.addItem("Alcantara");
            cmbCity.addItem("Banton");
            cmbCity.addItem("Cajidiocan");
            cmbCity.addItem("Calatrava");
            cmbCity.addItem("Concepcion");
            cmbCity.addItem("Corcuera");
            cmbCity.addItem("Ferrol");
            cmbCity.addItem("Looc");
            cmbCity.addItem("Magdiwang");
            cmbCity.addItem("Odiongan");
            cmbCity.addItem("Romblon");
            cmbCity.addItem("San Agustin");
            cmbCity.addItem("San Andres (Calolbon)");
            cmbCity.addItem("San Fernando");
            cmbCity.addItem("San Jose");
            cmbCity.addItem("Santa Fe");
            cmbCity.addItem("Santa Maria (Imelda)");
            cmbCity.setSelectedItem(null);
        } else if (cmbProvince.getSelectedItem().equals("Sorsogon")) {
            cmbCity.removeAllItems();
            cmbCity.addItem("Barcelona");
            cmbCity.addItem("Bulan");
            cmbCity.addItem("Bulusan");
            cmbCity.addItem("Casiguran");
            cmbCity.addItem("Castilla");
            cmbCity.addItem("Donsol");
            cmbCity.addItem("Gubat");
            cmbCity.addItem("Irosin");
            cmbCity.addItem("Juban");
            cmbCity.addItem("Magallanes");
            cmbCity.addItem("Matnog");
            cmbCity.addItem("Pilar");
            cmbCity.addItem("Prieto Diaz");
            cmbCity.addItem("Santa Magdalena");
            cmbCity.addItem("Sorsogon");
            cmbCity.setSelectedItem(null);
        } else if (cmbProvince.getSelectedItem().equals("Tarlac")) {
            cmbCity.removeAllItems();
            cmbCity.addItem("Anao");
            cmbCity.addItem("Bamban");
            cmbCity.addItem("Camiling");
            cmbCity.addItem("Capas");
            cmbCity.addItem("Concepcion");
            cmbCity.addItem("Gerona");
            cmbCity.addItem("La Paz");
            cmbCity.addItem("Mayantoc");
            cmbCity.addItem("Moncada");
            cmbCity.addItem("Paniqui");
            cmbCity.addItem("Pura");
            cmbCity.addItem("Ramos");
            cmbCity.addItem("San Clemente");
            cmbCity.addItem("San Jose");
            cmbCity.addItem("San Manuel");
            cmbCity.addItem("Santa Ignacia");
            cmbCity.addItem("Tarlac");
            cmbCity.addItem("Victoria");
            cmbCity.setSelectedItem(null);
        } else if (cmbProvince.getSelectedItem().equals("Zambales")) {
            cmbCity.removeAllItems();
            cmbCity.addItem("Botolan");
            cmbCity.addItem("Cabangan");
            cmbCity.addItem("Candelaria");
            cmbCity.addItem("Castillejos");
            cmbCity.addItem("Iba");
            cmbCity.addItem("Masinloc");
            cmbCity.addItem("Olongapo");
            cmbCity.addItem("Palauig");
            cmbCity.addItem("San Antonio");
            cmbCity.addItem("San Felipe");
            cmbCity.addItem("San Marcelino");
            cmbCity.addItem("San Narciso");
            cmbCity.addItem("Santa Cruz");
            cmbCity.addItem("Subic");
            cmbCity.setSelectedItem(null);
        } else if (cmbProvince.getSelectedItem().equals("Agusan del Norte")) {
            cmbCity.removeAllItems();
            cmbCity.addItem("Buenavista");
            cmbCity.addItem("Butuan");
            cmbCity.addItem("Cabadbaran");
            cmbCity.addItem("Carmen");
            cmbCity.addItem("Jabonga");
            cmbCity.addItem("Kitcharao");
            cmbCity.addItem("Las Nieves");
            cmbCity.addItem("Magallanes");
            cmbCity.addItem("Nasipit");
            cmbCity.addItem("Remedios T. Romualdez");
            cmbCity.addItem("Santiago");
            cmbCity.addItem("Tubay");
            cmbCity.setSelectedItem(null);
        } else if (cmbProvince.getSelectedItem().equals("Agusan del Sur")) {
            cmbCity.removeAllItems();
            cmbCity.addItem("Bayugan");
            cmbCity.addItem("Bunawan");
            cmbCity.addItem("Esperanza");
            cmbCity.addItem("La Paz");
            cmbCity.addItem("Loreto");
            cmbCity.addItem("Prosperidad");
            cmbCity.addItem("Rosario");
            cmbCity.addItem("San Francisco");
            cmbCity.addItem("San Luis");
            cmbCity.addItem("Santa Josefa");
            cmbCity.addItem("Sibagat");
            cmbCity.addItem("Talacogon");
            cmbCity.addItem("Trento");
            cmbCity.addItem("Veruela");
            cmbCity.setSelectedItem(null);
        } else if (cmbProvince.getSelectedItem().equals("Basilan")) {
            cmbCity.removeAllItems();
            cmbCity.addItem("Akbar");
            cmbCity.addItem("Al-Barka");
            cmbCity.addItem("Hadji Mohammad Ajul");
            cmbCity.addItem("Hadji Muhtamad");
            cmbCity.addItem("Lamitan");
            cmbCity.addItem("Lantawan");
            cmbCity.addItem("Maluso");
            cmbCity.addItem("Sumisip");
            cmbCity.addItem("Tabuan-Lasa");
            cmbCity.addItem("Tipo-Tipo");
            cmbCity.addItem("Tuburan");
            cmbCity.addItem("Ungkaya Pukan");
            cmbCity.setSelectedItem(null);
        } else if (cmbProvince.getSelectedItem().equals("Bukidnon")) {
            cmbCity.removeAllItems();
            cmbCity.addItem("Baungon");
            cmbCity.addItem("Cabanglasan");
            cmbCity.addItem("Damulog");
            cmbCity.addItem("Dangcagan");
            cmbCity.addItem("Don Carlos");
            cmbCity.addItem("Impasug-ong");
            cmbCity.addItem("Kadingilan");
            cmbCity.addItem("Kalilangan");
            cmbCity.addItem("Kibawe");
            cmbCity.addItem("Kitaotao");
            cmbCity.addItem("Lantapan");
            cmbCity.addItem("Libona");
            cmbCity.addItem("Malaybalay");
            cmbCity.addItem("Malitbog");
            cmbCity.addItem("Manolo Fortich");
            cmbCity.addItem("Maramag");
            cmbCity.addItem("Pangantucan");
            cmbCity.addItem("Quezon");
            cmbCity.addItem("San Fernando");
            cmbCity.addItem("Sumilao");
            cmbCity.addItem("Talakag");
            cmbCity.addItem("Valencia");
            cmbCity.setSelectedItem(null);
        } else if (cmbProvince.getSelectedItem().equals("Camiguin")) {
            cmbCity.removeAllItems();
            cmbCity.addItem("Catarman");
            cmbCity.addItem("Guinsiliban");
            cmbCity.addItem("Mahinog");
            cmbCity.addItem("Mambajao");
            cmbCity.addItem("Sagay");
            cmbCity.addItem("City of Isabela");
            cmbCity.addItem("Isabela");
            cmbCity.setSelectedItem(null);
        } else if (cmbProvince.getSelectedItem().equals("Compostela Valley")) {
            cmbCity.removeAllItems();
            cmbCity.addItem("Compostela");
            cmbCity.addItem("Laak (San Vicente)");
            cmbCity.addItem("Mabini (Doña Alicia)");
            cmbCity.addItem("Maco");
            cmbCity.addItem("Maragusan (San Mariano)");
            cmbCity.addItem("Mawab");
            cmbCity.addItem("Monkayo");
            cmbCity.addItem("Montevista");
            cmbCity.addItem("Nabunturan");
            cmbCity.addItem("New Bataan");
            cmbCity.addItem("Pantukan");
            cmbCity.setSelectedItem(null);
        } else if (cmbProvince.getSelectedItem().equals("Cotabato")) {
            cmbCity.removeAllItems();
            cmbCity.addItem("Alamada");
            cmbCity.addItem("Aleosan");
            cmbCity.addItem("Antipas");
            cmbCity.addItem("Arakan");
            cmbCity.addItem("Banisilan");
            cmbCity.addItem("Carmen");
            cmbCity.addItem("Kabacan");
            cmbCity.addItem("Kidapawan");
            cmbCity.addItem("Libungan");
            cmbCity.addItem("Magpet");
            cmbCity.addItem("Makilala");
            cmbCity.addItem("Matalam");
            cmbCity.addItem("Midsayap");
            cmbCity.addItem("M’lang");
            cmbCity.addItem("Pigkawayan (Pigcawayan)");
            cmbCity.addItem("Pikit");
            cmbCity.addItem("President Roxas");
            cmbCity.addItem("Tulunan");
            cmbCity.addItem("Cotabato City");
            cmbCity.addItem("Cotabato");
            cmbCity.setSelectedItem(null);
        } else if (cmbProvince.getSelectedItem().equals("Davao del Norte")) {
            cmbCity.removeAllItems();
            cmbCity.addItem("Asuncion (Saug)");
            cmbCity.addItem("Braulio E. Dujali");
            cmbCity.addItem("Carmen");
            cmbCity.addItem("Kapalong");
            cmbCity.addItem("New Corella");
            cmbCity.addItem("Panabo");
            cmbCity.addItem("Samal (Island Garden City of Samal)");
            cmbCity.addItem("San Isidro");
            cmbCity.addItem("Santo Tomas");
            cmbCity.addItem("Tagum");
            cmbCity.addItem("Talaingod");
            cmbCity.setSelectedItem(null);
        } else if (cmbProvince.getSelectedItem().equals("Davao del Sur")) {
            cmbCity.removeAllItems();
            cmbCity.addItem("Bansalan");
            cmbCity.addItem("Davao");
            cmbCity.addItem("Digos");
            cmbCity.addItem("Hagonoy");
            cmbCity.addItem("Kiblawan");
            cmbCity.addItem("Magsaysay");
            cmbCity.addItem("Malalag");
            cmbCity.addItem("Matanao");
            cmbCity.addItem("Padada");
            cmbCity.addItem("Santa Cruz");
            cmbCity.addItem("Sulop");
            cmbCity.setSelectedItem(null);
        } else if (cmbProvince.getSelectedItem().equals("Davao Occidental")) {
            cmbCity.removeAllItems();
            cmbCity.addItem("Don Marcelino");
            cmbCity.addItem("Jose Abad Santos (Trinidad)");
            cmbCity.addItem("Malita");
            cmbCity.addItem("Santa Maria");
            cmbCity.addItem("Sarangani");
            cmbCity.addItem("Davao Oriental : Province");
            cmbCity.addItem("Baganga");
            cmbCity.addItem("Banaybanay");
            cmbCity.addItem("Boston");
            cmbCity.addItem("Caraga");
            cmbCity.addItem("Cateel");
            cmbCity.addItem("Governor Generoso");
            cmbCity.addItem("Lupon");
            cmbCity.addItem("Manay");
            cmbCity.addItem("Mati");
            cmbCity.addItem("San Isidro");
            cmbCity.setSelectedItem(null);
        } else if (cmbProvince.getSelectedItem().equals("Tarragona")) {
            cmbCity.removeAllItems();
            cmbCity.addItem("Dinagat Islands : Province");
            cmbCity.addItem("Basilisa (Rizal)");
            cmbCity.addItem("Cagdianao");
            cmbCity.addItem("Dinagat");
            cmbCity.addItem("Libjo (Albor)");
            cmbCity.addItem("Loreto");
            cmbCity.addItem("San Jose");
            cmbCity.addItem("Tubajon");
            cmbCity.setSelectedItem(null);
        } else if (cmbProvince.getSelectedItem().equals("Lanao del Norte")) {
            cmbCity.removeAllItems();
            cmbCity.addItem("Bacolod");
            cmbCity.addItem("Baloi (Balo-i)");
            cmbCity.addItem("Baroy");
            cmbCity.addItem("Iligan");
            cmbCity.addItem("Kapatagan");
            cmbCity.addItem("Kauswagan");
            cmbCity.addItem("Kolambugan");
            cmbCity.addItem("Lala");
            cmbCity.addItem("Linamon");
            cmbCity.addItem("Magsaysay");
            cmbCity.addItem("Maigo");
            cmbCity.addItem("Matungao");
            cmbCity.addItem("Munai");
            cmbCity.addItem("Nunungan");
            cmbCity.addItem("Pantao Ragat");
            cmbCity.addItem("Pantar");
            cmbCity.addItem("Poona Piagapo");
            cmbCity.addItem("Salvador");
            cmbCity.addItem("Sapad");
            cmbCity.addItem("Sultan Naga Dimaporo (Karomatan)");
            cmbCity.addItem("Tagoloan");
            cmbCity.addItem("Tangcal");
            cmbCity.addItem("Tubod");
            cmbCity.setSelectedItem(null);
        } else if (cmbProvince.getSelectedItem().equals("Lanao del Sur")) {
            cmbCity.removeAllItems();
            cmbCity.addItem("Bacolod-Kalawi (Bacolod Grande)");
            cmbCity.addItem("Balabagan");
            cmbCity.addItem("Balindong (Watu)");
            cmbCity.addItem("Bayang");
            cmbCity.addItem("Binidayan");
            cmbCity.addItem("Buadiposo-Buntong");
            cmbCity.addItem("Bubong");
            cmbCity.addItem("Bumbaran (Amai Manabilang)");
            cmbCity.addItem("Butig");
            cmbCity.addItem("Calanogas");
            cmbCity.addItem("Ditsaan-Ramain");
            cmbCity.addItem("Ganassi");
            cmbCity.addItem("Kapai");
            cmbCity.addItem("Kapatagan");
            cmbCity.addItem("Lumba-Bayabao (Maguing)");
            cmbCity.addItem("Lumbaca-Unayan");
            cmbCity.addItem("Lumbatan");
            cmbCity.addItem("Lumbayanague");
            cmbCity.addItem("Madalum");
            cmbCity.addItem("Madamba");
            cmbCity.addItem("Maguing");
            cmbCity.addItem("Malabang");
            cmbCity.addItem("Marantao");
            cmbCity.addItem("Marawi");
            cmbCity.addItem("Marogong");
            cmbCity.addItem("Masiu");
            cmbCity.addItem("Mulondo");
            cmbCity.addItem("Pagayawan (Tatarikan)");
            cmbCity.addItem("Piagapo");
            cmbCity.addItem("Picong (Sultan Gumander)");
            cmbCity.addItem("Poona Bayabao (Gata)");
            cmbCity.addItem("Pualas");
            cmbCity.addItem("Saguiaran");
            cmbCity.addItem("Sultan Dumalondong");
            cmbCity.addItem("Tagoloan II");
            cmbCity.addItem("Tamparan");
            cmbCity.addItem("Taraka");
            cmbCity.addItem("Tubaran");
            cmbCity.addItem("Tugaya");
            cmbCity.addItem("Wao");
            cmbCity.setSelectedItem(null);
        } else if (cmbProvince.getSelectedItem().equals("Maguindanao")) {
            cmbCity.removeAllItems();
            cmbCity.addItem("Ampatuan");
            cmbCity.addItem("Barira");
            cmbCity.addItem("Buldon");
            cmbCity.addItem("Buluan");
            cmbCity.addItem("Datu Abdullah Sangki");
            cmbCity.addItem("Datu Anggal Midtimbang");
            cmbCity.addItem("Datu Blah T. Sinsuat");
            cmbCity.addItem("Datu Hoffer Ampatuan (← Shariff Aguak)");
            cmbCity.addItem("Datu Odin Sinsuat (Dinaig)");
            cmbCity.addItem("Datu Paglas");
            cmbCity.addItem("Datu Piang");
            cmbCity.addItem("Datu Salibo (← Datu Piang)");
            cmbCity.addItem("Datu Saudi-Ampatuan");
            cmbCity.addItem("Datu Unsay");
            cmbCity.addItem("General Salipada K. Pendatun");
            cmbCity.addItem("Guindulungan");
            cmbCity.addItem("Kabuntalan (Tumbao)");
            cmbCity.addItem("Mamasapano");
            cmbCity.addItem("Mangudadatu");
            cmbCity.addItem("Matanog");
            cmbCity.addItem("Northern Kabuntalan");
            cmbCity.addItem("Pagagawan (Datu Montawal)");
            cmbCity.addItem("Pagalungan");
            cmbCity.addItem("Paglat");
            cmbCity.addItem("Pandag");
            cmbCity.addItem("Parang");
            cmbCity.addItem("Rajah Buayan");
            cmbCity.addItem("Shariff Aguak (Maganoy)");
            cmbCity.addItem("Shariff Saydona Mustapha");
            cmbCity.addItem("South Upi");
            cmbCity.addItem("Sultan Kudarat (Nuling)");
            cmbCity.addItem("Sultan Mastura");
            cmbCity.addItem("Sultan sa Barongis (Lambayong)");
            cmbCity.addItem("Talayan");
            cmbCity.addItem("Talitay (Sultan Sumagka)");
            cmbCity.addItem("Upi");
            cmbCity.setSelectedItem(null);
        } else if (cmbProvince.getSelectedItem().equals("Misamis Occidental")) {
            cmbCity.removeAllItems();
            cmbCity.addItem("Aloran");
            cmbCity.addItem("Baliangao");
            cmbCity.addItem("Bonifacio");
            cmbCity.addItem("Calamba");
            cmbCity.addItem("Clarin");
            cmbCity.addItem("Concepcion");
            cmbCity.addItem("Don Victoriano Chiongbian (Don Mariano Marcos)");
            cmbCity.addItem("Jimenez");
            cmbCity.addItem("Lopez Jaena");
            cmbCity.addItem("Oroquieta");
            cmbCity.addItem("Ozamis (Ozamiz)");
            cmbCity.addItem("Panaon");
            cmbCity.addItem("Plaridel");
            cmbCity.addItem("Sapang Dalaga");
            cmbCity.addItem("Sinacaban");
            cmbCity.addItem("Tangub");
            cmbCity.addItem("Tudela");
            cmbCity.setSelectedItem(null);
        } else if (cmbProvince.getSelectedItem().equals("Misamis Oriental")) {
            cmbCity.removeAllItems();
            cmbCity.addItem("Alubijid");
            cmbCity.addItem("Balingasag");
            cmbCity.addItem("Balingoan");
            cmbCity.addItem("Binuangan");
            cmbCity.addItem("Cagayan de Oro");
            cmbCity.addItem("Claveria");
            cmbCity.addItem("El Salvador");
            cmbCity.addItem("Gingoog");
            cmbCity.addItem("Gitagum");
            cmbCity.addItem("Initao");
            cmbCity.addItem("Jasaan");
            cmbCity.addItem("Kinoguitan");
            cmbCity.addItem("Lagonglong");
            cmbCity.addItem("Laguindingan");
            cmbCity.addItem("Libertad");
            cmbCity.addItem("Lugait");
            cmbCity.addItem("Magsaysay (Linugos)");
            cmbCity.addItem("Manticao");
            cmbCity.addItem("Medina");
            cmbCity.addItem("Naawan");
            cmbCity.addItem("Opol");
            cmbCity.addItem("Salay");
            cmbCity.addItem("Sugbongcogon");
            cmbCity.addItem("Tagoloan");
            cmbCity.addItem("Talisayan");
            cmbCity.addItem("Villanueva");
            cmbCity.setSelectedItem(null);
        } else if (cmbProvince.getSelectedItem().equals("Sarangani")) {
            cmbCity.removeAllItems();
            cmbCity.addItem("Alabel");
            cmbCity.addItem("Glan");
            cmbCity.addItem("Kiamba");
            cmbCity.addItem("Maasim");
            cmbCity.addItem("Maitum");
            cmbCity.addItem("Malapatan");
            cmbCity.addItem("Malungon");
            cmbCity.setSelectedItem(null);
        } else if (cmbProvince.getSelectedItem().equals("South Cotabato")) {
            cmbCity.removeAllItems();
            cmbCity.addItem("Banga");
            cmbCity.addItem("General Santos (Dadiangas)");
            cmbCity.addItem("Koronadal");
            cmbCity.addItem("Lake Sebu");
            cmbCity.addItem("Norala");
            cmbCity.addItem("Polomolok");
            cmbCity.addItem("Santo Niño");
            cmbCity.addItem("Surallah");
            cmbCity.addItem("Tampakan");
            cmbCity.addItem("Tantangan");
            cmbCity.addItem("T’Boli");
            cmbCity.addItem("Tupi");
            cmbCity.setSelectedItem(null);
        } else if (cmbProvince.getSelectedItem().equals("Sultan Kudarat")) {
            cmbCity.removeAllItems();
            cmbCity.addItem("Bagumbayan");
            cmbCity.addItem("Columbio");
            cmbCity.addItem("Esperanza");
            cmbCity.addItem("Isulan");
            cmbCity.addItem("Kalamansig");
            cmbCity.addItem("Lambayong (Mariano Marcos)");
            cmbCity.addItem("Lebak");
            cmbCity.addItem("Lutayan");
            cmbCity.addItem("Palimbang");
            cmbCity.addItem("President Quirino");
            cmbCity.addItem("Senator Ninoy Aquino (Senator Ninoy Aquino)");
            cmbCity.addItem("Tacurong");
            cmbCity.setSelectedItem(null);
        } else if (cmbProvince.getSelectedItem().equals("Sulu")) {
            cmbCity.removeAllItems();
            cmbCity.addItem("Hadji Panglima Tahil (Marunggas) : Municipality");
            cmbCity.addItem("Indanan : Municipality");
            cmbCity.addItem("Jolo : Municipality");
            cmbCity.addItem("Kalingalan Caluang : Municipality");
            cmbCity.addItem("Lugus : Municipality");
            cmbCity.addItem("Luuk : Municipality");
            cmbCity.addItem("Maimbung : Municipality");
            cmbCity.addItem("Old Panamao : Municipality");
            cmbCity.addItem("Omar : Municipality");
            cmbCity.addItem("Pandami : Municipality");
            cmbCity.addItem("Panglima Estino (New Panamao) : Municipality");
            cmbCity.addItem("Pangutaran : Municipality");
            cmbCity.addItem("Parang : Municipality");
            cmbCity.addItem("Pata : Municipality");
            cmbCity.addItem("Patikul : Municipality");
            cmbCity.addItem("Siasi : Municipality");
            cmbCity.addItem("Talipao : Municipality");
            cmbCity.addItem("Tapul : Municipality");
            cmbCity.addItem("Tongkil (Banguingui) : Municipality");
            cmbCity.setSelectedItem(null);
        } else if (cmbProvince.getSelectedItem().equals("Surigao del Norte")) {
            cmbCity.removeAllItems();
            cmbCity.addItem("Alegria");
            cmbCity.addItem("Bacuag");
            cmbCity.addItem("Burgos");
            cmbCity.addItem("Claver");
            cmbCity.addItem("Dapa");
            cmbCity.addItem("Del Carmen");
            cmbCity.addItem("General Luna");
            cmbCity.addItem("Gigaquit");
            cmbCity.addItem("Mainit");
            cmbCity.addItem("Malimono");
            cmbCity.addItem("Pilar");
            cmbCity.addItem("Placer");
            cmbCity.addItem("San Benito");
            cmbCity.addItem("San Francisco (Anao-Aon)");
            cmbCity.addItem("San Isidro");
            cmbCity.addItem("Santa Monica (Sapao)");
            cmbCity.addItem("Sison");
            cmbCity.addItem("Socorro");
            cmbCity.addItem("Surigao");
            cmbCity.addItem("Tagana-an");
            cmbCity.addItem("Tubod");
            cmbCity.setSelectedItem(null);
        } else if (cmbProvince.getSelectedItem().equals("Surigao del Sur")) {
            cmbCity.removeAllItems();
            cmbCity.addItem("Barobo");
            cmbCity.addItem("Bayabas");
            cmbCity.addItem("Bislig");
            cmbCity.addItem("Cagwait");
            cmbCity.addItem("Cantilan");
            cmbCity.addItem("Carmen");
            cmbCity.addItem("Carrascal");
            cmbCity.addItem("Cortes");
            cmbCity.addItem("Hinatuan");
            cmbCity.addItem("Lanuza");
            cmbCity.addItem("Lianga");
            cmbCity.addItem("Lingig");
            cmbCity.addItem("Madrid");
            cmbCity.addItem("Marihatag");
            cmbCity.addItem("San Agustin");
            cmbCity.addItem("San Miguel");
            cmbCity.addItem("Tagbina");
            cmbCity.addItem("Tago");
            cmbCity.addItem("Tandag");
            cmbCity.setSelectedItem(null);
        } else if (cmbProvince.getSelectedItem().equals("Tawi-Tawi")) {
            cmbCity.removeAllItems();
            cmbCity.addItem("Bongao");
            cmbCity.addItem("Languyan");
            cmbCity.addItem("Mapun (Cagayan de Tawi-Tawi)");
            cmbCity.addItem("Panglima Sugala (Balimbing)");
            cmbCity.addItem("Sapa-Sapa");
            cmbCity.addItem("Sibutu");
            cmbCity.addItem("Simunul");
            cmbCity.addItem("Sitangkai");
            cmbCity.addItem("South Ubian");
            cmbCity.addItem("Tandubas");
            cmbCity.addItem("Turtle Islands");
            cmbCity.setSelectedItem(null);
        } else if (cmbProvince.getSelectedItem().equals("Zamboanga del Norte")) {
            cmbCity.removeAllItems();
            cmbCity.addItem("Bacungan (Leon T. Postigo)");
            cmbCity.addItem("Baliguian");
            cmbCity.addItem("Dapitan");
            cmbCity.addItem("Dipolog");
            cmbCity.addItem("Godod");
            cmbCity.addItem("Gutalac");
            cmbCity.addItem("Jose Dalman (Ponot)");
            cmbCity.addItem("Kalawit");
            cmbCity.addItem("Katipunan");
            cmbCity.addItem("Labason");
            cmbCity.addItem("La Libertad");
            cmbCity.addItem("Liloy");
            cmbCity.addItem("Manukan");
            cmbCity.addItem("Mutia");
            cmbCity.addItem("Piñan (New Piñan)");
            cmbCity.addItem("Polanco");
            cmbCity.addItem("President Manuel A. Roxas");
            cmbCity.addItem("Rizal");
            cmbCity.addItem("Salug");
            cmbCity.addItem("Sergio Osmeña Sr.");
            cmbCity.addItem("Siayan");
            cmbCity.addItem("Sibuco");
            cmbCity.addItem("Sibutad");
            cmbCity.addItem("Sindangan");
            cmbCity.addItem("Siocon");
            cmbCity.addItem("Sirawai");
            cmbCity.addItem("Tampilisan");
            cmbCity.setSelectedItem(null);
        } else if (cmbProvince.getSelectedItem().equals("Zamboanga del Sur")) {
            cmbCity.removeAllItems();
            cmbCity.addItem("Aurora");
            cmbCity.addItem("Bayog");
            cmbCity.addItem("Dimataling");
            cmbCity.addItem("Dinas");
            cmbCity.addItem("Dumalinao");
            cmbCity.addItem("Dumingag");
            cmbCity.addItem("Guipos");
            cmbCity.addItem("Josefina");
            cmbCity.addItem("Kumalarang");
            cmbCity.addItem("Labangan");
            cmbCity.addItem("Lakewood");
            cmbCity.addItem("Lapuyan");
            cmbCity.addItem("Mahayag");
            cmbCity.addItem("Margosatubig");
            cmbCity.addItem("Midsalip");
            cmbCity.addItem("Molave");
            cmbCity.addItem("Pagadian");
            cmbCity.addItem("Pitogo");
            cmbCity.addItem("Ramon Magsaysay (Liargo)");
            cmbCity.addItem("San Miguel");
            cmbCity.addItem("San Pablo");
            cmbCity.addItem("Sominot (Don Mariano Marcos)");
            cmbCity.addItem("Tabina");
            cmbCity.addItem("Tambulig");
            cmbCity.addItem("Tigbao");
            cmbCity.addItem("Tukuran");
            cmbCity.addItem("Vincenzo A. Sagun");
            cmbCity.addItem("Zamboanga");
            cmbCity.setSelectedItem(null);
        } else if (cmbProvince.getSelectedItem().equals("Zamboanga Sibugay")) {
            cmbCity.removeAllItems();
            cmbCity.addItem("Alicia");
            cmbCity.addItem("Buug");
            cmbCity.addItem("Diplahan");
            cmbCity.addItem("Imelda");
            cmbCity.addItem("Ipil");
            cmbCity.addItem("Kabasalan");
            cmbCity.addItem("Mabuhay");
            cmbCity.addItem("Malangas");
            cmbCity.addItem("Naga");
            cmbCity.addItem("Olutanga");
            cmbCity.addItem("Payao");
            cmbCity.addItem("Roseller Lim");
            cmbCity.addItem("Siay");
            cmbCity.addItem("Talusan");
            cmbCity.addItem("Titay");
            cmbCity.addItem("Tungawan");
            cmbCity.setSelectedItem(null);
        } else if (cmbProvince.getSelectedItem().equals("Aklan")) {
            cmbCity.removeAllItems();
            cmbCity.addItem("Altavas");
            cmbCity.addItem("Balete");
            cmbCity.addItem("Banga");
            cmbCity.addItem("Batan");
            cmbCity.addItem("Buruanga");
            cmbCity.addItem("Ibajay");
            cmbCity.addItem("Kalibo");
            cmbCity.addItem("Lezo");
            cmbCity.addItem("Libacao");
            cmbCity.addItem("Madalag");
            cmbCity.addItem("Makato");
            cmbCity.addItem("Malay");
            cmbCity.addItem("Malinao");
            cmbCity.addItem("Nabas");
            cmbCity.addItem("New Washington");
            cmbCity.addItem("Numancia");
            cmbCity.addItem("Tangalan");
            cmbCity.setSelectedItem(null);
        } else if (cmbProvince.getSelectedItem().equals("Antique")) {
            cmbCity.removeAllItems();
            cmbCity.addItem("Anini-y");
            cmbCity.addItem("Barbaza");
            cmbCity.addItem("Belison");
            cmbCity.addItem("Bugasong");
            cmbCity.addItem("Caluya");
            cmbCity.addItem("Culasi");
            cmbCity.addItem("Hamtic");
            cmbCity.addItem("Laua-an");
            cmbCity.addItem("Libertad");
            cmbCity.addItem("Pandan");
            cmbCity.addItem("Patnongon");
            cmbCity.addItem("San Jose (San Jose de Buenavista)");
            cmbCity.addItem("San Remigio");
            cmbCity.addItem("Sebaste");
            cmbCity.addItem("Sibalom");
            cmbCity.addItem("Tibiao");
            cmbCity.addItem("Tobias Fornier (Dao)");
            cmbCity.addItem("Valderrama");
            cmbCity.setSelectedItem(null);
        } else if (cmbProvince.getSelectedItem().equals("Biliran")) {
            cmbCity.removeAllItems();
            cmbCity.addItem("Almeria");
            cmbCity.addItem("Biliran");
            cmbCity.addItem("Cabucgayan");
            cmbCity.addItem("Caibiran");
            cmbCity.addItem("Culaba");
            cmbCity.addItem("Kawayan");
            cmbCity.addItem("Maripipi");
            cmbCity.addItem("Naval");
            cmbCity.setSelectedItem(null);
        } else if (cmbProvince.getSelectedItem().equals("Bohol")) {
            cmbCity.removeAllItems();
            cmbCity.addItem("Alburquerque");
            cmbCity.addItem("Alicia");
            cmbCity.addItem("Anda");
            cmbCity.addItem("Antequera");
            cmbCity.addItem("Baclayon");
            cmbCity.addItem("Balilihan");
            cmbCity.addItem("Batuan");
            cmbCity.addItem("Bien Unido");
            cmbCity.addItem("Bilar");
            cmbCity.addItem("Buenavista");
            cmbCity.addItem("Calape");
            cmbCity.addItem("Candijay");
            cmbCity.addItem("Carmen");
            cmbCity.addItem("Catigbian");
            cmbCity.addItem("Clarin");
            cmbCity.addItem("Corella");
            cmbCity.addItem("Cortes");
            cmbCity.addItem("Dagohoy");
            cmbCity.addItem("Danao");
            cmbCity.addItem("Dauis");
            cmbCity.addItem("Dimiao");
            cmbCity.addItem("Duero");
            cmbCity.addItem("Garcia Hernandez");
            cmbCity.addItem("Guindulman");
            cmbCity.addItem("Inabanga");
            cmbCity.addItem("Jagna");
            cmbCity.addItem("Jetafe (Getafe)");
            cmbCity.addItem("Lila");
            cmbCity.addItem("Loay");
            cmbCity.addItem("Loboc");
            cmbCity.addItem("Loon");
            cmbCity.addItem("Mabini");
            cmbCity.addItem("Maribojoc");
            cmbCity.addItem("Panglao");
            cmbCity.addItem("Pilar");
            cmbCity.addItem("President Carlos P. Garcia (Pitogo)");
            cmbCity.addItem("Sagbayan (Borja)");
            cmbCity.addItem("San Isidro");
            cmbCity.addItem("San Miguel");
            cmbCity.addItem("Sevilla");
            cmbCity.addItem("Sierra Bullones");
            cmbCity.addItem("Sikatuna");
            cmbCity.addItem("Tagbilaran");
            cmbCity.addItem("Talibon");
            cmbCity.addItem("Trinidad");
            cmbCity.addItem("Tubigon");
            cmbCity.addItem("Ubay");
            cmbCity.addItem("Valencia");
            cmbCity.setSelectedItem(null);
        } else if (cmbProvince.getSelectedItem().equals("Capiz")) {
            cmbCity.removeAllItems();
            cmbCity.addItem("Cuartero");
            cmbCity.addItem("Dao");
            cmbCity.addItem("Dumalag");
            cmbCity.addItem("Dumarao");
            cmbCity.addItem("Ivisan");
            cmbCity.addItem("Jamindan");
            cmbCity.addItem("Ma-ayon");
            cmbCity.addItem("Mambusao");
            cmbCity.addItem("Panay");
            cmbCity.addItem("Panitan");
            cmbCity.addItem("Pilar");
            cmbCity.addItem("Pontevedra");
            cmbCity.addItem("President Roxas");
            cmbCity.addItem("Roxas");
            cmbCity.addItem("Sapi-an");
            cmbCity.addItem("Sigma");
            cmbCity.addItem("Tapaz");
            cmbCity.setSelectedItem(null);
        } else if (cmbProvince.getSelectedItem().equals("Cebu")) {
            cmbCity.removeAllItems();
            cmbCity.addItem("Alcantara");
            cmbCity.addItem("Alcoy");
            cmbCity.addItem("Alegria");
            cmbCity.addItem("Aloguinsan");
            cmbCity.addItem("Argao");
            cmbCity.addItem("Asturias");
            cmbCity.addItem("Badian");
            cmbCity.addItem("Balamban");
            cmbCity.addItem("Bantayan");
            cmbCity.addItem("Barili");
            cmbCity.addItem("Bogo");
            cmbCity.addItem("Boljoon");
            cmbCity.addItem("Borbon");
            cmbCity.addItem("Carcar");
            cmbCity.addItem("Carmen");
            cmbCity.addItem("Catmon");
            cmbCity.addItem("Cebu");
            cmbCity.addItem("Compostela");
            cmbCity.addItem("Consolacion");
            cmbCity.addItem("Cordoba (Cordova)");
            cmbCity.addItem("Daanbantayan");
            cmbCity.addItem("Dalaguete");
            cmbCity.addItem("Danao");
            cmbCity.addItem("Dumanjug");
            cmbCity.addItem("Ginatilan");
            cmbCity.addItem("Lapu-Lapu (Opon)");
            cmbCity.addItem("Liloan");
            cmbCity.addItem("Madridejos");
            cmbCity.addItem("Malabuyoc");
            cmbCity.addItem("Mandaue");
            cmbCity.addItem("Medellin");
            cmbCity.addItem("Minglanilla");
            cmbCity.addItem("Moalboal");
            cmbCity.addItem("Naga");
            cmbCity.addItem("Oslob");
            cmbCity.addItem("Pilar");
            cmbCity.addItem("Pinamungahan (Pinamungajan)");
            cmbCity.addItem("Poro");
            cmbCity.addItem("Ronda");
            cmbCity.addItem("Samboan");
            cmbCity.addItem("San Fernando");
            cmbCity.addItem("San Francisco");
            cmbCity.addItem("San Remigio");
            cmbCity.addItem("Santa Fe");
            cmbCity.addItem("Santander");
            cmbCity.addItem("Sibonga");
            cmbCity.addItem("Sogod");
            cmbCity.addItem("Tabogon");
            cmbCity.addItem("Tabuelan");
            cmbCity.addItem("Talisay");
            cmbCity.addItem("Toledo");
            cmbCity.addItem("Tuburan");
            cmbCity.addItem("Tudela");
            cmbCity.setSelectedItem(null);
        } else if (cmbProvince.getSelectedItem().equals("Eastern Samar")) {
            cmbCity.removeAllItems();
            cmbCity.addItem("Arteche");
            cmbCity.addItem("Balangiga");
            cmbCity.addItem("Balangkayan");
            cmbCity.addItem("Borongan");
            cmbCity.addItem("Can-avid");
            cmbCity.addItem("Dolores");
            cmbCity.addItem("General MacArthur");
            cmbCity.addItem("Giporlos");
            cmbCity.addItem("Guiuan");
            cmbCity.addItem("Hernani");
            cmbCity.addItem("Jipapad");
            cmbCity.addItem("Lawaan");
            cmbCity.addItem("Llorente");
            cmbCity.addItem("Maslog");
            cmbCity.addItem("Maydolong");
            cmbCity.addItem("Mercedes");
            cmbCity.addItem("Oras");
            cmbCity.addItem("Quinapondan");
            cmbCity.addItem("Salcedo");
            cmbCity.addItem("San Julian");
            cmbCity.addItem("San Policarpo");
            cmbCity.addItem("Sulat");
            cmbCity.addItem("Taft");
            cmbCity.setSelectedItem(null);
        } else if (cmbProvince.getSelectedItem().equals("Guimaras")) {
            cmbCity.removeAllItems();
            cmbCity.addItem("Buenavista");
            cmbCity.addItem("Jordan");
            cmbCity.addItem("Nueva Valencia");
            cmbCity.addItem("San Lorenzo");
            cmbCity.addItem("Sibunag");
            cmbCity.setSelectedItem(null);
        } else if (cmbProvince.getSelectedItem().equals("Iloilo")) {
            cmbCity.removeAllItems();
            cmbCity.addItem("Ajuy");
            cmbCity.addItem("Alimodian");
            cmbCity.addItem("Anilao");
            cmbCity.addItem("Badiangan");
            cmbCity.addItem("Balasan");
            cmbCity.addItem("Banate");
            cmbCity.addItem("Barotac Nuevo");
            cmbCity.addItem("Barotac Viejo");
            cmbCity.addItem("Batad");
            cmbCity.addItem("Bingawan");
            cmbCity.addItem("Cabatuan");
            cmbCity.addItem("Calinog");
            cmbCity.addItem("Carles");
            cmbCity.addItem("Concepcion");
            cmbCity.addItem("Dingle");
            cmbCity.addItem("Dueñas (Dueñas)");
            cmbCity.addItem("Dumangas");
            cmbCity.addItem("Estancia");
            cmbCity.addItem("Guimbal");
            cmbCity.addItem("Igbaras");
            cmbCity.addItem("Iloilo");
            cmbCity.addItem("Janiuay");
            cmbCity.addItem("Lambunao");
            cmbCity.addItem("Leganes");
            cmbCity.addItem("Lemery");
            cmbCity.addItem("Leon");
            cmbCity.addItem("Maasin");
            cmbCity.addItem("Miagao");
            cmbCity.addItem("Mina");
            cmbCity.addItem("New Lucena");
            cmbCity.addItem("Oton");
            cmbCity.addItem("Passi");
            cmbCity.addItem("Pavia");
            cmbCity.addItem("Pototan");
            cmbCity.addItem("San Dionisio");
            cmbCity.addItem("San Enrique");
            cmbCity.addItem("San Joaquin");
            cmbCity.addItem("San Miguel");
            cmbCity.addItem("San Rafael");
            cmbCity.addItem("Santa Barbara");
            cmbCity.addItem("Sara");
            cmbCity.addItem("Tigbauan");
            cmbCity.addItem("Tubungan");
            cmbCity.addItem("Zarraga");
            cmbCity.setSelectedItem(null);
        } else if (cmbProvince.getSelectedItem().equals("Leyte")) {
            cmbCity.removeAllItems();
            cmbCity.addItem("Abuyog");
            cmbCity.addItem("Alangalang");
            cmbCity.addItem("Albuera");
            cmbCity.addItem("Babatngon");
            cmbCity.addItem("Barugo");
            cmbCity.addItem("Bato");
            cmbCity.addItem("Baybay");
            cmbCity.addItem("Burauen");
            cmbCity.addItem("Calubian");
            cmbCity.addItem("Capoocan");
            cmbCity.addItem("Carigara");
            cmbCity.addItem("Dagami");
            cmbCity.addItem("Dulag");
            cmbCity.addItem("Hilongos");
            cmbCity.addItem("Hindang");
            cmbCity.addItem("Inopacan");
            cmbCity.addItem("Isabel");
            cmbCity.addItem("Jaro");
            cmbCity.addItem("Javier (Bugho)");
            cmbCity.addItem("Julita");
            cmbCity.addItem("Kananga");
            cmbCity.addItem("La Paz");
            cmbCity.addItem("Leyte");
            cmbCity.addItem("Macarthur");
            cmbCity.addItem("Mahaplag");
            cmbCity.addItem("Matag-ob");
            cmbCity.addItem("Matalom");
            cmbCity.addItem("Mayorga");
            cmbCity.addItem("Merida");
            cmbCity.addItem("Ormoc");
            cmbCity.addItem("Palo");
            cmbCity.addItem("Palompon");
            cmbCity.addItem("Pastrana");
            cmbCity.addItem("San Isidro");
            cmbCity.addItem("San Miguel");
            cmbCity.addItem("Santa Fe");
            cmbCity.addItem("Tabango");
            cmbCity.addItem("Tabontabon");
            cmbCity.addItem("Tacloban");
            cmbCity.addItem("Tanauan");
            cmbCity.addItem("Tolosa");
            cmbCity.addItem("Tunga");
            cmbCity.addItem("Villaba");
            cmbCity.setSelectedItem(null);
        } else if (cmbProvince.getSelectedItem().equals("Negros Occidental")) {
            cmbCity.removeAllItems();
            cmbCity.addItem("Bacolod");
            cmbCity.addItem("Bago");
            cmbCity.addItem("Binalbagan");
            cmbCity.addItem("Cadiz");
            cmbCity.addItem("Calatrava");
            cmbCity.addItem("Candoni");
            cmbCity.addItem("Cauayan");
            cmbCity.addItem("Enrique B. Magalona (Saravia)");
            cmbCity.addItem("Escalante");
            cmbCity.addItem("Himamaylan");
            cmbCity.addItem("Hinigaran");
            cmbCity.addItem("Hinoba-an (Asia)");
            cmbCity.addItem("Ilog");
            cmbCity.addItem("Isabela");
            cmbCity.addItem("Kabankalan");
            cmbCity.addItem("La Carlota");
            cmbCity.addItem("La Castellana");
            cmbCity.addItem("Manapla");
            cmbCity.addItem("Moises Padilla (Magallon)");
            cmbCity.addItem("Murcia");
            cmbCity.addItem("Pontevedra");
            cmbCity.addItem("Pulupandan");
            cmbCity.addItem("Sagay");
            cmbCity.addItem("Salvador Benedicto");
            cmbCity.addItem("San Carlos");
            cmbCity.addItem("San Enrique");
            cmbCity.addItem("Silay");
            cmbCity.addItem("Sipalay");
            cmbCity.addItem("Talisay");
            cmbCity.addItem("Toboso");
            cmbCity.addItem("Valladolid");
            cmbCity.addItem("Victorias");
            cmbCity.setSelectedItem(null);
        } else if (cmbProvince.getSelectedItem().equals("Negros Oriental")) {
            cmbCity.removeAllItems();
            cmbCity.addItem("Amlan (Ayuquitan)");
            cmbCity.addItem("Ayungon");
            cmbCity.addItem("Bacong");
            cmbCity.addItem("Bais");
            cmbCity.addItem("Basay");
            cmbCity.addItem("Bayawan (Tulong)");
            cmbCity.addItem("Bindoy (Payabon)");
            cmbCity.addItem("Canlaon");
            cmbCity.addItem("Dauin");
            cmbCity.addItem("Dumaguete");
            cmbCity.addItem("Guihulngan");
            cmbCity.addItem("Jimalalud");
            cmbCity.addItem("La Libertad");
            cmbCity.addItem("Mabinay");
            cmbCity.addItem("Manjuyod");
            cmbCity.addItem("Pamplona");
            cmbCity.addItem("San Jose");
            cmbCity.addItem("Santa Catalina");
            cmbCity.addItem("Siaton");
            cmbCity.addItem("Sibulan");
            cmbCity.addItem("Tanjay");
            cmbCity.addItem("Tayasan");
            cmbCity.addItem("Valencia (Luzurriaga)");
            cmbCity.addItem("Vallehermoso");
            cmbCity.addItem("Zamboanguita");
            cmbCity.setSelectedItem(null);
        } else if (cmbProvince.getSelectedItem().equals("Northern Samar")) {
            cmbCity.removeAllItems();
            cmbCity.addItem("Allen");
            cmbCity.addItem("Biri");
            cmbCity.addItem("Bobon");
            cmbCity.addItem("Capul");
            cmbCity.addItem("Catarman");
            cmbCity.addItem("Catubig");
            cmbCity.addItem("Gamay");
            cmbCity.addItem("Laoang");
            cmbCity.addItem("Lapinig");
            cmbCity.addItem("Las Navas");
            cmbCity.addItem("Lavezares");
            cmbCity.addItem("Lope de Vega");
            cmbCity.addItem("Mapanas");
            cmbCity.addItem("Mondragon");
            cmbCity.addItem("Palapag");
            cmbCity.addItem("Pambujan");
            cmbCity.addItem("Rosario");
            cmbCity.addItem("San Antonio");
            cmbCity.addItem("San Isidro");
            cmbCity.addItem("San Jose");
            cmbCity.addItem("San Roque");
            cmbCity.addItem("San Vicente");
            cmbCity.addItem("Silvino Lobos");
            cmbCity.addItem("Victoria");
            cmbCity.setSelectedItem(null);
        } else if (cmbProvince.getSelectedItem().equals("Samar")) {
            cmbCity.removeAllItems();
            cmbCity.addItem("Almagro");
            cmbCity.addItem("Basey");
            cmbCity.addItem("Calbayog");
            cmbCity.addItem("Calbiga");
            cmbCity.addItem("Catbalogan");
            cmbCity.addItem("Daram");
            cmbCity.addItem("Gandara");
            cmbCity.addItem("Hinabangan");
            cmbCity.addItem("Jiabong");
            cmbCity.addItem("Marabut");
            cmbCity.addItem("Matuguinao");
            cmbCity.addItem("Motiong");
            cmbCity.addItem("Pagsanghan");
            cmbCity.addItem("Paranas (Wright)");
            cmbCity.addItem("Pinabacdao");
            cmbCity.addItem("San Jorge");
            cmbCity.addItem("San Jose de Buan");
            cmbCity.addItem("San Sebastian");
            cmbCity.addItem("Santa Margarita");
            cmbCity.addItem("Santa Rita");
            cmbCity.addItem("Santo Niño");
            cmbCity.addItem("Tagapul-an");
            cmbCity.addItem("Talalora");
            cmbCity.addItem("Tarangnan");
            cmbCity.addItem("Villareal");
            cmbCity.addItem("Zumarraga");
            cmbCity.setSelectedItem(null);
        } else if (cmbProvince.getSelectedItem().equals("Siquijor")) {
            cmbCity.removeAllItems();
            cmbCity.addItem("Enrique Villanueva");
            cmbCity.addItem("Larena");
            cmbCity.addItem("Lazi");
            cmbCity.addItem("Maria");
            cmbCity.addItem("San Juan");
            cmbCity.addItem("Siquijor");
        } else if (cmbProvince.getSelectedItem().equals("Southern Leyte")) {
            cmbCity.removeAllItems();
            cmbCity.addItem("Anahawan");
            cmbCity.addItem("Bontoc");
            cmbCity.addItem("Hinunangan");
            cmbCity.addItem("Hinundayan");
            cmbCity.addItem("Libagon");
            cmbCity.addItem("Liloan");
            cmbCity.addItem("Limasawa");
            cmbCity.addItem("Maasin");
            cmbCity.addItem("Macrohon");
            cmbCity.addItem("Malitbog");
            cmbCity.addItem("Padre Burgos");
            cmbCity.addItem("Pintuyan");
            cmbCity.addItem("Saint Bernard");
            cmbCity.addItem("San Francisco");
            cmbCity.addItem("San Juan (Cabalian)");
            cmbCity.addItem("San Ricardo");
            cmbCity.addItem("Silago");
            cmbCity.addItem("Sogod");
            cmbCity.addItem("Tomas Oppus");
            cmbCity.setSelectedItem(null);
        }
    }//GEN-LAST:event_cmbProvinceActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        ImageIcon imageIcon = new ImageIcon("com\\raven\\icon\\NO_PIC.png");
        Image image = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(image);
        lblPicture.setIcon(icon);
        lblPicture.setText("      Upload Picture");
        txtFirstname.setText("");
        txtLastname.setText("");
        txtMiddlename.setText("");
        rbnGender.clearSelection();
        txtDate.setText("");
        cmbCivilStatus.setSelectedIndex(0);
        txtHouse.setText("");
        txtBarangay.setText("");
        cmbProvince.setSelectedIndex(0);
        cmbCity.setSelectedItem("Select:");
        txtZipCode.setText("");
        txtContactNo.setText("");
        btnGrpRole.clearSelection();
    }//GEN-LAST:event_btnClearActionPerformed
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
    private com.raven.swing.Button btnClear;
    private javax.swing.ButtonGroup btnGrpRole;
    private com.raven.swing.Button btnRegister;
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
