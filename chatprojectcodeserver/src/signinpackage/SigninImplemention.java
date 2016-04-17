/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signinpackage;

import com.mysql.jdbc.Driver;
import commonclasses.ClientData;
import commonclasses.SigninInterface;
import dbconnections.ConnectDb;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Vector;

/**
 *
 * @author Karim
 */
public class SigninImplemention extends UnicastRemoteObject implements SigninInterface {
    public static HashMap<String,ClientData> registeredusers = new HashMap<String, ClientData>();
    public SigninImplemention() throws RemoteException {

    }

    public int validateUserLoginData(ClientData cd) throws RemoteException {
        ConnectDb connectDb = new ConnectDb();
        int db_result = -2;
        //-2 means server problems
        try {

            DriverManager.registerDriver(new Driver());
            Connection con = DriverManager.getConnection("jdbc:mysql://"+connectDb.getIp()+"/"+connectDb.getDbName()+"?" + "user="+connectDb.getUsername()+"&password="+connectDb.getPassword());
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from users where email = '" + cd.getEmail() + "' and passwd= '" + cd.getPasswd() + "'");
            if (rs.first()) {
                db_result = 1;
                //there is such user
                registeredusers.put(cd.getEmail(), cd);
            } else {
                db_result = -1;
                //there is no such user
            }

        } catch (SQLException ex) {
            System.out.println("Can't connect to database server");;
        }
        return db_result;
    }
}
