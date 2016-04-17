/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package signoutclass;

import com.mysql.jdbc.Driver;
import commonclasses.SignoutInterface;
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
import server.ServerClass;

/**
 *
 * @author Karim
 */
public class SignoutImplementation extends UnicastRemoteObject implements SignoutInterface{
    public SignoutImplementation()throws RemoteException{
        
    }

    @Override
    public void signout(String mail) throws RemoteException {
        ConnectDb connectDb = new ConnectDb();
        try {
            
            DriverManager.registerDriver(new Driver());
            Connection con = DriverManager.getConnection("jdbc:mysql://"+connectDb.getIp()+"/"+connectDb.getDbName()+"?" + "user="+connectDb.getUsername()+"&password="+connectDb.getPassword());
            Statement st = con.createStatement();
            st.executeUpdate("update users set status = 'offline' where email='" + mail + "'");
               ServerClass.map1.remove(ServerClass.map1.get(mail));
        } catch (SQLException ex) {
            Logger.getLogger(SignoutImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
