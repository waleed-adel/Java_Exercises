
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DELL
 */
public class ChatServer {

    ServerSocket serverSocket;

    /**
     *
     * @throws IOException
     */
    public ChatServer() throws IOException {
        serverSocket = new ServerSocket(5005);
        while (true) {
            Socket s = serverSocket.accept();
            new ChatHandler(s);
        }
    }

    public static void main(String[] args) throws IOException {
        
        new ChatServer();
    }
}

class ChatHandler extends Thread {

    DataInputStream dis;
    PrintStream ps;
    static Vector<ChatHandler> clientsVector
            = new Vector<ChatHandler>();

    public ChatHandler(Socket cs) throws IOException {
        dis = new DataInputStream(cs.getInputStream());
        ps = new PrintStream(cs.getOutputStream());
        clientsVector.add(this);
        this.start();
    }

    @Override
    public void run() {
      
        while (true) {
            
            try {
              String str = dis.readLine();
              sendMessageToAll(str);
            } catch (IOException ex) {
                Logger.getLogger(ChatHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    } 

    void sendMessageToAll(String msg) {
        for (ChatHandler ch : clientsVector) {
            ch.ps.println(msg);
        }
    }
}
