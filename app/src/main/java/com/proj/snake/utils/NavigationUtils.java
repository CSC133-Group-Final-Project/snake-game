package com.proj.snake.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.widget.Button;
import android.widget.ListView;

import com.proj.snake.R;
import com.proj.snake.adapters.HighScoreAdapter;
import com.proj.snake.models.HighScoreBoard;
import com.proj.snake.views.GameMenuActivity;

public class NavigationUtils {

    public static void showHighScoreDialog(Activity activity) {
        // Get the current High Scores
        HighScoreBoard highScoreBoard = HighScoreBoard.getInstance();
        // Create a Dialog instance
        final Dialog dialog = new Dialog(activity, R.style.CustomDialogTheme);
        // Set the custom layout
        dialog.setContentView(R.layout.high_score_layout);

        ListView highScoreList = dialog.findViewById(R.id.highScoreList);
        Button backButton = dialog.findViewById(R.id.backButton);

        HighScoreAdapter adapter = new HighScoreAdapter(activity, R.layout.high_score_item, highScoreBoard.getHighScores(activity.getApplicationContext()));
        highScoreList.setAdapter(adapter);

        backButton.setOnClickListener(v -> dialog.dismiss());
        dialog.show();
    }

    public static void returnToMainMenu(Activity activity) {
        Intent intent = new Intent(activity, GameMenuActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        activity.startActivity(intent);
    }
}
