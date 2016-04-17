/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package commonclasses;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author amal magdi
 */
public interface ChatInterface extends Remote{
    public void connectFriends(ArrayList<String> mails)throws RemoteException;
    public void tellToGroup(int sessionID,String msg)throws RemoteException;
    //public void register(String mail,ClientInterface model)throws RemoteException;
    public void disconnect(int id,ClientInterface model)throws RemoteException;
}
