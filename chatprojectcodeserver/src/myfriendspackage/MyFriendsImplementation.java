/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myfriendspackage;

import com.mysql.jdbc.Driver;
import commonclasses.ClientData;
import commonclasses.MyFriendsList;
import dbconnections.ConnectDb;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Karim
 */
public class MyFriendsImplementation extends UnicastRemoteObject implements MyFriendsList {

    public MyFriendsImplementation() throws RemoteException {

    }

    @Override
    public ArrayList<ClientData> onlineFriends(ClientData client) throws RemoteException {
        ArrayList<ClientData> allfriends = new ArrayList<ClientData>();
        ClientData temp = new ClientData();
        ConnectDb connectDb = new ConnectDb();
        try {

            DriverManager.registerDriver(new Driver());
            Connection con = DriverManager.getConnection("jdbc:mysql://" + connectDb.getIp() + "/" + connectDb.getDbName() + "?" + "user=" + connectDb.getUsername() + "&password=" + connectDb.getPassword());
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from friends where usermail='" + client.getEmail() + "'");
            while (rs.next()) {
                ResultSet rs2 = st.executeQuery("select * from users where email='" + rs.getString("friendmail") + "'");
                while(rs2.next()){
                    temp.setEmail(rs2.getString("email"));
                    temp.setUsername(rs2.getString("username"));
                    temp.setStatus(rs2.getString("status"));
                    allfriends.add(temp);
                }
            }
            rs = st.executeQuery("select * from friends where friendmail='" + client.getEmail() + "'");
            while (rs.next()) {
                ResultSet rs2 = st.executeQuery("select * from users where email='" + rs.getString("usermail") + "'");
                while(rs2.next()){
                temp.setEmail(rs2.getString("email"));
                temp.setUsername(rs2.getString("username"));
                temp.setStatus(rs2.getString("status"));
                allfriends.add(temp);
                }
            }
        } catch (SQLException ex) {
            System.out.println("can't connect to database");
        }
        return allfriends;
    }
}
