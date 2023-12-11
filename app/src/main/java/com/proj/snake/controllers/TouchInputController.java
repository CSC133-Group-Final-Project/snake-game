package com.proj.snake.controllers;

import android.view.MotionEvent;
import android.view.View;

import com.proj.snake.events.GameEventPublisher;
import com.proj.snake.interfaces.ITouchEventListener;

public class TouchInputController implements View.OnTouchListener {

    private final GameEventPublisher gameEventPublisher;
    private ITouchEventListener touchEventListener;

    public TouchInputController(GameEventPublisher gameEventPublisher) {
        this.gameEventPublisher = gameEventPublisher;
    }

    public void setTouchEventListener(ITouchEventListener touchEventListener) {
        this.touchEventListener = touchEventListener;
    }

    // Overriding the onTouch method to handle touch events.
    @Override
    public boolean onTouch(View v, MotionEvent motionEvent) {
        // Using a switch statement to handle different touch actions.
        // When the screen is touched.
        if ((motionEvent.getAction() & MotionEvent.ACTION_MASK) == MotionEvent.ACTION_UP) {// Notify to unpause the game.
            gameEventPublisher.notifyUnpause();
            // Calling the onScreenTouched method on touchEventListener,
            touchEventListener.onScreenTouched(motionEvent);
            // When the touch is released.
        }
        // Returning true to indicate that the event has been handled.
        return true;
    }
}
