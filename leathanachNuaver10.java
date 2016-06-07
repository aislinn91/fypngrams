package com.example.aislinnmorrhouse.predictiteacs;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.UnknownFormatConversionException;
import java.io.IOException;
import java.io.DataInputStream;
import java.io.*;
import java.util.*;

public class leathanachNua extends AppCompatActivity {

    //Creating a button variable will be used to display String text
    Button btn;
    //Creating an image button variable used to go back 
    ImageButton backbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leathanach_nua);
        
        //used to hold what the user types
        final EditText teacs = (EditText) findViewById(R.id.editText1);
        //used to display desired output
        final TextView display = (TextView) findViewById(R.id.textView1);

        //cast to a button and assigned
        btn = (Button) findViewById(R.id.button2);
        backbtn = (ImageButton) findViewById(R.id.araisbutton);


        teacs.setHint("Chuir an gaeilge isteach sa mbosca");

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

        //creating an onkeylistener event
        teacs.setOnKeyListener(new EditText.OnKeyListener() {
            //method that on the condition that a hardware key is pressed will cause the text in the edittext box to disappear
            public boolean onKey(View v, int KeyCode, KeyEvent event) {
                //event called when a key is pressed down
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    switch (KeyCode) {
                        //in the case of the enter key
                        case KeyEvent.KEYCODE_ENTER:
                            //clearing the edittext
                            teacs.setText("");
                            return true;
                        default:
                            break;
                    }
                }
                return false;
            }
        });

        //creating new on click listener for the taispean button
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //creating reference variable to store string input
                String getteacs = teacs.getText().toString();
                //clearing the editText
                teacs.setText("");

                //incorporating data validation by checking if no string text entered to edittext box
                if (getteacs.equals("")) {
                    //in this situation call an error output defined by the text below
                    teacs.setError("Caithfidh tú téacs a chuir sa mbosca");
                }

                else {
                    //populating arrays based on values returned from file unique word counts
                    //if aba typed in box abair should appear..if abh typed in ábhar should appear.. if bea typed in beag should
                    //appear if bai typed in baile should appear
                    String[] nonfadaval = {"abair", "abalta", "abhar", "abhaile", "bean", "beag", "baile","baint"};
                    String[] fadaval = {"abair", "ábalta", "ábhar", "abhaile", "bean", "beag", "baile", "baint"};
                    int[] count = {10, 8, 111, 9, 2, 60, 191, 10 };
                    String[] results = new String[8];
                    boolean findingmatch = false;
                    //set to -1 will always be higher

                    //array storing freqs of result vals
                    int [] resfreq = new int [8];



                    //int length of text input
                    int teacslength = getteacs.length();
                    //position counter vars
                    //int pos = 0;
                    int respoint = 0;

                    for (int i = 0; i < teacslength; i++) {
                        //current nonfada string in array
                        String nonfadacurrent = nonfadaval[i];
                        //substring of current nf up to length of input string length
                        String subs = (nonfadacurrent.substring(0, teacslength));

                        //if input text equals substring of nonfada val
                        if (getteacs.equals(subs)) {
                            //its equivalent fada word stored in results array
                            results[respoint] = fadaval[i];
                            //freq count of chosen value stored for comparison
                            resfreq[respoint] = count[i];
                            //increase results pointer
                            respoint++;

                            //match found set boolean to true
                            findingmatch = true;
                        } else {
                            //was finding matches but have gone past match range (alphabetical)
                            if (findingmatch) {
                                //in this case break out of loop
                                break;
                            }
                        }


                        int highestprob = -1;
                        int wordindex = -1;
                        String chosenword = "";

                        //going through result array
                        for(int j=0; j<results.length; j++) {
                            // if current value in results freq greater than highestprob val
                            if (resfreq[j] > highestprob) {
                                //make resultfreq count new highest prob
                                highestprob = resfreq[j];
                                //make predicted word the result word with the same index
                                chosenword = results[j];
                            }
                        }

                        //displaying TextView output of predicted word of the entered word input by user
                        //display.setText(results[i]);
                        display.setText(chosenword);

                        //creating a new Toast
                        Toast toast = new Toast(getApplicationContext());
                        //displaying text "predicting the word" on toast pop-up for a short time period
                        toast.makeText(leathanachNua.this, "thuar an focal", Toast.LENGTH_SHORT).show();

                    }
                }
            }

        });

        //creating new on click listener for ar ais image button
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            //when image button is clicked
            public void onClick(View v) {
                //the mainactivity will be started i.e.user is brought back to the home page
                startActivity(new Intent(getApplicationContext(), mainactivity.class));
            }
        });
    }
}
