/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addfriendpackage;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Karim
 */
public class AddFriendService {

    public AddFriendService() {
        try {
            AddFriendImplementation friend = new AddFriendImplementation();
            Registry reg = LocateRegistry.createRegistry(5002);
            reg.rebind("addfriendService", friend);
        } catch (RemoteException ex) {
            Logger.getLogger(AddFriendService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
