/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.GridBagConstraints;
import java.awt.Insets;

/**
 *
 * @author Reetoo
 */
public class TravelPanel extends javax.swing.JPanel {

    TrainStatusPanel status;
    CurrentWeatherPanel current;
    /**
     * Creates new form TravelPanel
     */
    public TravelPanel() {
        initComponents();
        initalize();
    }
    public void setLandscape(){
        removeAll();
        GridBagConstraints c = new  GridBagConstraints();
        c.fill =  GridBagConstraints.BOTH;
        c.weightx = 1;
        c.weighty = 1;
        c.gridx = 1;
        c.gridy = 0;
        c.insets = new Insets(10,10,10,10);
        add(status,c);
        
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0;
        c.weighty = 1;
        c.gridx=0;
        c.gridy=0;
        add(current,c);
        revalidate();
        repaint();
    }
    public void setPortrait(){
        removeAll();
         GridBagConstraints c = new  GridBagConstraints();
        c.fill =  GridBagConstraints.BOTH;
        c.weightx = 1;
        c.weighty = 0;
        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(10,10,10,10);
        add(status,c);
        
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.weighty = 1;
        
        add(current,c);
    }
    public void initalize(){
        status = new TrainStatusPanel();
        current = new CurrentWeatherPanel();
        
        
        
        GridBagConstraints c = new  GridBagConstraints();
        c.fill =  GridBagConstraints.BOTH;
        c.weightx = 1;
        c.weighty = 0;
        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(10,10,10,10);
        add(status,c);
        
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.weighty = 1;
        
        add(current,c);
    }
     @Override
    public boolean isOpaque(){
        return false;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new java.awt.GridBagLayout());
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
