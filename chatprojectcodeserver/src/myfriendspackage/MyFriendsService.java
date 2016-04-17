/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myfriendspackage;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Karim
 */
public class MyFriendsService {

    public MyFriendsService() {
        try {
            MyFriendsImplementation myFriends = new MyFriendsImplementation();
            Registry reg = LocateRegistry.createRegistry(5004);
            reg.rebind("myfriendsservice", myFriends);
        } catch (RemoteException ex) {
            Logger.getLogger(MyFriendsService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
