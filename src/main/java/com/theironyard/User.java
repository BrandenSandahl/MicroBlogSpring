package com.theironyard;

/**
 * Created by branden on 3/7/16 at 13:10.
 */
public class User {


    private String userName, userPassword;


    public User(String userName) {
        this.userName = userName;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}