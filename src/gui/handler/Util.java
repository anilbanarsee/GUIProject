/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.handler;

import java.awt.AlphaComposite;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.ImageProducer;
import java.awt.image.RGBImageFilter;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import javax.swing.ImageIcon;

/**
 *
 * @author User
 */
public class Util {
    
    // Takes a file path and returns a scaled version of it.
    // Credit to http://stackoverflow.com/questions/7252983/resizing-image-java-getscaledinstance
     public static BufferedImage scaleImage(int WIDTH, int HEIGHT, String filename) {
        BufferedImage bi = null;
        try {
            ImageIcon ii = new ImageIcon(filename);//path to image
            bi = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d = (Graphics2D) bi.createGraphics();
            g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
            g2d.drawImage(ii.getImage(), 0, 0, WIDTH, HEIGHT, null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return bi;
    }
    public static BufferedImage makeTransparent(BufferedImage img){
        BufferedImage tempImage = new BufferedImage(img.getWidth(),img.getHeight(),BufferedImage.TYPE_INT_ARGB);
        Graphics2D G2D = (Graphics2D) tempImage.getGraphics();
        G2D.setComposite(AlphaComposite.SrcOver.derive(0.5f));
        return tempImage;
    }
    public static Image makeWhiteTransparent(BufferedImage image){
        ImageFilter filter = new RGBImageFilter(){
            public int markerRGB = 0xFFFFFFFF;
            public final int filterRGB(int x, int y, int rgb){
                if((rgb|0xFF000000)==markerRGB){
                    return 0x00FFFFFF & rgb;
                }
                return rgb;
            }
        };
        ImageProducer ip = new FilteredImageSource(image.getSource(),filter);
        return Toolkit.getDefaultToolkit().createImage(ip);
    }
    public static Font getFont(String filepath, int size){
        Font newFont = null;
        try{
            newFont = Font.createFont(Font.TRUETYPE_FONT, new File(filepath)).deriveFont(12f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File(filepath)));
           // return newFont;
        }
        catch(IOException e){
            e.printStackTrace();
           // System.exit(0);
        }
        catch(FontFormatException e){
            System.out.println("FONTFORMATEXCEPTION");
          //  System.exit(0);
        }
        float fsize = size;
        newFont = newFont.deriveFont(fsize);
        return newFont;
    
    }
    public static Font getWeatherFont(int size){
        return getFont("assets\\Font\\weather_font.ttf",size);
        //return new Font("Arial",0,12);
    }
    public static String[] getNextDays(int n){
        String[] days = {"Sunday  ","Monday  ","Tuesday ","Wednesday","Thursday","Friday  ","Saturday"};
        int day = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
        //System.out.println(day+"GG");
        int x = 1;
        day++;
        String[] nextDays = new String[4];
        nextDays[0] = "Tommorow";
        while(x<4){
            day++;
            if(day>7){
                System.out.println("Test");
                day=1;
            }
            System.out.println(day);
            nextDays[x]=days[day-1];
            x++;
        }
        return nextDays;
    }

}
