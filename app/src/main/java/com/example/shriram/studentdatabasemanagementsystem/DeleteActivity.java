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

public class DeleteActivity extends AppCompatActivity {

    EditText div,id;
    Button delete, reset, logout, back;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        div =(EditText) findViewById(R.id.div);
        id =(EditText) findViewById(R.id.id);
        delete = (Button) findViewById(R.id.delete);
        reset = (Button) findViewById(R.id.reset);
        logout = (Button)findViewById(R.id.logout);
        back = (Button) findViewById(R.id.back);
        db = new DatabaseHelper(this);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dv = div.getText().toString();
                if (dv.length() == 0) {
                    div.setError("Please enter division");
                    div.requestFocus();
                    return;
                }

                String i = id.getText().toString();
                if (i.length() == 0) {
                    id.setError("Please enter ID");
                    id.requestFocus();
                    return;
                }


                int result = db.deleteData(dv, i);
                Toast.makeText(DeleteActivity.this, result + "  Rows Deleted" ,Toast.LENGTH_SHORT).show();

            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(DeleteActivity.this, DeleteActivity.class);
                startActivity(i);
                finish();
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(DeleteActivity.this, FirstPage.class);
                startActivity(i);
                finish();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(DeleteActivity.this, AdminWelcomePage.class);
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
