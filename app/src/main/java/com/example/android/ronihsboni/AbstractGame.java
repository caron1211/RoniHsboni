package com.example.android.ronihsboni;

import android.os.Parcelable;

import java.io.Serializable;

public abstract class AbstractGame implements Serializable {

    protected int numLevel;
    protected Exercise currExercise;
    protected static int numOfExercise =0;



    public   AbstractGame (int _numLevel) {
        this.numLevel= _numLevel;
        createNewExercise();

    }


    protected void createNewExercise (){
        currExercise = randomExercise();
        numOfExercise++;
    }

    abstract Exercise randomExercise () ;

//    boolean CheckCurrSolution (double userAns) {
//        return currExercise.checkSolution(userAns);
//    }

    public Exercise getCurrExercise() {
        return currExercise;
    }

    public static int getNumOfExercise() {
        return numOfExercise;
    }


    public int getNumLevel() {
        return numLevel;
    }
}
