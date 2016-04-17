/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commonclasses;

import java.io.Serializable;

/**
 *
 * @author Karim
 */

/*
 this class contains all the user's data 
 */
public class ClientData implements Serializable {

    private String username;
    private String passwd;
    private String email;
    private String status;

    public void setUsername(String u_name) {
        username = u_name;
    }

    public void setPasswd(String pswd) {
        passwd = pswd;
    }

    public void setEmail(String mail) {
        email = mail;
    }

    public void setStatus(String state) {
        status = state;
    }

    public String getUsername() {
        return username;
    }

    public String getPasswd() {
        return passwd;
    }

    public String getEmail() {
        return email;
    }

    public String getStatus() {
        return status;
    }
}
