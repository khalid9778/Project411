package com.example.project411;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

// Report Send Page

public class Main4Activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

         public Button send_but;
         public Button cancel_but ;
         public Button add_image_but;
         public TextView image_added_ar;
         public TextView image_added_en;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        Spinner spinner = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.companys_list, android.R.layout.simple_spinner_item);
           adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
           spinner.setAdapter(adapter);
           spinner.setOnItemSelectedListener(this);


           cancel_but = (Button) findViewById(R.id.cancel_but);
           cancel_but.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   openActivity2();
               }
           });

           send_but = (Button) findViewById(R.id.send_but);
           send_but.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   openActivity2();
                   for (int i=0; i < 2; i++)
                   {
                       Toast.makeText(getApplicationContext(), "تم الارسال شكرا لك", Toast.LENGTH_LONG).show();
                   }
               }
           });


           add_image_but = (Button) findViewById(R.id.add_image_but);
           add_image_but.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   openActivity8();

               }
           });





    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void openActivity2(){
        Intent intent = new Intent(this , Main2Activity.class);
        startActivity(intent);

    }

    public void openActivity8(){
        Intent intent = new Intent(this , Main8Activity.class);
        startActivity(intent);
    }
}
