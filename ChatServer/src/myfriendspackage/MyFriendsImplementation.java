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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Karim
 */
public class MyFriendsImplementation extends UnicastRemoteObject implements MyFriendsList {

    public MyFriendsImplementation() throws RemoteException {

    }
    public ClientData returnClientData(String mail){
        
            ClientData temp = new ClientData();
            ConnectDb connectDb = new ConnectDb();
            
        try {
            DriverManager.registerDriver(new Driver());
            Connection con = DriverManager.getConnection("jdbc:mysql://" + connectDb.getIp() + "/" + connectDb.getDbName() + "?" + "user=" + connectDb.getUsername() + "&password=" + connectDb.getPassword());
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from users where email = '" + mail + "'");
            if (rs.first()) {
                temp.setEmail(rs.getString("email"));
                temp.setUsername(rs.getString("username"));
                temp.setStatus(rs.getString("status"));
                temp.setPasswd(rs.getString("passwd"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MyFriendsImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return temp;
    }
    @Override
    public ArrayList<ClientData> onlineFriends(ClientData client) throws RemoteException {
        ArrayList<ClientData> allfriends = new ArrayList<ClientData>();
        ClientData temp ;
        ConnectDb connectDb = new ConnectDb();
        try {

            DriverManager.registerDriver(new Driver());
            Connection con = DriverManager.getConnection("jdbc:mysql://" + connectDb.getIp() + "/" + connectDb.getDbName() + "?" + "user=" + connectDb.getUsername() + "&password=" + connectDb.getPassword());
            Statement st = con.createStatement();
            System.out.println(client.getEmail());
            ResultSet rs = st.executeQuery("select * from friends where usermail='" + client.getEmail() + "'");
            ArrayList<String> myfriends = new ArrayList<String>();
            while (rs.next()) {
                
                myfriends.add(rs.getString("friendmail"));
            
            }
           for(int i = 0 ; i < myfriends.size(); i++){
               temp = returnClientData(myfriends.get(i));
               allfriends.add(temp);
           }
        } catch (SQLException ex) {
         ex.printStackTrace();
        
        }
        
        return allfriends;
    }
}
