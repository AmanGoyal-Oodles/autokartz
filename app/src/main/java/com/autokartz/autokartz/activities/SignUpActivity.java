package com.autokartz.autokartz.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.autokartz.autokartz.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUpActivity extends AppCompatActivity {
    private static final String TAG = "signuperror";
    EditText mFirstName;
    EditText mLastName;
    EditText mEmail;
    EditText mPhoneNumber;
    EditText mPassword;
    EditText mRePassword;
    Button mSignup;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        init();
        mAuth = FirebaseAuth.getInstance();
        mSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignIn();
            }
        });

    }

    private void SignIn() {
        String firstname = mFirstName.getText().toString().trim();
        String lastname = mLastName.getText().toString().trim();
        String email = mEmail.getText().toString().trim();
        String phonenumber = mPhoneNumber.getText().toString().trim();
        String password = mPassword.getText().toString().trim();
        String repassword = mRePassword.getText().toString().trim();

        if (TextUtils.isEmpty(firstname)) {
            mFirstName.setError("Enter firstname");
            return;
        }

        if (TextUtils.isEmpty(lastname)) {
            mLastName.setError("Enter lastname");
            return;
        }

        if (TextUtils.isEmpty(email)) {
            mEmail.setError("Enter email");
            return;
        }

        if (TextUtils.isEmpty(password)) {
            mPassword.setError("Enter password");
            return;
        }
        if (TextUtils.isEmpty(repassword)) {
            mRePassword.setError("Enter repassword");
            return;
        }
        if (password.length() < 6) {
            Toast.makeText(getApplicationContext(), "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(phonenumber) || !(phonenumber.length() == 10)) {
            mPhoneNumber.setError(" Enter valid 10 digit phone number ");
            return;

        }
        if (!password.equals(repassword)) {
            AlertDialog.Builder alertBuilder = new AlertDialog.Builder(SignUpActivity.this);
            alertBuilder.setMessage("password does not match");
            alertBuilder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    return;
                }
            });
            alertBuilder.show();
            return;
        }
        if (!isValidEmail(email)) {
            Snackbar snackbar = Snackbar
                    .make(findViewById(R.id.relativeLayout), "Invalid Email Addresss", Snackbar.LENGTH_LONG);
            snackbar.show();

        }


        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            Snackbar snackbar = Snackbar
                                    .make(findViewById(R.id.relativeLayout), "Successfully Registered", Snackbar.LENGTH_LONG);
                            snackbar.show();
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Snackbar snackbar = Snackbar
                                    .make(findViewById(R.id.relativeLayout), "Registration Failed", Snackbar.LENGTH_LONG);
                            snackbar.show();
                            updateUI(null);
                        }

                        // ...
                    }
                });

    }

    private boolean isValidEmail(String email) {
        if (!TextUtils.isEmpty(email)) {
            return Patterns.EMAIL_ADDRESS.matcher(email).matches();
        }
        return false;
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }

    private void updateUI(FirebaseUser currentUser) {
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
