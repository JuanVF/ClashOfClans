package com.game.views;

import com.game.model.Tools;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainWindow extends javax.swing.JFrame {

    public MainWindow() {
        initComponents();
        try {
            background.setIcon(Tools.getComponentIcon("res/bg.png", background.getWidth(), background.getHeight()));

            btnPlay.setIcon(Tools.getComponentIcon("res/play_button.png", btnPlay.getWidth(), btnPlay.getHeight()));
            btnLoad.setIcon(Tools.getComponentIcon("res/load_button.png", btnPlay.getWidth(), btnPlay.getHeight()));
            btnConfig.setIcon(Tools.getComponentIcon("res/config_button.png", btnPlay.getWidth(), btnPlay.getHeight()));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnLoad = new javax.swing.JLabel();
        btnConfig = new javax.swing.JLabel();
        btnPlay = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 500));
        getContentPane().setLayout(null);

        btnLoad.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLoad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLoadMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLoadMouseExited(evt);
            }
        });
        getContentPane().add(btnLoad);
        btnLoad.setBounds(500, 190, 130, 80);

        btnConfig.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConfig.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnConfigMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnConfigMouseExited(evt);
            }
        });
        getContentPane().add(btnConfig);
        btnConfig.setBounds(130, 190, 170, 80);

        btnPlay.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPlay.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                btnPlayFocusGained(evt);
            }
        });
        btnPlay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPlayMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPlayMouseExited(evt);
            }
        });
        getContentPane().add(btnPlay);
        btnPlay.setBounds(320, 190, 130, 80);
        getContentPane().add(background);
        background.setBounds(0, 0, 810, 510);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPlayFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnPlayFocusGained

    }//GEN-LAST:event_btnPlayFocusGained

    // Animaciones
    private void btnPlayMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPlayMouseEntered
        try {
            btnPlay.setIcon(Tools.getComponentIcon("res/play_focus_button.png", btnPlay.getWidth(), btnPlay.getHeight()));

        } catch (IOException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
     }//GEN-LAST:event_btnPlayMouseEntered

    private void btnPlayMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPlayMouseExited
        try {
            btnPlay.setIcon(Tools.getComponentIcon("res/play_button.png", btnPlay.getWidth(), btnPlay.getHeight()));

        } catch (IOException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPlayMouseExited

    private void btnConfigMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfigMouseEntered
        try {
            btnConfig.setIcon(Tools.getComponentIcon("res/config_focus_button.png", btnPlay.getWidth(), btnPlay.getHeight()));

        } catch (IOException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnConfigMouseEntered

    private void btnConfigMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfigMouseExited
        try {
            btnConfig.setIcon(Tools.getComponentIcon("res/config_button.png", btnPlay.getWidth(), btnPlay.getHeight()));

        } catch (IOException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnConfigMouseExited

    private void btnLoadMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoadMouseEntered
        try {
            btnLoad.setIcon(Tools.getComponentIcon("res/load_focus_button.png", btnPlay.getWidth(), btnPlay.getHeight()));

        } catch (IOException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLoadMouseEntered

    private void btnLoadMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoadMouseExited
        try {
            btnLoad.setIcon(Tools.getComponentIcon("res/load_button.png", btnPlay.getWidth(), btnPlay.getHeight()));

        } catch (IOException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLoadMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JLabel btnConfig;
    private javax.swing.JLabel btnLoad;
    private javax.swing.JLabel btnPlay;
    // End of variables declaration//GEN-END:variables
}
