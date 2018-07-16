package com.example.shriram.studentdatabasemanagementsystem;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AdminWelcomePage extends AppCompatActivity {

    Button insert,update, delete, view, btnLogOut;
    TextView userprompt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_welcome_page);

        insert = (Button) findViewById(R.id.insert);
        view = (Button) findViewById(R.id.view);
        delete = (Button) findViewById(R.id.delete);
        update = (Button) findViewById(R.id.update);
        btnLogOut = (Button) findViewById(R.id.btnLogOut);
        userprompt2 = (TextView) findViewById(R.id.userprompt2);

        Intent i = getIntent();
        String user = i.getStringExtra("user");
        if(user == null)
            userprompt2.setText("Welcome: ADMIN ");
        else
            userprompt2.setText("Welcome: " + user);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(AdminWelcomePage.this, InsertActivity.class);
                startActivity(it);
                finish();

            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(AdminWelcomePage.this, View1.class);
                startActivity(it);
                it.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                finish();

            }

        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(AdminWelcomePage.this, UpdateActivity.class);
                startActivity(it);
                finish();

            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(AdminWelcomePage.this, DeleteActivity.class);
                startActivity(it);
                finish();

            }
        });

        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(AdminWelcomePage.this, FirstPage.class);
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
