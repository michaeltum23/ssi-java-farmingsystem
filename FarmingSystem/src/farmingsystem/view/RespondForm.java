package farmingsystem.view;

import farmingsystem.FarmingConnection;
import farmingsystem.controller.RespondImpl;
import farmingsystem.model.Respond;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author RPAGUIO
 */
public class RespondForm extends javax.swing.JFrame {

    public RespondForm() {
        initComponents();
        Load();
        LoadUserID();
        
        LoadComplain();
    }

  
    @SuppressWarnings("unchecked")
    public void Load()
    {
        RespondImpl res = new RespondImpl();
        List<Respond> list = res.list();
        DefaultTableModel DFT = (DefaultTableModel) jTable1.getModel();
        DFT.setRowCount(0);
        for(Respond tips: list)    {
            int sid = tips.getId();
            int userID = tips.getUser_id();
            int comID = tips.getComplaint_id();
            String responseDate = tips.getResponse_date();
            String responseBody = tips.getResponse_body();
            
            DFT.addRow(new Object[]{sid,userID,comID,responseDate ,responseBody});
        }  
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        dateChooser1 = new com.raven.datechooser.DateChooser();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        response_body = new javax.swing.JTextArea();
        btnPostResponse = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        user_id = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        textDate = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableComplain = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextAreaMessageComplain = new javax.swing.JTextArea();
        complainIDS = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        dateChooser1.setTextRefernce(textDate);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("userID");

        response_body.setColumns(20);
        response_body.setRows(5);
        jScrollPane1.setViewportView(response_body);

        btnPostResponse.setText("Post");
        btnPostResponse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPostResponseActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "id", "userID", "Complaint_id", "ResponseDate", "ResponseMessage"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        user_id.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("RespondDate :");

        textDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textDateActionPerformed(evt);
            }
        });

        jTableComplain.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "user_id", "message"
            }
        ));
        jTableComplain.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableComplainMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTableComplain);

        jLabel4.setFont(new java.awt.Font("Sylfaen", 1, 36)); // NOI18N
        jLabel4.setText("Compalin List By ID");

        jTextAreaMessageComplain.setEditable(false);
        jTextAreaMessageComplain.setColumns(20);
        jTextAreaMessageComplain.setRows(5);
        jScrollPane4.setViewportView(jTextAreaMessageComplain);

        complainIDS.setEditable(false);
        complainIDS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                complainIDSActionPerformed(evt);
            }
        });

        jLabel2.setText("Complain ID");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnDelete)
                                .addGap(8, 8, 8)
                                .addComponent(btnUpdate))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(complainIDS, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGap(6, 6, 6)
                                                    .addComponent(jLabel3))
                                                .addComponent(textDate, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(63, 63, 63)
                                        .addComponent(jLabel1)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(btnSearch)
                        .addGap(18, 18, 18)
                        .addComponent(btnPostResponse)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(user_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)))
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(80, 80, 80))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(complainIDS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(4, 4, 4)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDelete)
                            .addComponent(btnUpdate)
                            .addComponent(textDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnPostResponse)
                            .addComponent(btnSearch)
                            .addComponent(user_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(120, 120, 120))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

      public void LoadComplain(){
        RespondImpl com = new RespondImpl();
        List<Respond> listComplain = com.listComplain();
        DefaultTableModel DFT = (DefaultTableModel) jTableComplain.getModel();
        DFT.setRowCount(0);
        for(Respond tips: listComplain)    {
            int cid = tips.getComplaint_id();
            int userID = tips.getComplaint_user_id();
            String userMessage = tips.getComplaint_message();

            DFT.addRow(new Object[]{cid,userID,userMessage});
        }  
    }
      
      
    public void LoadUserID(){
        try {
            Connection con = FarmingConnection.getConnection();
            String sql = "SELECT id FROM users";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
           user_id.removeAllItems();
            while(rs.next()){
           user_id.addItem(rs.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        } 
    }
    
    
    
    
    private void btnPostResponseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPostResponseActionPerformed
        // TODO add your handling code here:        textDate
        
        Respond tip = new Respond ();
        int userid = Integer.parseInt( String.valueOf(user_id.getSelectedItem()));
        String responseBody = response_body.getText();
        String responseDate = textDate.getText();
        //int complain_id  = complainIDS.getText();
        int complain_id  = Integer.parseInt( String.valueOf(complainIDS.getText()));
        
       
        tip.setUser_id(userid);
        tip.setComplaint_id(complain_id);
        tip.setResponse_date(responseDate);
        tip.setResponse_body(responseBody);
        
        
        RespondImpl cs = new RespondImpl();
        cs.addRes(tip);
        Load();
       // user_id.setText("");
        response_body.setText("");
    }//GEN-LAST:event_btnPostResponseActionPerformed
    
    
    
    int search;
    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        search = Integer.parseInt(JOptionPane.showInputDialog("Enter Response ID"));
     
        RespondImpl tips = new RespondImpl();
        Respond tip  = tips.get(search);
        
       // user_id.setText(tip.getUser_id());
        response_body.setText(tip.getResponse_body());
        
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        Respond tips = new Respond();
 
     //  int userID = user_id.getText();
        String Response_body = response_body.getText();
       
        
       // tips.setUser_id(userID);
        tips.setResponse_body(Response_body);
        
        tips.setId(search);
        RespondImpl tip = new RespondImpl();
        tip.updateTips(tips);
        Load();
      //  user_id.setText("");
        response_body.setText("");
      
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        
        Respond tips = new Respond();
        tips.setId(search);
        RespondImpl tip = new RespondImpl();
        tip.deleteTips(tips);
        Load();
       // user_id.setText("");
        response_body.setText("");
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void textDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textDateActionPerformed

    private void complainIDSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_complainIDSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_complainIDSActionPerformed

    private void jTableComplainMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableComplainMouseClicked
    int i = jTableComplain.getSelectedRow();

        TableModel model = jTableComplain.getModel();
      
        complainIDS.setText(model.getValueAt(i,0).toString());
        jTextAreaMessageComplain.setText(model.getValueAt(i,2).toString());
       
    
    }//GEN-LAST:event_jTableComplainMouseClicked

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RespondForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnPostResponse;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JTextField complainIDS;
    private com.raven.datechooser.DateChooser dateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTableComplain;
    private javax.swing.JTextArea jTextAreaMessageComplain;
    private javax.swing.JTextArea response_body;
    private javax.swing.JTextField textDate;
    private javax.swing.JComboBox<String> user_id;
    // End of variables declaration//GEN-END:variables
}
