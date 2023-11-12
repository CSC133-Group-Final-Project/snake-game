package com.proj.snake.events;

import com.proj.snake.interfaces.IGameEventListener;

import java.util.ArrayList;
import java.util.List;

// The GameEventPublisher class is responsible for handling game events within the game.
public class GameEventPublisher {

    // A list of listeners that are interested in receiving game event notifications.
    private final List<IGameEventListener> listeners = new ArrayList<>();

    // Method to add a game event listener to the list.
    public void addListener(IGameEventListener listener) {
        listeners.add(listener);
    }

    // Notify all registered listeners about a game over event.
    public void notifyGameOver() {
        for (IGameEventListener listener : listeners) {
            listener.onGameOver();
        }
    }

    // Notify all registered listeners about a resume event.
    public void notifyResume() {
        for (IGameEventListener listener : listeners) {
            listener.resume();
        }
    }

    // Notify all registered listeners about a pause event.
    public void notifyPause() {
        for (IGameEventListener listener : listeners) {
            listener.pause();
        }
    }

    // Notify all registered listeners about an unpause event.
    public void notifyUnpause() {
        for (IGameEventListener listener : listeners) {
            listener.unpause();
        }
    }

    // Dirty hack to get the paused state of the game.
    // Notify the first listener about the paused state and return the result.
    // Note: This method will return the state from the first listener only, which may not be correct if there are multiple listeners.
    public boolean notifyIsPaused() {
        for (IGameEventListener listener : listeners) {
            return listener.isPaused();
        }
        return false;
    }
}
