package com.example.project411;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Objects;

public class Main8Activity extends AppCompatActivity {

    private Button back_but;
    public Button choose_but;
    public ImageView view_image;
    public Button submit_but;
    public TextView text1 ;
    public TextView text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);

        back_but = (Button) findViewById(R.id.back_but_activity8);
        back_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity4();
            }
        });

        choose_but = (Button) findViewById(R.id.choose_but);
        choose_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");

                startActivityForResult(Intent.createChooser(intent , "Pick an image"), 1);

            }
        });


        submit_but = (Button) findViewById(R.id.submit_but);
        submit_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity4_2();
                for (int i=0; i < 2; i++)
                {
                    Toast.makeText(getApplicationContext(), "Image added", Toast.LENGTH_LONG).show();
                }
            }
        });


    }
    public void openActivity4(){
        Intent intent = new Intent(this, Main4Activity.class);
        startActivity(intent);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == 1) {

            view_image = (ImageView) findViewById(R.id.view_choose_image);

            try {
                InputStream inputStream = getContentResolver().openInputStream(data.getData());

                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                view_image.setImageBitmap(bitmap);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }

    }

    public void openActivity4_2(){
        Intent intent = new Intent(this, Main4Activity.class);
        startActivity(intent);
    }
}
