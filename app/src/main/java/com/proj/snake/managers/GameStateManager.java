package com.proj.snake.managers;

import com.proj.snake.events.GameEventPublisher;
import com.proj.snake.utils.GameConstants;
import com.proj.snake.views.GameRenderer;

public class GameStateManager implements Runnable {
    // Objects for the game loop/thread
    private Thread mThread = null;

    // Is the game currently playing and or paused?
    private volatile boolean running = false;

    private final GameManager gameManager;
    private final GameRenderer gameRenderer;
    private final GameEventPublisher gameEventPublisher;

    public GameStateManager(GameManager gameManager, GameRenderer gameRenderer, GameEventPublisher gameEventPublisher) {
        this.gameManager = gameManager;
        this.gameRenderer = gameRenderer;
        this.gameEventPublisher = gameEventPublisher;
    }

    // Starts the game loop in a new thread if it is not already running
    public void start() {
        if (mThread == null || !mThread.isAlive()) {
            running = true; // set running to true
            mThread = new Thread(this); // create a new thread
            mThread.start(); // start the new thread
        }
    }

    // Returns the running status of the game loop
    public boolean isRunning() {
        return running;
    }

    // Stops the game loop and terminates the thread
    public void stop() {
        running = false; // set running to false
        try {
            if (mThread != null && mThread.isAlive()) {
                mThread.join(); // wait for the thread to terminate
                mThread = null; // set gameThread to null
            }
        } catch (InterruptedException e) {
            e.printStackTrace(); // print the stack trace of the exception
        }
    }

    // Handles the game loop
    @Override
    public void run() {
        while (running) {
            long frameStartTime = System.currentTimeMillis();
            if(!gameEventPublisher.notifyIsPaused()) {
                if (gameManager.updateRequired()) {
                    gameManager.update();
                }
            }
            gameRenderer.draw();

            long frameDuration = System.currentTimeMillis() - frameStartTime;
            if (frameDuration > 0) {
                gameRenderer.updateFPS(GameConstants.MILLIS_IN_SECOND / frameDuration);
            }
        }
    }
}

