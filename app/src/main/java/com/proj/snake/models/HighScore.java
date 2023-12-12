package com.proj.snake.models;

public class HighScore implements Comparable<HighScore> {
    private String playerName;
    private int score;

    public HighScore(String playerName, int score) {
        this.playerName = playerName;
        this.score = score;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getScore() {
        return score;
    }

    @Override
    public int compareTo(HighScore other) {
        return Integer.compare(other.score, this.score);
    }

    public void setScore(int score) {
        this.score = score;
    }
}
