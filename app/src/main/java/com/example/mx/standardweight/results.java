package com.example.mx.standardweight;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class results extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        Intent input = getIntent();

        int gender = input.getIntExtra("gender", 0);
        int feet = input.getIntExtra("feet", 0);
        int inches = input.getIntExtra("inches", 0);

        System.out.println("Results: G-"+gender+" F/I-"+feet+"/"+inches);
    }
}
