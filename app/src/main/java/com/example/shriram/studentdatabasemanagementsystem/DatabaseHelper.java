package com.example.shriram.studentdatabasemanagementsystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;
public class DatabaseHelper extends SQLiteOpenHelper {
    SQLiteDatabase db;
    Context context;
    public static String T1 = "d12a";
    public static String T2 = "d12b";
    public static String T3 = "d12c";

    public DatabaseHelper(Context context) {
        super(context, "data", null, 1);
        this.context = context;
        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE user_details(id INTEGER PRIMARY KEY AUTOINCREMENT,firstName TEXT,lastName TEXT,email TEXT UNIQUE,password TEXT)";
        db.execSQL(sql);
        String s2 = "CREATE TABLE admin (name TEXT, email TEXT PRIMARY KEY,id INTEGER UNIQUE, password TEXT)";
        db.execSQL(s2);
        String s3 = "CREATE TABLE d12a(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT,div TEXT,email TEXT UNIQUE,phone TEXT,address TEXT,sem1 TEXT,sem2 TEXT,sem3 TEXT, sem4 TEXT,sem5 TEXT)";
        db.execSQL(s3);
        String s4 = "CREATE TABLE d12b(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT,div TEXT,email TEXT UNIQUE,phone TEXT,address TEXT,sem1 TEXT,sem2 TEXT,sem3 TEXT, sem4 TEXT,sem5 TEXT)";
        db.execSQL(s4);
        String s5 = "CREATE TABLE d12c(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT,div TEXT,email TEXT UNIQUE,phone TEXT,address TEXT,sem1 TEXT,sem2 TEXT,sem3 TEXT, sem4 TEXT,sem5 TEXT)";
        db.execSQL(s5);
        String s6 = "INSERT INTO admin VALUES('Ramesh','admin1@gmail.com',12345,123)";
        db.execSQL(s6);
        String s7 = "INSERT INTO admin VALUES('Suresh','admin2@gmail.com',12346,123)";
        db.execSQL(s7);
        String s8 = "INSERT INTO admin VALUES('Mahesh','admin3@gmail.com',12347,123)";
        db.execSQL(s8);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS user_details");
        onCreate(db);
    }

    public void addUser(String firstName, String lastName, String email, String password) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("firstName", firstName);
        contentValues.put("lastName", lastName);
        contentValues.put("email", email);
        contentValues.put("password", password);
        long rid = db.insert("user_details", null, contentValues);
        if (rid == -1) {
            Toast.makeText(context, "Insert issue", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Registered successfully", Toast.LENGTH_SHORT).show();
        }
    }

    public String getUser(String email, String password) {
        Cursor cursor = db.rawQuery("SELECT * FROM user_details WHERE email=? AND password=?", new String[]{email, password});
        if (cursor.getCount() == 0) {
            Toast.makeText(context, "Please enter correct email/password combination", Toast.LENGTH_SHORT).show();
            return "";
        } else {
            cursor.moveToFirst();
            do {
                Toast.makeText(context, "Login successful", Toast.LENGTH_SHORT).show();
                return cursor.getString(cursor.getColumnIndex("firstName"));
            } while (cursor.moveToNext());
        }
    }

    public String getAdmin(String email, String password, String id) {
        Cursor cursor = db.rawQuery("SELECT * FROM admin WHERE email=? AND password=? AND id=?", new String[]{email, password, id});
        if (cursor.getCount() == 0) {
            Toast.makeText(context, "Please enter correct email/password/id combination", Toast.LENGTH_SHORT).show();
            return "";
        } else {
            cursor.moveToFirst();
            do {
                Toast.makeText(context, "Login successful", Toast.LENGTH_SHORT).show();
                return cursor.getString(cursor.getColumnIndex("name"));
            } while (cursor.moveToNext());
        }
    }

    public void addStudent(String name, String div, String email, String phone, String address, String sem1, String sem2, String sem3, String sem4, String sem5) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("div", div);
        contentValues.put("email", email);
        contentValues.put("phone", phone);
        contentValues.put("address", address);
        contentValues.put("sem1", sem1);
        contentValues.put("sem2", sem2);
        contentValues.put("sem3", sem3);
        contentValues.put("sem4", sem4);
        contentValues.put("sem5", sem5);

