package com.example.test;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;

public class SharedActivity extends AppCompatActivity {

    AlertDialog alertDialog;
    AlertDialog.Builder builder;
    Button back;
    private ProgressBar progressBar;
    private int status=0;
    private TextView textv;
    private Handler handler = new Handler();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared);
        TextView textView = findViewById(R.id.textview2);
        back = findViewById(R.id.back);

        SharedPreferences sharedPreferences = getSharedPreferences("key",MODE_PRIVATE);
        String value = sharedPreferences.getString("value","");
        textView.setText(value);



        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder = new AlertDialog.Builder(SharedActivity.this,R.style.Theme_AppCompat_DayNight_Dialog_Alert);
                builder.setMessage("Yes or No");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Toast.makeText(getApplicationContext(),"Done",Toast.LENGTH_SHORT).show();

                        Intent intent =new Intent(SharedActivity.this,MainActivity.class);
                        startActivity(intent);
                    }
                });

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"Cancel",Toast.LENGTH_SHORT).show();
                    }
                });
                alertDialog = builder.create();
                alertDialog.show();

            }
        });


        progressBar = findViewById(R.id.progress_circular);
        textv = findViewById(R.id.textv);


        new Thread(new Runnable() {
            @Override
            public void run() {
                while (status<100){
                    status+=1;
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setProgress(status);
                            textv.setText(status+"/"+progressBar.getMax());
                        }
                    });
                    try {
                        Thread.sleep(200);
                    }
                    catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }).start();


    }
}
