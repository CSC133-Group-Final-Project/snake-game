package com.proj.snake.controllers;

import android.view.MotionEvent;
import android.view.View;

import com.proj.snake.events.GameEventPublisher;
import com.proj.snake.interfaces.ITouchEventListener;
import com.proj.snake.models.Snake;

public class TouchInputController implements View.OnTouchListener {

    private final GameEventPublisher gameEventPublisher;
    private ITouchEventListener touchEventListener;
    private Snake mSnake = Snake.getRunningInstance();

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
            mSnake.switchHeading(motionEvent);
        }
        return true;
    }
}