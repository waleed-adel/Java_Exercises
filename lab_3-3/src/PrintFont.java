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
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;

public class PrintFont extends Applet {
    
    
    public void paint(Graphics g) {
    String[] s = Toolkit.getDefaultToolkit().getFontList();
    int x = 10;
        for (String item : s) {
            Font f = new Font(item, 3, 20);
            g.setFont(f);
            g.drawString(item, 100, x+=50);
        }
    }
}
