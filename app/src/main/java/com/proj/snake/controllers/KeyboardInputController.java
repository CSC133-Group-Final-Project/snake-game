package com.proj.snake.controllers;

import android.view.KeyEvent;
import android.view.View;

import com.proj.snake.events.GameEventPublisher;
import com.proj.snake.models.Snake;

public class KeyboardInputController implements View.OnKeyListener {
    private final GameEventPublisher gameEventPublisher;

    public KeyboardInputController(GameEventPublisher gameEventPublisher, Snake snake) {
        this.gameEventPublisher = gameEventPublisher;
        mSnake = snake;
    }

    private Snake mSnake;



    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (event.getKeyCode()) {
                case KeyEvent.KEYCODE_DPAD_UP:
                    mSnake.switchDirection(0);
                    break;
                case KeyEvent.KEYCODE_DPAD_DOWN:
                    mSnake.switchDirection(2);
                    break;
                case KeyEvent.KEYCODE_DPAD_LEFT:
                    mSnake.switchDirection(3);
                    break;
                case KeyEvent.KEYCODE_DPAD_RIGHT:
                    mSnake.switchDirection(1);
                    break;
                case KeyEvent.KEYCODE_SPACE:
                    if (gameEventPublisher.notifyIsPaused()) {
                        gameEventPublisher.notifyUnpause();
                    }
                    break;
            }
        }
        return true;
    }
}