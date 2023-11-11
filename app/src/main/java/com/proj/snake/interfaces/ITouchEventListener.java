package com.proj.snake.interfaces;

// Interface for handling touch events.
public interface ITouchEventListener {
    // Called when the screen is touched.
    void onScreenTouch(float x);
    // Called when the screen is released.
    void onScreenRelease();
}