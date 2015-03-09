/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import gui.handler.Util;
import java.awt.Color;
import java.awt.Font;

/**
 *
 * @author User
 */
public class HourWeatherSubPanel extends javax.swing.JPanel {
    Font weatherFont;
    /**
     * Creates new form HourWeatherSubPanel
     */
    public HourWeatherSubPanel() {
        initFont();
        initComponents();
        
    }
     public void setColour(Color color){
        setBackground(color);
    }
    public void setTimeText(int n){
        jLabel1.setText((n/60)+":00");
        
    }
    public void setTemp(int n){
        jLabel3.setText(n+"*C");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 153, 0));
        setForeground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("9:00");
        add(jLabel1, new java.awt.GridBagConstraints());

        jLabel2.setFont(weatherFont);
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Y");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        add(jLabel2, gridBagConstraints);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("9°C");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        add(jLabel3, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void initFont(){
        weatherFont = Util.getWeatherFont(30);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
