/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chattingPackage;
import commonclasses.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import server.ServerClass;
/**
 *
 * @author amal magdi
 */
public class chatImpl extends UnicastRemoteObject implements ChatInterface {
    
    
    
    /*
    hashmap1 , hashmap2 , register asln magodeeeeeen asasi 
    */
  
    
    HashMap<Integer, ArrayList<ClientInterface>> map2;
    static  int sessionIndex=0;
    public chatImpl()throws RemoteException{
        
        map2=new HashMap<Integer, ArrayList<ClientInterface>>();
                
    }
    
    
    

    public void connectFriends(ArrayList<String> mails) throws RemoteException {
        sessionIndex++;
        ArrayList<ClientInterface> arr=new ArrayList<ClientInterface>();
                
    for(String s:mails){
      ClientInterface cf=ServerClass .map1.get(s);
      if(cf!=null){
        arr.add(cf);
        cf.startSession(sessionIndex);
      }
  }
    
    map2.put(sessionIndex, arr);
    
    }

    public void tellToGroup(int sessionID, String msg) throws RemoteException {
   for(ClientInterface i: map2.get(sessionID) ){
       i.receive(sessionID, msg);
   }
    
    }

//    public void register(String mail,ClientInterface model) throws RemoteException {
//
//    map1.put(mail, model);
//    }

    
    // when one
    

    public void disconnect(int sessionID, ClientInterface model) throws RemoteException {
if(map2.get(sessionID).contains(model))
   map2.get(sessionID).remove(model);
    
    }
    
}
