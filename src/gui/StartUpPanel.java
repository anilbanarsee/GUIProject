/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author User
 */
public class StartUpPanel extends javax.swing.JPanel {
    Timer timer;
    int alpha;
    /**
     * Creates new form StartUpPanel
     */
    public StartUpPanel() {
        initComponents();
        //fadeIn();
       // setVisible(true);
    }
    public void fadeIn(){
        //jLabel1.setForeground(new Color(0,0,0,0));
        alpha = 0;
       timer = new Timer(5, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
               alpha += 5;
               System.out.println(alpha);
               //jLabel1.setText(""+alpha);
               
               repaint();
                    if(alpha==255){
                    timer.stop();
                    }
                    
                
                
            }
        }
        );
         timer.setInitialDelay(10);
            timer.start(); 
        }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setLayout(new java.awt.GridLayout());

        jButton1.setText("jButton1");
        add(jButton1);

        jLabel2.setText("jLabel2");
        add(jLabel2);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
