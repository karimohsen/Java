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
 * @author Karim
 */
public interface ConfirmInterface extends Remote {

    public int confirmRejectFriend(ClientData client, String friend, int choice) throws RemoteException;
}
