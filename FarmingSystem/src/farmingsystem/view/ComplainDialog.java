/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package farmingsystem.view;

import farmingsystem.FarmingConnection;
import farmingsystem.controller.ComplainImpl;
import farmingsystem.model.Complain;

import farmingsystem.controller.RespondImpl;
import farmingsystem.model.Respond;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
/**
 *
 * @authord FPALES
 */
public final class ComplainDialog extends javax.swing.JDialog {

    /**
     * Creates new form ComplainDialog
     */
    public ComplainDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        
        initComponents();
        setLocationRelativeTo(null);
        LoadComplain();
        //LoadResponse(); error on importing java respond.
        LoadUserID();
     //   LoadResponseId();
     //   LoadResponseComplain();
        LoadOrderId();
    }
    public final void LoadComplain()
    {
        ComplainImpl complain = new ComplainImpl();
        List<Complain> list = complain.list();
        DefaultTableModel DFT = (DefaultTableModel) jTable4.getModel();
        DFT.setRowCount(0);
        for(Complain complains: list)
        {
            int id = complains.getId();
            String ticketNo  = complains.getTicketNo();
            int orderId = complains.getOrderId();
            String message = complains.getMessage();
            String status = complains.getStatus();
            String dateCreated = complains.getDateCreated();
            String dateResolve = complains.getDateResolved();
            int responseId = complains.getResponse_id();
            String response = complains.getResponse();
            int user = complains.getUser_id();
            DFT.addRow(new Object[]{id,ticketNo,orderId,message,status,dateCreated,dateResolve,responseId,response,user});
           
            
        }
        
  
    }
    public final void LoadResponse()
    {
        RespondImpl respondImpl = new RespondImpl();
        List<Respond> list = respondImpl.list();
        DefaultTableModel DFT = (DefaultTableModel) jTableResponse.getModel();
        DFT.setRowCount(0);
        for(Respond responds: list)
        {
            int id = responds.getId();         
            int userID = responds.getUser_id();
            int username  = responds.getUser_id();
            int complainID = responds.getComplaint_id();
            String respondDate = responds.getResponse_date();
            String responBody = responds.getResponse_body();
            DFT.addRow(new Object[]{id, userID, username, complainID, respondDate, responBody});
        }    
  
    }

    public final void LoadResponseComplain()
    {
        ComplainImpl complain = new ComplainImpl();
        List<Complain> list2List = complain.list();
        DefaultTableModel DFT = (DefaultTableModel) ResponseComplainTable.getModel();
        DFT.setRowCount(0);
        for(Complain complains: list2List)
        {
            int user = complains.getUser_id();
            int orderId = complains.getOrderId();
            int id = complains.getId();
            String message = complains.getMessage();
            int responseId = complains.getResponse_id();
            String response = complains.getResponse();
            DFT.addRow(new Object[]{user, orderId, id, response, response});
        }    
  
    }
   
    public void LoadUserID(){
        try {
            Connection con = FarmingConnection.getConnection();
            String sql = "SELECT id FROM users";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            jcUseId.removeAllItems();
            while(rs.next()){
               
                
                jcUseId.addItem(rs.getString(1));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        
    }
    public void LoadOrderId(){
        try {
            Connection con = FarmingConnection.getConnection();
            String sql = "SELECT order_id FROM orders WHERE user_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(jcUseId.getSelectedItem().toString()));    
            ResultSet rs = ps.executeQuery();
            jcOrderId.removeAllItems();
            while(rs.next()){  
                jcOrderId.addItem(rs.getString(1));
            }     
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        complaintableview = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        addComplainPanel = new javax.swing.JPanel();
        jcOrderId = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtMessage = new javax.swing.JTextArea();
        jcUseId = new javax.swing.JComboBox<>();
        btnSave = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        updateComplainPanel = new javax.swing.JPanel();
        lbluser = new javax.swing.JLabel();
        lblticket = new javax.swing.JLabel();
        lbldateCreated = new javax.swing.JLabel();
        lbldateResolve = new javax.swing.JLabel();
        lbl11 = new javax.swing.JLabel();
        lbl10 = new javax.swing.JLabel();
        lbl1 = new javax.swing.JLabel();
        lbl2 = new javax.swing.JLabel();
        lbl3 = new javax.swing.JLabel();
        lbl6 = new javax.swing.JLabel();
        btnStatusResolved = new javax.swing.JButton();
        btnStatusPending = new javax.swing.JButton();
        lblStatus = new javax.swing.JLabel();
        btnSelect = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        responsePanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtResponseId = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaResponseBody = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        txtResponseComplainId = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtResponseTicketNo = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtResponseStatus = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnSubmitResponse = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtComplainant = new javax.swing.JLabel();
        txtComplainee = new javax.swing.JLabel();
        btnRemoveComplain = new javax.swing.JButton();
        reponsetableview = new javax.swing.JScrollPane();
        jTableResponse = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        ResponseComplainTable = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lbl = new javax.swing.JLabel();
        user = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jcStatus = new javax.swing.JComboBox<>();
        lbl7 = new javax.swing.JLabel();
        lbl4 = new javax.swing.JLabel();
        lbl5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "id", "ticket_no", "order_id", "message", "status", "date_created", "date_resolve", "response_id", "response", "user_id"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable4.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        jTable4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable4MouseClicked(evt);
            }
        });
        complaintableview.setViewportView(jTable4);

        jPanel2.add(complaintableview, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 750, 130));

        addComplainPanel.setBackground(new java.awt.Color(255, 0, 255));
        addComplainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addComplainPanel.add(jcOrderId, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 100, -1));

        txtMessage.setColumns(20);
        txtMessage.setRows(5);
        jScrollPane3.setViewportView(txtMessage);

        addComplainPanel.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 271, -1));

        jcUseId.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcUseIdItemStateChanged(evt);
            }
        });
        addComplainPanel.add(jcUseId, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 130, -1));

        btnSave.setBackground(new java.awt.Color(0, 204, 255));
        btnSave.setText("save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        addComplainPanel.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 240, 70, 30));

        jLabel2.setText("User / Complainant");
        addComplainPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 110, -1));

        jLabel4.setText("Order ID");
        addComplainPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 76, -1));

        jLabel6.setText("Add Complain");
        addComplainPanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel16.setText("Complain Message");
        addComplainPanel.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 120, -1));

        jPanel2.add(addComplainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 13, 270, 280));

        updateComplainPanel.setBackground(new java.awt.Color(255, 255, 51));
        updateComplainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbluser.setText("none");
        updateComplainPanel.add(lbluser, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 94, -1));

        lblticket.setText("none");
        updateComplainPanel.add(lblticket, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 120, -1));

        lbldateCreated.setText("none");
        updateComplainPanel.add(lbldateCreated, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 80, -1));

        lbldateResolve.setText("none");
        updateComplainPanel.add(lbldateResolve, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 80, -1));

        lbl11.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        lbl11.setText("Date Resolved :");
        updateComplainPanel.add(lbl11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 90, -1));

        lbl10.setText("Date Created :");
        updateComplainPanel.add(lbl10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 80, -1));

        lbl1.setText("User              :");
        updateComplainPanel.add(lbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 80, -1));

        lbl2.setText("Status            :");
        updateComplainPanel.add(lbl2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 80, 20));

        lbl3.setText("TicketNo       :");
        updateComplainPanel.add(lbl3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 80, -1));

        lbl6.setText("Update Complain");
        updateComplainPanel.add(lbl6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 180, -1));

        btnStatusResolved.setBackground(new java.awt.Color(0, 51, 255));
        btnStatusResolved.setForeground(new java.awt.Color(51, 51, 51));
        btnStatusResolved.setText("Resolved");
        btnStatusResolved.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStatusResolvedActionPerformed(evt);
            }
        });
        updateComplainPanel.add(btnStatusResolved, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 90, 30));

        btnStatusPending.setBackground(new java.awt.Color(0, 255, 51));
        btnStatusPending.setText("Pending");
        btnStatusPending.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStatusPendingActionPerformed(evt);
            }
        });
        updateComplainPanel.add(btnStatusPending, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 80, 30));

        lblStatus.setText("none");
        updateComplainPanel.add(lblStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 120, -1));

        btnSelect.setBackground(new java.awt.Color(255, 255, 0));
        btnSelect.setText("Select cId");
        btnSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectActionPerformed(evt);
            }
        });
        updateComplainPanel.add(btnSelect, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 90, 30));

        btnUpdate.setBackground(new java.awt.Color(242, 243, 245));
        btnUpdate.setText("update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        updateComplainPanel.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 80, 30));

        jLabel3.setText("Message");
        updateComplainPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 60, -1));

        jLabel15.setText("none");
        updateComplainPanel.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 140, -1));

        jLabel9.setText("Mark As");
        updateComplainPanel.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 60, -1));

        jPanel2.add(updateComplainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 220, 280));

        responsePanel.setBackground(new java.awt.Color(204, 255, 51));
        responsePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setText("Complainee");
        responsePanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        txtResponseId.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtResponseId.setText("none");
        responsePanel.add(txtResponseId, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 70, -1));

        txtAreaResponseBody.setColumns(20);
        txtAreaResponseBody.setRows(5);
        jScrollPane1.setViewportView(txtAreaResponseBody);

        responsePanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 270, 100));

        jLabel12.setText("user Complainee");
        responsePanel.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 90, -1));

        txtResponseComplainId.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtResponseComplainId.setText("none");
        responsePanel.add(txtResponseComplainId, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 70, -1));

        jLabel14.setText("Ticket No:");
        responsePanel.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 70, 20));

        txtResponseTicketNo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtResponseTicketNo.setText("none");
        responsePanel.add(txtResponseTicketNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 70, -1));

        jLabel13.setText("Status");
        responsePanel.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 70, 20));

        txtResponseStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtResponseStatus.setText("none");
        responsePanel.add(txtResponseStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 70, -1));

        jButton1.setText("jButton1");
        responsePanel.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, -1, -1));

        btnSubmitResponse.setText("submit response");
        btnSubmitResponse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitResponseActionPerformed(evt);
            }
        });
        responsePanel.add(btnSubmitResponse, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 290, -1, -1));

        jLabel17.setText("Response");
        responsePanel.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 164, 222, -1));

        jLabel18.setText("response_id");
        responsePanel.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 80, -1));

        jLabel19.setText("complain_id");
        responsePanel.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 70, -1));

        jLabel20.setText("user Complainant");
        responsePanel.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 100, -1));

        txtComplainant.setText("none");
        responsePanel.add(txtComplainant, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 100, -1));

        txtComplainee.setText("none");
        responsePanel.add(txtComplainee, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 60, -1));

        jPanel2.add(responsePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 10, -1, 320));

        btnRemoveComplain.setBackground(new java.awt.Color(255, 51, 0));
        btnRemoveComplain.setText("Delete");
        btnRemoveComplain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveComplainActionPerformed(evt);
            }
        });
        jPanel2.add(btnRemoveComplain, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 320, 180, 30));

        jTableResponse.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "response_id", "user_id", "user", "complain_id", "response_date", "response"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableResponse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableResponseMouseClicked(evt);
            }
        });
        reponsetableview.setViewportView(jTableResponse);

        jPanel2.add(reponsetableview, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, 750, 110));

        ResponseComplainTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "User_id", "Order_id", "Complain_id", "Response_id", "Response Body"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(ResponseComplainTable);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 360, 700, 250));

        jLabel8.setText("Response Table View");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, 120, -1));

        jLabel10.setText("Complain Table View");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 120, -1));

        jLabel11.setText("Flow View");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 340, 120, -1));

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        lbl.setText("Sort Complain Table");

        user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userActionPerformed(evt);
            }
        });

        btnSearch.setText("search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jLabel7.setText("Status");

        jcStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Done", "Pending", "Failed", " " }));
        jcStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcStatusActionPerformed(evt);
            }
        });

        lbl7.setText("User ID");

        lbl4.setText("?Select for User ID and Status");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl7, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(btnSearch))
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl4, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl)
                .addGap(25, 25, 25)
                .addComponent(lbl4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(7, 7, 7)
                .addComponent(jcStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(103, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, 200, 280));

        lbl5.setText("Eliminate rows of Complain Table");
        jPanel2.add(lbl5, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 300, 190, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1492, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 806, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        
         Complain complain = new Complain();
          //complain id, user id, order id, ticketNumber, startdate, message, 
          int userid = Integer.parseInt( String.valueOf(jcUseId.getSelectedItem()));
          int orderid = Integer.parseInt(String.valueOf(jcOrderId.getSelectedItem()));
          String messageComplain = txtMessage.getText(); 
          /// get Ticket No
          int length = 10;
          String lower_case = "qwertyuiopasdfghjklzxcvbnm";
          String upper_case = "QWERTYUIOPASDFGHJKLZXCVBNM";
          String genTicket="";
          for (int i = 0; i< length; i++){
              int rand = (int)(3*Math.random());
              switch (rand) {
                  case 0:
                      genTicket += String.valueOf((int)(0* Math.random()));
                      break;
                  case 1:
                      rand = (int)(lower_case.length() * Math.random());
                      genTicket += String.valueOf((lower_case.charAt(rand)));
                      break;
                  case 2:
                      rand = (int)(upper_case.length() * Math.random());
                      genTicket += String.valueOf((upper_case.charAt(rand)));
                      break;
                  default:
                      throw new AssertionError();
              }
          }
        String ticketNo = genTicket;         
        String status ="Pending";
        String created = String.valueOf(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss")));
       // String resolve="";
//        if (status.equalsIgnoreCase("Done") || status.equalsIgnoreCase("Failed")){
//        resolve = String.valueOf(LocalDateTime.now());    
//        }
//        else if(status.equalsIgnoreCase("Pending")){
//        
//        }
        //setters
        complain.setUser_id(userid);
        complain.setMessage(messageComplain);
        complain.setOrderId(orderid);
        complain.setTicketNo(ticketNo);
        complain.setStatus(status);
        complain.setDateCreated(created);

        //Impl function
        ComplainImpl complainImpl = new ComplainImpl();
        complainImpl.addComplain(complain);
        LoadComplain();
        
        // clear text
        txtMessage.setText("");
        jcOrderId.setSelectedItem("");
        jcStatus.setSelectedItem("");   
        txtMessage.requestFocus();
        
        
    }//GEN-LAST:event_btnSaveActionPerformed
  
    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        Complain complains = new Complain();
        // variable
        String edtmessage = txtMessage.getText(); 
        String upstatus = lblStatus.getText();
        String edtresolve = lbldateResolve.getText();
          
            
        // Complain set
        complains.setTicketNo(lblticket.getText());
        complains.setMessage(edtmessage);
        complains.setStatus(upstatus);
        complains.setDateResolved(edtresolve);
//      complains.setDateCreated(lbldateCreated.getText());
//        

        // query complain imp
        ComplainImpl complainImpl = new ComplainImpl();
        complainImpl.updateComplain(complains);
        LoadComplain();
        
        lblticket.setText("");
        txtMessage.setText("");
        lblStatus.setText("");
        lbldateResolve.setText("");        
        txtMessage.requestFocus();
        //lbldateCreated.setText("");
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnRemoveComplainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveComplainActionPerformed
        Complain complain = new Complain();
        complain.setTicketNo(String.valueOf(lblticket.getText()));
        ComplainImpl complainImpl = new ComplainImpl();
        complainImpl.deleteComplain(complain);
        LoadComplain();
       
        txtMessage.setText("");
        lblticket.setText("");
        lblStatus.setText("");   
        lbldateCreated.setText("");
        lbldateResolve.setText("");
        txtMessage.requestFocus();
    }//GEN-LAST:event_btnRemoveComplainActionPerformed

    private void userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userActionPerformed
    int search;
    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        int user_id=Integer.parseInt(user.getText());
        String statuses = String.valueOf(jcStatus.getSelectedItem());
        
        // query
        ComplainImpl complainImpl = new ComplainImpl();
        List<Complain> list = complainImpl.searchComplain(user_id, statuses);
        DefaultTableModel DFT = (DefaultTableModel) jTable4.getModel();
        DFT.setRowCount(0);
        
        for(Complain complains: list)
        {
            int id = complains.getId();
            String ticketNo  = complains.getTicketNo();
            int orderId = complains.getOrderId();
            String message = complains.getMessage();
            String status = complains.getStatus();
            String dateCreated = complains.getDateCreated();
            String dateResolve = complains.getDateResolved();
            int responseId = complains.getResponse_id();
            String response = complains.getResponse();
            int user = complains.getUser_id();

            DFT.addRow(new Object[]{id,ticketNo,orderId,message,status,dateCreated,dateResolve,responseId,response, user_id});
        }    
        
        
        
    }//GEN-LAST:event_btnSearchActionPerformed

    private void jcStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcStatusActionPerformed
        // TODO add your handling code here:
       
        String searchStatus = String.valueOf(jcStatus.getSelectedItem());
        ComplainImpl complainImpl = new ComplainImpl();
        List<Complain> list = complainImpl.searchComplainByStatus(searchStatus);
        DefaultTableModel DFT = (DefaultTableModel) jTable4.getModel();
        DFT.setRowCount(0);
        for(Complain complains: list)
        {
            int id = complains.getId();
            String ticketNo  = complains.getTicketNo();
            int orderId = complains.getOrderId();
            String message = complains.getMessage();
            String status = complains.getStatus();
            String dateCreated = complains.getDateCreated();
            String dateResolve = complains.getDateResolved();
            int responseId = complains.getResponse_id();
            String response = complains.getResponse();
            int user = complains.getUser_id();
            DFT.addRow(new Object[]{id,ticketNo,orderId,message,status,dateCreated,dateResolve,responseId,response,user});
        }    
    }//GEN-LAST:event_jcStatusActionPerformed

    private void btnStatusPendingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStatusPendingActionPerformed
         Complain complains = new Complain();
        String markStatus ="Pending";
        String dateResolved = "";
        complains.setStatus(markStatus);
        complains.setDateResolved(dateResolved);
        lblStatus.setText(complains.getStatus());
        lbldateResolve.setText(complains.getDateResolved());
        ComplainImpl complainImpl = new ComplainImpl();
        complainImpl.markResolve(complains);
        LoadComplain();
    }//GEN-LAST:event_btnStatusPendingActionPerformed
    int select;
    private void btnSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectActionPerformed
        select = Integer.parseInt(JOptionPane.showInputDialog("Enter Complain ID"));
        ComplainImpl complainimpl = new ComplainImpl();
        Complain complain  = complainimpl.get(select);
        lbluser.setText(String.valueOf(complain.getId()));
        txtMessage.setText(complain.getMessage());
        lblticket.setText(complain.getTicketNo());
        lbldateCreated.setText(complain.getDateCreated());
        lbldateResolve.setText(complain.getDateResolved());
        
    }//GEN-LAST:event_btnSelectActionPerformed

    private void jTable4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable4MouseClicked
        int i = jTable4.getSelectedRow();
        TableModel model1 = jTable4.getModel();
        txtResponseComplainId.setText(model1.getValueAt(i, 0).toString());
        txtResponseTicketNo.setText(model1.getValueAt(i, 1).toString());
        txtResponseStatus.setText(model1.getValueAt(i, 4).toString());
        txtComplainant.setText(model1.getValueAt(i, 9).toString());
    }//GEN-LAST:event_jTable4MouseClicked

    private void jTableResponseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableResponseMouseClicked
        
        int i = jTableResponse.getSelectedRow();
        TableModel model1 = jTableResponse.getModel();
        txtResponseId.setText(model1.getValueAt(i, 0).toString());
   //     txtComplainee.setText(model1.getValueAt(i, 2).toString());
        
    }//GEN-LAST:event_jTableResponseMouseClicked

    private void btnSubmitResponseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitResponseActionPerformed
       Complain complains = new Complain();

        int responseId = Integer.parseInt(txtResponseId.getText());
        int complain_id = Integer.parseInt(txtResponseComplainId.getText());
        String response_body = txtAreaResponseBody.getText(); 
        String upstatus = "responded";
            
        complains.setResponse_id(responseId);
        complains.setId(complain_id);
        complains.setResponse(response_body);
        complains.setStatus(upstatus);

        // query complain imp
        ComplainImpl complainImpl = new ComplainImpl();
        complainImpl.updateComplain(complains);
