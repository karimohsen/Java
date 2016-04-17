/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package signoutclass;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Karim
 */
public class SignoutService {
    public SignoutService(){
        try {
            SignoutImplementation out = new SignoutImplementation();
            Registry reg = LocateRegistry.createRegistry(5009);
            reg.rebind("signoutservice", out);
        } catch (RemoteException ex) {
            Logger.getLogger(SignoutService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
