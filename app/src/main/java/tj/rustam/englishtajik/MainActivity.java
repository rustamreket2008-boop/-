package com.example.dictionary;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.*;
import java.util.*;

public class MainActivity extends Activity {

    EditText search;
    TextView result;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(25, 30, 25, 25);

        TextView title = new TextView(this);
        title.setText("📚 ENGLISH — ТОҶИКӢ\n1000 КАЛИМА");
        title.setTextSize(25);
        title.setGravity(Gravity.CENTER);
        title.setPadding(0, 10, 0, 25);

        search = new EditText(this);
        search.setHint("Калимаи англисиро навис...");
        search.setTextSize(18);

        Button button = new Button(this);
        button.setText("ҶУСТУҶӮ");

        result = new TextView(this);
        result.setTextSize(21);
        result.setTextColor(Color.BLACK);
        result.setPadding(10, 25, 10, 10);

        layout.addView(title);
        layout.addView(search);
        layout.addView(button);
        layout.addView(result);

        setContentView(layout);

        button.setOnClickListener(v -> {
            String word = search.getText().toString()
                    .trim()
                    .toLowerCase(Locale.ROOT);

            String translation = DictionaryData.get(word);

            if (translation != null) {
                result.setText(
                        "English: " + word +
                        "\nТоҷикӣ: " + translation
                );
            } else {
                result.setText("❌ Калима ёфт нашуд.");
            }
        });
    }
                                  }
