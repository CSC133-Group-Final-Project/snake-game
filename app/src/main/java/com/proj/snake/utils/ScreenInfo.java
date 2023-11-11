package com.proj.snake.utils;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;

// This class is used to get the screen dimensions.
public class ScreenInfo {
    // Variables to hold screen width and height
    private final int mScreenX;
    private final int mScreenY;

    // Static variable to hold the singleton instance
    private static ScreenInfo sInstance = null;

    // Public method to initialize the singleton instance
    public static void init(Context context) {
        if (sInstance == null) {
            sInstance = new ScreenInfo(context);
        }
    }

    // Public method to get the singleton instance
    public static ScreenInfo getInstance() {
        if (sInstance == null) {
            throw new IllegalStateException("ScreenInfo not initialized. Call init(context) first.");
        }
        return sInstance;
    }

    // Private constructor used to initialize screen dimensions
    private ScreenInfo(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        // Get screen dimensions
        ((Activity)context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        mScreenX = displayMetrics.widthPixels;
        mScreenY = displayMetrics.heightPixels;
    }

    // Getter for block size
    public int getBlockSize() {
        return mScreenX / GameConstants.NUM_BLOCKS_WIDE;
    }

    // Getter for maximum number of blocks based on height
    public int getNumBlocksHigh() {
        return mScreenY / getBlockSize();
    }
}