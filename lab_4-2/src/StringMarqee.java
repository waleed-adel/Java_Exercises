
import java.applet.Applet;
import java.awt.*;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author DELL
 */
public class StringMarqee extends Applet implements Runnable {

    Thread th;
    int x = 0;

    @Override
    public void init() {

        th = new Thread(this);
        th.start();

    }

    @Override
    public void paint(Graphics g) {

        if (x >= getWidth()) {
            x = 0;
        }
        g.drawString("kalam bymshy", x, 120);
    }

    @Override
    public void run() {

        while (true) {
            repaint();
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                System.out.println("Exception ya m3lm!!");
            }
            x += 10;
        }
    }

}
