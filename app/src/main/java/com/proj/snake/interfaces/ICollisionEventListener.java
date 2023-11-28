package com.proj.snake.interfaces;

public interface ICollisionEventListener {
    void onCollisionWithWall();
    void onCollisionWithSelf();
    void onCollisionWithFood();
    void onCollisionWithPowerUp();

}
