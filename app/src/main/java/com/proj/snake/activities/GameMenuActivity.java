package com.proj.snake.activities;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.proj.snake.R;
import com.proj.snake.adapters.HighScoreAdapter;
import com.proj.snake.interfaces.IAudioManager;
import com.proj.snake.managers.AudioManagerImpl;
import com.proj.snake.managers.GlobalStateManager;
import com.proj.snake.models.HighScoreBoard;
import com.proj.snake.utils.NavigationUtils;

public class GameMenuActivity extends Activity {
    private void showUsernameDialog() {
        final Dialog dialog = new Dialog(this, R.style.CustomDialogTheme); // Apply the custom theme
        dialog.setContentView(R.layout.username_dialog);

        EditText usernameEditText = dialog.findViewById(R.id.usernameEditText);
        Button submitButton = dialog.findViewById(R.id.usernameSubmitButton);

        submitButton.setOnClickListener(v -> {
            String username = usernameEditText.getText().toString();
            if (!username.isEmpty()) {
                GlobalStateManager.getInstance().setUsername(username);
                startGame();
            }
        });

        dialog.show();
    }

    private void startGame() {
        Intent intent = new Intent(GameMenuActivity.this, SnakeActivity.class);
        startActivity(intent);
    }
    private void showHighScoreDialog() {
        // Get the current High Scores
        HighScoreBoard highScoreBoard = HighScoreBoard.getInstance();
        // Create a Dialog instance
        final Dialog dialog = new Dialog(this, R.style.CustomDialogTheme); // Apply the custom theme
        // Set the custom layout
        dialog.setContentView(R.layout.high_score_layout);

        // Find the ListView and Back button in the layout
        ListView highScoreList = dialog.findViewById(R.id.highScoreList);
        Button backButton = dialog.findViewById(R.id.backButton);

        HighScoreAdapter adapter = new HighScoreAdapter(this, R.layout.high_score_item, highScoreBoard.getHighScores(getApplicationContext()));
        highScoreList.setAdapter(adapter);

        // Close the dialog when the Back button is pressed
        backButton.setOnClickListener(v -> dialog.dismiss());

        // Display the dialog
        dialog.show();
    }

    private void updateSoundButtonText(Button soundButton) {
        if (GlobalStateManager.getInstance().isSoundEnabled()) {
            soundButton.setText(R.string.sound_on);
        } else {
            soundButton.setText(R.string.sound_off);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_layout);

        // Initialize buttons
        Button playButton = findViewById(R.id.playButton);
        Button highScoreButton = findViewById(R.id.highScoreButton);
        Button soundButton = findViewById(R.id.soundButton);
        Button aboutButton = findViewById(R.id.aboutButton);
        Button exitButton = findViewById(R.id.exitButton);

        // Play button logic
        playButton.setOnClickListener(v -> showUsernameDialog());

        // Exit button logic
        exitButton.setOnClickListener(v -> {
            // Close the app
            finish();
        });

        // Sound button logic
        soundButton.setOnClickListener(v -> {
            IAudioManager audioManager = AudioManagerImpl.getInstance(getApplicationContext());
            audioManager.toggleSound();
            GlobalStateManager.getInstance().setSoundEnabled(audioManager.isSoundEnabled());
            updateSoundButtonText(soundButton);
        });

        // High Score button logic
        highScoreButton.setOnClickListener(v -> NavigationUtils.showHighScoreDialog(this));

        // About button logic
        aboutButton.setOnClickListener(v -> {
            // Create a Dialog instance
            final Dialog dialog = new Dialog(this, R.style.CustomDialogTheme); // Apply the custom theme
            // Set the custom layout
            dialog.setContentView(R.layout.about_layout);

            // Find the Back button in the layout
            Button backButton = dialog.findViewById(R.id.backButton);

            // Close the dialog when the Back button is pressed
            backButton.setOnClickListener(v1 -> dialog.dismiss());

            // Display the dialog
            dialog.show();
        });
    }
}
