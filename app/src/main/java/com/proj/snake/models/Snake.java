package com.proj.snake.models;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.MotionEvent;

import com.proj.snake.R;
import com.proj.snake.events.CollisionEventPublisher;
import com.proj.snake.interfaces.IResettableEntity;
import com.proj.snake.utils.GameConstants;
import com.proj.snake.utils.ScreenInfo;

import java.util.ArrayList;

public class Snake implements IResettableEntity {

    // The location in the grid of all the segments
    private ArrayList<Point> segmentLocations;

    // How big is each segment of the snake?
    private int mSegmentSize;

    // How big is the entire grid
    private Point mMoveRange;

    // Where is the centre of the screen
    // horizontally in pixels?
    private int halfWayPoint;

    private boolean isDead = false;
    private boolean isSlowedDown = false;
    private long slowDownEndTime = 0;
    private boolean moveThisFrame = true;

    private final CollisionEventPublisher collisionEventPublisher;



    public void onCollisionWithFood() {
        segmentLocations.add(new Point(-10, -10));
    }

    // For tracking movement Heading
    private enum Heading {
        UP, RIGHT, DOWN, LEFT
    }

    // Start by heading to the right
    private Heading heading = Heading.RIGHT;

    // A bitmap for each direction the head can face
    private Bitmap mBitmapHeadRight;
    private Bitmap mBitmapHeadLeft;
    private Bitmap mBitmapHeadUp;
    private Bitmap mBitmapHeadDown;

    // A bitmap for the body
    private Bitmap mBitmapBody;

    public Snake(Context context, Point mr, int ss, CollisionEventPublisher collisionEventPublisher) {
        // Initialize our ArrayList
        segmentLocations = new ArrayList<>();

        // Initialize the segment size and movement
        // range from the passed in parameters
        mSegmentSize = ss;
        mMoveRange = mr;

        // Create and scale the bitmaps
        mBitmapHeadRight = BitmapFactory
                .decodeResource(context.getResources(),
                        R.drawable.head);

        // Create 3 more versions of the head for different headings
        mBitmapHeadLeft = BitmapFactory
                .decodeResource(context.getResources(),
                        R.drawable.head);

        mBitmapHeadUp = BitmapFactory
                .decodeResource(context.getResources(),
                        R.drawable.head);

        mBitmapHeadDown = BitmapFactory
                .decodeResource(context.getResources(),
                        R.drawable.head);

        // Modify the bitmaps to face the snake head
        // in the correct direction
        mBitmapHeadRight = Bitmap
                .createScaledBitmap(mBitmapHeadRight,
                        ss, ss, false);

        // A matrix for scaling
        Matrix matrix = new Matrix();
        matrix.preScale(-1, 1);

        mBitmapHeadLeft = Bitmap
                .createBitmap(mBitmapHeadRight,
                        0, 0, ss, ss, matrix, true);

        // A matrix for rotating
        matrix.preRotate(-90);
        mBitmapHeadUp = Bitmap
                .createBitmap(mBitmapHeadRight,
                        0, 0, ss, ss, matrix, true);

        // Matrix operations are cumulative
        // so rotate by 180 to face down
        matrix.preRotate(180);
        mBitmapHeadDown = Bitmap
                .createBitmap(mBitmapHeadRight,
                        0, 0, ss, ss, matrix, true);

        // Create and scale the body
        mBitmapBody = BitmapFactory
                .decodeResource(context.getResources(),
                        R.drawable.body);

        mBitmapBody = Bitmap
                .createScaledBitmap(mBitmapBody,
                        ss, ss, false);

        // The halfway point across the screen in pixels
        // Used to detect which side of screen was pressed
        halfWayPoint = mr.x * ss / 2;

        this.collisionEventPublisher = collisionEventPublisher;
    }

    // Get the snake ready for a new game
    @Override
    public void reset() {

        // Reset the heading
        heading = Heading.RIGHT;

        // Delete the old contents of the ArrayList
        segmentLocations.clear();

        // Start with a single snake segment
        segmentLocations.add(new Point(GameConstants.NUM_BLOCKS_WIDE / 2, ScreenInfo.getInstance().getNumBlocksHigh() / 2));
    }

