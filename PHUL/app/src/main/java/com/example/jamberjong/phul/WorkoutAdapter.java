package com.example.jamberjong.phul;


import android.content.Context;
import android.graphics.Typeface;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class WorkoutAdapter extends BaseAdapter {
    private Context myContext;
    private LayoutInflater myInflater;
    private ArrayList<tuple> myDataSource;

    public WorkoutAdapter(Context context, ArrayList<tuple> items) {
        myContext = context;
        myDataSource = items;
        myInflater = (LayoutInflater) myContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount(){
        return myDataSource.size();
    }

    @Override
    public Object getItem(int position){
        return myDataSource.get(position);
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        // Gets the view for row item
        View rowView = myInflater.inflate(R.layout.workout_week, parent, false);
        TextView workoutNameView =
                (TextView) rowView.findViewById(R.id._workoutName);
        TextView recSets =
                (TextView) rowView.findViewById(R.id._recSets);
        TextView recReps =
                (TextView) rowView.findViewById(R.id._recReps);
        EditText weight =
                (EditText) rowView.findViewById(R.id.weightEdit);
        EditText sets =
                (EditText) rowView.findViewById(R.id.setsEdit);
        EditText reps =
                (EditText) rowView.findViewById(R.id.repsEdit);

        tuple item = myDataSource.get(position);
        workoutNameView.setText(item.getWorkoutName());
        String _weight = Integer.toString(item.getWeight());
        String _sets = Integer.toString(item.getSets());
        String _reps = Integer.toString(item.getReps());
        recSets.setText(item.getRecSets());
        recReps.setText(item.getRecReps());
        weight.setText(_weight);
        sets.setText(_sets);
        reps.setText(_reps);

        Typeface textTypeface =
                Typeface.createFromAsset(myContext.getAssets(), "fonts/BebasNeue Regular.ttf");
        workoutNameView.setTypeface(textTypeface);
        recSets.setTypeface(textTypeface);
        recReps.setTypeface(textTypeface);
        weight.setTypeface(textTypeface);
        sets.setTypeface(textTypeface);
        reps.setTypeface(textTypeface);

        return rowView;
    }
}

