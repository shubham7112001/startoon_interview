package com.shubham.zohoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    LinearLayout newUserSignUp;
    EditText loginTOMobileEt;
    ImageButton loginToOtpBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        newUserSignUp = findViewById(R.id.newUserSignUp);
        loginTOMobileEt = findViewById(R.id.loginMobileEt);
        loginToOtpBtn = findViewById(R.id.loginToOtpBtn);

        newUserSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,SignUpActivity.class));
                finishAffinity();
            }
        });

        loginToOtpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(loginTOMobileEt.length() == 10){

                    startActivity(new Intent(LoginActivity.this,LoginOtpActivity.class));
                    finishAffinity();
                }
                else Toast.makeText(LoginActivity.this,"Please Enter 10 digit Mobile Number",Toast.LENGTH_SHORT);

            }
        });
    }
}