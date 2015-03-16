/*
 * This is the interface for TravelData
 */
package travelData;
import weatherdata.DataNotFoundException;

/**
 *
 * @author Hamzah
 */
public interface TravelDataInterface
{
    /**
     * This class will probably evolve a bit as the GUI is worked on
     * For now, i will have an interface that can get the status of all lines
     */
    
    /**
     * Line number codes are as follows
     * Bakerloo - 1
     * Central - 2
     * Victoria - 3
     * Jubilee - 4
     * Northern - 5
     * Piccadilly - 6
     * Circle - 7
     * HammerSmith and City - 8
     * District - 9
     * Metropolitan - 11
     * Waterloo and City - 12
     * DLR - 81
     * Overground - 82
     */
    
    /**
     * This method will return a status code for a specific line
     * the status codes are 
     * GS - Good service
     * MD - Minor Delays
     * SD - Severe Delays
     * NS - No step free access
     * I dont know about the other ones
     * @param lineNumber
     * @return 
     * @throws weatherapp.DataNotFoundException 
     */
    public String getStatusOfLine(int lineNumber) throws DataNotFoundException;
    
    public String getDisruptionDescOfLine(int lineNumber) throws DataNotFoundException;
    
}
