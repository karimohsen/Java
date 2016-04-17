/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import java.rmi.AccessException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Karim
 */
public class ServerRMI {
    public ServerRMI(){
        try {
            ChatServer cs = new ChatServer();
            Registry r = LocateRegistry.createRegistry(5080);
            r.rebind("ChatServer", cs);
        } catch (AccessException ex) {
            ex.printStackTrace();
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

    }
    public static void main(String[] args){

        new ServerRMI();
    }
}
