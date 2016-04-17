
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
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
public class ChatHandler extends Thread {

    DataInputStream dis;
    DataOutputStream ps;
    Socket sock;
    static ArrayList<ChatHandler> arrayList = new ArrayList<ChatHandler>();

    public ChatHandler(Socket s) {
        try {
            sock = s;
            dis = new DataInputStream(s.getInputStream());
            ps = new DataOutputStream(s.getOutputStream());
            ChatHandler.arrayList.add(this);
            start();
        } catch (IOException ex) {

            Logger.getLogger(ChatHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void run() {
        try {
            while (true) {

                String str = dis.readUTF();
                System.out.println(str);
                flodMessage(str);
            }
        } catch (IOException ex) {
            try {
                System.out.println("A client Logged Out");
                this.dis.close();
                this.ps.close();
                this.sock.close();
                ChatHandler.arrayList.remove(this);
            } catch (IOException ex1) {
                System.out.println("Error");
            }
        }
    }

public void flodMessage(String s){
            for(ChatHandler c : ChatHandler.arrayList){
            try {
                c.ps.writeUTF(s);
            } catch (IOException ex) {
                Logger.getLogger(ChatHandler.class.getName()).log(Level.SEVERE, null, ex);
            }

                }
        }
}

        

