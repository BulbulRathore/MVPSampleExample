package com.example.mvpexample.presenter;

import com.example.mvpexample.model.IUser;
import com.example.mvpexample.model.User;
import com.example.mvpexample.view.ILoginView;

public class LoginPresenter implements IPresenter {
    private IUser userRef;
    private ILoginView iLoginView;

    public LoginPresenter(ILoginView view){
        this.iLoginView = view;
    }

    @Override
    public void doLogin(String email, String password) {
        userRef = new User(email,password);
        int result = userRef.checkValidity(email,password);

        iLoginView.onLoginResult(result == 0,email,password);
    }
}
