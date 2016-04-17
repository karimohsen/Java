/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addfriendpackage;

import com.mysql.jdbc.Driver;
import commonclasses.AddfriendInterface;
import commonclasses.ClientData;
import dbconnections.ConnectDb;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Karim
 */
public class AddFriendImplementation extends UnicastRemoteObject implements AddfriendInterface {

    public AddFriendImplementation() throws RemoteException {

    }

    public int checkrequest(String from, String to) {
        int result = 0;
        ConnectDb connectDb = new ConnectDb();
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://" + connectDb.getIp() + "/" + connectDb.getDbName() + "?" + "user=" + connectDb.getUsername() + "&password=" + connectDb.getPassword());
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from `requests` where `from` = '" + from + "' and `to` = '" + to + "'");
            if(rs.next()){
                result=-1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AddFriendImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    public void addfriend(String from, String to){
        ConnectDb connectDb = new ConnectDb();
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://" + connectDb.getIp() + "/" + connectDb.getDbName() + "?" + "user=" + connectDb.getUsername() + "&password=" + connectDb.getPassword());
            Statement st = con.createStatement();
             st.executeUpdate("INSERT INTO `requests` (`from`,`to`)VALUES ('" + from + "','" + to + "')");
            
        } catch (SQLException ex) {
            Logger.getLogger(AddFriendImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public int SendfriendRequest(ClientData client, String request_to) throws RemoteException {
        ConnectDb connectDb = new ConnectDb();
        int db_result = -2;
        //if -2 means can't connect to server
        try {

            DriverManager.registerDriver(new Driver());
            Connection con = DriverManager.getConnection("jdbc:mysql://" + connectDb.getIp() + "/" + connectDb.getDbName() + "?" + "user=" + connectDb.getUsername() + "&password=" + connectDb.getPassword());
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from users where email = '" + request_to + "'");
            if (rs.next()) {
                //check at client side if they are already friends don't send request
                //===================================================================
                //check if he already sent a request
                int result1 = checkrequest(request_to,client.getEmail());
                int result2 = checkrequest(client.getEmail(),request_to);
                
                if (result1==-1 || result2==-1) {
                    //means some one already sent to the other one request
                    db_result = 0;
                } else {
                    //send request to friend
                    db_result = 1;
                    addfriend(client.getEmail(),request_to);
                }
            } else {
                //means there is no such user with this mail
                db_result = -1;
            }

        } catch (SQLException ex) {
            System.out.println("can't connect to database");
        }
        return db_result;
    }

}
