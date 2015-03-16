package gui;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Anil
 */
public class MainPanel extends javax.swing.JPanel {
    private gui.ContentPane content;
    private gui.TopBar topBar1;
    boolean moving = false;
    boolean start = true;
    int indexSelected = 0;
    int backgroundPosX = 0;
    int backgroundPosY = 0;
    Timer timer1, timer2;
    boolean portrait = true;
    boolean fadein = true;
    //float alpha = 0.0f;
    float opacity = 0.0f;
    int x = 0;
    BufferedImage logo;
    Timer timer;
    Image img;

   
    public MainPanel() throws IOException {
        loadComponents();
         logo = ImageIO.read(new File("assets//logo.png"));
         img = chooseRandomBackground();
       // initComponents();
         startUp();
         
        this.setBackground(Color.WHITE);
    }
    public void loadComponents(){
         content = new gui.ContentPane();
        topBar1 = new gui.TopBar(content);
    }
    private Image chooseRandomBackground()
    {
        Random rand = new Random();
        int backgroundNo = rand.nextInt(5);
        System.out.println(backgroundNo);
        return Toolkit.getDefaultToolkit().createImage("assets//background" +Integer.toString(backgroundNo)+".jpg");
    }
    
    public void switchToPortrait(){
        if(portrait){
            return;           
        }
        portrait = true;
        content.setPortrait();
    }
        public void switchToLandscape(){
            
        if(!portrait){
            return;           
        }
        portrait = false;
        
        content.setLandscape();
    }
        
    public void swipeLeft(){
        
        indexSelected--;
        if(indexSelected<0){
            indexSelected = 2;
        }
         System.out.println("C:"+indexSelected);
        if(indexSelected==0){
            
            content.setCurrentWeatherPanel();
            moveBackground(0,10000);
            
            revalidate();
            repaint();
            
        }
        if(indexSelected==1){
            
            
            moveBackground(-320,10000);
            content.setFutureWeatherPanel();
            
          
            revalidate();
            repaint();
        }
        if(indexSelected==2){
            content.setTravelPanel();
            moveBackground(-640,10000);
           revalidate();
            repaint();
        }
    }
    public void swipeRight(){
        
        indexSelected++;
        if(indexSelected>2){
            indexSelected = 0;
        }
        System.out.println("D:"+indexSelected);
        if(indexSelected==0){
            content.setCurrentWeatherPanel();
             moveBackground(0,10000);
           repaint();
        }
        if(indexSelected==1){
            content.setFutureWeatherPanel();
             moveBackground(-320,10000);
           repaint();
        }
        if(indexSelected==2){
            content.setTravelPanel();
            moveBackground(-640,10000);
           repaint();
        }
    }
     public void startUp(){
        setSize(320,480);
        
       // companyName = new JLabel();
       // companyName.setText("TEMPEST");
       // companyName.setIcon(new ImageIcon(img));
       // companyName.setFont(new Font("Arial",1,18));
       // add(companyName);
 //jLabel1.setForeground(new Color(0,0,0,0));
        //alpha = 0;
      //  playSound();
       timer = new Timer(5, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
               
               //alpha += 5;
               if(fadein){
                   opacity += 0.008f;
               }
               else{
                   opacity -= 0.01f;
                  // System.out.println("hello");
               }
               
               if(opacity>=1.0f){
                   opacity = 1.0f;
                   fadein = false;
               }
               if(opacity<0.0f){
                   opacity = 0.0f;
                   //System.out.println("Hello");
                   start = false;
                   timer.stop();
                   timer2.start();
               }
               
               //System.out.println(opacity);
               //System.out.println(alpha);
               //companyName.setForeground(new Color(0,0,0,alpha));
               
               repaint();
              // System.out.println("1");   
                    
                
                
            }
        }
        );
         timer.setInitialDelay(0);
            timer.start(); 
        timer2 = new Timer(10, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                start = false;
                
                initComponents();

                
                
                
                // setSize(320,480);
                 revalidate();
                 repaint();
                 
                 //switchToLandscape();
                 //switchToPortrait();
                 // swipeRight();
                // swipeLeft();
            }
        });
        timer2.setInitialDelay(0);
        timer2.setRepeats(false);
        
        Timer timer3 = new Timer(100, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                revalidate();
                repaint();

                 //switchToLandscape();
                 //switchToPortrait();
                 // swipeRight();
                // swipeLeft();
            }
        });

        //timer3.setRepeats(false);
        timer3.setInitialDelay(100);
        timer3.start();
        //timer2.start();
    }
    @Override
    public void paintComponent(Graphics g){
        
        super.paintComponent(g);
        if(start){
           // System.out.println("test");
            //System.out.println("Hello");
        //super.paintComponents(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity));
        g2.drawImage(logo,19,107,null);
        //g2.dispose();
        
        }
        else{
            
       
        //System.out.println("Hello");
        g.drawImage(img,backgroundPosX,backgroundPosY,null);
        
        }
        
    }
    public void moveBackground(int n, int time){
        if(!moving){
            moving = true;
       int i = n-backgroundPosX;
        if(i>0){
       x = 0;
       System.out.println("POSITIVE");
       //System.out.println(backgroundPosX);
      // System.out.println(backgroundPosY);
       
        timer = new Timer(5, new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                   x++;
                   if(backgroundPosX + x>n){
                       backgroundPosX = n;
                   }
                   else{
                       backgroundPosX+=x;
                   }
                   repaint();
                   if(backgroundPosX==n){
                       timer.stop();
                       moving=false;
                   }
                   
                }
            }
            );
         timer.setInitialDelay(10);
            timer.start(); 
        }
        if(i<0){
            System.out.println("NEGATIVE");
             x = 0;
            System.out.println(backgroundPosX);
            System.out.println(backgroundPosY);
       
             timer = new Timer(7, new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                   backgroundPosX-=x;
                   x++;
                   if(backgroundPosX-x<n){
                       x = backgroundPosX-n;
                   }
                   if(backgroundPosX==n){
                       timer.stop();
                       moving = false;
                   }
                   repaint();
                }
            }
            );
         timer.setInitialDelay(10);
            timer.start(); 
        }
    }
    }
                      
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

       

        setLayout(new java.awt.GridBagLayout());

      
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 353;
        gridBagConstraints.ipady = 455;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(content, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 374;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(topBar1, gridBagConstraints);
    }                      

                                


    // Variables declaration - do not modify                     

    // End of variables declaration                   
}
