package com.raven.form;

import com.raven.dialog.Message;
import com.raven.main.Main;
import com.raven.swing.table.EventActionTraining;
import farmingsystem.controller.TrainingImpl;
import farmingsystem.model.Training;
import java.util.List;


public class AdminTrainingHome extends javax.swing.JPanel {
    
    private Training training;
    public AdminTrainingHome() {
        initComponents();
          tableTraining.fixTable(jScrollPane1);
        jPanel2.add(jScrollPane1);
        Load();
        setOpaque(false);
        initData();
        tableTraining.removeColumn(tableTraining.getColumnModel().getColumn(0));
    }

    private void initData() {
        
        initTableData();
    }
   
    public void Load() 
             {
                 
             }
      
  
     
   private void initTableData() {
         EventActionTraining eventAction = new EventActionTraining() {
            @Override
            public void delete(Training training) {
                if (showMessage("Delete Course " + training.getTitle())) {
                    
                    TrainingImpl ti = new TrainingImpl();
                    training.setId(training.getId());
                    ti.deleteTraining(training);
                } else {
                    System.out.println("User click Cancel");
                }
            }

            @Override
            public void update(Training training) {
                if (showMessage("Update Course " + training.getTitle())) {
                    TrainingDetails traidet = new TrainingDetails();
                    traidet.setVisible(true);
                    traidet.pack();
                    
                    TrainingImpl ti = new TrainingImpl();
                    
                    Training course = ti.get(training.getId());
                    traidet.jLabel2.setText(String.valueOf(course.getId()));
                    traidet.txtTitle.setText(String.valueOf(course.getTitle()));
                    traidet.txtDescription.setText(String.valueOf(course.getDescription()));
                    traidet.txtDate.setText(String.valueOf(course.getScheduleDate()));
                    traidet.txtTime.setText(String.valueOf(course.getSchedulteTime()));
                    traidet.jcStatus.setSelectedItem(String.valueOf(course.getStatus()));

                } else {
                    System.out.println("User click Cancel");
                }
            }
             
        };
                
              TrainingImpl training = new TrainingImpl();
                 List<Training> list = training.list();
                 for (Training tr : list) {
                     int id = tr.getId();
                     String title = tr.getTitle();
                     String description = tr.getDescription();
                     String schedDate = tr.getScheduleDate();
                     String schedTime = tr.getSchedulteTime();
                     String status = tr.getStatus();
                   
                     tableTraining.addRow(new Training(id, title, description, schedDate, schedTime , status).toRowTable(eventAction));
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
        tableTraining = new com.raven.swing.table.TableTraining();

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(4, 72, 210));
        jLabel1.setText("Admin Dashboard");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(76, 76, 76));
        jLabel5.setText("List of Training");
        jLabel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        button1.setBackground(new java.awt.Color(204, 204, 204));
        button1.setForeground(new java.awt.Color(255, 255, 255));
        button1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/addIcon.png"))); // NOI18N
        button1.setText("Make Course");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        tableTraining.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Title", "Description", "Schedule Date", "Schedule Time", "Status", "Action"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableTraining);
        if (tableTraining.getColumnModel().getColumnCount() > 0) {
            tableTraining.getColumnModel().getColumn(0).setMinWidth(80);
            tableTraining.getColumnModel().getColumn(0).setMaxWidth(80);
            tableTraining.getColumnModel().getColumn(1).setMinWidth(200);
            tableTraining.getColumnModel().getColumn(1).setMaxWidth(200);
            tableTraining.getColumnModel().getColumn(2).setMinWidth(400);
            tableTraining.getColumnModel().getColumn(2).setMaxWidth(400);
            tableTraining.getColumnModel().getColumn(3).setMinWidth(100);
            tableTraining.getColumnModel().getColumn(3).setMaxWidth(100);
            tableTraining.getColumnModel().getColumn(4).setMinWidth(100);
            tableTraining.getColumnModel().getColumn(4).setMaxWidth(100);
            tableTraining.getColumnModel().getColumn(5).setMinWidth(100);
            tableTraining.getColumnModel().getColumn(5).setMaxWidth(100);
            tableTraining.getColumnModel().getColumn(6).setMinWidth(80);
            tableTraining.getColumnModel().getColumn(6).setMaxWidth(80);
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(792, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 790, Short.MAX_VALUE)
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
                        .addGap(0, 947, Short.MAX_VALUE)))
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
        AdminAddTraining1 add = new AdminAddTraining1();
        add.setVisible(true);
        add.pack();
    }//GEN-LAST:event_button1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.swing.Button button1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private com.raven.swing.table.TableTraining tableTraining;
    // End of variables declaration//GEN-END:variables
}
