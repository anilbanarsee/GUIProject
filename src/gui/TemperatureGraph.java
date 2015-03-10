/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherapp;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Hamzah
 */
public class TemperatureGraph extends javax.swing.JPanel
{
   //Establish variables for this program
   int Xleft = 100;
   int Xright = 300;
   int Ytop = 100;  // The y-value entries can be up to 250-100=150.
   int Ybottom = 250;

   int totalX, totalY;
    
    
    
    int[] temps = new int[5];
    public TemperatureGraph(int firstTemp,int secondTemp,int thirdTemp,int fourthTemp,int fifthTemp)
    {
        temps[0] = firstTemp;
        temps[1] = secondTemp;
        temps[2] = thirdTemp;
        temps[3] = fourthTemp;
        temps[4] = fifthTemp;
        totalX = Xright - Xleft + 1;
        totalY = Ybottom - Ytop + 1;
        setSize(500,500);
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
        drawAxes(g);
        int i, x1, y1, x2, y2, largestNumber, xIncrement, yIncrement;
       //Compute the x and y increments
       largestNumber = findLargest (temps);
       xIncrement = totalX / 5;
       if (largestNumber ==0)
               yIncrement = 0;
       else
               yIncrement = totalY / largestNumber;

      //Set the initial origin point
       x1 = getXCoordinate(1, xIncrement);
       y1 = getYCoordinate(temps[0], yIncrement);

      //Compute and plot the data points
       for(i=0; i < 5; i++)
      {
          x2 = getXCoordinate(i+1, xIncrement);
          y2 = getYCoordinate(temps[i], yIncrement);
          g.fillOval(x2, y2, 5, 5);
          g.drawLine(x1, y1, x2, y2);
          x1 = x2;
          y1 = y2;
       }
      //Label x - axes with grade choices
      String [ ] label = {"A", "B", "C", "D", "F"};
      for (i=1; i<=5; i++)
          g.drawString(label[i-1], 100+ i*xIncrement, 270);

      //Label y - axes with quantity of each grade
      int topy;
      if(largestNumber%10==0)
           topy=largestNumber;
      else
           topy = (largestNumber/10+1)*10;
      
      // i = i+5 controls y value label -- adjust for size of data
      for (i = 0; i <= topy; i = i+5) 
      {
        g.drawString(String.valueOf(i), 70, Ybottom-i*yIncrement+5);
      }
   }
   
   public void drawAxes (Graphics g)
   {
        g.drawLine(Xleft, Ytop, Xleft, Ybottom);
        g.drawLine(Xleft, Ybottom, Xright, Ybottom);
   }
   
   //Determining x coordinate
   public int getXCoordinate(int i, int xIncrement)
   {
       return Xleft + xIncrement *i;
   }

   //Determining y coordinate
   public int getYCoordinate(int numStudents, int yIncrement)
   {
       return Ybottom - yIncrement * numStudents;
   }

   //Finding the largest value in the array
   public int findLargest(int [ ] a)
   {
       int location = 0;
      for( int i = 1; i < a.length; i++)
                 if(a[i] > a[location])
                       location = i;
     return a[location];
   }
   
}
