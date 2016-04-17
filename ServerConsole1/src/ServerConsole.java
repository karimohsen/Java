
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
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
public class ServerConsole {
    ServerSocket ss;
     Socket s;
     DataInputStream dis;
     PrintStream ps;
    public static void main(String []args){
        new ServerConsole();
    }
    public ServerConsole(){
        try {
             ss = new ServerSocket(5647);
             s = ss.accept();
             dis = new DataInputStream(s.getInputStream());
             ps = new PrintStream(s.getOutputStream());
            String msg = dis.readLine();
            System.out.println("msg received");
            ps.println("msg");
        } catch (IOException ex) {
            Logger.getLogger(ServerConsole.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                ps.close();
                dis.close();
                s.close();
                ss.close();
            } catch (IOException ex) {
                Logger.getLogger(ServerConsole.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
