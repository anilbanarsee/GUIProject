/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.handler;

import java.util.ArrayList;
import weatherdata.DataNotFoundException;
import weatherdata.WeatherData;

/**
 *
 * @author User
 */
public class GUIHandler {
    public static String getCodeForWeather(int n){
        switch(n){
            case 0: return "C";
            case 1: return "B";
            case 2: return "H";
            case 3: return "I";
            case 4: return "";
            case 5: return "L";
            case 6: return "M";
            case 7: return "N";
            case 8: return "Y";
            case 9: return "Q";
            case 10: return "Q";
            case 11: return "Q";
            case 12: return "Q";
            case 13: return "R";
            case 14: return "R";
            case 15: return "R";
            case 16: return "T";
            case 17: return "T";
            case 18: return "T";
            case 19: return "X";
            case 20: return "X";
            case 21: return "X";
            case 22: return "U";
            case 23: return "U";
            case 24: return "U";
            case 25: return "W";
            case 26: return "W";
            case 27: return "W";
            case 28: return "0";
            case 29: return "0";
            case 30: return "0";
        }
        return "";
    }
    public static String getDescForWeather(int n){
        switch(n){
            case 0: return "Clear";
            case 1: return "Sunny";
            case 2: return "Cloudy";
            case 3: return "Cloudy";
            case 4: return "";
            case 5: return "Mist";
            case 6: return "Fog";
            case 7: return "Cloudy";
            case 8: return "Overcast";
            case 9: return "Light Rain";
            case 10: return "Light Rain";
            case 11: return "Drizzle";
            case 12: return "Light Rain";
            case 13: return "Heavy Rain";
            case 14: return "Heavy Rain";
            case 15: return "Heavy Rain";
            case 16: return "Sleet";
            case 17: return "Sleet";
            case 18: return "Sleet";
            case 19: return "Hail";
            case 20: return "Hail";
            case 21: return "Hail";
            case 22: return "Light Snow";
            case 23: return "Light Snow";
            case 24: return "Light Snow";
            case 25: return "Heavy Snow";
            case 26: return "Heavy Snow";
            case 27: return "Heavvy Snow";
            case 28: return "Thunderstorm";
            case 29: return "Thunderstorm";
            case 30: return "Thunderstorm";
        }
        return "";
    }
    public static ArrayList<ArrayList<String>> getFourDaysWeather(){
        WeatherData data = new WeatherData();
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        for(int i=1; i<=4;i++){
            ArrayList<String> tempList = new ArrayList<>();
            try{
                int n = data.getWeatherAtDay(i);
                int highTemp = data.getHighTempAtDay(i);
                int lowTemp = data.getLowTempAtDay(i);
                tempList.add(getCodeForWeather(n));
                tempList.add(highTemp+"");
                tempList.add(lowTemp+"");
            }
            catch(DataNotFoundException e){
                tempList.add("Cannot Find Data");
                tempList.add("");
                tempList.add("");
 
            }
            list.add(tempList);
            
        }
        return list;
    }
    public static ArrayList<Integer> getTodayTemperatures(){
        WeatherData data = new WeatherData();
        int[] times = {0,180,360,540,720,900,1080,1260};
        ArrayList<Integer> list = new ArrayList<>();
        for(int n:times){
            try{
                list.add(data.getTempAtTime(n));
            }
            catch(DataNotFoundException e){
                list.add(null);
            }
        }
        return list;
    }
}
