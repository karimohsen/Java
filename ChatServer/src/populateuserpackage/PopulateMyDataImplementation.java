/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package populateuserpackage;

import com.mysql.jdbc.Driver;
import commonclasses.ClientData;
import commonclasses.PopulateMyDataInterface;
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
public class PopulateMyDataImplementation extends UnicastRemoteObject implements PopulateMyDataInterface {

    public PopulateMyDataImplementation() throws RemoteException {

    }

    @Override
    public ClientData getmydata(String mail) throws RemoteException {
        ConnectDb connectDb = new ConnectDb();
        ClientData temp = new ClientData();
        try {

            DriverManager.registerDriver(new Driver());
            Connection con = DriverManager.getConnection("jdbc:mysql://" + connectDb.getIp() + "/" + connectDb.getDbName() + "?" + "user=" + connectDb.getUsername() + "&password=" + connectDb.getPassword());
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from users where email = '" + mail + "'");
            while (rs.next()) {
                temp.setEmail(rs.getString("email"));
                temp.setUsername(rs.getString("username"));
                temp.setStatus(rs.getString("status"));
                temp.setPasswd(rs.getString("passwd"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PopulateMyDataImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return temp;
    }

}
