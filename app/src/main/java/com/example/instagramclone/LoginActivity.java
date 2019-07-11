package com.example.instagramclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.shashank.sony.fancytoastlib.FancyToast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtLoginEmail, edtLoginPassword;
    private Button btnLoginActivity, btnSignUpActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setTitle("Log In");

        edtLoginEmail = findViewById(R.id.edtLoginMail);
        edtLoginPassword= findViewById(R.id.edtLoginPassword);

        btnLoginActivity = findViewById(R.id.btnLoginActivity);
        btnSignUpActivity = findViewById(R.id.btnSignUpActivity);

        btnLoginActivity.setOnClickListener(this);
        btnSignUpActivity.setOnClickListener(this);

        if(ParseUser.getCurrentUser() != null){
            ParseUser.getCurrentUser().logOut();

        }


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnLoginActivity:


                if(edtLoginEmail.getText().toString().equals("") || edtLoginPassword.getText().toString().equals("")){
                    FancyToast.makeText(LoginActivity.this, "Email and Password is required!", FancyToast.LENGTH_SHORT, FancyToast.INFO, false).show();


                }else {

                    ParseUser.logInInBackground(edtLoginEmail.getText().toString(), edtLoginPassword.getText().toString(), new LogInCallback() {
                        @Override
                        public void done(ParseUser user, ParseException e) {
                            if (e == null && user!= null) {
                                FancyToast.makeText(LoginActivity.this, user.getUsername() + " is Logged In!", FancyToast.LENGTH_LONG, FancyToast.SUCCESS, false).show();
                                transitionToSocialMediaActivity();
                            } else {
                                FancyToast.makeText(LoginActivity.this, e.getMessage(), FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show();

                            }
                        }
                    });
                }

                break;
            case R.id.btnSignUpActivity:



                break;
        }
    }
    public void rootLayoutTapped(View view){
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }catch(Exception e){
            e.printStackTrace();
        }

    }
    public void transitionToSocialMediaActivity(){
        Intent intent= new Intent(LoginActivity.this, SocialMediaActivity.class);
        startActivity(intent);
    }
}
