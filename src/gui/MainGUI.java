/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author User
 */
public class MainGUI extends javax.swing.JFrame{
    int indexSelected = 0;
    JLabel companyName;
    boolean fadein = true;
    int alpha;
    Timer timer;
    Timer timer2;
    BufferedImage img;
    float opacity = 0.0f;
    boolean start = true;
    /**
     * Creates new form MainGUI
     */
    public MainGUI() throws IOException{
        img = ImageIO.read(new File("assets//logo.png"));
        setBackground(new Color(255,255,255,255));
        startUp();
        
        //initComponents();
        setColour(new Color(0,51,204));
        createControlPanel();
        
    }
    @Override
    public void paint(Graphics g){
        if(!start){
        super.paintComponents(g);
        }
        if(start){
            //System.out.println("Hello");
        Graphics2D g2 = (Graphics2D) g;
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity));
        g2.drawImage(img,27,107,null);
        //g2.dispose();
        }
    }
   

    public void startUp(){
        setSize(320,480);
        
        companyName = new JLabel();
        companyName.setText("TEMPEST");
        companyName.setIcon(new ImageIcon(img));
        companyName.setFont(new Font("Arial",1,18));
         timer2 = new Timer(50, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
               
                start = false;
                remove(companyName);
                initComponents();
                
                setSize(320,480);
                repaint();
            }
        });
        add(companyName);
 //jLabel1.setForeground(new Color(0,0,0,0));
        alpha = 0;
        playSound();
       timer = new Timer(25, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
               //alpha += 5;
               if(fadein){
                   opacity += 0.008f;
               }
               
               if(opacity>=1.0f){
                   opacity = 1.0f;
                   timer.stop();
                   timer2.start();
                     
               }
               
             
               //System.out.println(alpha);
               //companyName.setForeground(new Color(0,0,0,alpha));
               
               repaint();
                  
                    
                
                
            }
        }
        );
         timer.setInitialDelay(10);
            timer.start(); 
       
        timer2.setInitialDelay(100);
        timer2.setRepeats(false);
        //timer2.start();
    }
    public void playSound(){
        JFXPanel fxPanel = new JFXPanel();
        URL resource = null;
        try {
            resource = new File("assets//start_up.mp3").toURI().toURL();
        } catch (MalformedURLException ex) {
            Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        final Media media = new Media(resource.toString());
         final MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
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
                try {
                    new MainGUI().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private gui.MainPanel mainPanel1;
    // End of variables declaration//GEN-END:variables


}
