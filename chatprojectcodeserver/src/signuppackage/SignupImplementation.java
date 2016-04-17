/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signuppackage;

import com.mysql.jdbc.Driver;
import commonclasses.ClientData;
import commonclasses.SignupInterface;
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
public class SignupImplementation extends UnicastRemoteObject implements SignupInterface {

    public SignupImplementation() throws RemoteException {

    }

    public int validateUserSignupData(ClientData client) throws RemoteException {
        ConnectDb connectDb = new ConnectDb();
        int db_result = -2;
        //-2 means server problems
        try {

            DriverManager.registerDriver(new Driver());
            Connection con = DriverManager.getConnection("jdbc:mysql://" + connectDb.getIp() + "/" + connectDb.getDbName() + "?" + "user=" + connectDb.getUsername() + "&password=" + connectDb.getPassword());
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from users where email = '" + client.getEmail() + "'");
            if (!rs.first()) {
                //means there is no such mail in database so you can use this mail
                db_result = 1;
                st.executeUpdate("insert into users (email,passwd,username) VALUES ('" + client.getEmail() + "','" + client.getPasswd() + "','" + client.getUsername() + "')");
            } else {
                db_result = -1;
            }

        } catch (SQLException ex) {
            System.out.println("can't connect to database");
        }
        return db_result;
    }
}
