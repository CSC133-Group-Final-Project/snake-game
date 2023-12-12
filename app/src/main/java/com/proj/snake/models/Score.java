package com.proj.snake.models;

import com.proj.snake.interfaces.IResettableEntity;

public class Score implements IResettableEntity {
    static int mScore;

    private static Score instance = null;

    // Private constructor
    private Score() {

    }

    // Method to get singleton instance
    public static synchronized Score getInstance() {
        if (instance == null) {
            instance = new Score();
        }
        return instance;
    }

    //addScore() method from GameManager class
    public void addScore() {
        mScore++;
    }

    //resetScore() method from GameManager class
    @Override
    public void reset() {
        mScore = 0;
    }

    public int getScore() {
        return mScore;
    }
}