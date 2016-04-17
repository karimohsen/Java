/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signinpackage;

import com.mysql.jdbc.Driver;
import commonclasses.ClientData;
import commonclasses.ClientInterface;
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
import server.ServerClass;

/**
 *
 * @author Karim
 */
public class SigninImplemention extends UnicastRemoteObject implements SigninInterface {

    ClientData temp;

    public SigninImplemention() throws RemoteException {

    }

    public int validateUserLoginData(String mail, String passwd) throws RemoteException {
        ConnectDb connectDb = new ConnectDb();
        int db_result = -2;
        temp=new ClientData();
        //-2 means server problems
        try {

            DriverManager.registerDriver(new Driver());
            Connection con = DriverManager.getConnection("jdbc:mysql://" + connectDb.getIp() + "/" + connectDb.getDbName() + "?" + "user=" + connectDb.getUsername() + "&password=" + connectDb.getPassword());
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from users where email = '" + mail + "' and passwd= '" + passwd + "'");
            
            if (rs.next()) {
                db_result = 1;
                //there is such user
                temp.setEmail(rs.getString("email"));
                temp.setUsername(rs.getString("username"));
                temp.setStatus("available");
                temp.setPasswd(rs.getString("passwd"));

            } else {
                db_result = -1;
                
                //there is no such user
            }
            if(db_result==1){
                st.executeUpdate("update users set status = 'available' where email = '" + mail + "'");
            }

        } catch (SQLException ex) {
            System.out.println("Can't connect to database server");;
        }
        return db_result;
    }

    @Override
    public void register(String mail, ClientInterface model) throws RemoteException {
        ServerClass.map1.put(mail, model);
    }

    @Override
    public ClientData getmydata(String mail) throws RemoteException {
        return temp;
    }
}
