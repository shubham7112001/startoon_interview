package com.shubham.zohoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class SignUpActivity extends AppCompatActivity {
    EditText usernameEt, signUpMobNoEt;
    ImageButton signUpToLoginOtpBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        usernameEt = findViewById(R.id.userNameEt);
        signUpMobNoEt = findViewById(R.id.signUpMobNoEt);
        signUpToLoginOtpBtn = findViewById(R.id.signUpToLoginOtpBtn);

        signUpToLoginOtpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUpActivity.this,LoginOtpActivity.class));
            }
        });
    }
}