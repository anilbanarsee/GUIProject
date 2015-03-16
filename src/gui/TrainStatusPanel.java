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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import weatherdata.DataNotFoundException;

/**
 *
 * @author User
 */
public class TrainStatusPanel extends javax.swing.JPanel {
    ArrayList<String> lineNames;
    ArrayList<Integer> lineNum;
    ArrayList<Color> lineColor;
    travelData.TravelData travelData;
    ArrayList<LineStatusBar> lineBars;
    private JLabel jLabel1;
    private JButton addButton;
    boolean selecting = false;
    TravelPanel parent;
    
    /**
     * Creates new form TrainStatusPanel
     */
    public TrainStatusPanel(TravelPanel parent) {
         travelData  = new travelData.TravelData();
        this.parent = parent;
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
    public void addBar(LineStatusBar bar, int n){
        remove(addButton);
        remove(bar);
        ArrayList<Integer> selected = getSelectedLines();
        System.out.println(selected);
        selected.add(n);
        try {
            writeSelectedLines(selected);
        } catch (IOException ex) {
            Logger.getLogger(TrainStatusPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        add(bar);
        add(addButton);
    }
    public void removeBar(LineStatusBar bar, int n){
       
        remove(bar);
         ArrayList<Integer> selected = getSelectedLines();
         selected.remove(new Integer(n));
         System.out.println(selected);
        try {
            writeSelectedLines(selected);
        } catch (IOException ex) {
            Logger.getLogger(TrainStatusPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        
    }
    public void initLineBars(){
                lineBars = new ArrayList<>();
        LineStatusBar line = null;
        for(int i=0; i<lineNames.size(); i++){
            try
            {
                line = new LineStatusBar();
                
                line.addMouseListener(new TrainMouseAdapter(line, i, this));
                line.setText(lineNames.get(i));
                
                switch(lineNames.get(i))
                {
                    case "Central":
                        line.setService(travelData.getStatusOfLine(2));
                        break;
                    case "Circle":
                        line.setService(travelData.getStatusOfLine(7));
                        break;
                    case "District":
                        line.setService(travelData.getStatusOfLine(9));
                        break;
                    case "Bakerloo":
                        line.setService(travelData.getStatusOfLine(1));
                        break;
                    case "Hammersmith and City":
                        line.setService(travelData.getStatusOfLine(8));
                        break;
                    case "Jubilee":
                        line.setService(travelData.getStatusOfLine(4));
                        break;
                    case "Metropolitan":
                        line.setService(travelData.getStatusOfLine(11));
                        break;
                    case "Northern":
                        line.setService(travelData.getStatusOfLine(5));
                        break;
                    case "Piccadilly":
                        line.setService(travelData.getStatusOfLine(6));
                        break;
                    case "Victoria":
                        line.setService(travelData.getStatusOfLine(3));
                        break;
                    case "Waterloo & City":
                        line.setService(travelData.getStatusOfLine(12));
                        break;
                }
                line.setColour(lineColor.get(i));
                lineBars.add(line);
            }
            catch (DataNotFoundException ex)
            {
                line.setService("No Data Available");
            }
        }
    }
    public LineStatusBar getLine(String s){
        int x = 0;
        for(int i=0; i<lineNames.size(); i++){
            x = i;
            if(lineNames.get(i).equals(s)){
                break;
            }
        }
        return lineBars.get(x);
    }
  public int getLineNum(String s){
        
        for(int i=0; i<lineNames.size(); i++){
           
            if(lineNames.get(i).equals(s)){
                return i;
            }
        }
        return 0;
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
    public void writeSelectedLines(ArrayList<Integer> list) throws IOException{
       PrintWriter writer = new PrintWriter("lines.txt", "UTF-8");
       for(Integer i: list){
           writer.println(i+"");
       }
        writer.close();
    }
    public void endSelectBar(){
        selecting = false;
        parent.parent.setTravelPanel();
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
            try {
                writeSelectedLines(list1);
            } catch (IOException ex) {
                Logger.getLogger(TrainStatusPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
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
    public void clicked(MouseEvent evt, int n){
        System.out.println(evt.getY());
      int y = evt.getY();
      if(y>30){
          System.out.println("More");
      }
      
    }
    public void addButtonPressed(){
        if(selecting){
            return;
        }
        selecting = true;
        getParent().getParent().add(new ChooseLineFrame(this));
    }
    private void initComponents() {

        addButton = new JButton();
        addButton.setText("Add Line");
        addButton.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               addButtonPressed();
           } 
        });
        jLabel1 = new javax.swing.JLabel();

        setLayout(new java.awt.GridLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("London Underground");
        add(jLabel1);
       
        add(addButton);
    }                   



            
}
