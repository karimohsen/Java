/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package server;

import addfriendpackage.AddFriendService;
import chattingPackage.*;
import commonclasses.ClientInterface;
import confirmpackage.ConfirmService;
import friendsrequestspackage.FriendRequestsService;
import java.util.HashMap;
import myfriendspackage.MyFriendsService;
import signinpackage.SigninService;
import signoutclass.SignoutService;
import signuppackage.SignupService;
import statuschangepackage.StatusChangeService;
/**
 *
 * @author Karim
 */
public class ServerClass {
   public static HashMap<String, ClientInterface> map1=new HashMap<String, ClientInterface>();
    
    public static void main(String [] args){
        
        new SignoutService();
        new AddFriendService();
        new ConfirmService();
        new FriendRequestsService();
        new MyFriendsService();
        new SigninService();
        new SignupService();
        new StatusChangeService();
            new chatService();
    }
}
