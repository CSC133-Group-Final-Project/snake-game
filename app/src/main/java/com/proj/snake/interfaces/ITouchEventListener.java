package com.proj.snake.interfaces;

import android.view.MotionEvent;

// Interface for handling touch events.
public interface ITouchEventListener {
    // Handle Bat movement events based on callback from TouchInputHandler.
    void onScreenTouched(MotionEvent motionEvent);
}