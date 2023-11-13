package com.proj.snake.interfaces;

// This interface should be implemented by any class that wants to listen and respond to game events.
public interface IGameEventListener {
    // Called when the game is over.
    void onGameOver();
    // Called to resume the game.
    void resume();
    // Called to pause the game.
    void pause();
    // Called to unpause the game.
    void unpause();
    // Checks if the game is paused.
    boolean isPaused();
}
