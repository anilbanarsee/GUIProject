package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

/**
 *
 * @author Hamzah
 */
public class ChooseLineFrame extends JFrame {
    
    TrainStatusPanel trainStatusPanel;
    
    
    /**
     * I make a comboBox
     * central
     * circle
     * district
     * bakerloo
     * hammersmith and city
     * piccidilly
     * metropolitan
     * northern
     * victoria
     */
    public ChooseLineFrame(TrainStatusPanel trainStatus)
    {
        trainStatusPanel = trainStatus;
        initComponents();
        setSize(200,200);
        pack();
        this.setVisible(true);
        setLayout(new GridLayout(0,1));
    }
    
    //init the combobox
    public void initComponents()
    {
        JComboBox lineBox = new JComboBox();
        
        //Adding the stations
        lineBox.addItem("Central");
        lineBox.addItem("Circle");
        lineBox.addItem("District");
        lineBox.addItem("Bakerloo");
        lineBox.addItem("Hammersmith & City");
        lineBox.addItem("Piccdilly");
        lineBox.addItem("Metropolitan");
        lineBox.addItem("Northern");
        lineBox.addItem("Victoria");
        
        
        JButton selectLineButton = new JButton("Select Line");
        
        selectLineButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             chooseLine((String) lineBox.getSelectedItem());
             dispose();
             trainStatusPanel.getParent().repaint();
             
         }});
        add(lineBox);
        add(selectLineButton);
    }
    
    public void chooseLine(String obj)
    {
        trainStatusPanel.addBar(trainStatusPanel.getLine(obj));
        
    }
}
