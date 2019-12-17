package com.example.aramamu1.babyonboard;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;


public class TrackHealthMilestone extends AppCompatActivity {


    EditText currentweight;
    EditText currentheight;
    EditText currenthead;
    EditText currentdiaper;
    EditText currentmilk;
    EditText currentsolid;

    TextView advice;
    TextView healthresults;
    //store user settings here once we get them
    private SharedPreferences mPreferences;
    private String sharedPrefFile =
            "com.example.aramamu1.babyonboard";
    //Shared preferences keys
    private final String USERID_KEY = "userID";
    private final String USERNAME_KEY = "userName";
    private final String birthDate_KEY = "birthDate";
    private final String WEEK_KEY = "currentWeek";
    private final String INITWEIGHT_KEY = "initialWeight";


    int uid;
    String uname;
    String udate;
    String uweek;
    String initial_weight;
    String current_date;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_healthmilestone);
        currentweight = (EditText) findViewById(R.id.currentweight);
        currentheight = (EditText) findViewById(R.id.height);
        currenthead = (EditText) findViewById(R.id.head);
        currentdiaper = (EditText) findViewById(R.id.numdiapers);
        currentmilk = (EditText) findViewById(R.id.nummilk);
        currentsolid = (EditText) findViewById(R.id.numsolid);
        healthresults = (TextView) findViewById(R.id.healthmilestone);

        //restore user data
        mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);
        uid = mPreferences.getInt(USERID_KEY, uid);
        uname = mPreferences.getString(USERNAME_KEY, uname);
        udate = mPreferences.getString(birthDate_KEY, udate);
        uweek = mPreferences.getString(WEEK_KEY, uweek);
        initial_weight = mPreferences.getString(INITWEIGHT_KEY, initial_weight);

        final Calendar cal = Calendar.getInstance();
        int month = cal.get(Calendar.MONTH) + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int year = cal.get(Calendar.YEAR);
        current_date = String.valueOf(month) + "/" + String.valueOf(day) + "/" + String.valueOf(year);

    }

    public void addHealth(View view) {

        if (currentweight.getText().toString().isEmpty() || (currentweight.getText().toString() == null)) {
            currentweight.setText("0");
        }
        if (currentheight.getText().toString().isEmpty() || (currentheight.getText().toString() == null)) {
            currentheight.setText("0");
        }
        if (currenthead.getText().toString().isEmpty() || (currenthead.getText().toString() == null)) {
            currenthead.setText("0");
        }
        if (currentdiaper.getText().toString().isEmpty() || (currentdiaper.getText().toString() == null)) {
            currentdiaper.setText("0");
        }
        if (currentmilk.getText().toString().isEmpty() || (currentmilk.getText().toString() == null)) {
            currentmilk.setText("0");
        }
        if (currentsolid.getText().toString().isEmpty() || (currentsolid.getText().toString() == null)) {
            currentsolid.setText("0");
        }

        //add to the database
        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
        HealthMilestone hm = new HealthMilestone(uid, current_date, Integer.parseInt(currentweight.getText().toString()), Integer.parseInt(currentheight.getText().toString()), Integer.parseInt(currenthead.getText().toString()), Integer.parseInt(currentdiaper.getText().toString()), Integer.parseInt(currentmilk.getText().toString()), Integer.parseInt(currentsolid.getText().toString()));
        dbHandler.addHealthMilestoneHandler(hm);
        String create = "Health results added";
        healthresults.setText(create);
    }

        public void loadResults (View view){
            MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
            String status_text = dbHandler.loadHealthHandler(uid);
            if (status_text != null) {
                healthresults.setText(status_text);
            } else {
                healthresults.setText("No Results Stored");
            }
            currentweight.setText("");
            currentheight.setText("");
            currenthead.setText("");
        }
    }




