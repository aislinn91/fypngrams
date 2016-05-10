package com.example.aislinnmorrhouse.predictiteacs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;


public class mainactivity extends AppCompatActivity {

    //private Intent leathanachNua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainactivity);
    }
        //function that creates a new intent called cnaipeBhru(button press)
        // which directs to the new activity leathanachNua
        public void onClick(View v){
            //if view id matches button id
            if(v.getId() == R.id.button) {
                //create object of intent class taking context and new activity class
                Intent cnaipeBhru = new Intent(mainactivity.this, leathanachNua.class);

                //start activity
                startActivity(cnaipeBhru);
            }
    }
}
