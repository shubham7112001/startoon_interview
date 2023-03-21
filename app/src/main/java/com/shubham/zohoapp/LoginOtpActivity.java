package com.shubham.zohoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class LoginOtpActivity extends AppCompatActivity {
    EditText otpEt1,otpEt2,otpEt3,otpEt4;
    TextView resendOtpTv;
    ImageButton backBtn;
    AppCompatButton submitOtpBtn;

    int selectedTextEtPosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_otp);

        otpEt1 = findViewById(R.id.otpEt1);
        otpEt2 = findViewById(R.id.otpEt2);
        otpEt3 = findViewById(R.id.otpEt3);
        otpEt4 = findViewById(R.id.otpEt4);

        backBtn = findViewById(R.id.backBtn);

        submitOtpBtn  = findViewById(R.id.submitOtpBtn);

        resendOtpTv = findViewById(R.id.resendOtptTv);

        otpEt1.addTextChangedListener(textWatcher);
        otpEt2.addTextChangedListener(textWatcher);
        otpEt3.addTextChangedListener(textWatcher);
        otpEt4.addTextChangedListener(textWatcher);


        //Default
        showKeyBoard(otpEt1);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginOtpActivity.this, SignUpActivity.class));
            }
        });

        //Resend Button
        resendOtpTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        submitOtpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String generateOtp = otpEt1.getText().toString()+otpEt2.getText().toString()+otpEt3.getText().toString()+otpEt4.getText().toString();

                if(generateOtp.length() == 4){
                    // Otp Verification Handle
                }
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
            if(s.length() > 0){
                if(selectedTextEtPosition == 0){
                    selectedTextEtPosition = 1;
                    showKeyBoard(otpEt2);
                }else if(selectedTextEtPosition == 1){
                    selectedTextEtPosition = 2;
                    showKeyBoard(otpEt3);
                }
                else if(selectedTextEtPosition == 2){
                    selectedTextEtPosition = 3;
                    showKeyBoard(otpEt4);
                }
            }

        }
    };

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event){

        if(keyCode == KeyEvent.KEYCODE_DEL){
            if(selectedTextEtPosition == 3){
                selectedTextEtPosition = 2;
                otpEt4.getText().clear();
                showKeyBoard(otpEt3);
            }
            else if(selectedTextEtPosition == 2){
                selectedTextEtPosition = 1;
                otpEt3.getText().clear();
                showKeyBoard(otpEt2);
            }else if(selectedTextEtPosition == 1){
                selectedTextEtPosition = 0;
                otpEt2.getText().clear();
                showKeyBoard(otpEt1);
            }
            return true;
        }
        else return super.onKeyUp(keyCode,event);
    }
}