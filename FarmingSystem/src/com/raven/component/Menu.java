package com.raven.component;

import com.raven.event.EventMenu;
import com.raven.event.EventMenuSelected;
import com.raven.event.EventShowPopupMenu;
import com.raven.model.ModelMenu;
import com.raven.swing.MenuAnimation;
import com.raven.swing.MenuItem;
import com.raven.swing.scrollbar.ScrollBarCustom;
import farmingsystem.model.User;
import java.awt.Color;
import java.awt.Component;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import javax.swing.ImageIcon;
import net.miginfocom.swing.MigLayout;

public class Menu extends javax.swing.JPanel {

    public boolean isShowMenu() {
        return showMenu;
    }

    public void addEvent(EventMenuSelected event) {
        this.event = event;
    }

    public void setEnableMenu(boolean enableMenu) {
        this.enableMenu = enableMenu;
    }

    public void setShowMenu(boolean showMenu) {
        this.showMenu = showMenu;
    }

    public void addEventShowPopup(EventShowPopupMenu eventShowPopup) {
        this.eventShowPopup = eventShowPopup;
    }

    private final MigLayout layout;
    private EventMenuSelected event;
    private EventShowPopupMenu eventShowPopup;
    private boolean enableMenu = true;
    private boolean showMenu = true;

    private User user;

    public Menu(User user) {
        this.user = user;
        initComponents();
        setOpaque(false);
        ImageIcon im = new ImageIcon(getClass().getResource("/com/raven/icon/testlogo.png"));
        Image image = im.getImage().getScaledInstance(71, 50, Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(image);
        lblLogo.setIcon(icon);
        sp.getViewport().setOpaque(false);
        sp.setVerticalScrollBar(new ScrollBarCustom());
        layout = new MigLayout("wrap, fillx, insets 0", "[fill]", "[]0[]");
        panel.setLayout(layout);
    }

    public void initMenuItem() {
        if (user.getUserType().equals("Admin")) {
            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/raven/icon/1.png")), "Dashboard"));
            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/raven/icon/ads.png")), "Advertisement"));
            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/raven/icon/order.png")), "OrderTracker"));
            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/raven/icon/course.png")), "Course"));
            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/raven/icon/complaints.png")), "Complaints"));
            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/raven/icon/farming.png")), "FarmingTips"));
            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/raven/icon/blogs.png")), "Blogs"));
            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/raven/icon/admin.png")), "Admin"));
            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/raven/icon/supplier.png")), "Supplier"));
            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/raven/icon/farmer.png")), "Farmer"));
            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("")), ""));
            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("")), ""));
            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("")), ""));
            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("")), ""));
            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("")), ""));
            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("")), ""));
            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/raven/icon/Logout.png")), "Logout"));
        } else if (user.getUserType().equals("Farmer")) {
            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/raven/icon/1.png")), "Dashboard"));
            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/raven/icon/ads.png")), "Advertisement"));
            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/raven/icon/order.png")), "Transaction"));
            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/raven/icon/course.png")), "Course"));
            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/raven/icon/complaints.png")), "Crops"));
            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/raven/icon/farming.png")), "Complaints"));
            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/raven/icon/blogs.png")), "My Profile"));
            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("")), ""));
            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("")), ""));
            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("")), ""));
            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("")), "ABOUT THE APPLICATION"));
            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("")), "SUMMARY OF PRODUCTS"));
            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("")), "BLOG ARTICLE"));
            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("")), ""));
            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("")), ""));
            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("")), ""));
            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/raven/icon/Logout.png")), "Logout"));
        } else if (user.getUserType().equals("Supplier")) {
            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/raven/icon/1.png")), "Dashboard"));
            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/raven/icon/ads.png")), "Advertisement"));
            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/raven/icon/order.png")), "Transaction"));
            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/raven/icon/course.png")), "Notification"));
            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/raven/icon/complaints.png")), "Complaints"));
            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/raven/icon/blogs.png")), "My Profile"));
            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("")), ""));
            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("")), ""));
            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("")), ""));
            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("")), "ABOUT THE APPLICATION"));
            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("")), "SUMMARY OF PRODUCTS"));
            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("")), "BLOG ARTICLE"));
            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("")), ""));
            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("")), ""));
            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("")), ""));
            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/raven/icon/Logout.png")), "Logout"));
        }
    }

    private void addMenu(ModelMenu menu) {
        panel.add(new MenuItem(menu, getEventMenu(), event, panel.getComponentCount()), "h 40!");
    }

    private EventMenu getEventMenu() {
        return new EventMenu() {
            @Override
            public boolean menuPressed(Component com, boolean open) {
                if (enableMenu) {
                    if (isShowMenu()) {
                        if (open) {
                            new MenuAnimation(layout, com).openMenu();
                        } else {
                            new MenuAnimation(layout, com).closeMenu();
                        }
                        return true;
                    } else {
                        eventShowPopup.showPopup(com);
                    }
                }
                return false;
            }
        };
    }

    public void hideallMenu() {
        for (Component com : panel.getComponents()) {
            MenuItem item = (MenuItem) com;
            if (item.isOpen()) {
                new MenuAnimation(layout, com, 500).closeMenu();
                item.setOpen(false);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sp = new javax.swing.JScrollPane();
        panel = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();

        sp.setBorder(null);
        sp.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        panel.setOpaque(false);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 426, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 616, Short.MAX_VALUE)
        );

        sp.setViewportView(panel);

        lblLogo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblLogo.setForeground(new java.awt.Color(255, 255, 255));
        lblLogo.setText("Online Farming");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sp))
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        GradientPaint gra = new GradientPaint(0, 0, new Color(0, 102, 51), getWidth(), 0, new Color(0, 102, 51));

        g2.setPaint(gra);
        g2.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(grphcs);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblLogo;
    private javax.swing.JPanel panel;
    private javax.swing.JScrollPane sp;
    // End of variables declaration//GEN-END:variables
}
