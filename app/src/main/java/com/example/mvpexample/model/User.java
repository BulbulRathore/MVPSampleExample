package com.example.mvpexample.model;

public class User implements IUser{
   private final String email;
    private final String password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }


    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public int checkValidity(String email, String password) {
        if (email.equals("") || password.equals(""))
            return -1;
        return 0;
    }
}
