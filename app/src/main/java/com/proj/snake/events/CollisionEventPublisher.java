package com.proj.snake.events;

import android.graphics.Point;

import com.proj.snake.interfaces.ICollisionEventListener;
import com.proj.snake.utils.ScreenInfo;

import java.util.ArrayList;
import java.util.List;

public class CollisionEventPublisher {
    // Assume new class variables headSize and bodySize
    private final List<ICollisionEventListener> listeners = new ArrayList<>();


    // Method to add a collision event listener
    public void addListener(ICollisionEventListener listener) {
        listeners.add(listener);
    }

    // Method to remove a collision event listener
    public void removeListener(ICollisionEventListener listener) {
        listeners.remove(listener);
    }

    // Check collision with wall
    // Method to check collision with wall
    public void checkCollisionWithWall(Point head, Point moveRange, int headSize) {
        // Calculate the bounds of the snake's head
        int headLeft = head.x * headSize;
        int headTop = head.y * headSize;
        int headRight = headLeft + headSize;
        int headBottom = headTop + headSize;

        // Check if any part of the head is outside the grid
        if (headLeft < 0 || headRight > moveRange.x * headSize ||
                headTop < 0 || headBottom > moveRange.y * headSize) {
            publishCollisionWithWall();
        }
    }

    // Check collision with self
    public void checkCollisionWithSelf(List<Point> segmentLocations) {
        Point head = segmentLocations.get(0);
        for (int i = segmentLocations.size() - 1; i > 0; i--) {
            if (head.x == segmentLocations.get(i).x && head.y == segmentLocations.get(i).y) {
                publishCollisionWithSelf();
                break;
            }
        }
    }

    // Method to check collision with food
    public void checkCollisionWithFood(List<Point> segmentLocations, Point foodLocation) {
        int gridSize = ScreenInfo.getInstance().getBlockSize();
        Point head = segmentLocations.get(0);

        // Calculate the bounds of the snake's head, centered on its grid cell
        double headLeft = head.x * gridSize + gridSize / 2 - gridSize * 1.5;
        double headTop = head.y * gridSize + gridSize / 2 - gridSize * 1.5;
        double headRight = headLeft + gridSize * 2;
        double headBottom = headTop + gridSize * 2;

        // Calculate the bounds of the apple, centered on its grid cell
        double appleLeft = foodLocation.x * gridSize + gridSize / 2 - gridSize * 1.5;
        double appleTop = foodLocation.y * gridSize + gridSize / 2 - gridSize * 1.5;
        double appleRight = appleLeft + gridSize * 2;
        double appleBottom = appleTop + gridSize * 2;

        // Check if the rectangles overlap
        if (headRight > appleLeft && headLeft < appleRight &&
                headBottom > appleTop && headTop < appleBottom) {
            publishCollisionWithFood();
        }
    }


    // Method to check collision with power-up
    public void checkCollisionWithPowerUp(List<Point> segmentLocations, Point powerUpLocation) {
        if (segmentLocations.get(0).x == powerUpLocation.x && segmentLocations.get(0).y == powerUpLocation.y) {
            publishCollisionWithPowerUp();
        }
    }

    private void publishCollisionWithPowerUp() {
        for (ICollisionEventListener listener : listeners) {
            listener.onCollisionWithPowerUp();
        }
    }

    private void publishCollisionWithWall() {
        for (ICollisionEventListener listener : listeners) {
            listener.onCollisionWithWall();
        }
    }

    private void publishCollisionWithSelf() {
        for (ICollisionEventListener listener : listeners) {
            listener.onCollisionWithSelf();
        }
    }

    private void publishCollisionWithFood() {
        for (ICollisionEventListener listener : listeners) {
            listener.onCollisionWithFood();
        }
    }
}
