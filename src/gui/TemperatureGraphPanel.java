/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import gui.handler.GUIHandler;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;

/**
 *
 * @author Reetoo
 */
public class TemperatureGraphPanel extends javax.swing.JPanel {
    TemperatureGraph temperatureGraph;
    ArrayList<String> times;
    ArrayList<Integer> data;
    /**
     * Creates new form TemperatureGraphPanel
     */
    public TemperatureGraphPanel() {
        initComponents();
        initTimes();
        initGraph();
        initData();
       setBackground(new Color(116,159,171,0));
      //  setOpaque(false);
    }
    public TemperatureGraph getGraph(){
        return temperatureGraph;
    }
    public void resizeGraph(){
      
      temperatureGraph.setGraph(data,times,new Dimension(getWidth(),100));
      
    }
     @Override
    public boolean isOpaque(){
        return true;
    }
    public void initGraph(){
        
        temperatureGraph = new TemperatureGraph();
        ArrayList<Integer> temps = new ArrayList<>();
        temps.add(0);
        temps.add(0);
        temps.add(0);
        temps.add(0);
        temps.add(0);
        temps.add(0);
        temps.add(0);
        temps.add(0);
        temperatureGraph.setGraph(temps,times,new Dimension(320,300));
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0.1;
        c.weighty = 0.1;
        c.insets = new Insets(0,0,0,0);
       // c.anchor = GridBagConstraints.SOUTH;
        add(temperatureGraph,c);
    }
    public void initData(){
        data = GUIHandler.getTodayTemperatures();
        temperatureGraph.setGraph(data,times,new Dimension(320,100));
        
    }
    public void initTimes(){
        times = new ArrayList<String>();
        times.clear();
        times.add("0");
        times.add("180");
        times.add("360");
        times.add("540");
        times.add("720");
        times.add("900");
        times.add("1080");
        times.add("1260");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(51, 51, 51));
        setLayout(new java.awt.GridBagLayout());
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
