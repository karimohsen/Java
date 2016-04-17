/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package serverpackage;

import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Karim
 */
public class EmpDb extends UnicastRemoteObject implements DbInterface {

    public EmpDb() throws RemoteException {
    }

    public void writetodb(Emp e) throws RemoteException {
        try {
            DriverManager.registerDriver(new Driver());
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test?" + "user=root&password=root");
            Statement st = con.createStatement();
            String sql = "Insert into emp values(" + e.getId() + ",'" + e.getName() + "','" + e.getAdd() + "')";
            st.executeUpdate(sql);

        } catch (SQLException ex) {
            System.out.println("Can't Connect to Db");
        }

    }

    public Emp readfromdb(int i) throws RemoteException {
        Emp e = new Emp();
        try {

            DriverManager.registerDriver(new Driver());
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test?" + "user=root&password=root");
            Statement st = con.createStatement();
            String sql = "select * from  emp where id = " + i;
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                e.setName(rs.getString("name"));
                e.setadd(rs.getString("address"));
            }
            e.setId(i);
        } catch (SQLException ex) {
            System.out.println("Error connect db");
        }
        return e;
    }
}
