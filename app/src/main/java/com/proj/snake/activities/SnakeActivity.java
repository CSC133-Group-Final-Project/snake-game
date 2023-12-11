package com.proj.snake.activities;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.proj.snake.R;
import com.proj.snake.managers.AudioManagerImpl;
import com.proj.snake.managers.GlobalStateManager;
import com.proj.snake.utils.NavigationUtils;
import com.proj.snake.views.SnakeGame;

// SnakeActivity class is the main Activity for the Pong game.
// It manages the lifecycle of the PongGame object, ensuring it
// pauses and resumes as the Activity lifecycle changes.
public class SnakeActivity extends Activity implements SnakeGame.GameEventListener {
    // mPongGame is an instance of the PongGame class which handles the game logic and rendering.
    private SnakeGame mSnakeGame;


    private void updateSoundStatusText(boolean isSoundOn) {
        TextView soundStatusText = findViewById(R.id.soundStatusText);
        if (isSoundOn) {
            soundStatusText.setText("Sound On");
        } else {
            soundStatusText.setText("Sound Off");
        }
    }
    // Called when the activity is first created.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game); // Set the content view to activity_game.xml

        // Find the SnakeGame view object in the activity's view hierarchy.
        // This enables the SnakeGame object to perform rendering.
        mSnakeGame = findViewById(R.id.snakeGame);
        mSnakeGame.setGameEventListener(this);


        // Find the Switch and TextView in the sound_checkbox_layout.xml layout
        Switch soundSwitch = findViewById(R.id.soundSwitch);
        soundSwitch.setThumbResource(R.drawable.custom_thumb);
        soundSwitch.setTrackResource(R.drawable.custom_track);
        soundSwitch.setThumbTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.switchThumbColor))); // Custom thumb color
        if (GlobalStateManager.getInstance().isSoundEnabled()) {
            soundSwitch.setChecked(true);
        } else {
            soundSwitch.setChecked(false);
        }
        TextView soundStatusText = findViewById(R.id.soundStatusText);

        // Initialize the text based on the initial state of the Switch
        updateSoundStatusText(soundSwitch.isChecked());

        // Set a listener to handle switch state changes
        soundSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
                    // Toggle the sound based on the switch state
                    AudioManagerImpl audioManager = AudioManagerImpl.getInstance(this);
                    audioManager.toggleSound();
                    GlobalStateManager.getInstance().setSoundEnabled(isChecked);

                    // Update the text based on the switch state
                    updateSoundStatusText(isChecked);

                });


        // Initialize the SnakeGame object.
//        mSnakeGame = new SnakeGame(this);

        // Set the current content view to Snake Game view for rendering the game.
//        setContentView(mSnakeGame);

    }

    // Called when the game is over.
    @Override
    public void onGameOver() {
        runOnUiThread(() -> {
            // Show the game over dialog
            showGameOverDialog();
        });
    }

    // Show the game over dialog
    private void showGameOverDialog() {
        // Create a new instance of the Dialog
        final Dialog dialog = new Dialog(this, R.style.CustomDialogTheme);
        dialog.setContentView(R.layout.game_over_layout);

        // Find the views within the dialog
        TextView scoreText = dialog.findViewById(R.id.scoreText);
        Button viewHighScoresButton = dialog.findViewById(R.id.viewHighScoresButton);
        Button playAgainButton = dialog.findViewById(R.id.playAgainButton);
        Button mainMenuButton = dialog.findViewById(R.id.mainMenuButton);

        // Update the score text with the score from the game
        scoreText.setText("Score: " + mSnakeGame.getGameManager().getScore());

        // Set up the button listeners
        viewHighScoresButton.setOnClickListener(v -> {
            // Handle the action for viewing high scores
            NavigationUtils.showHighScoreDialog(this);
            dialog.dismiss();
        });

        playAgainButton.setOnClickListener(v -> {
            // Handle the action for playing again
            dialog.dismiss();
            mSnakeGame.getGameManager().reset();
            mSnakeGame.resume(); // Resume the game
        });

        mainMenuButton.setOnClickListener(v -> {
            // Handle the action for returning to the main menu
            dialog.dismiss();
            mSnakeGame = null;
            NavigationUtils.returnToMainMenu(this);
        });

        // Show the dialog
        dialog.show();
    }


    // Called after onStop() when the current Activity is being re-displayed to the user.
    @Override
    protected void onResume() {
        super.onResume();

        // Resumes the game when the activity is resumed.
        mSnakeGame.resume();
    }

    // Called as part of the activity lifecycle when an activity is going into the background.
    @Override
    protected void onPause() {
        super.onPause();

        // Pauses the game when the activity is paused to ensure game state is maintained.
        mSnakeGame.pause();
    }
}