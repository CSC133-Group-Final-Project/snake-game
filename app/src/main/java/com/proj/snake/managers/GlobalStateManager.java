package com.proj.snake.managers;

public class GlobalStateManager {
    private static GlobalStateManager instance;
    private String username;
    private boolean soundEnabled = true; // Default to true


    private GlobalStateManager() {}

    public static synchronized GlobalStateManager getInstance() {
        if (instance == null) {
            instance = new GlobalStateManager();
        }
        return instance;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isSoundEnabled() {
        return soundEnabled;
    }

    public void setSoundEnabled(boolean enabled) {
        this.soundEnabled = enabled;
    }
}
