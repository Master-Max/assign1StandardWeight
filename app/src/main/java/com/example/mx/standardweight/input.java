package com.example.mx.standardweight;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import static com.example.mx.standardweight.R.id.btCalc;
import static com.example.mx.standardweight.R.id.rbFemale;
import static com.example.mx.standardweight.R.id.rbMale;
import static com.example.mx.standardweight.R.id.rgGenders;
import static com.example.mx.standardweight.R.id.etFeet;
import static com.example.mx.standardweight.R.id.etInch;

public class input extends AppCompatActivity {
    RadioGroup rgG;
    RadioButton rbM;
    RadioButton rbF;
    EditText etF;
    EditText etI;

    int feet = 0;
    int inches = 0;
    int gender = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        rgG = (RadioGroup) findViewById(rgGenders);
        rbM = (RadioButton) findViewById(rbMale);
        rbF = (RadioButton) findViewById(rbFemale);
        etF = (EditText) findViewById(etFeet);
        etI = (EditText) findViewById(etInch);

        //Calculate Button Launches Next Screen
        Button calc = (Button) findViewById(btCalc);
        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                feet = getFeet();
                inches = getInches();
                gender = getGender();

                System.out.println("F: " + feet);
                System.out.println("I: " + inches);
                System.out.println("G: " + gender);

                Intent startIntent = new Intent(getApplicationContext(), results.class);
                startIntent.putExtra("feet", feet);
                startIntent.putExtra("inches", inches);
                startIntent.putExtra("gender", gender);
                startActivity(startIntent);
            }
        });
/*
        rgG.setOnCheckedChangeListener(new View.OnContextClickListener(){
            @Override
            public void onContextClick(View v){

            }
        });*/

    }

    public int getFeet(){
        if(etF.getText().toString().matches("")){
            Toast.makeText(this,"Enter Feet", Toast.LENGTH_SHORT).show();
            return 0;
        }else{
            return Integer.parseInt(etF.getText().toString());
        }
    }
    public int getInches(){
        if(etI.getText().toString().matches("")){
            return 0;
        }else{
            return Integer.parseInt(etI.getText().toString());
        }
    }
    public int getGender(){
        int selID = rgG.getCheckedRadioButtonId();
        int mID = rbM.getId();
        int fID = rbF.getId();
        System.out.printf("selID: %d mID: %d fID: %d\n", selID, mID, fID);

        if(selID == mID){
            return 1;
        }else if(selID == fID){
            return 2;
        }else{
            return 0;
        }
    }
   /* public int getGender(View v){
        int gender = 0;
        boolean checked = ((RadioButton) v).isChecked();

        switch(v.getId()){
            case R.id.rbMale:
                if(checked)
                    gender = 1;
                break;
            case R.id.rbFemale:
                if(checked)
                    gender = 2;
                break;
        }
        return gender;
    }*/
}
