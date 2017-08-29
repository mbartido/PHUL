package com.example.jamberjong.phul;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.preference.PreferenceManager;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.view.ViewGroup.LayoutParams;

public class Calculator extends AppCompatActivity {

    // For our uses, weight is described in pounds
    private double weight = 0;
    private double weightKG = 0;

    private Context myContext;
    private Activity myActivity;
    private PopupWindow myPopUpWindow;
    private ConstraintLayout constraintLayout;

    // Counters for number of times button is pressed
    // Pounds
    private int num45_l = 0;
    private int num35_l = 0;
    private int num25_l = 0;
    private int num10_l = 0;
    private int num5_0_l = 0;
    private int num2_5_l = 0;
    // Kilograms
    private int num25_k = 0;
    private int num20_k = 0;
    private int num15_k = 0;
    private int num10_k = 0;
    private int num5_0_k = 0;
    private int num2_5_k = 0;
    private int num2_0_k = 0;
    private int num1_5_k = 0;
    private int num1_0_k = 0;
    private int num0_5_k = 0;


    // For saving the number of times button is pressed
    public void saveInt(String key, int value) {
        // getting shared preferences
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        // getting the editor
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.commit();
    }

    // Getting number of times button is pressed
    public String getInt(String key) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        int savedValue = sharedPreferences.getInt(key, 0);
        return Integer.toString(savedValue);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        // Context and activity
        myContext = getApplicationContext();
        myActivity = Calculator.this;
        constraintLayout = (ConstraintLayout) findViewById(R.id.calc_layout);

        // Gets the action bar
        ActionBar ab = getSupportActionBar();
        // Sets the background of the action bar
        ab.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#000000")));
        // Makes a new text view
        TextView tv = new TextView(getApplicationContext());
        // Creates layout params for textView
        ViewGroup.LayoutParams lp = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        // Apply the Layout Params to textView
        tv.setLayoutParams(lp);
        // Sets the text for the bar
        tv.setText("PHUL");
        // Sets font color
        tv.setTextColor(Color.parseColor("#FFFFFF"));
        // Centers text
        tv.setGravity(Gravity.CENTER);
        // Sets a custom font for title
        Typeface custom = Typeface.createFromAsset(getAssets(), "fonts/DroidSans-Bold.ttf");
        tv.setTypeface(custom);
        // Changes the text size
        tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        // Sets ActionBar display option
        ab.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        // Set newly created TextView as ActionBar custom view
        ab.setCustomView(tv);