        String a = "D12A";
        String b = "D12B";
        String c = "D12C";
        if (div.contentEquals("d12a") || div.contentEquals("D12a") || div.contentEquals("d12A") || div.contentEquals("D12A")) {
            long rid = db.insert("d12a", null, contentValues);
            if (rid == -1) {
                Toast.makeText(context, "Insert issue", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "Inserted successfully", Toast.LENGTH_SHORT).show();
            }
        }

        else if (div.contentEquals("d12b") || div.contentEquals("D12b") || div.contentEquals("d12B") || div.contentEquals("D12B")) {
            long rid = db.insert("d12b", null, contentValues);
            if (rid == -1) {
                Toast.makeText(context, "Insert issue", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "Inserted successfully", Toast.LENGTH_SHORT).show();
            }
        }

        else if (div.contentEquals("d12c") || div.contentEquals("D12c") || div.contentEquals("d12C") || div.contentEquals("D12C")) {
            long rid = db.insert("d12c", null, contentValues);
            if (rid == -1) {
                Toast.makeText(context, "Insert issue", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "Inserted successfully", Toast.LENGTH_SHORT).show();
            }
        }

        else
        {
            Toast.makeText(context, "Please enter valid division", Toast.LENGTH_SHORT).show();
        }
    }

    public Cursor getAdata(){
        Cursor res = db.rawQuery("SELECT  * FROM d12a ORDER BY name",null );
        return  res;

    }

    public Cursor getBdata(){
        Cursor res = db.rawQuery("SELECT  * FROM d12b ORDER BY name",null );
        return  res;

    }

    public Cursor getCdata(){
        Cursor res = db.rawQuery("SELECT  * FROM d12c ORDER BY name",null );
        return  res;

    }



    public boolean updateStudent(String name, String div, String email, String phone, String address, String sem1, String sem2, String sem3, String sem4, String sem5) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("div", div);
        contentValues.put("email", email);
        contentValues.put("phone", phone);
        contentValues.put("address", address);
        contentValues.put("sem1", sem1);
        contentValues.put("sem2", sem2);
        contentValues.put("sem3", sem3);
        contentValues.put("sem4", sem4);
        contentValues.put("sem5", sem5);

        String a = "D12A";
        String b = "D12B";
        String c = "D12C";
        if (div.contentEquals("d12a") || div.contentEquals("D12a") || div.contentEquals("d12A") || div.contentEquals("D12A")) {
             int result  = db.update(T1,contentValues,"email=?", new String[]{email});
            if (result > 0) {
                return true;
            } else {
                return false;}
        }

        else if (div.contentEquals("d12b") || div.contentEquals("D12b") || div.contentEquals("d12B") || div.contentEquals("D12B")) {
            int result  = db.update(T2,contentValues,"email=?", new String[]{email});
            if (result > 0) {
                return true;} else {
                return false;}
        }

        else if (div.contentEquals("d12c") || div.contentEquals("D12c") || div.contentEquals("d12C") || div.contentEquals("D12C")) {
            int result = db.update(T3, contentValues, "email=?", new String[]{email});
            if (result > 0) {
                return true;
            } else {
                return false;
            }
        }

        else
            return false;
    }
    public Integer deleteData(String div, String id) {

        if (div.contentEquals("d12a") || div.contentEquals("D12a") || div.contentEquals("d12A") || div.contentEquals("D12A")) {

           int i = db.delete(T1, "id = ?", new String[]{id});
           return i;
        }
        else if (div.contentEquals("d12b") || div.contentEquals("D12b") || div.contentEquals("d12B") || div.contentEquals("D12B")) {
            int i = db.delete(T2, "id = ?", new String[]{id});
            return i;
        }
        else if (div.contentEquals("d12c") || div.contentEquals("D12c") || div.contentEquals("d12C") || div.contentEquals("D12C")) {
            int i = db.delete(T2, "id = ?", new String[]{id});
            return i;
        }
        else
            return 0;
        }
}
