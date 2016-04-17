/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package confirmpackage;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Karim
 */
public class ConfirmService {

    public ConfirmService() {
        try {
            ConfirmImplementation confirm = new ConfirmImplementation();
            Registry reg = LocateRegistry.createRegistry(5003);
            reg.rebind("confirmservice", confirm);
        } catch (RemoteException ex) {
            Logger.getLogger(ConfirmService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
