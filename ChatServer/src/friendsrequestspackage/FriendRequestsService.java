/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package friendsrequestspackage;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Karim
 */
public class FriendRequestsService {

    public FriendRequestsService() {
        try {
            FriendRequestsImplementation friends = new FriendRequestsImplementation();
            Registry reg = LocateRegistry.createRegistry(5006);
            reg.rebind("friendrequestservice", friends);
        } catch (RemoteException ex) {
            Logger.getLogger(FriendRequestsService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
