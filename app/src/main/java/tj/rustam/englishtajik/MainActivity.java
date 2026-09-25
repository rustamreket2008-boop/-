package com.example.dictionary;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView text = new TextView(this);

        text.setText("САЛОМ 👋\n\nБарнома кор кард!");
        text.setTextSize(28);
        text.setTextColor(Color.BLACK);
        text.setGravity(Gravity.CENTER);

        setContentView(text);
    }
}
