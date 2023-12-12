package com.proj.snake.managers;


import android.content.Context;
import android.graphics.Point;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;

import com.proj.snake.events.CollisionEventPublisher;
import com.proj.snake.events.GameEventPublisher;
import com.proj.snake.interfaces.IAudioManager;
import com.proj.snake.interfaces.ICollisionEventListener;
import com.proj.snake.interfaces.IKeyboardEventListener;
import com.proj.snake.interfaces.IResettableEntity;
import com.proj.snake.interfaces.ITouchEventListener;
import com.proj.snake.models.Apple;
import com.proj.snake.models.HighScore;
import com.proj.snake.models.HighScoreBoard;
import com.proj.snake.models.Score;
import com.proj.snake.models.SlowDownPowerUp;
import com.proj.snake.models.Snake;
import com.proj.snake.utils.GameConstants;
import com.proj.snake.utils.ScreenInfo;
import android.os.Vibrator;


import java.util.ArrayList;
import java.util.List;

public class GameManager implements ICollisionEventListener {
    // A snake ssss
    private final Snake mSnake;
    private final Apple mApple;
    private final GameEventPublisher gameEventPublisher;
    private final IAudioManager audioManager;

    private final Score scoreBoard;

    private SlowDownPowerUp slowDownPowerUp;

    private final Point spawnRange;

    private final String playerName = GlobalStateManager.getInstance().getUsername();

    private static long mNextFrameTime; // the time the next frame should be drawn
    private final List<IResettableEntity> resettables = new ArrayList<>();

    // store context passed in from SnakeActivity
    private Context mContext;
    private final Vibrator vibrator;




    public GameManager(Context context, GameEventPublisher gameEventPublisher) {
        mContext = context;
        // Initialize screen info.
        ScreenInfo.init(context);

        vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);


        // Initialize collision event publisher.
        CollisionEventPublisher collisionEventPublisher = new CollisionEventPublisher();
        collisionEventPublisher.addListener(this);

        // Initialize game entities.
        // Call the constructors of our two game objects
        mApple = Apple.getInstance(context,
                new Point(GameConstants.NUM_BLOCKS_WIDE,
                        ScreenInfo.getInstance().getNumBlocksHigh()),
                ScreenInfo.getInstance().getBlockSize());

        mSnake = new Snake(context,
                new Point(GameConstants.NUM_BLOCKS_WIDE,
                        ScreenInfo.getInstance().getNumBlocksHigh()),
                ScreenInfo.getInstance().getBlockSize(), collisionEventPublisher);

        this.gameEventPublisher = gameEventPublisher;


        // Initialize the SoundPool
        audioManager = AudioManagerImpl.getInstance(context);

        // Initialize the score board
        scoreBoard = Score.getInstance();

        // Initialize the high score

        // Add resettable entities to the list of resettables.
        resettables.add(mSnake);
        resettables.add(scoreBoard);
        resettables.add(mApple);

        spawnRange = new Point(GameConstants.NUM_BLOCKS_WIDE, ScreenInfo.getInstance().getNumBlocksHigh());
        this.slowDownPowerUp = SlowDownPowerUp.getInstance(context, spawnRange, ScreenInfo.getInstance().getBlockSize());

        reset();
    }

    // Reset the game state.
    public void reset() {
        for (IResettableEntity resettable : resettables) {
            resettable.reset();
        }
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
        if (mNextFrameTime <= System.currentTimeMillis()) {
            // Tenth of a second has passed
            // Setup when the next update will be triggered
            mNextFrameTime = System.currentTimeMillis()
                    + MILLIS_PER_SECOND / TARGET_FPS;
            // Return true so that the update and draw
            // methods are executed
            return true;
        }
        return false;
    }

    // Update all the game objects
    public void update() {
        mSnake.move();
    }


    public boolean isGamePaused() {
        return gameEventPublisher.notifyIsPaused();
    }

    @Override
    public void onCollisionWithWall() {
        Log.d("Collision", "Collision with wall");
        audioManager.play(GameConstants.DEATH_SOUND);
        provideHapticFeedback();
        gameEventPublisher.notifyGameOver();
    }

    @Override
    public void onCollisionWithSelf() {
        Log.d("Collision", "Collision with self");
        audioManager.play(GameConstants.DEATH_SOUND);
        provideHapticFeedback();
        gameEventPublisher.notifyGameOver();
    }

    @Override
    public void onCollisionWithFood() {
        Log.d("Collision", "Collision with food");
        mApple.reset();
        audioManager.play(GameConstants.EAT_SOUND);
        scoreBoard.addScore();
        HighScore highScore = new HighScore(playerName, scoreBoard.getScore());
        HighScoreBoard.getInstance().addScore(mContext, highScore);
        provideHapticFeedback();
        mSnake.grow();

        // Check for collision with SlowDownPowerUp
        if (mSnake.getHeadLocation().equals(slowDownPowerUp.getLocation())) {
            // Activate slow down effect
            mSnake.setSlowDownMode(true);
            // Reset power-up location
            slowDownPowerUp.reset(spawnRange);
        }
    }

    @Override
    public void onCollisionWithPowerUp() {
        // Handle the logic when the snake collides with the power-up
        // For instance, activate slow-down mode and reset power-up location
        mSnake.setSlowDownMode(true);
        provideHapticFeedback();
        slowDownPowerUp.reset(spawnRange);
    }

    // Method to get SlowDownPowerUp
    public SlowDownPowerUp getSlowDownPowerUp() {
        return slowDownPowerUp;
    }

    private void provideHapticFeedback() {
        // Check if the device has a vibrator
        if (vibrator.hasVibrator()) {
            // Vibrate for a specified length of time
            // You can adjust the duration as needed
            long vibrationDuration = 100; // milliseconds
            vibrator.vibrate(vibrationDuration);
        }
    }

}

