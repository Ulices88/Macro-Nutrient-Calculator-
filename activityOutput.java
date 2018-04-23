package edu.cis135mpcc.macros;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class activityOutput extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);



        Intent intent = getIntent();
        int fitnessValue = intent.getIntExtra("fitSpinner",0);
        int lifestyleValue = intent.getIntExtra("lifeSSpinner",0);
        int mealValue = intent.getIntExtra("mealSSpinner", 0);
        int weightValue = intent.getIntExtra(MainActivity.EXTRA_weight_input,0);




        int calories = (weightValue * fitnessValue) + (weightValue * lifestyleValue);

        double protein = calories * 0.35 / mealValue;
        double carbs = calories * 0.45 / mealValue;
        double fats = calories * 0.20 /mealValue;




        TextView nTCal = (TextView)findViewById(R.id.nTCal);
        nTCal.setText(getString(R.string.totalCaloriesText) + " "+ calories);

        TextView proMacros = (TextView)findViewById(R.id.pro_macros);
        proMacros.setText(getString(R.string.totalProteinCal) + " " + (int) protein + " Cal");

        TextView carbMacros = (TextView) findViewById(R.id.carb_macros);
        carbMacros.setText(getString(R.string.totalCarbCal) + " " + (int) carbs + " Cal");

        TextView fatMacros = (TextView) findViewById(R.id.fat_macros);
        fatMacros.setText(getString(R.string.totalFatCal) + " " +(int)fats + " Cal");




    }
}
