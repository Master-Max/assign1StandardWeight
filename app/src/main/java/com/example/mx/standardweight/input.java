package com.example.mx.standardweight;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import static com.example.mx.standardweight.R.id.btCalc;
import static com.example.mx.standardweight.R.id.rgGenders;
import static com.example.mx.standardweight.R.id.etFeet;
import static com.example.mx.standardweight.R.id.etInch;

public class input extends AppCompatActivity {
    RadioGroup rgG;
    EditText etF;
    EditText etI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        rgG = (RadioGroup) findViewById(rgGenders);
        etF = (EditText) findViewById(etFeet);
        etI = (EditText) findViewById(etInch);

        //Calculate Button Launches Next Screen
        Button calc = (Button) findViewById(btCalc);
        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int feet = getFeet();
                int inches = getInches();
                int gender = getGender(v);

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
    }

    public int getFeet(){
        return Integer.parseInt(etF.getText().toString());
    }
    public int getInches(){
        return Integer.parseInt(etI.getText().toString());
    }
    public int getGender(View v){
        int gender = 0;
        boolean checked = ((RadioButton) v).isChecked();

        switch(v.getId()){
            case R.id.rbMale:
                if(checked)
                    gender = 0;
                break;
            case R.id.rbFemale:
                if(checked)
                    gender = 1;
                break;
        }
        return gender;
    }
}
