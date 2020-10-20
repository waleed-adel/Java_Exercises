/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DELL
 */

import java.applet.Applet;
import java.awt.*;

public class MyImage extends Applet {
    
    @Override
    public void paint(Graphics g){
        
        Image img;
        img = getImage(getDocumentBase(),"3908.jpg");
        g.drawImage(img, 0, 0, getWidth(),getHeight(), this);
       
    }
    
}
