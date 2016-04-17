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
 * @author Karim
 */
public interface MyFriendsList extends Remote {

    public ArrayList<ClientData> onlineFriends(ClientData client) throws RemoteException;

}
