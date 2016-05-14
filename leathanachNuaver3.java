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
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getteacs = teacs.getText().toString();
                display.setText(getteacs);
            }
        });
    }
