package com.proj.snake.activities;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.proj.snake.R;
import com.proj.snake.interfaces.IAudioManager;
import com.proj.snake.managers.AudioManagerImpl;
import com.proj.snake.managers.GlobalStateManager;
import com.proj.snake.utils.NavigationUtils;

public class GameMenuActivity extends Activity {
    private void showUsernameDialog() {
        final Dialog dialog = new Dialog(this, R.style.CustomDialogTheme); // Apply the custom theme
        dialog.setContentView(R.layout.username_dialog);

        EditText usernameEditText = dialog.findViewById(R.id.usernameEditText);
        Button submitButton = dialog.findViewById(R.id.usernameSubmitButton);

        submitButton.setOnClickListener(v -> {
            dialog.dismiss();
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

        if (GlobalStateManager.getInstance().isSoundEnabled()) {
            soundButton.setText(R.string.sound_on);
        } else {
            soundButton.setText(R.string.sound_off);
        }

        // Play button logic
        playButton.setOnClickListener(v -> showUsernameDialog());

        // Exit button logic
        exitButton.setOnClickListener(v -> {
            // Kill the app
            finishAndRemoveTask();
            System.exit(0);
        });

        IAudioManager audioManager = AudioManagerImpl.getInstance(this);

        // Sound button logic
        soundButton.setOnClickListener(v -> {
            if (GlobalStateManager.getInstance().isSoundEnabled()) {
                audioManager.toggleSound(false);
                GlobalStateManager.getInstance().setSoundEnabled(false);
            } else {
                audioManager.toggleSound(true);
                GlobalStateManager.getInstance().setSoundEnabled(true);
            }
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
