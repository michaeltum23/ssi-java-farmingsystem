/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package farmingsystem.view;

import farmingsystem.controller.UserImp;
import farmingsystem.model.User;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JRadioButton;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author MTUMANGAN
 */
public class RegisterForm extends javax.swing.JFrame {

    /**
     * Creates new form RegisterForm
     */
    public RegisterForm() {
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rbnGender = new javax.swing.ButtonGroup();
        dateChooser1 = new com.raven.datechooser.DateChooser();
        jPanel1 = new javax.swing.JPanel();
        btnRegister = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        txtUsername = new javax.swing.JTextField();
        txtMiddleName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();
        rbnMale = new javax.swing.JRadioButton();
        rbnFemale = new javax.swing.JRadioButton();
        txtDate = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtContactNumber = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtHouseNo = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtStreetAddress = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtCityAddress = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        cmbRole = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        txtConfirmPassword = new javax.swing.JPasswordField();
        txtPassword = new javax.swing.JPasswordField();
        jLabel14 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        lblValidIDSrc = new javax.swing.JLabel();
        lblProfileImage = new javax.swing.JLabel();
        lblFilePath = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();

        dateChooser1.setTextRefernce(txtDate);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(948, 628));
        setPreferredSize(new java.awt.Dimension(948, 628));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(17, 129, 70));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRegister.setBackground(new java.awt.Color(51, 204, 0));
        btnRegister.setForeground(new java.awt.Color(17, 129, 70));
        btnRegister.setText("REGISTER");
        btnRegister.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), javax.swing.BorderFactory.createEtchedBorder()));
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 470, 270, 30));

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Username *");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 200, 120, -1));

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Password *");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 250, 110, -1));

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("First name *");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 110, -1));

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Confirm Password *");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 300, 170, -1));

        txtFirstName.setBackground(new java.awt.Color(204, 204, 204));
        txtFirstName.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        txtFirstName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        txtFirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFirstNameActionPerformed(evt);
            }
        });
        jPanel1.add(txtFirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 270, 30));

        txtUsername.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        txtUsername.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });
        jPanel1.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 220, 270, 30));

        txtMiddleName.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        txtMiddleName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        txtMiddleName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMiddleNameActionPerformed(evt);
            }
        });
        jPanel1.add(txtMiddleName, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 270, 30));

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Middle name*");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 110, -1));

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Last name *");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 110, -1));

        txtLastName.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        txtLastName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        jPanel1.add(txtLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 220, 270, 30));

        rbnMale.setBackground(new java.awt.Color(17, 129, 70));
        rbnGender.add(rbnMale);
        rbnMale.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        rbnMale.setForeground(new java.awt.Color(204, 204, 204));
        rbnMale.setText("Male");
        jPanel1.add(rbnMale, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 270, 80, -1));

        rbnFemale.setBackground(new java.awt.Color(17, 129, 70));
        rbnGender.add(rbnFemale);
        rbnFemale.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        rbnFemale.setForeground(new java.awt.Color(204, 204, 204));
        rbnFemale.setText("Female");
        rbnFemale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbnFemaleActionPerformed(evt);
            }
        });
        jPanel1.add(rbnFemale, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 270, 90, -1));

        txtDate.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        txtDate.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        jPanel1.add(txtDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 270, 110, 30));

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Gender");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 250, 70, -1));

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Phone *");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 300, -1, -1));

        txtContactNumber.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        txtContactNumber.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        jPanel1.add(txtContactNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 320, 270, 30));

        jLabel9.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("House No.");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 360, -1, -1));

        txtHouseNo.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        txtHouseNo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        jPanel1.add(txtHouseNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 380, 130, 30));

        jLabel10.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Street/Sitio/Brgy");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 410, 150, -1));

        txtStreetAddress.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        txtStreetAddress.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        jPanel1.add(txtStreetAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 430, 270, 30));

        jLabel11.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("City/Municipal");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 360, -1, -1));

        txtCityAddress.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        txtCityAddress.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        jPanel1.add(txtCityAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 380, 130, 30));

        jLabel12.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Email *");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 100, 70, 20));

        txtEmail.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        txtEmail.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        jPanel1.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 118, 270, 30));

        cmbRole.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        cmbRole.setForeground(new java.awt.Color(255, 255, 255));
        cmbRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Farmer", "Supplier/Wholesaler" }));
        cmbRole.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.add(cmbRole, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 170, 270, 30));

        jLabel13.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("What bring you here? *");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 150, 180, 20));

        txtConfirmPassword.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        txtConfirmPassword.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        jPanel1.add(txtConfirmPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 318, 270, 30));

        txtPassword.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        txtPassword.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        jPanel1.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 270, 270, 30));

        jLabel14.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Birthday *");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, 80, -1));

        jButton1.setBackground(new java.awt.Color(218, 218, 217));
        jButton1.setForeground(new java.awt.Color(17, 129, 70));
        jButton1.setText("Valid ID");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 440, 110, 20));

        jButton2.setBackground(new java.awt.Color(218, 218, 217));
        jButton2.setForeground(new java.awt.Color(17, 129, 70));
        jButton2.setText("Upload Photo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 440, 110, 20));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 580, 70, 10));

        jLabel15.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(204, 204, 204));
        jLabel15.setText("Sign-In / Login");
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 520, 80, -1));

        jLabel16.setForeground(new java.awt.Color(204, 204, 204));
        jLabel16.setText("Already have an account? ");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 520, 150, -1));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 510, 480, 30));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 560, 950, 20));

        jLabel17.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Sign-Up");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 40, 180, 40));

        jLabel18.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel18.setText("Terms & Agreement Policy");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 480, -1, 20));

        jCheckBox1.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 480, -1, 20));

        lblValidIDSrc.setBackground(new java.awt.Color(204, 204, 204));
        lblValidIDSrc.setFont(new java.awt.Font("Nirmala UI", 2, 14)); // NOI18N
        lblValidIDSrc.setText("imgsrc/dcim");
        jPanel1.add(lblValidIDSrc, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 350, 110, 90));

        lblProfileImage.setBackground(new java.awt.Color(204, 204, 204));
        lblProfileImage.setFont(new java.awt.Font("Nirmala UI", 2, 14)); // NOI18N
        lblProfileImage.setText("imgsrc/dcim");
        jPanel1.add(lblProfileImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 350, 110, 90));
        jPanel1.add(lblFilePath, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 360, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 950, 580));

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 950, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtMiddleNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMiddleNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMiddleNameActionPerformed

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameActionPerformed
    InputStream is;
    File f;
    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        // TODO add your handling code here:

        User user = new User();
        f = new File(lblFilePath.getText());
        System.out.println(f);
        try {
            is = new FileInputStream(f);
        } catch (FileNotFoundException ex) {
        }
        user.setProfielImage(is);
        user.setFile(f);
        
        String password = String.valueOf(txtPassword.getText());
        String userType = cmbRole.getSelectedItem().toString();
        rbnMale.setActionCommand("Male");
        rbnFemale.setActionCommand("Female");
        String gender = rbnGender.getSelection().getActionCommand().toString();
