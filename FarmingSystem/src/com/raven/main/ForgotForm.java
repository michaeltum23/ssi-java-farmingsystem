/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.raven.main;

import com.raven.component.Message;
import com.raven.component.PanelCoverForgot;
import com.raven.component.PanelLoading;
import com.raven.component.PanelForgot;
import com.raven.component.PanelVerifyCode;
import com.raven.form.RegisterForm;
import com.raven.model.ModelLogin;
import com.raven.model.ModelMessage;
import farmingsystem.FarmingConnection;
import farmingsystem.controller.ServiceMail;
import farmingsystem.controller.UserImp;
import farmingsystem.model.User;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import javax.swing.JLayeredPane;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;


public class ForgotForm extends javax.swing.JFrame {

    private final DecimalFormat df = new DecimalFormat("##0.###", DecimalFormatSymbols.getInstance(Locale.US));
    private MigLayout layout;
    private PanelCoverForgot cover;
    private PanelLoading loading;
    private PanelVerifyCode verifyCode;
    private PanelForgot loginAndRegister;
    private boolean isLogin;
    private final double addSize = 30;
    private final double coverSize = 40;
    private final double loginSize = 60;
    private UserImp userService;
    private RegisterForm registerForm;

    public ForgotForm() {
        initComponents();
        init();
    }

    private void init() {
        try {
            userService = new UserImp();
            userService.deleteInit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        layout = new MigLayout("fill, insets 0");
        cover = new PanelCoverForgot();
        loading = new PanelLoading();
        verifyCode = new PanelVerifyCode();
        
        ActionListener eventRegister = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                register();
            }
        };
        
