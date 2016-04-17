
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Karim
 */
public class ClientConsole {
    Socket s;
    DataInputStream dis;
    PrintStream ps;
    
    public static void main(String [] args){
        new ClientConsole();
    }
    public ClientConsole(){
        try {
            s = new Socket(InetAddress.getLocalHost(), 5647);
            dis =new DataInputStream(s.getInputStream());
            ps = new PrintStream(s.getOutputStream());
            ps.println("test from client");
            String replayMsg=dis.readLine();
            System.out.println(replayMsg);
        } catch (IOException ex) {
            
        }
        finally{
            try {
                if(s!=null)
                s.close();
                if(dis!=null)
                dis.close();
                if(ps!=null)
                ps.close();
                
            } catch (IOException ex) {
                
            }
           
        }
    }
}
