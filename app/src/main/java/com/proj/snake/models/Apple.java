package com.proj.snake.models;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;

import com.proj.snake.R;
import com.proj.snake.interfaces.IResettableEntity;
import com.proj.snake.utils.ScreenInfo;

import java.util.Random;

public class Apple implements IResettableEntity {
    private static Apple instance;

    // The location of the apple on the grid
    // Not in pixels
    private final Point location = new Point();

    // The range of values we can choose from
    // to spawn an apple
    private final Point mSpawnRange;
    private final int mSize;

    // An image to represent the apple
    private Bitmap mBitmapApple;

    /// Set up the apple in the constructor
    // Private constructor
    private Apple(Context context, Point sr, int s) {
        mSpawnRange = sr;
        mSize = s;
        location.x = -10;

        mBitmapApple = BitmapFactory.decodeResource(context.getResources(), R.drawable.apple);
        mBitmapApple = Bitmap.createScaledBitmap(mBitmapApple, s * 3, s * 3, false);
    }

    // Public static method to get instance
    public static Apple getInstance(Context context, Point sr, int s) {
        if (instance == null) {
            instance = new Apple(context, sr, s);
        }
        return instance;
    }

    public static Apple getRunningInstance() {
        return instance;
    }

    // This is called every time an apple is eaten
    @Override
    public void reset() {
        Random random = new Random();

        // Adjusted for the larger apple size (3 cells)
        int maxX = mSpawnRange.x - 3; // 3 cells width
        int maxY = mSpawnRange.y - 3; // 3 cells height

        // Randomly generate a new location within the adjusted boundaries
        location.x = random.nextInt(maxX + 1);
        location.y = random.nextInt(maxY + 1);
    }

    // Let SnakeGame know where the apple is
    // SnakeGame can share this with the snake
    public Point getLocation(){
        return location;
    }

    // Draw the apple
    public void draw(Canvas canvas, Paint paint) {
        // Calculate the top-left coordinates to draw the apple image
        // so that it's centered on its location
        int drawX = location.x * mSize + mSize / 2 - mBitmapApple.getWidth() / 2;
        int drawY = location.y * mSize + mSize / 2 - mBitmapApple.getHeight() / 2;

        canvas.drawBitmap(mBitmapApple, drawX, drawY, paint);
    }
}
