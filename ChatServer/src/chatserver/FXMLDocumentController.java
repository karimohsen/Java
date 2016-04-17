/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatserver;

import addfriendpackage.AddFriendImplementation;
import chattingPackage.chatImpl;
import commonclasses.ClientData;
import confirmpackage.ConfirmImplementation;
import friendsrequestspackage.FriendRequestsImplementation;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import myfriendspackage.MyFriendsImplementation;
import server.ServerClass;
import signinpackage.SigninImplemention;
import signoutclass.SignoutImplementation;
import signuppackage.SignupImplementation;
import statuschangepackage.StatusChangeImplementation;

/**
 *
 * @author Karim
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private ImageView start;
    @FXML
    private ImageView stop;
    @FXML
    private ImageView broadmsg;
    @FXML
    private PieChart pie;

    int index = 0;
    boolean startflag = false;
    boolean stopglag = false;
    Registry reg_addfriend;
    Registry reg_chat;
    Registry reg_confirm;
    Registry reg_friendreq;
    Registry reg_myfriend;
    Registry reg_signin;
    Registry reg_signout;
    Registry reg_signup;
    Registry reg_state;
    AddFriendImplementation friend;
    chatImpl chatSer;
    ConfirmImplementation confirm;
    FriendRequestsImplementation friends;
    MyFriendsImplementation myFriends;
    SigninImplemention signin;
    SignoutImplementation out;
    SignupImplementation signup;
    StatusChangeImplementation stateChange;
     ObservableList<Data> answer;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        start.setImage(new Image(getClass().getResource("1421752406_Play1Hot.png").toString()));
        stop.setImage(new Image(getClass().getResource("1421752315_hand-stop-48.png").toString()));
        broadmsg.setImage(new Image(getClass().getResource("1421751932_mail-01-48.png").toString()));
        start.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                if (index == 0) {
                    index = 1;
                    System.out.println("here");
                    startflag = true;
                    try {

//==========================================================
                        friend = new AddFriendImplementation();
                        reg_addfriend = LocateRegistry.createRegistry(5002);
                        reg_addfriend.rebind("addfriendService", friend);
//===========================================================
                        chatSer = new chatImpl();
                        reg_chat = LocateRegistry.createRegistry(5596);
                        reg_chat.rebind("chat", chatSer);
//==========================================================
                        confirm = new ConfirmImplementation();
                        reg_confirm = LocateRegistry.createRegistry(5003);
                        reg_confirm.rebind("confirmservice", confirm);
//=========================================================
                        friends = new FriendRequestsImplementation();
                        reg_friendreq = LocateRegistry.createRegistry(5006);
                        reg_friendreq.rebind("friendrequestservice", friends);
//==========================================================
                        myFriends = new MyFriendsImplementation();
                        reg_myfriend = LocateRegistry.createRegistry(5004);
                        reg_myfriend.rebind("myfriendsservice", myFriends);
//==================================================
                        signin = new SigninImplemention();
                        //select random port for sign in service
                        reg_signin = LocateRegistry.createRegistry(5000);
                        reg_signin.rebind("signinservice", signin);
//=======================================================
                        out = new SignoutImplementation();
                        reg_signout = LocateRegistry.createRegistry(5009);
                        reg_signout.rebind("signoutservice", out);

//=======================================================
                        signup = new SignupImplementation();
                        //create random port for Sign up service
                        reg_signup = LocateRegistry.createRegistry(5001);
                        reg_signup.rebind("signupservice", signup);
//============================================================
                        stateChange = new StatusChangeImplementation();
                        reg_state = LocateRegistry.createRegistry(5005);
                        reg_state.rebind("statuechangeservice", stateChange);
                    } catch (RemoteException ex) {
                        ex.printStackTrace();
                    }

                }
                if (startflag == false && index != 0) {
                    startflag = true;
                    try {

                        friend = new AddFriendImplementation();
                        reg_addfriend = LocateRegistry.getRegistry(5002);
                        reg_addfriend.rebind("addfriendService", friend);
//===========================================================
                        chatSer = new chatImpl();
                        reg_chat = LocateRegistry.getRegistry(5596);
                        reg_chat.rebind("chat", chatSer);
//==========================================================
                        confirm = new ConfirmImplementation();
                        reg_confirm = LocateRegistry.getRegistry(5003);
                        reg_confirm.rebind("confirmservice", confirm);
//=========================================================
                        friends = new FriendRequestsImplementation();
                        reg_friendreq = LocateRegistry.getRegistry(5006);
                        reg_friendreq.rebind("friendrequestservice", friends);
//==========================================================
                        myFriends = new MyFriendsImplementation();
                        reg_myfriend = LocateRegistry.getRegistry(5004);
                        reg_myfriend.rebind("myfriendsservice", myFriends);
//==================================================
                        signin = new SigninImplemention();
                        //select random port for sign in service
                        reg_signin = LocateRegistry.getRegistry(5000);
                        reg_signin.rebind("signinservice", signin);
//=======================================================
                        out = new SignoutImplementation();
                        reg_signout = LocateRegistry.getRegistry(5009);
                        reg_signout.rebind("signoutservice", out);

//=======================================================
                        signup = new SignupImplementation();
                        //create random port for Sign up service
                        reg_signup = LocateRegistry.getRegistry(5001);
                        reg_signup.rebind("signupservice", signup);
//============================================================
                        stateChange = new StatusChangeImplementation();
                        reg_state = LocateRegistry.getRegistry(5005);
                        reg_state.rebind("statuechangeservice", stateChange);

                    } catch (RemoteException ex) {
                        ex.printStackTrace();
                    }

                }
            }
        });
        stop.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                try {
                    // TODO add your handling code here:
                    if (stopglag == false) {
                        stopglag = true;
                        startflag = false;
                        reg_addfriend.unbind("addfriendService");
                        reg_chat.unbind("chat");
                        reg_confirm.unbind("confirmservice");
                        reg_friendreq.unbind("friendrequestservice");
                        reg_myfriend.unbind("myfriendsservice");
                        reg_signin.unbind("signinservice");
                        reg_signout.unbind("signoutservice");
                        reg_signup.unbind("signupservice");
                        reg_state.unbind("statuechangeservice");
                    }
                } catch (RemoteException ex) {
                    ex.printStackTrace();
                } catch (NotBoundException ex) {
                    ex.printStackTrace();
                }
            }
        });
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    int available = 0;
                    int busy = 0;
                    int away = 0;
                    Iterator it = ServerClass.map1.entrySet().iterator();
                    while (it.hasNext()) {
                        Map.Entry pairs = (Map.Entry) it.next();
                        ClientData data = (ClientData) pairs.getKey();
                        if (data.getStatus() == "available") {
                            available++;
                        } else if (data.getStatus() == "away") {
                            away++;
                        } else if (data.getStatus() == "busy") {
                            busy++;
                        }
                        try {
                            Thread.sleep(300);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        it.remove(); // avoids a ConcurrentModificationException
                    }
                     answer = FXCollections.observableArrayList(new PieChart.Data("available", available),
                            new PieChart.Data("away", away),
                            new PieChart.Data("busy", busy));
                    
                    Platform.runLater(new Runnable() {

                        @Override
                        public void run() {
                            pie.setData(answer);
                        }
                    });
                    
                }
            }
        });
        thread.start();

    }

}
