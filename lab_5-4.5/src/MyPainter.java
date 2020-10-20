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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Vector;

public class MyPainter extends Applet {

    Vector<Integer> x1 = new Vector<>();  //dynamic array of Integer class  
    Vector<Integer> y1 = new Vector<>();
    Vector<Integer> x2 = new Vector<>();
    Vector<Integer> y2 = new Vector<>();
    int count = 0;
    Button clrScr;

    @Override
    public void init() {

        clrScr = new Button("Clear Screen");
        clrScr.addActionListener(new MyClrScr());
        add(clrScr);

        addMouseListener(new MouseListener() {

            @Override
            public void mousePressed(MouseEvent e) {
                x1.add(new Integer(e.getX()));
                y1.add(new Integer(e.getY()));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                count++;
            }

            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        addMouseMotionListener(new MouseMotionListener() {

            @Override
            public void mouseMoved(MouseEvent e) {
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                x2.add(count, new Integer(e.getX()));
                y2.add(count, new Integer(e.getY()));
                repaint();  //draw only when mouse is dragged
            }
        });
    }

    @Override
    public void paint(Graphics g) {
            for (int i = 0; i < x1.size(); i++) {
                g.drawLine((int) x1.get(i), (int) y1.get(i), (int) x2.get(i), (int) y2.get(i));
            }
    }

    class MyClrScr implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ev) {

            x1.clear();
            x2.clear();
            y1.clear();
            y2.clear();
            count=0;
            repaint();
        }
    }
}
