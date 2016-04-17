/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chattingPackage;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author amal magdi
 */
public class chatService {
    public chatService(){
        try {
            chatImpl chatSer=new chatImpl();
            Registry reg=LocateRegistry.createRegistry(5596);
            reg.rebind("chat", chatSer);
        } catch (RemoteException ex) {
            Logger.getLogger(chatService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   
}
