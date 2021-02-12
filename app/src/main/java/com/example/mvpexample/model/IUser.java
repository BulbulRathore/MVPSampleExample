package com.example.mvpexample.model;

public interface IUser {
    String getEmail();
    String getPassword();

    int checkValidity(String email,String password);
}