//        complainImpl.responseComplain( responseId, complain_id,  response_body, upstatus); // test to update complain table
//        LoadResponse();
        
    }//GEN-LAST:event_btnSubmitResponseActionPerformed

    private void jcUseIdItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcUseIdItemStateChanged
        LoadOrderId();
    }//GEN-LAST:event_jcUseIdItemStateChanged

    private void btnStatusResolvedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStatusResolvedActionPerformed
        Complain complains = new Complain();
        String markStatus ="Resolve";
        String dateResolved = String.valueOf(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss")));
        
        complains.setStatus(markStatus);
        complains.setDateResolved(dateResolved);
        
        lblStatus.setText(complains.getStatus());
        lbldateResolve.setText(complains.getDateResolved());
      
        ComplainImpl complainImpl = new ComplainImpl();
        complainImpl.markResolve(complains);
        
        LoadComplain();
        
        System.out.println("status  : "+complains.getStatus());
        System.out.println("Resolve : "+complains.getDateResolved());
        
    }//GEN-LAST:event_btnStatusResolvedActionPerformed

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
            java.util.logging.Logger.getLogger(ComplainDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ComplainDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ComplainDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ComplainDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ComplainDialog dialog = new ComplainDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ResponseComplainTable;
    private javax.swing.JPanel addComplainPanel;
    private javax.swing.JButton btnRemoveComplain;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSelect;
    private javax.swing.JButton btnStatusPending;
    private javax.swing.JButton btnStatusResolved;
    private javax.swing.JButton btnSubmitResponse;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JScrollPane complaintableview;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTableResponse;
    private javax.swing.JComboBox<String> jcOrderId;
    private javax.swing.JComboBox<String> jcStatus;
    private javax.swing.JComboBox<String> jcUseId;
    private javax.swing.JLabel lbl;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl10;
    private javax.swing.JLabel lbl11;
    private javax.swing.JLabel lbl2;
    private javax.swing.JLabel lbl3;
    private javax.swing.JLabel lbl4;
    private javax.swing.JLabel lbl5;
    private javax.swing.JLabel lbl6;
    private javax.swing.JLabel lbl7;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lbldateCreated;
    private javax.swing.JLabel lbldateResolve;
    private javax.swing.JLabel lblticket;
    private javax.swing.JLabel lbluser;
    private javax.swing.JScrollPane reponsetableview;
    private javax.swing.JPanel responsePanel;
    private javax.swing.JTextArea txtAreaResponseBody;
    private javax.swing.JLabel txtComplainant;
    private javax.swing.JLabel txtComplainee;
    private javax.swing.JTextArea txtMessage;
    private javax.swing.JLabel txtResponseComplainId;
    private javax.swing.JLabel txtResponseId;
    private javax.swing.JLabel txtResponseStatus;
    private javax.swing.JLabel txtResponseTicketNo;
    private javax.swing.JPanel updateComplainPanel;
    private javax.swing.JTextField user;
    // End of variables declaration//GEN-END:variables
}
