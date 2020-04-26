package com.example.project411;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main7Activity extends AppCompatActivity {

    private Button back_but ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);


        back_but = (Button) findViewById(R.id.back_but);
        back_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity6();
            }
        });


    }

    public void openActivity6(){
        Intent intent = new Intent(this, Main6Activity.class);
        startActivity(intent);
    }
}
