package com.example.aislinnmorrhouse.predictiteacs;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class datafreqs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datafreqs);

        final TextView output = (TextView)findViewById(R.id.textView2);

        String str = "";

        //String [] word = new String [64];
        //int pos = 0;

        //Scanner used to read in input being created
        Scanner myFile = null;

        //read in text file
        try {
            //creating an InputStream which will open the text file stored in the assets resources folder using an AssetsManager
            DataInputStream textFileStream =new DataInputStream(getAssets().open("testdata.txt"));
            //the scanner "myFile" created above is assigned the file read in above as string input

            myFile = new Scanner(new File(String.valueOf(textFileStream)));
            str = myFile.next();
        }
        //catch exception
        catch(IOException e){
            e.printStackTrace();
        };
        //while the text file has another line
        //while (myFile.hasNextLine()) {
            //take in next available strings and store in string variables str (nonfadas) and str2 (fadas) respectively
        //    str = myFile.next();
            //assigning the file input string to the word array at the current index
        //    word[pos] = str;
            //incrementing position counter
        //    pos++;
            //output.setText(str2);
        //}
        //displaying the array in the text view it is also cast to string
        //output.setText(word.toString());
        output.setText(str);
    }
}
