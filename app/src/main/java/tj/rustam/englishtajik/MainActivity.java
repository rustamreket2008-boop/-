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
    HashMap<String, String> dictionary = new HashMap<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        createDictionary();

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(25, 30, 25, 25);

        TextView title = new TextView(this);
        title.setText("📚 English — Тоҷикӣ");
        title.setTextSize(26);
        title.setGravity(Gravity.CENTER);
        title.setPadding(0, 10, 0, 25);

        search = new EditText(this);
        search.setHint("Калимаи англисиро навис...");
        search.setTextSize(18);

        Button button = new Button(this);
        button.setText("ҶУСТУҶӮ");

        result = new TextView(this);
        result.setTextSize(20);
        result.setTextColor(Color.BLACK);
        result.setPadding(10, 25, 10, 10);

        layout.addView(title);
        layout.addView(search);
        layout.addView(button);
        layout.addView(result);

        setContentView(layout);

        button.setOnClickListener(v -> findWord());
    }

    void findWord() {
        String word = search.getText().toString().trim().toLowerCase();

        if (dictionary.containsKey(word)) {
            result.setText(
                "English: " + word +
                "\nТоҷикӣ: " + dictionary.get(word)
            );
        } else {
            result.setText("❌ Ин калима ёфт нашуд.");
        }
    }

    void createDictionary() {

        dictionary.put("hello", "салом");
        dictionary.put("goodbye", "хайр");
        dictionary.put("yes", "ҳа");
        dictionary.put("no", "не");
        dictionary.put("please", "лутфан");
        dictionary.put("thanks", "ташаккур");
        dictionary.put("sorry", "бахшиш");
        dictionary.put("welcome", "хуш омадед");
        dictionary.put("friend", "дӯст");
        dictionary.put("family", "оила");

        dictionary.put("mother", "модар");
        dictionary.put("father", "падар");
        dictionary.put("brother", "бародар");
        dictionary.put("sister", "хоҳар");
        dictionary.put("son", "писар");
        dictionary.put("daughter", "духтар");
        dictionary.put("child", "кӯдак");
        dictionary.put("man", "мард");
        dictionary.put("woman", "зан");
        dictionary.put("boy", "писар");

        dictionary.put("girl", "духтар");
        dictionary.put("teacher", "муаллим");
        dictionary.put("student", "хонанда");
        dictionary.put("school", "мактаб");
        dictionary.put("class", "синф");
        dictionary.put("book", "китоб");
        dictionary.put("pen", "қалам");
        dictionary.put("pencil", "қаламча");
        dictionary.put("table", "миз");
        dictionary.put("chair", "курсӣ");

        dictionary.put("house", "хона");
        dictionary.put("room", "ҳуҷра");
        dictionary.put("door", "дар");
        dictionary.put("window", "тиреза");
        dictionary.put("bed", "кат");
        dictionary.put("kitchen", "ошхона");
        dictionary.put("garden", "боғ");
        dictionary.put("city", "шаҳр");
        dictionary.put("village", "деҳа");
        dictionary.put("country", "кишвар");

        dictionary.put("water", "об");
        dictionary.put("food", "хӯрок");
        dictionary.put("bread", "нон");
        dictionary.put("milk", "шир");
        dictionary.put("tea", "чой");
        dictionary.put("apple", "себ");
        dictionary.put("orange", "афлесун");
        dictionary.put("banana", "банан");
        dictionary.put("meat", "гӯшт");
        dictionary.put("rice", "биринҷ");

        dictionary.put("sun", "офтоб");
        dictionary.put("moon", "моҳ");
        dictionary.put("star", "ситора");
        dictionary.put("sky", "осмон");
        dictionary.put("cloud", "абр");
        dictionary.put("rain", "борон");
        dictionary.put("snow", "барф");
        dictionary.put("wind", "шамол");
        dictionary.put("fire", "оташ");
        dictionary.put("earth", "замин");

        dictionary.put("car", "мошин");
        dictionary.put("bus", "автобус");
        dictionary.put("train", "қатора");
        dictionary.put("airplane", "ҳавопаймо");
        dictionary.put("road", "роҳ");
        dictionary.put("street", "кӯча");
        dictionary.put("bicycle", "велосипед");
        dictionary.put("phone", "телефон");
        dictionary.put("computer", "компютер");
        dictionary.put("internet", "интернет");

        dictionary.put("big", "калон");
        dictionary.put("small", "хурд");
        dictionary.put("good", "хуб");
        dictionary.put("bad", "бад");
        dictionary.put("new", "нав");
        dictionary.put("old", "кӯҳна");
        dictionary.put("hot", "гарм");
        dictionary.put("cold", "сард");
        dictionary.put("fast", "тез");
        dictionary.put("slow", "оҳиста");

        dictionary.put("beautiful", "зебо");
        dictionary.put("happy", "хушбахт");
        dictionary.put("sad", "ғамгин");
        dictionary.put("easy", "осон");
        dictionary.put("difficult", "душвор");
        dictionary.put("strong", "қавӣ");
        dictionary.put("weak", "заиф");
        dictionary.put("young", "ҷавон");
        dictionary.put("rich", "бой");
        dictionary.put("poor", "камбағал");

        dictionary.put("eat", "хӯрдан");
        dictionary.put("drink", "нӯшидан");
        dictionary.put("go", "рафтан");
        dictionary.put("come", "омадан");
        dictionary.put("see", "дидан");
        dictionary.put("hear", "шунидан");
        dictionary.put("speak", "гап задан");
        dictionary.put("read", "хондан");
        dictionary.put("write", "навиштан");
        dictionary.put("learn", "омӯхтан");
    }
                            }
