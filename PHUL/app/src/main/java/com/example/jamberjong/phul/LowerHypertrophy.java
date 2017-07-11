package com.example.jamberjong.phul;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class LowerHypertrophy extends AppCompatActivity {
    private ListView lowerList;    // Our List

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lower_hypertrophy);

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

        TextView title = (TextView) findViewById(R.id.lowerHypertrophyTitle);
        Typeface titleTypeface = Typeface.createFromAsset(getAssets(), "fonts/DroidSans-Bold.ttf");
        title.setTypeface(titleTypeface);
        title.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 30);

        tuple tuple1 = new tuple("Front Squat", "3-4", "8-12", 0, 0, 0);
        tuple tuple2 = new tuple("Barbell Lunge", "3-4", "8-12", 0, 0, 0);
        tuple tuple3 = new tuple("Leg Extension", "3-4", "10-15", 0, 0, 0);
        tuple tuple4 = new tuple("Leg Curl", "3-4", "10-15", 0, 0, 0);
        tuple tuple5 = new tuple("Seated Calf Raise", "3-4", "8-12", 0, 0, 0);
        tuple tuple6 = new tuple("Calf Press", "3-4", "8-12", 0, 0, 0);
        ArrayList<tuple> tupleList = new ArrayList<tuple>();
        tupleList.add(tuple1);
        tupleList.add(tuple2);
        tupleList.add(tuple3);
        tupleList.add(tuple4);
        tupleList.add(tuple5);
        tupleList.add(tuple6);

        lowerList = (ListView) findViewById(R.id.workoutList_view);
        final WorkoutAdapter adapter = new WorkoutAdapter(this, tupleList);
        lowerList.setAdapter(adapter);
    }

    @Override
    public void onBackPressed(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
