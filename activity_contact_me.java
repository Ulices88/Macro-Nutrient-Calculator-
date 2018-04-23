package edu.cis135mpcc.macros;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class activity_contact_me extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_me);
    }

     public void dismiss (View view) { this.finish();}
}
