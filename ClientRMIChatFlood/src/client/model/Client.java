/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package client.model;

import client.controller.Controller;
import common.ClientInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Karim
 */
public class Client extends UnicastRemoteObject implements ClientInterface{
    public Controller cont;
    public Client ()throws RemoteException{
        
    }
    public Client (Controller c)throws RemoteException{
        cont=c;
    }
    public void receive(String msg)  {
         cont.getthensettext(msg);
    }
    
}
