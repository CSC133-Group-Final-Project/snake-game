package com.proj.snake.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.proj.snake.R;
import com.proj.snake.managers.GameManager;
import com.proj.snake.utils.ScreenInfo;

// This class is used to render the game objects and HUD.
public class GameRenderer extends SurfaceView {
    // Instance of GameController to manage game objects.
    private final GameManager gameManager;
    // Screen width to be used for rendering and calculations.
    private final int screenX = ScreenInfo.getInstance().getScreenX();

    // Screen height to be used for rendering and calculations.
    private final int screenY = ScreenInfo.getInstance().getScreenY();
    // Objects needed for drawing on the canvas.
    private Canvas mCanvas;
    private final Paint mPaint;

    // Variables for font size and margin.
    private final int mFontSize;

    // Variable to hold frames per second.
    private long mFPS;

    // Variable to hold reference to the surface holder.
    private final SurfaceHolder mSurfaceHolder;

    // Background image for the game.
    private final android.graphics.Bitmap mBackgroundImage;


    // Constructor to initialize rendering components.
    public GameRenderer(Context context, SurfaceHolder mSurfaceHolder, GameManager gameManager) {
        super(context);
        this.gameManager = gameManager;


        // Resizing the background image to fit the screen.
        mBackgroundImage = Bitmap.createScaledBitmap(
                BitmapFactory.decodeResource(context.getResources(), R.drawable.snake_game_board),
                screenX,
                screenY,
                false);

        // Calculating font size and margin based on screen size.
        mFontSize = screenX / 20;
        int mFontMargin = screenX / 75;

        // Initializing drawing objects.
        this.mSurfaceHolder = mSurfaceHolder;
        mPaint = new Paint();
    }

    // Method to update frames per second.
    public void updateFPS(long fps) {
        mFPS = fps;
    }

    // Getter method for FPS.
    public long getFPS() {
        return mFPS;
    }

    // Do all the drawing
    public void draw() {
        // Get a lock on the mCanvas
        if (mSurfaceHolder.getSurface().isValid()) {
            // Objects for drawing
            mCanvas = mSurfaceHolder.lockCanvas();

            // Draw the background image
            mCanvas.drawBitmap(mBackgroundImage, 0, 0, null);

            // Set the size and color of the mPaint for the text
            mPaint.setColor(Color.argb(255, 255, 255, 255));
            mPaint.setTextSize(120);

            // Draw the score
            mCanvas.drawText("" + gameManager.getScore(), 20, 120, mPaint);


            // Draw the apple and the snake
            gameManager.getApple().draw(mCanvas, mPaint);
            gameManager.getSnake().draw(mCanvas, mPaint);

            // Set the size and color of the mPaint for the text
            mPaint.setColor(Color.argb(255, 255, 255, 255));
            mPaint.setTextSize(250);

            // Draw the message
            if (gameManager.isGamePaused()) {
                mPaint.setTextSize(250);

                float textWidth = mPaint.measureText(getResources().
                        getString(R.string.tap_to_play));
                float x = (screenX - textWidth) / 2;
                float y = 700;
                mCanvas.drawText(getResources().
                        getString(R.string.tap_to_play), x, y, mPaint);
            }

            // Draw some debugging text
            printDebuggingText();

            // Draw the SlowDownPowerUp
            gameManager.getSlowDownPowerUp().draw(mCanvas, mPaint);

            // Unlock the mCanvas and reveal the graphics for this frame
            mSurfaceHolder.unlockCanvasAndPost(mCanvas);
        }
    }


    // Method to print debugging text (FPS).
    private void printDebuggingText() {
        int debugSize = mFontSize / 2;
        int debugStart = 150;
        mPaint.setTextSize(debugSize);
        mCanvas.drawText("FPS: " + mFPS, 10, debugStart + debugSize, mPaint);
    }
}