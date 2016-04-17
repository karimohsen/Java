/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package populateuserpackage;


import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Karim
 */
public class PopulateMyDataServer {
    public PopulateMyDataServer(){
        try {
            PopulateMyDataImplementation data = new PopulateMyDataImplementation();
            Registry reg = LocateRegistry.createRegistry(5007);
            reg.rebind("friendrequestservice", data);
        } catch (RemoteException ex) {
            Logger.getLogger(PopulateMyDataServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
