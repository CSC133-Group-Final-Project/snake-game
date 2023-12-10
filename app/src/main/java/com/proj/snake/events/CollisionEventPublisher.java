package com.proj.snake.events;

import android.graphics.Point;

import com.proj.snake.interfaces.ICollisionEventListener;
import com.proj.snake.utils.ScreenInfo;

import java.util.ArrayList;
import java.util.List;

public class CollisionEventPublisher {
    // Assume new class variables headSize and bodySize
    private final List<ICollisionEventListener> listeners = new ArrayList<>();

    private final int snakeSize = ScreenInfo.getInstance().getBlockSize();

    // Method to add a collision event listener
    public void addListener(ICollisionEventListener listener) {
        listeners.add(listener);
    }

    // Method to remove a collision event listener
    public void removeListener(ICollisionEventListener listener) {
        listeners.remove(listener);
    }

    // Check collision with wall
    public void checkCollisionWithWall(Point head, Point moveRange) {
        int gridSize = snakeSize;
        int headRight = head.x * gridSize + snakeSize;
        int headBottom = head.y * gridSize + snakeSize;

        if (head.x < 0 || headRight > moveRange.x * gridSize ||
                head.y < 0 || headBottom > moveRange.y * gridSize) {
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
        int gridSize = snakeSize;
        Point head = segmentLocations.get(0);

        // Calculate the bounds of the snake's head
        int headLeft = head.x * gridSize;
        int headTop = head.y * gridSize;
        int headRight = headLeft + snakeSize; // Assuming the snake is one grid size
        int headBottom = headTop + snakeSize;

        // Calculate the bounds of the food
        int foodLeft = foodLocation.x * gridSize;
        int foodTop = foodLocation.y * gridSize;
        int foodRight = foodLeft + gridSize; // Assuming the food is one grid size
        int foodBottom = foodTop + gridSize;

        // Check if the rectangles overlap
        if (headLeft < foodRight && headRight > foodLeft &&
                headTop < foodBottom && headBottom > foodTop) {
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
