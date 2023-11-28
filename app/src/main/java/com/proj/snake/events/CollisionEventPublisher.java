package com.proj.snake.events;

import android.graphics.Point;

import com.proj.snake.interfaces.ICollisionEventListener;
import java.util.ArrayList;
import java.util.List;

public class CollisionEventPublisher {

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
    public void checkCollisionWithWall(Point head, Point moveRange) {
        if (head.x == -1 || head.x > moveRange.x || head.y == -1 || head.y > moveRange.y) {
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

    // Check collision with food
    public void checkCollisionWithFood(List<Point> segmentLocations, Point foodLocation) {
        if (segmentLocations.get(0).x == foodLocation.x && segmentLocations.get(0).y == foodLocation.y) {
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
