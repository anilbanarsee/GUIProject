/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import gui.handler.Util;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;


/**
 *
 * @author User
 */
public class CurrentWeatherPanel extends javax.swing.JPanel {
     private BufferedImage image;
     private BufferedImage weatherIcon;
     private Font weatherFont,weatherFont2;
    /**
     * Creates new form CurrentWeatherPanel
     */
    public CurrentWeatherPanel() {
        
        initFont();
       initComponents();
       initalize();
      
       
    }
    public void initalize(){
        Font smallIcon = Util.getWeatherFont(25);
        
        cityLabel.setText("London");
        cityLabel.setFont(new Font("Arial",0,12));
        cityLabel.setForeground(Color.WHITE);
        
        windSpeedIcon.setText("F");
        windSpeedIcon.setFont(smallIcon);
        windSpeedIcon.setForeground(Color.WHITE);
        
        windSpeedLabel.setText("20mph");
        windSpeedLabel.setFont(new Font("Arial",0,10));
        windSpeedLabel.setForeground(Color.WHITE);
        
        windDirectionIcon.setText("(");
        windDirectionIcon.setFont(smallIcon);
        windDirectionIcon.setForeground(Color.WHITE);
        
        windSpeedLabel.setText("30mph");
        windSpeedLabel.setFont(new Font("Arial",0,10));
        windSpeedLabel.setForeground(Color.WHITE);
        
        humidIcon.setText("Q");
        humidIcon.setFont(smallIcon);
        humidIcon.setForeground(Color.WHITE);
        
        humidLabel.setText("50%");
        humidLabel.setFont(new Font("Arial",0,10));
        
        humidLabel.setForeground(Color.WHITE);
        
        temperatureLabel.setText("50");
        temperatureLabel.setFont(new Font("Arial",0,120));
        temperatureLabel.setForeground(Color.WHITE);
        
        weatheRIcon.setText("R");
        weatheRIcon.setFont(Util.getWeatherFont(30));
        weatheRIcon.setForeground(Color.WHITE);
        
        weatherDesc.setText("Light Rain");
        weatherDesc.setFont(new Font("Arial",1,13));
        weatherDesc.setForeground(Color.WHITE);
        
        setColor(new Color(255,255,255,100));
        jPanel1.setOpaque(false);
        
        
        
    }
    public void setColor(Color c){
        System.out.println("ALERT");
        setBackground(c);
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        windDirectionIcon = new javax.swing.JLabel();
        windDirectionLabel = new javax.swing.JLabel();
        cityLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        windSpeedIcon = new javax.swing.JLabel();
        humidIcon = new javax.swing.JLabel();
        humidLabel = new javax.swing.JLabel();
        windSpeedLabel = new javax.swing.JLabel();
        temperatureLabel = new javax.swing.JLabel();
        weatheRIcon = new javax.swing.JLabel();
        weatherDesc = new javax.swing.JLabel();

        windDirectionIcon.setFont(weatherFont2);
        windDirectionIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        windDirectionIcon.setText("windDirectionIcon");

        windDirectionLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        windDirectionLabel.setText("windDirectionLabel");

        setLayout(new java.awt.GridBagLayout());

        cityLabel.setText("cityLabel");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(cityLabel, gridBagConstraints);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        windSpeedIcon.setFont(weatherFont2);
        windSpeedIcon.setText("windSpeedIcon");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel1.add(windSpeedIcon, gridBagConstraints);

        humidIcon.setFont(weatherFont2);
        humidIcon.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        humidIcon.setText("humidIcon");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel1.add(humidIcon, gridBagConstraints);

        humidLabel.setText("humidLabel");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel1.add(humidLabel, gridBagConstraints);

        windSpeedLabel.setText("windSpeedLabel");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel1.add(windSpeedLabel, gridBagConstraints);

        temperatureLabel.setText("temperature");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LAST_LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel1.add(temperatureLabel, gridBagConstraints);

        weatheRIcon.setText("weatherIcon");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        jPanel1.add(weatheRIcon, gridBagConstraints);

        weatherDesc.setText("weatherDesc");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel1.add(weatherDesc, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        add(jPanel1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents
    public void setLocationText(String s){
        
    }
    public void setTimeText(int n){
        
    }
    public void setWeatherText(String s){
        
    }
    public void setWeatherIcon(int n){
        
    }
    public void setWeather(int n){
        
    }
    public void initFont(){
        weatherFont = Util.getWeatherFont(125);
        weatherFont2 = Util.getWeatherFont(25);
                }
    public void initBackground(){
        String filePath = "C:\\Users\\User\\Documents\\NetBeansProjects\\GUIProject\\assets\\background.png";
        image = Util.scaleImage(320, 480, filePath);
    }
    public void setWeatherImage(String filePath){
        weatherIcon = Util.scaleImage(200, 200, filePath);
        Image tempImg = Util.makeWhiteTransparent(weatherIcon);
        weatherIcon = convertToBufferedImage(tempImg);
       // jLabel3.setIcon(new ImageIcon(weatherIcon));
  
    }
    private static BufferedImage convertToBufferedImage(Image img){
        BufferedImage tempImage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        Graphics2D G2D = tempImage.createGraphics();
        G2D.drawImage(img,0,0,null);
        G2D.dispose();
        return tempImage;
    }
     @Override
    protected void paintComponent(Graphics g){
        
        super.paintComponent(g);
    //    initBackground();
        g.drawImage(image,0,0,null);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cityLabel;
    private javax.swing.JLabel humidIcon;
    private javax.swing.JLabel humidLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel temperatureLabel;
    private javax.swing.JLabel weatheRIcon;
    private javax.swing.JLabel weatherDesc;
    private javax.swing.JLabel windDirectionIcon;
    private javax.swing.JLabel windDirectionLabel;
    private javax.swing.JLabel windSpeedIcon;
    private javax.swing.JLabel windSpeedLabel;
    // End of variables declaration//GEN-END:variables
}
