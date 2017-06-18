package com.example.jamberjong.phul;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.support.constraint.solver.SolverVariable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.support.v7.app.ActionBar;
import android.widget.Toast;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.lang.reflect.Type;

import static android.R.id.list;

public class MainActivity extends AppCompatActivity {

    private ListView myList;
    public static final String TAG = "List";
    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        // List View stuff
        myList = (ListView) findViewById(R.id.recipe_list_view);
        // Shared preferences
        SharedPreferences settings = getSharedPreferences("PREFS", 0);
        String wordsString = settings.getString("words", "");
        // Gets weeks from words
        String[] week = wordsString.split(",");
        final ArrayList<String> list = new ArrayList<String>();
        // Adds each day to the list
        for (int i = 0; i < week.length; i++){
            list.add(week[i]);
        }
        // Set adapter so you can view the list
        final WeekAdapter adapter = new WeekAdapter(this, list);
        myList.setAdapter(adapter);
        myList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l){
                // Value of position clicked
                int pos = (int) myList.getAdapter().getItemId(position);
                pos = pos + 1;
                // Display position in toast
                String clicked = "Position " + pos + " clicked";
                Toast.makeText(getApplicationContext(), clicked, Toast.LENGTH_SHORT).show();

                // Go to new activity
                if ((pos%4) == 1){
                    Intent upperPower = new Intent(MainActivity.this, UpperPower.class);
                    startActivity(upperPower);
                    finish();
                }
            }
        });


        // Add button
        final Button addButton = (Button) findViewById(R.id.add_button);
        addButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                StringBuilder stringBuilder = new StringBuilder();
                // Adds to string builder for every string in list
                for (String s: list){
                    stringBuilder.append(s);
                    stringBuilder.append(",");
                }
                // Adds one more to stringbuilder than previous list size
                stringBuilder.append("Day " + list.size()+1);
                sharedpreferences = getSharedPreferences("PREFS", 0);
                SharedPreferences.Editor editor = sharedpreferences.edit();
                // Puts the newly added string to shared preferences
                editor.putString("words", stringBuilder.toString());
                editor.commit();
                list.add("Day " + list.size()+1);
                String added = "Added Day " + (list.size());
                Toast.makeText(getApplicationContext(), added, Toast.LENGTH_SHORT).show();
                adapter.notifyDataSetChanged();
            }
        });

        // Delete Button
        final Button delButton = (Button) findViewById(R.id.delete_button);
        delButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                // Don't do anything if the list size is 0
                if (list.size() == 0) return;
                // Remove last element from list
                list.remove(list.size()-1);
                // Add to string builder from list with removed element
                StringBuilder stringBuilder = new StringBuilder();
                for (String s: list){
                    stringBuilder.append(s);
                    stringBuilder.append(",");
                }
                // Shared preferences stuff
                sharedpreferences = getSharedPreferences("PREFS", 0);
                SharedPreferences.Editor editor = sharedpreferences.edit();
                // Puts new week string to shared preferences
                editor.putString("words", stringBuilder.toString());
                editor.commit();
                adapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    protected void onResume(){
        super.onResume();
    }



}
