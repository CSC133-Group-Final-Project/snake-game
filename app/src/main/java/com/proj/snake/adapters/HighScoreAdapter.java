package com.proj.snake.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.proj.snake.R;
import com.proj.snake.models.HighScore;

import java.util.List;

public class HighScoreAdapter extends ArrayAdapter<HighScore> {
    private final int resourceLayout;
    private final Context mContext;

    public HighScoreAdapter(Context context, int resource, List<HighScore> items) {
        super(context, resource, items);
        this.resourceLayout = resource;
        this.mContext = context;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(mContext);
            v = vi.inflate(resourceLayout, null);
        }

        HighScore p = getItem(position);

        if (p != null) {
            TextView tt1 = v.findViewById(R.id.highScorePlayerName);
            TextView tt2 = v.findViewById(R.id.highScoreValue);

            if (tt1 != null) {
                tt1.setText(p.getPlayerName());
            }

            if (tt2 != null) {
                tt2.setText(String.valueOf(p.getScore()));
            }
        }

        return v;
    }
}
