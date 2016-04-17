/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import common.ClientInterface;
import common.ServerInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Karim
 */
public class ChatServer extends UnicastRemoteObject implements ServerInterface{
    Vector<ClientInterface> clientvector = new Vector<ClientInterface>();
    public ChatServer()throws RemoteException{
        
    }
    public void flodMessage(String msg) {
        for(int i =0 ; i < clientvector.size() ; i++){
            try {
                clientvector.get(i).receive(msg);
            } catch (RemoteException ex) {
                System.out.println("Can't send msg to client");
                Logger.getLogger(ChatServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void register(ClientInterface clientRef) {
       clientvector.add(clientRef);
        System.out.println("new client Added");
    }

    public void unRegister(ClientInterface clientRef){
        clientvector.remove(clientRef);
        System.out.println("new client Removed");
    }

}
