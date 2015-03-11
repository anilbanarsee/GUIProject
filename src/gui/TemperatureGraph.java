/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Color;
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
    int Ytop = 20;  // The y-value entries can be up to 250-100=150.
    int Ybottom = 200;

    int totalX, totalY;

    ArrayList<Integer> temps = new ArrayList<>();

    public TemperatureGraph()
    {
        setOpaque(false);
    }

    public void setGraph(ArrayList<Integer> temps)
    {
        this.temps = temps;
        totalX = Xright - Xleft + 1;
        totalY = Ybottom - Ytop + 1;
        setSize(500, 500);
        this.setVisible(true);
    }

    @Override
    public void paint(Graphics g)
    {
        super.paintComponent(g);
        //Painting graph goes here
        g.setColor(Color.blue);
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

        drawAxes(g,largestNumber,smallestNumber);
        int i, x1, y1, x2, y2, xIncrement, yIncrement;
        //Compute the x and y increments
        xIncrement = totalX / 5;
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
            g.fillOval(x2, y2, 5, 5);
            g.drawLine(x1, y1, x2, y2);
            x1 = x2;
            y1 = y2;
        }
      //Label x - axes with grade choices
        //Not being used
//      String [ ] label = {"A", "B", "C", "D", "F"};
//      for (i=1; i<=5; i++)
//          g.drawString(label[i-1], 100+ i*xIncrement, 270);

        //Label y - axes with quantity of each grade
        int topy;
        int bottomy = 0;
        if (largestNumber % 10 == 0)
        {
            topy = largestNumber;
        }
        else
        {
            topy = (largestNumber / 10 + 1) * 10;
        }
        if(smallestNumber<0)
        {
            //Label y - axes with quantity of each grade
            if (-smallestNumber % 10 == 0)
            {
                bottomy = -smallestNumber;
            }
            else
            {
                bottomy =(-smallestNumber / 10 + 1) * 10;
            }
        }
        
        // i = i+5 controls y value label -- adjust for size of data
        for (i = 0; i <= topy; i = i + 5)
        {
            g.drawString(String.valueOf(i), 5, Ybottom - i * yIncrement + 5);
        }
        if(smallestNumber<0)
        {
            for (i = 5; i <= bottomy; i = i + 5)
            {
                g.drawString("-"+String.valueOf(i), 5, Ybottom + i * yIncrement + 5);
            }
        }
    }

    public void drawAxes(Graphics g,int largest,int smallest)
    {
        //Need to figure out how big to draw axis
        if(smallest<0)
        {
            g.drawLine(Xleft, Ytop, Xleft, Ybottom-smallest*10);
            g.drawLine(Xleft, Ybottom, Xright, Ybottom);
        }
        else
        {
            g.drawLine(Xleft, Ytop, Xleft, Ybottom);
            g.drawLine(Xleft, Ybottom, Xright, Ybottom);   
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
