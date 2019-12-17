package com.example.aramamu1.babyonboard;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Milestone extends AppCompatActivity {

    //store user settings here once we get them
    private SharedPreferences mPreferences;
    private String sharedPrefFile =
            "com.example.aramamu1.babyonboard";
    //Shared preferences keys
    private final String USERNAME_KEY = "userName";
    private final String WEEK_KEY = "currentWeek";
    String uname;
    String uweek;
    TextView weeklystatus;
    TextView apptadvice;
    TextView foodadvice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_milestone);

        mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);
        uname = mPreferences.getString(USERNAME_KEY, uname);
        uweek = mPreferences.getString(WEEK_KEY, uweek);

        weeklystatus = (TextView) findViewById(R.id.milestone);
        apptadvice = (TextView) findViewById(R.id.apptadvice);
        foodadvice = (TextView) findViewById(R.id.foodadvice);

        displayAdvice(uname, uweek);

    }


    //display advice
    private void displayAdvice(String uname, String uweek){

        int nummon = (int)(Math.floor(Integer.parseInt(uweek)/4.345));

        if((nummon>=0) && (nummon<=2)){
            weeklystatus.setText("Welcome "+uname+" to the world! Your child won't do much but be sure to make sure that they can latch when breastfeeding, if not please see a lactation consultant ASAP.");
            apptadvice.setText("At 2 months your child will have vaccines: PEDIARIX OR PENTACEL, HIB, PREVNAR 13, Rotavirus, HEP B. ");
            foodadvice.setText("Be sure to breastfeed on demand as you are building up your supply.");

        }
        else if((nummon>=3) && (nummon<=5)){
            weeklystatus.setText("Your child is 3-5 months! Your child will start to be more aware of the world. Cooing at you. Holding onto toys. Baby should start smiling.");
            apptadvice.setText("Your child will have vaccines: PEDIARIX OR PENTACEL, HIB, PREVNAR 13, Rotavirus, HEP B.");
            foodadvice.setText("Now is the time most moms go back to work.  Be sure to try a bottle out before you go back to work.  Try giving 1-1.5 oz an hour.");

        }
        else if((nummon>=6) && (nummon<=8)){
            weeklystatus.setText("Your child is 6-8 months!  Milestones to expect are sitting up and possibly their first tooth. Baby should start laughing.");
            apptadvice.setText("Your child will have vaccines: PEDIARIX OR PENTACEL, HIB, PREVNAR 13, Rotavirus, HEP B.");
            foodadvice.setText("Your child will now eat solids twice a day.  Chunkier solids are now recommended like pieces of baby guacamole: pieces of avocado mashed.");

        }
        else if((nummon>=9) && (nummon<=11)){
            weeklystatus.setText("Your child is 9-11 months!  Expect your child to start crawling or walking. Baby should start babbling sounds like dada dada. Baby should also start clapping.");
            apptadvice.setText("Your child gets a break from vaccines until they reach a year.");
            foodadvice.setText("Your child will now eat solids three times a day.  Try feeding foods that you eat cut into small pieces.  Remember nothing should contain honey.");

        }
        else if(nummon == 12){
            weeklystatus.setText("Congrats on reaching a year!");
            apptadvice.setText(uname+" has a 12 month appointment coming up! Your child will have vaccines: MMR, VARICELLA, HEP A.");
            foodadvice.setText("Your baby can now expect to wean from nursing or formula and is ready for whole milk.  Try mixing breastmilk or formula with cow's milk until your child can take cows milk.");
        }
        else{
            weeklystatus.setText("Congrats your child is over a year! This app is no longer applicable to them.");
            apptadvice.setText(" ");
            foodadvice.setText(" ");
        }

    }
}
