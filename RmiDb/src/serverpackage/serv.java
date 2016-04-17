/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package serverpackage;

import java.rmi.AccessException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Karim
 */
public class serv {

    public static void main(String[] args) {
        new serv();
    }

    public serv() {
        try {
            EmpDb obj = new EmpDb();
            Registry reg = LocateRegistry.createRegistry(5050);
            reg.bind("DbService", obj);
        } catch (AlreadyBoundException ex) {
            System.out.println("Service name is already used");
        } catch (AccessException ex) {
            System.out.println("Access Exception");
        } catch (RemoteException ex) {
            System.out.println("Server is already running");
        }

    }
}
