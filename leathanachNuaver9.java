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
    ImageButton backbtn;
    Button databtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leathanach_nua);
        //used to hold what the user types
        final EditText teacs = (EditText) findViewById(R.id.editText1);
        //used to display desired output
        final TextView display= (TextView)findViewById(R.id.textView1);
        final TextView output = (TextView)findViewById(R.id.textView2);
        //cast to a button and assigned
        btn=(Button)findViewById(R.id.button2);
        backbtn = (ImageButton)findViewById(R.id.araisbutton);
        databtn = (Button)findViewById(R.id.databtn);
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
        teacs.setOnKeyListener(new EditText.OnKeyListener(){
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
                if(getteacs.equals("")){
                    //in this situation call an error output defined by the text below
                    teacs.setError("Caithfidh tú téacs a chuir sa mbosca");
                }


                 else {
                    //displaying TextView output of String entered in EditText box by user
                    display.setText(getteacs);

                    //creating a new Toast
                    Toast toast = new Toast(getApplicationContext());
                    //displaying text "predicting the word" on toast pop-up for a short time period
                    toast.makeText(leathanachNua.this, "thuar an focal", Toast.LENGTH_SHORT).show();
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


        //trying to get data from test data back in form of a string
        databtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String to store word taken in
                //String inputstr = teacs.getText().toString();
                String str = "";
                //String str2 = "";
                String [] word = new String [64];
                int pos = 0;

                //Scanner used to read in input being created
                Scanner myFile = null;

                //read in text file
                try {
                    //creating an InputStream which will open the text file stored in the assets resources folder using an AssetsManager
                    DataInputStream textFileStream =new DataInputStream(getAssets().open("testdata.txt"));
                    //the scanner "myFile" created above is assigned the file read in above as string input
                    myFile = new Scanner(new File(String.valueOf(textFileStream)));
                }
                //catch exception
                catch(IOException e){};
                //while the text file has another line
                while (myFile.hasNextLine()) {
                    //take in next available strings and store in string variables str (nonfadas) and str2 (fadas) respectively
                    str = myFile.next();
                    //str2 = myFile.next();
                    //assigning the input string to the word array at the current index
                    word[pos] = str;
                    //incrementing position counter
                    pos++;
                    //output.setText(str2);
                }
                //displaying the array in the text view it is also cast to string
                output.setText(Arrays.toString(word));

            }
        });



    }
}
