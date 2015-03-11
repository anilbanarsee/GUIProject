/**
 * A simple temperature graph to show 9 temperatures
 */
package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author Hamzah
 */
public class TemperatureGraph extends javax.swing.JPanel {

    //Establish variables for this program

    int Xleft = 25;
    int Xright = 300;
    int Ytop = 20;  
    int Ybottom = 300;
    //These values are defualts
    public Color graphColor = Color.WHITE;

    int totalX, totalY;

    //These are the data arrays
    ArrayList<Integer> temps = new ArrayList<>();
    ArrayList<String> tempsTimes = new ArrayList<>();

    public TemperatureGraph()
    {
        setOpaque(false);
    }

    public void setGraph(ArrayList<Integer> temps,ArrayList<String> tempsTimes,Dimension d)
    {
        this.temps = temps;
        this.tempsTimes = tempsTimes;
        Xright = d.width-25;
        Ybottom = d.height-20;
        //Give some breathing room at bottom and right
        totalX = Xright - Xleft;
        totalY = Ybottom - Ytop;
        setSize(d.width,d.height);
        this.setVisible(true);
    }

    @Override
    public void paint(Graphics g)
    {
        super.paintComponent(g);
        //Painting graph goes here
        g.setColor(graphColor);
        drawLineGraph(g);
        g.drawString("Temperature", 170, 290); // title
    }

    //Draw the line graph
    public void drawLineGraph(Graphics g)
    {
        //Find Largest and smallest numbers
        int largestNumber, smallestNumber;
        largestNumber = findLargest(temps);
        smallestNumber = findSmallest(temps);

        if(largestNumber>0)
        {
            if(smallestNumber<0)
            {
                //Here we need to draw a negative and positive graph
                drawAxes(g,2,largestNumber,smallestNumber);
                drawBothGraph(g,smallestNumber,largestNumber);
            }
            else
            {
                //Here we draw a positive graph
                drawAxes(g,1,largestNumber,smallestNumber);
                drawNormalGraph(g,smallestNumber,largestNumber);
            }
        }
        else
        {
            //here we draw a negative graph
            drawAxes(g,1,largestNumber,smallestNumber);
            drawNormalGraph(g,smallestNumber,largestNumber);
        }

        
    }

    /**
     * This graph method will be used when i have both a postitive and negative axis
     * @param g
     * @param smallestNumber
     * @param largestNumber 
     */
    public void drawBothGraph(Graphics g,int smallestNumber,int largestNumber)
    {
        int i, x1, y1, x2, y2, xIncrement, yIncrement;
        xIncrement = totalX / temps.size();
        yIncrement = totalY/(-smallestNumber+largestNumber);
        float middleLower = ((float)smallestNumber/((float)largestNumber-(float)smallestNumber))*(float)Ybottom; //Space between middle and bottom
        float middleUpper = ((float)largestNumber/((float)largestNumber-(float)smallestNumber))*(float)Ybottom;  //space between top and middle
        
        
        //Set the start point as the first temperature point
        x1 = getXCoordinate(1,xIncrement);
        y1 = getYCoordinate(temps.get(0),yIncrement);
        
        //Compute and plot the data points
        for (i = 0; i < temps.size(); i++)
        {
            if (temps.get(i) == null)
            {
                continue;
            }
            x2 = getXCoordinate(i + 1, xIncrement);
            if(temps.get(i)>0)
            {
                y2 = getYCoordinate(temps.get(i), yIncrement);
                g.drawString(Integer.toString(temps.get(i)), x2, y2);
                g.fillOval(x2, y2, 5, 5);
                g.drawLine(x1, y1, x2, y2);
            }
            else
            {
                y2 = getYCoordinateWithMiddle(temps.get(i), yIncrement,(int)middleUpper);
                g.drawString(Integer.toString(temps.get(i)), x2, y2);
                g.fillOval(x2, y2, 5, 5);
                g.drawLine(x1, y1, x2, y2);
            }
            x1 = x2;
            y1 = y2;
        }
    }
    
    public void drawNormalGraph(Graphics g,int smallestNumber,int largestNumber)
    {
        int i, x1, y1, x2, y2, xIncrement, yIncrement;
        //Compute the x and y increments
        xIncrement = totalX / 8;
        if (largestNumber == 0)
        {
            yIncrement = 0;
        }
        else
        {
            yIncrement = totalY / largestNumber;
        }

        //Set the initial origin point
        x1 = getXCoordinate(1, xIncrement);
        y1 = getYCoordinate(temps.get(0), yIncrement);

        //Compute and plot the data points
        for (i = 0; i < temps.size(); i++)
        {
            if (temps.get(i) == null)
            {
                continue;
            }
            x2 = getXCoordinate(i + 1, xIncrement);
            y2 = getYCoordinate(temps.get(i), yIncrement);
            g.drawString(Integer.toString(temps.get(i)), x2, y2-10);
            g.fillOval(x2, y2, 5, 5);
            g.drawLine(x1, y1, x2, y2);
            x1 = x2;
            y1 = y2;
        }
    }
    
    
    public void drawAxes(Graphics g,int caseNumber,int largest,int smallest)
    {
        switch(caseNumber)
        {
            case 1:
                //Just draw positive axes
                g.drawLine(Xleft, Ytop, Xleft, Ybottom);
                g.drawLine(Xleft, Ybottom, Xright, Ybottom);   
                break;
            case 2:
                //Draw negative and positive, using a ratio between the highest and lowest numbers
                g.drawLine(Xleft, Ytop, Xleft, Ybottom);
                float middle = ((float)largest/((float)largest-(float)smallest))*(float)Ybottom;
                g.drawLine(Xleft, (int)middle, Xright, (int)middle);
                break;
        }
    }

    //Determining x coordinate
    public int getXCoordinate(int i, int xIncrement)
    {
        return Xleft + xIncrement * i;
    }

    //Determining y coordinate
    public int getYCoordinate(int temp, int yIncrement)
    {
        return Ybottom - yIncrement * temp;
    }
    
    //Determining y coordinate with a middle
    public int getYCoordinateWithMiddle(int temp, int yIncrement,int middle)
    {
        return (Ybottom - middle) - yIncrement * temp;
    }
    //Finding the largest value in the array
    public int findLargest(ArrayList<Integer> a)
    {
        int location = 0;
        for (int i = 1; i < a.size(); i++)
        {
            if (a.get(i) == null)
            {
                continue;
            }
            if (a.get(i) > a.get(location))
            {
                location = i;
            }
        }
        return a.get(location);
    }

    //Finding the smallest value in the array
    public int findSmallest(ArrayList<Integer> a)
    {
        int location = 0;
        for (int i = 1; i < a.size(); i++)
        {
            if (a.get(i) == null)
            {
                continue;
            }
            if (a.get(i) < a.get(location))
            {
                location = i;
            }
        }
        return a.get(location);
    }
}
