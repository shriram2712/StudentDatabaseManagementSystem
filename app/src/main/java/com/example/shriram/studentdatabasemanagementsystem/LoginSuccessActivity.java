package com.example.shriram.studentdatabasemanagementsystem;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LoginSuccessActivity extends AppCompatActivity {

    TextView tvMsg;
    Button btnLogOut, view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_success);

        tvMsg = (TextView) findViewById(R.id.tvMsg);
        btnLogOut = (Button) findViewById(R.id.btnLogOut);
        view = (Button) findViewById(R.id.view);
        Intent i = getIntent();
        String user = i.getStringExtra("user");

        tvMsg.setText("Welcome: " + user);
        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(LoginSuccessActivity.this, LoginActivity.class);
                startActivity(it);
                finish();

            }});

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(LoginSuccessActivity.this, View1.class);
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
