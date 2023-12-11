package com.proj.snake.views;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.widget.Button;
import android.widget.TextView;

import com.proj.snake.R;
import com.proj.snake.controllers.KeyboardInputController;
import com.proj.snake.controllers.TouchInputController;
import com.proj.snake.events.GameEventPublisher;
import com.proj.snake.interfaces.IGameEventListener;
import com.proj.snake.managers.GameManager;
import com.proj.snake.managers.GameStateManager;
import com.proj.snake.utils.NavigationUtils;

public class SnakeGame extends SurfaceView implements IGameEventListener {
    // Flag to check whether the game is paused.
    private boolean mPaused = true;

    private final GameManager gameManager;

    private final GameStateManager gameStateManager;

    // Callback interface for game events
    public interface GameEventListener {
        void onGameOver();
    }

    private GameEventListener gameEventListener;

    public void setGameEventListener(GameEventListener listener) {
        this.gameEventListener = listener;
    }

    // This is the constructor method that gets called
    // from SnakeActivity
    public SnakeGame(Context context, AttributeSet attrs) {
        super(context, attrs);

        GameEventPublisher gameEventPublisher = new GameEventPublisher();
        gameEventPublisher.addListener(this);

        gameManager = new GameManager(context, gameEventPublisher);

        GameRenderer gameRenderer = new GameRenderer(context, getHolder(), gameManager);

        TouchInputController inputController = new TouchInputController(gameEventPublisher);
        this.setOnTouchListener(inputController);

        // Set this as the key listener
        KeyboardInputController keyboardController = new KeyboardInputController(gameEventPublisher);
        this.setFocusable(true);
        this.setOnKeyListener(keyboardController);


        gameStateManager = new GameStateManager(gameManager, gameRenderer, gameEventPublisher);
    }

    // Pausing the game and stopping the game loop.
    @Override
    public void pause() {
        mPaused = true;
        gameStateManager.stop();
    }

    // Unpausing the game.
    @Override
    public void unpause() {
        mPaused = false;
    }

    // Resuming the game loop if it's not running.
    @Override
    public void resume() {
        if (!gameStateManager.isRunning()) {
            gameStateManager.start();

        }
    }

    // Handling game over by pausing the game and resetting the game controller.
    @Override
    public void onGameOver() {
        mPaused = true;
        if (gameEventListener != null) {
            gameEventListener.onGameOver();
        }
    }

    public GameManager getGameManager() {
        return gameManager;
    }

    // Returns whether the game is paused.
    @Override
    public boolean isPaused() {
        return mPaused;
    }
}