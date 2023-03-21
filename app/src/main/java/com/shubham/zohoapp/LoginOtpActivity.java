package com.shubham.zohoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

public class LoginOtpActivity extends AppCompatActivity {
    EditText otpEt1,otpEt2,otpEt3,otpEt4;
    TextView resendOtpTv;
    AppCompatButton submitOtpBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_otp);

        otpEt1 = findViewById(R.id.otpEt1);
        otpEt2 = findViewById(R.id.otpEt2);
        otpEt3 = findViewById(R.id.otpEt3);
        otpEt4 = findViewById(R.id.otpEt4);

        submitOtpBtn  = findViewById(R.id.submitOtpBtn);

        resendOtpTv = findViewById(R.id.resendOtptTv);

        otpEt1.addTextChangedListener(textWatcher);
        otpEt2.addTextChangedListener(textWatcher);
        otpEt3.addTextChangedListener(textWatcher);
        otpEt4.addTextChangedListener(textWatcher);


        //Default
        showKeyBoard(otpEt1);

        //Resend Button
        resendOtpTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        submitOtpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }

    private  void showKeyBoard(EditText otpEt){
        otpEt.requestFocus();

        InputMethodManager inputMethodManager =(InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.showSoftInput(otpEt,InputMethodManager.SHOW_IMPLICIT);
    }

    private   TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}