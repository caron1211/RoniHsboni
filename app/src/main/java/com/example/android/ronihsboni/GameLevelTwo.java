package com.example.android.ronihsboni;

import java.util.Random;

public class GameLevelTwo extends AbstractGame {

    final static int twoLevel = 2;
    final static int maxValue = 20;

    enum arithmeticOperations {
        PLUS,
        MINUS,
        MULTI
    }


    public GameLevelTwo() {
        super(twoLevel);
    }

    @Override
    Exercise randomExercise() {

        int x = (int) (Math.random() * maxValue + 1);
        int y = (int) (Math.random() * maxValue + 1);

        GameLevelTwo.arithmeticOperations art = GameLevelTwo.arithmeticOperations.values()[new Random().nextInt(GameLevelOne.arithmeticOperations.values().length)];

        switch (art) {
            case PLUS:
                return new Exercise(twoLevel, x, y, '+');
            case MINUS:
                return new Exercise(twoLevel, x, y, '-');
            case MULTI:
                return new Exercise(twoLevel, x, y, '*');

            default:
                return null;


        }


    }
}