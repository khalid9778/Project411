
package com.example.project411;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    SQLiteDatabase db;
    SQLiteOpenHelper openHelper;
    Cursor cursor;


    public EditText Email;
    public  EditText Password;
    public  Button Login;
    public  TextView Wel;
    public Button SignUp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openHelper=new DataBaseHelper(this);
        db = openHelper.getReadableDatabase();

        Email =(EditText)findViewById(R.id.etName);
        Password =(EditText)findViewById(R.id.etPassward);
        Login = (Button)findViewById(R.id.bLogin);
        SignUp = (Button)findViewById(R.id.bNewLog);


        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = Email.getText().toString();
                String pass = Password.getText().toString();


                cursor = db.rawQuery("SELECT *FROM " + DataBaseHelper.TABLE_NAME + " WHERE " + DataBaseHelper.Col5+ "=? AND " + DataBaseHelper.Col3 + "=?", new String[]{email, pass});
                if (cursor != null) {
                    if (cursor.getCount() > 0) {
                        Intent intent = new Intent(MainActivity.this ,Main2Activity.class );
                        startActivity(intent);
                        Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_SHORT).show();

                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Login error "+cursor.getCount() , Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this ,Main3Activity.class );
                startActivity(intent);
            }
        });

    }}
