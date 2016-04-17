/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signuppackage;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Karim
 */
public class SigupService {

    public SigupService() {
        try {
            SignupImplementation signup = new SignupImplementation();
            //create random port for Sign up service
            Registry regist = LocateRegistry.createRegistry(5001);
            regist.rebind("signupservice", signup);
        } catch (RemoteException ex) {
            System.out.println("Can't bind service");
        }

    }

}
