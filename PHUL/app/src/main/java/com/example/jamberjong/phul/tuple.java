package com.example.jamberjong.phul;

import android.util.Log;

public class tuple {
    String workoutName;
    int recSets;
    int recReps;
    int weight;
    int sets;
    int reps;


    // constructor
    public tuple(String _workoutName, int _recSets, int _recReps, int _weight, int _sets, int _reps){
        workoutName = _workoutName;
        recSets = _recSets;
        recReps = _recReps;
        weight = _weight;
        sets = _sets;
        reps = _reps;
    }

    // Assign workout name
    public void setWorkoutName(String _workoutName) { workoutName = _workoutName; }

    // Assign rec sets
    public void setRecSets(int _recSets) { recSets = _recSets; }

    // Assign rec reps
    public void setRecReps(int _recReps) { recReps = _recReps; }

    // Assign weight to _weight
    public void setWeight(int _weight){
        weight = _weight;
    }

    // Assign sets to _sets
    public void setSets(int _sets){
        sets = _sets;
    }

    // Assign reps to _reps
    public void setReps(int _reps){ reps = _reps; }

    // Gets weight, sets, and reps, and others
    public String getWorkoutName(){ return workoutName; }
    public int getRecSets(){ return recSets; }
    public int getRecReps(){ return recReps; }
    public int getWeight(){ return weight; }
    public int getSets(){ return sets; }
    public int getReps(){ return reps; }

    public void print(){
        Log.d("Tuple", "Weight: " + Integer.toString(weight));
        Log.d("Tuple", "Sets: " + Integer.toString(weight));
        Log.d("Tuple", "Reps: " + Integer.toString(reps));
    }

    public String toString(){
        return "(" + weight + "," + sets + "," + reps + ")";
    }
}
