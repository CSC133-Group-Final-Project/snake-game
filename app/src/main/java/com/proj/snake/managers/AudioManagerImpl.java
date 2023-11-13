package com.proj.snake.managers;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.util.Log;

import com.proj.snake.interfaces.IAudioManager;
import com.proj.snake.utils.GameConstants;

import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AudioManagerImpl implements IAudioManager {
    // Tag for logging
    private static final String TAG = "AudioManagerImpl";

    // Singleton instance of the class
    private static AudioManagerImpl instance = null;

    // Variables for SoundPool and sound IDs
    private SoundPool mSP;
    private int mEat_ID = -1;
    private int mCrashID = -1;

    private final Context myContext;
    private final Executor executor = Executors.newSingleThreadExecutor();

    // Private constructor
    private AudioManagerImpl(Context context) {
        myContext = context.getApplicationContext();
        createSoundPool();
        initSounds();
    }

    // Method to get singleton instance
    public static synchronized AudioManagerImpl getInstance(Context context) {
        if (instance == null) {
            instance = new AudioManagerImpl(context);
        } else {
            instance.reinitialize();
        }
        return instance;
    }

    // Method to create SoundPool
    private void createSoundPool() {
        AudioAttributes audioAttributes = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_MEDIA)
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .build();

        mSP = new SoundPool.Builder()
                .setMaxStreams(5)
                .setAudioAttributes(audioAttributes)
                .build();
    }

    // Method to initialize sounds
    public void initSounds() {
        if (mSP == null) {
            createSoundPool();
        }

        // Load the sounds in a separate thread
        executor.execute(() -> {
            AssetManager assetManager = myContext.getAssets();
            try {
                loadSound(assetManager, "get_apple.ogg");
                loadSound(assetManager, "snake_death.ogg");
            } catch (IOException e) {
                Log.e(TAG, "Failed to load sound files", e);
            }
        });
    }

    // Method to load a sound file
    private void loadSound(AssetManager assetManager, String fileName) throws IOException {
        try (AssetFileDescriptor descriptor = assetManager.openFd(fileName)) {
            if (mSP == null) {
                Log.e(TAG, "SoundPool instance is null");
                return;
            }
            switch (fileName) {
                case "get_apple.ogg":
                    mEat_ID = mSP.load(descriptor, 0);
                    break;
                case "snake_death.ogg":
                    mCrashID = mSP.load(descriptor, 0);
                    break;
            }
            Log.d(TAG, "Loaded sound: " + fileName);
        }
    }

    // Method to play a sound
    public void play(int soundID) {
        if (mSP == null) {
            Log.e(TAG, "SoundPool instance is null");
            return;
        }

        int soundToPlay = -1;
        switch (soundID) {
            case GameConstants.DEATH_SOUND:
                soundToPlay = mCrashID;
                break;
            case GameConstants.EAT_SOUND:
                soundToPlay = mEat_ID;
                break;
        }

        if (soundToPlay != -1) {
            mSP.play(soundToPlay, 1, 1, 0, 0, 1);
        } else {
            Log.e(TAG, "Requested sound ID not loaded: " + soundID);
        }
    }

    // Method to reinitialize the sounds
    public void reinitialize() {
        if (isMspReleased()) {
            initSounds();
        }
    }

    // Method to check if SoundPool is released
    public boolean isMspReleased() {
        return mSP == null;
    }
}