package com.example.test;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class FirstFragmentActivity extends Fragment implements View.OnClickListener{

    View view;
    EditText editText;
   // Button button;

   SharedPreferences sharedPreferences;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_first_fragment,container,false);


        editText = view.findViewById(R.id.edittext1);
        Button button = view.findViewById(R.id.button4);


        button.setOnClickListener(this);
        return view;

    }


    @Override
    public void onClick(View v) {

        String value = editText.getText().toString().trim();
        sharedPreferences = getActivity().getSharedPreferences("key",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("value",value);
        editor.apply();
        Intent i= new Intent(getActivity(),SharedActivity.class);
        startActivity(i);

    }
}
