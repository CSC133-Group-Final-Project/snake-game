package com.proj.snake.activities;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.widget.Switch;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.proj.snake.R;
import com.proj.snake.managers.AudioManagerImpl;
import com.proj.snake.managers.GlobalStateManager;
import com.proj.snake.views.SnakeGame;

// SnakeActivity class is the main Activity for the Pong game.
// It manages the lifecycle of the PongGame object, ensuring it
// pauses and resumes as the Activity lifecycle changes.
public class SnakeActivity extends Activity {
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
        AudioManagerImpl audioManager = AudioManagerImpl.getInstance(this);

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

        // Initialize the text based on the initial state of the Switch
        updateSoundStatusText(soundSwitch.isChecked());

        // Set a listener to handle switch state changes
        soundSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
                    // Toggle the sound based on the switch state and current sound state from the GlobalStateManager
                    if (GlobalStateManager.getInstance().isSoundEnabled()) {
                        audioManager.toggleSound(false);
                        GlobalStateManager.getInstance().setSoundEnabled(false);
                    } else {
                        audioManager.toggleSound(true);
                        GlobalStateManager.getInstance().setSoundEnabled(true);
                    }
                    // Update the text based on the switch state
                    updateSoundStatusText(isChecked);
                });
    }

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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AudioManagerImpl.getInstance(this).deinitSounds();
    }
}