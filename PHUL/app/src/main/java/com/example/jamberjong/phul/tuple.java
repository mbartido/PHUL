package com.example.jamberjong.phul;

import android.util.Log;

public class tuple {
    int weight;
    int sets;
    int reps;

    // constructor
    public tuple(int _weight, int _sets, int _reps){
        weight = _weight;
        sets = _sets;
        reps = _reps;
    }

    // Assign weight to _weight
    public void exerWeight(int _weight){
        weight = _weight;
    }

    // Assign sets to _sets
    public void exerSets(int _sets){
        sets = _sets;
    }

    // Assign reps to _reps
    public void exerReps(int _reps){
        reps = _reps;
    }

    public void print(){
        Log.d("Tuple", "Weight: " + Integer.toString(weight));
        Log.d("Tuple", "Sets: " + Integer.toString(weight));
        Log.d("Tuple", "Reps: " + Integer.toString(reps));
    }

    public String toString(){
        return "(" + weight + "," + sets + "," + reps + ")";
    }
}
