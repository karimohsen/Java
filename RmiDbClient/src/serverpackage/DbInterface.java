/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package serverpackage;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Karim
 */
public interface DbInterface extends Remote {

    void writetodb(Emp e) throws RemoteException;

    Emp readfromdb(int i) throws RemoteException;
}
