package com.example.shriram.studentdatabasemanagementsystem;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText etEmail, etPassword;
    Button back, btnLogin, btnRegister;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnRegister = (Button) findViewById(R.id.btnRegister);
        back = (Button) findViewById(R.id.back);
        db = new DatabaseHelper(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = etEmail.getText().toString();
                if (email.length() == 0) {
                    etEmail.setError("Please enter E-mail address");
                    etEmail.requestFocus();
                    return;
                }
                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    etEmail.setError("Please enter valid E-mail address");
                    etEmail.requestFocus();
                    return;
                }

                String password = etPassword.getText().toString();
                if (password.length() == 0) {
                    etPassword.setError("Please enter password");
                    etPassword.requestFocus();
                    return;
                }

                String user = db.getUser(email, password);

                if (user.length() != 0) {
                    Intent i = new Intent(LoginActivity.this, LoginSuccessActivity.class);
                    i.putExtra("user", user);
                    startActivity(i);
                    finish();
                }
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
                                           @Override
                                           public void onClick(View v) {
                                               Intent it = new Intent(LoginActivity.this, MainActivity.class);
                                               startActivity(it);
                                               finish();

                                           }
                                       }

        );

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(LoginActivity.this, FirstPage.class);
                startActivity(it);
                finish();

            }
        });
    }

    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }
}
