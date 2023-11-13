package com.proj.snake.views;

import android.content.Context;
import android.view.SurfaceView;

import com.proj.snake.controllers.InputController;
import com.proj.snake.events.GameEventPublisher;
import com.proj.snake.interfaces.IGameEventListener;
import com.proj.snake.managers.GameManager;
import com.proj.snake.managers.GameStateManager;
import com.proj.snake.utils.ScreenInfo;ereet

public class SnakeGame extends SurfaceView implements IGameEventListener {
    // Flag to check whether the game is paused.
    private boolean mPaused = true;

    private final GameManager gameManager;

    private final GameStateManager gameStateManager;

    private final GameEventPublisher gameEventPublisher;

    // This is the constructor method that gets called
    // from SnakeActivity
    public SnakeGame(Context context) {
        super(context);

        gameEventPublisher = new GameEventPublisher();
        gameEventPublisher.addListener(this);

        gameManager = new GameManager(context, gameEventPublisher);

        GameRenderer gameRenderer = new GameRenderer(context, getHolder(), gameManager);

        InputController inputController = new InputController(gameEventPublisher);
        inputController.setTouchEventListener(gameManager);

        this.setOnTouchListener(inputController);

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
        gameManager.reset();
    }

    // Returns whether the game is paused.
    @Override
    public boolean isPaused() {
        return mPaused;
    }
}