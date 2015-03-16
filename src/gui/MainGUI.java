package gui;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author User
 */
public class MainGUI extends javax.swing.JFrame{
    int indexSelected = 0;
    MainPanel mainPanel;
    JLabel companyName;
    boolean fadein = true;
    int alpha;
    Timer timer;
    Timer timer2, timer3;
    BufferedImage img;
    float opacity = 0.1f;
    boolean start = true;
    /**
     * Creates new form MainGUI
     */
    public MainGUI() throws IOException{
        img = ImageIO.read(new File("assets//logo.png"));
        setBackground(new Color(255,255,255,255));
        //startUp();
        
        initComponents();
        setColour(new Color(0,51,204));
        createControlPanel();
        
    }
  

   
    public void playSound(){
        JFXPanel fxPanel = new JFXPanel();
        URL resource = null;
        try {
            resource = new File("assets//start_up.mp3").toURI().toURL();
        } catch (MalformedURLException ex) {
            Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        final Media media = new Media(resource.toString());
         final MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
    }
    public void switchToLandscape(){
        setSize(480,320);
        mainPanel.switchToLandscape();
    }
    public void switchToPortrait(){
        setSize(320,480);
        mainPanel.switchToPortrait();
    }
    public void createControlPanel(){
        ControlPanel a = new ControlPanel(this);
        a.setVisible(true);
    }
    public void setColour(Color c){
        //horizontalLayoutPanel1.setColour(c);
        //verticalLayoutPanel1.setColour(c);
    }
    public void swipeLeft(){
        mainPanel.swipeLeft();
    }
    public void swipeRight(){
        mainPanel.swipeRight();
    }


    public void initComponents(){
        setSize(320,480);
        try {
            mainPanel = new MainPanel();
        } catch (IOException ex) {
            Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        setLayout(new GridLayout());
        add(mainPanel);
    }
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MainGUI().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }


}
