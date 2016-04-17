/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package friendsrequests;

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

        ArrayList<ClientData> requestslist = new ArrayList<ClientData>();
        ConnectDb connectDb = new ConnectDb();
        ClientData temp = new ClientData();
        try {
            DriverManager.registerDriver(new Driver());
            Connection con = DriverManager.getConnection("jdbc:mysql://" + connectDb.getIp() + "/" + connectDb.getDbName() + "?" + "user=" + connectDb.getUsername() + "&password=" + connectDb.getPassword());
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from `requests` where `to` = '" + client.getEmail() + "'");
            while (rs.next()) {
                ResultSet rs2 = st.executeQuery("select * from users where email = '" + rs.getString("from") + "'");
                while (rs2.next()) {
                    temp.setEmail(rs2.getString("email"));
                    temp.setUsername(rs2.getString("username"));
                    temp.setStatus(rs2.getString("status"));
                    requestslist.add(temp);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(FriendRequestsImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return requestslist;
    }

}
