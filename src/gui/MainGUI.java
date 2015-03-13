/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Action;
import javax.swing.JLabel;
import javax.swing.KeyStroke;
import javax.swing.Timer;

/**
 *
 * @author User
 */
public class MainGUI extends javax.swing.JFrame{
    int indexSelected = 0;
    JLabel companyName;
    int alpha;
    Timer timer;
    Timer timer2;
    /**
     * Creates new form MainGUI
     */
    public MainGUI() {
        startUp();
        
        //initComponents();
        setColour(new Color(0,51,204));
        createControlPanel();
        
    }
    public void startUp(){
        setSize(320,480);
        
        companyName = new JLabel();
        companyName.setText("TEMPEST");
        companyName.setFont(new Font("Arial",1,18));
        add(companyName);
 //jLabel1.setForeground(new Color(0,0,0,0));
        alpha = 0;
       timer = new Timer(35, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
               alpha += 5;
               //System.out.println(alpha);
               companyName.setForeground(new Color(0,0,0,alpha));
               
               repaint();
                    if(alpha==255){
                    timer.stop();
                    
                    }
                    
                
                
            }
        }
        );
         timer.setInitialDelay(10);
            timer.start(); 
        timer2 = new Timer(50, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                remove(companyName);
                initComponents();
                
                setSize(320,480);
                repaint();
            }
        });
        timer2.setInitialDelay(1500);
        timer2.setRepeats(false);
        timer2.start();
    }
    public void switchToLandscape(){
        setSize(480,320);
        mainPanel1.switchToLandscape();
    }
    public void switchToPortrait(){
        setSize(320,480);
        mainPanel1.switchToPortrait();
    }
    public void createControlPanel(){
        ControlPanel a = new ControlPanel(this);
        a.setVisible(true);
    }
    public void setColour(Color c){
        //horizontalLayoutPanel1.setColour(c);
        //verticalLayoutPanel1.setColour(c);
    }
    public void swipeLeft(){
        mainPanel1.swipeLeft();
    }
    public void swipeRight(){
        mainPanel1.swipeRight();
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

        mainPanel1 = new gui.MainPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(320, 480));
        getContentPane().setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(mainPanel1, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private gui.MainPanel mainPanel1;
    // End of variables declaration//GEN-END:variables


}
