package com.proj.snake.views;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;

import com.proj.snake.R;

// SnakeActivity class is the main Activity for the Pong game.
// It manages the lifecycle of the PongGame object, ensuring it
// pauses and resumes as the Activity lifecycle changes.
public class SnakeActivity extends Activity {
    // mPongGame is an instance of the PongGame class which handles the game logic and rendering.
    private SnakeGame mSnakeGame;
    MediaPlayer mySong;

    // Called when the activity is first created.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialize the PongGame object.
        mSnakeGame = new SnakeGame(this);

        // Set the current content view to PongGame view for rendering the game.
        setContentView(mSnakeGame);

        mySong=MediaPlayer.create(SnakeActivity.this, R.raw.pop);
    }

    // Called after onStop() when the current Activity is being re-displayed to the user.
    @Override
    protected void onResume() {
        super.onResume();

        // Resumes the game when the activity is resumed.
        mSnakeGame.resume();

        mySong.setLooping(true);
        mySong.start();
    }

    // Called as part of the activity lifecycle when an activity is going into the background.
    @Override
    protected void onPause() {
        super.onPause();

        // Pauses the game when the activity is paused to ensure game state is maintained.
        mSnakeGame.pause();

        mySong.release();
    }
}
