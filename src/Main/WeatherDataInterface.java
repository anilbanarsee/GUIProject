/*
 * Interface for WeatherData
 */
package Main;

/**
 *
 * @author Hamzah
 */
public interface WeatherDataInterface {
    //There will be no public variables
    
    //Gets current Weather
    public int getCurrentWeather() throws DataNotFoundException;
    
    /*
     * Note, whenever a time variable is used, you may only use the following numbers
     * 0,180,360,540,720,900,1080,1260
     * These correspond to three hour intervals in a day.
     */
    
    //The weather codes are
    //If i get a NA code, i will instead use number 4
    /*
        NA-Not available
        0-Clear night
        1-Sunny day
        2-Partly cloudy (night)
        3-Partly cloudy (day)
        4-Not used
        5-Mist
        6-Fog
        7-Cloudy
        8-Overcast
        9-Light rain shower (night)
        10-Light rain shower (day)
        11-Drizzle
        12-Light rain
        13-Heavy rain shower (night)
        14-Heavy rain shower (day)
        15-Heavy rain
        16-Sleet shower (night)
        17-Sleet shower (day)
        18-Sleet
        19 -Hail shower (night)
        20 -Hail shower (day)
        21 -Hail
        22 -Light snow shower (night)
        23 -Light snow shower (day)
        24 -Light snow
        25 -Heavy snow shower (night)
        26 -Heavy snow shower (day)
        27 -Heavy snow
        28 -Thunder shower (night)
        29 -Thunder shower (day)
        30 -Thunder
    */
    
    
    
    //Gets the weather at a certain time
    public int getWeatherAtTime(int time) throws DataNotFoundException;
    
    //Gets the average temperature at a certain time
    public int getTempAtTime(int time) throws DataNotFoundException;
    
    //Gets current wind speed
    //Note, i return an int, but it is a percentage out of 100
    public int getCurrentWindSpeed() throws DataNotFoundException;
    
    //Gets wind direction
    public String getCurrentWindDirection() throws DataNotFoundException;
    
    //Gets current humidity
    public int getCurrentHumidity() throws DataNotFoundException;
    
    /*
     * These methods are for the coming days
     * They also require an int number from 1-4 which says how many days in the future
     * you want the information
     */
    //Gets weather on a day
    public int getWeatherAtDay(int day) throws DataNotFoundException;
    
    //Gets high temp on a day
    public int getHighTempAtDay(int day) throws DataNotFoundException;
    
    //Gets low temp on a day
    public int getLowTempAtDay(int day) throws DataNotFoundException;
    
    //Gets the average temp for a day
    public int getAverageTempAtDay(int day) throws DataNotFoundException;
}
