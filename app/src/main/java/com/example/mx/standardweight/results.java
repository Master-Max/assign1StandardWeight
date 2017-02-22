package com.example.mx.standardweight;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class results extends AppCompatActivity {
    String gend;
    int gender = 0;
    int feet = 0;
    int inches = 0;
    double weight = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        Intent input = getIntent();

        gender = input.getIntExtra("gender", 0);
        feet = input.getIntExtra("feet", 0);
        inches = input.getIntExtra("inches", 0);

        if(gender == 1){
            gend = "Male";
            weight = getMW();
        }else if(gender == 2){
            gend = "Female";
            weight = getFW();
        }

        TextView rG = (TextView) findViewById(R.id.rGender);
        TextView rH = (TextView) findViewById(R.id.rHeight);
        TextView rW = (TextView) findViewById(R.id.rWeight);

        rG.setText(gend);
        rH.setText(feet+"\'"+inches+"\"");
        rW.setText(""+weight);


        //System.out.println("Results: G-"+gender+" F/I-"+feet+"/"+inches);
    }

    public double getFW(){
        double fw = 45.5 + (2.3*(((feet*12)+inches)-60));
        fw = roundOff(fw);
        return fw;
    }
    public double getMW(){
        double mw = 50 + (2.3*(((feet*12)+inches)-60));
        mw = roundOff(mw);
        return mw;
    }
    double roundOff(double a) {
        a = Math.round(a * 100.0)/100.0;
        return a;
    }
}
