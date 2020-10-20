/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the edito

/**
 *
 * @author DELL
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Client extends JFrame {

    Socket mySocket;
    DataInputStream dis;
    PrintStream ps;

    public static void main(String[] args) throws IOException {

        //creating GUI   
        Client ui = new Client();
        ui.setSize(400, 500);
        ui.setVisible(true);
    }

    public Client() throws IOException {

        //GUI code
        this.setLayout(new FlowLayout());
        JTextArea ta = new JTextArea(5, 30);
        JScrollPane scroll = new JScrollPane(ta);
        scroll.setViewportView(ta);
        JTextField tf = new JTextField(30);
        JButton sendButton = new JButton("Send");

        try {
            mySocket = new Socket("127.0.0.1",5005);
            dis = new DataInputStream(mySocket.getInputStream());
            ps = new PrintStream(mySocket.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }

        sendButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ps.println(tf.getText());           
                //tf.setText("");
            }
        });
        
        
        Thread th = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        String s = dis.readLine();
                        ta.append(s + "\n");
                    } catch (IOException ex) {
                        ex.printStackTrace();
                        Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        th.start();
        add(scroll);
        add(tf);
        add(sendButton);
    }//end of client constructor
}
