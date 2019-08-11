package com.example.android.ronihsboni;


import java.util.Random;

public class GameLevelOne extends AbstractGame {

    final static int OneLevel= 1;
    final static int maxValue= 10;

    enum arithmeticOperations {
        PLUS,
        MINUS
    }


    public  GameLevelOne () {
        super(OneLevel);
    }
    @Override
    Exercise randomExercise() {

        int x = (int) (Math.random()* maxValue+1);
        int y = (int) (Math.random()* maxValue+1);

        arithmeticOperations art = arithmeticOperations.values()[new Random().nextInt(arithmeticOperations.values().length)];

        switch (art)
        {
            case PLUS:
            return new Exercise(OneLevel,x,y,'+');
            case MINUS:
                return new Exercise(OneLevel,x,y,'-');
            default:
                return null;


        }


    }




}
