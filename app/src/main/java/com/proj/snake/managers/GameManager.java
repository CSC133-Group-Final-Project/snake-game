package com.proj.snake.managers;


import android.content.Context;
import android.graphics.Point;
import android.util.Log;
import android.view.MotionEvent;

import com.proj.snake.events.GameEventPublisher;
import com.proj.snake.interfaces.IAudioManager;
import com.proj.snake.interfaces.IGameEventListener;
import com.proj.snake.interfaces.ITouchEventListener;
import com.proj.snake.models.Apple;
import com.proj.snake.models.Snake;
import com.proj.snake.models.HighScoreBoard;
import com.proj.snake.utils.GameConstants;
import com.proj.snake.utils.ScreenInfo;

public class GameManager implements ITouchEventListener {
    // A snake ssss
    private final Snake mSnake;
    private final Apple mApple;
    private final GameEventPublisher gameEventPublisher;
    private final IAudioManager audioManager;

    private final HighScoreBoard scoreBoard;
    private static long mNextFrameTime; // the time the next frame should be drawn

    public GameManager(Context context, GameEventPublisher gameEventPublisher) {
        // Initialize screen info.
        ScreenInfo.init(context);

        // Initialize game entities.
        // Call the constructors of our two game objects
        mApple = new Apple(context,
                new Point(GameConstants.NUM_BLOCKS_WIDE,
                        ScreenInfo.getInstance().getNumBlocksHigh()),
                ScreenInfo.getInstance().getBlockSize());

        mSnake = new Snake(context,
                new Point(GameConstants.NUM_BLOCKS_WIDE,
                        ScreenInfo.getInstance().getNumBlocksHigh()),
                ScreenInfo.getInstance().getBlockSize());

        this.gameEventPublisher = gameEventPublisher;

        // Initialize the SoundPool
        audioManager = AudioManagerImpl.getInstance(context);

        // Initialize the Highscore board
        scoreBoard = HighScoreBoard.getInstance();

        reset();
    }

    // Reset the game state.
    public void reset() {
        // reset the snake
        mSnake.reset(GameConstants.NUM_BLOCKS_WIDE, ScreenInfo.getInstance().getNumBlocksHigh());
        // Get the apple ready for dinner
        mApple.spawn();
        // Reset the mScore
        scoreBoard.resetScore();
        // Setup mNextFrameTime so an update can triggered
        mNextFrameTime = System.currentTimeMillis();
    }

    // Getter for the snake.
    public Snake getSnake() {
        return mSnake;
    }

    // Getter for the apple.
    public Apple getApple() {
        return mApple;
    }

    // Getter for the score.
    public int getScore() {
        return scoreBoard.getScore();
    }

    // Check to see if it is time for an update
    public boolean updateRequired() {
        // Run at 10 frames per second
        final long TARGET_FPS = 10;
        // There are 1000 milliseconds in a second
        final long MILLIS_PER_SECOND = 1000;
        // Are we due to update the frame
        if(mNextFrameTime <= System.currentTimeMillis()){
            // Tenth of a second has passed
            // Setup when the next update will be triggered
            mNextFrameTime =System.currentTimeMillis()
                    + MILLIS_PER_SECOND / TARGET_FPS;
            // Return true so that the update and draw
            // methods are executed
            return true;
        }
        return false;
    }

    // Update all the game objects
    public void update() {
        // Move the snake
        mSnake.move();
        // Did the head of the snake eat the apple?
        if(mSnake.checkDinner(mApple.getLocation())){
            // This reminds me of Edge of Tomorrow.
            // One day the apple will be ready!
            mApple.spawn();
            scoreBoard.addScore();
            // Play a sound
            audioManager.play(GameConstants.EAT_SOUND);
        }
        // Did the snake die?
        if (mSnake.detectDeath()) {
            // Pause the game ready to start again
            audioManager.play(GameConstants.DEATH_SOUND);
            gameEventPublisher.notifyGameOver();
            scoreBoard.resetScore();
        }
    }


    // Handle Bat movement events based on callback from TouchInputHandler.
    @Override
    public void onScreenTouched(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & MotionEvent.ACTION_MASK) == MotionEvent.ACTION_UP) {
            if (gameEventPublisher.notifyIsPaused()) {
                reset();
            }
            // Let the Snake class handle the input
            mSnake.switchHeading(motionEvent);
        }
    }

    public boolean isGamePaused() {
        return gameEventPublisher.notifyIsPaused();
    }
}