        ActionListener eventLogin = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login();
            }
        };
        
        ActionListener eventForgot = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              //  forgot();
               System.out.println("TEst");
            }
        };
        
        loginAndRegister = new PanelForgot(eventRegister, eventLogin ,eventForgot);
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                double fractionCover;
                double fractionLogin;
                double size = coverSize;
                if (fraction <= 0.5f) {
                    size += fraction * addSize;
                } else {
                    size += addSize - fraction * addSize;
                }
                if (isLogin) {
                    fractionCover = 1f - fraction;
                    fractionLogin = fraction;
                    if (fraction >= 0.5f) {
                        cover.registerRight(fractionCover * 100);
                    } else {
                        cover.loginRight(fractionLogin * 100);
                    }
                } else {
                    fractionCover = fraction;
                    fractionLogin = 1f - fraction;
                    if (fraction <= 0.5f) {
                        cover.registerLeft(fraction * 100);
                    } else {
                        cover.loginLeft((1f - fraction) * 100);
                    }
                }
                if (fraction >= 0.5f) {
                    loginAndRegister.showRegister(isLogin);
                }
                fractionCover = Double.valueOf(df.format(fractionCover));
                fractionLogin = Double.valueOf(df.format(fractionLogin));
                layout.setComponentConstraints(cover, "width " + size + "%, pos " + fractionCover + "al 0 n 100%");
                layout.setComponentConstraints(loginAndRegister, "width " + loginSize + "%, pos " + fractionLogin + "al 0 n 100%");
                bg.revalidate();
            }

            @Override
            public void end() {
                isLogin = !isLogin;
            }
        };
        Animator animator = new Animator(800, target);
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
        animator.setResolution(0);  //  for smooth animation
        bg.setLayout(layout);
        bg.setLayer(loading, JLayeredPane.POPUP_LAYER);
        bg.setLayer(verifyCode, JLayeredPane.POPUP_LAYER);
        bg.add(loading, "pos 0 0 100% 100%");
        bg.add(verifyCode, "pos 0 0 100% 100%");
        bg.add(cover, "width " + coverSize + "%, pos " + (isLogin ? "1al" : "0al") + " 0 n 100%");
        bg.add(loginAndRegister, "width " + loginSize + "%, pos " + (isLogin ? "0al" : "1al") + " 0 n 100%"); //  1al as 100%
        loginAndRegister.showRegister(!isLogin);
        cover.login(isLogin);
        cover.addEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!animator.isRunning()) {
                    animator.start();
                }
            }
        });
        verifyCode.addEventButtonOK(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    User user = loginAndRegister.getUser();
                    System.out.println(user.getId());
                    System.out.println(verifyCode.getInputCode());
                    if (userService.verifyCodeWithUserForgot(user.getId(), verifyCode.getInputCode())) {
                        userService.doneVerifyForgot(user.getId());
                      
                        verifyCode.setVisible(false);
                        userService.updateUserNewPassword(user);       
                        showMessage(Message.MessageType.SUCCESS, "Successfully Password Change");
                        loginAndRegister.showRegister(isLogin);

                    } else {
                        showMessage(Message.MessageType.ERROR, "Verification code incorrect");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    showMessage(Message.MessageType.ERROR, "Error");
                }
            }
        });
    }

    private void register() {
        User user = loginAndRegister.getUser();
        try {
            if (userService.checkDuplicateEmail(user.getEmail())) {
                  showMessage(Message.MessageType.SUCCESS, "Email Confirmed");
                  userService.insertUserFogot(user);
                  sendMain(user);
            } else {
               showMessage(Message.MessageType.ERROR, "Email Not Registered");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            showMessage(Message.MessageType.ERROR, "ERROR REGISTER");
        }
    }

    private void login() {
        ModelLogin data = loginAndRegister.getDataLogin();
        try {
            User user = userService.login(data);
            if (user != null) {
                this.dispose();
                if (user.getUserType().equals("Farmer")) {
                    FarmerModule.main(user);
                } else if (user.getUserType().equals("Admin")) {
                    Main.main(user);
                } else if (user.getUserType().equals("Supplier")) {
                    SupplierModule.main(user);
                } else {
                    showMessage(Message.MessageType.ERROR, "INVALID USER");
                }
            } else {
                showMessage(Message.MessageType.ERROR, "Email or Password incorrect");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            showMessage(Message.MessageType.ERROR, "Error");
        }
    }

    private void sendMain(User user) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                loading.setVisible(true);
                System.out.println(user.getVerifyCode());
                ModelMessage ms = new ServiceMail().sendMain(user.getEmail(), user.getVerifyCode());
                if (ms.isSuccess()) {
                    loading.setVisible(false);
                    verifyCode.setVisible(true);
                } else {
                    loading.setVisible(false);
                    showMessage(Message.MessageType.ERROR, ms.getMessage());
                }
            }
        }).start();
    }

    public void showMessage(Message.MessageType messageType, String message) {
        Message ms = new Message();
        ms.showMessage(messageType, message);
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void begin() {
                if (!ms.isShow()) {
                    bg.add(ms, "pos 0.5al -30", 0); //  Insert to bg fist index 0
                    ms.setVisible(true);
                    bg.repaint();
                }
            }

            @Override
            public void timingEvent(float fraction) {
                float f;
                if (ms.isShow()) {
                    f = 40 * (1f - fraction);
                } else {
                    f = 40 * fraction;
                }
                layout.setComponentConstraints(ms, "pos 0.5al " + (int) (f - 30));
                bg.repaint();
                bg.revalidate();
            }

            @Override
            public void end() {
                if (ms.isShow()) {
                    bg.remove(ms);
                    bg.repaint();
                    bg.revalidate();
                } else {
                    ms.setShow(true);
                }
            }
        };
        Animator animator = new Animator(300, target);
        animator.setResolution(0);
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
        animator.start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    animator.start();
                } catch (InterruptedException e) {
                    System.err.println(e);
                }
            }
        }).start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setOpaque(true);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1128, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 708, Short.MAX_VALUE)
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
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        try {
            FarmingConnection.getConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new LoginForm().setVisible(true);
                ForgotForm lf = new ForgotForm();
                lf.setVisible(true);
                lf.setLocationRelativeTo(null);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane bg;
    // End of variables declaration//GEN-END:variables
}
