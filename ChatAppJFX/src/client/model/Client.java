/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package client.model;

import chatappjfx.FXMLDocumentController;
import common.ClientInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Karim
 */
public class Client extends UnicastRemoteObject implements ClientInterface{
    public FXMLDocumentController cont;
    public Client ()throws RemoteException{
        
    }
    public Client (FXMLDocumentController c)throws RemoteException{
        cont=c;
    }
    public void receive(String msg)  {
         cont.getthensettext(msg);
    }
    
}
