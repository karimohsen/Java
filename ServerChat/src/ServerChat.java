
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Karim
 */
public class ServerChat {
    ServerSocket serversocket;
    public static void main(String [] args){
        new ServerChat();
    }
    public ServerChat(){
        try {
            serversocket = new ServerSocket(5323);
            while (true) {
                Socket s = serversocket.accept();
                new ChatHandler(s);
            }
        } catch (IOException ex) {
            System.out.println("Serever is already started");
            
        }
    }
    
}
