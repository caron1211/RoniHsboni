package com.example.android.ronihsboni;

import android.content.Intent;
import android.util.Log;

import java.io.Serializable;
import java.util.Random;

public class Exercise implements Serializable {

    int level;
    double x;
    double y;
    char op;
    String exerciseString;
    double solution;

public Exercise (int _level, double _x, double _y, char _op ) {

    level=_level;
    x=_x;
    y=_y;
    op=_op;
    exerciseString= fmt(_x)+_op+fmt(_y);
    solution= doMath(_x,_y,_op);

}

    private static String fmt(double d)
    {
        if(d == (long) d)
            return String.format("%d",(long)d);
        else
            return String.format("%s",d);
    }

    private double doMath(double first, double second, char op ){

        switch(op){
            case '+':
                return first + second;
            case '-':
                return first - second;
            case '*':
                return first * second;
            case '/':
                return first / second;
            default:
                return 0;
        }
    }


    public boolean checkSolution (double userAns) {

    return  ( userAns== solution);
    }

public String toString () {
    return exerciseString;
}

}
