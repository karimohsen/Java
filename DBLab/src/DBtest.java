
import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Karim
 */
public class DBtest {
    public static void main(String[] args){
        new DBtest();
    }
    public DBtest(){
        try {
            DriverManager.registerDriver(new Driver());
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost/javadb?"+"user=root&password=root");
            Statement st = con.createStatement();
           String sql="Insert into employee values (3,'karim')";
            st.executeUpdate(sql);
            sql="Insert into employee values (4,'mostafa')";
           st.executeUpdate(sql);
            sql="delete from employee where id =  1";
            st.executeUpdate(sql);
            sql = "update employee set name= 'ali' where id = 2";
            st.executeUpdate(sql);
            sql="select * from employee";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                System.out.println("name is "+rs.getString("name"));
                System.out.println("id is "+rs.getInt("id"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBtest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
