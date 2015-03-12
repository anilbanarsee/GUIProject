/**
 * A simple temperature graph to show 9 temperatures
 */
package gui;

import gui.handler.GUIHandler;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 *
 * @author Hamzah
 */
public class TemperatureGraph extends javax.swing.JPanel {

    //Establish variables for this program

    int Xleft = 0;
    int Xright = 300;
    int Ytop = 30;  
    int Ybottom = 300;
    //These values are defualts
    public Color graphColor = Color.WHITE;

    int totalX, totalY;

    //These are the data arrays
    ArrayList<Integer> temps = new ArrayList<>();
    ArrayList<String> tempsTimes = new ArrayList<>();

    public TemperatureGraph()
    {
        setBackground(Color.BLACK);
        
    }
     @Override
    public boolean isOpaque(){
        return false;
    }
    public void setGraph(ArrayList<Integer> temps,ArrayList<String> tempsTimes,Dimension d)
    {
        this.temps = temps;
        this.tempsTimes = tempsTimes;
        Xright = d.width-0;
        Ybottom = d.height-10;
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
    }

    //Draw the line graph
    public void drawLineGraph(Graphics g)
    {


        drawAxes(g);
        drawNormalGraph(g);
    }
    
    public void drawNormalGraph(Graphics g)
    {
        //Find Largest and smallest numbers
        int largestNumber, smallestNumber;
        largestNumber = findLargest(temps);
        smallestNumber = findSmallest(temps);
        
        
        float xIncrement, yIncrement;
        int i,x1,y1,x2,y2;
        //Compute the x and y increments
        xIncrement = totalX / 8;
        if(largestNumber==smallestNumber)
        {
            yIncrement=0;
        }
        else
        {
            yIncrement = totalY / (largestNumber-smallestNumber);
        }

        //Set the initial origin point
        x1 = (int)getXCoordinate(1, 0);
        y1 = (int)getYCoordinate(Math.abs(temps.get(0)), 0,smallestNumber);

        //Compute and plot the data points
        for (i = 0; i < temps.size(); i++)
        {
            if (temps.get(i) == null)
            {
                continue;
            }
            x2 = (int)getXCoordinate(i + 1, xIncrement);
            y2 = (int)getYCoordinate((float)temps.get(i), yIncrement,smallestNumber);
           
            Graphics2D g2 = (Graphics2D) g;
            g2.setStroke(new BasicStroke(3));
              g2.setColor(graphColor);
            g2.drawLine(x1, y1, x2, y2);
            
               g2.setColor(GUIHandler.getColorForTemp(temps.get(i)));
            g2.setFont(new Font("Arial",1,12));
            g2.drawString(Integer.toString(temps.get(i)),(int)x2-7,(int) y2-10);
           // g2.fillOval(x2, y2, 5, 5);
            x1 = x2;
            y1 = y2;
        }
    }
    
    
    public void drawAxes(Graphics g)
    {
        //Just draw positive axes
        //g.drawLine(Xleft, Ybottom, Xright, Ybottom);   
    }

    //Determining x coordinate
    public float getXCoordinate(float i, float xIncrement)
    {
        return Xleft + xIncrement * i;
    }

    //Determining y coordinate
    public float getYCoordinate(float temp, float yIncrement,float smallestNumber)
    {
        return Ybottom - yIncrement * (temp-smallestNumber) ;
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
