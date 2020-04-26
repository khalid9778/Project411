package com.example.project411;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


// Home Page

public class Main2Activity extends AppCompatActivity {

     private Button button2 ;
     private Button menu_but ;
     private Button profile_but;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        button2 = (Button) findViewById(R.id.add_report_but);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActiviy4();

            }
        });

        menu_but = (Button) findViewById(R.id.menu_but);
        menu_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity5();
            }
        });

        profile_but = (Button) findViewById(R.id.profile_but);
        profile_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity6();
            }
        });
    }

    public void openActiviy4(){
        Intent intent = new Intent(this, Main4Activity.class);
        startActivity(intent);
    }
    public void openActivity5(){
        Intent intent = new Intent(this, Main5Activity.class);
        startActivity(intent);
    }
    public void openActivity6(){
        Intent intent = new Intent(this, Main6Activity.class);
        startActivity(intent);
    }
}
