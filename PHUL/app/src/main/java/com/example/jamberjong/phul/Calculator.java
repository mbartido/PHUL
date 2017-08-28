package com.example.jamberjong.phul;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
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
    public double weight = 0;
    public double weightKG = 0;

    private Context myContext;
    private Activity myActivity;
    private PopupWindow myPopUpWindow;
    private ConstraintLayout constraintLayout;

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
            }
        });

        final Button history = (Button) findViewById(R.id.historyButton);
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater = (LayoutInflater) myContext.getSystemService(LAYOUT_INFLATER_SERVICE);
                ViewGroup popupView = (ViewGroup) inflater.inflate(R.layout.pop_up, null);

                myPopUpWindow = new PopupWindow(popupView, 800, 600, true);

                // Elevate popup window
                if (Build.VERSION.SDK_INT >= 21) {
                    myPopUpWindow.setElevation(5.0f);
                }

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
