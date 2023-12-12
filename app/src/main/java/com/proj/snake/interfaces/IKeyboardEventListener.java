package com.proj.snake.interfaces;

import android.view.KeyEvent;
import android.view.View;

public interface IKeyboardEventListener {
    boolean onKey(View v, int keyCode, KeyEvent event);
}
