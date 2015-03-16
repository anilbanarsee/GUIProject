package weatherdata;

import javax.swing.ImageIcon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class WeatherCodeHandler {
          public static String getWeatherString(int n){
                String[] weatherStrings = {"Clear","Sunshine","Partly Cloudy (night)","Partly Cloudy (day)","ERROR","Misty","Foggy","Cloudy","Overcast","Light Rain (night)","Light Rain (day)","Drizzle","Light Rain","Heavy Rain (night)","Heavy Rain (day)","Heavy Rain","Sleet (night)","Sleet (day)","Sleet","Hail (night)","Hail (day)","Hail","Light Snow (night)","Light Snow (day)","Light Snow","Heavy Snow (night)","Heavy Snow (day)","Heavy Snow","Thunderstorm (night)","Thunderstorm (day)","Thunderstorm"};

          return weatherStrings[n];
      }
          public static ImageIcon getWeatherIcon(int n){
               return new javax.swing.ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\GUIProject\\assets\\"+getWeatherString(n)+".png");

          }
}
