/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui2;

import gui.handler.Util;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JPanel;
import weatherdata.WeatherCodeHandler;

/**
 *
 * @author Anil
 */
public class WeekWeatherSubBar extends JPanel{
    JLabel dayName, highTemp, lowTemp, weatherIcon;
    public WeekWeatherSubBar(){
        initComplete();
    }
    public void initComplete(){
        initComponentData();
        initComponentPosition();
    }
    public void initComponentData(){
        Font font = new Font("Arial", 0,11);
        
        dayName = new JLabel();
        highTemp = new JLabel();
        lowTemp = new JLabel();
        weatherIcon = new JLabel();
        
        weatherIcon.setText("T");
        dayName.setText("Mon");
        highTemp.setText("21");
        lowTemp.setText("15");
        dayName.setFont(font);
        weatherIcon.setFont(Util.getWeatherFont(25));
    }
    public void initComponentPosition(){
        setLayout(new GridBagLayout());
        
        GridBagConstraints c = new GridBagConstraints();
        dayName.setAlignmentX(1.0F);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.LINE_START;
        c.weightx = 1.0;
        c.insets = new Insets(0,5,0,0);
        add(dayName, c);
        
        c = new GridBagConstraints();
        highTemp.setAlignmentX(1.0F);
        c.gridx = 2;
        c.gridy = 0;
        c.anchor = GridBagConstraints.LINE_END;
        add(highTemp, c);
        
        c = new GridBagConstraints();
        lowTemp.setAlignmentX(1.0F);
        c.gridx = 3;
        c.gridy = 0;
        c.anchor = GridBagConstraints.LINE_END;
        c.insets = new Insets(0,0,0,4);
        add(lowTemp, c);
        
        c = new GridBagConstraints();
        weatherIcon.setAlignmentX(1.0F);
        c.gridx = 1;
        c.gridy = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.LINE_END;
        c.weightx = 1.0;
        add(weatherIcon, c);
    }
    public void setDayName(String s){
        dayName.setText(s);
    }
    public void setHighTemp(int n){
        highTemp.setText(n+"°C");
    }
    public void setLowTemp(int n){
        lowTemp.setText(n+"°C");
    }
     public void setColour(Color color){
        setBackground(color);
    }
}
