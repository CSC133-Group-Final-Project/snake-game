package com.proj.snake.interfaces;

import android.view.MotionEvent;
import android.view.View;

// Interface for handling touch events.
public interface ITouchEventListener {
    // Handle Bat movement events based on callback from TouchInputHandler.
    boolean onTouch(View v, MotionEvent motionEvent);
}