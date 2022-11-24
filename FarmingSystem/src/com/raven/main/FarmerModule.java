package com.raven.main;

import com.raven.component.Header;
import com.raven.component.Menu;
import com.raven.event.EventMenuSelected;
import com.raven.event.EventShowPopupMenu;
import com.raven.form.AboutApp;
import com.raven.form.SummaryProducts;

import com.raven.form.Admin;
import com.raven.form.AdminAdvertisement;
import com.raven.form.Blogs;
import com.raven.form.Complaints;
import com.raven.form.Course;
import com.raven.form.AdminFarmer;
import com.raven.form.BlogArticle;
import com.raven.form.FarmerHome;
import com.raven.form.FarmingTip;
import com.raven.form.Form_Home;
import com.raven.form.MainForm;
import com.raven.form.OrderTracker;
import com.raven.form.AdminSupplier;
import com.raven.form.FarmerCropsCrud;

import com.raven.swing.MenuItem;
import com.raven.swing.PopupMenu;
import com.raven.swing.icon.GoogleMaterialDesignIcons;
import com.raven.swing.icon.IconFontSwing;
import farmingsystem.model.User;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class FarmerModule extends javax.swing.JFrame {

    private MigLayout layout;
    private Menu menu;
    private Header header;
    private MainForm main;
    private Animator animator;

    private final User user;

    public FarmerModule(User user) {
        this.user = user;
        initComponents();
        init();
    }

    private FarmerModule() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void init() {
        layout = new MigLayout("fill", "0[]0[100%, fill]0", "0[fill, top]0");
        bg.setLayout(layout);
        menu = new Menu(user);
        header = new Header(user);
        main = new MainForm();
        menu.addEvent(new EventMenuSelected() {
            @Override
            public void menuSelected(int menuIndex, int subMenuIndex) {
                System.out.println("Menu Index : " + menuIndex + " SubMenu Index " + subMenuIndex);
                if (menuIndex == 0) {
                    main.showForm(new FarmerHome(user));
//                    if (subMenuIndex == 0) {
//                        main.showForm(new Form_Home());
//                    } else if (subMenuIndex == 1) {
//                        main.showForm(new Form1());
//                    }
                }
                if (menuIndex == 1) {
                    if (subMenuIndex == -1) {
                        main.showForm(new AdminAdvertisement());
                    }
                }

                if (menuIndex == 2) {
                    if (subMenuIndex == -1) {
                        main.showForm(new OrderTracker());
                    }
                }

                if (menuIndex == 3) {
                    if (subMenuIndex == -1) {
                        main.showForm(new Course());
                    }
                }

                if (menuIndex == 4) {
                    if (subMenuIndex == -1) {
                        main.showForm(new FarmerCropsCrud(user));
                    }
                }

                if (menuIndex == 5) {
                    if (subMenuIndex == -1) {
                        main.showForm(new FarmingTip());
                    }
                }

                if (menuIndex == 6) {
                    if (subMenuIndex == -1) {
                        main.showForm(new Blogs());
                    }
                }

                if (menuIndex == 7) {
                    if (subMenuIndex == -1) {
                        main.showForm(new Admin());
                    }
                }
                
                if (menuIndex == 10) {
                    if (subMenuIndex == -1) {
                        main.showForm(new AboutApp());
                    }
                }
                
                  if (menuIndex == 11) {
                    if (subMenuIndex == -1) {
                        main.showForm(new SummaryProducts());
                    }
                }
                  
                  if (menuIndex == 12) {
                    if (subMenuIndex == -1) {
                        main.showForm(new BlogArticle());
                    }
                }

                if (menuIndex == 16) {
                    if (subMenuIndex == -1) {
                        dispose();
                        LoginForm lf = new LoginForm();
                        lf.setVisible(true);
                        lf.setLocationRelativeTo(null);
                    }
                }
            }
        });
        menu.addEventShowPopup(new EventShowPopupMenu() {
            @Override
            public void showPopup(Component com) {
                MenuItem item = (MenuItem) com;
                PopupMenu popup = new PopupMenu(FarmerModule.this, item.getIndex(), item.getEventSelected(), item.getMenu().getSubMenu());
                int x = FarmerModule.this.getX() + 52;
                int y = FarmerModule.this.getY() + com.getY() + 86;
                popup.setLocation(x, y);
                popup.setVisible(true);
            }
        });
        menu.initMenuItem();
        bg.add(menu, "w 230!, spany 2");    // Span Y 2cell
        bg.add(header, "h 50!, wrap");
        bg.add(main, "w 100%, h 100%");
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                double width;
                if (menu.isShowMenu()) {
                    width = 60 + (170 * (1f - fraction));
                } else {
                    width = 60 + (170 * fraction);
                }
                layout.setComponentConstraints(menu, "w " + width + "!, spany2");
                menu.revalidate();
            }

            @Override
            public void end() {
                menu.setShowMenu(!menu.isShowMenu());
                menu.setEnableMenu(true);
            }

        };
        animator = new Animator(500, target);
        animator.setResolution(0);
        animator.setDeceleration(0.5f);
        animator.setAcceleration(0.5f);
        header.addMenuEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!animator.isRunning()) {
                    animator.start();
                }
                menu.setEnableMenu(false);
                if (menu.isShowMenu()) {
                    menu.hideallMenu();
                }
            }
        });
        //  Init google icon font
        IconFontSwing.register(GoogleMaterialDesignIcons.getIconFont());
        //  Start with this form
        main.showForm(new FarmerHome(user));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        bg.setBackground(new java.awt.Color(245, 245, 245));
        bg.setOpaque(true);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1366, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 783, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(FarmerModule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FarmerModule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FarmerModule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FarmerModule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FarmerModule(user).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane bg;
    // End of variables declaration//GEN-END:variables
}
