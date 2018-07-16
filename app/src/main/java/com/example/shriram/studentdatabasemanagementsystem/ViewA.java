package com.example.shriram.studentdatabasemanagementsystem;

import android.content.Intent;
import android.database.Cursor;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ViewA extends AppCompatActivity {

    DatabaseHelper db;
    TextView t;
    Button b,logout,back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        db = new DatabaseHelper(this);
        t = (TextView) findViewById(R.id.t);
        b = (Button) findViewById(R.id.b);
        logout = (Button) findViewById(R.id.logout);
        back = (Button) findViewById(R.id.back);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = db.getAdata();
                StringBuffer stringBuffer = new StringBuffer();
                int roll = 0;
                if(res!= null && res.getCount()>0){
                    while (res.moveToNext()){
                        roll++;
                        stringBuffer.append("Roll No : " + roll + "\n");
                        stringBuffer.append("GR ID : " + res.getString(0) + "\n");
                        stringBuffer.append("Name : " + res.getString(1) + "\n");
                        stringBuffer.append("Email : " + res.getString(3) + "\n");
                        stringBuffer.append("Phone :" + res.getString(4) + "\n");
                        stringBuffer.append("Address :" + res.getString(5) + "\n");
                        stringBuffer.append("Sem 1 ptr :" + res.getString(6) + "\n");
                        stringBuffer.append("Sem 2 ptr :" + res.getString(7) + "\n");
                        stringBuffer.append("Sem 3 ptr :" + res.getString(8) + "\n");
                        stringBuffer.append("Sem 4 ptr :" + res.getString(9) + "\n");
                        stringBuffer.append("Sem 5 ptr :" + res.getString(10) + "\n" +"\n" +"\n");
                    }
                    t.setText(stringBuffer.toString());
                    Toast.makeText(ViewA.this, "Data retrieved successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ViewA.this, "No Data Found",Toast.LENGTH_SHORT).show();
                }
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(ViewA.this, FirstPage.class);
                startActivity(it);
                finish();

            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(ViewA.this, View1.class);
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
