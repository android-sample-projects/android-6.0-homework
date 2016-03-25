package com.example.robertpc.homework;

import java.io.Serializable;

/**
 * Created by Robert PC on 3/21/2016.
 */
public class User implements Serializable {
    private String email;
    private String password;

    protected User(){}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
