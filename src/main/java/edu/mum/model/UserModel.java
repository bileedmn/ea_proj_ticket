package edu.mum.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by: Ganbat Bayar
 * On: 12/18/2018
 * Project: Ticket_Booker
 */
@XmlRootElement
public class UserModel {
    String username;
    String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