        // Text stuff
        TextView title = (TextView) findViewById(R.id.calcTitle);
        Typeface titleTypeface = Typeface.createFromAsset(getAssets(), "fonts/DroidSans-Bold.ttf");
        title.setTypeface(titleTypeface);
        title.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 30);

        // TextViews for pounds and kilograms
        final TextView pounds = (TextView) findViewById(R.id.pounds);
        final TextView kilograms = (TextView) findViewById(R.id.kilograms);

        // When you click reset button
        final Button resetButton = (Button) findViewById(R.id.ResetButton);
        resetButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                weight = 0;
                weightKG = 0;
                weight = Math.round(weight * 100.0)/100.0;
                weightKG = Math.round(weightKG * 100.0)/100.0;
                pounds.setText(weight + " LBS");
                kilograms.setText(weightKG + " KGS");

                // Resetting counters
                // Pounds
                num45_l = 0;
                num35_l = 0;
                num25_l = 0;
                num10_l = 0;
                num5_0_l = 0;
                num2_5_l = 0;
                // Kilograms
                num25_k = 0;
                num20_k = 0;
                num15_k = 0;
                num10_k = 0;
                num5_0_k = 0;
                num2_5_k = 0;
                num2_0_k = 0;
                num1_5_k = 0;
                num1_0_k = 0;
                num0_5_k = 0;

                // Setting textViews back to 0 in shared preferences
                saveInt("num45_l", num45_l);
                saveInt("num35_l", num35_l);
                saveInt("num25_l", num25_l);
                saveInt("num10_l", num10_l);
                saveInt("num5_0_l", num5_0_l);
                saveInt("num2_5_l", num2_5_l);
                saveInt("num25_k", num25_k);
                saveInt("num20_k", num20_k);
                saveInt("num15_k", num15_k);
                saveInt("num10_k", num10_k);
                saveInt("num5_0_k", num5_0_k);
                saveInt("num2_5_k", num2_5_k);
                saveInt("num2_0_k", num2_0_k);
                saveInt("num1_5_k", num1_5_k);
                saveInt("num1_0_k", num1_0_k);
                saveInt("num0_5_k", num0_5_k);
            }
        });

        /** Pounds Section *******************************************/

        // When you click 45L button
        final Button P45 = (Button) findViewById(R.id.lbs45);
        P45.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                weight = weight + 45;
                weightKG = weight * 0.45359237;
                weight = Math.round(weight * 100.0)/100.0;
                weightKG = Math.round(weightKG * 100.0)/100.0;
                pounds.setText(weight + " LBS");
                kilograms.setText(weightKG + " KGS");
                num45_l += 1;
                saveInt("num45_l", num45_l);
            }

        });

        // When you click 35L button
        final Button P35 = (Button) findViewById(R.id.lbs35);
        P35.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                weight = weight + 35;
                weightKG = weight * 0.45359237;
                weight = Math.round(weight * 100.0)/100.0;
                weightKG = Math.round(weightKG * 100.0)/100.0;
                pounds.setText(weight + " LBS");
                kilograms.setText(weightKG + " KGS");
                num35_l += 1;
                saveInt("num35_l", num35_l);
            }

        });

        // When you click 25L button
        final Button P25 = (Button) findViewById(R.id.lbs25);
        P25.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                weight = weight + 25;
                weightKG = weight * 0.45359237;
                weight = Math.round(weight * 100.0)/100.0;
                weightKG = Math.round(weightKG * 100.0)/100.0;
                pounds.setText(weight + " LBS");
                kilograms.setText(weightKG + " KGS");
                num25_l += 1;
                saveInt("num25_l", num25_l);
            }

        });

        // When you click 10L button
        final Button P10 = (Button) findViewById(R.id.lbs10);
        P10.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                weight = weight + 10;
                weightKG = weight * 0.45359237;
                weight = Math.round(weight * 100.0)/100.0;
                weightKG = Math.round(weightKG * 100.0)/100.0;
                pounds.setText(weight + " LBS");
                kilograms.setText(weightKG + " KGS");
                num10_l += 1;
                saveInt("num10_l", num10_l);
            }

        });

        // When you click 5.0L button
        final Button P5 = (Button) findViewById(R.id.lbs5);
        P5.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                weight = weight + 5;
                weightKG = weight * 0.45359237;
                weight = Math.round(weight * 100.0)/100.0;
                weightKG = Math.round(weightKG * 100.0)/100.0;
                pounds.setText(weight + " LBS");
                kilograms.setText(weightKG + " KGS");
                num5_0_l += 1;
                saveInt("num5_0_l", num5_0_l);
            }
        });

        // When you click 2.5L button
        final Button P2_5 = (Button) findViewById(R.id.lbs2_5);
        P2_5.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                weight = weight + 2.5;
                weightKG = weight * 0.45359237;
                weight = Math.round(weight * 100.0)/100.0;
                weightKG = Math.round(weightKG * 100.0)/100.0;
                pounds.setText(weight + " LBS");
                kilograms.setText(weightKG + " KGS");
                num2_5_l += 1;
                saveInt("num2_5_l", num2_5_l);
            }
        });

        /** Kilogram Section ********************************************/

        // When you click 25K button
        final Button K25 = (Button) findViewById(R.id.kg25);
        K25.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                weightKG = weightKG + 25;
                weight = weightKG / 0.45359237;
                weightKG = Math.round(weightKG * 100.0)/100.0;
                weight = Math.round(weight * 100.0)/100.0;
                pounds.setText(weight + " LBS");
                kilograms.setText(weightKG + " KGS");
                num25_k += 1;
                saveInt("num25_k", num25_k);
            }
        });

        // When you click 20K button
        final Button K20 = (Button) findViewById(R.id.kg20);
        K20.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                weightKG = weightKG + 20;
                weight = weightKG / 0.45359237;
                weightKG = Math.round(weightKG * 100.0)/100.0;
                weight = Math.round(weight * 100.0)/100.0;
                pounds.setText(weight + " LBS");
                kilograms.setText(weightKG + " KGS");
                num20_k += 1;
                saveInt("num20_k", num20_k);
            }
        });

        // When you click 15K button
        final Button K15 = (Button) findViewById(R.id.kg15);
        K15.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                weightKG = weightKG + 15;
                weight = weightKG / 0.45359237;
                weightKG = Math.round(weightKG * 100.0)/100.0;
                weight = Math.round(weight * 100.0)/100.0;
                pounds.setText(weight + " LBS");
                kilograms.setText(weightKG + " KGS");
                num15_k += 1;
                saveInt("num15_k", num15_k);
            }
        });

        // When you click 10K button
        final Button K10 = (Button) findViewById(R.id.kg10);
        K10.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                weightKG = weightKG + 10;
                weight = weightKG / 0.45359237;
                weightKG = Math.round(weightKG * 100.0)/100.0;
                weight = Math.round(weight * 100.0)/100.0;
                pounds.setText(weight + " LBS");
                kilograms.setText(weightKG + " KGS");
                num10_k += 1;
                saveInt("num10_k", num10_k);
            }
        });

        // When you click 5.0K button
        final Button K5 = (Button) findViewById(R.id.kg5_0);
        K5.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                weightKG = weightKG + 5;
                weight = weightKG / 0.45359237;;
                weightKG = Math.round(weightKG * 100.0)/100.0;
                weight = Math.round(weight * 100.0)/100.0;
                pounds.setText(weight + " LBS");
                kilograms.setText(weightKG + " KGS");
                num5_0_k += 1;
                saveInt("num5_0_k", num5_0_k);
            }
        });

        // When you click 2.5K button
        final Button K2_5 = (Button) findViewById(R.id.kg2_5);
        K2_5.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                weightKG = weightKG + 2.5;
                weight = weightKG / 0.45359237;
                weightKG = Math.round(weightKG * 100.0)/100.0;
                weight = Math.round(weight * 100.0)/100.0;
                pounds.setText(weight + " LBS");
                kilograms.setText(weightKG + " KGS");
                num2_5_k += 1;
                saveInt("num2_5_k", num2_5_k);
            }
        });

        // When you click 2.0K button
        final Button K2_0  = (Button) findViewById(R.id.kg2_0);
        K2_0.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                weightKG = weightKG + 2.0;
                weight = weightKG / 0.45359237;
                weightKG = Math.round(weightKG * 100.0)/100.0;
                weight = Math.round(weight * 100.0)/100.0;
                pounds.setText(weight + " LBS");
                kilograms.setText(weightKG + " KGS");
                num2_0_k += 1;
                saveInt("num2_0_k", num2_0_k);
            }
        });

        // When you click 1.5K button
        final Button K1_5  = (Button) findViewById(R.id.kg1_5);
        K1_5.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                weightKG = weightKG + 1.5;
                weight = weightKG / 0.45359237;
                weightKG = Math.round(weightKG * 100.0)/100.0;
                weight = Math.round(weight * 100.0)/100.0;
                pounds.setText(weight + " LBS");
                kilograms.setText(weightKG + " KGS");
                num1_5_k += 1;
                saveInt("num1_5_k", num1_5_k);
            }
        });

        // When you click 1.0K button
        final Button K1_0  = (Button) findViewById(R.id.kg1_0);
        K1_0.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                weightKG = weightKG + 1.0;
                weight = weightKG / 0.45359237;
                weightKG = Math.round(weightKG * 100.0)/100.0;
                weight = Math.round(weight * 100.0)/100.0;
                pounds.setText(weight + " LBS");
                kilograms.setText(weightKG + " KGS");
                num1_0_k += 1;
                saveInt("num1_0_k", num1_0_k);
            }
        });

        // When you click 0.5K button
        final Button K0_5  = (Button) findViewById(R.id.kg0_5);
        K0_5.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                weightKG = weightKG + 0.5;
                weight = weightKG / 0.45359237;
                weightKG = Math.round(weightKG * 100.0)/100.0;
                weight = Math.round(weight * 100.0)/100.0;
                pounds.setText(weight + " LBS");
                kilograms.setText(weightKG + " KGS");
                num0_5_k += 1;
                saveInt("num0_5_k", num0_5_k);
            }
        });

        final Button history = (Button) findViewById(R.id.historyButton);
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater = (LayoutInflater) myContext.getSystemService(LAYOUT_INFLATER_SERVICE);
                ViewGroup popupView = (ViewGroup) inflater.inflate(R.layout.pop_up, null);

                // For getting height and width of screen
                DisplayMetrics dm = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getMetrics(dm);
                int width = dm.widthPixels;
                int height = dm.heightPixels;

                // Pop up window height and width
                myPopUpWindow = new PopupWindow(popupView, (int) (width * .8),
                                               (int) (height * .7), true);


                // Elevate popup window
                if (Build.VERSION.SDK_INT >= 21) {
                    myPopUpWindow.setElevation(5.0f);
                }

                // All of the text views
                TextView text45L = (TextView) popupView.findViewById(R.id.num45l);
                TextView text35L = (TextView) popupView.findViewById(R.id.num35l);
                TextView text25L = (TextView) popupView.findViewById(R.id.num25l);
                TextView text10L = (TextView) popupView.findViewById(R.id.num10l);
                TextView text5_0L = (TextView) popupView.findViewById(R.id.num5_0l);
                TextView text2_5L = (TextView) popupView.findViewById(R.id.num2_5l);
                TextView text25K = (TextView) popupView.findViewById(R.id.num25k);
                TextView text20K = (TextView) popupView.findViewById(R.id.num20k);
                TextView text15K = (TextView) popupView.findViewById(R.id.num15k);
                TextView text10K = (TextView) popupView.findViewById(R.id.num10k);
                TextView text5_0K = (TextView) popupView.findViewById(R.id.num5_0k);
                TextView text2_5K = (TextView) popupView.findViewById(R.id.num2_5k);
                TextView text2_0K = (TextView) popupView.findViewById(R.id.num2_0k);
                TextView text1_5K = (TextView) popupView.findViewById(R.id.num1_5k);
                TextView text1_0K = (TextView) popupView.findViewById(R.id.num1_0k);
                TextView text0_5K = (TextView) popupView.findViewById(R.id.num0_5k);

                // Setting text views
                text45L.setText(getInt("num45_l"));
                text35L.setText(getInt("num35_l"));
                text25L.setText(getInt("num25_l"));
                text10L.setText(getInt("num10_l"));
                text5_0L.setText(getInt("num5_0_l"));
                text2_5L.setText(getInt("num2_5_l"));
                text25K.setText(getInt("num25_k"));
                text20K.setText(getInt("num20_k"));
                text15K.setText(getInt("num15_k"));
                text10K.setText(getInt("num10_k"));
                text5_0K.setText(getInt("num5_0_k"));
                text2_5K.setText(getInt("num2_5_k"));
                text2_0K.setText(getInt("num2_0_k"));
                text1_5K.setText(getInt("num1_5_k"));
                text1_0K.setText(getInt("num1_0_k"));
                text0_5K.setText(getInt("num0_5_k"));

                // To let window actually show
                myPopUpWindow.showAtLocation(constraintLayout, Gravity.CENTER, 0, 0);

                // For clicking anywhere to close window
                // Will get a warning when touching to close but that is normal
                popupView.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        myPopUpWindow.dismiss();
                        return true;
                    }
                });

            }
        });
    }


    @Override
    public void onBackPressed(){
        Intent intent = new Intent(this, UpperPower.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onResume(){
        super.onResume();
    }
}
