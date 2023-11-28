package com.proj.snake.models;

public class HighScoreBoard {
    // TODO: Implement this class - Stores the high score of the player.
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
    public void resetScore() {
        mScore = 0;
    }

    public int getScore() {
        return mScore;
    }
}