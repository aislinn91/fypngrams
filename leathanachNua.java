/**last two lines additional from first working ver 
**second activity java file**/

package com.example.aislinnmorrhouse.predictiteacs;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class leathanachNua extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leathanach_nua);
    }
        //used to hold what the user types
        EditText teacs = (EditText) findViewById(R.id.editText1);
        TextView textView = new TextView(this);
}
