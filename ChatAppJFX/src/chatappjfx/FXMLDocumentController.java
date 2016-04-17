/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chatappjfx;

import client.model.Client;
import common.ServerInterface;
import java.net.URL;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 *
 * @author Karim
 */
public class FXMLDocumentController implements Initializable {
    ServerInterface si;
    @FXML
    private TextField txf1;
    @FXML
    private TextField txf2;
    @FXML
    private Button but;
    @FXML
    private void handleButtonAction(ActionEvent event) {
        try {   
            si.flodMessage(txf2.getText());
            txf2.setText("");
        } catch (RemoteException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void getthensettext(final String s){
        //txf1.appendText("\n"+s);
        Platform.runLater(new Runnable() {

            @Override
            public void run() {
                txf1.appendText(s+"\n");
            }
        });
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txf1.setEditable(false);
        try {
            // TODO
            Registry reg = LocateRegistry.getRegistry("127.0.0.1", 5080);
            si = (ServerInterface) reg.lookup("ChatServer");
            Client c= new Client(this);
             si.register(c);
        } catch (RemoteException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }    
    
}
