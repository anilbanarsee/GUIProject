/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Color;

/**
 *
 * @author User
 */
public class VerticalLayoutPanel extends javax.swing.JPanel {

    /**
     * Creates new form VerticalLayoutPanel
     */
    public VerticalLayoutPanel() {
        initComponents();
        initalize();
        
    }
    public void initalize(){
       currentWeatherPanel1.initBackground();
    }
        public void setColour(Color c){
            setBackground(new Color(0,0,0,0));
        
       // thisWeekWeatherPanel1.setColour(c);
        //weatherPanel1.setColour(c);
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

        trainStatusPanel1 = new gui.TrainStatusPanel();
        currentWeatherPanel1 = new gui.CurrentWeatherPanel();

        setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(currentWeatherPanel1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private gui.CurrentWeatherPanel currentWeatherPanel1;
    private gui.TrainStatusPanel trainStatusPanel1;
    // End of variables declaration//GEN-END:variables
}