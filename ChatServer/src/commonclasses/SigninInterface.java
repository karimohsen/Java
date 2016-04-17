/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commonclasses;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Karim
 */
public interface SigninInterface extends Remote {

    public int validateUserLoginData(String mail,String passwd) throws RemoteException;
    public void register(String mail,ClientInterface model)throws RemoteException;
    public ClientData getmydata(String mail)throws RemoteException;
}
