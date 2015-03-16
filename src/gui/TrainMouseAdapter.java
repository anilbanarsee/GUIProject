/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Reetoo
 */
public class TrainMouseAdapter extends MouseAdapter{
    LineStatusBar bar;
    TrainStatusPanel parent;
    int n;
    public TrainMouseAdapter(LineStatusBar bar, int n, TrainStatusPanel parent){
        this.parent = parent;
        this.bar = bar;
        this.n = n;
    }
    public int getInt(){
        return n;
    }
    @Override
    public void mouseClicked(MouseEvent evt){
        parent.removeBar(bar, n);
    }
    
}