    public void move() {
        // Check if slow down mode is active and timer has expired
        if (isSlowedDown && System.currentTimeMillis() > slowDownEndTime) {
            isSlowedDown = false;
        }

        // Slow down movement if in slow down mode
        if (isSlowedDown) {
            // Alternate between moving and not moving each frame
            if (moveThisFrame) {
                updateSnakePosition(); // Update the position this frame
                moveThisFrame = false; // Skip the next frame
            } else {
                moveThisFrame = true; // Move on the next frame
            }
        } else {
            // Normal movement logic, moving every frame
            updateSnakePosition();
            collisionEventPublisher.checkCollisionWithPowerUp(segmentLocations, SlowDownPowerUp.getInstance().getLocation());
        }
    }

    private void updateSnakePosition() {
        // Move the body
        for (int i = segmentLocations.size() - 1; i > 0; i--) {
            segmentLocations.get(i).x = segmentLocations.get(i - 1).x;
            segmentLocations.get(i).y = segmentLocations.get(i - 1).y;
        }

        // Move the head
        Point head = segmentLocations.get(0);
        switch (heading) {
            case UP:
                head.y--;
                break;
            case RIGHT:
                head.x++;
                break;
            case DOWN:
                head.y++;
                break;
            case LEFT:
                head.x--;
                break;
        }

        // Check for collisions after moving the head
        collisionEventPublisher.checkCollisionWithWall(head, mMoveRange);
        collisionEventPublisher.checkCollisionWithSelf(segmentLocations);
        collisionEventPublisher.checkCollisionWithFood(segmentLocations, Apple.getRunningInstance().getLocation());
    }

    public Point getHeadLocation() {
        // Assuming the head is always at index 0
        return segmentLocations.get(0);
    }

    public void setSlowDownMode(boolean slowDown) {
        this.isSlowedDown = slowDown;
        this.slowDownEndTime = System.currentTimeMillis() + 15000; // 15 seconds
    }

    public void grow() {
        // Grab the last segment in the ArrayList
        // which will be the tail of the snake
        Point lastSegment = segmentLocations.get(segmentLocations.size() - 1);

        // Duplicate this point and add it to the end of the snake
        segmentLocations.add(new Point(lastSegment.x, lastSegment.y));
    }

    public void draw(Canvas canvas, Paint paint) {

        // Don't run this code if ArrayList has nothing in it
        if (!segmentLocations.isEmpty()) {
            // All the code from this method goes here
            // Draw the head
            switch (heading) {
                case RIGHT:
                    canvas.drawBitmap(mBitmapHeadRight,
                            segmentLocations.get(0).x
                                    * mSegmentSize,
                            segmentLocations.get(0).y
                                    * mSegmentSize, paint);
                    break;

                case LEFT:
                    canvas.drawBitmap(mBitmapHeadLeft,
                            segmentLocations.get(0).x
                                    * mSegmentSize,
                            segmentLocations.get(0).y
                                    * mSegmentSize, paint);
                    break;

                case UP:
                    canvas.drawBitmap(mBitmapHeadUp,
                            segmentLocations.get(0).x
                                    * mSegmentSize,
                            segmentLocations.get(0).y
                                    * mSegmentSize, paint);
                    break;

                case DOWN:
                    canvas.drawBitmap(mBitmapHeadDown,
                            segmentLocations.get(0).x
                                    * mSegmentSize,
                            segmentLocations.get(0).y
                                    * mSegmentSize, paint);
                    break;
            }

            // Draw the snake body one block at a time
            for (int i = 1; i < segmentLocations.size(); i++) {
                canvas.drawBitmap(mBitmapBody,
                        segmentLocations.get(i).x
                                * mSegmentSize,
                        segmentLocations.get(i).y
                                * mSegmentSize, paint);
            }
        }
    }


    // Handle changing direction
    public void switchHeading(MotionEvent motionEvent) {

        // Is the tap on the right hand side?
        if (motionEvent.getX() >= halfWayPoint) {
            switch (heading) {
                // Rotate right
                case UP:
                    heading = Heading.RIGHT;
                    break;
                case RIGHT:
                    heading = Heading.DOWN;
                    break;
                case DOWN:
                    heading = Heading.LEFT;
                    break;
                case LEFT:
                    heading = Heading.UP;
                    break;

            }
        } else {
            // Rotate left
            switch (heading) {
                case UP:
                    heading = Heading.LEFT;
                    break;
                case LEFT:
                    heading = Heading.DOWN;
                    break;
                case DOWN:
                    heading = Heading.RIGHT;
                    break;
                case RIGHT:
                    heading = Heading.UP;
                    break;
            }
        }
    }
}
