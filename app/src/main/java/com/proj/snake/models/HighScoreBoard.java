package com.proj.snake.models;

import com.proj.snake.interfaces.IResettableEntity;

public class HighScoreBoard implements IResettableEntity {
    static int mScore;

    private static HighScoreBoard instance = null;

    // Private constructor
    private HighScoreBoard() {

    }

    // Method to get singleton instance
    public static synchronized HighScoreBoard getInstance() {
        if (instance == null) {
            instance = new HighScoreBoard();
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