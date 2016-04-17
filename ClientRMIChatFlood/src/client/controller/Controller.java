/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package client.controller;

import client.model.Client;
import client.view.chatview;
import common.ServerInterface;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Karim
 */
public class Controller {
    ServerInterface si;
    chatview ch;
    Client c;
    public void settext(String s){
        try {
            si.flodMessage(s);
        } catch (RemoteException ex) {
            System.out.println("server is closed");
        }
    }
    public void getthensettext(String s){
        ch.settext(s);
    }
    public Controller(){
        try {
            Registry reg = LocateRegistry.getRegistry("127.0.0.1", 5080);
             si = (ServerInterface) reg.lookup("ChatServer");
             ch = new chatview(this);
             c= new Client(this);
             si.register(c);
        } catch (NotBoundException ex) {
            ex.printStackTrace();
        } catch (AccessException ex) {
            ex.printStackTrace();
        } catch (RemoteException ex) {
            System.out.println("Server is Closed donkey");
        }

    }
    public static void main(String [] args){
        new Controller();
    }
}