//        user.setUserId(userType + txtUsername.getText() + (int) (Math.random() * 1000000));
        user.setPassword(password);
//        user.setUsername(txtUsername.getText());
        user.setUserType(userType);
        user.setFirstName(txtFirstName.getText());
        user.setMiddleName(txtMiddleName.getText());
        user.setLastName(txtLastName.getText());
        user.setGender(gender);
        user.setContactNumber(txtContactNumber.getText());
        user.setHouseNo(txtHouseNo.getText());
        user.setStreetAddress(txtStreetAddress.getText());
        user.setCityAddress(txtCityAddress.getText());
        user.setBirthDate(txtDate.getText());
        user.setEmail(txtEmail.getText());
        user.setActive(true);

//        System.out.println(user.getUserId());
//        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getGender());
        System.out.println(user.getBirthDate());
        System.out.println(user.getUserType());
        System.out.println(user.getProfielImage());
        System.out.println(user.getActive());

        UserImp ui = new UserImp();
        ui.register(user);
        // Validations
//        if (txtUsername = "" | txtCityAddress = "" |  ) {
//            
//        }
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
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
            Image img = ii.getImage().getScaledInstance(110, 110, Image.SCALE_SMOOTH);
            lblProfileImage.setText("");
            lblProfileImage.setIcon(new ImageIcon(img));
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        // TODO add your handling code here:
        LoginForm lf = new LoginForm();
        lf.setVisible(true);
        this.dispose();
        lf.setLocationRelativeTo(null);
    }//GEN-LAST:event_jLabel15MouseClicked

    private void txtFirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFirstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFirstNameActionPerformed

    private void rbnFemaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbnFemaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbnFemaleActionPerformed

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
                new RegisterForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegister;
    private javax.swing.JComboBox<String> cmbRole;
    private com.raven.datechooser.DateChooser dateChooser1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
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
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblFilePath;
    private javax.swing.JLabel lblProfileImage;
    private javax.swing.JLabel lblValidIDSrc;
    private javax.swing.JRadioButton rbnFemale;
    private javax.swing.ButtonGroup rbnGender;
    private javax.swing.JRadioButton rbnMale;
    private javax.swing.JTextField txtCityAddress;
    private javax.swing.JPasswordField txtConfirmPassword;
    private javax.swing.JTextField txtContactNumber;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtHouseNo;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtMiddleName;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtStreetAddress;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
