/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package statuschangepackage;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Karim
 */
public class StatusChangeService {

    public StatusChangeService() {
        try {
            StatusChangeImplementation stateChange = new StatusChangeImplementation();
            Registry reg = LocateRegistry.createRegistry(5005);
            reg.rebind("statuechangeservice", stateChange);
        } catch (RemoteException ex) {
            Logger.getLogger(StatusChangeService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
