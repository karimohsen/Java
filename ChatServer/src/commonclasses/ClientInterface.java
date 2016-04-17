/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package commonclasses;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author amal magdi
 */
public interface ClientInterface extends Remote {
    public void startSession(int id) throws RemoteException ;
    public void receive(int id,String msg) throws RemoteException;
    public void onConfirmFriendRequest()throws RemoteException;
}
