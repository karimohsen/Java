package common;

import java.rmi.Remote;
import java.rmi.RemoteException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Karim
 */
public interface ServerInterface extends Remote {

    void flodMessage(String msg) throws RemoteException;

    void register(ClientInterface clientRef) throws RemoteException;

    void unRegister(ClientInterface clientRef) throws RemoteException;
}
