package com.example.aramamu1.babyonboard;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.DialogFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class SettingsAdmin extends AppCompatActivity {

    TextView lst;
    EditText userid;

    EditText userpswd;



    //store user settings here once we get them- shared preferences
    //preferences object
    private SharedPreferences mPreferences;
    //preferences name
    private String sharedPrefFile =
            "com.example.aramamu1.babyonboard";
    private String birthDate;
    private String currentWeek;
    //Shared preferences keys
    private final String USERID_KEY = "userID";
    private final String USERNAME_KEY = "userName";
    private final String birthDate_KEY = "birthDate";
    private final String WEEK_KEY = "currentWeek";
    private final String INITWEIGHT_KEY = "initialWeight";
    String start_date;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_admin);
        mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);
        lst = (TextView) findViewById(R.id.lst);
        userid = (EditText) findViewById(R.id.userid);

        userpswd = (EditText) findViewById(R.id.userpswd);


    }










    public void findUser (View view) {
        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
        User user = dbHandler.findHandler(Integer.parseInt(userid.getText().toString()), userpswd.getText().toString());
        if (user != null) {
            lst.setText(String.valueOf(user.getID()) +" "+ user.getUserName()+" "+user.getbirthDate()+" "+String.valueOf(user.getInitialWeight()));

        } else {
            lst.setText("No Match Found");
        }
    }

    public void loadUser(View view) {
        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
        String response = dbHandler.loadHandler();
        if(response == "") {
            lst.setText("No records found.");
        }
        else{
            lst.setText(response);
        }

        userid.setText("");
        userpswd.setText("");

    }

    public void deleteUser(View view) {
        MyDBHandler dbHandler = new MyDBHandler(this, null,
                null, 1);
        boolean result = dbHandler.deleteHandler(
                Integer.parseInt(userid.getText().toString()));
        if (result) {
            userid.setText("");
            userpswd.setText("");

            lst.setText("Record Deleted");
            SharedPreferences.Editor preferencesEditor = mPreferences.edit();
            preferencesEditor.clear();
            preferencesEditor.apply();
            preferencesEditor.putInt(USERID_KEY, 0);
            preferencesEditor.apply();
        } else {
            lst.setText("No Match Found");
        }



    }

}
