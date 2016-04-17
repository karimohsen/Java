/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbconnections;

/**
 *
 * @author Karim
 */
public class ConnectDb {

    private final String ip = "localhost";
    private final String dbName = "chatdb";
    private final String username = "root";
    private final String password = "root";

    public String getIp() {
        return ip;
    }

    public String getDbName() {
        return dbName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}
