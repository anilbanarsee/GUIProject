/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Reetoo
 */
public class MainPanel extends javax.swing.JPanel {
    boolean moving = false;
    boolean start = false;
    int indexSelected = 0;
    int backgroundPosX = 0;
    int backgroundPosY = 0;
    boolean portrait = true;
    float opacity = 0.5f;
    int x = 0;
    BufferedImage logo;
    Timer timer;
    Image img;
    /**
     * Creates new form MainPanel
     */
    public MainPanel() {
         img = chooseRandomBackground();
        initComponents();
       // this.setBackground(Color.BLACK);
    }
    
    private Image chooseRandomBackground()
    {
        Random rand = new Random();
        int backgroundNo = rand.nextInt(3);
        System.out.println(backgroundNo);
        return Toolkit.getDefaultToolkit().createImage("assets//background" +Integer.toString(backgroundNo+1)+".jpg");
    }
    
    public void switchToPortrait(){
        if(portrait){
            return;           
        }
        portrait = true;
        content.setPortrait();
    }
        public void switchToLandscape(){
            
        if(!portrait){
            return;           
        }
        portrait = false;
        
        content.setLandscape();
    }
        
    public void swipeLeft(){
           
        indexSelected--;
        if(indexSelected<0){
            indexSelected = 2;
        }
         System.out.println("C:"+indexSelected);
        if(indexSelected==0){
            
            content.setCurrentWeatherPanel();
            moveBackground(0,10000);
            
            revalidate();
            repaint();
            
        }
        if(indexSelected==1){
            
            
            moveBackground(-320,10000);
            content.setFutureWeatherPanel();
            
          
            revalidate();
            repaint();
        }
        if(indexSelected==2){
            content.setTravelPanel();
            moveBackground(-640,10000);
           revalidate();
            repaint();
        }
    }
    public void swipeRight(){
        
        indexSelected++;
        if(indexSelected>2){
            indexSelected = 0;
        }
        System.out.println("D:"+indexSelected);
        if(indexSelected==0){
            content.setCurrentWeatherPanel();
             moveBackground(0,10000);
           repaint();
        }
        if(indexSelected==1){
            content.setFutureWeatherPanel();
             moveBackground(-320,10000);
           repaint();
        }
        if(indexSelected==2){
            content.setTravelPanel();
            moveBackground(-640,10000);
           repaint();
        }
    }
    @Override
    public void paintComponent(Graphics g){
        
        super.paintComponent(g);
        
        //System.out.println("Hello");
        g.drawImage(img,backgroundPosX,backgroundPosY,null);
        
        
    }
    public void moveBackground(int n, int time){
        if(!moving){
            moving = true;
       int i = n-backgroundPosX;
        if(i>0){
       x = 0;
       System.out.println("POSITIVE");
       //System.out.println(backgroundPosX);
      // System.out.println(backgroundPosY);
       
        timer = new Timer(5, new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                   x++;
                   if(backgroundPosX + x>n){
                       backgroundPosX = n;
                   }
                   else{
                       backgroundPosX+=x;
                   }
                   repaint();
                   if(backgroundPosX==n){
                       timer.stop();
                       moving=false;
                   }
                   
                }
            }
            );
         timer.setInitialDelay(10);
            timer.start(); 
        }
        if(i<0){
            System.out.println("NEGATIVE");
             x = 0;
            System.out.println(backgroundPosX);
            System.out.println(backgroundPosY);
       
             timer = new Timer(7, new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                   backgroundPosX-=x;
                   x++;
                   if(backgroundPosX-x<n){
                       x = backgroundPosX-n;
                   }
                   if(backgroundPosX==n){
                       timer.stop();
                       moving = false;
                   }
                   repaint();
                }
            }
            );
         timer.setInitialDelay(10);
            timer.start(); 
        }
    }
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

        content = new gui.ContentPane();
        topBar1 = new gui.TopBar();

        setLayout(new java.awt.GridBagLayout());

        content.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                contentMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 353;
        gridBagConstraints.ipady = 455;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(content, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 374;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(topBar1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void contentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contentMouseClicked
     
    }//GEN-LAST:event_contentMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private gui.ContentPane content;
    private gui.TopBar topBar1;
    // End of variables declaration//GEN-END:variables
}
