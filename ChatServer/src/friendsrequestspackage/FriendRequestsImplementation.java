/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package friendsrequestspackage;

import com.mysql.jdbc.Driver;
import commonclasses.ClientData;
import commonclasses.FriendRequestsInterface;
import dbconnections.ConnectDb;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Karim
 */
public class FriendRequestsImplementation extends UnicastRemoteObject implements FriendRequestsInterface {

    public FriendRequestsImplementation() throws RemoteException {

    }

    @Override
    public ArrayList<ClientData> friendsRequests(ClientData client) throws RemoteException {
        ArrayList<String> fromlist = new ArrayList<String>();
        ArrayList<ClientData> requestslist = new ArrayList<ClientData>();
        ConnectDb connectDb = new ConnectDb();
        ClientData temp = new ClientData();
        try {
            DriverManager.registerDriver(new Driver());
            Connection con = DriverManager.getConnection("jdbc:mysql://" + connectDb.getIp() + "/" + connectDb.getDbName() + "?" + "user=" + connectDb.getUsername() + "&password=" + connectDb.getPassword());
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from `requests` where `to` = '" + client.getEmail() + "'");
            while (rs.next()) {
                fromlist.add(rs.getString(1));
            }
            for (int i = 0; i < fromlist.size(); i++) {
                requestslist.add(getMyData(fromlist.get(i)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FriendRequestsImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return requestslist;
    }

    public ClientData getMyData(String name) {
        ClientData temp = new ClientData();
        ConnectDb connectDb = new ConnectDb();
        try {

            DriverManager.registerDriver(new Driver());
            Connection con = DriverManager.getConnection("jdbc:mysql://" + connectDb.getIp() + "/" + connectDb.getDbName() + "?" + "user=" + connectDb.getUsername() + "&password=" + connectDb.getPassword());
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("select * from users where email = '" + name + "'");
            while (rs.next()) {
                temp.setEmail(rs.getString("email"));
                temp.setUsername(rs.getString("username"));
                temp.setStatus(rs.getString("status"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(FriendRequestsImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return temp;
    }
}
