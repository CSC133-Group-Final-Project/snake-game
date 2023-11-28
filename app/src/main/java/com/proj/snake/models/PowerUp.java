package com.proj.snake.models;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;

public abstract class PowerUp {
    protected Point location;
    protected int size;

    public PowerUp(Point location, int size) {
        this.location = location;
        this.size = size;
    }

    public Point getLocation() {
        return location;
    }

    public abstract void reset(Point spawnRange);
    public abstract void draw(Canvas canvas, Paint paint);
}
