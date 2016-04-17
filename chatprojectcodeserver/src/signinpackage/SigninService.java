/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signinpackage;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Karim
 */
public class SigninService {

    public SigninService() {
        try {
            SigninImplemention signin = new SigninImplemention();
            //select random port for sign in service
            Registry rg = LocateRegistry.createRegistry(5000);
            rg.rebind("signinservice", signin);
        } catch (RemoteException ex) {
            System.out.println("can't bind service");
        }
    }
}
