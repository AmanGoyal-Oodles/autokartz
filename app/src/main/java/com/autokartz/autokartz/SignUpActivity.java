package com.autokartz.autokartz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {
    EditText mFirstName;
    EditText mLastName;
    EditText mEmail;
    EditText mPhoneNumber;
    EditText mPassword;
    EditText mRePassword;
    Button mSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        init();
        mSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstname = mFirstName.getText().toString();
                String lastname = mFirstName.getText().toString();
                String email = mFirstName.getText().toString();
                String phonenumber = mFirstName.getText().toString();
                String password = mFirstName.getText().toString();
                String repassword = mFirstName.getText().toString();

                if (firstname.isEmpty()) {
                    mFirstName.setError("Enter FirstName");
                    return;
                }
                else if(lastname.isEmpty()) {
                    mLastName.setError("Enter LastName");
                    return;
                }
                if (email.isEmpty()) {
                    mEmail.setError("Enter Email");
                    return;
                }
                if (phonenumber.isEmpty()) {
                    mPhoneNumber.setError("Enter PhoneNumber");
                    return;
                }
                if (password.isEmpty()) {
                    mPassword.setError("Enter Password");
                    return;
                }
                if (repassword.isEmpty()) {
                    mRePassword.setError("Enter RePassword");
                    return;
                }
               // Toast.makeText(SignUpActivity.this, "posting", Toast.LENGTH_SHORT).show();


            }
        });


    }

    private void init() {
        mFirstName = (EditText) findViewById(R.id.et_firstname);
        mLastName = (EditText) findViewById(R.id.et_lastname);
        mEmail = (EditText) findViewById(R.id.et_email);
        mPhoneNumber = (EditText) findViewById(R.id.et_phonenumeber);
        mPassword = (EditText) findViewById(R.id.et_password);
        mRePassword = (EditText) findViewById(R.id.et_repassword);
        mSignup = (Button) findViewById(R.id.btn_signup);
    }
}
