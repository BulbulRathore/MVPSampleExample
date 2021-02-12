package com.example.mvpexample.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mvpexample.R;
import com.example.mvpexample.presenter.IPresenter;
import com.example.mvpexample.presenter.LoginPresenter;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity implements ILoginView{

    private TextInputLayout email;
    private TextInputLayout password;
    private Button signInBtn;
    private TextView txtData;

    private String strEmail;
    private String strPassword;

    private IPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        signInBtn.setOnClickListener(v -> {
            strEmail = email.getEditText().getText().toString();
            strPassword = password.getEditText().getText().toString();
            presenter.doLogin(strEmail,strPassword);
        });
    }

    private void initView() {
        email = findViewById(R.id.txt_email);
        password = findViewById(R.id.txt_password);
        signInBtn = findViewById(R.id.sign_in);
        txtData = findViewById(R.id.txt_data);
        presenter = new LoginPresenter(this);
    }

    @Override
    public void onLoginResult(boolean result, String email, String password) {

        if (result)
            txtData.setText("Email : " + email +"\n Password : " + password);
        else
            txtData.setText("Login details are not valid, try again!!!");
    }
}