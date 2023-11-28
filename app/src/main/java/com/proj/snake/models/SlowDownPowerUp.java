package com.proj.snake.models;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;

import com.proj.snake.R;

import java.util.Random;

public class SlowDownPowerUp extends PowerUp {

    private Bitmap bitmap;
    private static SlowDownPowerUp instance = null;


    private SlowDownPowerUp(Context context, Point spawnRange, int size) {
        super(new Point(), size);
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.fastfood);
        bitmap = Bitmap.createScaledBitmap(bitmap, size, size, false);
        reset(spawnRange);
    }

    // Method to get singleton instance
    public static synchronized SlowDownPowerUp getInstance(Context context, Point spawnRange, int size) {
        if (instance == null) {
            instance = new SlowDownPowerUp(context, spawnRange, size);
        }
        return instance;
    }

    // Method to get running instance
    public static synchronized SlowDownPowerUp getInstance() {
        return instance;
    }

    @Override
    public void reset(Point spawnRange) {
        Random random = new Random();
        location.x = random.nextInt(spawnRange.x) + 1;
        location.y = random.nextInt(spawnRange.y - 1) + 1;
    }

    @Override
    public void draw(Canvas canvas, Paint paint) {
        canvas.drawBitmap(bitmap, location.x * size, location.y * size, paint);
    }
}
