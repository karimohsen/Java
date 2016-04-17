/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Karim
 */
public class ClientClass extends UnicastRemoteObject implements Remote{
    public ClientClass()throws RemoteException{
        
    }
    public void receive(String msg,int frameno){
        
    }
}
