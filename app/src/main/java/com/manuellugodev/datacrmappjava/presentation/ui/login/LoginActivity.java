package com.manuellugodev.datacrmappjava.presentation.ui.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.manuellugodev.datacrmappjava.R;
import com.manuellugodev.datacrmappjava.data.repository.LoginRepository;
import com.manuellugodev.datacrmappjava.data.repository.LoginRepositoryImpl;
import com.manuellugodev.datacrmappjava.databinding.ActivityLoginBinding;
import com.manuellugodev.datacrmappjava.domain.login.Token;
import com.manuellugodev.datacrmappjava.framework.DataCrmAppJava;
import com.manuellugodev.datacrmappjava.presentation.ui.contacts.MainActivity;

import javax.inject.Inject;
import javax.inject.Named;

public class LoginActivity extends AppCompatActivity implements LoginContracts.view{


    @Inject
    @Named("loginRepository")
    LoginRepository repository;

    private ActivityLoginBinding loginBinding;

    LoginContracts.presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((DataCrmAppJava)getApplicationContext()).getAppComponent().inject(this);

        loginBinding=ActivityLoginBinding.inflate(getLayoutInflater());

        presenter=new LoginPresenter(this,repository);



        View view= loginBinding.getRoot();


        setContentView(view);

        loginBinding.login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getToken();
            }
        });
    }

    private void getToken(){
        String userName=loginBinding.username.getText().toString();
        presenter.sendRequestToken(userName);
    }

    @Override
    public void sendLogin(Token token) {
        String userName=loginBinding.username.getText().toString();
        String password=loginBinding.password.getText().toString();

        presenter.sendLoginPresenter(userName,password,token.getToken());

    }

    @Override
    public void navigateToContacts(String userSessionName) {

        Intent intent=new Intent(this, MainActivity.class);

        intent.putExtra("sessionName",userSessionName);

        startActivity(intent);
    }

    @Override
    public void showError(String error) {

        Toast.makeText(this,error,Toast.LENGTH_LONG).show();

    }

    @Override
    public void showProgress() {
        loginBinding.loading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        loginBinding.loading.setVisibility(View.GONE);
    }
}