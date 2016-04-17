/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package confirmpackage;

import com.mysql.jdbc.Driver;
import commonclasses.ClientData;
import commonclasses.ConfirmInterface;
import dbconnections.ConnectDb;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Karim
 */
public class ConfirmImplementation extends UnicastRemoteObject implements ConfirmInterface {

    public ConfirmImplementation() throws RemoteException {

    }

    @Override
    public int confirmRejectFriend(ClientData client, String friend, int choice) throws RemoteException {
        ConnectDb connectDb = new ConnectDb();
        int db_result = -2;
        try {

            //-2 represents database error
            DriverManager.registerDriver(new Driver());
            Connection con = DriverManager.getConnection("jdbc:mysql://" + connectDb.getIp() + "/" + connectDb.getDbName() + "?" + "user=" + connectDb.getUsername() + "&password=" + connectDb.getPassword());
            Statement st = con.createStatement();
            if (choice == 1) {
                //means the user accepted the request
                st.executeQuery("delete from `requests` where `from` = '" + client.getEmail() + "' AND `to` = '" + friend + "'");
                st.executeQuery("Insert Into friends VALUES ('" + client.getEmail() + "','" + friend + "')");
            } else {
                st.executeQuery("delete from `requests` where `from` = '" + client.getEmail() + " AND `to` = '" + friend + "'");
            }

        } catch (SQLException ex) {
            System.out.println("Database connection error");
        }
        return db_result;
    }

}
