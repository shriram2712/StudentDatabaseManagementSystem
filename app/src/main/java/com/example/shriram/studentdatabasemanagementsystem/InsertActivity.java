package com.example.shriram.studentdatabasemanagementsystem;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class InsertActivity extends AppCompatActivity {
    EditText div;
    EditText name, email, phone, address, s1,s2,s3,s4,s5;
    Button insert, reset, logout, back;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        name =(EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
         phone=(EditText) findViewById(R.id.phone);
        address = (EditText) findViewById(R.id.address);
        s1 =(EditText) findViewById(R.id.s1);
        s2 = (EditText) findViewById(R.id.s2);
        s3 =(EditText) findViewById(R.id.s3);
        s4 = (EditText) findViewById(R.id.s4);
        s5 =(EditText) findViewById(R.id.s5);
         insert = (Button) findViewById(R.id.insert);
        reset = (Button) findViewById(R.id.reset);
        logout = (Button) findViewById(R.id.logout);
        back = (Button)findViewById(R.id.back);
        div  = (EditText) findViewById(R.id.div);

        db = new DatabaseHelper(this);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nm = name.getText().toString();
                if (nm.length() == 0) {
                    name.setError("Please enter first name");
                    name.requestFocus();
                    return;
                }

                String a = "D12A";
                String b = "D12B";
                String c = "D12C";
                String dv = div.getText().toString();
                if (dv.length() == 0 ) {
                    div.setError("Please enter proper class");
                    div.requestFocus();
                    return;
                }

                String em = email.getText().toString();
                if (em.length() == 0) {
                    email.setError("Please enter E-mail address");
                    email.requestFocus();
                    return;
                }

                if (!Patterns.EMAIL_ADDRESS.matcher(em).matches()) {
                    email.setError("Please enter valid E-mail address");
                    email.requestFocus();
                    return;
                }

                String ph = phone.getText().toString();

                if (ph.length() == 0 || ph.length()!=10) {
                    phone.setError("Please enter valid phone no");
                    phone.requestFocus();
                    return; }

                String add = address.getText().toString();
                if (add.length() ==0) {
                    address.setError("Please enter the address");
                    address.requestFocus();
                    return; }

                String sem5 = s5.getText().toString();
                if (sem5.length() ==0) {
                    s5.setError("Please enter the pointer");
                    s5.requestFocus();
                    return; }
                String sem1 = s1.getText().toString();
                if (sem1.length() ==0) {
                    s1.setError("Please enter the pointer");
                    s1.requestFocus();
                    return; }
                String sem2 = s2.getText().toString();
                if (sem2.length() ==0) {
                    s2.setError("Please enter the pointer");
                    s2.requestFocus();
                    return; }
                String sem3 = s3.getText().toString();
                if (sem3.length() ==0) {
                    s3.setError("Please enter the pointer");
                    s3.requestFocus();
                    return; }
                String sem4 = s4.getText().toString();
                if (sem4.length() ==0) {
                    s4.setError("Please enter the pointer");
                    s4.requestFocus();
                    return; }

                try
                {
                    Double a1 =Double.parseDouble(sem1);
                    Double a2=Double.parseDouble(sem2);
                    Double a3=Double.parseDouble(sem3);
                    Double a4=Double.parseDouble(sem4);
                    Double a5=Double.parseDouble(sem5);
                    Double a6=Double.parseDouble(ph);

                    if(a1>10 || a2>10 || a3>10 || a4>10 || a5>10 )
                    {
                        Toast.makeText(InsertActivity.this, "Please enter ptr less than or equal to 10", Toast.LENGTH_SHORT).show();
                    }
                }
                catch (NumberFormatException ne)
                {
                    Toast.makeText(InsertActivity.this, "Please enter valid values", Toast.LENGTH_SHORT).show();
                }


                db.addStudent(nm, dv, em, ph, add, sem1, sem2, sem3, sem4, sem5 );

            }});

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(InsertActivity.this, InsertActivity.class);
                startActivity(i);
                finish();
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(InsertActivity.this, FirstPage.class);
                startActivity(i);
                finish();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(InsertActivity.this, AdminWelcomePage.class);
                startActivity(i);
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
