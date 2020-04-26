package com.example.project411;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {

    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;

    public TextView Name;
    public TextView Password;
    public TextView Email;
    public TextView PhoneNumber;
    public Button Register;
    public Button go_to_login_but;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        // db = new DataBaseHelper(this);
        openHelper = new DataBaseHelper(this);

        Name =(EditText)findViewById(R.id.Name);
        Password =(EditText)findViewById(R.id.Password);
        Email= (EditText)findViewById(R.id.EAddress);
        PhoneNumber = (EditText)findViewById(R.id.PNumber);
        Register= (Button)findViewById(R.id.Register);
        go_to_login_but = (Button) findViewById(R.id.go_to_login_but);

        go_to_login_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity1();
            }
        });

        Register.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                db=openHelper.getWritableDatabase();
                String name=Name.getText().toString();
                String pass=Password.getText().toString();
                String email= Email.getText().toString();
                String phone=PhoneNumber.getText().toString();
                insertdata(name,pass,phone,email);
                Intent intent = new Intent(Main3Activity.this ,MainActivity.class );
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "register successfully",Toast.LENGTH_LONG).show();

            }

            public void insertdata(String name, String pass, String email, String phone) {
                ContentValues contentValues = new ContentValues();
                contentValues.put(DataBaseHelper.Col2, name);
                contentValues.put(DataBaseHelper.Col3, pass);
                contentValues.put(DataBaseHelper.Col4, email);
                contentValues.put(DataBaseHelper.Col5, phone);
                long id = db.insert(DataBaseHelper.TABLE_NAME, null, contentValues);
            }
        });



    }

    public void openActivity1(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}

