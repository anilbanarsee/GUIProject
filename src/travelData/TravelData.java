/**
 * This class will be used to handle the data from the TFL
 * It will use the travelDataInterface
 */
package travelData;

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
import weatherdata.DataNotFoundException;

/**
 *
 * @author Hamzah
 */
public class TravelData implements TravelDataInterface
{
    Document docTravel;
    public TravelData()
    {
        try
        {
            URL travelData = new URL("http://cloud.tfl.gov.uk/TrackerNet/LineStatus");
            //Now ive got the data for both daily and hourly weather for london
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            docTravel = dBuilder.parse(travelData.openConnection().getInputStream());
            docTravel.getDocumentElement().normalize();
        }
        catch (SAXException | IOException | ParserConfigurationException ex)
        {
            Logger.getLogger(TravelData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public String getStatusOfLine(int lineNumber) throws DataNotFoundException
    {
        NodeList nList = docTravel.getElementsByTagName("LineStatus");
        for(int i=0;i<nList.getLength();i++)
        {
            Element lineStatusElement = (Element)nList.item(i);
            NodeList lineList = lineStatusElement.getElementsByTagName("Line");
            
            Element lineElement = (Element)lineList.item(i);
            System.out.println(lineElement.getAttributes().getNamedItem("ID"));
            if(Integer.parseInt(lineElement.getAttributes().getNamedItem("ID").getNodeValue())==lineNumber)
            {
                NodeList StatusList = lineStatusElement.getElementsByTagName("Status");
                Element statusElement=(Element)StatusList.item(0);
                return statusElement.getAttributes().getNamedItem("Description").getNodeValue();
            }
        }
        //Cant find that line number of status for that line
        throw new DataNotFoundException("Cannot get status of that line number");
    }

    @Override
    public String getDisruptionDescOfLine(int lineNumber) throws DataNotFoundException
    {
        NodeList nList = docTravel.getElementsByTagName("LineStatus");
        for(int i=0;i<nList.getLength();i++)
        {
            Element lineStatusElement = (Element)nList.item(i);
            NodeList lineList = lineStatusElement.getElementsByTagName("Line");
            
            Element lineElement = (Element)lineList.item(i);
            System.out.println(lineElement.getAttributes().getNamedItem("ID"));
            if(Integer.parseInt(lineElement.getAttributes().getNamedItem("ID").getNodeValue())==lineNumber)
            {
                NodeList StatusList = lineStatusElement.getElementsByTagName("Status");
                Element statusElement=(Element)StatusList.item(0);
                if(!statusElement.getAttributes().getNamedItem("Description").getNodeValue().equals("Good Service"))
                {
                    return lineStatusElement.getAttributes().getNamedItem("StatusDetails").getNodeValue();
                }
                else
                {
                    throw new DataNotFoundException("This line has a good service, it does not have any problems");
                }
            }
        }
        throw new DataNotFoundException("Cannot get a description of a problem on that line number");
    }
    
}
