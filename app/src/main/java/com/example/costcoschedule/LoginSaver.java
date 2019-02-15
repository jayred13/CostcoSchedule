package com.example.costcoschedule;

public class LoginSaver {
    private String username;
    private String password;

    public LoginSaver(){}
    public LoginSaver(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }


}
