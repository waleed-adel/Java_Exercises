/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DELL
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.applet.Applet;

public class MyButtons extends Applet{
    
    int x;
    Button inc;
    Button dec;
    
    @Override
    public void init (){
       
        inc = new Button ("Increment"); 
        dec = new Button ("Decrement");  
        inc.addActionListener(
         new ActionListener(){
             
             @Override
             public void actionPerformed(ActionEvent ev){
                
                x++;
                repaint();
            } 
         });
        
        dec.addActionListener(
         new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev){
                
                x--;
                repaint();
            } 
         });
        add(inc);
        add(dec);
    }//end of init   

    @Override
    public void paint(Graphics g){
      
        if (x >= 10) 
            x = 10;
        if (x <= 0)
            x = 0;
        g.drawString("Counter: "+x,650,60);
    }
}    