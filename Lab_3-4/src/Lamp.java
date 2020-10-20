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

public class Lamp extends Applet{
    
    @Override
    public void paint(Graphics g) {
    
    g.drawRect(550,500,240,15);
    g.drawLine(620, 500, 650, 400);
    g.drawLine(730, 500, 700, 400);
    /*angular start (0 represents 3 o'clock position and 6 represents 9 o'clock position
      arc angle (+ve value for CW direction and -ve value for CCW direction)
      arc angle (360 for drawing full ellipse,180 for a half elleptic motion, 90 for quarter elliptic motion,etc..)
    */
    g.drawArc(470,310,390,90,6,-180); 
    g.drawLine(470, 357, 515, 100);
    g.drawLine(860, 355, 815, 100);
    g.drawOval(515, 75, 300, 50);
    g.setColor(Color.yellow);
    g.fillOval(516, 76, 299, 49);
    g.setColor(Color.black);
    g.drawOval(505, 220, 50, 85);
    g.setColor(Color.yellow);
    g.fillOval(506, 221, 49, 84);
    g.setColor(Color.black);
    g.drawOval(775, 220, 50, 85);
    g.setColor(Color.yellow);
    g.fillOval(776, 221, 49, 84);
    g.setColor(Color.black);
    g.drawOval(605, 170, 120, 185);
    g.setColor(Color.yellow);
    g.fillOval(606, 171, 119, 184);
    g.setColor(Color.black);
   }    
}
