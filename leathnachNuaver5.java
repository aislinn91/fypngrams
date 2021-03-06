package com.example.aislinnmorrhouse.predictiteacs;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class leathanachNua extends AppCompatActivity {

    //Creating a button variable will be used to display String text
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leathanach_nua);
        //used to hold what the user types
        final EditText teacs = (EditText) findViewById(R.id.editText1);
        //used to display desired output
        final TextView display= (TextView)findViewById(R.id.textView1);
        //cast to a button and assigned
        btn=(Button)findViewById(R.id.button2);

        //creating an assetmanager so that .txt files in sub-folder may be accessed not fully working yet comment out
        //AssetManager achmainn = getAssets();

        //creating an onClickListener so that on user clicking the editText box the instructions disappear
        teacs.setOnClickListener(new View.OnClickListener() {
            @Override
            //onClick function
            public void onClick(View v) {
                //set the editText box to have no text inside box so user can type freely
                teacs.setText("");
            }
        });

    //Trying to change editText to clear when a key is pressed aswell as just user clicking the box aboove method which works
       // teacs.setOnKeyListener(new View.OnKeyListener(){

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //creating reference variable to store string input
                String getteacs = teacs.getText().toString();
                //clearing the editText
                teacs.setText("");
                //displaying TextView output of String entered in EditText box by user
                display.setText(getteacs);

                //creating a new Toast
                Toast toast = new Toast(getApplicationContext());
                //displaying text "predicting the word" on toast pop-up for a short time period
                toast.makeText(leathanachNua.this, "thuar an focal", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

