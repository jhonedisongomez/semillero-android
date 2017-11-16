package com.coapps.semillero.domain.model;

/**
 * Created by jhon on 11/11/2017.
 */

public class User {

    private String username;
    private String password1;
    private String email;
    private String password2;
    private String firstName;
    private String lastName;
    private String key;

    public User(String username, String password1){

        this.username = username;
        this.password1 = password1;
    }

    //constructor to register the user
    public User(String username,String email, String password1, String password2){

        this.email = email;
        this.password1 = password1;
        this.password2 = password2;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
