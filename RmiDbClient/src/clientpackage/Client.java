/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clientpackage;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import serverpackage.DbInterface;
import serverpackage.Emp;

/**
 *
 * @author Karim
 */
public class Client {

    public static void main(String[] args) {
        new Client();
    }

    public Client() {
        try {
            Registry reg = LocateRegistry.getRegistry("127.0.0.1", 5050);
            DbInterface db = (DbInterface) reg.lookup("DbService");
            Emp e = new Emp();
            e.setId(3);
            e.setName("eng.medhat");
            e.setadd("adfasdfasdf");
            db.writetodb(e);
            Emp e2 = new Emp();
            db.readfromdb(2);
            System.out.println("Emp id is " + e2.getId());
            System.out.println("Emp name is " + e2.getName());
            System.out.println("Emp address is " + e2.getAdd());
        } catch (NotBoundException ex) {
            System.out.println("Error");
        } catch (AccessException ex) {
            System.out.println("Access error");
        } catch (RemoteException ex) {
            System.out.println("error with remote connection");
        }
    }
}
