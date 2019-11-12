package com.example.test;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import static android.content.ContentValues.TAG;

public class SecondFragmentActivity extends Fragment implements View.OnClickListener {

    View view;


    RatingBar ratingBar;
    Button  button;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.activity_second_fragment,container,false);


        ratingBar =view.findViewById(R.id.ratingbar);
        button = view.findViewById(R.id.send);

        button.setOnClickListener(this);
        return view;

    }

    @Override
    public void onClick(View v) {

        String totalstar = "TOTAL STARS :"+ratingBar.getNumStars();
        String star = "RATED :"+ratingBar.getRating();
        Toast.makeText(getActivity(),totalstar+"\n"+star,Toast.LENGTH_SHORT).show();
    }
}
