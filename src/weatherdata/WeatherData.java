/*
 * This class is designed to download weather data from the met office
 */
package weatherdata;

import weatherdata.WeatherDataInterface;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Hamzah
 */
public class WeatherData implements WeatherDataInterface
{
    String apiKey = "e8301ece-ac18-4968-9199-6f245e616e4e";
    Document docDaily;
    Document docHourly;
    boolean init = false;
    
    public WeatherData()
    {
        try 
        {
            URL weatherDataHourly = new URL("http://datapoint.metoffice.gov.uk/public/data/val/wxfcs/all/xml/352409?res=3hourly&key=e8301ece-ac18-4968-9199-6f245e616e4e");
            URL weatherDataDaily = new URL("http://datapoint.metoffice.gov.uk/public/data/val/wxfcs/all/xml/352409?res=daily&key=e8301ece-ac18-4968-9199-6f245e616e4e");
            //Now ive got the data for both daily and hourly weather for london
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            docDaily = dBuilder.parse(weatherDataDaily.openConnection().getInputStream());
            docDaily.getDocumentElement().normalize();
            docHourly = dBuilder.parse(weatherDataHourly.openConnection().getInputStream());
            docHourly.getDocumentElement().normalize();
            init = true;
        } 
        catch (SAXException | IOException | ParserConfigurationException ex) 
        {
           // Logger.getLogger(WeatherData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @Override
    public int getCurrentWeather() throws DataNotFoundException
    {
        if(!init){
            throw new DataNotFoundException();
        }
        NodeList nList = docHourly.getElementsByTagName("Rep");
        if(nList!=null && nList.getLength() > 0)
        {
            //Get First element in list
            //Then return weather code
            Element element = (Element)nList.item(0);
            return Integer.parseInt(element.getAttributes().getNamedItem("W").getNodeValue());
        }
        //Cant find current weather in list
        throw new DataNotFoundException("Cannot find current Weather");
    }

    @Override
    public int getWeatherAtTime(int time) throws DataNotFoundException
    {
         if(!init){
            throw new DataNotFoundException();
         }
        NodeList nList = docHourly.getElementsByTagName("Rep");
        if(nList!=null && nList.getLength() > 0)
        {
            //Look through list, once i find a node matching the input time
            //I return that times weather code
            for(int i=0;i<nList.getLength();i++)
            {
                Element element = (Element)nList.item(i);
                if(Integer.parseInt(element.getTextContent())==time)
                {
                    return Integer.parseInt(element.getAttributes().getNamedItem("W").getNodeValue());
                }
            }
        }
        //Cant find that time in todays list
        throw new DataNotFoundException("Cannot find Weather for that time");
    }

    @Override
    public int getTempAtTime(int time) throws DataNotFoundException
    {
          if(!init){
            throw new DataNotFoundException();
         }
        NodeList nList = docHourly.getElementsByTagName("Rep");
        if(nList!=null && nList.getLength() > 0)
        {
            //Look through all nodes until time is found 
            //Then return that temp
            for(int i=0;i<nList.getLength();i++)
            {
                Element element = (Element)nList.item(i);
                if(Integer.parseInt(element.getTextContent())==time)
                {
                    return Integer.parseInt(element.getAttributes().getNamedItem("T").getNodeValue());
                }
            }
        }
        //Cant find that time in the list
        throw new DataNotFoundException("Cannot find Temp for that time period");
    }

    @Override
    public int getCurrentWindSpeed() throws DataNotFoundException
    {
          if(!init){
            throw new DataNotFoundException();
         }
        NodeList nList = docHourly.getElementsByTagName("Rep");
        if(nList!=null && nList.getLength() > 0)
        {
            //Get First element in list
            //Then return wind speed
            Element element = (Element)nList.item(0);
            return Integer.parseInt(element.getAttributes().getNamedItem("S").getNodeValue());
        }
        //Cant find current wind speed
        throw new DataNotFoundException("Cannot find current Wind Speed");
    }

    @Override
    public String getCurrentWindDirection() throws DataNotFoundException
    {
          if(!init){
            throw new DataNotFoundException();
         }
        NodeList nList = docHourly.getElementsByTagName("Rep");
        if(nList!=null && nList.getLength() > 0)
        {
            //Get First element in list
            //Then return wind direction
            Element element = (Element)nList.item(0);
            return element.getAttributes().getNamedItem("D").getNodeValue();
        }
        //Cant find current wind direction
        throw new DataNotFoundException("Cannot find current Wind Direction");
    }
    @Override
    public int getCurrentHumidity() throws DataNotFoundException
    {
          if(!init){
            throw new DataNotFoundException();
         }
        NodeList nList = docHourly.getElementsByTagName("Rep");
        if(nList!=null && nList.getLength() > 0)
        {
            //Get First element in list
            //Then return weather code
            Element element = (Element)nList.item(0);
            return Integer.parseInt(element.getAttributes().getNamedItem("H").getNodeValue());
        }
        //Cant find current weather in list
        throw new DataNotFoundException("Cannot find current Humidity");
    }

    @Override
    public int getWeatherAtDay(int day) throws DataNotFoundException
    {     
          if(!init){
            throw new DataNotFoundException();
         }
        NodeList nList = docDaily.getElementsByTagName("Period");
        if(nList!=null && nList.getLength() > 0)
        {
            //Find the element using the day int
            Element element = (Element)nList.item(day);
            NodeList dayData = element.getElementsByTagName("Rep");
            return Integer.parseInt(dayData.item(0).getAttributes().getNamedItem("W").getNodeValue());
        }
        //Cant find weather for that day
        throw new DataNotFoundException("Cannot find Weather for day " + day);
    }

    @Override
    public int getHighTempAtDay(int day) throws DataNotFoundException
    {
          if(!init){
            throw new DataNotFoundException();
         }
        NodeList nList = docDaily.getElementsByTagName("Period");
        if(nList!=null && nList.getLength() > 0)
        {
            //Find the element using the day int
            Element element = (Element)nList.item(day);
            NodeList dayData = element.getElementsByTagName("Rep");
            return Integer.parseInt(dayData.item(0).getAttributes().getNamedItem("Dm").getNodeValue());
        }
        //Cant find high temp for that day
        throw new DataNotFoundException("Cannot find High Temp for day " + day);
    }

    @Override
    public int getLowTempAtDay(int day) throws DataNotFoundException
    {
          if(!init){
            throw new DataNotFoundException();
         }
        NodeList nList = docDaily.getElementsByTagName("Period");
        if(nList!=null && nList.getLength() > 0)
        {
            //Find the element using the day int
            Element element = (Element)nList.item(day);
            NodeList dayData = element.getElementsByTagName("Rep");
            return Integer.parseInt(dayData.item(1).getAttributes().getNamedItem("Nm").getNodeValue());
        }
        //Cant find low temp for that day
        throw new DataNotFoundException("Cannot find Low Temp for day " + day);
    }
    
    @Override
    public int getAverageTempAtDay(int day) throws DataNotFoundException
    {
          if(!init){
            throw new DataNotFoundException();
         }
        try
        {
            return (getHighTempAtDay(day)+getLowTempAtDay(day))/2;
        }
        catch(DataNotFoundException exception)
        {
            throw new DataNotFoundException("Cannot find Average Temp for day " + day);
        }
    }
}