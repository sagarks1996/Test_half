package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    CheckBox c,java;
    Button button;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        c = findViewById(R.id.c1);
        java = findViewById(R.id.c2);

        button = findViewById(R.id.button3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder result = new StringBuilder();
                result.append("Selected Subjects:");
                if (c.isChecked()){
                    result.append("\n C++");
                }
                if (java.isChecked()){
                    result.append("\n Java");
                }
                //textView.setText(result.toString());
                Toast.makeText(getApplicationContext(),result.toString(),Toast.LENGTH_SHORT).show();
            }
        });


        Spinner spinner =findViewById(R.id.spin);
        spinner.setOnItemSelectedListener(this);
        List<String> list =new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,list);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);



        Toolbar toolbar = findViewById(R.id.tools);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu1:

                Intent intent1 = new Intent(MainActivity.this,FragmentActivity.class);
                startActivity(intent1);
                //Toast.makeText(getApplicationContext(),"Menu1",Toast.LENGTH_SHORT).show();
                break;

            case R.id.menu2:
                Toast.makeText(getApplicationContext(),"Menu2",Toast.LENGTH_SHORT).show();
                break;
            default:return super.onOptionsItemSelected(item);


        }return true;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


        textView = findViewById(R.id.textview1);
        String string = parent.getItemAtPosition(position).toString();
        textView.setText("Selected Number: "+string);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
