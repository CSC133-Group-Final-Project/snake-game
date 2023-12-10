package com.proj.snake.views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.proj.snake.R;

public class GameMenuActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_layout);

        // Initialize buttons
        Button playButton = findViewById(R.id.playButton);
        Button highScoreButton = findViewById(R.id.highScoreButton);
        Button soundButton = findViewById(R.id.soundButton);
        Button aboutButton = findViewById(R.id.aboutButton);
        Button exitButton = findViewById(R.id.exitButton);

        // Play button logic
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Launch SnakeActivity when Play button is clicked
                Intent intent = new Intent(GameMenuActivity.this, SnakeActivity.class);
                startActivity(intent);
            }
        });

        // Exit button logic
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Close the app
                finish();
            }
        });
    }
}
