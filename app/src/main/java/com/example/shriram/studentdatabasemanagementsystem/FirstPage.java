package com.example.shriram.studentdatabasemanagementsystem;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstPage extends AppCompatActivity {

    Button btnLogin2, btnLogin1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);

        btnLogin1 = (Button) findViewById(R.id.btnLogin1);
        btnLogin2 = (Button) findViewById(R.id.btnLogin2);

        btnLogin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(FirstPage.this, AdminLogin.class);
                startActivity(it);
                finish();

            }
        });

        btnLogin2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(FirstPage.this, LoginActivity.class);
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
