package com.raven.form;

import com.raven.dialog.Message;
import com.raven.main.Main;
import com.raven.swing.table.EventActionUser1;
import farmingsystem.controller.FarmingTipsImpl;
import farmingsystem.model.FarmingTips;
import java.awt.Component;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.TableCellRenderer;

public class FarmingTip extends javax.swing.JPanel {

    public FarmingTip() {
        initComponents();
        table11.fixTable(jScrollPane2);
        jPanel2.add(jScrollPane2);
        setOpaque(false);
        initData();
        table11.removeColumn(table11.getColumnModel().getColumn(0));
    }

    private void initData() {

        initTableData();
    }

    private void initTableData() {
        EventActionUser1 eventAction = new EventActionUser1() {
            @Override
            public void delete(FarmingTips tips) {
                if (showMessage("Delete Tip")) {
                    FarmingTipsImpl f = new FarmingTipsImpl();
                    tips.setTitle(tips.getTitle());
                    f.deleteTips(tips);
                } else {
                    System.out.println("User click Cancel");
                }
            }

            @Override
            public void update(FarmingTips tips) {
                if (showMessage("Update Tip")) {
                    UpdateFarmingTips update = new UpdateFarmingTips();
                    update.setVisible(true);
                    update.pack();

                    FarmingTipsImpl tip = new FarmingTipsImpl();

                    FarmingTips u = tip.get(tips.getId());

                    update.jLabel1.setText(String.valueOf(u.getId()));
                    update.textTitle.setText(String.valueOf(u.getTitle()));
                    update.textContent.setText(String.valueOf(u.getContent()));

                } else {
                    System.out.println("User click Cancel");
                }
            }
        };
        FarmingTipsImpl tips = new FarmingTipsImpl();
        List<FarmingTips> list = tips.list();
        table11.getColumn("Content").setCellRenderer(new MyCellRenderer());
        for (FarmingTips tip : list) {
            int id = tip.getId();
            String title = tip.getTitle();
            String content = tip.getContent();
            JTextArea ta = new JTextArea();
            ta.append(content);
            ta.setWrapStyleWord(true);
            ta.setLineWrap(true);
            JScrollPane msgScroller = new JScrollPane();
            msgScroller.setBorder(
                    BorderFactory.createTitledBorder("Details"));
            msgScroller.setViewportView(ta);
            table11.addRow(new FarmingTips(id, title, ta).toRowTable(eventAction));
        }
    }

    public class MyCellRenderer implements TableCellRenderer {
//
//        public MyCellRenderer() {
//            setLineWrap(true);
//            setWrapStyleWord(true);
//        }

        public Component getTableCellRendererComponent(JTable table,
                Object value,
                boolean isSelected,
                boolean hasFocus,
                int row,
                int column) {
//            setText(value);//or something in value, like value.getNote()...
//            setSize(table.getColumnModel().getColumn(column).getWidth(),
//                    getPreferredSize().height);
//            if (table11.getRowHeight(row) != getPreferredSize().height) {
//                table11.setRowHeight(60);
//            }
            table11.setRowHeight(120);
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
        button1 = new com.raven.swing.Button();
        jScrollPane2 = new javax.swing.JScrollPane();
        table11 = new com.raven.swing.table.Table1();

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(4, 72, 210));
        jLabel1.setText("Dashboard / FarmingTips");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(76, 76, 76));
        jLabel5.setText("List of Farming Tips ");
        jLabel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        button1.setBackground(new java.awt.Color(204, 204, 204));
        button1.setText("Add Farming Tips");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        table11.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Title", "Content", "Action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table11.setOpaque(false);
        table11.setShowVerticalLines(true);
        jScrollPane2.setViewportView(table11);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5))
                    .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 737, Short.MAX_VALUE)
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
                        .addGap(0, 904, Short.MAX_VALUE)))
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
        AddFarmingTips add = new AddFarmingTips();
        add.setVisible(true);
        add.pack();
    }//GEN-LAST:event_button1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.swing.Button button1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private com.raven.swing.table.Table1 table11;
    // End of variables declaration//GEN-END:variables
}
