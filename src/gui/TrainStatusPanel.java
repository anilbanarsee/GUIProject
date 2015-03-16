/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author User
 */
public class TrainStatusPanel extends javax.swing.JPanel {
    ArrayList<String> lineNames;
    ArrayList<Integer> lineNum;
    ArrayList<Color> lineColor;
    ArrayList<LineStatusBar> lineBars;
              
    private JLabel jLabel1;
    
    
    /**
     * Creates new form TrainStatusPanel
     */
    public TrainStatusPanel() {
        initComponents();
        setLayout(new GridLayout(0,1));
        initInfo();
        initLineBars();
        addBars();
  
    }
    public void test(){
        JOptionPane.showMessageDialog(null,""+lineBars.get(0).getHeight()+"");
    }
    public void addBars(){
        ArrayList<Integer> selected = getSelectedLines();
        for(int i=0; i<lineBars.size(); i++){
            if(selected.contains(i)){
                add(lineBars.get(i));
            }
        }
    }
    public void initLineBars(){
        lineBars = new ArrayList<>();
        LineStatusBar line = null;
        for(int i=0; i<lineNames.size(); i++){
            line = new LineStatusBar();
            line.setText(lineNames.get(i));
            line.setColour(lineColor.get(i));
            lineBars.add(line);
        }
    }
    public void initInfo(){
        lineNames = new ArrayList<>();
        lineColor = new ArrayList<>();
        lineNum = new ArrayList<>();
        
        lineNames.clear();
        lineNames.add("Central");
        lineColor.add(new Color(220,36,31));
        lineNum.add(0);
        
        lineNames.add("Circle");
        lineColor.add(new Color(255,206,0));        
        lineNum.add(0);
        
        lineNames.add("District");
        lineColor.add(new Color(0,114,41));       
        lineNum.add(0);
        
        lineNames.add("Bakerloo");
        lineColor.add(new Color(137,78,36));      
        lineNum.add(0);
        
        lineNames.add("Hammersmith & City");
        lineColor.add(new Color(215,153,175));    
        lineNum.add(0);
        
        lineNames.add("Jubilee");
        lineColor.add(new Color(134,143,152));        
        lineNum.add(0);
        
        lineNames.add("Metropolitan");
        lineColor.add(new Color(117,16,86));        
        lineNum.add(0);
        
        lineNames.add("Northern");
        lineColor.add(new Color(0,0,0));       
        lineNum.add(0);
        
        lineNames.add("Piccadilly");
        lineColor.add(new Color(0,25,168));
        lineNum.add(0);
        
        lineNames.add("Victoria");
        lineColor.add(new Color(0,160,226));       
        lineNum.add(0);
        
        lineNames.add("Waterloo & City");
        lineColor.add(new Color(118,208,189));
        lineNum.add(0);
    }
    public void writeSelectedLines(ArrayList<Integer> list){
        Writer writer = null;
        for(Integer i: list){
          try {
                writer = new BufferedWriter(new OutputStreamWriter(
               new FileOutputStream("lines.txt"), "utf-8"));
               writer.write(i+"\n");
            } catch (IOException ex) {
               System.out.println("Cannot find file");
            } finally {
               try {writer.close();} catch (Exception ex) {}
            }
        }
    }
    public ArrayList<Integer> getSelectedLines(){
        ArrayList<Integer> list = new ArrayList<>();
         BufferedReader br = null; 
         try{
                br = new BufferedReader(new FileReader("lines.txt"));
         }  
         catch(FileNotFoundException e){
                ArrayList<Integer> list1 = new ArrayList<Integer>();
                list1.add(1);
                list1.add(2);
                list1.add(3);
                writeSelectedLines(list1);
                System.out.println("1");
                return getSelectedLines();
                
         }
    try {
       // StringBuilder sb = new StringBuilder();
        String line = br.readLine();

        while (line != null) {
           list.add(Integer.parseInt(line));
           line = br.readLine();
        }
        
    }catch(IOException e){
        e.printStackTrace();
    }
    return list;
    }
    public void clicked(MouseEvent evt){
        System.out.println("Hlllllll");
      int y = evt.getY();
      if(y>30){
          System.out.println("More");
      }
      
    }
    private void initComponents() {

                        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                clicked(evt);
            }
        });
        jLabel1 = new javax.swing.JLabel();

        setLayout(new java.awt.GridLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("London Underground");
        add(jLabel1);
    }                   



            
}
