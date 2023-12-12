package com.proj.snake.models;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class HighScoreBoard {
    private List<HighScore> highScores;
    private static final int MAX_SCORES = 10;
    private static final String SHARED_PREFS_FILE = "HighScores";
    private static final String SCORES_KEY = "HighScoreList";

    private static class LazyHolder {
        static final HighScoreBoard INSTANCE = new HighScoreBoard();
    }

    public static HighScoreBoard getInstance() {
        return LazyHolder.INSTANCE;
    }

    public void addScore(Context context, HighScore newHighScore) {
        if (highScores == null) {
            highScores = loadHighScores(context);
        }

        // Check if the user already has a score entry
        HighScore existingScore = null;
        for (HighScore highScore : highScores) {
            if (highScore.getPlayerName().equals(newHighScore.getPlayerName())) {
                existingScore = highScore;
                break;
            }
        }

        if (existingScore != null) {
            // Update the existing score if the new score is higher
            if (newHighScore.getScore() > existingScore.getScore()) {
                existingScore.setScore(newHighScore.getScore());
            }
        } else {
            // Add new high score if user doesn't have an existing entry
            highScores.add(newHighScore);
        }

        Collections.sort(highScores);
        if (highScores.size() > MAX_SCORES) {
            highScores.remove(highScores.size() - 1);
        }
        saveHighScores(context);
    }

    public List<HighScore> getHighScores(Context context) {
        if (highScores == null) {
            highScores = loadHighScores(context);
        }
        return highScores;
    }

    private void saveHighScores(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(SHARED_PREFS_FILE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(highScores);
        editor.putString(SCORES_KEY, json);
        editor.apply();
    }

    private List<HighScore> loadHighScores(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(SHARED_PREFS_FILE, Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = prefs.getString(SCORES_KEY, null);
        Type type = new TypeToken<ArrayList<HighScore>>() {}.getType();
        List<HighScore> scores = gson.fromJson(json, type);
        if (scores == null) {
            scores = new ArrayList<>();
        }
        return scores;
    }
}