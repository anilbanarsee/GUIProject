/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import gui.handler.GUIHandler;
import gui.handler.Util;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 *
 * @author User
 */
public class CurrentWeatherPanel extends javax.swing.JPanel {
     private BufferedImage image;
     private BufferedImage weatherIcon;
     private Font weatherFont,weatherFont2;
     private JLabel degreeSymbol;
   
    private JPanel jPanel1, jPanel2;
     private JLabel humidIcon, humidLabel, temperatureLabel, weatheRIcon, weatherDesc, windDirectionIcon,
             windDirectionLabel, windSpeedIcon, windSpeedLabel;
     private int temperature;
    /**
     * Creates new form CurrentWeatherPanel
     */
    public CurrentWeatherPanel() {
        initBackground();
        initFont();
       initComponents();
       
       initalize();
       initData();
      setBackground(new Color(0,0,0,0));
      validateUnit();
     //  setOpaque(false);
       //jPanel1.setBackground(Color.WHITE);
    }
    
     @Override
    public boolean isOpaque(){
        return true;
    }
    public void validateUnit(){
        if(isCelcius()){
            switchToCelcius();
            return;
        }
        switchToFarenheit();
        return;
    }
    public boolean isCelcius(){
        BufferedReader br;
         try {
             br =  new BufferedReader(new FileReader("unit.txt"));
         } catch (FileNotFoundException ex) {
             return true;
         }
         String s = "C";
         try {
             s = br.readLine();
         } catch (IOException ex) {
             
         }
         if(s.equals("C")){
             return true;
         }
         return false;
    }
    public void switchToFarenheit(){
        setTemperature(GUIHandler.convertToFarenheit(temperature),false);
        degreeSymbol.setText("°F");
    }
    public void switchToCelcius(){
        setTemperature(temperature,true);
        degreeSymbol.setText("°C");
    }
    public void dimBackground(){
        setBackground(new Color(0,0,0,130));
    }
    public void undimBackground(){
        setBackground(new Color(0,0,0,0));
    }
    public void setTempSize(int n){
        temperatureLabel.setFont(new Font("Arial",0,n));
    }
     public void initData(){
        
        setWeatherIcon(GUIHandler.getWeatherToday());
        setWeather(GUIHandler.getWeatherToday());
        setTemperature(GUIHandler.getTempToday(),true);
        setHumidity(GUIHandler.getHumidityToday());
        setWindDirection(GUIHandler.getWindDirectionToday());
        setWindSpeed(GUIHandler.getWindSpeedToday());
    }
    public void initalize(){
        Font smallIcon = Util.getWeatherFont(25);
        
        //cityLabel.setText("London");
        //cityLabel.setFont(new Font("Arial",1,12));
        //cityLabel.setForeground(Color.WHITE);
        
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
        
        degreeSymbol.setText("°");
        degreeSymbol.setFont(new Font("Arial",1,35));
        degreeSymbol.setForeground(Color.WHITE);
        
        //setColor(new Color(255,255,255,100));
        jPanel1.setOpaque(false);
        jPanel2.setOpaque(false);
        setOpaque(false);
       
        
    }
    public void setColor(Color c){
        System.out.println("ALERT");
        //setBackground(c);
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        windDirectionIcon = new javax.swing.JLabel();
        windDirectionLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        temperatureLabel = new javax.swing.JLabel();
        weatheRIcon = new javax.swing.JLabel();
        weatherDesc = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        windSpeedIcon = new javax.swing.JLabel();
        humidLabel = new javax.swing.JLabel();
        humidIcon = new javax.swing.JLabel();
        windSpeedLabel = new javax.swing.JLabel();
        degreeSymbol = new javax.swing.JLabel();

        windDirectionIcon.setFont(weatherFont2);
        windDirectionIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        windDirectionIcon.setText("windDirectionIcon");

        windDirectionLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        windDirectionLabel.setText("windDirectionLabel");

     
        setLayout(new java.awt.GridBagLayout());

        jPanel1.setLayout(new java.awt.GridBagLayout());

        temperatureLabel.setText("temperature");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LAST_LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel1.add(temperatureLabel, gridBagConstraints);

        weatheRIcon.setText("weatherIcon");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 0, 0);
        jPanel1.add(weatheRIcon, gridBagConstraints);

        weatherDesc.setText("weatherDesc");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        jPanel1.add(weatherDesc, gridBagConstraints);

        jPanel2.setLayout(new java.awt.GridBagLayout());

        windSpeedIcon.setFont(weatherFont2);
        windSpeedIcon.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        windSpeedIcon.setText("windSpeedIcon");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 1);
        jPanel2.add(windSpeedIcon, gridBagConstraints);

        humidLabel.setText("humidLabel");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 1, 0, 0);
        jPanel2.add(humidLabel, gridBagConstraints);

        humidIcon.setFont(weatherFont2);
        humidIcon.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        humidIcon.setText("humidIcon");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 1);
        jPanel2.add(humidIcon, gridBagConstraints);

        windSpeedLabel.setText("windSpeedLabel");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        jPanel2.add(windSpeedLabel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        jPanel1.add(jPanel2, gridBagConstraints);

        degreeSymbol.setText("°");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        jPanel1.add(degreeSymbol, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LAST_LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(jPanel1, gridBagConstraints);
    }// </editor-fold>                        

    
   
    public void setWeatherIcon(int n){
        weatheRIcon.setText(GUIHandler.getCodeForWeather(n));
    }
    public void setWeather(int n){
        weatherDesc.setText(GUIHandler.getDescForWeather(n));
    }
    public void setTemperature(int n, boolean b){
        if(b){
        temperature = n;
        }
        temperatureLabel.setText(n+"");
    }
    public void setHumidity(int n){
        humidLabel.setText(n+"");
        
    }
    public void setWindDirection(String s){
        windDirectionLabel.setText(s);
    }
    public void setWindSpeed(int n){
        windSpeedLabel.setText(n+"");
    }
    public void initFont(){
        weatherFont = Util.getWeatherFont(125);
        weatherFont2 = Util.getWeatherFont(25);
                }
    public void initBackground(){
        
        String filePath = "assets\\background.png";
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
    // Variables declaration - do not modify                     

    // End of variables declaration                   
}
