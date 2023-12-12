package com.proj.snake.views;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.view.View;
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

    // This is the constructor method that gets called
    // from SnakeActivity
    public SnakeGame(Context context, AttributeSet attrs) {
        super(context, attrs);

        GameEventPublisher gameEventPublisher = new GameEventPublisher();
        gameEventPublisher.addListener(this);

        gameManager = new GameManager(context, gameEventPublisher);

        GameRenderer gameRenderer = new GameRenderer(context, getHolder(), gameManager);

        TouchInputController inputController = new TouchInputController(gameEventPublisher, gameManager.getSnake());
        this.setOnTouchListener(inputController);

        // Set this as the key listener
        KeyboardInputController keyboardController = new KeyboardInputController(gameEventPublisher, gameManager.getSnake());
        this.setFocusable(true);
        this.setOnKeyListener(keyboardController);


        this.setOnTouchListener((View.OnTouchListener) inputController);
        this.setOnKeyListener((View.OnKeyListener) keyboardController);

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
        ((Activity) getContext()).runOnUiThread(this::showGameOverDialog);

        //gameManager.reset();
    }

    // Returns whether the game is paused.
    @Override
    public boolean isPaused() {
        return mPaused;
    }

    private void showGameOverDialog() {
        final Dialog dialog = new Dialog(getContext(), R.style.CustomDialogTheme);
        dialog.setContentView(R.layout.game_over_layout);

        TextView scoreText = dialog.findViewById(R.id.scoreText);
        Button viewHighScoresButton = dialog.findViewById(R.id.viewHighScoresButton);
        Button playAgainButton = dialog.findViewById(R.id.playAgainButton);
        Button mainMenuButton = dialog.findViewById(R.id.mainMenuButton);

        // Update the score text
        scoreText.setText("Score: " + gameManager.getScore());

        // Set up button listeners
        viewHighScoresButton.setOnClickListener(v -> {
            // Handle view high scores action
            NavigationUtils.showHighScoreDialog((Activity) getContext());

        });

        playAgainButton.setOnClickListener(v -> {
            // Handle play again action
            dialog.dismiss();
            gameManager.reset();
            resume(); // Resume the game
        });

        mainMenuButton.setOnClickListener(v -> {
            // Handle return to main menu action
            dialog.dismiss();
            NavigationUtils.returnToMainMenu((Activity) getContext());
        });

        dialog.show();
    }
}