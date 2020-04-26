package com.example.project411;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

// Profile Page

public class Main6Activity extends AppCompatActivity {

      private Button back_but;
      private Button old_myreport_but;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        back_but = (Button) findViewById(R.id.back_but_for_Profile_page);
        back_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });


        old_myreport_but = (Button) findViewById(R.id.old_myreport_but);
        old_myreport_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity7();
            }
        });

    }

    public void openActivity2(){
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }

    public void openActivity7(){
        Intent intent = new Intent(this, Main7Activity.class);
        startActivity(intent);
    }
}
