/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.AbstractButton;

/**
 *
 * @author Magdi
 */
public class Options extends javax.swing.JPanel {
    ContentPane content;
    /**
     * Creates new form Options
     */
    public Options(ContentPane parent) {
        content = parent;
        initComponents();
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        celsiusRadio = new javax.swing.JRadioButton();
        buttonGroup1.add(celsiusRadio);
        fahrenheitRadio = new javax.swing.JRadioButton();
        buttonGroup1.add(fahrenheitRadio); 
        try {
            BufferedReader in = new BufferedReader(new FileReader("properties.txt"));
            String unit = in.readLine();
            if (unit.equals("C")) {
                celsiusRadio.setSelected(true);
            }
            else if (unit.equals("F")) {
                fahrenheitRadio.setSelected(true);
            }
            else {
                //do nothing
            }
            in.close();
        }
        catch (IOException ex) {
            System.out.println("FILE MISSING!");
        }
        saveButton = new javax.swing.JButton();

        setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel1.setText("Temperature Unit:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 15);
        add(jLabel1, gridBagConstraints);

        celsiusRadio.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        celsiusRadio.setText("Celsius");
        celsiusRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                celsiusRadioActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        add(celsiusRadio, gridBagConstraints);

        fahrenheitRadio.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        fahrenheitRadio.setText("Fahrenheit");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        add(fahrenheitRadio, gridBagConstraints);

        saveButton.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        saveButton.setText("Save & Close");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_END;
        gridBagConstraints.insets = new java.awt.Insets(11, 0, 0, 0);
        add(saveButton, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        if (evt.getSource() == saveButton) {
            try {
                PrintWriter out = new PrintWriter(new FileWriter("unit.txt"));
                if (fahrenheitRadio.isSelected()) {
                    out.write("F");
                }
                else if (celsiusRadio.isSelected()) {
                    out.write("C");
                }
                out.close();
            }
            catch (IOException ex) {
                System.out.println("FILE MISSING!");
            }
        }
        else if (evt.getSource() == celsiusRadio) {
            fahrenheitRadio.setSelected(false);
        }
        else if (evt.getSource() == fahrenheitRadio) {
            celsiusRadio.setSelected(false);
        }
        else {
            
        }
        content.setCurrentWeatherPanel();
        content.validateUnit();
    }//GEN-LAST:event_saveButtonActionPerformed

    private void celsiusRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_celsiusRadioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_celsiusRadioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton celsiusRadio;
    private javax.swing.JRadioButton fahrenheitRadio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables
}
