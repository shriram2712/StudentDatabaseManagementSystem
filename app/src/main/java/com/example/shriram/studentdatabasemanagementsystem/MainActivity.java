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

public class MainActivity extends AppCompatActivity {
    EditText etFirstName, etLastName, etEmail, etPassword, etPassword1;
    Button btnRegister, btnLogin, back;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etFirstName = (EditText) findViewById(R.id.etFirstName);
        etLastName = (EditText) findViewById(R.id.etLastName);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etPassword1 = (EditText) findViewById(R.id.etPassword1);
        btnRegister = (Button) findViewById(R.id.btnRegister);
        btnLogin = (Button) findViewById(R.id.btnLogin);

        db = new DatabaseHelper(this);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String firstName = etFirstName.getText().toString();
                if (firstName.length() == 0) {
                    etFirstName.setError("Please enter first name");
                    etFirstName.requestFocus();
                    return;
                }

                String lastName = etLastName.getText().toString();
                if (lastName.length() == 0) {
                     etLastName.setError("Please enter last name");
                    etLastName.requestFocus();
                    return;
                }

                String email = etEmail.getText().toString();
                if (email.length() == 0) {
                    etEmail.setError("Please enter E-mail address");
                    etEmail.requestFocus();
                    return;
                }


                String password = etPassword.getText().toString();
                if (password.length() == 0) {
                    etPassword.setError("Please enter password");
                    etPassword.requestFocus();
                    return; }
                String password1 = etPassword1.getText().toString();
                if (!password1.contentEquals(password)) {
                    etPassword1.setError("Please enter the same password in both fields");
                    etPassword1.requestFocus();
                    return; }

                db.addUser(firstName, lastName, email, password);
            }});

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(i);
                finish();
            }}); }

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
    }}
