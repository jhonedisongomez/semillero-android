package com.coapps.semillero.domain.model;

/**
 * Created by jhon on 11/11/2017.
 */

public class User {

    private String username;
    private String password;
    private String key;

    //TODO:crear el resto de las variables como son el email y los passwords

    public User(String username, String password){

        this.username = username;
        this.password = password;
    }

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

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
