/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statuschangepackage;

import com.mysql.jdbc.Driver;
import commonclasses.ClientData;
import commonclasses.StatusChangeInterface;
import dbconnections.ConnectDb;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Karim
 */
public class StatusChangeImplementation extends UnicastRemoteObject implements StatusChangeInterface {

    public StatusChangeImplementation() throws RemoteException {

    }

    @Override
    public void changeStatus(ClientData client) throws RemoteException {
        ConnectDb connectDb = new ConnectDb();
        try {

            DriverManager.registerDriver(new Driver());
            Connection con = DriverManager.getConnection("jdbc:mysql://" + connectDb.getIp() + "/" + connectDb.getDbName() + "?" + "user=" + connectDb.getUsername() + "&password=" + connectDb.getPassword());
            Statement st = con.createStatement();
            st.executeUpdate("update users set status = '" + client.getStatus() + "' where email ='" + client.getEmail() + "'");

        } catch (SQLException ex) {
            System.out.println("can't connect to database");
        }
    }

}
