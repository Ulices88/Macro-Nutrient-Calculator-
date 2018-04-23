package edu.cis135mpcc.macros;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    public final static String EXTRA_weight_input = "edu.cis135mpcc.macros.MainActivity";

    ArrayAdapter<CharSequence> adapter;
    private int fitnessValue = 0;
    private int lifestyleValue = 0;
    private int mealValue = 0;
    private Spinner fitnessSpinner;
    private Spinner lifestyleSpinner;
    private Spinner mealSpinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner1 = (Spinner) findViewById(R.id.fitness_menu);
        Spinner spinner2 = (Spinner) findViewById(R.id.lifeStyle_menu);
        Spinner spinner3 = (Spinner) findViewById(R.id.meal_menu);

        fitnessSpinner = spinner1;
        lifestyleSpinner = spinner2;
        mealSpinner = spinner3;


        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.fitnessGoals, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.Life_Style, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this,
                R.array.mealsArray, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        spinner1.setAdapter(adapter1);
        spinner2.setAdapter(adapter2);
        spinner3.setAdapter(adapter3);

        spinner1.setOnItemSelectedListener(this);
        spinner2.setOnItemSelectedListener(this);
        spinner3.setOnItemSelectedListener(this);

    }


    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
        if (parent == fitnessSpinner) {
            switch (pos) {
                case 0:
                    fitnessValue = 13;
                    break;
                case 1:
                    fitnessValue = 10;
                    break;
                case 2:
                    fitnessValue = 7;
                    break;
                case 3:
                    fitnessValue = 6;
                    break;


            }
        } else if (parent == lifestyleSpinner) {
            switch (pos) {
                case 0:
                    lifestyleValue = 3;
                    break;
                case 1:
                    lifestyleValue = 5;
                    break;
                case 2:
                    lifestyleValue = 10;
                    break;
            }


        }else if (parent == mealSpinner){
            switch (pos){
                case 0:
                    mealValue = 1;
                    break;
                case 1:
                    mealValue = 2;
                case 2:
                    mealValue = 3;
                    break;
                case 3:
                    mealValue = 4;
                case 4:
                    mealValue = 5;
                    break;
                case 5:
                    mealValue = 6;
                    break;
                case 6:
                    mealValue = 7;
                    break;
                case 7:
                    mealValue = 8;
                    break;
            }
        }
        Toast.makeText(this, "Fitness: " + fitnessValue + ", Lifestyle: " + lifestyleValue, Toast.LENGTH_SHORT).show();


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }


    public void submit(View view) {


        TextView weightInput = (TextView) findViewById(R.id.weight_input);

        int weightValue = Integer.parseInt(weightInput.getText().toString());
        if (weightValue == 0) {

            Toast.makeText(this, "Enter Valid Weight", Toast.LENGTH_LONG).show();

        } else {

            Intent intent = new Intent(this, activityOutput.class);
            intent.putExtra("fitSpinner", fitnessValue);
            intent.putExtra("lifeSSpinner", lifestyleValue);
            intent.putExtra("mealSSpinner", mealValue);
            intent.putExtra(EXTRA_weight_input, (weightValue));
            startActivity(intent);
        }


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about_menu:
                Intent intent = new Intent(this, aboutActivity.class);
                startActivity(intent);
                return true;


            case R.id.contact_menu:
                Intent intent1 = new Intent(this, activity_contact_me.class);
                startActivity(intent1);
                return true;

            case R.id.more_menu:
                Intent intent2 = new Intent (this, activity_more.class);
                startActivity(intent2);
                return true;

            default:
                return super.onOptionsItemSelected(item);


        }
    }

}