package com.example.jamberjong.phul;


import android.content.Context;
import android.graphics.Typeface;
import android.text.Editable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.text.TextWatcher;

import java.util.ArrayList;
import java.util.HashMap;

import static com.example.jamberjong.phul.R.id.weightEdit;
import static java.lang.Integer.parseInt;

public class WorkoutAdapter extends BaseAdapter {
    private Context myContext;
    private LayoutInflater myInflater;
    private ArrayList<tuple> myDataSource;
    private Holder holder;

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
    public View getView(int position, View convertView, ViewGroup parent) {
        // View stuff
        if (convertView == null) {
            convertView = myInflater.inflate(R.layout.workout_week, parent, false);
            holder = new Holder();
            holder.weightEdit = (EditText) convertView.findViewById(R.id.weightEdit);
            holder.setsEdit = (EditText) convertView.findViewById(R.id.setsEdit);
            holder.repsEdit = (EditText) convertView.findViewById(R.id.repsEdit);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }

        // the item we are currently looking at
        final tuple item = myDataSource.get(position);
        // Sets name, rec sets, and rec reps for current item
        TextView workoutNameView =
                (TextView) convertView.findViewById(R.id._workoutName);
        TextView recSets =
                (TextView) convertView.findViewById(R.id._recSets);
        TextView recReps =
                (TextView) convertView.findViewById(R.id._recReps);
        workoutNameView.setText(item.getWorkoutName());
        recSets.setText(item.getRecSets());
        recReps.setText(item.getRecReps());

        // When you lose focus for a certain view
        holder.weightEdit.setOnFocusChangeListener(new View.OnFocusChangeListener(){
            public void onFocusChange(View v, boolean hasFocus){
                if (!hasFocus){
                    // Text is the current edit text
                    final EditText text = (EditText) v;
                    // If the text isn't empty set the weight of the item
                    if (!text.getText().toString().equals("")){
                        item.setWeight(parseInt(text.getText().toString()));
                    }
                }
            }
        });

        // Get the weight and then set the weight for the holder
        Integer itemWeight = item.getWeight();
        holder.weightEdit.setText(itemWeight.toString());

        // Font setting
        Typeface textTypeface =
                Typeface.createFromAsset(myContext.getAssets(), "fonts/BebasNeue Regular.ttf");
        TextView workoutNameTitle = (TextView) convertView.findViewById(R.id.workoutName);
        TextView recSetsTitle = (TextView) convertView.findViewById(R.id.recSets);
        TextView recRepsTitle = (TextView) convertView.findViewById(R.id.recReps);
        TextView weightTitle = (TextView) convertView.findViewById(R.id.weight);
        TextView setsTitle = (TextView) convertView.findViewById(R.id.sets);
        TextView repsTitle = (TextView) convertView.findViewById(R.id.reps);
        workoutNameTitle.setTypeface(textTypeface);
        recSetsTitle.setTypeface(textTypeface);
        recRepsTitle.setTypeface(textTypeface);
        weightTitle.setTypeface(textTypeface);
        setsTitle.setTypeface(textTypeface);
        repsTitle.setTypeface(textTypeface);
        workoutNameView.setTypeface(textTypeface);
        recSets.setTypeface(textTypeface);
        recReps.setTypeface(textTypeface);
        holder.weightEdit.setTypeface(textTypeface);
        holder.setsEdit.setTypeface(textTypeface);
        holder.repsEdit.setTypeface(textTypeface);
        return convertView;


    /*
    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        if (convertView == null) {
            holder = new Holder();
            convertView = myInflater.inflate(R.layout.workout_week, null);
            holder.weightEdit = (EditText) convertView.findViewById(weightEdit);
            holder.setsEdit = (EditText) convertView.findViewById(R.id.setsEdit);
            holder.repsEdit = (EditText) convertView.findViewById(R.id.repsEdit);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }

        // for getting the item at position
        final tuple item = myDataSource.get(position);
        // Sets name, and rec sets and reps
        TextView workoutNameView =
                (TextView) convertView.findViewById(R.id._workoutName);
        TextView recSets =
                (TextView) convertView.findViewById(R.id._recSets);
        TextView recReps =
                (TextView) convertView.findViewById(R.id._recReps);
        workoutNameView.setText(item.getWorkoutName());
        recSets.setText(item.getRecSets());
        recReps.setText(item.getRecReps());


        // Bind data from list
        holder.weightEdit.setText(Integer.toString(item.getWeight()));
        holder.weightEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String weightS = s.toString();
                if (weightS.equals("")){
                    item.setWeight(0);
                } else {
                    Integer weightI = Integer.parseInt(weightS);
                    item.setWeight(weightI);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                String weightS = s.toString();
                if (weightS.equals("")){
                    item.setWeight(0);
                } else {
                    Integer weightI = Integer.parseInt(weightS);
                    item.setWeight(weightI);
                }
            }
        });

        holder.setsEdit.setText(Integer.toString(item.getSets()));
        holder.setsEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String setsS = s.toString();
                if (setsS.equals("")){
                    item.setSets(0);
                } else {
                    Integer setsI = Integer.parseInt(setsS);
                    item.setSets(setsI);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                String setsS = s.toString();
                if (setsS.equals("")){
                    item.setSets(0);
                } else {
                    Integer setsI = Integer.parseInt(setsS);
                    item.setSets(setsI);
                }
            }
        });

        holder.repsEdit.setText(Integer.toString(item.getReps()));
        holder.repsEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String repsS = s.toString();
                if (repsS.equals("")){
                    item.setReps(0);
                } else {
                    Integer repsI = Integer.parseInt(repsS);
                    item.setReps(repsI);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                String repsS = s.toString();
                if (repsS.equals("")){
                    item.setReps(0);
                } else {
                    Integer repsI = Integer.parseInt(repsS);
                    item.setReps(repsI);
                }
            }
        });

        Typeface textTypeface =
                Typeface.createFromAsset(myContext.getAssets(), "fonts/BebasNeue Regular.ttf");
        workoutNameView.setTypeface(textTypeface);
        recSets.setTypeface(textTypeface);
        recReps.setTypeface(textTypeface);
        holder.weightEdit.setTypeface(textTypeface);
        holder.setsEdit.setTypeface(textTypeface);
        holder.repsEdit.setTypeface(textTypeface);

        return convertView;
        */

        /*
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
        */
    }

    private class Holder {
        EditText weightEdit;
        EditText setsEdit;
        EditText repsEdit;
    }
}

